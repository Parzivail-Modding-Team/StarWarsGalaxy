package com.parzivail.swg.render.entity;

import com.parzivail.swg.Resources;
import com.parzivail.swg.entity.EntityShipParentTest;
import com.parzivail.swg.proxy.Client;
import com.parzivail.util.binary.Swg3.SwgModel;
import com.parzivail.util.binary.Swg3.SwgPart;
import com.parzivail.util.ui.FxMC;
import com.parzivail.util.ui.gltk.AttribMask;
import com.parzivail.util.ui.gltk.EnableCap;
import com.parzivail.util.ui.gltk.GL;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by colby on 12/26/2017.
 */
public class RenderShipParentTest extends Render
{
	private static final SwgModel model;

	static
	{
		ResourceLocation r = new ResourceLocation(Resources.MODID, "models/test.swg3");
		model = SwgModel.Load(r);
	}

	public RenderShipParentTest()
	{
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float unknown, float partialTicks)
	{
		if (!(entity instanceof EntityShipParentTest))
			return;

		int frame = 0;

		GL11.glPushMatrix();
		GL.PushAttrib(AttribMask.EnableBit);
		GL11.glShadeModel(GL11.GL_SMOOTH);

		EntityShipParentTest ship = (EntityShipParentTest)entity;

		if (ship.riddenByEntity == Client.getPlayer() || (ship.seats[0] != null && ship.seats[0].riddenByEntity == Client.getPlayer()))
			GL.Translate(0, -1.75f, 0);
		else
			GL.Translate(x, y, z);
		GL.Enable(EnableCap.Texture2D);
		//GL.Disable(EnableCap.CullFace);

		FxMC.enableSunBasedLighting(ship, partialTicks);

		GL.Translate(0, ship.data.verticalCenteringOffset, 0);
		float dYaw = MathHelper.wrapAngleTo180_float(ship.orientation.getYaw() - ship.previousOrientation.getYaw());
		float dPitch = MathHelper.wrapAngleTo180_float(ship.orientation.getPitch() - ship.previousOrientation.getPitch());
		float dRoll = MathHelper.wrapAngleTo180_float(ship.orientation.getRoll() - ship.previousOrientation.getRoll());
		GL11.glRotatef((ship.previousOrientation.getYaw() + dYaw * partialTicks), 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-(ship.previousOrientation.getPitch() + dPitch * partialTicks), 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-(ship.previousOrientation.getRoll() + dRoll * partialTicks), 0.0F, 0.0F, 1.0F);
		GL.Translate(0, -ship.data.verticalCenteringOffset, 0);

		GL.Translate(0, ship.data.verticalGroundingOffset, 0);

		GL.Rotate(-90, 1, 0, 0);
		GL.Rotate(-90, 0, 0, 1);

		for (SwgPart p : model.parts)
		{
			GL.PushMatrix();
			//if (p.name.equals("x_wing01") || p.name.equals("x_wing04"))
			//{
			//	GL.Translate(0, 0, ship.verticalCenteringOffset - ship.verticalGroundingOffset);
			//	GL.Rotate(-Math.abs(13 * Fx.Util.Hz(0.5f)), 1, 0, 0);
			//	GL.Translate(0, 0, -ship.verticalCenteringOffset + ship.verticalGroundingOffset);
			//}
			//if (p.name.equals("x_wing02") || p.name.equals("x_wing03"))
			//{
			//	GL.Translate(0, 0, ship.verticalCenteringOffset - ship.verticalGroundingOffset);
			//	GL.Rotate(Math.abs(13 * Fx.Util.Hz(0.5f)), 1, 0, 0);
			//	GL.Translate(0, 0, -ship.verticalCenteringOffset + ship.verticalGroundingOffset);
			//}
			bindTexture(p.textures[frame].texture);
			GL.Scale(0.0004f);
			GL.CallList(model.partRenderLists.get(p.name)[frame]);
			GL.PopMatrix();
		}

		//		Fx.D3.DrawSolidBox();
		//
		//		GL.Disable(EnableCap.Lighting);
		//		GL.PushMatrix();
		//		GL.Scale(0.25f);
		//		GL11.glLineWidth(2);
		//		GL.Color(1f, 0, 0);
		//		GL.Begin(PrimitiveType.LineStrip);
		//		GL.Vertex3(0.0D, 0.0D, 0.0D);
		//		GL.Vertex3((double)10, 0.0D, 0.0D);
		//		GL.End();
		//
		//		GL.Color(0, 1f, 0);
		//		GL.Begin(PrimitiveType.LineStrip);
		//		GL.Vertex3(0.0D, 0.0D, 0.0D);
		//		GL.Vertex3(0.0D, (double)10, 0.0D);
		//		GL.End();
		//
		//		GL.Color(0, 0, 1f);
		//		GL.Begin(PrimitiveType.LineStrip);
		//		GL.Vertex3(0.0D, 0.0D, 0.0D);
		//		GL.Vertex3(0.0D, 0.0D, (double)10);
		//		GL.End();
		//		GL.PopMatrix();

		GL.PopAttrib();
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return null;
	}
}

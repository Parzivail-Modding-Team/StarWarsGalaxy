package com.parzivail.swg.gui.modern;

import com.parzivail.swg.proxy.Client;
import com.parzivail.util.ui.Fx;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.gltk.AttribMask;
import com.parzivail.util.ui.gltk.EnableCap;
import com.parzivail.util.ui.gltk.GL;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.TextureImpl;

import java.util.EnumSet;

public class ModernButton extends GuiButton
{
	private static final int[] stateColor = { GLPalette.GREY, GLPalette.WHITE, GLPalette.SW_YELLOW };

	public ModernButton(int id, int x, int y, int w, int h, String text)
	{
		super(id, x, y, w, h, text);
	}

	/**
	 * Draws this button to the screen.
	 */
	public void drawButton(Minecraft mc, int mouseX, int mouseY)
	{
		if (this.visible)
		{
			this.mouseDragged(mc, mouseX, mouseY);

			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			int k = this.getHoverState(this.hovered); // 0->disabled, 1->normal, 2->hover

			ScaledResolution sr = Client.resolution;
			float oneOverSr = 1f / sr.getScaleFactor();

			//			int textColor = GLPalette.WHITE;
			//			if (!this.enabled)
			//				textColor = GLPalette.MEDIUM_GREY;
			//			else if (this.hovered)
			//				textColor = GLPalette.BUTTER_YELLOW;

			boolean inverted = false;

			GL.PushAttrib(EnumSet.of(AttribMask.EnableBit, AttribMask.LineBit));
			GL.Enable(EnableCap.Blend);
			GL.Disable(EnableCap.Texture2D);
			GL.Enable(EnableCap.LineSmooth);
			GL.Color(stateColor[k]);
			GL11.glLineWidth(2);
			if (inverted)
				Fx.D2.DrawSolidRoundRectangle(this.xPosition, this.yPosition, this.width, this.height, 7 * oneOverSr);
			else
				Fx.D2.DrawWireRoundRectangle(this.xPosition, this.yPosition, this.width, this.height, 7 * oneOverSr);
			//GLPalette.glColorI(stateColor[k], 192);
			//			Fx.D2.DrawWireRectangle(this.xPosition, this.yPosition, this.width, this.height);
			GL.Enable(EnableCap.Texture2D);

			GL.PushMatrix();
			TrueTypeFont fontrenderer = Client.brandonReg;
			GL.Translate(this.xPosition + this.width / 2 - fontrenderer.getWidth(this.displayString) / 2 * oneOverSr, this.yPosition + this.height / 2 - fontrenderer.getHeight() / 2 * oneOverSr, 0);
			GL.Scale(oneOverSr);
			TextureImpl.bindNone();
			fontrenderer.drawString(0, 0, this.displayString, inverted ? Fx.Util.GetColor(0x0D0D0D) : Color.white);
			GL.PopMatrix();
			GL.PopAttrib();
		}
	}
}
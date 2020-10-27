package com.parzivail.pswg.client.model.npc;

import com.parzivail.pswg.Resources;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public class ModelTogrutaM<T extends LivingEntity> extends PlayerEntityModel<T>
{
	private static final Identifier texture = Resources.identifier("textures/species/togruta_m.png");

	public ModelPart chest;
	public ModelPart tailBaseR;
	public ModelPart tailBaseL;
	public ModelPart tailBaseB;
	public ModelPart headTailR;
	public ModelPart tailUpperR;
	public ModelPart tailLowerR;
	public ModelPart headTailChildR;
	public ModelPart headTailL;
	public ModelPart tailUpperL;
	public ModelPart tailLowerL;
	public ModelPart headTailChildL;
	public ModelPart headTailB;
	public ModelPart tailLowerB;

	public ModelTogrutaM(float scale)
	{
		super(scale, false);

		textureWidth = 64;
		textureHeight = 60;
		headTailB = new ModelPart(this, 22, 50);
		headTailB.mirror = true;
		headTailB.setPivot(1.0F, 1.6F, 2.6F);
		headTailB.addCuboid(0.0F, 0.0F, -0.9F, 4, 7, 3, 0.0F);
		headTailChildR = new ModelPart(this, 40, 40);
		headTailChildR.mirror = true;
		headTailChildR.setPivot(0.0F, 3.5F, 0.0F);
		headTailChildR.addCuboid(0.0F, 0.0F, 0.0F, 3, 6, 1, 0.0F);
		rightArm = new ModelPart(this, 40, 16);
		rightArm.setPivot(-5.0F, 2.0F, 0.0F);
		rightArm.addCuboid(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
		setRotateAngle(rightArm, 0.0F, 0.0F, 0.10000736613927509F);
		rightLeg = new ModelPart(this, 0, 16);
		rightLeg.setPivot(-1.9F, 12.0F, 0.1F);
		rightLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		tailUpperR = new ModelPart(this, 50, 39);
		tailUpperR.mirror = true;
		tailUpperR.setPivot(0.9F, -5.6F, 0.1F);
		tailUpperR.addCuboid(0.0F, 0.0F, 0.0F, 2, 6, 3, 0.0F);
		setRotateAngle(tailUpperR, 0.13962634015954636F, 0.0F, 0.13962634015954636F);
		tailBaseR = new ModelPart(this, 0, 36);
		tailBaseR.mirror = true;
		tailBaseR.setPivot(-5.4F, -7.9F, 0.2F);
		tailBaseR.addCuboid(0.0F, -1.3F, -0.8F, 4, 6, 6, 0.0F);
		setRotateAngle(tailBaseR, -0.45378560551852565F, 0.13962634015954636F, 0.0F);
		chest = new ModelPart(this, 50, 10);
		chest.setPivot(-3.0F, 2.0F, -2.9F);
		chest.addCuboid(0.0F, 0.0F, 0.0F, 6, 3, 1, 0.0F);
		tailUpperL = new ModelPart(this, 50, 39);
		tailUpperL.mirror = true;
		tailUpperL.setPivot(0.9F, -5.3F, -0.1F);
		tailUpperL.addCuboid(0.0F, 0.0F, 0.0F, 2, 6, 3, 0.0F);
		setRotateAngle(tailUpperL, 0.13962634015954636F, 0.0F, -0.13962634015954636F);
		headTailChildL = new ModelPart(this, 40, 40);
		headTailChildL.mirror = true;
		headTailChildL.setPivot(0.0F, 3.5F, 0.0F);
		headTailChildL.addCuboid(0.0F, 0.0F, 0.0F, 3, 6, 1, 0.0F);
		tailBaseB = new ModelPart(this, 0, 50);
		tailBaseB.setPivot(-3.0F, -6.8F, 0.4F);
		tailBaseB.addCuboid(0.0F, 0.0F, 0.0F, 6, 5, 5, 0.0F);
		tailLowerL = new ModelPart(this, 32, 40);
		tailLowerL.mirror = true;
		tailLowerL.setPivot(1.5F, 11.5F, 2.7F);
		tailLowerL.addCuboid(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
		setRotateAngle(tailLowerL, 0.45378560551852565F, 0.0F, 0.0F);
		head = new ModelPart(this, 0, 0);
		head.setPivot(0.0F, 0.0F, 0.0F);
		head.addCuboid(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		tailLowerR = new ModelPart(this, 32, 40);
		tailLowerR.mirror = true;
		tailLowerR.setPivot(1.5F, 11.5F, 2.7F);
		tailLowerR.addCuboid(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
		setRotateAngle(tailLowerR, 0.45378560551852565F, 0.0F, 0.0F);
		leftArm = new ModelPart(this, 40, 16);
		leftArm.mirror = true;
		leftArm.setPivot(5.0F, 2.0F, -0.0F);
		leftArm.addCuboid(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
		setRotateAngle(leftArm, 0.0F, 0.0F, -0.10000736613927509F);
		tailBaseL = new ModelPart(this, 0, 36);
		tailBaseL.setPivot(1.4F, -7.9F, -0.2F);
		tailBaseL.addCuboid(0.0F, -1.3F, -0.8F, 4, 6, 6, 0.0F);
		setRotateAngle(tailBaseL, -0.45378560551852565F, -0.13962634015954636F, 0.0F);
		torso = new ModelPart(this, 16, 16);
		torso.setPivot(0.0F, 0.0F, 0.0F);
		torso.addCuboid(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
		leftLeg = new ModelPart(this, 0, 16);
		leftLeg.mirror = true;
		leftLeg.setPivot(1.9F, 12.0F, 0.1F);
		leftLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		headTailL = new ModelPart(this, 20, 35);
		headTailL.mirror = true;
		headTailL.setPivot(0.6F, -0.2F, 0.9F);
		headTailL.addCuboid(0.0F, 1.9F, 1.1F, 3, 10, 3, 0.0F);
		setRotateAngle(headTailL, -0.08726646259971647F, 0.0F, 0.0F);
		headTailR = new ModelPart(this, 20, 35);
		headTailR.mirror = true;
		headTailR.setPivot(0.4F, -0.2F, 0.9F);
		headTailR.addCuboid(0.0F, 1.9F, 1.1F, 3, 10, 3, 0.0F);
		setRotateAngle(headTailR, -0.06981317007977318F, 0.0F, 0.0F);
		tailLowerB = new ModelPart(this, 36, 52);
		tailLowerB.mirror = true;
		tailLowerB.setPivot(0.5F, 4.7F, -0.4F);
		tailLowerB.addCuboid(0.0F, 0.0F, 0.0F, 3, 6, 2, 0.0F);
		tailBaseB.addChild(headTailB);
		headTailR.addChild(headTailChildR);
		tailBaseR.addChild(tailUpperR);
		head.addChild(tailBaseR);
		tailBaseL.addChild(tailUpperL);
		headTailL.addChild(headTailChildL);
		head.addChild(tailBaseB);
		headTailL.addChild(tailLowerL);
		headTailR.addChild(tailLowerR);
		head.addChild(tailBaseL);
		tailBaseL.addChild(headTailL);
		tailBaseR.addChild(headTailR);
		headTailB.addChild(tailLowerB);
	}

	public void setRotateAngle(ModelPart part, float x, float y, float z)
	{
		part.pitch = x;
		part.yaw = y;
		part.roll = z;
	}
}

package io.github.fallout015.two.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.fallout015.two.entity.passive.PenguinEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

@OnlyIn(Dist.CLIENT)
public class PenguinModel<T extends PenguinEntity> extends AgeableModel<T> {
	public final ModelRenderer body;
	private final ModelRenderer leftFoot;
	private final ModelRenderer rightFoot;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer head;
	private final ModelRenderer beakUpper;
	private final ModelRenderer beakLower;
	
	public PenguinModel() {
		textureWidth = 32;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-3.0F, -13.0F, -3.0F, 6.0F, 12.0F, 4.0F, 0.0F, false);

		leftFoot = new ModelRenderer(this);
		leftFoot.setRotationPoint(2.0F, -1.0F, 0.0F);
		body.addChild(leftFoot);
		leftFoot.setTextureOffset(0, 16).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		rightFoot = new ModelRenderer(this);
		rightFoot.setRotationPoint(-2.0F, -1.0F, 0.0F);
		body.addChild(rightFoot);
		rightFoot.setTextureOffset(12, 16).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(4.5F, -11.5F, -0.5F);
		body.addChild(leftArm);
		setRotationAngle(leftArm, 0.0F, 0.0F, -0.1309F);
		leftArm.setTextureOffset(24, 0).addBox(-1.4914F, -0.6305F, -1.5F, 1.0F, 9.0F, 3.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-4.5F, -11.5F, -0.5F);
		body.addChild(rightArm);
		setRotationAngle(rightArm, 0.0F, 0.0F, 0.1309F);
		rightArm.setTextureOffset(24, 12).addBox(0.4914F, -0.6305F, -1.5F, 1.0F, 9.0F, 3.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -13.5F, -0.25F);
		body.addChild(head);
		head.setTextureOffset(0, 21).addBox(-2.0F, -3.5F, -1.75F, 4.0F, 4.0F, 3.0F, 0.0F, false);

		beakUpper = new ModelRenderer(this);
		beakUpper.setRotationPoint(0.0F, -1.5F, -1.75F);
		head.addChild(beakUpper);
		beakUpper.setTextureOffset(0, 28).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 0.5F, 2.0F, 0.0F, false);

		beakLower = new ModelRenderer(this);
		beakLower.setRotationPoint(0.0F, -1.5F, -1.75F);
		head.addChild(beakLower);
		beakLower.setTextureOffset(0, 28).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 0.5F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		if(this.isChild) {
			matrixStack.push();
			matrixStack.scale(0.5f, 0.5f, 0.5f);
			matrixStack.translate(0, 1.5f, 0);
		}
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		if(this.isChild) {
			matrixStack.pop();
		}
	}
	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if(entityIn.hasFish()) {
			this.beakUpper.rotateAngleX = -0.5f;
			this.beakLower.rotateAngleX = 0.5f;
			this.head.rotateAngleX = -0.5f;
		} else {
			this.beakUpper.rotateAngleX = 0;
			this.beakLower.rotateAngleX = 0;
			this.head.rotateAngleX = 0;			
		}
		
		this.body.rotateAngleZ = MathHelper.clamp(MathHelper.cos(limbSwing * 2.6648f) * 0.4f * limbSwingAmount, -0.1816687434911728f, 0.1816687434911728f); // w a d d l e
		this.leftArm.rotateAngleZ = MathHelper.clamp(-2f * limbSwingAmount - 0.1309F, -0.7432956695556641f, -0.1309F);
		this.rightArm.rotateAngleZ = MathHelper.clamp(2f * limbSwingAmount + 0.1309F, 0.1309F, 0.7432956695556641f);
		this.leftFoot.rotateAngleX = MathHelper.cos(limbSwing * 2.8662F) * 0.8f * limbSwingAmount;
		this.rightFoot.rotateAngleX = MathHelper.cos(limbSwing * 2.8662F) * -0.8f * limbSwingAmount;
	}
	@Override
	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.head, this.beakLower, this.beakUpper);
	}
	@Override
	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body, this.rightArm, this.leftArm, this.rightFoot, this.leftFoot);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
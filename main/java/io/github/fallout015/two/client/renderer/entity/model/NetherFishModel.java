package io.github.fallout015.two.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.fallout015.two.entity.monster.NetherFishEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

@OnlyIn(Dist.CLIENT)
public class NetherFishModel<T extends NetherFishEntity> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer rightFin;
	private final ModelRenderer leftFin;
	private final ModelRenderer tail;
	private final ModelRenderer head;

	public NetherFishModel() {
		textureWidth = 32;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 21.6667F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-1.0F, -1.6667F, -4.0F, 2.0F, 4.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(0.0F, -3.6667F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);

		rightFin = new ModelRenderer(this);
		rightFin.setRotationPoint(-1.0F, 1.8333F, -2.2493F);
		body.addChild(rightFin);
		setRotationAngle(rightFin, 0.0F, 0.3927F, 0.0F);
		rightFin.setTextureOffset(0, 0).addBox(-2.0776F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		leftFin = new ModelRenderer(this);
		leftFin.setRotationPoint(1.0F, 1.8333F, -2.2493F);
		body.addChild(leftFin);
		setRotationAngle(leftFin, 0.0F, -0.3927F, 0.0F);
		leftFin.setTextureOffset(0, 0).addBox(-0.0776F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 22.0F, 4.0F);
		tail.setTextureOffset(0, 8).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		tail.setTextureOffset(0, 12).addBox(0.0F, -2.0F, 4.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 23.0F, -4.0F);
		head.setTextureOffset(8, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(8, 12).addBox(0.0F, 0.0F, -7.0F, 0.0F, 1.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.tail.rotateAngleY = MathHelper.cos(limbSwing * 0.75f) * limbSwingAmount;
		this.body.rotateAngleY = MathHelper.cos(limbSwing * 0.5f) * limbSwingAmount * 0.75f;
		this.leftFin.rotateAngleY = MathHelper.sin(limbSwing) * limbSwingAmount * 2f + 0.3927F;
		this.rightFin.rotateAngleY = MathHelper.cos(limbSwing) * limbSwingAmount * 2f + 0.3927F;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
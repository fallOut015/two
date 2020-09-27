package io.github.fallout015.two.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.fallout015.two.entity.effect.ButterflyEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

@OnlyIn(Dist.CLIENT)
public class ButterflyModel<T extends ButterflyEntity> extends EntityModel<T> {
	private final ModelRenderer leftWing;
	private final ModelRenderer rightWing;

	public ButterflyModel() {
		textureWidth = 16;
		textureHeight = 16;

		leftWing = new ModelRenderer(this);
		leftWing.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(leftWing, 0.0F, 0.0F, -0.3927F);
		leftWing.setTextureOffset(-6, 0).addBox(0.0F, 0.0F, -3.0F, 8.0F, 0.0F, 6.0F, 0.0F, true);

		rightWing = new ModelRenderer(this);
		rightWing.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(rightWing, 0.0F, 0.0F, 0.3927F);
		rightWing.setTextureOffset(-6, 0).addBox(-8.0F, 0.0F, -3.0F, 8.0F, 0.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		leftWing.rotateAngleZ = MathHelper.cos(limbSwing) * -2f * limbSwingAmount - 0.3927F;
		rightWing.rotateAngleZ = MathHelper.cos(limbSwing) * 2f * limbSwingAmount + 0.3927F;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		leftWing.render(matrixStack, buffer, packedLight, packedOverlay);
		rightWing.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
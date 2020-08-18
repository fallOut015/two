package io.github.fallout015.two.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.fallout015.two.entity.effect.TwisterEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 3.6.3
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class TwisterModel<T extends TwisterEntity> extends EntityModel<T> {
	private final ModelRenderer twister;
	private final ModelRenderer column1;
	private final ModelRenderer column2;
	private final ModelRenderer column3;
	private final ModelRenderer column4;
	private final ModelRenderer column5;
	private final ModelRenderer column6;

	public TwisterModel() {
		textureWidth = 64;
		textureHeight = 64;

		twister = new ModelRenderer(this);
		twister.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		column1 = new ModelRenderer(this);
		column1.setRotationPoint(6.0F, -3.0F, 0.0F);
		twister.addChild(column1);
		column1.setTextureOffset(0, 0).addBox(0.0F, -3.0F, -6.0F, 0.0F, 6.0F, 12.0F, 0.0F, false);
		column1.setTextureOffset(0, 12).addBox(-12.0F, -3.0F, 6.0F, 12.0F, 6.0F, 0.0F, 0.0F, false);
		column1.setTextureOffset(0, 12).addBox(-12.0F, -3.0F, -6.0F, 12.0F, 6.0F, 0.0F, 0.0F, false);
		column1.setTextureOffset(0, 0).addBox(-12.0F, -3.0F, -6.0F, 0.0F, 6.0F, 12.0F, 0.0F, false);

		column2 = new ModelRenderer(this);
		column2.setRotationPoint(8.0F, -9.0F, -2.0F);
		twister.addChild(column2);
		column2.setTextureOffset(0, 2).addBox(0.0F, -3.0F, -6.0F, 0.0F, 6.0F, 16.0F, 0.0F, false);
		column2.setTextureOffset(0, 18).addBox(-16.0F, -3.0F, 10.0F, 16.0F, 6.0F, 0.0F, 0.0F, false);
		column2.setTextureOffset(0, 18).addBox(-16.0F, -3.0F, -6.0F, 16.0F, 6.0F, 0.0F, 0.0F, false);
		column2.setTextureOffset(0, 2).addBox(-16.0F, -3.0F, -6.0F, 0.0F, 6.0F, 16.0F, 0.0F, false);

		column3 = new ModelRenderer(this);
		column3.setRotationPoint(10.0F, -15.0F, -4.0F);
		twister.addChild(column3);
		column3.setTextureOffset(0, 4).addBox(0.0F, -3.0F, -6.0F, 0.0F, 6.0F, 20.0F, 0.0F, false);
		column3.setTextureOffset(0, 24).addBox(-20.0F, -3.0F, 14.0F, 20.0F, 6.0F, 0.0F, 0.0F, false);
		column3.setTextureOffset(0, 24).addBox(-20.0F, -3.0F, -6.0F, 20.0F, 6.0F, 0.0F, 0.0F, false);
		column3.setTextureOffset(0, 4).addBox(-20.0F, -3.0F, -6.0F, 0.0F, 6.0F, 20.0F, 0.0F, false);

		column4 = new ModelRenderer(this);
		column4.setRotationPoint(13.0F, -21.0F, -6.0F);
		twister.addChild(column4);
		column4.setTextureOffset(0, 6).addBox(0.0F, -3.0F, -6.0F, 0.0F, 6.0F, 24.0F, 0.0F, false);
		column4.setTextureOffset(0, 30).addBox(-25.0F, -3.0F, 18.0F, 25.0F, 6.0F, 0.0F, 0.0F, false);
		column4.setTextureOffset(0, 30).addBox(-25.0F, -3.0F, -6.0F, 25.0F, 6.0F, 0.0F, 0.0F, false);
		column4.setTextureOffset(0, 6).addBox(-25.0F, -3.0F, -6.0F, 0.0F, 6.0F, 24.0F, 0.0F, false);

		column5 = new ModelRenderer(this);
		column5.setRotationPoint(15.0F, -27.0F, -8.0F);
		twister.addChild(column5);
		column5.setTextureOffset(0, 8).addBox(0.0F, -3.0F, -6.0F, 0.0F, 6.0F, 28.0F, 0.0F, false);
		column5.setTextureOffset(0, 36).addBox(-29.0F, -3.0F, 22.0F, 29.0F, 6.0F, 0.0F, 0.0F, false);
		column5.setTextureOffset(0, 36).addBox(-29.0F, -3.0F, -6.0F, 29.0F, 6.0F, 0.0F, 0.0F, false);
		column5.setTextureOffset(0, 8).addBox(-29.0F, -3.0F, -6.0F, 0.0F, 6.0F, 28.0F, 0.0F, false);

		column6 = new ModelRenderer(this);
		column6.setRotationPoint(17.0F, -33.0F, -10.0F);
		twister.addChild(column6);
		column6.setTextureOffset(0, 10).addBox(0.0F, -3.0F, -6.0F, 0.0F, 6.0F, 32.0F, 0.0F, false);
		column6.setTextureOffset(0, 42).addBox(-33.0F, -3.0F, 26.0F, 33.0F, 6.0F, 0.0F, 0.0F, false);
		column6.setTextureOffset(0, 42).addBox(-33.0F, -3.0F, -6.0F, 33.0F, 6.0F, 0.0F, 0.0F, false);
		column6.setTextureOffset(0, 10).addBox(-33.0F, -3.0F, -6.0F, 0.0F, 6.0F, 32.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		this.twister.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float alpha){
		this.render(matrixStack, buffer, packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.twister.rotateAngleY = ageInTicks / 10;
	}
}
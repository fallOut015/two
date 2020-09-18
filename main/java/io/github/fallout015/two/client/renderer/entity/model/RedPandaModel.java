package io.github.fallout015.two.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.fallout015.two.entity.passive.RedPandaEntity;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Made with Blockbench 3.6.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

@OnlyIn(Dist.CLIENT)
public class RedPandaModel<T extends RedPandaEntity> extends QuadrupedModel<T> {
	private final ModelRenderer tail;

	public RedPandaModel() {
		super(9, 0, true, 23.0F, 4.8F, 2.7F, 3.0F, 49);
		
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.5F, 22.0F, 15.0F);
		body.setTextureOffset(0, 39).addBox(-4.0F, -9.0F, -7.0F, 7.0F, 5.0F, 10.0F, 0.0F, false);
		body.setTextureOffset(0, 39).addBox(-4.0F, -9.0F, -17.0F, 7.0F, 5.0F, 10.0F, 0.0F, false);

		headModel = new ModelRenderer(this);
		headModel.setRotationPoint(0.0F, 1.0F, -8.0F);
		body.addChild(headModel);
		headModel.setTextureOffset(0, 5).addBox(-5.0F, -11.0F, -14.0F, 9.0F, 5.0F, 7.0F, 0.0F, false);
		headModel.setTextureOffset(0, 17).addBox(-6.0F, -10.0F, -13.0F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		headModel.setTextureOffset(0, 17).addBox(4.0F, -10.0F, -13.0F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		headModel.setTextureOffset(12, 17).addBox(-6.0F, -14.0F, -13.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		headModel.setTextureOffset(22, 17).addBox(2.0F, -14.0F, -13.0F, 3.0F, 3.0F, 2.0F, 0.0F, true);
		headModel.setTextureOffset(0, 2).addBox(-3.0F, -8.0F, -15.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		headModel.setTextureOffset(2, 0).addBox(-2.0F, -9.0F, -15.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		headModel.setTextureOffset(0, 31).addBox(-4.0F, -12.0F, -14.0F, 7.0F, 1.0F, 7.0F, 0.0F, false);
		headModel.setTextureOffset(0, 25).addBox(-3.0F, -13.0F, -13.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 1.0F, 9.0F);
		body.addChild(tail);
		tail.setTextureOffset(32, 0).addBox(-3.0F, -9.225F, -7.0F, 5.0F, 4.0F, 8.0F, 0.0F, false);
		tail.setTextureOffset(32, 12).addBox(-3.0F, -8.0F, 1.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);
		tail.setTextureOffset(32, 19).addBox(-2.0F, -7.0F, 6.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		legBackRight = new ModelRenderer(this);
		legBackRight.setRotationPoint(0.5F, 2.0F, -6.0F);
		body.addChild(legBackRight);
		legBackRight.setTextureOffset(32, 23).addBox(-0.5F, -6.0F, -8.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		legBackRight.setTextureOffset(44, 30).addBox(-0.5F, -1.0F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		legBackLeft = new ModelRenderer(this);
		legBackLeft.setRotationPoint(-0.5F, 2.0F, -6.0F);
		body.addChild(legBackLeft);
		legBackLeft.setTextureOffset(32, 23).addBox(-3.5F, -6.0F, -8.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		legBackLeft.setTextureOffset(44, 30).addBox(-3.5F, -1.0F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		legFrontRight = new ModelRenderer(this);
		legFrontRight.setRotationPoint(0.5F, 2.0F, -15.0F);
		body.addChild(legFrontRight);
		legFrontRight.setTextureOffset(32, 23).addBox(-0.5F, -6.0F, 15.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		legFrontRight.setTextureOffset(44, 30).addBox(-0.5F, -1.0F, 14.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		legFrontLeft = new ModelRenderer(this);
		legFrontLeft.setRotationPoint(-0.5F, 2.0F, -15.0F);
		body.addChild(legFrontLeft);
		legFrontLeft.setTextureOffset(32, 23).addBox(-3.5F, -6.0F, 15.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		legFrontLeft.setTextureOffset(44, 30).addBox(-3.5F, -1.0F, 14.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
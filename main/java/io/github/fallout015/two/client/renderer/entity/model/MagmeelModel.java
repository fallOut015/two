package io.github.fallout015.two.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MagmeelModel<T extends Entity> extends EntityModel<T> {
	MagmeelHeadModel headModel;
	MagmeelSegmentModel[] segmentModels;
	MagmeelTailModel tailModel;
	
	public MagmeelModel(int length) {
		this.headModel = new MagmeelHeadModel(this);
		for(int i = 0; i < length; ++ i) {
			this.segmentModels[i] = new MagmeelSegmentModel(this, i);
		}
		this.tailModel = new MagmeelTailModel(this, length * 16);
	}
	
	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headModel.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		for(MagmeelSegmentModel segmentModel : segmentModels) {
			segmentModel.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
		tailModel.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}
	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//		headModel.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
//		for(MagmeelSegmentModel segmentModel : segmentModels) {
//			segmentModel.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
//		}
//		tailModel.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@OnlyIn(Dist.CLIENT)
	public class MagmeelHeadModel extends Model {
		private final ModelRenderer head;
		private final ModelRenderer lowerJaw;
		private final ModelRenderer upperJaw;

		public MagmeelHeadModel(Model base) {
			super(RenderType::getEntityCutout);
			
			textureWidth = 48;
			textureHeight = 96;

			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 21.0F, 0.0F);
			head.setTextureOffset(24, 0).addBox(-3.0F, -3.0F, 2.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(0.0F, -6.0F, 3.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);

			upperJaw = new ModelRenderer(this);
			upperJaw.setRotationPoint(0.0F, 1.0F, 2.0F);
			head.addChild(upperJaw);
			setRotationAngle(upperJaw, -0.48F, 0.0F, 0.0F);
			upperJaw.setTextureOffset(0, 13).addBox(-2.5F, -2.0F, -4.0F, 5.0F, 2.0F, 4.0F, 0.0F, false);

			lowerJaw = new ModelRenderer(this);
			lowerJaw.setRotationPoint(0.0F, 0.0F, 2.0F);
			head.addChild(lowerJaw);
			setRotationAngle(lowerJaw, 0.48F, 0.0F, 0.0F);
			lowerJaw.setTextureOffset(0, 7).addBox(-2.5F, 0.0F, -4.0F, 5.0F, 2.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
		}
		
		public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// TODO Auto-generated method stub
		}
	}
	@OnlyIn(Dist.CLIENT)
	public class MagmeelSegmentModel extends Model {
		private final ModelRenderer segment;

		public MagmeelSegmentModel(Model base, int distance) {
			super(RenderType::getEntityCutout);
			
			textureWidth = 48;
			textureHeight = 96;

			segment = new ModelRenderer(base);
			segment.setRotationPoint(0.0F, 24.0F, 8.0F);
			segment.setTextureOffset(0, 32).addBox(-2.0F, -4.0F, -16.0F - (16f * distance), 4.0F, 4.0F, 16.0F, 0.0F, false);
			segment.setTextureOffset(0, 32).addBox(0.0F, -8.0F, -6.0F - (16f * distance), 0.0F, 8.0F, 6.0F, 0.0F, false);
			segment.setTextureOffset(0, 32).addBox(0.0F, -8.0F, -14.0F - (16f * distance), 0.0F, 8.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
			segment.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// TODO Auto-generated method stub
		}
	}
	@OnlyIn(Dist.CLIENT)
	public class MagmeelTailModel extends Model {
		private final ModelRenderer tail;

		public MagmeelTailModel(Model base, int distance) {
			super(RenderType::getEntityCutout);
			
			textureWidth = 48;
			textureHeight = 96;

			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, 24.0F, -8.0F);
			tail.setTextureOffset(0, 64).addBox(-1.0F, -1.0F, 0.0F - (16f * distance), 2.0F, 1.0F, 8.0F, 0.0F, false);
			tail.setTextureOffset(0, 62).addBox(0.0F, -4.0F, 2.0F - (16f * distance), 0.0F, 4.0F, 4.0F, 0.0F, false);
		}
		
		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
			tail.render(matrixStack, buffer, packedLight, packedOverlay);
		}
		
		public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			this.tail.rotateAngleY = MathHelper.sin(limbSwing) * limbSwingAmount;
		}
	}
}
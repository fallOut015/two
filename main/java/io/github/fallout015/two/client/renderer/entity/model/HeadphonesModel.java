package io.github.fallout015.two.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

@OnlyIn(Dist.CLIENT)
public class HeadphonesModel extends Model {
	public final ModelRenderer headphones;

	public HeadphonesModel(Model base) {
	    super(RenderType::getEntityCutoutNoCull);
		
		textureWidth = 16;
		textureHeight = 16;

		headphones = new ModelRenderer(base);
		headphones.setRotationPoint(0.0F, 0.0F, 0.0F);
		headphones.setTextureOffset(0, 0).addBox(-5.0F, -6.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		headphones.setTextureOffset(0, 0).addBox(4.0F, -6.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, true);
		headphones.setTextureOffset(0, 8).addBox(-4.5F, -9.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		headphones.setTextureOffset(6, 8).addBox(3.5F, -9.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		headphones.setTextureOffset(0, 13).addBox(-3.5F, -9.0F, -1.0F, 7.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		headphones.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}
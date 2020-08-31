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
public class CrownModel extends Model {
	public final ModelRenderer crown;

	public CrownModel(Model base) {
		super(RenderType::getEntityCutoutNoCull);
		
		textureWidth = 16;
		textureHeight = 16;

		int texmod = 3;
		
		crown = new ModelRenderer(base);
		crown.setRotationPoint(0.0F, 24.0F, 0.0F);
		crown.setTextureOffset(0, 6 + texmod).addBox(-3.0F, -11.0F, -3.0F, 6.0F, 3.0F, 0.0F, 0.0F, false);
		crown.setTextureOffset(0, 6 + texmod).addBox(-3.0F, -11.0F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, false);
		crown.setTextureOffset(0, 0 + texmod).addBox(3.0F, -11.0F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, false);
		crown.setTextureOffset(0, 0 + texmod).addBox(-3.0F, -11.0F, -3.0F, 0.0F, 3.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		crown.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}
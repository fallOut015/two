package io.github.fallout015.two.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import io.github.fallout015.two.client.renderer.entity.model.ButterflyModel;
import io.github.fallout015.two.entity.effect.ButterflyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ButterflyRenderer extends MobRenderer<ButterflyEntity, ButterflyModel<ButterflyEntity>> {
	public static final ResourceLocation[] TEXTURE = {
		new ResourceLocation("two", "textures/entity/butterfly/butterfly_black_yellow.png"),
		new ResourceLocation("two", "textures/entity/butterfly/butterfly_blue_black.png"),
		new ResourceLocation("two", "textures/entity/butterfly/butterfly_red_white.png"),
		new ResourceLocation("two", "textures/entity/butterfly/butterfly_white_black.png")
	};
	public ButterflyRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ButterflyModel<>(), 0);
	}
	
	@Override
	protected void preRenderCallback(ButterflyEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
		matrixStackIn.scale(0.5f, 0.5f, 0.5f);
		super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
	}
	@Override
	public ResourceLocation getEntityTexture(ButterflyEntity entity) {
		return TEXTURE[entity.getVariant()];
	}
}
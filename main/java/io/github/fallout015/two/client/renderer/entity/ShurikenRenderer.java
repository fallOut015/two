package io.github.fallout015.two.client.renderer.entity;

import io.github.fallout015.two.entity.projectile.ShurikenEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class ShurikenRenderer extends EntityRenderer<ShurikenEntity> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/item/shuriken.png");
	
	public ShurikenRenderer(EntityRendererManager renderManager) {
		super(renderManager);
	}

	@Override
	public ResourceLocation getEntityTexture(ShurikenEntity entity) {
		return TEXTURE;
	}
}
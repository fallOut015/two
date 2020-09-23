package io.github.fallout015.two.client.renderer.entity;

import io.github.fallout015.two.client.renderer.entity.model.PenguinModel;
import io.github.fallout015.two.entity.passive.PenguinEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel<PenguinEntity>> {
	public static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/penguin.png");
	
	public PenguinRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PenguinModel<>(), 0.35f);
	}

	@Override
	public ResourceLocation getEntityTexture(PenguinEntity entity) {
		return TEXTURE;
	}
}
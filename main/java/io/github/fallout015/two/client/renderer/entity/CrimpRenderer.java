package io.github.fallout015.two.client.renderer.entity;

import io.github.fallout015.two.client.renderer.entity.model.CrimpModel;
import io.github.fallout015.two.entity.passive.CrimpEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CrimpRenderer extends MobRenderer<CrimpEntity, CrimpModel<CrimpEntity>> {
	public static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/crimp.png");
	
	public CrimpRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CrimpModel<>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(CrimpEntity entity) {
		return TEXTURE;
	}
}
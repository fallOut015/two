package io.github.fallout015.two.client.renderer.entity;

import io.github.fallout015.two.entity.effect.SwarmEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SwarmRenderer extends EntityRenderer<SwarmEntity> {
	public static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/sigil/sigil-4.png");
	
	public SwarmRenderer(EntityRendererManager rendererManager) {
		super(rendererManager);
	}

	@Override
	public ResourceLocation getEntityTexture(SwarmEntity entity) {
		return TEXTURE;
	}
}
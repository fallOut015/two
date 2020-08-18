package io.github.fallout015.two.client.renderer.entity;

import io.github.fallout015.two.client.renderer.entity.model.RedPandaModel;
import io.github.fallout015.two.entity.passive.RedPandaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedPandaRenderer extends MobRenderer<RedPandaEntity, RedPandaModel<RedPandaEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/red_panda.png");

	public RedPandaRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RedPandaModel<>(), 0.5f);
	}
	
	@Override
	public ResourceLocation getEntityTexture(RedPandaEntity entity) {
		return TEXTURE;
	}
}
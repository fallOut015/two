package io.github.fallout015.two.client.renderer.entity;

import io.github.fallout015.two.client.renderer.entity.model.JellyfishModel;
import io.github.fallout015.two.entity.passive.JellyfishEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class JellyfishRenderer extends MobRenderer<JellyfishEntity, JellyfishModel<JellyfishEntity>> {
	public static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/jellyfish.png");
	
	public JellyfishRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new JellyfishModel<>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(JellyfishEntity entity) {
		return TEXTURE;
	}
}
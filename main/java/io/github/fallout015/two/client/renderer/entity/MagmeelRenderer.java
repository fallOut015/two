package io.github.fallout015.two.client.renderer.entity;

import io.github.fallout015.two.client.renderer.entity.model.MagmeelModel;
import io.github.fallout015.two.entity.boss.magmeel.MagmeelEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MagmeelRenderer extends MobRenderer<MagmeelEntity, MagmeelModel<MagmeelEntity>> {
	public static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/magmeel.png");

	public MagmeelRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new MagmeelModel<>(5), 0);
	}

	@Override
	public ResourceLocation getEntityTexture(MagmeelEntity entity) {
		return TEXTURE;
	}
}
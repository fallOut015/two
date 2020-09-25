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
	public MagmeelRenderer(EntityRendererManager entityRendererManager) {
		super(entityRendererManager, new MagmeelModel<>(), 0);
	}

	@Override
	public ResourceLocation getEntityTexture(MagmeelEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
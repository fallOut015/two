package io.github.fallout015.two.client.renderer.entity;

import io.github.fallout015.two.client.renderer.entity.layers.PenguinFishInBeakLayer;
import io.github.fallout015.two.client.renderer.entity.model.PenguinModel;
import io.github.fallout015.two.entity.passive.PenguinEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel<PenguinEntity>> {
	public static final ResourceLocation[] TEXTURE = {
		new ResourceLocation("two", "textures/entity/penguin/penguin_black.png"),
		new ResourceLocation("two", "textures/entity/penguin/penguin_white.png"),
		new ResourceLocation("two", "textures/entity/penguin/penguin_striped.png"),
		new ResourceLocation("two", "textures/entity/penguin/penguin_macaroni.png"),
		new ResourceLocation("two", "textures/entity/penguin/penguin_emperor.png"),
		new ResourceLocation("two", "textures/entity/penguin/penguin_silver.png")
	};
	
	public PenguinRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PenguinModel<>(), 0.35f);
		this.addLayer(new PenguinFishInBeakLayer(this));
	}

	@Override
	public ResourceLocation getEntityTexture(PenguinEntity entity) {
		return TEXTURE[entity.getVariant()];
	}
}
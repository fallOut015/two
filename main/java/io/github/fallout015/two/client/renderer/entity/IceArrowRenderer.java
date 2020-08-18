package io.github.fallout015.two.client.renderer.entity;

import io.github.fallout015.two.entity.projectile.IceArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IceArrowRenderer extends ArrowRenderer<IceArrowEntity> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/projectiles/ice_arrow.png");
	
	public IceArrowRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getEntityTexture(IceArrowEntity entity) {
		return TEXTURE;
	}
}
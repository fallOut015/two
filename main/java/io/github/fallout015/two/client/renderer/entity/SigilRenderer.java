package io.github.fallout015.two.client.renderer.entity;

import io.github.fallout015.two.entity.effect.SigilEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SigilRenderer extends EntityRenderer<SigilEntity> {
	public static final ResourceLocation[] TEXTURE = {
		new ResourceLocation("two", "textures/entity/sigil/sigil-1.png"),
		new ResourceLocation("two", "textures/entity/sigil/sigil-2.png"),
		new ResourceLocation("two", "textures/entity/sigil/sigil-1.png"),
		new ResourceLocation("two", "textures/entity/sigil/sigil-4.png")
	};
	
	public SigilRenderer(EntityRendererManager rendererManager) {
		super(rendererManager);
	}

	@Override
	public ResourceLocation getEntityTexture(SigilEntity entity) {
		return TEXTURE[(entity.ticksExisted % 16) / 4];
	}
}
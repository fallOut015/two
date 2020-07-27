package two.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import two.entity.projectile.ShurikenEntity;

public class ShurikenRenderer extends EntityRenderer<ShurikenEntity> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/item/shuriken.png");
	
	public ShurikenRenderer(EntityRendererManager renderManager) {
		super(renderManager);
	}

	@Override
	public ResourceLocation getEntityTexture(ShurikenEntity entity) {
		return TEXTURE;
	}
}
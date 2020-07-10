package two.client.renderer.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.entity.projectile.BombArrowEntity;

@OnlyIn(Dist.CLIENT)
public class BombArrowRenderer extends ArrowRenderer<BombArrowEntity> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/projectiles/bomb_arrow.png");
	
	public BombArrowRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getEntityTexture(BombArrowEntity entity) {
		return TEXTURE;
	}
}
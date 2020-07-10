package two.client.renderer.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.entity.projectile.FireArrowEntity;

@OnlyIn(Dist.CLIENT)
public class FireArrowRenderer extends ArrowRenderer<FireArrowEntity> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/projectiles/fire_arrow.png");
	
	public FireArrowRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getEntityTexture(FireArrowEntity entity) {
		return TEXTURE;
	}
}
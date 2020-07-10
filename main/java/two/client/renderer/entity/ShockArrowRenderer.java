package two.client.renderer.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.entity.projectile.ShockArrowEntity;

@OnlyIn(Dist.CLIENT)
public class ShockArrowRenderer extends ArrowRenderer<ShockArrowEntity> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/projectiles/shock_arrow.png");
	
	public ShockArrowRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getEntityTexture(ShockArrowEntity entity) {
		return TEXTURE;
	}
}
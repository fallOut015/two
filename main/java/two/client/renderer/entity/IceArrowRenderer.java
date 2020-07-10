package two.client.renderer.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.entity.projectile.IceArrowEntity;

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
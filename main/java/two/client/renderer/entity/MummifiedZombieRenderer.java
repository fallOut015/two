package two.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.client.renderer.entity.layers.MummifiedZombieOverlayLayer;

@OnlyIn(Dist.CLIENT)
public class MummifiedZombieRenderer extends ZombieRenderer {
	private static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/zombie/mummified_zombie.png");

	public MummifiedZombieRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
		this.addLayer(new MummifiedZombieOverlayLayer<>(this));
	}
	
	@Override
	protected void preRenderCallback(ZombieEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
		matrixStackIn.scale(1.2f, 1.2f, 1.2f);
		super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
	}
	@Override
	public ResourceLocation getEntityTexture(ZombieEntity entity) {
		return TEXTURE;
	}
}
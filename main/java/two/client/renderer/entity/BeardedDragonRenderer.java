package two.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.client.renderer.entity.model.BeardedDragonModel;
import two.entity.passive.BeardedDragonEntity;

@OnlyIn(Dist.CLIENT)
public class BeardedDragonRenderer extends MobRenderer<BeardedDragonEntity, BeardedDragonModel<BeardedDragonEntity>> {
	public static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/bearded_dragon.png");

	public BeardedDragonRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new BeardedDragonModel<>(), 0.25f);
	}

	@Override
	public ResourceLocation getEntityTexture(BeardedDragonEntity entity) {
		return TEXTURE;
	}
}
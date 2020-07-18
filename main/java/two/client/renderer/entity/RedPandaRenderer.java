package two.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.client.renderer.entity.model.RedPandaModel;
import two.entity.passive.RedPandaEntity;

@OnlyIn(Dist.CLIENT)
public class RedPandaRenderer extends MobRenderer<RedPandaEntity, RedPandaModel<RedPandaEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/red_panda.png");

	public RedPandaRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RedPandaModel<>(), 0.5f);
	}
	
	@Override
	public ResourceLocation getEntityTexture(RedPandaEntity entity) {
		return TEXTURE;
	}
}
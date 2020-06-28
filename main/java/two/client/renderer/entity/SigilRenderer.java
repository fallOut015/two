package two.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.client.renderer.entity.model.SigilModel;
import two.entity.effect.SigilEntity;

@OnlyIn(Dist.CLIENT)
public class SigilRenderer extends LivingRenderer<SigilEntity, SigilModel<SigilEntity>> {
	public static final ResourceLocation[] TEXTURE = {
		new ResourceLocation("two", "textures/entity/sigil/sigil-1.png"),
		new ResourceLocation("two", "textures/entity/sigil/sigil-2.png"),
		new ResourceLocation("two", "textures/entity/sigil/sigil-1.png"),
		new ResourceLocation("two", "textures/entity/sigil/sigil-4.png")
	};
	
	public SigilRenderer(EntityRendererManager rendererManager) {
		super(rendererManager, new SigilModel<>(), 0);
	}

	@Override
	public ResourceLocation getEntityTexture(SigilEntity entity) {
		return TEXTURE[(entity.ticksExisted % 16) / 4];
	}
	@Override
	protected boolean canRenderName(SigilEntity entity) {
		return false;
	}
}
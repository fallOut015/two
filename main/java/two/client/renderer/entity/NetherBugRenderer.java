package two.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import two.client.renderer.entity.model.NetherBugModel;
import two.entity.passive.NetherBugEntity;

public class NetherBugRenderer extends MobRenderer<NetherBugEntity, NetherBugModel<NetherBugEntity>> {
	public static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/nether_bug.png");
	
	public NetherBugRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new NetherBugModel<>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(NetherBugEntity entity) {
		return TEXTURE;
	}
}
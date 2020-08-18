package io.github.fallout015.two.client.renderer.entity;

import io.github.fallout015.two.client.renderer.entity.model.NetherBugModel;
import io.github.fallout015.two.entity.passive.NetherBugEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

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
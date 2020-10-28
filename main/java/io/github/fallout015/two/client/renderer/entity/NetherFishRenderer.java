package io.github.fallout015.two.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import io.github.fallout015.two.client.renderer.entity.model.NetherFishModel;
import io.github.fallout015.two.entity.monster.NetherFishEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NetherFishRenderer extends MobRenderer<NetherFishEntity, NetherFishModel<NetherFishEntity>> {
	public static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/nether_fish.png");
	
	public NetherFishRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new NetherFishModel<>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(NetherFishEntity entity) {
		return TEXTURE;
	}
	@Override
	protected void preRenderCallback(NetherFishEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
		super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);

		matrixStackIn.push();
		matrixStackIn.scale(1.2f, 1.2f, 1.2f);
		matrixStackIn.pop();
	}
}
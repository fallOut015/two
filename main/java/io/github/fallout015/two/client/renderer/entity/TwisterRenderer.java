package io.github.fallout015.two.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import io.github.fallout015.two.client.renderer.entity.model.TwisterModel;
import io.github.fallout015.two.entity.effect.TwisterEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TwisterRenderer extends EntityRenderer<TwisterEntity> {
	TwisterModel<TwisterEntity> model = new TwisterModel<TwisterEntity>();
	
	public static final ResourceLocation[] TEXTURE = {
		new ResourceLocation("two", "textures/entity/twister/twister-1.png"),
		new ResourceLocation("two", "textures/entity/twister/twister-2.png"),
		new ResourceLocation("two", "textures/entity/twister/twister-1.png"),
		new ResourceLocation("two", "textures/entity/twister/twister-4.png")
	};
	
	public TwisterRenderer(EntityRendererManager rendererManager) {
		super(rendererManager);
	}

	@Override
	public void render(TwisterEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		this.model.render(matrixStackIn, bufferIn.getBuffer(RenderType.getEntityTranslucent(this.getEntityTexture(entityIn))), packedLightIn, 0, 0.5f);
	}
	@Override
	public ResourceLocation getEntityTexture(TwisterEntity entity) {
		return TEXTURE[(entity.ticksExisted % 16) / 4];
	}
	@Override
	protected boolean canRenderName(TwisterEntity entity) {
		return false;
	}
}
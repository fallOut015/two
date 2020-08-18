package io.github.fallout015.two.client.renderer.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.fallout015.two.client.renderer.entity.model.TopHatModel;
import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TopHatLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
	private static final ResourceLocation TEXTURE_TOP_HAT = new ResourceLocation("minecraft", "textures/entity/top_hat.png");
	private final TopHatModel<T> modelTopHat = new TopHatModel<>();

	public TopHatLayer(IEntityRenderer<T, M> entityRendererIn) {
		super(entityRendererIn);
	}
	
	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		ItemStack itemStack = entitylivingbaseIn.getItemStackFromSlot(EquipmentSlotType.HEAD);
		if(itemStack.getItem() == ItemsTwo.TOP_HAT) {
			ResourceLocation resourceLocation = null;
			if(entitylivingbaseIn instanceof AbstractClientPlayerEntity) {
				AbstractClientPlayerEntity abstractClientPlayerEntity = (AbstractClientPlayerEntity) entitylivingbaseIn;
				if(abstractClientPlayerEntity.isPlayerInfoSet()) {
					resourceLocation = TEXTURE_TOP_HAT;
				}
			} else {
				resourceLocation = TEXTURE_TOP_HAT;
			}
			matrixStackIn.push();
			matrixStackIn.translate(0, 0, 0);
			this.getEntityModel().copyModelAttributesTo(this.modelTopHat);
			this.modelTopHat.setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			IVertexBuilder vertexBuilder = ItemRenderer.getBuffer(bufferIn, this.modelTopHat.getRenderType(resourceLocation), false, itemStack.hasEffect());
			this.modelTopHat.render(matrixStackIn, vertexBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
			matrixStackIn.pop();
		}
	}
}
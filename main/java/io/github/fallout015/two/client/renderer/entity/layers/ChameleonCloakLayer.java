package io.github.fallout015.two.client.renderer.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.fallout015.two.client.renderer.entity.model.ChameleonCloakModel;
import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChameleonCloakLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
	private static final ResourceLocation TEXTURE_CHAMELEON_CLOAK = new ResourceLocation("two", "textures/entity/chameleon_cloak.png");
	private final ChameleonCloakModel<T> modelChameleonCloak = new ChameleonCloakModel<>();

	public ChameleonCloakLayer(IEntityRenderer<T, M> entityRendererIn) {
		super(entityRendererIn);
	}

	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if(entitylivingbaseIn.isInvisible()) {
			return;
		}
		
		ItemStack itemstack = entitylivingbaseIn.getItemStackFromSlot(EquipmentSlotType.CHEST);
		if (itemstack.getItem() == ItemsTwo.CHAMELEON_CLOAK) {
			ResourceLocation resourcelocation;
			if (entitylivingbaseIn instanceof AbstractClientPlayerEntity) {
				AbstractClientPlayerEntity abstractclientplayerentity = (AbstractClientPlayerEntity)entitylivingbaseIn;
				if (abstractclientplayerentity.isPlayerInfoSet() && abstractclientplayerentity.getLocationElytra() != null) {
					resourcelocation = abstractclientplayerentity.getLocationElytra();
	            } else if (abstractclientplayerentity.hasPlayerInfo() && abstractclientplayerentity.getLocationCape() != null && abstractclientplayerentity.isWearing(PlayerModelPart.CAPE)) {
	            	resourcelocation = abstractclientplayerentity.getLocationCape();
	            } else {
	            	resourcelocation = TEXTURE_CHAMELEON_CLOAK;
	            }
			} else {
				resourcelocation = TEXTURE_CHAMELEON_CLOAK;
			}

			matrixStackIn.push();
			matrixStackIn.translate(0.0D, 0.0D, 0.125D);
			this.getEntityModel().copyModelAttributesTo(this.modelChameleonCloak);
			this.modelChameleonCloak.setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			IVertexBuilder ivertexbuilder = ItemRenderer.getBuffer(bufferIn, this.modelChameleonCloak.getRenderType(resourcelocation), false, itemstack.hasEffect());
			this.modelChameleonCloak.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
			matrixStackIn.pop();
		}
	}
}
package io.github.fallout015.two.client.renderer.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;

import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InspectionSpectaclesLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/inspection_spectacles.png");
	private final BipedModel<T> layerModel = new BipedModel<T>(0.25f);

	public InspectionSpectaclesLayer(IEntityRenderer<T, M> entityRendererIn) {
		super(entityRendererIn);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		ItemStack itemStack = entitylivingbaseIn.getItemStackFromSlot(EquipmentSlotType.HEAD);
		if(itemStack.getItem() == ItemsTwo.INSPECTION_SPECTACLES) {
			renderCopyCutoutModel(this.getEntityModel(), this.layerModel, TEXTURE, matrixStackIn, bufferIn, packedLightIn, entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTicks, 1.0F, 1.0F, 1.0F);
		}
	}
}
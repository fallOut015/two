package two.client.renderer.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

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
import two.client.renderer.entity.model.TopHatModel;
import two.item.ItemsTwo;

@OnlyIn(Dist.CLIENT)
public class TopHatLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
	private static final ResourceLocation TEXTURE_TOP_HAT = new ResourceLocation("minecraft", "textures/entity/top_hat.png");
	private final TopHatModel<T> modelTopHat = new TopHatModel<>();

	public TopHatLayer(IEntityRenderer<T, M> entityRendererIn) {
		super(entityRendererIn);
	}

	@Override
	public void func_225628_a_(MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int p_225628_3_, T t, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
		ItemStack itemStack = t.getItemStackFromSlot(EquipmentSlotType.HEAD);
		if(itemStack.getItem() == ItemsTwo.TOP_HAT) {
			ResourceLocation resourceLocation = null;
			if(t instanceof AbstractClientPlayerEntity) {
				AbstractClientPlayerEntity abstractClientPlayerEntity = (AbstractClientPlayerEntity) t;
				if(abstractClientPlayerEntity.isPlayerInfoSet()) {
					resourceLocation = TEXTURE_TOP_HAT;
				}
			} else {
				resourceLocation = TEXTURE_TOP_HAT;
			}
			matrixStack.func_227860_a_();
			matrixStack.func_227861_a_(0, 0, 0);
			this.getEntityModel().setModelAttributes(this.modelTopHat);
			this.modelTopHat.func_225597_a_(t, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_);
			IVertexBuilder vertexBuilder = ItemRenderer.func_229113_a_(renderTypeBuffer, this.modelTopHat.func_228282_a_(resourceLocation), false, itemStack.hasEffect());
			this.modelTopHat.func_225598_a_(matrixStack, vertexBuilder, p_225628_3_, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
			matrixStack.func_227865_b_();
		}
	}
}
package io.github.fallout015.two.client.renderer.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.fallout015.two.client.renderer.entity.model.TopHatModel;
import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TopHatLayer extends LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> {
	private static final ResourceLocation TEXTURE_TOP_HAT = new ResourceLocation("minecraft", "textures/entity/top_hat.png");
	private final TopHatModel modelTopHat;

	public TopHatLayer(IEntityRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> entityRendererIn) {
		super(entityRendererIn);
		
		this.modelTopHat = new TopHatModel(this.getEntityModel());
	}
	
	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, AbstractClientPlayerEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if(entitylivingbaseIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemsTwo.TOP_HAT) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(TEXTURE_TOP_HAT));
			int i = LivingRenderer.getPackedOverlay(entitylivingbaseIn, 0.0F);

			matrixStackIn.push();
			this.modelTopHat.brim.copyModelAngles(this.getEntityModel().bipedHead);
			this.modelTopHat.render(matrixStackIn, ivertexbuilder, packedLightIn, i, 0, 0, 0, 0);
			matrixStackIn.pop();
		}		
	}
}
package io.github.fallout015.two.client.renderer.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.fallout015.two.client.renderer.entity.model.CrownModel;
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
public class CrownLayer extends LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/crown.png");
	private final CrownModel crownModel;
	
	public CrownLayer(IEntityRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> entityRendererIn) {
		super(entityRendererIn);
		
		this.crownModel = new CrownModel(this.getEntityModel());
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, AbstractClientPlayerEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
	    if("Dev".equals(entitylivingbaseIn.getName().getString()) && entitylivingbaseIn.hasSkin() && !entitylivingbaseIn.isInvisible()) {
	    	if(entitylivingbaseIn.getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty()) {
	    		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(TEXTURE));
		    	int i = LivingRenderer.getPackedOverlay(entitylivingbaseIn, 0.0F);

		    	matrixStackIn.push();
		    	this.crownModel.crown.copyModelAngles(this.getEntityModel().bipedHead);
		    	this.crownModel.render(matrixStackIn, ivertexbuilder, packedLightIn, i, 0, 0, 0, 0);
		    	matrixStackIn.pop();
	    	}
	    }
	}
}
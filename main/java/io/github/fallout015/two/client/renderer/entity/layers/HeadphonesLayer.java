package io.github.fallout015.two.client.renderer.entity.layers;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.fallout015.two.client.renderer.entity.model.HeadphonesModel;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HeadphonesLayer extends LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/headphones.png");
	private final HeadphonesModel headphonesModel;
	
	public HeadphonesLayer(IEntityRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> entityRendererIn) {
		super(entityRendererIn);
		
		this.headphonesModel = new HeadphonesModel(this.getEntityModel());
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, AbstractClientPlayerEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
	    if("DerekSturm263".equals(entitylivingbaseIn.getName().getString()) && entitylivingbaseIn.hasSkin() && !entitylivingbaseIn.isInvisible()) {
	    	List<ArmorItem> armor = new ArrayList<ArmorItem>();
	    	entitylivingbaseIn.getArmorInventoryList().forEach(itemStack -> {
	    		if(itemStack.getItem() instanceof ArmorItem)
	    			armor.add((ArmorItem) itemStack.getItem());
	    	});
	    	if(armor.removeIf(item -> item.getEquipmentSlot() == EquipmentSlotType.HEAD)) {
	    		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(entitylivingbaseIn.getLocationSkin()));
		    	ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(TEXTURE));
		    	int i = LivingRenderer.getPackedOverlay(entitylivingbaseIn, 0.0F);

		    	matrixStackIn.push();
		    	this.headphonesModel.headphones.copyModelAngles(this.getEntityModel().bipedHead);
		    	this.headphonesModel.render(matrixStackIn, ivertexbuilder, packedLightIn, i, 0, 0, 0, 0);
		    	matrixStackIn.pop();
	    	}
	    }
	}
}
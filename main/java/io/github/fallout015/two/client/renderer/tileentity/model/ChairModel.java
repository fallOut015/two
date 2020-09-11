package io.github.fallout015.two.client.renderer.tileentity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChairModel extends Model {
    public ModelRenderer back;
    public ModelRenderer seat;
    public ModelRenderer legs;
	
	public ChairModel() {
		super(RenderType::getEntitySolid);
		
		this.textureWidth = 16;
		this.textureHeight = 16;
        
		this.back = new ModelRenderer(this, 0, 0);
		this.back.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.back.addBox(-8.0F, 16.0F, 6.0F, 16, 16, 2);
        
		this.seat = new ModelRenderer(this, 0, 0);
		this.seat.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.seat.addBox(-8.0F, 14.0F, -8.0F, 16, 2, 16);
        
		this.legs = new ModelRenderer(this, 0, 0);
		this.legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legs.addBox(-8.0F, 0.0F, 6.0F, 2, 14, 2);
		this.legs.addBox(6.0F, 0.0F, 6.0F, 2, 14, 2);
		this.legs.addBox(6.0F, 0.0F, -8.0F, 2, 14, 2);
		this.legs.addBox(-8.0F, 0.0F, -8.0F, 2, 14, 2);
	}

	/*
	 * Don't call this. 
	 */
	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
	}
}
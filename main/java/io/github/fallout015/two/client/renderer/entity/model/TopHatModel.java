package io.github.fallout015.two.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TopHatModel extends Model {
	public ModelRenderer brim;
    public ModelRenderer top;

    public TopHatModel(Model base) {
    	super(RenderType::getEntityCutoutNoCull);
    	
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.top = new ModelRenderer(base, 0, 13);
        this.top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.top.addBox(-4.0F, -6.0F, -4.0F, 8, 6, 8, 0.0F);
        this.brim = new ModelRenderer(base, 0, 0);
        this.brim.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.brim.addBox(-6.0F, 0, -6.0F, 12, 1, 12, 0.0F);
        this.brim.addChild(this.top);
        
        // TODO clean up in BB
    }

    @Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		this.top.render(matrixStack, buffer, packedLight, packedOverlay);
		this.brim.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}
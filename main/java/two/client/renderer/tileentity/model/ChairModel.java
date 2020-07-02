package two.client.renderer.tileentity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.Direction;

@OnlyIn(Dist.CLIENT)
public class ChairModel extends Model {
    public ModelRenderer back;
    public ModelRenderer seat;
	public ModelRenderer leg_a;
    public ModelRenderer leg_b;
    public ModelRenderer leg_c;
    public ModelRenderer leg_d;
	
	public ChairModel() {
         super(RenderType::getEntitySolid);
         
         this.back = new ModelRenderer(this, 32, 0);
         this.back.setRotationPoint(-8.0F, -8.0F, 7.0F);
         this.back.addBox(0.0F, 16.0F, 0.0F, 16, 16, 1);
         
         this.seat = new ModelRenderer(this, 0, 17);
         this.seat.setRotationPoint(-8.0F, 8.0F, -8.0F);
         this.seat.addBox(0.0F, -1.0F, 0.0F, 16, 1, 16);
         
         this.leg_a = new ModelRenderer(this, 0, 0);
         this.leg_a.setRotationPoint(6.0F, 9.0F, -8.0F);
         this.leg_a.addBox(0.0F, -17.0F, 0.0F, 2, 15, 2);
         
         this.leg_b = new ModelRenderer(this, 8, 0);
         this.leg_b.setRotationPoint(6.0F, 9.0F, 6.0F);
         this.leg_b.addBox(0.0F, -17.0F, 0.0F, 2, 15, 2);
         
         this.leg_c = new ModelRenderer(this, 16, 0);
         this.leg_c.setRotationPoint(-8.0F, 9.0F, 6.0F);
         this.leg_c.addBox(0.0F, -17.0F, 0.0F, 2, 15, 2);
         
         this.leg_d = new ModelRenderer(this, 24, 0);
         this.leg_d.setRotationPoint(-8.0F, 9.0F, -8.0F);
         this.leg_d.addBox(0.0F, -17.0F, 0.0F, 2, 15, 2);
         
         this.seat.addChild(leg_a);
         this.seat.addChild(leg_b);
         this.seat.addChild(leg_c);
         this.seat.addChild(leg_d);
         
         this.seat.addChild(back);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.back.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.seat.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.leg_a.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.leg_b.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.leg_c.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.leg_d.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
	
	public void setRotationAngles(Direction directionIn) {
		this.seat.rotateAngleY = directionIn.getHorizontalAngle();
	}
}
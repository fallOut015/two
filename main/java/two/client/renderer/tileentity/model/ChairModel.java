package two.client.renderer.tileentity.model;

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
	public ModelRenderer leg_a;
    public ModelRenderer leg_b;
    public ModelRenderer leg_c;
    public ModelRenderer leg_d;
	
	public ChairModel() {
         super(RenderType::func_228640_c_);
         
//         this.textureWidth = 77;
//         this.textureHeight = 39;
         this.back = new ModelRenderer(this, 32, 0);
         this.back.setRotationPoint(-8.0F, -8.0F, 7.0F);
         this.back.func_228300_a_(0.0F, 16.0F, 0.0F, 16, 16, 1);
         
         this.seat = new ModelRenderer(this, 0, 17);
         this.seat.setRotationPoint(-8.0F, 8.0F, -8.0F);
         this.seat.func_228300_a_(0.0F, -1.0F, 0.0F, 16, 1, 16);
         
         this.leg_a = new ModelRenderer(this, 0, 0);
         this.leg_a.setRotationPoint(6.0F, 9.0F, -8.0F);
         this.leg_a.func_228300_a_(0.0F, -17.0F, 0.0F, 2, 15, 2);
         
         this.leg_b = new ModelRenderer(this, 8, 0);
         this.leg_b.setRotationPoint(6.0F, 9.0F, 6.0F);
         this.leg_b.func_228300_a_(0.0F, -17.0F, 0.0F, 2, 15, 2);
         
         this.leg_c = new ModelRenderer(this, 16, 0);
         this.leg_c.setRotationPoint(-8.0F, 9.0F, 6.0F);
         this.leg_c.func_228300_a_(0.0F, -17.0F, 0.0F, 2, 15, 2);
         
         this.leg_d = new ModelRenderer(this, 24, 0);
         this.leg_d.setRotationPoint(-8.0F, 9.0F, -8.0F);
         this.leg_d.func_228300_a_(0.0F, -17.0F, 0.0F, 2, 15, 2);
	}

	@Override
	public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder vertexBuilder, int i3, int i4, float f5, float f6, float f7, float f8) {
        this.back.func_228309_a_(matrixStack, vertexBuilder, i3, i4, f5, f6, f7, f8);
        this.seat.func_228309_a_(matrixStack, vertexBuilder, i3, i4, f5, f6, f7, f8);
        this.leg_a.func_228309_a_(matrixStack, vertexBuilder, i3, i4, f5, f6, f7, f8);
        this.leg_b.func_228309_a_(matrixStack, vertexBuilder, i3, i4, f5, f6, f7, f8);
        this.leg_c.func_228309_a_(matrixStack, vertexBuilder, i3, i4, f5, f6, f7, f8);
        this.leg_d.func_228309_a_(matrixStack, vertexBuilder, i3, i4, f5, f6, f7, f8);
	}
}
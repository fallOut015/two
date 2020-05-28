package two.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Material;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.tileentity.ChairTileEntity;

@OnlyIn(Dist.CLIENT)
public class ChairTileEntityRenderer extends TileEntityRenderer<ChairTileEntity> {
	private final ChairTileEntityRenderer.ChairModel model = new ChairTileEntityRenderer.ChairModel();
	
	public ChairTileEntityRenderer(TileEntityRendererDispatcher p_i226006_1_) {
		super(p_i226006_1_);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void func_225616_a_(ChairTileEntity chairTileEntity, float f2, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int i5, int i6) {
//		BlockState blockstate = chairTileEntity.getBlockState();
		matrixStack.func_227860_a_();

		matrixStack.func_227861_a_(0.5D, 0.5D, 0.5D);


		String back = chairTileEntity.getTop();
		String seat = chairTileEntity.getMiddle();
		String legs = chairTileEntity.getBottom();
		
		this.model.leg_a.showModel = true;
		this.model.leg_b.showModel = true;
		this.model.leg_c.showModel = true;
		this.model.leg_d.showModel = true;
		this.model.seat.showModel = true;
		this.model.back.showModel = true;
		
		Material materialback = new Material(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("blocks/" + back));
		IVertexBuilder vertexbuilderback = materialback.func_229311_a_(renderTypeBuffer, this.model::func_228282_a_);
		this.model.seat.func_228308_a_(matrixStack, vertexbuilderback, i5, i6);

		Material materialseat = new Material(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("blocks/" + seat));
		IVertexBuilder vertexbuilderseat = materialseat.func_229311_a_(renderTypeBuffer, this.model::func_228282_a_);
		this.model.seat.func_228308_a_(matrixStack, vertexbuilderseat, i5, i6);
		
		Material materiallegs = new Material(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("blocks/" + legs));
		IVertexBuilder vertexbuilderlegs = materiallegs.func_229311_a_(renderTypeBuffer, this.model::func_228282_a_);
		this.model.leg_a.func_228308_a_(matrixStack, vertexbuilderlegs, i5, i6);
		this.model.leg_b.func_228308_a_(matrixStack, vertexbuilderlegs, i5, i6);
		this.model.leg_c.func_228308_a_(matrixStack, vertexbuilderlegs, i5, i6);
		this.model.leg_d.func_228308_a_(matrixStack, vertexbuilderlegs, i5, i6);

		matrixStack.func_227860_a_();
		matrixStack.func_227862_a_(0.6666667F, -0.6666667F, -0.6666667F);
		
		matrixStack.func_227865_b_();
		matrixStack.func_227861_a_(0.0D, (double)0.33333334F, (double)0.046666667F);
		matrixStack.func_227862_a_(0.010416667F, -0.010416667F, 0.010416667F);
		matrixStack.func_227865_b_();
	}
	
	@OnlyIn(Dist.CLIENT)
	public static final class ChairModel extends Model {
		public ModelRenderer leg_a;
	    public ModelRenderer leg_b;
	    public ModelRenderer leg_c;
	    public ModelRenderer leg_d;
	    public ModelRenderer seat;
	    public ModelRenderer back;
		
		public ChairModel() {
	         super(RenderType::func_228640_c_);
	         
//	         this.textureWidth = 77;
//	         this.textureHeight = 39;
	         this.leg_a = new ModelRenderer(this, 0, 0);
	         this.leg_a.setRotationPoint(6.0F, 9.0F, -8.0F);
	         this.leg_a.func_228300_a_(0.0F, 0.0F, 0.0F, 2, 15, 2);
	         this.leg_b = new ModelRenderer(this, 8, 0);
	         this.leg_b.setRotationPoint(6.0F, 9.0F, 6.0F);
	         this.leg_b.func_228300_a_(0.0F, 0.0F, 0.0F, 2, 15, 2);
	         this.seat = new ModelRenderer(this, 0, 17);
	         this.seat.setRotationPoint(-8.0F, 8.0F, -8.0F);
	         this.seat.func_228300_a_(0.0F, 0.0F, 0.0F, 16, 1, 16);
	         this.back = new ModelRenderer(this, 32, 0);
	         this.back.setRotationPoint(-8.0F, -8.0F, 7.0F);
	         this.back.func_228300_a_(0.0F, 0.0F, 0.0F, 16, 16, 1);
	         this.leg_c = new ModelRenderer(this, 16, 0);
	         this.leg_c.setRotationPoint(-8.0F, 9.0F, 6.0F);
	         this.leg_c.func_228300_a_(0.0F, 0.0F, 0.0F, 2, 15, 2);
	         this.leg_d = new ModelRenderer(this, 24, 0);
	         this.leg_d.setRotationPoint(-8.0F, 9.0F, -8.0F);
	         this.leg_d.func_228300_a_(0.0F, 0.0F, 0.0F, 2, 15, 2);
		}

		@Override
		public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder vertexBuilder, int i3, int i4, float f5, float f6, float f7, float f8) {
	         this.leg_a.func_228309_a_(matrixStack, vertexBuilder, i3, i4, f5, f6, f7, f8);
	         this.leg_b.func_228309_a_(matrixStack, vertexBuilder, i3, i4, f5, f6, f7, f8);
	         this.leg_c.func_228309_a_(matrixStack, vertexBuilder, i3, i4, f5, f6, f7, f8);
	         this.leg_d.func_228309_a_(matrixStack, vertexBuilder, i3, i4, f5, f6, f7, f8);
	         this.seat.func_228309_a_(matrixStack, vertexBuilder, i3, i4, f5, f6, f7, f8);
	         this.back.func_228309_a_(matrixStack, vertexBuilder, i3, i4, f5, f6, f7, f8);
		}
	}
}
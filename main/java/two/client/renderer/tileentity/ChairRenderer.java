package two.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.Material;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.client.renderer.tileentity.model.ChairModel;
import two.tileentity.ChairTileEntity;

@OnlyIn(Dist.CLIENT)
public class ChairRenderer extends TileEntityRenderer<ChairTileEntity> {
	private final ChairModel model = new ChairModel();
	
	public ChairRenderer(TileEntityRendererDispatcher tileEntityRendererDispatcher) {
		super(tileEntityRendererDispatcher);
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
		
		Material materialback = new Material(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("block/" + back));
		IVertexBuilder vertexbuilderback = materialback.func_229311_a_(renderTypeBuffer, this.model::func_228282_a_);
		this.model.back.func_228308_a_(matrixStack, vertexbuilderback, i5, i6);

		Material materialseat = new Material(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("block/" + seat));
		IVertexBuilder vertexbuilderseat = materialseat.func_229311_a_(renderTypeBuffer, this.model::func_228282_a_);
		this.model.seat.func_228308_a_(matrixStack, vertexbuilderseat, i5, i6);
		
		Material materiallegs = new Material(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("block/" + legs));
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
}
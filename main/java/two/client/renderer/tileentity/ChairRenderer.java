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
	public void render(ChairTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
//		BlockState blockstate = chairTileEntity.getBlockState();
		
		// TODO use the blockstate to get the direction property and rotate the chair model. 
		
		matrixStackIn.push();
		matrixStackIn.translate(0.5D, 0.5D, 0.5D);

		String back = tileEntityIn.getTop();
		String seat = tileEntityIn.getMiddle();
		String legs = tileEntityIn.getBottom();
		
		this.model.leg_a.showModel = true;
		this.model.leg_b.showModel = true;
		this.model.leg_c.showModel = true;
		this.model.leg_d.showModel = true;
		this.model.seat.showModel = true;
		this.model.back.showModel = true;
		
		Material materialback = new Material(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("block/" + back));
		IVertexBuilder vertexbuilderback = materialback.getBuffer(bufferIn, this.model::getRenderType);
		this.model.back.render(matrixStackIn, vertexbuilderback, combinedLightIn, combinedOverlayIn);

		Material materialseat = new Material(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("block/" + seat));
		IVertexBuilder vertexbuilderseat = materialseat.getBuffer(bufferIn, this.model::getRenderType);
		this.model.seat.render(matrixStackIn, vertexbuilderseat, combinedLightIn, combinedOverlayIn);
		
		Material materiallegs = new Material(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("block/" + legs));
		IVertexBuilder vertexbuilderlegs = materiallegs.getBuffer(bufferIn, this.model::getRenderType);
		this.model.leg_a.render(matrixStackIn, vertexbuilderlegs, combinedLightIn, combinedOverlayIn);
		this.model.leg_b.render(matrixStackIn, vertexbuilderlegs, combinedLightIn, combinedOverlayIn);
		this.model.leg_c.render(matrixStackIn, vertexbuilderlegs, combinedLightIn, combinedOverlayIn);
		this.model.leg_d.render(matrixStackIn, vertexbuilderlegs, combinedLightIn, combinedOverlayIn);

//		matrixStackIn.pop();
//		matrixStackIn.func_227862_a_(0.6666667F, -0.6666667F, -0.6666667F);
//		
//		matrixStackIn.func_227865_b_();
//		matrixStackIn.func_227861_a_(0.0D, (double)0.33333334F, (double)0.046666667F);
//		matrixStackIn.func_227862_a_(0.010416667F, -0.010416667F, 0.010416667F);
//		matrixStackIn.func_227865_b_();
	}
}
package two.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class NeondotBlock extends MushroomBlock {
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

	public NeondotBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getBlock() == BlocksTwo.SPORESTONE_SOIL;
	}
//	@Override
//	public boolean func_226940_a_(ServerWorld p_226940_1_, BlockPos p_226940_2_, BlockState p_226940_3_, Random p_226940_4_) {
//		p_226940_1_.removeBlock(p_226940_2_, false);
//		ConfiguredFeature<BigMushroomFeatureConfig, ?> configuredfeature = FeatureTwo.HUGE_NEONDOT.withConfiguration(DefaultBiomeFeaturesTwo.BIG_NEONDOT);
//
//		if (configuredfeature.place(p_226940_1_, p_226940_1_.getChunkProvider().getChunkGenerator(), p_226940_4_, p_226940_2_)) {
//			return true;
//		} else {
//			p_226940_1_.setBlockState(p_226940_2_, p_226940_3_, 3);
//			return false;
//		}
//	}
}
package two.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.server.ServerWorld;
import two.world.biome.DefaultBiomeFeaturesTwo;
import two.world.gen.feature.FeatureTwo;

public class BrimshineBlock extends MushroomBlock {
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 11.0D, 13.0D);

	public BrimshineBlock(Properties properties) {
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
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.down();
		BlockState blockstate = worldIn.getBlockState(pos.down());
		return worldIn.getLightSubtracted(pos, 0) < 8 && blockstate.canSustainPlant(worldIn, blockpos, net.minecraft.util.Direction.UP, this);
	}
	@Override
	public boolean func_226940_a_(ServerWorld p_226940_1_, BlockPos p_226940_2_, BlockState p_226940_3_, Random p_226940_4_) {
		p_226940_1_.removeBlock(p_226940_2_, false);
		ConfiguredFeature<BigMushroomFeatureConfig, ?> configuredfeature = FeatureTwo.HUGE_BRIMSHINE.withConfiguration(DefaultBiomeFeaturesTwo.BIG_BRIMSHINE);

		if (configuredfeature.place(p_226940_1_, p_226940_1_.getChunkProvider().getChunkGenerator(), p_226940_4_, p_226940_2_)) {
			return true;
		} else {
			p_226940_1_.setBlockState(p_226940_2_, p_226940_3_, 3);
			return false;
		}
	}
}
package io.github.fallout015.two.block;

import java.util.Random;

import io.github.fallout015.two.world.gen.feature.FeaturesTwo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.server.ServerWorld;

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
	public boolean func_226940_a_(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
		world.removeBlock(pos, false);
		ConfiguredFeature<?, ?> configuredfeature = FeaturesTwo.HUGE_BRIMSHINE;

		if (configuredfeature.func_242765_a(world, world.getChunkProvider().getChunkGenerator(), rand, pos)) {
			return true;
		} else {
			world.setBlockState(pos, state, 3);
			return false;
		}
	}
}
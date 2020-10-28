package io.github.fallout015.two.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBodyPlantBlock;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class CattailsBlock extends AbstractBodyPlantBlock implements ILiquidContainer {
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 16.0D, 16.0D, 16.0D);

	public CattailsBlock(AbstractBlock.Properties properties) {
		super(properties, Direction.UP, SHAPE, true);
	}
	
	@Override
	public FluidState getFluidState(BlockState state) {
		return Fluids.WATER.getStillFluidState(false);
	}

	@Override
	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return false;
	}
	@Override
	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
		return false;
	}
	@Override
	protected AbstractTopPlantBlock getTopPlantBlock() {
		return (AbstractTopPlantBlock) BlocksTwo.CATTAILS;
	}
}
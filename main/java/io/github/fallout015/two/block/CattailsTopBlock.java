package io.github.fallout015.two.block;

import java.util.Random;

import javax.annotation.Nullable;

import io.github.fallout015.two.Two;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;

public class CattailsTopBlock extends AbstractTopPlantBlock implements ILiquidContainer {
	public static final BooleanProperty IN_WATER = BooleanProperty.create("in_water");
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 16.0D, 14.0D, 16.0D);

	public CattailsTopBlock(AbstractBlock.Properties builder) {
		super(builder, Direction.UP, SHAPE, true, 0.14d);
		
		this.setDefaultState(this.stateContainer.getBaseState().with(IN_WATER, Boolean.valueOf(true)).with(AGE, Integer.valueOf(0)));
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluidstate = context.getWorld().getFluidState(context.getPos());
		
		boolean inTallWater = fluidstate.isTagged(FluidTags.WATER) && fluidstate.getLevel() == 8;
		boolean aboveWater = context.getWorld().getFluidState(context.getPos().down()).isTagged(FluidTags.WATER);
		
		if(inTallWater) {
			return super.getStateForPlacement(context).with(IN_WATER, Boolean.valueOf(true));
		} else if(aboveWater) {
			return super.getStateForPlacement(context).with(IN_WATER, Boolean.valueOf(false));
		} else {
			return null;
		}
	}
	@SuppressWarnings("deprecation")
	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(IN_WATER) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}
	@Override
	protected boolean canGrowOn(Block block) {
		return block != Blocks.MAGMA_BLOCK;
	}
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(IN_WATER);
		
		super.fillStateContainer(builder);
	}
	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		BlockPos blockpos = pos.offset(this.growthDirection);
		int i = Math.min(state.get(AGE) + 1, 25);
		int j = this.getGrowthAmount(rand);

		for(int k = 0; k < j && this.canGrowIn(worldIn.getBlockState(blockpos)); ++k) {
			boolean isair = false;
			if(worldIn.isAirBlock(blockpos)) {
				isair = true;
				if(worldIn.getFluidState(blockpos.down()).isEmpty()) {
					return;
				}
			}
			worldIn.setBlockState(blockpos, state.with(AGE, Integer.valueOf(i)).with(IN_WATER, !isair));
			blockpos = blockpos.offset(this.growthDirection);
			i = Math.min(i + 1, 25);
		}
	}


	@Override
	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return !state.get(IN_WATER) && fluidIn == Fluids.WATER;
	}
	@Override
	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
		return false;
	}
	@Override
	protected int getGrowthAmount(Random rand) {
		return 1;
	}
	@Override
	protected boolean canGrowIn(BlockState state) {
		return state.isIn(Blocks.WATER) || state.isAir();
	}
	@SuppressWarnings("deprecation")
	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return (worldIn.getBlockState(pos.down()).isIn(Blocks.WATER) && worldIn.getBlockState(pos).isAir()) || super.canGrow(worldIn, pos, state, isClient);
	}
	@Override
	protected Block getBodyPlantBlock() {
		return BlocksTwo.CATTAILS_PLANT;
	}
}
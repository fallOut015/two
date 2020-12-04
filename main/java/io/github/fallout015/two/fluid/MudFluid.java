package io.github.fallout015.two.fluid;

import io.github.fallout015.two.block.BlocksTwo;
import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;

public abstract class MudFluid extends FlowingFluid {
	public Fluid getFlowingFluid() {
		return FluidsTwo.FLOWING_MUD.get();
	}
	public Fluid getStillFluid() {
		return FluidsTwo.MUD.get();
	}
	public Item getFilledBucket() {
		return ItemsTwo.MUD_BUCKET;
	}
	
	@Override
	protected boolean canSourcesMultiply() {
		return false;
	}
	@Override
	protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
		TileEntity tileentity = state.hasTileEntity() ? worldIn.getTileEntity(pos) : null;
		Block.spawnDrops(state, worldIn, pos, tileentity);
	}
	@Override
	protected int getSlopeFindDistance(IWorldReader worldIn) {
		return 4;
	}
	@Override
	protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
		return 2;
	}
	@Override
	public boolean canDisplace(FluidState state, IBlockReader blockReader, BlockPos pos, Fluid fluid, Direction direction) {
		return direction == Direction.DOWN && !fluid.isIn(FluidTags.WATER);
	}
	@Override
	public int getTickRate(IWorldReader p_205569_1_) {
		return 10;
	}
	@Override
	protected float getExplosionResistance() {
		return 150f;
	}
	@Override
	protected BlockState getBlockState(FluidState state) {
		return BlocksTwo.MUD.getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state)));
	}
	@Override
	protected FluidAttributes createAttributes() {
		return FluidAttributes.builder(new ResourceLocation("two", "block/mud_still"), new ResourceLocation("two", "block/mud_flow")).translationKey("block.two.mud").density(1500).build(this);
	}
	@Override
	public boolean isEquivalentTo(Fluid fluidIn) {
		return fluidIn == FluidsTwo.MUD.get() || fluidIn == FluidsTwo.FLOWING_MUD.get();
	}
	
	public static class Flowing extends MudFluid {
		protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
			super.fillStateContainer(builder);
			builder.add(LEVEL_1_8);
		}
		public int getLevel(FluidState state) {
			return state.get(LEVEL_1_8);
		}
		public boolean isSource(FluidState state) {
			return false;
		}
	}

	public static class Source extends MudFluid {
		public int getLevel(FluidState state) {
			return 8;
		}
		public boolean isSource(FluidState state) {
			return true;
		}
	}
}
package io.github.fallout015.two.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class GroundLightBlock extends HorizontalFaceBlock {
	protected static final VoxelShape AABB_X_CEILING = Block.makeCuboidShape(6.0D, 14.0D, 5.0D, 10.0D, 16.0D, 11.0D);
	protected static final VoxelShape AABB_Z_CEILING = Block.makeCuboidShape(5.0D, 14.0D, 6.0D, 11.0D, 16.0D, 10.0D);
	protected static final VoxelShape AABB_X_FLOOR = Block.makeCuboidShape(6.0D, 0.0D, 5.0D, 10.0D, 2.0D, 11.0D);
	protected static final VoxelShape AABB_Z_FLOOR = Block.makeCuboidShape(5.0D, 0.0D, 6.0D, 11.0D, 2.0D, 10.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(5.0D, 6.0D, 14.0D, 11.0D, 10.0D, 16.0D);
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(5.0D, 6.0D, 0.0D, 11.0D, 10.0D, 2.0D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(14.0D, 6.0D, 5.0D, 16.0D, 10.0D, 11.0D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(0.0D, 6.0D, 5.0D, 2.0D, 10.0D, 11.0D);
	   
	protected GroundLightBlock(Properties builder) {
		super(builder);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(HORIZONTAL_FACING);
		switch((AttachFace)state.get(FACE)) {
			case FLOOR:
				if (direction.getAxis() == Direction.Axis.X) {
					return AABB_X_FLOOR;
				} else {
					return AABB_Z_FLOOR;
				}
			case WALL:
				switch(direction) {
					case EAST:
						return AABB_EAST;
					case WEST:
						return AABB_WEST;
					case SOUTH:
						return AABB_SOUTH;
					case NORTH:
					default:
						return AABB_NORTH;
				}
			case CEILING:
			default:
				if (direction.getAxis() == Direction.Axis.X) {
					return AABB_X_CEILING;
				} else {
					return AABB_Z_CEILING;
				}
		}
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HORIZONTAL_FACING, FACE);
	}
}
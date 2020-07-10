package two.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.IParticleData;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;

public abstract class DreamcatcherBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	protected static final VoxelShape DREAMCATCHER_EAST_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
	protected static final VoxelShape DREAMCATCHER_WEST_AABB = Block.makeCuboidShape(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape DREAMCATCHER_SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
	protected static final VoxelShape DREAMCATCHER_NORTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);
	private final IParticleData particle;
	
	public DreamcatcherBlock(Properties properties, IParticleData particle) {
		super(properties);
	    this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	    this.particle = particle;
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch((Direction)state.get(FACING)) {
	    	case NORTH:
	    		return DREAMCATCHER_NORTH_AABB;
	    	case SOUTH:
	    		return DREAMCATCHER_SOUTH_AABB;
	    	case WEST:
	    		return DREAMCATCHER_WEST_AABB;
	    	case EAST:
	    	default:
	    		return DREAMCATCHER_EAST_AABB;
	    }
	}
	private boolean canAttachTo(IBlockReader blockReader, BlockPos blockPos, Direction direction) {
		BlockState blockstate = blockReader.getBlockState(blockPos);
	    return !blockstate.canProvidePower() && blockstate.isSolidSide(blockReader, blockPos, direction);
	}
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		Direction direction = state.get(FACING);
	    return this.canAttachTo(worldIn, pos.offset(direction.getOpposite()), direction);
	}
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (facing.getOpposite() == stateIn.get(FACING) && !stateIn.isValidPosition(worldIn, currentPos)) {
			return Blocks.AIR.getDefaultState();
	    } else {
	        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	    }
	}
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		if (!context.replacingClickedOnBlock()) {
			BlockState blockstate = context.getWorld().getBlockState(context.getPos().offset(context.getFace().getOpposite()));
	        if (blockstate.getBlock() == this && blockstate.get(FACING) == context.getFace())
	        	return null;
	    }

	    BlockState blockstate1 = this.getDefaultState();

	    for(Direction direction : context.getNearestLookingDirections())
	    	if (direction.getAxis().isHorizontal())
	    		if((blockstate1 = blockstate1.with(FACING, direction.getOpposite())).isValidPosition(context.getWorld(), context.getPos()))
	    			return blockstate1;

	    return null;
	}
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	
	public abstract void onPlayerWakeUp(final PlayerWakeUpEvent playerWakeUpEvent);
	
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		// TODO check dimension
		
		if(worldIn.getDayTime() > 13000 && worldIn.getDayTime() < 23500) {
			double x = 0, z = 0;
			double y = MathHelper.lerp(rand.nextInt(2), (double)pos.getY(), (double)pos.getY() + 1);

			if(stateIn.get(FACING).equals(Direction.NORTH)) {
				x = MathHelper.lerp(rand.nextInt(2), (double)pos.getX(), (double)pos.getX() + 1);
				z = pos.getZ() + 0.8125;
			} else if(stateIn.get(FACING).equals(Direction.EAST)) {
				x = pos.getX() + 0.1875;
				z = MathHelper.lerp(rand.nextInt(2), (double)pos.getZ(), (double)pos.getZ() + 1);
			} else if(stateIn.get(FACING).equals(Direction.SOUTH)) {
				x = MathHelper.lerp(rand.nextInt(2), (double)pos.getX(), (double)pos.getX() + 1);
				z = pos.getZ() + 0.1875;
			} else if(stateIn.get(FACING).equals(Direction.WEST)) {
				x = pos.getX() + 0.8125;
				z = MathHelper.lerp(rand.nextInt(2), (double)pos.getZ(), (double)pos.getZ() + 1);
			}
			
			worldIn.addParticle(this.particle, x, y, z, 0.0D, 0.0D, 0.0D);
		}
	}
}
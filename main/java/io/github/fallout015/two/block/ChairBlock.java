package io.github.fallout015.two.block;

import javax.annotation.Nullable;

import io.github.fallout015.two.item.ChairItem;
import io.github.fallout015.two.tileentity.ChairTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public class ChairBlock extends Block implements ITileEntityProvider {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	private static final VoxelShape LEG_A_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 2.0D, 14.0D, 2.0D);
	private static final VoxelShape LEG_B_SHAPE = Block.makeCuboidShape(14.0D, 0.0D, 0.0D, 16.0D, 14.0D, 2.0D);
	private static final VoxelShape LEG_C_SHAPE = Block.makeCuboidShape(14.0D, 0.0D, 14.0D, 16.0D, 14.0D, 16.0D);
	private static final VoxelShape LEG_D_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 14.0D, 2.0D, 14.0D, 16.0D);
	private static final VoxelShape LEGS_SHAPE = VoxelShapes.or(LEG_A_SHAPE, LEG_B_SHAPE, LEG_C_SHAPE, LEG_D_SHAPE);
	private static final VoxelShape SEAT_SHAPE = Block.makeCuboidShape(0, 14, 0, 16, 16, 16);
	private static final VoxelShape BACK_NORTH_SHAPE = Block.makeCuboidShape(0, 16.0D, 14.0D, 16.0D, 32.0D, 16.0D);
	private static final VoxelShape BACK_EAST_SHAPE = Block.makeCuboidShape(0.0D, 16.0D, 0.0D, 2.0D, 32.0D, 16.0D);
	private static final VoxelShape BACK_SOUTH_SHAPE = Block.makeCuboidShape(0, 16.0D, 0.0D, 16.0D, 32.0D, 2.0D);
	private static final VoxelShape BACK_WEST_SHAPE = Block.makeCuboidShape(14.0D, 16.0D, 0.0D, 16.0D, 32.0D, 16.0D);
	private static final VoxelShape NORTH_AABB = VoxelShapes.or(LEGS_SHAPE, SEAT_SHAPE, BACK_NORTH_SHAPE);
	private static final VoxelShape EAST_AABB = VoxelShapes.or(LEGS_SHAPE, SEAT_SHAPE, BACK_EAST_SHAPE);
	private static final VoxelShape SOUTH_AABB = VoxelShapes.or(LEGS_SHAPE, SEAT_SHAPE, BACK_SOUTH_SHAPE);
	private static final VoxelShape WEST_AABB = VoxelShapes.or(LEGS_SHAPE, SEAT_SHAPE, BACK_WEST_SHAPE);
	
	public ChairBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch((Direction)state.get(FACING)) {
	    	case NORTH:
	    		return NORTH_AABB;
	    	case SOUTH:
	    		return SOUTH_AABB;
	    	case WEST:
	    		return WEST_AABB;
	    	case EAST:
	    	default:
	    		return EAST_AABB;
	    }
	}
	
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		if (!context.replacingClickedOnBlock()) {
			BlockState blockstate = context.getWorld().getBlockState(context.getPos().offset(context.getFace().getOpposite()));
	        if (blockstate.getBlock() == this && blockstate.get(FACING) == context.getFace())
	        	return null;
	    }
		
	    BlockState blockstate1 = ChairBlock.from(context.getItem());

	    for(Direction direction : context.getNearestLookingDirections())
	    	if (direction.getAxis().isHorizontal())
	    		if((blockstate1 = blockstate1.with(FACING, direction.getOpposite())).isValidPosition(context.getWorld(), context.getPos()))
	    			return blockstate1;
	    
	    if(context.getWorld().getTileEntity(context.getPos()) instanceof ChairTileEntity) {
//	    	context.getWorld().getTileEntity(context.getPos()).read(context.getItem().getTag());
	    	// because i removed it from ChairTileEntity TODO
	    }

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
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		ItemStack itemstack = ChairItem.from(state);
		
	    ItemEntity itementity = new ItemEntity(worldIn, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), itemstack);
	    itementity.setDefaultPickupDelay();
	    worldIn.addEntity(itementity);
		
		super.onBlockHarvested(worldIn, pos, state, player);
	}
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		// TODO chair sitting code
//		player.startRiding(worldIn.getTileEntity(pos));
		
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}
	
	public static BlockState from(ItemStack stack) {
//		String back = stack.getTag().getString("top");
//		String seat = stack.getTag().getString("middle");
//		String legs = stack.getTag().getString("bottom");
//		BlockState chair = BlocksTwo.CHAIR.getStateContainer().getBaseState();
		return null;
	}
	
	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new ChairTileEntity();
	}
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return this.createNewTileEntity(world);
	}
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
}
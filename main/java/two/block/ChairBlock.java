package two.block;

import javax.annotation.Nullable;

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
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import two.item.ChairItem;
import two.tileentity.ChairTileEntity;

@SuppressWarnings("deprecation")
public class ChairBlock extends Block implements ITileEntityProvider {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	
	public ChairBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
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
	public boolean hasTileEntity() {
		return true;
	}
	@Override
	public boolean hasTileEntity(BlockState state) {
		return this.hasTileEntity();
	}
}
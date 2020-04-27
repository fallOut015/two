package two.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import two.item.EdgeStoolItem;

public class EdgeStoolBlock extends Block {
//	public static final StringProperty SEAT = BlockStatePropertiesTwo.TOP;
//	public static final StringProperty REST = BlockStatePropertiesTwo.MIDDLE;
//	public static final StringProperty LEGS = BlockStatePropertiesTwo.BOTTOM;

	public EdgeStoolBlock(Properties properties) {
		super(properties);
//		this.setDefaultState(this.stateContainer.getBaseState().with(SEAT, "white_wool").with(REST, "oak_planks").with(LEGS, "oak_planks"));
	}
//	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
//		builder.add(SEAT, REST, LEGS);
//	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		ItemStack itemstack = EdgeStoolItem.from(state);
		
	    ItemEntity itementity = new ItemEntity(worldIn, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), itemstack);
	    itementity.setDefaultPickupDelay();
	    worldIn.addEntity(itementity);
		
		super.onBlockHarvested(worldIn, pos, state, player);
	}
	
	public static BlockState from(ItemStack stack) {
//		String seat = stack.getTag().getString("top");
//		String rest = stack.getTag().getString("middle");
//		String legs = stack.getTag().getString("bottom");
//		BlockState edge_stool = BlocksTwo.EDGE_STOOL.getStateContainer().getBaseState().with(SEAT, seat).with(REST, rest).with(LEGS, legs);
		return null;
	}
}
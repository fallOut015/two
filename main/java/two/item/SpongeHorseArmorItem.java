package two.item;

import java.util.Queue;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.material.Material;
import net.minecraft.entity.MobEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpongeHorseArmorItem extends HorseArmorItem {
	public SpongeHorseArmorItem(int p_i50042_1_, String p_i50042_2_, Properties p_i50042_3_) {
		super(p_i50042_1_, p_i50042_2_, p_i50042_3_);
	}
	
	@Override
	public void onHorseArmorTick(ItemStack stack, World world, MobEntity horse) {
		super.onHorseArmorTick(stack, world, horse);
		
		if(horse.isInWater())
			if(this.absorb(world, horse.getPosition()))
		         world.playEvent(2001, horse.getPosition(), Block.getStateId(Blocks.WATER.getDefaultState()));
	}
	
	private boolean absorb(World worldIn, BlockPos pos) {
		Queue<Tuple<BlockPos, Integer>> queue = Lists.newLinkedList();
	    queue.add(new Tuple<>(pos, 0));
	    int i = 0;

	    while(!queue.isEmpty()) {
	    	Tuple<BlockPos, Integer> tuple = queue.poll();
	        BlockPos blockpos = tuple.getA();
	        int j = tuple.getB();

	        for(Direction direction : Direction.values()) {
	        	BlockPos blockpos1 = blockpos.offset(direction);
	            BlockState blockstate = worldIn.getBlockState(blockpos1);
	            IFluidState ifluidstate = worldIn.getFluidState(blockpos1);
	            Material material = blockstate.getMaterial();
	            if (ifluidstate.isTagged(FluidTags.WATER)) {
	            	if (blockstate.getBlock() instanceof IBucketPickupHandler && ((IBucketPickupHandler)blockstate.getBlock()).pickupFluid(worldIn, blockpos1, blockstate) != Fluids.EMPTY) {
	            		++i;
	            		if (j < 5) {
	            			queue.add(new Tuple<>(blockpos1, j + 1));
	            		}
	            	} else if (blockstate.getBlock() instanceof FlowingFluidBlock) {
	            		worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 3);
	            		++i;
	            		if (j < 5) {
	            			queue.add(new Tuple<>(blockpos1, j + 1));
	            		}
	            	} else if (material == Material.OCEAN_PLANT || material == Material.SEA_GRASS) {
	            		worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 3);
	            		++i;
	            		if (j < 5) {
	            			queue.add(new Tuple<>(blockpos1, j + 1));
	            		}
	            	}
	            }
	        }

	        if (i > 64) {
	            break;
	        }
	    }

	    return i > 0;
	}
}
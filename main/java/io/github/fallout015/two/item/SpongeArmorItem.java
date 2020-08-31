package io.github.fallout015.two.item;

import java.util.Queue;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpongeArmorItem extends ArmorItem {
	public SpongeArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
	}
	
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		super.onArmorTick(stack, world, player);
		
		if(player.getRidingEntity() != null) {
			// do checks for horse armor, return void if there's already a horse wearing any armor
		}
		
		for(ItemStack itemStack : player.getArmorInventoryList()) {
			if(itemStack.equals(stack, true)) {
				break;
			} else if(itemStack.getItem() instanceof SpongeArmorItem) {
				return;
			}
		} // Only checks once even if you have more sponge armor. make a value that goes up that increases your absorbancy
		// TODO
		
		if(player.isInWater()) {
			this.tryAbsorb(world, new BlockPos(player.getPositionVec()));
		}
	}
	
	protected void tryAbsorb(World worldIn, BlockPos pos) {
		if(this.absorb(worldIn, pos)) {
			worldIn.playEvent(2001, pos, Block.getStateId(Blocks.WATER.getDefaultState()));
		}
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
	            FluidState ifluidstate = worldIn.getFluidState(blockpos1);
	            Material material = blockstate.getMaterial();
	            if (ifluidstate.isTagged(FluidTags.WATER)) {
	            	if (blockstate.getBlock() instanceof IBucketPickupHandler && ((IBucketPickupHandler)blockstate.getBlock()).pickupFluid(worldIn, blockpos1, blockstate) != Fluids.EMPTY) {
	            		++i;
	            		if (j < 3) {
	            			queue.add(new Tuple<>(blockpos1, j + 1));
	            		}
	            	} else if (blockstate.getBlock() instanceof FlowingFluidBlock) {
	            		worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 3);
	            		++i;
	            		if (j < 3) {
	            			queue.add(new Tuple<>(blockpos1, j + 1));
	            		}
	            	} else if (material == Material.OCEAN_PLANT || material == Material.SEA_GRASS) {
	            		worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 3);
	            		++i;
	            		if (j < 3) {
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
package io.github.fallout015.two.item;

import io.github.fallout015.two.block.EdgeStoolBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class EdgeStoolItem extends BlockItem {
	public EdgeStoolItem(Block blockIn, Properties builder) {
		super(blockIn, builder);
	}

	public static ItemStack from(BlockState state) {
		ItemStack stack = ItemStack.EMPTY;
		if(state.getBlock() instanceof EdgeStoolBlock) {
			CompoundNBT nbt = new CompoundNBT();
//			nbt.putString("top", state.get(EdgeStoolBlock.SEAT).toString());
//			nbt.putString("middle", state.get(EdgeStoolBlock.REST).toString());
//			nbt.putString("bottom", state.get(EdgeStoolBlock.LEGS).toString());
			stack.setTag(nbt);
		}
		return stack;
	}
}
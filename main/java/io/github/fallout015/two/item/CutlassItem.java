package io.github.fallout015.two.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CutlassItem extends SwordItem {
	public CutlassItem(Properties builder) {
		super(ItemTier.IRON, 3, -2.8f, builder);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		// add code for sword blocking
		return ActionResult.resultSuccess(playerIn.getActiveItemStack());
	};
}
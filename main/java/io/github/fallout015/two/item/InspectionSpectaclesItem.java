package io.github.fallout015.two.item;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class InspectionSpectaclesItem extends Item {
	public InspectionSpectaclesItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemStack = playerIn.getHeldItem(handIn);
		EquipmentSlotType equipmentSlotType = MobEntity.getSlotForItemStack(itemStack);
		ItemStack stack = playerIn.getItemStackFromSlot(equipmentSlotType);
		if (stack.isEmpty()) {
			playerIn.setItemStackToSlot(equipmentSlotType, itemStack.copy());
	        itemStack.setCount(0);
	        return ActionResult.resultSuccess(itemStack);
	    } else {
	    	return ActionResult.resultFail(itemStack);
	    }
	}
	@Override
	public EquipmentSlotType getEquipmentSlot(ItemStack stack) {
		return EquipmentSlotType.HEAD;
	}
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
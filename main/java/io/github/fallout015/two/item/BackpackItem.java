package io.github.fallout015.two.item;

import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BackpackItem extends Item implements IVanishable {
	public BackpackItem(Properties properties) {
		super(properties);
		
		// TODO AAAAAAAAAAAAAAAAAAaaa
		
//		this.addPropertyOverride(new ResourceLocation("count"), (itemStack, world, livingEntity) -> {
//			if(livingEntity != null && livingEntity.getActiveItemStack().getItem() instanceof BackpackItem)
//				return 1.0f;
//			return 0.0f;
//			// return 0.0 for empty
//			// return 0.2 for 1
//			// return 0.4 for 2
//			// return 0.6 for 3
//			// return 0.8 for 4 or more
//		});
	}
	
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
		return EquipmentSlotType.CHEST;
	}
}
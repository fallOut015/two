package io.github.fallout015.two.item;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ChameleonCloakItem extends Item {
	public ChameleonCloakItem(Properties properties) {
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
		return EquipmentSlotType.CHEST;
	}
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == ItemsTwo.CHAMELEON_SKIN;
	}
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		if(player.isSneaking()) {
			player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 10, 0, false, false));
		}
		
		super.onArmorTick(stack, world, player);
	}
}
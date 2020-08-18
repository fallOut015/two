package io.github.fallout015.two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.Hand;

public class FlimsinessCurseEnchantment extends Enchantment {
	public FlimsinessCurseEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.BREAKABLE, slots);
	}
	
	@Override
	public void onEntityDamaged(LivingEntity user, Entity target, int level) {
		user.getActiveItemStack().damageItem((level + 1) * 20, user, playerEntity -> playerEntity.sendBreakAnimation(user.getActiveHand() == Hand.MAIN_HAND ? EquipmentSlotType.MAINHAND : EquipmentSlotType.OFFHAND));
	}
	@Override
	public boolean isCurse() {
		return true;
	}
}
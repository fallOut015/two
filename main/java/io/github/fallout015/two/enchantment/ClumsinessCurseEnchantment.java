package io.github.fallout015.two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.Hand;

public class ClumsinessCurseEnchantment extends Enchantment {
	public ClumsinessCurseEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.ALL, slots);
	}
	
	@Override
	public void onEntityDamaged(LivingEntity user, Entity target, int level) {
		if(EnchantmentHelper.getEnchantmentLevel(EnchantmentsTwo.FLIMSINESS_CURSE, user.getActiveItemStack()) > 0) {
			user.getActiveItemStack().damageItem(level * 20, user, playerEntity -> playerEntity.sendBreakAnimation(user.getActiveHand() == Hand.MAIN_HAND ? EquipmentSlotType.MAINHAND : EquipmentSlotType.OFFHAND));
		}
	}
	@Override
	public boolean isCurse() {
		return true;
	}
}
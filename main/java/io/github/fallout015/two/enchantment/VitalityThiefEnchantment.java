package io.github.fallout015.two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;

public class VitalityThiefEnchantment extends Enchantment {
	protected VitalityThiefEnchantment(Enchantment.Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentTypeTwo.BLOOD_BLADE, slots);
	}
	
	@Override
	public int getMaxLevel() {
		return 2;
	}
}
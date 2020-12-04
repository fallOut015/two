package io.github.fallout015.two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;

public class SnappingEnchantment extends Enchantment {
	public SnappingEnchantment(Enchantment.Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentTypeTwo.EVOCATION_STAFF, slots);
	}
	
	@Override
	public int getMaxLevel() {
		return 2;
	}
}
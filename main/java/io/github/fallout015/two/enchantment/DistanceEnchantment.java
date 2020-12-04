package io.github.fallout015.two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;

public class DistanceEnchantment extends Enchantment {
	public DistanceEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentTypeTwo.BANISHER, slots);
	}
}
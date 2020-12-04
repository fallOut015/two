package io.github.fallout015.two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;

public class GentleDescentEnchantment extends Enchantment {
	public GentleDescentEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentTypeTwo.HERMES_HELMET, slots);
	}
}
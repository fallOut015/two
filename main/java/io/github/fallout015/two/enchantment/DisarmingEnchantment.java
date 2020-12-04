package io.github.fallout015.two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;

public class DisarmingEnchantment extends Enchantment {
	public DisarmingEnchantment(Enchantment.Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentTypeTwo.DAGGER, slots);
	}
}
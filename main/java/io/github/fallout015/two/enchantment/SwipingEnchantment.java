package io.github.fallout015.two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;

public class SwipingEnchantment extends Enchantment {
	protected SwipingEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentTypeTwo.SICKLE, slots);
	}
	
	@Override
	public int getMaxLevel() {
		return 2;
	}
}
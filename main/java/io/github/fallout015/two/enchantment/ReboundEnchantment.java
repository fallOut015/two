package io.github.fallout015.two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;

public class ReboundEnchantment extends Enchantment {
	public ReboundEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentsTwo.Holder.SLIME_BOOTS, slots);
	}
	
	@Override
	public int getMaxLevel() {
		return 2;
	}
}
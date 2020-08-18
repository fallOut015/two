package io.github.fallout015.two.enchantment;

import io.github.fallout015.two.Two;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;

public class GrassAbilityEnchantment extends AbilityEnchantment {
	protected GrassAbilityEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
	}

	@Override
	public void action(RightClickItem playerInteractEvent$rightClickItem) {
		Two.LOGGER.info("plant power!");
	}
}
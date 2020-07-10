package two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;

public class DisarmingEnchantment extends Enchantment {
	public DisarmingEnchantment(Enchantment.Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentsTwo.Holder.DAGGER, slots);
	}
}
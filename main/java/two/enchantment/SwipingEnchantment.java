package two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import two.item.SickleItem;

public class SwipingEnchantment extends Enchantment {
	protected SwipingEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.create("sickle", item -> item.asItem() instanceof SickleItem), slots);
	}
	
	@Override
	public int getMaxLevel() {
		return 2;
	}
}
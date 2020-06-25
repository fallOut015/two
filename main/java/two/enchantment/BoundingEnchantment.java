package two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import two.item.ItemsTwo;

public class BoundingEnchantment extends Enchantment {
	public BoundingEnchantment(Enchantment.Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.create("double_jump_boots", item -> item.asItem() == ItemsTwo.DOUBLE_JUMP_BOOTS), slots);
	}
	
	@Override
	public int getMaxLevel() {
		return 3;
	}
}
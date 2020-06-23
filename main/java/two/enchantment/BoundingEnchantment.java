package two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import two.item.ItemsTwo;

public class BoundingEnchantment extends Enchantment {
	public BoundingEnchantment(Enchantment.Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.ARMOR_FEET, slots);
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() == ItemsTwo.DOUBLE_JUMP_BOOTS;
	}
}
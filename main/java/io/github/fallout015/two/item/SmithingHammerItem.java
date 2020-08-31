package io.github.fallout015.two.item;

import net.minecraft.enchantment.IVanishable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SmithingHammerItem extends Item implements IVanishable {
	public SmithingHammerItem(Properties properties) {
		super(properties);
	}
	
	public boolean hasContainerItem() {
		return true;
	};
	public ItemStack getContainerItem(ItemStack itemStack) {
		itemStack.setDamage(itemStack.getDamage() - 2);
		return itemStack;
	};
}
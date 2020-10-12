package io.github.fallout015.two.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class BloodFlameBladeItem extends BloodBladeItem {
	public BloodFlameBladeItem(Properties builder) {
		super(builder);
	}

	@Override
	public void bonusEffect(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.setFire(5);
	}
}
package io.github.fallout015.two.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class BloodVenomBladeItem extends BloodBladeItem {
	public BloodVenomBladeItem(Properties builder) {
		super(builder);
	}

	@Override
	public void bonusEffect(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addPotionEffect(new EffectInstance(Effects.POISON, 50, 3, false, true));
	}
}
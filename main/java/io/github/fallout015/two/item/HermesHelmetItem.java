package io.github.fallout015.two.item;

import io.github.fallout015.two.enchantment.EnchantmentsTwo;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class HermesHelmetItem extends ArmorItem {
	public HermesHelmetItem(Properties builder) {
		super(ArmorMaterialTwo.HERMES_HELMET, EquipmentSlotType.HEAD, builder);
	}
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		int amplifierIn = EnchantmentHelper.getEnchantmentLevel(EnchantmentsTwo.GENTLE_DESCENT.get(), stack);
		
		if(player.getActivePotionEffect(Effects.SLOW_FALLING) == null) {
			player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 1, amplifierIn, true, false));
		} else {
			player.getActivePotionEffect(Effects.SLOW_FALLING).combine(new EffectInstance(Effects.SLOW_FALLING, 1, amplifierIn, true, false));
		}
		super.onArmorTick(stack, world, player);
	}
}
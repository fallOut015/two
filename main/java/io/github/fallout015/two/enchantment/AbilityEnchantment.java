package io.github.fallout015.two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public abstract class AbilityEnchantment extends Enchantment {
	protected AbilityEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
		super(rarityIn, typeIn, slots);
	}

	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return !(ench instanceof AbilityEnchantment);
	}
	@Override
	public ITextComponent getDisplayName(int level) {
		IFormattableTextComponent iformattabletextcomponent = new TranslationTextComponent(this.getName());
		iformattabletextcomponent.func_240699_a_(TextFormatting.GREEN);
		
//		if (level != 1 || this.getMaxLevel() != 1) {
//			iformattabletextcomponent.func_240702_b_(" ").func_230529_a_(new TranslationTextComponent("enchantment.level." + level));
//		}

		return iformattabletextcomponent;
	}
	
	abstract public void action(final PlayerInteractEvent.RightClickItem playerInteractEvent$rightClickItem);
}
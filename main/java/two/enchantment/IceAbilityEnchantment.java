package two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class IceAbilityEnchantment extends Enchantment implements IAbility {
	protected IceAbilityEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
	}
	
	public ITextComponent getDisplayName(int level) {
		ITextComponent itextcomponent = new TranslationTextComponent(this.getName());
		if (this.isAbility()) {
			itextcomponent.applyTextStyle(TextFormatting.GREEN);
		} else {
			itextcomponent.applyTextStyle(TextFormatting.GRAY);
		}

		if (level != 1 || this.getMaxLevel() != 1) {
			itextcomponent.appendText(" ").appendSibling(new TranslationTextComponent("enchantment.level." + level));
		}

		return itextcomponent;
	}
}
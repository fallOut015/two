package two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
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
		ITextComponent itextcomponent = new TranslationTextComponent(this.getName());
		itextcomponent.applyTextStyle(TextFormatting.GREEN);

		if (level != 1 || this.getMaxLevel() != 1) {
			itextcomponent.appendText(" ").appendSibling(new TranslationTextComponent("enchantment.level." + level));
		}

		return itextcomponent;
	}
	
	abstract public void action(final PlayerInteractEvent.RightClickItem playerInteractEvent$rightClickItem);
}
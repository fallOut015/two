package two.enchantment;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import two.Two;

public class WindAbilityEnchantment extends AbilityEnchantment {
	protected WindAbilityEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
	}

	@Override
	public void action(RightClickItem playerInteractEvent$rightClickItem) {
		Two.LOGGER.info("control wind!");
	}
}
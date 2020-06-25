package two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class VitalityThiefEnchantment extends Enchantment {
	protected VitalityThiefEnchantment(Enchantment.Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentsTwo.Holder.BLOOD_BLADE, slots);
	}
	
	@Override
	public int getMaxLevel() {
		return 2;
	}
	@Override
	public void onEntityDamaged(LivingEntity user, Entity target, int level) {
		user.heal(level);
	}
}
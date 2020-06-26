package two.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

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
		if(target instanceof LivingEntity) {
			user.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 20, level, false, false));
		}
	}
}
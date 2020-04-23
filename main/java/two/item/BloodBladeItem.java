package two.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public abstract class BloodBladeItem extends SwordItem {
	public BloodBladeItem(Properties builder) {
		super(ItemTierTwo.BLOOD_BLADE, 3, -2.4f, builder);
	}
	
	public abstract boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker);
}
package two.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;

public abstract class BloodBladeItem extends SwordItem {
	public BloodBladeItem(Properties builder) {
		super(ItemTierTwo.BLOOD_BLADE, 3, -2.4f, builder);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		super.onCreated(stack, worldIn, playerIn);

		CompoundNBT nbt = new CompoundNBT();
		nbt.putFloat("xp", 0.1f);
		nbt.putInt("level", 0);
		stack.setTag(nbt);
	}
	public abstract boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker);
}
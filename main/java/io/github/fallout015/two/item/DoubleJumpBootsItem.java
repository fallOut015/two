package io.github.fallout015.two.item;

import io.github.fallout015.two.enchantment.EnchantmentsTwo;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;

public class DoubleJumpBootsItem extends ArmorItem {
	private static final int EXTRA_JUMPS = 3;
	
	public DoubleJumpBootsItem(Properties builder) {
		super(ArmorMaterialTwo.DOUBLE_JUMP_BOOTS, EquipmentSlotType.FEET, builder);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		int jumps = EXTRA_JUMPS;
		jumps += EnchantmentHelper.getEnchantmentLevel(EnchantmentsTwo.BOUNDING, stack);
		
		CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("extrajumplimit", jumps);
		nbt.putInt("jumps", 0);
		playerIn.getArmorInventoryList().iterator().next().setTag(nbt);
	}
}

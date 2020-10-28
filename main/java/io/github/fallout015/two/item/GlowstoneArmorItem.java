package io.github.fallout015.two.item;

import io.github.fallout015.two.block.BlocksTwo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GlowstoneArmorItem extends ArmorItem {
	public GlowstoneArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		if(world.isAirBlock(player.getPosition())) {
			world.setBlockState(player.getPosition(), BlocksTwo.LIGHT_SOURCE.getDefaultState());
		}
	}
}
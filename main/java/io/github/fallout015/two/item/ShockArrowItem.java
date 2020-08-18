package io.github.fallout015.two.item;

import io.github.fallout015.two.entity.projectile.ShockArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ShockArrowItem extends ArrowItem {
	public ShockArrowItem(Properties builder) {
		super(builder);
	}
	
	public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		ShockArrowEntity shockarrowentity = new ShockArrowEntity(worldIn, shooter);
		return shockarrowentity;
	}
}
package io.github.fallout015.two.item;

import io.github.fallout015.two.entity.projectile.BombArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BombArrowItem extends ArrowItem {
	public BombArrowItem(Properties builder) {
		super(builder);
	}
	
	public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		BombArrowEntity bombarrowentity = new BombArrowEntity(worldIn, shooter);
		return bombarrowentity;
	}
}
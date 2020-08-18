package io.github.fallout015.two.item;

import io.github.fallout015.two.entity.projectile.IceArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IceArrowItem extends ArrowItem {
	public IceArrowItem(Properties builder) {
		super(builder);
	}
	
	public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		IceArrowEntity icearrowentity = new IceArrowEntity(worldIn, shooter);
		return icearrowentity;
	}
}
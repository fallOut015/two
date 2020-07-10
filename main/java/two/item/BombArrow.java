package two.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import two.entity.projectile.BombArrowEntity;

public class BombArrow extends ArrowItem {
	public BombArrow(Properties builder) {
		super(builder);
	}
	
	public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		BombArrowEntity bombarrowentity = new BombArrowEntity(worldIn, shooter);
		return bombarrowentity;
	}
}
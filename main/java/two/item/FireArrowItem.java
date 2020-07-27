package two.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import two.entity.projectile.FireArrowEntity;

public class FireArrowItem extends ArrowItem {
	public FireArrowItem(Properties builder) {
		super(builder);
	}
	
	public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		FireArrowEntity firearrowentity = new FireArrowEntity(worldIn, shooter);
		return firearrowentity;
	}
}
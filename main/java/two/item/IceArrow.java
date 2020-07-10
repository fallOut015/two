package two.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import two.entity.projectile.IceArrowEntity;

public class IceArrow extends ArrowItem {
	public IceArrow(Properties builder) {
		super(builder);
	}
	
	public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		IceArrowEntity icearrowentity = new IceArrowEntity(worldIn, shooter);
		return icearrowentity;
	}
}
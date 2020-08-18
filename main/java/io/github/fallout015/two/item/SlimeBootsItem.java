package io.github.fallout015.two.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SlimeBootsItem extends ArmorItem {
	public SlimeBootsItem(Properties builder) {
		super(ArmorMaterialTwo.SLIME_BOOTS, EquipmentSlotType.FEET, builder);
	}
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
//		player.setSneaking(true);
		
		super.onArmorTick(stack, world, player);
	}
	
	public static void bounce(Entity entity, int level) {
		Vec3d vec3d = entity.getMotion();
		System.out.println(level);
		if(vec3d.y < 0.0D) {
			double d0 = (3 + (3 * level)) * (entity instanceof LivingEntity ? 1.0D : 0.8D);
			entity.setMotion(vec3d.x, -vec3d.y * d0, vec3d.z);
		}
	}
}
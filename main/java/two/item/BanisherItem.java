package two.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;

public class BanisherItem extends Item {
	public BanisherItem(Properties properties) {
		super(properties);
	}
	
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.knockBack(target, 10, -(target.prevPosX - attacker.prevPosX), -(target.prevPosZ - attacker.prevPosZ));
		target.world.addParticle((IParticleData) ParticleTypes.DUST, target.prevPosX, target.prevPosY, target.prevPosZ, -(target.prevPosX - attacker.prevPosX), -0.1, -(target.prevPosZ - attacker.prevPosZ));
		return true;
	}
}
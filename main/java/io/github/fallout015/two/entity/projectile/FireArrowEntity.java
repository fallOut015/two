package io.github.fallout015.two.entity.projectile;

import io.github.fallout015.two.entity.EntityTypeTwo;
import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class FireArrowEntity extends AbstractArrowEntity {
	public FireArrowEntity(EntityType<? extends FireArrowEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}
	public FireArrowEntity(World worldIn, double x, double y, double z) {
		super(EntityTypeTwo.FIRE_ARROW.get(), x, y, z, worldIn);
	}
	public FireArrowEntity(World worldIn, LivingEntity shooter) {
		super(EntityTypeTwo.FIRE_ARROW.get(), shooter, worldIn);
	}
	
	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(ItemsTwo.FIRE_ARROW);
	}
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	@Override
	public boolean isBurning() {
		return true;
	}
	@Override
	public void tick() {
		super.tick();
		if (this.world.isRemote && !this.inGround) {
			this.world.addParticle(ParticleTypes.FLAME, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
		}
	}
}
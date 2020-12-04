package io.github.fallout015.two.entity.projectile;

import io.github.fallout015.two.entity.EntityTypeTwo;
import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BombArrowEntity extends AbstractArrowEntity {
	public BombArrowEntity(EntityType<? extends BombArrowEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}
	public BombArrowEntity(World worldIn, double x, double y, double z) {
		super(EntityTypeTwo.BOMB_ARROW.get(), x, y, z, worldIn);
	}
	public BombArrowEntity(World worldIn, LivingEntity shooter) {
		super(EntityTypeTwo.BOMB_ARROW.get(), shooter, worldIn);
	}
	
	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(ItemsTwo.BOMB_ARROW);
	}
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	@Override
	protected void arrowHit(LivingEntity living) {
		if (!this.world.isRemote) {
			explode();
		}
	}
	@Override
	public void tick() {
		super.tick();
		if(this.timeInGround > 10) {
			explode();
		}
		if (this.world.isRemote && !this.inGround) {
			this.world.addParticle(ParticleTypes.FIREWORK, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
		}
	}
	private void explode() {
		this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 2.0f, Explosion.Mode.BREAK);
		this.remove();
	}
}
package io.github.fallout015.two.entity.effect;

import io.github.fallout015.two.entity.EntityTypeTwo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class SigilEntity extends Entity {
	public SigilEntity(EntityType<? extends Entity> type, World worldIn) {
		super(EntityTypeTwo.SIGIL, worldIn); // super(type)? TODO
	}

	@Override
	public void tick() {
		this.noClip = true;
		super.tick();
		
		double x = MathHelper.lerp(this.rand.nextInt(2), this.getPosX() - 32, this.getPosX() + 32);
		double y = this.getPosY();
		double z = MathHelper.lerp(this.rand.nextInt(2), this.getPosZ() - 32, this.getPosZ() + 32);
		this.getEntityWorld().addParticle(ParticleTypes.FIREWORK, x, y, z, 0, this.rand.nextInt() % 2, 0);
	}
	@Override
	protected void registerData() {
		// TODO Auto-generated method stub
	}
	@Override
	protected void readAdditional(CompoundNBT compound) {
		// TODO Auto-generated method stub
	}
	@Override
	protected void writeAdditional(CompoundNBT compound) {
		// TODO Auto-generated method stub
	}
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
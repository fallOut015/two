package io.github.fallout015.two.entity.effect;

import javax.annotation.Nullable;

import io.github.fallout015.two.entity.EntityTypeTwo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class TwisterEntity extends Entity {
	@Nullable
	private ServerPlayerEntity caster;
	
	public TwisterEntity(EntityType<? extends Entity> type, World worldIn) {
		super(type, worldIn);
		
		this.caster = null;
		this.ignoreFrustumCheck = false;
	}
	public TwisterEntity(World worldIn, double x, double y, double z, @Nullable ServerPlayerEntity caster) {
		super(EntityTypeTwo.TWISTER.get(), worldIn);
		
		this.setLocationAndAngles(x, y, z, 0.0F, 0.0F);
		this.caster = caster;
		this.ignoreFrustumCheck = true;
	}
	
	@Override
	public void tick() {
		super.tick();
		if (this.world.isRemote) {
			this.world.addParticle(ParticleTypes.CLOUD, this.getPosX() + this.rand.nextInt(16) / 16f, this.getPosY() + this.rand.nextInt(32) / 32f, this.getPosZ() + this.rand.nextInt(16) / 16f, 0.0D, 0.0D, 0.0D);
		}
	}
	@Override
	protected void registerData() { }
	@Override
	protected void readAdditional(CompoundNBT compound) { }
	@Override
	protected void writeAdditional(CompoundNBT compound) { }
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public float getSizeFromTicks() {
		return Math.max(0, -(0.05f * this.ticksExisted - 1));
	}
}
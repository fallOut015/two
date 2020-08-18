package io.github.fallout015.two.entity.monster;

import java.util.Random;

import io.github.fallout015.two.potion.EffectsTwo;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class IceSlimeEntity extends SlimeEntity {
	public IceSlimeEntity(EntityType<? extends IceSlimeEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	protected void dealDamage(LivingEntity entityIn) {
		if (this.isAlive()) {
			int i = this.getSlimeSize();
			if (this.getDistanceSq(entityIn) < 0.6D * (double)i * 0.6D * (double)i && this.canEntityBeSeen(entityIn) && entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), this.func_225512_er_())) {
				this.playSound(SoundEvents.ENTITY_SLIME_ATTACK, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
				this.applyEnchantments(this, entityIn);
				entityIn.addPotionEffect(new EffectInstance(EffectsTwo.FROSTY, 100, 1, false, true));
			}
		}
	}
	@Override
	protected int getJumpDelay() {
		return this.rand.nextInt(30) + 20;
	}
	@Override
	protected IParticleData getSquishParticle() {
		return ParticleTypes.ITEM_SNOWBALL; // TODO change to icy slime ball
	}
	@Override
	public void tick() {
		super.tick();
		if (this.world.isRemote) {
			double x = this.getPosX() - this.getWidth() / 2 + this.rand.nextInt((int) this.getWidth() + 1);
			double y = this.getPosY() - this.getHeight() / 2 + this.rand.nextInt((int) this.getHeight() + 1);
			double z = this.getPosZ() - this.getWidth() / 2 + this.rand.nextInt((int) this.getWidth() + 1);
			this.world.addParticle(ParticleTypes.CLOUD, x, y, z, 0.0D, 0.0D, 0.0D);
		}
	}
	
	public static boolean canSpawn(EntityType<IceSlimeEntity> iceSlimeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
		if (pos.getY() >= worldIn.getSeaLevel() / 2) {
			return randomIn.nextInt(10) == 0; // small chance of spawning above ground. 
		}
		return true; // spawns underground. 
	}
}
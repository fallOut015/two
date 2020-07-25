package two.entity.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.EvokerFangsEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EvocationFangsEntity extends EvokerFangsEntity {
	private int warmupDelayTicks;
	private boolean sentSpikeEvent;
	private int lifeTicks = 22;
	private boolean clientSideAttackStarted;

	private int snappingLevel;
	
	public EvocationFangsEntity(EntityType<? extends EvocationFangsEntity> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
	}
	public EvocationFangsEntity(World worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, LivingEntity casterIn, int snappingLevel) {
		super(worldIn, x, y, z, p_i47276_8_, p_i47276_9_, casterIn);
		this.warmupDelayTicks = p_i47276_9_;
		
		this.snappingLevel = snappingLevel;
	}

	@Override
	public void tick() {
		super.tick();
		if (this.world.isRemote) {
			if (this.clientSideAttackStarted) {
				-- this.lifeTicks;
				if (this.lifeTicks == 14) {
	               for(int i = 0; i < 12; ++i) {
	            	   double d0 = this.getPosX() + (this.rand.nextDouble() * 2.0D - 1.0D) * (double)this.getWidth() * 0.5D;
	            	   double d1 = this.getPosY() + 0.05D + this.rand.nextDouble();
	            	   double d2 = this.getPosZ() + (this.rand.nextDouble() * 2.0D - 1.0D) * (double)this.getWidth() * 0.5D;
	            	   double d3 = (this.rand.nextDouble() * 2.0D - 1.0D) * 0.3D;
	            	   double d4 = 0.3D + this.rand.nextDouble() * 0.3D;
	            	   double d5 = (this.rand.nextDouble() * 2.0D - 1.0D) * 0.3D;
	            	   this.world.addParticle(ParticleTypes.CRIT, d0, d1 + 1.0D, d2, d3, d4, d5);
	               }
				}
			}
		} else if (--this.warmupDelayTicks < 0) {
			if (this.warmupDelayTicks == -8) {
				for(LivingEntity livingentity : this.world.getEntitiesWithinAABB(LivingEntity.class, this.getBoundingBox().grow(0.2D, 0.0D, 0.2D))) {
					this.damage(livingentity);
	            }
			}
			if (!this.sentSpikeEvent) {
	            this.world.setEntityState(this, (byte)4);
	            this.sentSpikeEvent = true;
			}
			if (--this.lifeTicks < 0) {
	            this.remove();
			}
		}
	}
	
	private void damage(LivingEntity p_190551_1_) {
		LivingEntity livingentity = this.getCaster();
		if (p_190551_1_.isAlive() && !p_190551_1_.isInvulnerable() && p_190551_1_ != livingentity) {
			if (livingentity == null) {
				p_190551_1_.attackEntityFrom(DamageSource.MAGIC, 6.0F * (snappingLevel + 1));
			} else {
	            if (livingentity.isOnSameTeam(p_190551_1_)) {
	            	return;
	            }

	            p_190551_1_.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, livingentity), 6.0F);
			}
		}
	}
}
package io.github.fallout015.two.entity.projectile;

import io.github.fallout015.two.entity.EntityTypeTwo;
import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ShurikenEntity extends ProjectileItemEntity {
	public ShurikenEntity(EntityType<? extends ShurikenEntity> type, World world) {
		super(type, world);
	}
	public ShurikenEntity(World worldIn, LivingEntity throwerIn) {
		super(EntityTypeTwo.SHURIKEN.get(), throwerIn, worldIn);
	}
	public ShurikenEntity(World worldIn, double x, double y, double z) {
		super(EntityTypeTwo.SHURIKEN.get(), x, y, z, worldIn);
	}
	
	protected Item getDefaultItem() {
		return ItemsTwo.SHURIKEN;
	}
	
	@Override
	public void tick() {
		super.tick();
		
		if (this.world.isRemote) {
			this.world.addParticle(ParticleTypes.FIREWORK, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
		}
	}
	
//	@OnlyIn(Dist.CLIENT)
//	public void handleStatusUpdate(byte id) {
//		if(id == 3) {
//			IParticleData iparticledata = ParticleTypes.CRIT;
//
//			for(int i = 0; i < 8; ++i) {
//				this.world.addParticle(iparticledata, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
//			}
//		}
//	}

	protected void onEntityHit(EntityRayTraceResult result) {
		super.onEntityHit(result);
		Entity entity = result.getEntity();
		entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), (float) 1);
	}
	protected void onImpact(RayTraceResult result) {
		super.onImpact(result);
		if (!this.world.isRemote) {
//			this.world.setEntityState(this, (byte)3);
//			this.remove();
		}
	}
}
package io.github.fallout015.two.entity.boss.magmeel;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;

public class MagmeelSegmentEntity extends Entity {
	public MagmeelSegmentEntity(EntityType<?> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
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
		// TODO Auto-generated method stub
		return null;
	}
}
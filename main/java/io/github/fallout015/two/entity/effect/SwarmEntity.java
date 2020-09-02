package io.github.fallout015.two.entity.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;

public class SwarmEntity extends Entity {
	public SwarmEntity(EntityType<?> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
	}
	/*
	 * butterflies in flower biomes, plains, etc.
	 * flies in jungles
	 * fireflies in forests at night
	 * etc.
	 * grasshopper
	 */

	@Override
	protected void registerData() {
		
	}
	@Override
	protected void readAdditional(CompoundNBT compound) {
		
	}
	@Override
	protected void writeAdditional(CompoundNBT compound) {
		
	}
	@Override
	public IPacket<?> createSpawnPacket() {
		return null;
	}
}
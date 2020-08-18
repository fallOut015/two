package io.github.fallout015.two.entity.monster;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class WandererEntity extends MonsterEntity {
	public WandererEntity(EntityType<? extends WandererEntity> type, World worldIn) {
		super(type, worldIn);
	}
}
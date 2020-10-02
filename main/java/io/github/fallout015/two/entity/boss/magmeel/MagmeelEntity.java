package io.github.fallout015.two.entity.boss.magmeel;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class MagmeelEntity extends MonsterEntity {
	public MagmeelEntity(EntityType<? extends MagmeelEntity> type, World world) {
		super(type, world);
	}
	
	public static AttributeModifierMap.MutableAttribute applyAttributes() {
		return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, 100.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.5F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0D).createMutableAttribute(Attributes.ARMOR, 5.0D);
	}
}
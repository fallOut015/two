package io.github.fallout015.two.entity.passive;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.world.World;

public class JellyfishEntity extends WaterMobEntity {
	public JellyfishEntity(EntityType<? extends JellyfishEntity> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
	}
	
	public static AttributeModifierMap.MutableAttribute applyAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.15F).createMutableAttribute(Attributes.MAX_HEALTH, 10.0D);
	}
}
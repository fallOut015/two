package io.github.fallout015.two.entity.passive;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class NetherBugEntity extends CreatureEntity {
	public NetherBugEntity(EntityType<? extends NetherBugEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 0.4D, 1.0000001E-5F));
		this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 10.0F));
		this.goalSelector.addGoal(2, new PanicGoal(this, 2.0D));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, AbstractPiglinEntity.class, 10.0F, 0.4D, 0.6D));
	}
	
	public static AttributeModifierMap.MutableAttribute applyAttributes() {
		return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233821_d_, (double)0.2F).func_233815_a_(Attributes.field_233818_a_, 10.0D);
	}

	@Override
	public boolean isBurning() {
		return false;
	}
}
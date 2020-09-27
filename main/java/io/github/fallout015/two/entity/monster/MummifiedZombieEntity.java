package io.github.fallout015.two.entity.monster;

import java.util.Random;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class MummifiedZombieEntity extends ZombieEntity {
	public MummifiedZombieEntity(EntityType<? extends ZombieEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	@SuppressWarnings("deprecation")
	public static boolean canSpawn(EntityType<MummifiedZombieEntity> batIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
		if (pos.getY() >= worldIn.getSeaLevel()) {
			return false;
		}
		return true;
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.applyEntityAI();
	}
	@Override
	protected void applyEntityAI() {
		this.goalSelector.addGoal(2, new ZombieAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::isBreakDoorsTaskSet));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(ZombifiedPiglinEntity.class));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.TARGET_DRY_BABY));
	}
	
	public static AttributeModifierMap.MutableAttribute applyAttributes() {
		return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, 40.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.33F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0D).createMutableAttribute(Attributes.ARMOR, 3.0D).createMutableAttribute(Attributes.ZOMBIE_SPAWN_REINFORCEMENTS);
	}
	
	@Override
	protected void registerData() {
		super.registerData();
	}
	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
	}
	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
	}
	@Override
	protected boolean shouldBurnInDay() {
		return false;
	}
}
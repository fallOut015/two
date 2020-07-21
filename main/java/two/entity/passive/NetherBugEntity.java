package two.entity.passive;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.ZombiePigmanEntity;
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
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, ZombiePigmanEntity.class, 10.0F, 0.4D, 0.6D));
	}
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
	}
	@Override
	public boolean isBurning() {
		return false;
	}
}
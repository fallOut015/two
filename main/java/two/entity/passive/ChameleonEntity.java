package two.entity.passive;

import net.minecraft.block.Block;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ChameleonEntity extends ShoulderRidingEntity {
	private Block on;
	
	public ChameleonEntity(EntityType<? extends ChameleonEntity> type, World worldIn) {
		super(type, worldIn);
	    this.setTamed(false);
	}
	
	protected void applyEntityAI() {
		//this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1.0D, 10.0F, 5.0F));
		this.goalSelector.addGoal(2, new BreedGoal(this, 0.8D));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 0.8D, 1.0000001E-5F));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 10.0F));
		this.goalSelector.addGoal(5, new PanicGoal(this, 1.25D));
	}
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(2);
	}
	@Override
	public AgeableEntity createChild(AgeableEntity arg0) {
		return null;
	}
	@SuppressWarnings("deprecation")
	public Block getStandingOn() {
		if(world.getBlockState(new BlockPos(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ())).getBlock().isSolid(
			world.getBlockState(new BlockPos(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ())).getBlockState()
		)) this.on = world.getBlockState(new BlockPos(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ())).getBlock();
		else this.on = world.getBlockState(new BlockPos(this.getPosition().getX(), this.getPosition().getY() - 0.25, this.getPosition().getZ())).getBlock();
		return this.on;
	}
}

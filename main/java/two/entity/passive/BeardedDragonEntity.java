package two.entity.passive;

import java.util.UUID;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import two.entity.EntityTypeTwo;

public class BeardedDragonEntity extends ShoulderRidingEntity {
	public BeardedDragonEntity(EntityType<? extends BeardedDragonEntity> type, World worldIn) {
		super(type, worldIn);
		this.setTamed(false);
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		BeardedDragonEntity beardeddragonentity = EntityTypeTwo.BEARDED_DRAGON.create(this.world);
		UUID uuid = this.getOwnerId();
		if (uuid != null) {
			beardeddragonentity.setOwnerId(uuid);
			beardeddragonentity.setTamed(true);
		}
		return beardeddragonentity;
	}
	@Override
	protected void registerGoals() {
	    this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 2.0D, 1.0F, 9.0F, false));
		this.goalSelector.addGoal(2, new BreedGoal(this, 0.8D));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 0.8D, 1.0000001E-5F));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 10.0F));
		this.goalSelector.addGoal(5, new PanicGoal(this, 2.0D));
	}
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
	}
	@Override
	public boolean processInteract(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			return super.processInteract(player, hand);
		} else if (this.world.isRemote) {
			return this.isOwner(player) || item == Items.SPIDER_EYE;
		} else {
			if (this.isTamed()) {
				if (item.isFood() && this.getHealth() < this.getMaxHealth()) {
	               if (!player.abilities.isCreativeMode) {
	            	   itemstack.shrink(1);
	               }

	               this.heal((float)item.getFood().getHealing());
	               return true;
				}
	            if (this.isOwner(player) && !this.isBreedingItem(itemstack)) {
	            	this.isJumping = false;
	            	this.navigator.clearPath();
	            }
			} else if (item == Items.SPIDER_EYE) {
				if (!player.abilities.isCreativeMode) {
					itemstack.shrink(1);
	            }

	            if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
	            	this.setTamedBy(player);
	            	this.navigator.clearPath();
	            	this.world.setEntityState(this, (byte)7);
	            } else {
	            	this.world.setEntityState(this, (byte)6);
	            }

	            return true;
			}

			return super.processInteract(player, hand);
		}
	}
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		Item item = stack.getItem();
		return item == Items.SPIDER_EYE;
	}
}
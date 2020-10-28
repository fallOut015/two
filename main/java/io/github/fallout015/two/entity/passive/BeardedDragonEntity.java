package io.github.fallout015.two.entity.passive;

import java.util.UUID;

import io.github.fallout015.two.entity.EntityTypeTwo;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.LandOnOwnersShoulderGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class BeardedDragonEntity extends ShoulderRidingEntity {
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.SPIDER_EYE);

	public BeardedDragonEntity(EntityType<? extends BeardedDragonEntity> type, World worldIn) {
		super(type, worldIn);
		this.setTamed(false);
	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity ageable) {
		BeardedDragonEntity beardeddragonentity = EntityTypeTwo.BEARDED_DRAGON.create(serverWorld);
		UUID uuid = this.getOwnerId();
		if (uuid != null) {
			beardeddragonentity.setOwnerId(uuid);
			beardeddragonentity.setTamed(true);
		}
		
		return beardeddragonentity;
	}
	@Override
	protected void registerGoals() {
	    this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1.0D, 1.0F, 9.0F, false));
		this.goalSelector.addGoal(2, new LandOnOwnersShoulderGoal(this));
		this.goalSelector.addGoal(3, new PanicGoal(this, 2.0D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 0.8D, 1.0000001E-5F));
		this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 10.0F));
		this.goalSelector.addGoal(6, new BreedGoal(this, 0.8D));
		this.goalSelector.addGoal(7, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
	}
	
	public static AttributeModifierMap.MutableAttribute applyAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.3F).createMutableAttribute(Attributes.MAX_HEALTH, 5.0D);
	}
	
	public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		Item item = itemstack.getItem();
		if (this.world.isRemote) {
			boolean flag = this.isOwner(player) || this.isTamed() || item == Items.SPIDER_EYE && !this.isTamed();
			return flag ? ActionResultType.CONSUME : ActionResultType.PASS;
		} else {
			if (this.isTamed()) {
				if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
					if (!player.abilities.isCreativeMode) {
						itemstack.shrink(1);
					}

					this.heal((float)item.getFood().getHealing());
					return ActionResultType.SUCCESS;
	            }

	            if (!(item instanceof DyeItem)) {
	            	ActionResultType actionresulttype = super.func_230254_b_(player, hand);
	            	if ((!actionresulttype.isSuccessOrConsume() || this.isChild()) && this.isOwner(player)) {
	            		this.func_233687_w_(!this.isSitting());
	            		this.isJumping = false;
	            		this.navigator.clearPath();
	            		this.setAttackTarget((LivingEntity)null);
	            		return ActionResultType.SUCCESS;
	            	}

	            	return actionresulttype;
	            }

			} else if (item == Items.SPIDER_EYE) {
	            if (!player.abilities.isCreativeMode) {
	            	itemstack.shrink(1);
	            }

	            if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
	            	this.setTamedBy(player);
	            	this.navigator.clearPath();
	            	this.setAttackTarget((LivingEntity)null);
	            	this.func_233687_w_(true);
	            	this.world.setEntityState(this, (byte)7);
	            } else {
	            	this.world.setEntityState(this, (byte)6);
	            }

	            return ActionResultType.SUCCESS;
			}

			return super.func_230254_b_(player, hand);
		}
	}
	
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		Item item = stack.getItem();
		return item == Items.SPIDER_EYE;
	}
	@Override
	public void setTamed(boolean tamed) {
		super.setTamed(tamed);
		if (tamed) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10.0D);
			this.setHealth(10.0F);
		} else {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(5.0D);
		}
	}
}
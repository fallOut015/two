package two.entity.passive;

import java.util.UUID;

import net.minecraft.block.BlockState;
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
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import two.entity.EntityTypeTwo;

public class ChameleonEntity extends ShoulderRidingEntity {
	private static final DataParameter<Boolean> CAMOFLOUGE = EntityDataManager.createKey(ChameleonEntity.class, DataSerializers.BOOLEAN);
	private BlockState on;
	
	public ChameleonEntity(EntityType<? extends ChameleonEntity> type, World worldIn) {
		super(type, worldIn);
	    this.setTamed(false);
	}
	
	protected void applyEntityAI() {
	    this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
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
	public AgeableEntity createChild(AgeableEntity ageable) {
		ChameleonEntity chameleonentity = EntityTypeTwo.CHAMELEON.create(this.world);
		UUID uuid = this.getOwnerId();
		if (uuid != null) {
			chameleonentity.setOwnerId(uuid);
			chameleonentity.setTamed(true);
		}
		return chameleonentity;
	}
	public BlockState getStandingOn() {
		if(!this.world.getBlockState(this.getPosition()).isSolid() && !this.world.getBlockState(this.getPosition()).isAir(this.world, this.getPosition())) {
			this.on = this.world.getBlockState(this.getPosition());
		} else {
			this.on = this.world.getBlockState(this.getPosition().down());			
		}
		return this.on;
	}
	@Override
	protected void registerData() {
		super.registerData();
		
		this.dataManager.register(CAMOFLOUGE, true);
	}
	public static boolean camoflouged(ChameleonEntity entity) {
		return entity.getDataManager().get(CAMOFLOUGE).booleanValue();
	}
	
	public boolean processInteract(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			return super.processInteract(player, hand);
		} else if (this.world.isRemote) {
			return this.isOwner(player) || item == Items.SPIDER_EYE;
		} else {
			if (this.isTamed()) {
				if(this.isBreedingItem(itemstack)) {
					this.dataManager.set(CAMOFLOUGE, !this.dataManager.get(CAMOFLOUGE).booleanValue());
				} else if (item.isFood() && this.getHealth() < this.getMaxHealth()) {
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
	public boolean isBreedingItem(ItemStack stack) {
		Item item = stack.getItem();
		return item == Items.FERMENTED_SPIDER_EYE;
	}
}
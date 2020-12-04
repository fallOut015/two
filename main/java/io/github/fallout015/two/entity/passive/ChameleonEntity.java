package io.github.fallout015.two.entity.passive;

import java.util.EnumSet;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Stream;

import io.github.fallout015.two.Two;
import io.github.fallout015.two.entity.EntityTypeTwo;
import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LandOnOwnersShoulderGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.ClimberPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ChameleonEntity extends ShoulderRidingEntity {
	private static final DataParameter<Integer> CAMOFLOUGE = EntityDataManager.createKey(ChameleonEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Optional<BlockState>> ON = EntityDataManager.createKey(ChameleonEntity.class, DataSerializers.OPTIONAL_BLOCK_STATE);
	private static final DataParameter<Integer> COLOR = EntityDataManager.createKey(ChameleonEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(ChameleonEntity.class, DataSerializers.BYTE);
	private static final DataParameter<Boolean> RESTING = EntityDataManager.createKey(ChameleonEntity.class, DataSerializers.BOOLEAN);
	public int timeUntilNextShed = this.rand.nextInt(12000) + 6000;
	
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.SPIDER_EYE, Items.FERMENTED_SPIDER_EYE);

	public ChameleonEntity(EntityType<? extends ChameleonEntity> type, World worldIn) {
		super(type, worldIn);
	    this.setTamed(false);
	}
	
	@Override
	protected void registerGoals() {
	    this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1.5D, 1.0F, 9.0F, false));
		this.goalSelector.addGoal(2, new LandOnOwnersShoulderGoal(this));
		this.goalSelector.addGoal(3, new PanicGoal(this, 2.0D));
		this.goalSelector.addGoal(4, new BreedGoal(this, 0.8D));
		this.goalSelector.addGoal(5, new ChameleonEntity.RestOnBlockGoal(this, (blockState) -> blockState.getBlock() == Blocks.SAND)); // add a light value to the predicate
		this.goalSelector.addGoal(5, new ChameleonEntity.RestOnBlockGoal(this, (blockState) -> blockState.getBlock() == Blocks.JUNGLE_LOG));
		this.goalSelector.addGoal(6, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 10.0F));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 0.8D, 1.0000001E-5F));
	}
	
	public static AttributeModifierMap.MutableAttribute applyAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.15F).createMutableAttribute(Attributes.MAX_HEALTH, 5.0D);
	}
	
	@Override
	protected void registerData() {
		super.registerData();
		
		this.dataManager.register(CAMOFLOUGE, 0); // 0 is for blending (default), 1 is for default chameleon texture, 2 is for remembering
		this.dataManager.register(ON, Optional.empty());
		this.dataManager.register(COLOR, -1); // -1 for no color overlay
		this.dataManager.register(CLIMBING, (byte)0);
		this.dataManager.register(RESTING, false);
	}
	@Override
	public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity ageable) {
		ChameleonEntity chameleonentity = EntityTypeTwo.CHAMELEON.get().create(serverWorld);
		UUID uuid = this.getOwnerId();
		if (uuid != null) {
			chameleonentity.setOwnerId(uuid);
			chameleonentity.setTamed(true);
		}
		
		return chameleonentity;
	}
	
	public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		Item item = itemstack.getItem();
		if (this.world.isRemote) {
			boolean flag = this.isOwner(player) || this.isTamed() || item == Items.SPIDER_EYE && !this.isTamed();
			return flag ? ActionResultType.CONSUME : ActionResultType.PASS;
		} else {
			if (this.isTamed()) {
				if(this.isSpecialItem(itemstack)) {
					if(this.dataManager.get(CAMOFLOUGE).intValue() == 2) {
						this.dataManager.set(CAMOFLOUGE, 0);
					} else {
						this.dataManager.set(CAMOFLOUGE, this.dataManager.get(CAMOFLOUGE).intValue() + 1);
						if(this.dataManager.get(CAMOFLOUGE).intValue() == 2) {
							this.updateOn();
						}
					}
					if(this.world.isRemote) {
						for(int i = 0; i < 7; ++i) {
							double d0 = this.rand.nextGaussian() * 0.02D;
							double d1 = this.rand.nextGaussian() * 0.02D;
							double d2 = this.rand.nextGaussian() * 0.02D;
							this.world.addParticle(ParticleTypes.CLOUD, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D, this.getPosZRandom(1.0D), d0, d1, d2);
						}
					}
				}
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
	public boolean isSpecialItem(ItemStack stack) {
		Item item = stack.getItem();
		return item == Items.FERMENTED_SPIDER_EYE;
	}
	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		
		this.dataManager.set(CAMOFLOUGE, compound.getInt("camoflouge"));
		this.dataManager.set(ON, Optional.of(NBTUtil.readBlockState((CompoundNBT) compound.get("on"))));
		this.dataManager.set(COLOR, compound.getInt("color"));
		
		this.dataManager.set(RESTING, compound.getBoolean("resting"));
	}
	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		
		compound.putInt("camoflouge", this.dataManager.get(CAMOFLOUGE).intValue());
		compound.put("on", NBTUtil.writeBlockState(this.dataManager.get(ON).orElse(Blocks.AIR.getDefaultState())));
		compound.putInt("color", this.dataManager.get(COLOR).intValue());
		
		compound.putBoolean("resting", this.dataManager.get(RESTING).booleanValue());
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
	@Override
	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
	}
	@Override
	public void tick() {
		super.tick();
		if (!this.world.isRemote) {
			this.setBesideClimbableBlock(this.collidedHorizontally);
		}
	}
	@Override
	protected PathNavigator createNavigator(World worldIn) {
		return new ClimberPathNavigator(this, worldIn);
	}
	@Override
	public void livingTick() {
		super.livingTick();
		
		if (!this.world.isRemote && this.isAlive() && !this.isChild() && --this.timeUntilNextShed <= 0) {
//			this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			this.entityDropItem(ItemsTwo.CHAMELEON_SKIN);
			this.timeUntilNextShed = this.rand.nextInt(12000) + 6000;
		}
	}
	
	public boolean isBesideClimbableBlock() {
		return (this.dataManager.get(CLIMBING) & 1) != 0;
	}
	public void setBesideClimbableBlock(boolean climbing) {
		byte b0 = this.dataManager.get(CLIMBING);
		if (climbing) {
			b0 = (byte)(b0 | 1);
		} else {
			b0 = (byte)(b0 & -2);
		}
		this.dataManager.set(CLIMBING, b0);
	}
	public boolean blend() {
		return this.dataManager.get(CAMOFLOUGE).intValue() == 0;
	}
	public boolean blendOff() {
		return this.dataManager.get(CAMOFLOUGE).intValue() == 1;
	}
	public BlockState getOn() {
		return this.dataManager.get(ON).orElse(Blocks.AIR.getDefaultState());
	}
	public int getColor() {
		return this.dataManager.get(COLOR).intValue();
	}
	public void updateOn() {
		this.dataManager.set(ON, Optional.of(this.world.getBlockState(this.getPositionUnderneath())));
		this.dataManager.set(COLOR, Minecraft.getInstance().getBlockColors().getColor(this.dataManager.get(ON).get(), null, new BlockPos(this.getPositionUnderneath()), 0));
	}
	// TODO
	/*
	 * baby
	 * particles when cycling camoflouge
	 * tongue animations
	 * tree climbing
	 * data fixer
	 * fix camoflouge when hanging on the edge of a block
	 * camoflouge when submerged in a block
	 * add sound
	 * chameleons scare arthopods on shoulders
	 * chameleons retain texture on shoulder
	 * resting
	 */
	
	public class RestOnBlockGoal extends Goal {
		private final AnimalEntity animal;
		private final Predicate<BlockState> predicate$BlockState;
		private boolean foundBlock;
		private final PathNavigator navigator;
		private BlockPos destination;
		
		public RestOnBlockGoal(AnimalEntity animal, Predicate<BlockState> predicate$BlockState) {
			this.animal = animal;
			this.predicate$BlockState = predicate$BlockState;
			this.foundBlock = false;
			this.navigator = animal.getNavigator();
			this.destination = BlockPos.ZERO;
			
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}
			   
		@Override
		public boolean shouldExecute() {
			return true;
		}
		@Override
		public void tick() {
			super.tick();
			
			if(!this.foundBlock) {
				BlockPos from = new BlockPos(this.animal.getPositionVec().getX() - 5, this.animal.getPositionVec().getY() - 5, this.animal.getPositionVec().getZ() - 5);
				BlockPos to = new BlockPos(this.animal.getPositionVec().getX() + 5, this.animal.getPositionVec().getY() + 5, this.animal.getPositionVec().getZ() + 5);
				Stream<BlockPos> blocks = BlockPos.getAllInBox(from, to);
				blocks.forEach(pos -> {
					if(this.predicate$BlockState.test(this.animal.getEntityWorld().getBlockState(pos))) {
						Two.LOGGER.info("predicate accepted a block at {}", pos);
						this.foundBlock = true; 
						this.destination = pos;
					}
				});
			} else {
				Two.LOGGER.info("moving towards the goal");
				this.navigator.tryMoveToXYZ(this.destination.getX(), this.destination.getY(), this.destination.getZ(), this.animal.getAIMoveSpeed());
			}
		}
	}
}
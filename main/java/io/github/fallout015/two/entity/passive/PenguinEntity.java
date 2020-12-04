package io.github.fallout015.two.entity.passive;

import java.util.EnumSet;

import javax.annotation.Nullable;

import io.github.fallout015.two.client.renderer.entity.PenguinRenderer;
import io.github.fallout015.two.entity.EntityTypeTwo;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class PenguinEntity extends AnimalEntity {
	private static final DataParameter<ItemStack> FISH = EntityDataManager.createKey(PenguinEntity.class, DataSerializers.ITEMSTACK);
	private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(PenguinEntity.class, DataSerializers.VARINT);
	// penguins have a separate pose for when swimming
	// penguins guard their babies
	// eat fish and feed to babies
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.SALMON, Items.COD);
	
	public PenguinEntity(EntityType<? extends PenguinEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity p_241840_2_) {
		return EntityTypeTwo.PENGUIN.get().create(serverWorld);
	}
	
	public static AttributeModifierMap.MutableAttribute applyAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.19F).createMutableAttribute(Attributes.MAX_HEALTH, 5.0D);
	}
	@Override
	protected void registerData() {
		super.registerData();
		
		this.dataManager.register(FISH, ItemStack.EMPTY);
		this.dataManager.register(VARIANT, 0);
	}
	@Override
	public void readAdditional(CompoundNBT nbt) {
		super.readAdditional(nbt);
		
		ItemStack fish = ItemStack.EMPTY;
		fish.deserializeNBT((CompoundNBT) nbt.get("FISH"));
		this.dataManager.set(FISH, fish);
		this.dataManager.set(VARIANT, nbt.getInt("VARIANT"));
	}
	@Override
	public void writeAdditional(CompoundNBT nbt) {
		super.writeAdditional(nbt);

		nbt.put("FISH", this.dataManager.get(FISH).serializeNBT());
		nbt.putInt("VARIANT", this.dataManager.get(VARIANT).intValue());
	}
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new TemptGoal(this, 1.0D, true, TEMPTATION_ITEMS) {
			@Override
			public boolean shouldContinueExecuting() {
				return this.creature instanceof PenguinEntity && !((PenguinEntity) this.creature).hasFish() && super.shouldContinueExecuting();
			}
			@Override
			public boolean shouldExecute() {
				return this.creature instanceof PenguinEntity && !((PenguinEntity) this.creature).hasFish() && super.shouldExecute();
			}
		});
		this.goalSelector.addGoal(3, new PenguinEntity.FeedChildGoal(this, 1.0D, 10));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new MoveTowardsTargetGoal(this, 1.0D, 32.0F));
		this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 10.0F));
		this.goalSelector.addGoal(8, new PanicGoal(this, 1.75D));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractFishEntity.class, false));
	}
	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, ILivingEntityData spawnDataIn, CompoundNBT dataTag) {
		this.setVariant(this.rand.nextInt(PenguinRenderer.TEXTURE.length));
		
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	public boolean hasFish() {
		return !this.dataManager.get(FISH).isEmpty();
	}
	public ItemStack getFish() {
		return this.dataManager.get(FISH);
	}
	public void setFish(ItemStack fish) {
		if(fish.getItem() == Items.SALMON || fish.getItem() == Items.COD) {
			this.dataManager.set(FISH, fish);
		}
	}
	public void removeFish() {
		this.dataManager.set(FISH, ItemStack.EMPTY);
	}
	public int getVariant() {
		return this.dataManager.get(VARIANT).intValue();
	}
	public void setVariant(int value) {
		this.dataManager.set(VARIANT, value);
	}
	
	@Override
	public ActionResultType func_230254_b_(PlayerEntity playerEntity, Hand hand) {
		if(!this.isChild() && playerEntity.getHeldItem(hand).getItem() == Items.SALMON || playerEntity.getHeldItem(hand).getItem() == Items.COD) {
			this.setFish(new ItemStack(playerEntity.getHeldItem(hand).getItem()));
			playerEntity.getHeldItem(hand).shrink(1);
		} else if(playerEntity.getHeldItem(hand).isEmpty() && this.hasFish()) {
			playerEntity.setHeldItem(hand, this.getFish());
			this.removeFish();
		}
		
		return ActionResultType.CONSUME;
	}
	@Override
	protected void collideWithEntity(Entity entityIn) {
		if(entityIn.getType() == EntityType.SALMON) {
			entityIn.remove();
			this.setFish(new ItemStack(Items.SALMON));
		} else if(entityIn.getType() == EntityType.COD) {
			entityIn.remove();
			this.setFish(new ItemStack(Items.COD));
		} else if(entityIn instanceof PenguinEntity && entityIn.getType() == EntityTypeTwo.PENGUIN.get() && ((PenguinEntity) entityIn).isChild()) {
			((PenguinEntity) entityIn).setFish(this.getFish());
			this.removeFish();
		}
		
		super.collideWithEntity(entityIn);
	}
	
	public class FeedChildGoal extends Goal {
		protected final PenguinEntity creature;
		private final double speed;
		private final double distance;   
		private final PathNavigator navigator;

		public FeedChildGoal(CreatureEntity creatureIn, double speedIn, double distanceIn) {
			this.creature = (PenguinEntity) creatureIn;
			this.speed = speedIn;
			this.distance = distanceIn;
			this.navigator = creatureIn.getNavigator();
			
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		@Override
		public boolean shouldExecute() {
			return this.creature.hasFish();
		}
		@Override
		public boolean shouldContinueExecuting() {
			return this.creature.hasFish();
		}
		@Override
		public void tick() {
			// Find the nearest child penguin with the least health.
			float minhealth = this.creature.getMaxHealth();
			@Nullable Entity target = null;
			for(PenguinEntity penguin : this.creature.getEntityWorld().getEntitiesWithinAABB(EntityTypeTwo.PENGUIN.get(), new AxisAlignedBB(new BlockPos(this.creature.getPositionVec())).grow(this.distance), penguin -> penguin.isChild())) {
				if(penguin.getHealth() < minhealth) {
					minhealth = penguin.getHealth();
					target = penguin;
				}
			}
			if(target != null) {
				this.navigator.setPath(this.navigator.getPathToEntity(target, (int) this.distance), this.speed);
			}
			
			super.tick();
		}
	}
}
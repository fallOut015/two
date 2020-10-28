package io.github.fallout015.two.entity.effect;

import io.github.fallout015.two.client.renderer.entity.ButterflyRenderer;
import io.github.fallout015.two.entity.passive.PenguinEntity;
import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class ButterflyEntity extends CreatureEntity implements IFlyingAnimal {
	private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(PenguinEntity.class, DataSerializers.VARINT);
	public static String[] VARIANTS = {
		"entity.two.butterfly.black_yellow",
		"entity.two.butterfly.blue_black",
		"entity.two.butterfly.red_white",
		"entity.two.butterfly.white_black"
	};

	
	public ButterflyEntity(EntityType<? extends ButterflyEntity> type, World world) {
		super(type, world);
	}
	
	public static AttributeModifierMap.MutableAttribute applyAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 1.0D).createMutableAttribute(Attributes.FLYING_SPEED, (double)0.3F);
	}
	
	@Override
	protected void registerGoals() {
		// find flower
		this.goalSelector.addGoal(2, new AvoidEntityGoal<PlayerEntity>(this, PlayerEntity.class, 2.0f, 1.0D, 1.0D));
		// follow other butterflies
		this.goalSelector.addGoal(4, new WaterAvoidingRandomFlyingGoal(this, 1));
	}
	@Override
	protected void registerData() {
		super.registerData();
		
		this.dataManager.register(VARIANT, 0);
	}
	@Override
	public void readAdditional(CompoundNBT nbt) {
		super.readAdditional(nbt);
		
		this.dataManager.set(VARIANT, nbt.getInt("VARIANT"));
	}
	@Override
	public void writeAdditional(CompoundNBT nbt) {
		super.writeAdditional(nbt);

		nbt.putInt("VARIANT", this.dataManager.get(VARIANT).intValue());
	}
	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, ILivingEntityData spawnDataIn, CompoundNBT dataTag) {
		this.setVariant(this.rand.nextInt(ButterflyRenderer.TEXTURE.length));
		
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	@Override
	public boolean isInvulnerable() {
		return true;
	}
	@Override
	protected PathNavigator createNavigator(World worldIn) {
		return new FlyingPathNavigator(this, world);
	}
	@Override
	public boolean canBePushed() {
		return false;
	}
	@Override
	protected void collideWithEntity(Entity entityIn) { }
	@Override
	protected void collideWithNearbyEntities() { }
	@Override
	public void tick() {
		int groundDistance = 0;
		BlockPos pos = this.getPosition();
		while(this.getEntityWorld().isAirBlock(pos)) {
			++ groundDistance;
			pos = pos.down();
		}
		
		if(groundDistance < 2/* + this.fallDistance*/) {
			this.addVelocity(0, 0.2f, 0);
			if(this.getMotion().getY() > 0.4f) {
				this.setMotion(this.getMotion().getX(), 0.4f, this.getMotion().getZ());
			}
		}
		if(this.getMotion().getY() < -0.4f) {
			this.setMotion(this.getMotion().getX(), -0.4f, this.getMotion().getZ());
		}
		
		super.tick();
	}
	@Override
	protected int calculateFallDamage(float distance, float damageMultiplier) {
		return 0;
	}
	@Override
	public ActionResultType applyPlayerInteraction(PlayerEntity player, Vector3d vec, Hand hand) {
		if(player.getHeldItem(hand).getItem() == ItemsTwo.NET) {
			CompoundNBT nbt = player.getHeldItem(hand).getOrCreateTag();
			if(!nbt.contains("ButterflyEntity")) {
				nbt.put("ButterflyEntity", this.serializeNBT());	
			}
			
			this.remove();
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.PASS;
	}
	
	public int getVariant() {
		return this.dataManager.get(VARIANT).intValue();
	}
	public void setVariant(int value) {
		this.dataManager.set(VARIANT, value);
	}
}
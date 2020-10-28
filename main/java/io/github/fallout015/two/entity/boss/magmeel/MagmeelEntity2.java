package io.github.fallout015.two.entity.boss.magmeel;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class MagmeelEntity extends MonsterEntity {
	private static final DataParameter<Integer> SEGMENTS = EntityDataManager.createKey(MagmeelEntity.class, DataSerializers.VARINT);
//	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.WHITE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);
//	private MagmeelHeadEntity head;
//	private MagmeelSegmentEntity[] segments;
//	private MagmeelTailEntity tail;
	
	public MagmeelEntity(EntityType<? extends MagmeelEntity> type, World world) {
		super(type, world);
		
//		this.head = new MagmeelHeadEntity(this);
//		for(int i = 0; i < 10; ++ i) {
//			this.segments[i] = new MagmeelSegmentEntity(this);
//		}
//		this.tail = new MagmeelTailEntity(this);
	}
	
	public static AttributeModifierMap.MutableAttribute applyAttributes() {
		return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, 100.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.5F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0D).createMutableAttribute(Attributes.ARMOR, 5.0D);
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
//		if (this.hasCustomName()) {
//			this.bossInfo.setName(this.getDisplayName());
//		}
		this.dataManager.set(SEGMENTS, compound.getInt("SEGMENTS"));
	}
	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		
		compound.putInt("SEGMENTS", this.dataManager.get(SEGMENTS).intValue());
	}
//	@Override
//	public void setCustomName(@Nullable ITextComponent name) {
//		super.setCustomName(name);
//		this.bossInfo.setName(this.getDisplayName());
//	}
//	@Override
//	public boolean isNonBoss() {
//		return false;
//	}
//	@Override
//	protected void updateAITasks() {
//		super.updateAITasks();
//		
//		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
//	}
//	@Override
//	public void addTrackingPlayer(ServerPlayerEntity player) {
//		super.addTrackingPlayer(player);
//		this.bossInfo.addPlayer(player);
//	}
//	@Override
//	public void removeTrackingPlayer(ServerPlayerEntity player) {
//		super.removeTrackingPlayer(player);
//		this.bossInfo.removePlayer(player);
//	}
	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, ILivingEntityData spawnDataIn, CompoundNBT dataTag) {
		this.dataManager.set(SEGMENTS, getSegmentCountForDifficulty(difficultyIn));

		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
//	public MagmeelHeadEntity getHead() {
//		return this.head;
//	}
//	public MagmeelSegmentEntity[] getSegments() {
//		return this.segments;
//	}
//	public MagmeelTailEntity getTail() {
//		return this.tail;
//	}
	public static int getSegmentCountForDifficulty(DifficultyInstance difficultyIn) {
		switch(difficultyIn.getDifficulty()) {
			case EASY:
				return 5;
			case NORMAL:
				return 10;
			case HARD:
				return 20;
			case PEACEFUL:
			default:
				return 0;
		}
	}
	
//	public class MagmeelHeadEntity extends Entity {
//		final MagmeelEntity magmeel;
//		
//		public MagmeelHeadEntity(MagmeelEntity magmeel) {
//			super(EntityTypeTwo.MAGMEEL, magmeel.getEntityWorld());
//			
//			this.magmeel = magmeel;
//		}
//
//		@Override
//		protected void registerData() {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void readAdditional(CompoundNBT compound) {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void writeAdditional(CompoundNBT compound) {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public IPacket<?> createSpawnPacket() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//	}
//	public class MagmeelSegmentEntity extends Entity {
//		final MagmeelEntity magmeel;
//
//		public MagmeelSegmentEntity(MagmeelEntity magmeel) {
//			super(EntityTypeTwo.MAGMEEL, magmeel.getEntityWorld());
//			
//			this.magmeel = magmeel;
//		}
//
//		@Override
//		protected void registerData() {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void readAdditional(CompoundNBT compound) {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void writeAdditional(CompoundNBT compound) {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public IPacket<?> createSpawnPacket() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//	}
//	public class MagmeelTailEntity extends Entity {
//		final MagmeelEntity magmeel;
//		
//		public MagmeelTailEntity(MagmeelEntity magmeel) {
//			super(EntityTypeTwo.MAGMEEL, magmeel.getEntityWorld());
//			
//			this.magmeel = magmeel;
//		}
//
//		@Override
//		protected void registerData() {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void readAdditional(CompoundNBT compound) {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void writeAdditional(CompoundNBT compound) {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public IPacket<?> createSpawnPacket() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//	}
}
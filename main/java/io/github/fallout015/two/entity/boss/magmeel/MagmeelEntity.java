package io.github.fallout015.two.entity.boss.magmeel;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

public class MagmeelEntity extends MonsterEntity {
	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.WHITE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);
	MagmeelHeadEntity head;
	MagmeelSegmentEntity[] segments;
	MagmeelTailEntity tail;
	
	public MagmeelEntity(EntityType<? extends MagmeelEntity> type, World world) {
		super(type, world);
	}
	
	public static AttributeModifierMap.MutableAttribute applyAttributes() {
		return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233819_b_, 100.0D).func_233815_a_(Attributes.field_233821_d_, (double)0.5F).func_233815_a_(Attributes.field_233823_f_, 1.0D).func_233815_a_(Attributes.field_233826_i_, 5.0D).func_233814_a_(Attributes.field_233829_l_);
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		if (this.hasCustomName()) {
			this.bossInfo.setName(this.getDisplayName());
		}
	}
	@Override
	public void setCustomName(@Nullable ITextComponent name) {
		super.setCustomName(name);
		this.bossInfo.setName(this.getDisplayName());
	}
	@Override
	public boolean isNonBoss() {
		return false;
	}
	@Override
	protected void updateAITasks() {
		super.updateAITasks();
		
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}
	@Override
	public void addTrackingPlayer(ServerPlayerEntity player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}
	@Override
	public void removeTrackingPlayer(ServerPlayerEntity player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}
	
	public MagmeelHeadEntity getHead() {
		return this.head;
	}
	public MagmeelSegmentEntity[] getSegments() {
		return this.segments;
	}
	public MagmeelTailEntity getTail() {
		return this.tail;
	}
}
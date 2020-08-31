package io.github.fallout015.two.entity.effect;

import io.github.fallout015.two.entity.EntityTypeTwo;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.HandSide;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SigilEntity extends LivingEntity { // TODO change to normal entity
	public SigilEntity(EntityType<? extends LivingEntity> type, World worldIn) {
		super(EntityTypeTwo.SIGIL, worldIn);
	}

	@Override
	public Iterable<ItemStack> getArmorInventoryList() {
		return NonNullList.from(ItemStack.EMPTY);
	}
	@Override
	public ItemStack getItemStackFromSlot(EquipmentSlotType slotIn) {
		return ItemStack.EMPTY;
	}
	@Override
	public void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack) { }
	@Override
	public HandSide getPrimaryHand() {
		return HandSide.LEFT;
	}
	@Override
	public boolean hasNoGravity() {
		return true;
	}
	@Override
	public void tick() {
		this.noClip = true;
		super.tick();
		
		double x = MathHelper.lerp(this.rand.nextInt(2), this.getPosX() - 32, this.getPosX() + 32);
		double y = this.getPosY();
		double z = MathHelper.lerp(this.rand.nextInt(2), this.getPosZ() - 32, this.getPosZ() + 32);
		this.getEntityWorld().addParticle(ParticleTypes.FIREWORK, x, y, z, 0, this.rand.nextInt() % 2, 0);
	}
	@Override
	public boolean canBePushed() {
		return false;
	}
	@Override
	public boolean canAttack(EntityType<?> typeIn) {
		return false;
	}
	@Override
	public boolean canBeAttackedWithItem() {
		return false;
	}
	
	@Override
	protected void registerData() {
		super.registerData();
	}
}
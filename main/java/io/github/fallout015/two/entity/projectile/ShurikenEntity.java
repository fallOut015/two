package io.github.fallout015.two.entity.projectile;

import io.github.fallout015.two.entity.EntityTypeTwo;
import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Util;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

// TODO

public class ShurikenEntity extends ThrowableEntity {
	private static final DataParameter<ItemStack> ITEMSTACK_DATA = EntityDataManager.createKey(ShurikenEntity.class, DataSerializers.ITEMSTACK);
	
	public ShurikenEntity(EntityType<? extends ShurikenEntity> type, World worldIn) {
		super(type, worldIn);
	}
	public ShurikenEntity(double x, double y, double z, World worldIn) {
		super(EntityTypeTwo.SHURIKEN, x, y, z, worldIn);
	}
	public ShurikenEntity(LivingEntity livingEntityIn, World worldIn) {
		super(EntityTypeTwo.SHURIKEN, livingEntityIn, worldIn);
	}
	
	public void setItem(ItemStack stack) {
		if (stack.getItem() != this.getDefaultItem() || stack.hasTag()) {
			this.getDataManager().set(ITEMSTACK_DATA, Util.make(stack.copy(), (itemStack) -> {
				itemStack.setCount(1);
			}));
		}
	}
	protected Item getDefaultItem() {
		return ItemsTwo.SHURIKEN;
	}
	protected ItemStack itemStackData() {
		return this.getDataManager().get(ITEMSTACK_DATA);
	}
	
	@Override
	protected void onImpact(RayTraceResult result) {
		if (result.getType() == RayTraceResult.Type.ENTITY) {
			Entity entity = ((EntityRayTraceResult)result).getEntity();
			entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), 2.0f);
		}
		if (!this.world.isRemote) {
			this.world.setEntityState(this, (byte)3);
			this.remove();
		}
	}
	@Override
	protected void registerData() {
		this.getDataManager().register(ITEMSTACK_DATA, ItemStack.EMPTY);
	}
	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		ItemStack itemstack = this.itemStackData();
		if (!itemstack.isEmpty()) {
			compound.put("Item", itemstack.write(new CompoundNBT()));
		}
	}
	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		ItemStack itemstack = ItemStack.read(compound.getCompound("Item"));
		this.setItem(itemstack);
	}
}
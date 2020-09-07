package io.github.fallout015.two.entity.projectile;

import java.util.HashMap;
import java.util.Map;

import io.github.fallout015.two.Two;
import io.github.fallout015.two.entity.EntityTypeTwo;
import io.github.fallout015.two.item.ItemTierTwo;
import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;

public class CappedArrowEntity extends AbstractArrowEntity implements IEntityAdditionalSpawnData {
	private IItemTier tier;
	private static final Map<IItemTier, Item> ITEM_FOR_ARROW_TIER = new HashMap<IItemTier, Item>(9);

	public CappedArrowEntity(EntityType<? extends CappedArrowEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}
	public CappedArrowEntity(World worldIn, double x, double y, double z) {
		super(EntityTypeTwo.CAPPED_ARROW, x, y, z, worldIn);
	}
	public CappedArrowEntity(World worldIn, LivingEntity shooter) {
		super(EntityTypeTwo.CAPPED_ARROW, shooter, worldIn);
	}
	
	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(ITEM_FOR_ARROW_TIER.get(this.tier));
	}

	public void setItemTier(IItemTier tier) {
		this.tier = tier;
	}
	public IItemTier getItemTier() {
		return this.tier;
	}
	public float getVelocityMultiplier() {
		return this.tier.getEfficiency() / ItemTier.IRON.getEfficiency(); // iron is the same speed as a regular arrow, below iron is worse, above iron is better
	}
	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putString("tier", this.tier.toString());
	}
	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		try {
			this.tier = ItemTier.valueOf(compound.getString("tier"));
		} catch(Exception exception) {
			try {
				this.tier = ItemTierTwo.valueOf(compound.getString("tier"));
			} catch(Exception exception2) {
				Two.LOGGER.warn(exception2);
			}
		}
	}
	
	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		super.shoot(x, y, z, velocity * this.getVelocityMultiplier(), inaccuracy);
	}
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	static {
		ITEM_FOR_ARROW_TIER.put(ItemTier.WOOD, ItemsTwo.WOODEN_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTier.STONE, ItemsTwo.STONE_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTier.GOLD, ItemsTwo.GOLDEN_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTier.IRON, ItemsTwo.IRON_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTier.DIAMOND, ItemsTwo.DIAMOND_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTier.NETHERITE, ItemsTwo.NETHERITE_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTierTwo.EMERALD, ItemsTwo.EMERALD_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTierTwo.RUBY, ItemsTwo.RUBY_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTierTwo.LEAD, ItemsTwo.LEAD_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTierTwo.COPPER, ItemsTwo.COPPER_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTierTwo.MYRKYLITE, ItemsTwo.MYRKYLITE_CAPPED_ARROW);
	}

	@Override
	public void writeSpawnData(PacketBuffer buffer) {
		buffer.writeString(this.tier.toString());			
	}
	@Override
	@OnlyIn(Dist.CLIENT)
	public void readSpawnData(PacketBuffer additionalData) {
		String t = additionalData.readString();
		try {
			this.tier = ItemTier.valueOf(t);
		} catch(Exception exception) {
			try {
				this.tier = ItemTierTwo.valueOf(t);
			} catch(Exception exception2) {
				Two.LOGGER.warn(exception2);
			}
		}
	}
}
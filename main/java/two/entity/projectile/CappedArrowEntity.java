package two.entity.projectile;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.world.World;
import two.entity.EntityTypeTwo;
import two.item.ItemTierTwo;
import two.item.ItemsTwo;

public class CappedArrowEntity extends AbstractArrowEntity {
	private IItemTier tier;
	private static final Map<IItemTier, Item> ITEM_FOR_ARROW_TIER = new HashMap<IItemTier, Item>(9);

	public CappedArrowEntity(EntityType<? extends CappedArrowEntity> entityType, World worldIn) {
		super(entityType, worldIn);
		this.tier = ItemTier.IRON;
	}
	public CappedArrowEntity(World worldIn, double x, double y, double z) {
		super(EntityTypeTwo.CAPPED_ARROW, x, y, z, worldIn);
	}
	public CappedArrowEntity(World worldIn, LivingEntity shooter) {
		super(EntityType.ARROW, shooter, worldIn);
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
	
	@Override
	public double getDamage() {
		return this.tier.getAttackDamage();
	}
	
	static {
		ITEM_FOR_ARROW_TIER.put(ItemTier.IRON, ItemsTwo.IRON_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTier.WOOD, ItemsTwo.WOODEN_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTier.STONE, ItemsTwo.STONE_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTier.GOLD, ItemsTwo.GOLDEN_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTier.DIAMOND, ItemsTwo.DIAMOND_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTierTwo.EMERALD, ItemsTwo.EMERALD_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTierTwo.RUBY, ItemsTwo.RUBY_CAPPED_ARROW);
		ITEM_FOR_ARROW_TIER.put(ItemTierTwo.LEAD, ItemsTwo.LEAD_CAPPED_ARROW);
	}
}
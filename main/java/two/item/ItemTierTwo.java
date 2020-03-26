package two.item;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum ItemTierTwo implements IItemTier {
	RUBY(0, 0, 0.0f, 0.0f, 0, () -> {
		return Ingredient.fromItems(ItemsTwo.RUBY);
	}),
	LEAD(0, 0, 0.0f, 0.0f, 0, () -> {
		return Ingredient.fromItems(ItemsTwo.LEAD_INGOT);
	}),
	EMERALD(2 /*ItemTier.IRON.getHarvestLevel()*/, 131 /*stone*/, 12.0f /*gold*/, 2.0f /*iron*/, 22 /*gold*/, () -> {
		return Ingredient.fromItems(Items.EMERALD);
	}), // Attack speed of gold and attack damage of iron.
	// The only problem is that the only thing gold has over emerald is availability. 
	BLOOD_BLADE(0, 2048, 0.0f, 4.0f, 10, () -> {
		return Ingredient.fromItems(Items.WITHER_SKELETON_SKULL); // Blood
	});
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;

	private ItemTierTwo(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
		this.harvestLevel = harvestLevelIn;
	    this.maxUses = maxUsesIn;
	    this.efficiency = efficiencyIn;
	    this.attackDamage = attackDamageIn;
	    this.enchantability = enchantabilityIn;
	    this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}

	public int getMaxUses() {
		return this.maxUses;
	}
	public float getEfficiency() {
	    return this.efficiency;
	}
	public float getAttackDamage() {
	    return this.attackDamage;
	}
	public int getHarvestLevel() {
	    return this.harvestLevel;
	}
	public int getEnchantability() {
	    return this.enchantability;
	}
	public Ingredient getRepairMaterial() {
	    return this.repairMaterial.getValue();
	}
}

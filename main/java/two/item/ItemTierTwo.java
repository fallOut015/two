package two.item;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum ItemTierTwo implements IItemTier {
	EMERALD(2 /*ItemTier.IRON.getHarvestLevel()*/, 131 /*stone*/, 12.0f /*gold*/, 2.0f /*iron*/, 22 /*gold*/, () -> {
		return Ingredient.fromItems(Items.EMERALD);
	}), // Attack speed of gold and attack damage of iron.
	
	COBALT(3, 1910, 9.0f, 5.0f, 5, () -> { // End
		return Ingredient.fromItems(ItemsTwo.COBALT);
	}),
	JADE(4, 1900, 10.0f, 4.0f, 5, () -> { // End
		return Ingredient.fromItems(ItemsTwo.JADE);
	}),
	OPAL(1, 364, 6.0f, 3.0f, 22, () -> { // Overworld
		return Ingredient.fromItems(ItemsTwo.OPAL);
	}),
	TANZANITE(2, 1000, 8.0f, 3.0f, 20, () -> { // Overworld, savanna biomes. 
		return Ingredient.fromItems(ItemsTwo.TANZANITE);
	}),
	AMETHYST(3, 1810, 7.0f, 3.0f, 6, () -> { // Nether
		return Ingredient.fromItems(ItemsTwo.AMETHYST);
	}),
	GARNET(3, 1650, 7.0f, 3.0f, 7, () -> { // Nether
		return Ingredient.fromItems(ItemsTwo.GARNET);
	}),
	TOPAZ(3, 1675, 7.0f, 3.0f, 8, () -> { // Nether
		return Ingredient.fromItems(ItemsTwo.TOPAZ);
	}),
	SAPPHIRE(6, 5600, 10.0f, 6.0f, 10, () -> { // End
		return Ingredient.fromItems(ItemsTwo.SAPPHIRE);
	}),
	RUBY(3, 1061, 7.0F, 2.0F, 11, () -> { // Overworld
		return Ingredient.fromItems(ItemsTwo.RUBY);
	}),
	CELESTIUM(8, 8000, 11.0f, 6.0f, 7, () -> { // Nidavellir
		return Ingredient.fromItems(ItemsTwo.CELESTIUM);
	}),
	
	TALC(0, 0, 100.0f, 1.0f, 0, () -> { // Talcum poisoning effect. Overworld
		return Ingredient.fromItems(ItemsTwo.TALC);
	}),
	LEAD(1, 131, 5.0f, 2.0f, 14, () -> { // Lead poisoning effect. Nether
		return Ingredient.fromItems(ItemsTwo.LEAD_INGOT);
	}),
	TIN(1, 250, 6.0f, 2.0f, 5, () -> { // Overworld
		return Ingredient.fromItems(ItemsTwo.TIN_INGOT);
	}),
	ALUMINUM(1, 100, 7.0f, 1.0f, 4, () -> { // Overworld
		return Ingredient.fromItems(ItemsTwo.ALUMINUM_INGOT);
	}),
	SILVER(2, 222, 5.0f, 2.0f, 10, () -> { // Overworld
		return Ingredient.fromItems(ItemsTwo.SILVER_INGOT);
	}),
	COPPER(2, 275, 6.5f, 2.0f, 15, () -> { // Overworld
		return Ingredient.fromItems(ItemsTwo.COPPER_INGOT);
	}),
	PLATINUM(5, 1905, 7.0f, 4.0f, 10, () -> { // End
		return Ingredient.fromItems(ItemsTwo.PLATINUM_INGOT);
	}),
	TITANIUM(4, 1810, 6.0f, 3.0f, 15, () -> { // Nether
		return Ingredient.fromItems(ItemsTwo.TITANIUM_INGOT);
	}),
	PYRITE(0, 32, 12.0F, 0.0F, 22, () -> { // Behaves like gold. Overworld
		return Ingredient.fromItems(ItemsTwo.PYRITE_INGOT);
	}),
	STARSTONE(7, 7000, 10.0f, 5.0f, 8, () -> { // Nidavellir
		return Ingredient.fromItems(ItemsTwo.STARSTONE);
	}),
	URU(9, 9000, 12.0f, 7.0f, 6, () -> { // Nidavellir
		return Ingredient.fromItems(ItemsTwo.URU_INGOT);
	}),
	STEEL(5, 2100, 6.0f, 2.0f, 14, () -> { // Unnatural
		return Ingredient.fromItems(ItemsTwo.STEEL_INGOT);
	}),
	HARDENED_STEEL(6, 4200, 7.0f, 3.0f, 15, () -> { // Unnatural
		return Ingredient.fromItems(ItemsTwo.HARDENED_STEEL_INGOT);
	}),
	
	BLOOD_BLADE(0, 2048, 0.0f, 4.0f, 10, () -> {
		return Ingredient.fromItems(Items.BONE); // Blood
	}),
	MYRKYLITE(6, 6400, 9.0f, 4.0f, 9, () -> { // Stone in Nidavellir
		return Ingredient.fromItems(ItemsTwo.MYRKYLITE);
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

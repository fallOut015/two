package io.github.fallout015.two.data.server;

import java.util.function.Consumer;

import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.SingleItemRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.Tags;

public class RecipeProviderTwo extends RecipeProvider {
	public RecipeProviderTwo(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumerIn) {
//		buildChiseledBlockRecipes(ItemsTwo.CHISELED_DIAMOND_BLOCK, ItemsTwo.DIAMOND_SLAB, Items.DIAMOND_BLOCK, ItemsTwo.DIAMOND_PILLAR, consumerIn);
//		buildPillarRecipes(ItemsTwo.DIAMOND_PILLAR, Items.DIAMOND_BLOCK, ItemsTwo.CHISELED_DIAMOND_BLOCK, consumerIn);
//		buildOreStairRecipes(ItemsTwo.DIAMOND_STAIRS, ItemsTwo.CHISELED_DIAMOND_BLOCK, Items.DIAMOND_BLOCK, ItemsTwo.DIAMOND_PILLAR, consumerIn);
//		buildOreSlabRecipes(ItemsTwo.DIAMOND_SLAB, ItemsTwo.CHISELED_DIAMOND_BLOCK, Items.DIAMOND_BLOCK, ItemsTwo.DIAMOND_PILLAR, consumerIn);
//		buildSmeltingRecipe(ItemsTwo.SMOOTH_DIAMOND, Items.DIAMOND_BLOCK, 0.1f, 200, consumerIn);
//		buildSmoothOreStairRecipes(ItemsTwo.SMOOTH_DIAMOND_STAIRS, ItemsTwo.SMOOTH_DIAMOND, consumerIn);
//		buildSmoothOreSlabRecipes(ItemsTwo.SMOOTH_DIAMOND_SLAB, ItemsTwo.SMOOTH_DIAMOND, consumerIn);
//
//		buildChiseledBlockRecipes(ItemsTwo.CHISELED_EMERALD_BLOCK, ItemsTwo.EMERALD_SLAB, Items.EMERALD_BLOCK, ItemsTwo.EMERALD_PILLAR, consumerIn);
//		buildPillarRecipes(ItemsTwo.EMERALD_PILLAR, Items.EMERALD_BLOCK, ItemsTwo.CHISELED_EMERALD_BLOCK, consumerIn);
//		buildOreStairRecipes(ItemsTwo.EMERALD_STAIRS, ItemsTwo.CHISELED_EMERALD_BLOCK, Items.EMERALD_BLOCK, ItemsTwo.EMERALD_PILLAR, consumerIn);
//		buildOreSlabRecipes(ItemsTwo.EMERALD_SLAB, ItemsTwo.CHISELED_EMERALD_BLOCK, Items.EMERALD_BLOCK, ItemsTwo.EMERALD_PILLAR, consumerIn);
//		buildSmeltingRecipe(ItemsTwo.SMOOTH_EMERALD, Items.EMERALD_BLOCK, 0.1f, 200, consumerIn);
//		buildSmoothOreStairRecipes(ItemsTwo.SMOOTH_EMERALD_STAIRS, ItemsTwo.SMOOTH_EMERALD, consumerIn);
//		buildSmoothOreSlabRecipes(ItemsTwo.SMOOTH_EMERALD_SLAB, ItemsTwo.SMOOTH_EMERALD, consumerIn);
//
//		buildChiseledBlockRecipes(ItemsTwo.CHISELED_REDSTONE_BLOCK, ItemsTwo.REDSTONE_SLAB, Items.REDSTONE_BLOCK, ItemsTwo.REDSTONE_PILLAR, consumerIn);
//		buildPillarRecipes(ItemsTwo.REDSTONE_PILLAR, Items.REDSTONE_BLOCK, ItemsTwo.CHISELED_REDSTONE_BLOCK, consumerIn);
//		buildOreStairRecipes(ItemsTwo.REDSTONE_STAIRS, ItemsTwo.CHISELED_REDSTONE_BLOCK, Items.REDSTONE_BLOCK, ItemsTwo.REDSTONE_PILLAR, consumerIn);
//		buildOreSlabRecipes(ItemsTwo.REDSTONE_SLAB, ItemsTwo.CHISELED_REDSTONE_BLOCK, Items.REDSTONE_BLOCK, ItemsTwo.REDSTONE_PILLAR, consumerIn);
//		buildSmeltingRecipe(ItemsTwo.SMOOTH_REDSTONE, Items.REDSTONE_BLOCK, 0.1f, 200, consumerIn);
//		buildSmoothOreStairRecipes(ItemsTwo.SMOOTH_REDSTONE_STAIRS, ItemsTwo.SMOOTH_REDSTONE, consumerIn);
//		buildSmoothOreSlabRecipes(ItemsTwo.SMOOTH_REDSTONE_SLAB, ItemsTwo.SMOOTH_REDSTONE, consumerIn);
//
//		buildChiseledBlockRecipes(ItemsTwo.CHISELED_COAL_BLOCK, ItemsTwo.COAL_SLAB, Items.COAL_BLOCK, ItemsTwo.COAL_PILLAR, consumerIn);
//		buildPillarRecipes(ItemsTwo.COAL_PILLAR, Items.COAL_BLOCK, ItemsTwo.CHISELED_COAL_BLOCK, consumerIn);
//		buildOreStairRecipes(ItemsTwo.COAL_STAIRS, ItemsTwo.CHISELED_COAL_BLOCK, Items.COAL_BLOCK, ItemsTwo.COAL_PILLAR, consumerIn);
//		buildOreSlabRecipes(ItemsTwo.COAL_SLAB, ItemsTwo.CHISELED_COAL_BLOCK, Items.COAL_BLOCK, ItemsTwo.COAL_PILLAR, consumerIn);
//		buildSmeltingRecipe(ItemsTwo.SMOOTH_COAL, Items.COAL_BLOCK, 0.1f, 200, consumerIn);
//		buildSmoothOreStairRecipes(ItemsTwo.SMOOTH_COAL_STAIRS, ItemsTwo.SMOOTH_COAL, consumerIn);
//		buildSmoothOreSlabRecipes(ItemsTwo.SMOOTH_COAL_SLAB, ItemsTwo.SMOOTH_COAL, consumerIn);
	}
	
	public static void buildFenceRecipe(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 3)
			.patternLine("W#W")
			.patternLine("W#W")
			.key('#', Tags.Items.RODS_WOODEN)
			.key('W', base)
			.addCriterion(result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(base))
		.build(consumerIn);
	}
	public static void buildFenceGateRecipe(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result)
			.patternLine("#W#")
			.patternLine("#W#")
			.key('#', Tags.Items.RODS_WOODEN)
			.key('W', base)
			.addCriterion(result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(base))
		.build(consumerIn);
	}
	
	public static void buildDyeableEightRecipe(IItemProvider result, ITag<Item> base, IItemProvider dye, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 8)
			.patternLine("###")
			.patternLine("#$#")
			.patternLine("###")
			.key('#', base)
			.key('$', dye)
			.addCriterion(result.asItem().getRegistryName().getPath() + "_from_base", InventoryChangeTrigger.Instance.forItems(ItemPredicate.Builder.create().tag(base).build()))
		.build(consumerIn);
	}
	
	public static void buildOreBricks(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 4)
			.patternLine("##")
			.patternLine("##")
			.key('#', base)
			.addCriterion(result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(base))
		.build(consumerIn);
	}
	public static void buildOreBricksStonecutting(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		SingleItemRecipeBuilder.stonecuttingRecipe(
			Ingredient.fromItems(base), 
			result)
		.addCriterion(
			result.asItem().getRegistryName().getPath() + "_from_" + base.toString() + "_stonecutting",
			InventoryChangeTrigger.Instance.forItems(base)
		).build(
			consumerIn, 
			"two:" + result.asItem().getRegistryName().getPath() + "_from_" + base.toString() + "_stonecutting"
		);
	}
	
	public static void buildChiseledBlockRecipes(IItemProvider result, IItemProvider craftingbase, IItemProvider stonecuttingbase, IItemProvider pillar, Consumer<IFinishedRecipe> consumerIn) {
		buildChiseledBlockCrafting(result, craftingbase, stonecuttingbase, pillar, consumerIn);
		buildChiseledBlockStonecutting(result, stonecuttingbase, consumerIn);
	}
	public static void buildChiseledBlockCrafting(IItemProvider result, IItemProvider base, IItemProvider block, IItemProvider pillar, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result)
			.patternLine("#")
			.patternLine("#")
			.key('#', base)
			.addCriterion("has_" + result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(result))
			.addCriterion("has_" + block.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(block))
			.addCriterion("has_" + pillar.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(pillar))
		.build(consumerIn);
	}
	public static void buildChiseledBlockStonecutting(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		SingleItemRecipeBuilder.stonecuttingRecipe(
			Ingredient.fromItems(base), 
			result)
		.addCriterion(
			result.asItem().getRegistryName().getPath() + "_from_" + base.toString() + "_stonecutting",
			InventoryChangeTrigger.Instance.forItems(base)
		).build(
			consumerIn, 
			"two:" + result.asItem().getRegistryName().getPath() + "_from_" + base.toString() + "_stonecutting"
		);
	}
	
	public static void buildPillarRecipes(IItemProvider result, IItemProvider base, IItemProvider chiseled, Consumer<IFinishedRecipe> consumerIn) {
		buildPillarCrafting(result, base, chiseled, consumerIn);
		buildPillarStonecutting(result, base, consumerIn);
	}
	public static void buildPillarCrafting(IItemProvider result, IItemProvider base, IItemProvider chiseled, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result)
			.patternLine("#")
			.patternLine("#")
			.key('#', base)
			.addCriterion("has_" + chiseled.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(chiseled))
			.addCriterion("has_" + base.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(base))
			.addCriterion("has_" + result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(result))
		.build(consumerIn);
	}
	public static void buildPillarStonecutting(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		SingleItemRecipeBuilder.stonecuttingRecipe(
			Ingredient.fromItems(base), 
			result)
		.addCriterion(
			"has_" + base.toString(),
			InventoryChangeTrigger.Instance.forItems(base)
		).build(
			consumerIn, 
			"two:" + result.asItem().getRegistryName().getPath() + "_from_" + base.toString() + "_stonecutting"
		);
	}
	
	public static void buildOreStairRecipes(IItemProvider result, IItemProvider chiseledbase, IItemProvider base, IItemProvider pillarbase, Consumer<IFinishedRecipe> consumerIn) {
		buildOreStairCrafting(result, chiseledbase, base, pillarbase, consumerIn);
		buildOreStairStonecutting(result, base, consumerIn);
	}
	public static void buildOreStairCrafting(IItemProvider result, IItemProvider chiseledbase, IItemProvider base, IItemProvider pillarbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 4)
			.patternLine("#  ")
			.patternLine("## ")
			.patternLine("###")
			.key('#', Ingredient.fromItems(chiseledbase, base, pillarbase))
			.addCriterion("has_" + chiseledbase.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(chiseledbase))
			.addCriterion("has_" + base.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(base))
			.addCriterion("has_" + pillarbase.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(pillarbase))
		.build(consumerIn);
	}
	public static void buildOreStairStonecutting(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		SingleItemRecipeBuilder.stonecuttingRecipe(
			Ingredient.fromItems(base), 
			result
		).addCriterion(
			"has_" + base.toString(),
			InventoryChangeTrigger.Instance.forItems(base)
		).build(
			consumerIn, 
			"two:" + result.asItem().getRegistryName().getPath() + "_from_" + base.toString() + "_stonecutting"
		);
	}

	public static void buildOreSlabRecipes(IItemProvider result, IItemProvider chiseledbase, IItemProvider base, IItemProvider pillarbase, Consumer<IFinishedRecipe> consumerIn) {
		buildOreSlabCrafting(result, chiseledbase, base, pillarbase, consumerIn);
		buildOreSlabStonecutting(result, base, consumerIn);
	}
	public static void buildOreSlabCrafting(IItemProvider result, IItemProvider chiseledbase, IItemProvider base, IItemProvider pillarbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 6)
			.patternLine("###")
			.key('#', Ingredient.fromItems(chiseledbase, base, pillarbase))
			.addCriterion("has_" + chiseledbase.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(chiseledbase))
			.addCriterion("has_" + base.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(base))
			.addCriterion("has_" + pillarbase.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(pillarbase))
		.build(consumerIn);
	}
	public static void buildOreSlabStonecutting(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		SingleItemRecipeBuilder.stonecuttingRecipe(
			Ingredient.fromItems(base), 
			result,
			2
		).addCriterion(
			"has_" + base.toString(),
			InventoryChangeTrigger.Instance.forItems(base)
		).build(
			consumerIn, 
			"two:" + result.asItem().getRegistryName().getPath() + "_from_" + base.toString() + "_stonecutting"
		);
	}

	public static void buildSmoothOreSlabRecipes(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		buildSmoothOreSlabCrafting(result, base, consumerIn);
		buildSmoothOreSlabStonecutting(result, base, consumerIn);
	}
	public static void buildSmoothOreSlabCrafting(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 6)
			.patternLine("###")
			.key('#', base)
			.addCriterion("has_" + base.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(base))
		.build(consumerIn);
	}
	public static void buildSmoothOreSlabStonecutting(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		SingleItemRecipeBuilder.stonecuttingRecipe(
			Ingredient.fromItems(base), 
			result,
			2
		).addCriterion(
			"has_" + base.toString(),
			InventoryChangeTrigger.Instance.forItems(base)
		).build(
			consumerIn, 
			"two:" + result.asItem().getRegistryName().getPath() + "_from_" + base.toString() + "_stonecutting"
		);
	}

	public static void buildSmoothOreStairRecipes(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		buildSmoothOreStairCrafting(result, base, consumerIn);
		buildSmoothOreStairStonecutting(result, base, consumerIn);
	}
	public static void buildSmoothOreStairCrafting(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 4)
			.patternLine("#  ")
			.patternLine("## ")
			.patternLine("###")
			.key('#', base)
			.addCriterion("has_" + base.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(base))
		.build(consumerIn);
	}
	public static void buildSmoothOreStairStonecutting(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		SingleItemRecipeBuilder.stonecuttingRecipe(
			Ingredient.fromItems(base), 
			result
		).addCriterion(
			"has_" + base.toString(),
			InventoryChangeTrigger.Instance.forItems(base)
		).build(
			consumerIn, 
			"two:" + result.asItem().getRegistryName().getPath() + "_from_" + base.toString() + "_stonecutting"
		);
	}

	public static void buildSmeltingRecipe(IItemProvider result, IItemProvider base, float experience, int cookingtime, Consumer<IFinishedRecipe> consumerIn) {
		CookingRecipeBuilder.smeltingRecipe(
			Ingredient.fromItems(
				base
			), 
			result, 
			experience, 
			cookingtime
		).addCriterion(
			"has_" + base.toString(),
			InventoryChangeTrigger.Instance.forItems(base)
		).build(consumerIn);
	}
}
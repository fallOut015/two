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
import net.minecraft.item.Items;
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
//		buildWeaponRecipes(ItemsTwo.LEAD_SWORD, ItemsTwo.LEAD_BATTLEAXE, ItemsTwo.LEAD_DAGGER, ItemsTwo.LEAD_CAPPED_ARROW, ItemTagsTwo.INGOTS_LEAD, ItemsTwo.LEAD_INGOT, consumerIn);
//		buildToolRecipes(ItemsTwo.LEAD_SHOVEL, ItemsTwo.LEAD_PICKAXE, ItemsTwo.LEAD_HOE, ItemsTwo.LEAD_AXE, ItemsTwo.LEAD_SICKLE, ItemTagsTwo.INGOTS_LEAD, ItemsTwo.LEAD_INGOT, consumerIn);
//		buildArmorRecipes(ItemsTwo.LEAD_HELMET, ItemsTwo.LEAD_CHESTPLATE, ItemsTwo.LEAD_LEGGINGS, ItemsTwo.LEAD_BOOTS, ItemsTwo.LEAD_HORSE_ARMOR, ItemTagsTwo.INGOTS_LEAD, ItemsTwo.LEAD_INGOT, consumerIn);

//		buildStainedArmorRecipes(
//			ItemsTwo.BLACK_STAINED_WOODEN_HELMET, 
//			ItemsTwo.BLACK_STAINED_WOODEN_CHESTPLATE, 
//			ItemsTwo.BLACK_STAINED_WOODEN_LEGGINGS, 
//			ItemsTwo.BLACK_STAINED_WOODEN_BOOTS, 
//			ItemsTwo.BLACK_STAINED_WOODEN_PLANKS, 
//			consumerIn
//		);
		
//		buildChiseledBlockRecipes(ItemsTwo.CHISELED_NETHERITE_BLOCK, ItemsTwo.NETHERITE_SLAB, Items.NETHERITE_BRICKS, ItemsTwo.NETHERITE_PILLAR, consumerIn);
//		buildPillarRecipes(ItemsTwo.NETHERITE_PILLAR, Items.NETHERITE_BRICKS, ItemsTwo.CHISELED_NETHERITE_BLOCK, consumerIn);
//		buildOreStairRecipes(ItemsTwo.NETHERITE_STAIRS, ItemsTwo.CHISELED_NETHERITE_BLOCK, Items.NETHERITE_BRICKS, ItemsTwo.NETHERITE_PILLAR, consumerIn);
//		buildOreSlabRecipes(ItemsTwo.NETHERITE_SLAB, ItemsTwo.CHISELED_NETHERITE_BLOCK, Items.NETHERITE_BRICKS, ItemsTwo.NETHERITE_PILLAR, consumerIn);
//		buildSmeltingRecipe(ItemsTwo.SMOOTH_NETHERITE, Items.NETHERITE_BRICKS, 0.1f, 200, consumerIn);
//		buildSmoothOreStairRecipes(ItemsTwo.SMOOTH_NETHERITE_STAIRS, ItemsTwo.SMOOTH_NETHERITE, consumerIn);
//		buildSmoothOreSlabRecipes(ItemsTwo.SMOOTH_NETHERITE_SLAB, ItemsTwo.SMOOTH_NETHERITE, consumerIn);
//		buildOreBricksRecipes(ItemsTwo.NETHERITE_BRICKS, Items.NETHERITE_BRICKS, consumerIn);
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
	
	public static void buildOreBricksRecipes(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		buildOreBricksCrafting(result, base, consumerIn);
		buildOreBricksStonecutting(result, base, consumerIn);
	}
	public static void buildOreBricksCrafting(IItemProvider result, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
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
	
	public static void buildArmorRecipes(IItemProvider helmet, IItemProvider chestplate, IItemProvider leggings, IItemProvider boots, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		buildHelmetRecipe(helmet, base, "", consumerIn);
		buildChestplateRecipe(chestplate, base, "", consumerIn);
		buildLeggingsRecipe(leggings, base, "", consumerIn);
		buildBootsRecipe(boots, base, "", consumerIn);
	}
	public static void buildStainedArmorRecipes(IItemProvider helmet, IItemProvider chestplate, IItemProvider leggings, IItemProvider boots, IItemProvider base, Consumer<IFinishedRecipe> consumerIn) {
		buildHelmetRecipe(helmet, base, "wooden_helmet", consumerIn);
		buildChestplateRecipe(chestplate, base, "wooden_chestplate", consumerIn);
		buildLeggingsRecipe(leggings, base, "wooden_leggings", consumerIn);
		buildBootsRecipe(boots, base, "wooden_boots", consumerIn);
	}
	
	public static void buildHelmetRecipe(IItemProvider helmet, IItemProvider base, String group, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(helmet)
			.setGroup(group)
			.patternLine("XXX")
			.patternLine("X X")
			.key('X', base)
			.addCriterion("has_" + base.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(base))
		.build(consumerIn);
	}
	public static void buildChestplateRecipe(IItemProvider chestplate, IItemProvider base, String group, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(chestplate)
			.setGroup(group)
			.patternLine("X X")
			.patternLine("XXX")
			.patternLine("XXX")
			.key('X', base)
			.addCriterion("has_" + base.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(base))
		.build(consumerIn);
	}
	public static void buildLeggingsRecipe(IItemProvider leggings, IItemProvider base, String group, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(leggings)
			.setGroup(group)
			.patternLine("XXX")
			.patternLine("X X")
			.patternLine("X X")
			.key('X', base)
			.addCriterion("has_" + base.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(base))
		.build(consumerIn);
	}
	public static void buildBootsRecipe(IItemProvider boots, IItemProvider base, String group, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(boots)
			.setGroup(group)
			.patternLine("X X")
			.patternLine("X X")
			.key('X', base)
			.addCriterion("has_" + base.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(base))
		.build(consumerIn);
	}
	
	public static void buildWeaponRecipes(IItemProvider sword, IItemProvider battleaxe, IItemProvider dagger, IItemProvider cappedarrow, ITag<Item> base, IItemProvider advancmentbase, Consumer<IFinishedRecipe> consumerIn) {
		buildSwordRecipe(sword, base, advancmentbase, consumerIn);
		buildBattleaxeRecipe(battleaxe, base, advancmentbase, consumerIn);
		buildDaggerRecipe(dagger, base, advancmentbase, consumerIn);
		buildCappedArrowRecipe(cappedarrow, base, advancmentbase, consumerIn);
	}
	public static void buildSwordRecipe(IItemProvider result, ITag<Item> base, IItemProvider advancmentbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 1)
			.patternLine("X")
			.patternLine("X")
			.patternLine("#")
			.key('#', Tags.Items.RODS_WOODEN)
			.key('X', base)
			.addCriterion(result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(advancmentbase))
		.build(consumerIn);
	}
	public static void buildBattleaxeRecipe(IItemProvider result, ITag<Item> base, IItemProvider advancmentbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 1)
			.patternLine("XXX")
			.patternLine("X#X")
			.patternLine(" # ")
			.key('#', Tags.Items.RODS_WOODEN)
			.key('X', base)
			.addCriterion(result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(advancmentbase))
		.build(consumerIn);
	}
	public static void buildDaggerRecipe(IItemProvider result, ITag<Item> base, IItemProvider advancmentbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 1)
			.patternLine("X")
			.patternLine("#")
			.key('#', Tags.Items.RODS_WOODEN)
			.key('X', base)
			.addCriterion(result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(advancmentbase))
		.build(consumerIn);
	}
	public static void buildCappedArrowRecipe(IItemProvider result, ITag<Item> base, IItemProvider advancmentbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 4)
			.patternLine("X")
			.patternLine("#")
			.patternLine("Y")
			.key('#', Tags.Items.RODS_WOODEN)
			.key('X', base)
			.key('Y', Items.FEATHER)
			.addCriterion(result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(advancmentbase))
		.build(consumerIn);
	}
	
	public static void buildToolRecipes(IItemProvider shovel, IItemProvider pickaxe, IItemProvider hoe, IItemProvider axe, IItemProvider sickle, ITag<Item> base, IItemProvider advancmentbase, Consumer<IFinishedRecipe> consumerIn) {
		buildShovelRecipe(shovel, base, advancmentbase, consumerIn);
		buildPickaxeRecipe(pickaxe, base, advancmentbase, consumerIn);
		buildHoeRecipe(hoe, base, advancmentbase, consumerIn);
		buildAxeRecipe(axe, base, advancmentbase, consumerIn);
		buildSickleRecipe(sickle, base, advancmentbase, consumerIn);
	}
	public static void buildShovelRecipe(IItemProvider result, ITag<Item> base, IItemProvider advancmentbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 1)
			.patternLine("X")
			.patternLine("#")
			.patternLine("#")
			.key('#', Tags.Items.RODS_WOODEN)
			.key('X', base)
			.addCriterion(result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(advancmentbase))
		.build(consumerIn);
	}
	public static void buildPickaxeRecipe(IItemProvider result, ITag<Item> base, IItemProvider advancmentbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 1)
			.patternLine("XXX")
			.patternLine(" # ")
			.patternLine(" # ")
			.key('#', Tags.Items.RODS_WOODEN)
			.key('X', base)
			.addCriterion(result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(advancmentbase))
		.build(consumerIn);
	}
	public static void buildHoeRecipe(IItemProvider result, ITag<Item> base, IItemProvider advancmentbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 1)
			.patternLine("XX")
			.patternLine(" #")
			.patternLine(" #")
			.key('#', Tags.Items.RODS_WOODEN)
			.key('X', base)
			.addCriterion(result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(advancmentbase))
		.build(consumerIn);
	}
	public static void buildAxeRecipe(IItemProvider result, ITag<Item> base, IItemProvider advancmentbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 1)
			.patternLine("XX")
			.patternLine("X#")
			.patternLine(" #")
			.key('#', Tags.Items.RODS_WOODEN)
			.key('X', base)
			.addCriterion(result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(advancmentbase))
		.build(consumerIn);
	}
	public static void buildSickleRecipe(IItemProvider result, ITag<Item> base, IItemProvider advancmentbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(result, 1)
			.patternLine("XXX")
			.patternLine("  X")
			.patternLine(" # ")
			.key('#', Tags.Items.RODS_WOODEN)
			.key('X', base)
			.addCriterion(result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(advancmentbase))
		.build(consumerIn);
	}
	
	public static void buildArmorRecipes(IItemProvider helmet, IItemProvider chestplate, IItemProvider leggings, IItemProvider boots, IItemProvider horsearmor, ITag<Item> base, IItemProvider advancementbase, Consumer<IFinishedRecipe> consumerIn) {
		buildHelmetRecipe(helmet, base, advancementbase, consumerIn);
		buildChestplateRecipe(chestplate, base, advancementbase, consumerIn);
		buildLeggingsRecipe(leggings, base, advancementbase, consumerIn);
		buildBootsRecipe(boots, base, advancementbase, consumerIn);
		buildHorseArmorRecipe(horsearmor, base, advancementbase, consumerIn);
	}
	public static void buildHelmetRecipe(IItemProvider helmet, ITag<Item> base, IItemProvider advancementbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(helmet)
			.patternLine("XXX")
			.patternLine("X X")
			.key('X', base)
			.addCriterion("has_" + helmet.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(advancementbase))
		.build(consumerIn);
	}
	public static void buildChestplateRecipe(IItemProvider chestplate, ITag<Item> base, IItemProvider advancementbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(chestplate)
			.patternLine("X X")
			.patternLine("XXX")
			.patternLine("XXX")
			.key('X', base)
			.addCriterion("has_" + chestplate.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(advancementbase))
		.build(consumerIn);
	}
	public static void buildLeggingsRecipe(IItemProvider leggings, ITag<Item> base, IItemProvider advancementbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(leggings)
			.patternLine("XXX")
			.patternLine("X X")
			.patternLine("X X")
			.key('X', base)
			.addCriterion("has_" + leggings.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(advancementbase))
		.build(consumerIn);
	}
	public static void buildBootsRecipe(IItemProvider boots, ITag<Item> base, IItemProvider advancementbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(boots)
			.patternLine("XXX")
			.patternLine("X X")
			.patternLine("X X")
			.key('X', base)
			.addCriterion("has_" + boots.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(advancementbase))
		.build(consumerIn);
	}
	public static void buildHorseArmorRecipe(IItemProvider horsearmor, ITag<Item> base, IItemProvider advancementbase, Consumer<IFinishedRecipe> consumerIn) {
		ShapedRecipeBuilder
			.shapedRecipe(horsearmor)
			.patternLine("X X")
			.patternLine("XXX")
			.patternLine("X X")
			.key('X', base)
			.addCriterion("has_" + horsearmor.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(advancementbase))
		.build(consumerIn);
	}
}
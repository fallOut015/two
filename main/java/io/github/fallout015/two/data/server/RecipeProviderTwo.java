package io.github.fallout015.two.data.server;

import java.util.function.Consumer;

import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.Tags;

public class RecipeProviderTwo extends RecipeProvider {
	public RecipeProviderTwo(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
//		buildStainedFenceRecipe(ItemsTwo.WHITE_STAINED_WOODEN_FENCE, ItemsTwo.WHITE_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.ORANGE_STAINED_WOODEN_FENCE, ItemsTwo.ORANGE_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.MAGENTA_STAINED_WOODEN_FENCE, ItemsTwo.MAGENTA_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.LIGHT_BLUE_STAINED_WOODEN_FENCE, ItemsTwo.LIGHT_BLUE_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.YELLOW_STAINED_WOODEN_FENCE, ItemsTwo.YELLOW_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.LIME_STAINED_WOODEN_FENCE, ItemsTwo.LIME_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.PINK_STAINED_WOODEN_FENCE, ItemsTwo.PINK_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.GRAY_STAINED_WOODEN_FENCE, ItemsTwo.GRAY_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.LIGHT_GRAY_STAINED_WOODEN_FENCE, ItemsTwo.LIGHT_GRAY_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.CYAN_STAINED_WOODEN_FENCE, ItemsTwo.CYAN_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.PURPLE_STAINED_WOODEN_FENCE, ItemsTwo.PURPLE_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.BLUE_STAINED_WOODEN_FENCE, ItemsTwo.BLUE_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.BROWN_STAINED_WOODEN_FENCE, ItemsTwo.BROWN_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.GREEN_STAINED_WOODEN_FENCE, ItemsTwo.GREEN_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.RED_STAINED_WOODEN_FENCE, ItemsTwo.RED_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceRecipe(ItemsTwo.BLACK_STAINED_WOODEN_FENCE, ItemsTwo.BLACK_STAINED_WOODEN_PLANKS).build(consumer);
//
//		buildStainedFenceGateRecipe(ItemsTwo.WHITE_STAINED_WOODEN_FENCE_GATE, ItemsTwo.WHITE_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.ORANGE_STAINED_WOODEN_FENCE_GATE, ItemsTwo.ORANGE_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.MAGENTA_STAINED_WOODEN_FENCE_GATE, ItemsTwo.MAGENTA_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.LIGHT_BLUE_STAINED_WOODEN_FENCE_GATE, ItemsTwo.LIGHT_BLUE_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.YELLOW_STAINED_WOODEN_FENCE_GATE, ItemsTwo.YELLOW_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.LIME_STAINED_WOODEN_FENCE_GATE, ItemsTwo.LIME_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.PINK_STAINED_WOODEN_FENCE_GATE, ItemsTwo.PINK_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.GRAY_STAINED_WOODEN_FENCE_GATE, ItemsTwo.GRAY_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.LIGHT_GRAY_STAINED_WOODEN_FENCE_GATE, ItemsTwo.LIGHT_GRAY_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.CYAN_STAINED_WOODEN_FENCE_GATE, ItemsTwo.CYAN_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.PURPLE_STAINED_WOODEN_FENCE_GATE, ItemsTwo.PURPLE_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.BLUE_STAINED_WOODEN_FENCE_GATE, ItemsTwo.BLUE_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.BROWN_STAINED_WOODEN_FENCE_GATE, ItemsTwo.BROWN_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.GREEN_STAINED_WOODEN_FENCE_GATE, ItemsTwo.GREEN_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.RED_STAINED_WOODEN_FENCE_GATE, ItemsTwo.RED_STAINED_WOODEN_PLANKS).build(consumer);
//		buildStainedFenceGateRecipe(ItemsTwo.BLACK_STAINED_WOODEN_FENCE_GATE, ItemsTwo.BLACK_STAINED_WOODEN_PLANKS).build(consumer);
//	
//		buildDyeableEightRecipe(ItemsTwo.WHITE_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.WHITE_DYE).setGroup("stained_wooden_fence").build(consumer, "two:white_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.ORANGE_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.ORANGE_DYE).setGroup("stained_wooden_fence").build(consumer, "two:orange_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.MAGENTA_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.MAGENTA_DYE).setGroup("stained_wooden_fence").build(consumer, "two:magenta_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.LIGHT_BLUE_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.LIGHT_BLUE_DYE).setGroup("stained_wooden_fence").build(consumer, "two:light_blue_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.YELLOW_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.YELLOW_DYE).setGroup("stained_wooden_fence").build(consumer, "two:yellow_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.LIME_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.LIME_DYE).setGroup("stained_wooden_fence").build(consumer, "two:lime_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.PINK_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.PINK_DYE).setGroup("stained_wooden_fence").build(consumer, "two:pink_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.GRAY_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.GRAY_DYE).setGroup("stained_wooden_fence").build(consumer, "two:gray_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.LIGHT_GRAY_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.LIGHT_GRAY_DYE).setGroup("stained_wooden_fence").build(consumer, "two:light_gray_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.CYAN_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.CYAN_DYE).setGroup("stained_wooden_fence").build(consumer, "two:cyan_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.PURPLE_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.PURPLE_DYE).setGroup("stained_wooden_fence").build(consumer, "two:purple_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.BLUE_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.BLUE_DYE).setGroup("stained_wooden_fence").build(consumer, "two:blue_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.BROWN_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.BROWN_DYE).setGroup("stained_wooden_fence").build(consumer, "two:brown_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.GREEN_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.GREEN_DYE).setGroup("stained_wooden_fence").build(consumer, "two:green_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.RED_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.RED_DYE).setGroup("stained_wooden_fence").build(consumer, "two:red_stained_wooden_fence_from_base");
//		buildDyeableEightRecipe(ItemsTwo.BLACK_STAINED_WOODEN_FENCE, Tags.Items.FENCES_WOODEN, Items.BLACK_DYE).setGroup("stained_wooden_fence").build(consumer, "two:black_stained_wooden_fence_from_base");
//
//		buildDyeableEightRecipe(ItemsTwo.WHITE_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.WHITE_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:white_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.ORANGE_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.ORANGE_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:orange_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.MAGENTA_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.MAGENTA_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:magenta_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.LIGHT_BLUE_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.LIGHT_BLUE_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:light_blue_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.YELLOW_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.YELLOW_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:yellow_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.LIME_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.LIME_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:lime_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.PINK_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.PINK_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:pink_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.GRAY_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.GRAY_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:gray_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.LIGHT_GRAY_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.LIGHT_GRAY_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:light_gray_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.CYAN_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.CYAN_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:cyan_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.PURPLE_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.PURPLE_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:purple_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.BLUE_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.BLUE_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:blue_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.BROWN_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.BROWN_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:brown_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.GREEN_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.GREEN_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:green_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.RED_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.RED_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:red_stained_wooden_fence_gate_from_base");
//		buildDyeableEightRecipe(ItemsTwo.BLACK_STAINED_WOODEN_FENCE_GATE, Tags.Items.FENCE_GATES_WOODEN, Items.BLACK_DYE).setGroup("stained_wooden_fence_gate").build(consumer, "two:black_stained_wooden_fence_gate_from_base");
	}
	
	public static ShapedRecipeBuilder buildStainedFenceRecipe(IItemProvider result, IItemProvider base) {
		return buildFenceRecipe(result, base).setGroup("stained_wooden_fence");
	}
	public static ShapedRecipeBuilder buildStainedFenceGateRecipe(IItemProvider result, IItemProvider base) {
		return buildFenceGateRecipe(result, base).setGroup("stained_wooden_fence_gate");
	}
	
	public static ShapedRecipeBuilder buildFenceRecipe(IItemProvider result, IItemProvider base) {
		return ShapedRecipeBuilder
			.shapedRecipe(result, 3)
			.patternLine("W#W")
			.patternLine("W#W")
			.key('#', Tags.Items.RODS_WOODEN)
			.key('W', base)
			.addCriterion(result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(base));
	}
	public static ShapedRecipeBuilder buildFenceGateRecipe(IItemProvider result, IItemProvider base) {
		return ShapedRecipeBuilder
			.shapedRecipe(result)
			.patternLine("#W#")
			.patternLine("#W#")
			.key('#', Tags.Items.RODS_WOODEN)
			.key('W', base)
			.addCriterion(result.asItem().getRegistryName().getPath(), InventoryChangeTrigger.Instance.forItems(base));
	}
	
	public static ShapedRecipeBuilder buildDyeableEightRecipe(IItemProvider result, ITag<Item> base, IItemProvider dye) {
		return ShapedRecipeBuilder
			.shapedRecipe(result, 8)
			.patternLine("###")
			.patternLine("#$#")
			.patternLine("###")
			.key('#', base)
			.key('$', dye)
			.addCriterion(result.asItem().getRegistryName().getPath() + "_from_base", InventoryChangeTrigger.Instance.forItems(ItemPredicate.Builder.create().tag(base).build()));
	}
}
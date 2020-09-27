package io.github.fallout015.two.data;

import java.util.function.Consumer;

import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraftforge.common.Tags;

public class Recipes extends RecipeProvider {
	public Recipes(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		buildFenceRecipe(ItemsTwo.WHITE_STAINED_WOODEN_FENCE, ItemsTwo.WHITE_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.ORANGE_STAINED_WOODEN_FENCE, ItemsTwo.ORANGE_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.MAGENTA_STAINED_WOODEN_FENCE, ItemsTwo.MAGENTA_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.LIGHT_BLUE_STAINED_WOODEN_FENCE, ItemsTwo.LIGHT_BLUE_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.YELLOW_STAINED_WOODEN_FENCE, ItemsTwo.YELLOW_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.LIME_STAINED_WOODEN_FENCE, ItemsTwo.LIME_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.PINK_STAINED_WOODEN_FENCE, ItemsTwo.PINK_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.GRAY_STAINED_WOODEN_FENCE, ItemsTwo.GRAY_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.LIGHT_GRAY_STAINED_WOODEN_FENCE, ItemsTwo.LIGHT_GRAY_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.CYAN_STAINED_WOODEN_FENCE, ItemsTwo.CYAN_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.PURPLE_STAINED_WOODEN_FENCE, ItemsTwo.PURPLE_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.BLUE_STAINED_WOODEN_FENCE, ItemsTwo.BLUE_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.BROWN_STAINED_WOODEN_FENCE, ItemsTwo.BROWN_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.GREEN_STAINED_WOODEN_FENCE, ItemsTwo.GREEN_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.RED_STAINED_WOODEN_FENCE, ItemsTwo.RED_STAINED_WOODEN_PLANKS).build(consumer);
		buildFenceRecipe(ItemsTwo.BLACK_STAINED_WOODEN_FENCE, ItemsTwo.BLACK_STAINED_WOODEN_PLANKS).build(consumer);
	}
	
	public static ShapedRecipeBuilder buildFenceRecipe(Item result, Item base) {
		return ShapedRecipeBuilder.shapedRecipe(result).patternLine("W#W").patternLine("W#W").key('#', Tags.Items.RODS_WOODEN).key('W', base).setGroup("decorations");
	}
	public static ShapedRecipeBuilder buildFenceGateRecipe(Item result, Item base) {
		return ShapedRecipeBuilder.shapedRecipe(result).patternLine("#W#").patternLine("#W#").key('#', Tags.Items.RODS_WOODEN).key('W', base).setGroup("redstone");
	}
}
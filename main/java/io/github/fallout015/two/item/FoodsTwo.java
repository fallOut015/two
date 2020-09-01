package io.github.fallout015.two.item;

import net.minecraft.item.Food;

public class FoodsTwo {
	// Fruits
	public static final Food BANANA_BUNCH = (new Food.Builder()).hunger(3).saturation(0.3F).build();
	public static final Food BLUEBERRY = (new Food.Builder()).hunger(1).saturation(0.1F).build();
	public static final Food CORN = (new Food.Builder()).hunger(1).saturation(0.1F).build();
	public static final Food TOMATO = (new Food.Builder()).hunger(2).saturation(0.2F).build();
	// Vegetables

	// Meat
	
	// Fish
	
	// Pies
	public static final Food APPLE_PIE = (new Food.Builder()).hunger(8).saturation(0.4F).build();
	// Cookies
	public static final Food SUGAR_COOKIE = new Food.Builder().hunger(2).saturation(0.1f).build();
	// Cooked
	public static final Food TOAST = (new Food.Builder()).hunger(6).saturation(0.7F).build();
}
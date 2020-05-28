package two.item;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.util.SoundEventsTwo;

public enum ArmorMaterialTwo implements IArmorMaterial {
	EMERALD("emerald", 10, new int[] {2, 5, 6, 2}, 25, SoundEventsTwo.ITEM_ARMOR_EQUIP_EMERALD, 1.0f, () -> {
		return Ingredient.fromItems(Items.EMERALD);
	}),
	RUBY("ruby", 0, new int[] {0, 0, 0, 0}, 0, SoundEventsTwo.ITEM_ARMOR_EQUIP_RUBY, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.RUBY);
	}),
	LEAD("lead", 0, new int[] {0, 0, 0, 0}, 0, SoundEventsTwo.ITEM_ARMOR_EQUIP_LEAD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.LEAD_INGOT);
	}),
	
	STONE("stone", 10, new int[] {1, 4, 5, 2}, 6, SoundEventsTwo.ITEM_ARMOR_EQUIP_STONE, 1.0f, () -> {
		return Ingredient.fromItems(Items.COBBLESTONE);
	}),
	MYRKYLITE("myrkylite", 40, new int[] {3, 6, 8, 3}, 8, SoundEventsTwo.ITEM_ARMOR_EQUIP_MYRKYLITE, 4.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.MYRKYLITE);
	}),
	
	OAK("oak", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(Items.OAK_PLANKS);
	}),
	SPRUCE("spruce", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(Items.SPRUCE_PLANKS);
	}),
	BIRCH("birch", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(Items.BIRCH_PLANKS);
	}),
	JUNGLE("jungle", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(Items.JUNGLE_PLANKS);
	}),
	ACACIA("acacia", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(Items.ACACIA_PLANKS);
	}),
	DARK_OAK("dark_oak", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(Items.DARK_OAK_PLANKS);
	}),
	CHERRY("cherry", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.CHERRY_PLANKS);
	}),
	MAPLE("maple", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.MAPLE_PLANKS);
	}),
	GHOSTWOOD("ghostwood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.GHOSTWOOD_PLANKS);
	}),
	CLOUDWOOD("cloudwood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.CLOUDWOOD_PLANKS);
	}),
	BLACKBARK("blackbark", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.BLACKBARK_PLANKS);
	}),
	FROSTBARK("frostbark", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.FROSTBARK_PLANKS);
	}),
	
	WHITE_STAINED_WOOD("white_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.WHITE_STAINED_PLANKS);
	}),
	ORANGE_STAINED_WOOD("orange_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.ORANGE_STAINED_PLANKS);
	}),
	MAGENTA_STAINED_WOOD("magenta_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.MAGENTA_STAINED_PLANKS);
	}),
	LIGHT_BLUE_STAINED_WOOD("light_blue_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.LIGHT_BLUE_STAINED_PLANKS);
	}),
	YELLOW_STAINED_WOOD("yellow_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.YELLOW_STAINED_PLANKS);
	}),
	LIME_STAINED_WOOD("lime_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.LIME_STAINED_PLANKS);
	}),
	PINK_STAINED_WOOD("pink_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.PINK_STAINED_PLANKS);
	}),
	GRAY_STAINED_WOOD("gray_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.GRAY_STAINED_PLANKS);
	}),
	LIGHT_GRAY_STAINED_WOOD("light_gray_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.LIGHT_GRAY_STAINED_PLANKS);
	}),
	CYAN_STAINED_WOOD("cyan_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.CYAN_STAINED_PLANKS);
	}),
	PURPLE_STAINED_WOOD("purple_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.PURPLE_STAINED_PLANKS);
	}),
	BLUE_STAINED_WOOD("blue_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.BLUE_STAINED_PLANKS);
	}),
	BROWN_STAINED_WOOD("brown_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.BROWN_STAINED_PLANKS);
	}),
	GREEN_STAINED_WOOD("green_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.GREEN_STAINED_PLANKS);
	}),
	RED_STAINED_WOOD("red_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.RED_STAINED_PLANKS);
	}),
	BLACK_STAINED_WOOD("black_stained_wood", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOD, 0.0f, () -> {
		return Ingredient.fromItems(ItemsTwo.BLACK_STAINED_PLANKS);
	}),
	
	WHITE_WOOL("white_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	ORANGE_WOOL("orange_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	MAGENTA_WOOL("magenta_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	LIGHT_BLUE_WOOL("light_blue_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	YELLOW_WOOL("yellow_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	LIME_WOOL("lime_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	PINK_WOOL("pink_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	GRAY_WOOL("gray_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	LIGHT_GRAY_WOOL("light_gray_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	CYAN_WOOL("cyan_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	PURPLE_WOOL("purple_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	BLUE_WOOL("blue_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	BROWN_WOOL("brown_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	GREEN_WOOL("green_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	RED_WOOL("red_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	BLACK_WOOL("black_wool", 4, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_WOOL, 0.0f, () -> {
		return Ingredient.fromItems(Items.STRING);
	}),
	
	SPONGE("sponge", 5, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_SPONGE, 0.0f, () -> {
		return Ingredient.fromItems(Items.SPONGE);
	}),
	GLOWSTONE("glowstone", 5, new int[] {1, 2, 3, 1}, 10, SoundEventsTwo.ITEM_ARMOR_EQUIP_GLOWSTONE, 0.0f, () -> {
		return Ingredient.fromItems(Items.GLOWSTONE);
	}),
	OBSIDIAN("obsidian", 30, new int[] {3, 6, 8, 3}, 1, SoundEventsTwo.ITEM_ARMOR_EQUIP_OBSIDIAN, 0.0f, () -> {
		return Ingredient.fromItems(Items.OBSIDIAN);
	}),
	
	DOUBLE_JUMP_BOOTS("double_jump_boots", 5, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_DOUBLE_JUMP_BOOTS, 0.0f, () -> {
		return Ingredient.fromItems(Items.FEATHER);
	}),
	HERMES_HELMET("hermes_helmet", 5, new int[] {1, 2, 3, 1}, 5, SoundEventsTwo.ITEM_ARMOR_EQUIP_HERMES_HELMET, 0.0f, () -> {
		return Ingredient.fromItems(Items.FEATHER);
	});
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyValue<Ingredient> repairMaterial;

	private ArmorMaterialTwo(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float p_i48533_8_, Supplier<Ingredient> repairMaterialSupplier) {
		this.name = nameIn;
	    this.maxDamageFactor = maxDamageFactorIn;
	    this.damageReductionAmountArray = damageReductionAmountsIn;
	    this.enchantability = enchantabilityIn;
	    this.soundEvent = equipSoundIn;
	    this.toughness = p_i48533_8_;
	    this.repairMaterial = new LazyValue<>(repairMaterialSupplier);
	}
	
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}
	public int getEnchantability() {
	    return this.enchantability;
	}
	public SoundEvent getSoundEvent() {
	    return this.soundEvent;
	}
	public Ingredient getRepairMaterial() {
	    return this.repairMaterial.getValue();
	}
	@OnlyIn(Dist.CLIENT)
	public String getName() {
	    return this.name;
	}
	public float getToughness() {
	    return this.toughness;
	}
}
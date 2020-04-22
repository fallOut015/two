package two.item;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import two.block.BlocksTwo;
import two.entity.EntityTypeTwo;
import two.util.SoundEventsTwo;

@ObjectHolder("two")
public class ItemsTwo {
	// Not in creative inventory
	public static final Item TEST_BLOCK = register(BlocksTwo.TEST_BLOCK, new Item.Properties().rarity(Rarity.EPIC));
	public static final Item TEST_ITEM = register("test_item", new Item(new Item.Properties().rarity(Rarity.EPIC)));
	public static final Item COMMUNISM = register("communism", new Item(new Item.Properties().rarity(Rarity.EPIC)) {
		@Override
		public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
			tooltip.add(new StringTextComponent("OURcraft"));
		}
	});
	
//	public static final Item ANVIL = register(BlocksTwo.ANVIL, new Item.Properties().group(ItemGroup.DECORATIONS).rarity(Rarity.EPIC));
	
	
	
	// Building blocks 
	public static final Item ADOBE_WET = register(BlocksTwo.ADOBE_WET, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item ADOBE_DRY = register(BlocksTwo.ADOBE_DRY, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ADOBE_DRY_SLAB = register(BlocksTwo.ADOBE_DRY_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ADOBE_DRY_STAIRS = register(BlocksTwo.ADOBE_DRY_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item ADOBE_FROZEN = register(BlocksTwo.ADOBE_FROZEN, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ADOBE_FROZEN_SLAB = register(BlocksTwo.ADOBE_FROZEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ADOBE_FROZEN_STAIRS = register(BlocksTwo.ADOBE_FROZEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item CHERRY_PLANKS = register(BlocksTwo.CHERRY_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MAPLE_PLANKS = register(BlocksTwo.MAPLE_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GHOSTWOOD_PLANKS = register(BlocksTwo.GHOSTWOOD_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CLOUDWOOD_PLANKS = register(BlocksTwo.CLOUDWOOD_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLACKBARK_PLANKS = register(BlocksTwo.BLACKBARK_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item FROSTBARK_PLANKS = register(BlocksTwo.FROSTBARK_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item WHITE_STAINED_PLANKS = register(BlocksTwo.WHITE_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ORANGE_STAINED_PLANKS = register(BlocksTwo.ORANGE_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MAGENTA_STAINED_PLANKS = register(BlocksTwo.MAGENTA_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIGHT_BLUE_STAINED_PLANKS = register(BlocksTwo.LIGHT_BLUE_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item YELLOW_STAINED_PLANKS = register(BlocksTwo.YELLOW_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIME_STAINED_PLANKS = register(BlocksTwo.LIME_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PINK_STAINED_PLANKS = register(BlocksTwo.PINK_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GRAY_STAINED_PLANKS = register(BlocksTwo.GRAY_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIGHT_GRAY_STAINED_PLANKS = register(BlocksTwo.LIGHT_GRAY_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CYAN_STAINED_PLANKS = register(BlocksTwo.CYAN_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PURPLE_STAINED_PLANKS = register(BlocksTwo.PURPLE_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLUE_STAINED_PLANKS = register(BlocksTwo.BLUE_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BROWN_STAINED_PLANKS = register(BlocksTwo.BROWN_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GREEN_STAINED_PLANKS = register(BlocksTwo.GREEN_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item RED_STAINED_PLANKS = register(BlocksTwo.RED_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLACK_STAINED_PLANKS = register(BlocksTwo.BLACK_STAINED_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item CHERRY_LOG = register(BlocksTwo.CHERRY_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MAPLE_LOG = register(BlocksTwo.MAPLE_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GHOSTWOOD_LOG = register(BlocksTwo.GHOSTWOOD_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CLOUDWOOD_LOG = register(BlocksTwo.CLOUDWOOD_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLACKBARK_LOG = register(BlocksTwo.BLACKBARK_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item FROSTBARK_LOG = register(BlocksTwo.FROSTBARK_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item STRIPPED_CHERRY_LOG = register(BlocksTwo.STRIPPED_CHERRY_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STRIPPED_MAPLE_LOG = register(BlocksTwo.STRIPPED_MAPLE_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STRIPPED_GHOSTWOOD_LOG = register(BlocksTwo.STRIPPED_GHOSTWOOD_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STRIPPED_CLOUDWOOD_LOG = register(BlocksTwo.STRIPPED_CLOUDWOOD_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STRIPPED_BLACKBARK_LOG = register(BlocksTwo.STRIPPED_BLACKBARK_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STRIPPED_FROSTBARK_LOG = register(BlocksTwo.STRIPPED_FROSTBARK_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item CHERRY_WOOD = register(BlocksTwo.CHERRY_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MAPLE_WOOD = register(BlocksTwo.MAPLE_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GHOSTWOOD_WOOD = register(BlocksTwo.GHOSTWOOD_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CLOUDWOOD_WOOD = register(BlocksTwo.CLOUDWOOD_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLACKBARK_WOOD = register(BlocksTwo.BLACKBARK_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item FROSTBARK_WOOD = register(BlocksTwo.FROSTBARK_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item STRIPPED_CHERRY_WOOD = register(BlocksTwo.STRIPPED_CHERRY_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STRIPPED_MAPLE_WOOD = register(BlocksTwo.STRIPPED_MAPLE_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STRIPPED_GHOSTWOOD_WOOD = register(BlocksTwo.STRIPPED_GHOSTWOOD_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STRIPPED_CLOUDWOOD_WOOD = register(BlocksTwo.STRIPPED_CLOUDWOOD_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STRIPPED_BLACKBARK_WOOD = register(BlocksTwo.STRIPPED_BLACKBARK_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STRIPPED_FROSTBARK_WOOD = register(BlocksTwo.STRIPPED_FROSTBARK_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item CHERRY_SLAB = register(BlocksTwo.CHERRY_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MAPLE_SLAB = register(BlocksTwo.MAPLE_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GHOSTWOOD_SLAB = register(BlocksTwo.GHOSTWOOD_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CLOUDWOOD_SLAB = register(BlocksTwo.CLOUDWOOD_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLACKBARK_SLAB = register(BlocksTwo.BLACKBARK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item FROSTBARK_SLAB = register(BlocksTwo.FROSTBARK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item CHERRY_STAIRS = register(BlocksTwo.CHERRY_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MAPLE_STAIRS = register(BlocksTwo.MAPLE_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GHOSTWOOD_STAIRS = register(BlocksTwo.GHOSTWOOD_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CLOUDWOOD_STAIRS = register(BlocksTwo.CLOUDWOOD_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLACKBARK_STAIRS = register(BlocksTwo.BLACKBARK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item FROSTBARK_STAIRS = register(BlocksTwo.FROSTBARK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item WHITE_GLAZED_BRICKS = register(BlocksTwo.WHITE_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ORANGE_GLAZED_BRICKS = register(BlocksTwo.ORANGE_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MAGENTA_GLAZED_BRICKS = register(BlocksTwo.MAGENTA_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIGHT_BLUE_GLAZED_BRICKS = register(BlocksTwo.LIGHT_BLUE_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item YELLOW_GLAZED_BRICKS = register(BlocksTwo.YELLOW_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIME_GLAZED_BRICKS = register(BlocksTwo.LIME_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PINK_GLAZED_BRICKS = register(BlocksTwo.PINK_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GRAY_GLAZED_BRICKS = register(BlocksTwo.GRAY_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIGHT_GRAY_GLAZED_BRICKS = register(BlocksTwo.LIGHT_GRAY_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CYAN_GLAZED_BRICKS = register(BlocksTwo.CYAN_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PURPLE_GLAZED_BRICKS = register(BlocksTwo.PURPLE_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLUE_GLAZED_BRICKS = register(BlocksTwo.BLUE_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BROWN_GLAZED_BRICKS = register(BlocksTwo.BROWN_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GREEN_GLAZED_BRICKS = register(BlocksTwo.GREEN_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item RED_GLAZED_BRICKS = register(BlocksTwo.RED_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLACK_GLAZED_BRICKS = register(BlocksTwo.BLACK_GLAZED_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item GAULT = register(BlocksTwo.GAULT, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item NIGHTSTONE = register(BlocksTwo.NIGHTSTONE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item CLOUD = register(BlocksTwo.CLOUD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item COBALT_ORE = register(BlocksTwo.COBALT_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item JADE_ORE = register(BlocksTwo.JADE_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item OPAL_ORE = register(BlocksTwo.OPAL_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item TANZANITE_ORE = register(BlocksTwo.TANZANITE_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item AMETHYST_ORE = register(BlocksTwo.AMETHYST_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GARNET_ORE = register(BlocksTwo.GARNET_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item TOPAZ_ORE = register(BlocksTwo.TOPAZ_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SAPPHIRE_ORE = register(BlocksTwo.SAPPHIRE_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item RUBY_ORE = register(BlocksTwo.RUBY_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item COBALT_BLOCK = register(BlocksTwo.COBALT_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item JADE_BLOCK = register(BlocksTwo.JADE_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item OPAL_BLOCK = register(BlocksTwo.OPAL_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item TANZANITE_BLOCK = register(BlocksTwo.TANZANITE_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item AMETHYST_BLOCK = register(BlocksTwo.AMETHYST_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GARNET_BLOCK = register(BlocksTwo.GARNET_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item TOPAZ_BLOCK = register(BlocksTwo.TOPAZ_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SAPPHIRE_BLOCK = register(BlocksTwo.SAPPHIRE_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item RUBY_BLOCK = register(BlocksTwo.RUBY_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item TALC_ORE = register(BlocksTwo.TALC_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LEAD_ORE = register(BlocksTwo.LEAD_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item TIN_ORE = register(BlocksTwo.TIN_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ALUMINUM_ORE = register(BlocksTwo.ALUMINUM_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SILVER_ORE = register(BlocksTwo.SILVER_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item COPPER_ORE = register(BlocksTwo.COPPER_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PLATINUM_ORE = register(BlocksTwo.PLATINUM_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item TITANIUM_ORE = register(BlocksTwo.TITANIUM_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PYRITE_ORE = register(BlocksTwo.PYRITE_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item TALC_BLOCK = register(BlocksTwo.TALC_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LEAD_BLOCK = register(BlocksTwo.LEAD_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item TIN_BLOCK = register(BlocksTwo.TIN_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ALUMINUM_BLOCK = register(BlocksTwo.ALUMINUM_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SILVER_BLOCK = register(BlocksTwo.SILVER_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item COPPER_BLOCK = register(BlocksTwo.COPPER_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PLATINUM_BLOCK = register(BlocksTwo.PLATINUM_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item TITANIUM_BLOCK = register(BlocksTwo.TITANIUM_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PYRITE_BLOCK = register(BlocksTwo.PYRITE_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STEEL_BLOCK = register(BlocksTwo.STEEL_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item HARDENED_STEEL_BLOCK = register(BlocksTwo.HARDENED_STEEL_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item CHISELED_LAPIS_BLOCK = register(BlocksTwo.CHISELED_LAPIS_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LAPIS_PILLAR = register(BlocksTwo.LAPIS_PILLAR, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LAPIS_STAIRS = register(BlocksTwo.LAPIS_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LAPIS_SLAB = register(BlocksTwo.LAPIS_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SMOOTH_LAPIS = register(BlocksTwo.SMOOTH_LAPIS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SMOOTH_LAPIS_STAIRS = register(BlocksTwo.SMOOTH_LAPIS_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SMOOTH_LAPIS_SLAB = register(BlocksTwo.SMOOTH_LAPIS_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item CHISELED_IRON_BLOCK = register(BlocksTwo.CHISELED_IRON_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item IRON_PILLAR = register(BlocksTwo.IRON_PILLAR, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item IRON_STAIRS = register(BlocksTwo.IRON_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item IRON_SLAB = register(BlocksTwo.IRON_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SMOOTH_IRON = register(BlocksTwo.SMOOTH_IRON, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SMOOTH_IRON_STAIRS = register(BlocksTwo.SMOOTH_IRON_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SMOOTH_IRON_SLAB = register(BlocksTwo.SMOOTH_IRON_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item CHISELED_GOLD_BLOCK = register(BlocksTwo.CHISELED_GOLD_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GOLD_PILLAR = register(BlocksTwo.GOLD_PILLAR, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GOLD_STAIRS = register(BlocksTwo.GOLD_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GOLD_SLAB = register(BlocksTwo.GOLD_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SMOOTH_GOLD = register(BlocksTwo.SMOOTH_GOLD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SMOOTH_GOLD_STAIRS = register(BlocksTwo.SMOOTH_GOLD_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SMOOTH_GOLD_SLAB = register(BlocksTwo.SMOOTH_GOLD_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

	
	
	// Decoration
	public static final Item CHERRY_SAPLING = register(BlocksTwo.CHERRY_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item MAPLE_SAPLING = register(BlocksTwo.MAPLE_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item GHOSTWOOD_SAPLING = register(BlocksTwo.GHOSTWOOD_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item CLOUDWOOD_SAPLING = register(BlocksTwo.CLOUDWOOD_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item BLACKBARK_SAPLING = register(BlocksTwo.BLACKBARK_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item FROSTBARK_SAPLING = register(BlocksTwo.FROSTBARK_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	public static final Item CHERRY_LEAVES = register(BlocksTwo.CHERRY_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item MAPLE_LEAVES = register(BlocksTwo.MAPLE_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item GHOSTWOOD_LEAVES = register(BlocksTwo.GHOSTWOOD_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item CLOUDWOOD_LEAVES = register(BlocksTwo.CLOUDWOOD_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item BLACKBARK_LEAVES = register(BlocksTwo.BLACKBARK_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item FROSTBARK_LEAVES = register(BlocksTwo.FROSTBARK_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));

	public static final Item CHERRY_FENCE = register(BlocksTwo.CHERRY_FENCE, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item MAPLE_FENCE = register(BlocksTwo.MAPLE_FENCE, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item GHOSTWOOD_FENCE = register(BlocksTwo.GHOSTWOOD_FENCE, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item CLOUDWOOD_FENCE = register(BlocksTwo.CLOUDWOOD_FENCE, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item BLACKBARK_FENCE = register(BlocksTwo.BLACKBARK_FENCE, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item FROSTBARK_FENCE = register(BlocksTwo.FROSTBARK_FENCE, new Item.Properties().group(ItemGroup.DECORATIONS));

	public static final Item CHERRY_SIGN = register(BlocksTwo.CHERRY_SIGN, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item MAPLE_SIGN = register(BlocksTwo.MAPLE_SIGN, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item GHOSTWOOD_SIGN = register(BlocksTwo.GHOSTWOOD_SIGN, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item CLOUDWOOD_SIGN = register(BlocksTwo.CLOUDWOOD_SIGN, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item BLACKBARK_SIGN = register(BlocksTwo.BLACKBARK_SIGN, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item FROSTBARK_SIGN = register(BlocksTwo.FROSTBARK_SIGN, new Item.Properties().group(ItemGroup.DECORATIONS));

	public static final Item DREAMCATCHER_CHAOS = register(BlocksTwo.DREAMCATCHER_CHAOS, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item DREAMCATCHER_HEALING = register(BlocksTwo.DREAMCATCHER_HEALING, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item DREAMCATCHER_LOOT = register(BlocksTwo.DREAMCATCHER_LOOT, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item DREAMCATCHER_LUCKY = register(BlocksTwo.DREAMCATCHER_LUCKY, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item DREAMCATCHER_NIGHTMARE = register(BlocksTwo.DREAMCATCHER_NIGHTMARE, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item DREAMCATCHER_RAINBOW = register(BlocksTwo.DREAMCATCHER_RAINBOW, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item DREAMCATCHER_RANDOM = register(BlocksTwo.DREAMCATCHER_RANDOM, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item DREAMCATCHER_SKY = register(BlocksTwo.DREAMCATCHER_SKY, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	public static final Item MAPLE_TAP = register(BlocksTwo.MAPLE_TAP, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	public static final Item BILLBOARD = register(BlocksTwo.BILLBOARD, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item CONVEYER = register(BlocksTwo.CONVEYER, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	public static final Item UPHOLSTERY_TABLE = register(BlocksTwo.UPHOLSTERY_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	public static final Item CHAIR = register("chair", new ChairItem(BlocksTwo.CHAIR, new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final Item EDGE_STOOL = register("edge_stool", new Item(new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final Item ROUND_STOOL = register("round_stool", new Item(new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final Item EDGE_TABLE = register("edge_table", new EdgeTableItem(BlocksTwo.EDGE_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final Item ROUND_TABLE = register("round_table", new Item(new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final Item CUPBOARD = register("cupboard", new Item(new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final Item LAMP = register("lamp", new Item(new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final Item BED = register("bed", new Item(new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final Item COUCH = register("couch", new Item(new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final Item SHELF = register("shelf", new Item(new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	
	
	// Redstone
	public static final Item CHERRY_PRESSURE_PLATE = register(BlocksTwo.CHERRY_PRESSURE_PLATE, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item MAPLE_PRESSURE_PLATE = register(BlocksTwo.MAPLE_PRESSURE_PLATE, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item GHOSTWOOD_PRESSURE_PLATE = register(BlocksTwo.GHOSTWOOD_PRESSURE_PLATE, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item CLOUDWOOD_PRESSURE_PLATE = register(BlocksTwo.CLOUDWOOD_PRESSURE_PLATE, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item BLACKBARK_PRESSURE_PLATE = register(BlocksTwo.BLACKBARK_PRESSURE_PLATE, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item FROSTBARK_PRESSURE_PLATE = register(BlocksTwo.FROSTBARK_PRESSURE_PLATE, new Item.Properties().group(ItemGroup.REDSTONE));

	public static final Item CHERRY_TRAPDOOR = register(BlocksTwo.CHERRY_TRAPDOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item MAPLE_TRAPDOOR = register(BlocksTwo.MAPLE_TRAPDOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item GHOSTWOOD_TRAPDOOR = register(BlocksTwo.GHOSTWOOD_TRAPDOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item CLOUDWOOD_TRAPDOOR = register(BlocksTwo.CLOUDWOOD_TRAPDOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item BLACKBARK_TRAPDOOR = register(BlocksTwo.BLACKBARK_TRAPDOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item FROSTBARK_TRAPDOOR = register(BlocksTwo.FROSTBARK_TRAPDOOR, new Item.Properties().group(ItemGroup.REDSTONE));

	public static final Item CHERRY_FENCE_GATE = register(BlocksTwo.CHERRY_FENCE_GATE, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item MAPLE_FENCE_GATE = register(BlocksTwo.MAPLE_FENCE_GATE, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item GHOSTWOOD_FENCE_GATE = register(BlocksTwo.GHOSTWOOD_FENCE_GATE, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item CLOUDWOOD_FENCE_GATE = register(BlocksTwo.CLOUDWOOD_FENCE_GATE, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item BLACKBARK_FENCE_GATE = register(BlocksTwo.BLACKBARK_FENCE_GATE, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item FROSTBARK_FENCE_GATE = register(BlocksTwo.FROSTBARK_FENCE_GATE, new Item.Properties().group(ItemGroup.REDSTONE));
	
	public static final Item CHERRY_BUTTON = register(BlocksTwo.CHERRY_BUTTON, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item MAPLE_BUTTON = register(BlocksTwo.MAPLE_BUTTON, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item GHOSTWOOD_BUTTON = register(BlocksTwo.GHOSTWOOD_BUTTON, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item CLOUDWOOD_BUTTON = register(BlocksTwo.CLOUDWOOD_BUTTON, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item BLACKBARK_BUTTON = register(BlocksTwo.BLACKBARK_BUTTON, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item FROSTBARK_BUTTON = register(BlocksTwo.FROSTBARK_BUTTON, new Item.Properties().group(ItemGroup.REDSTONE));
	
	public static final Item CHERRY_DOOR = register(BlocksTwo.CHERRY_DOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item MAPLE_DOOR = register(BlocksTwo.MAPLE_DOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item GHOSTWOOD_DOOR = register(BlocksTwo.GHOSTWOOD_DOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item CLOUDWOOD_DOOR = register(BlocksTwo.CLOUDWOOD_DOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item BLACKBARK_DOOR = register(BlocksTwo.BLACKBARK_DOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item FROSTBARK_DOOR = register(BlocksTwo.FROSTBARK_DOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	
	
	
	// Transportation
	//public static final Item MAPLE_BOAT = register("maple_boat", new BoatItem(BoatEntityTwo.Type.MAPLE, new Item.Properties().group(ItemGroup.TRANSPORTATION)));
	public static final Item MAPLE_BOAT = register("maple_boat", new Item(new Item.Properties().group(ItemGroup.TRANSPORTATION)));
	public static final Item CHERRY_BOAT = register("cherry_boat", new Item(new Item.Properties().group(ItemGroup.TRANSPORTATION)));
	public static final Item GHOSTWOOD_BOAT = register("ghostwood_boat", new Item(new Item.Properties().group(ItemGroup.TRANSPORTATION)));
	public static final Item CLOUDWOOD_BOAT = register("cloudwood_boat", new Item(new Item.Properties().group(ItemGroup.TRANSPORTATION)));
	public static final Item BLACKBARK_BOAT = register("blackbark_boat", new Item(new Item.Properties().group(ItemGroup.TRANSPORTATION)));
	public static final Item FROSTBARK_BOAT = register("frostbark_boat", new Item(new Item.Properties().group(ItemGroup.TRANSPORTATION)));
	
	public static final Item OBSIDIAN_BOAT = register("obsidian_boat", new Item(new Item.Properties().group(ItemGroup.TRANSPORTATION)));
	
	
	
	// Misc
	public static final Item COBALT = register("cobalt", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item JADE = register("jade", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item OPAL = register("opal", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item TANZANITE = register("tanzanite", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item AMETHYST = register("amethyst", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item GARNET = register("garnet", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item TOPAZ = register("topaz", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item SAPPHIRE = register("sapphire", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item RUBY = register("ruby", new Item(new Item.Properties().group(ItemGroup.MISC)));
	
	public static final Item TALC = register("talc", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item LEAD_INGOT = register("lead_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item TIN_INGOT = register("tin_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item ALUMINUM_INGOT = register("aluminum_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item SILVER_INGOT = register("silver_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item COPPER_INGOT = register("copper_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item PLATINUM_INGOT = register("platinum_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item TITANIUM_INGOT = register("titanium_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item PYRITE_INGOT = register("pyrite_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item STEEL_INGOT = register("steel_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item HARDENED_STEEL_INGOT = register("hardened_steel_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	
    public static final Item CHAINMAIL_HORSE_ARMOR = register("chainmail_horse_armor", new HorseArmorItem(4, "chainmail", new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
	public static final Item EMERALD_HORSE_ARMOR = register("emerald_horse_armor", new HorseArmorItem(5, "emerald", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
	public static final Item RUBY_HORSE_ARMOR = register("ruby_horse_armor", new HorseArmorItem(11, "ruby", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
	public static final Item LEAD_HORSE_ARMOR = register("lead_horse_armor", new HorseArmorItem(5, "lead", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
	public static final Item STONE_HORSE_ARMOR = register("stone_horse_armor", new HorseArmorItem(4, "stone", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    
    public static final Item OAK_HORSE_ARMOR = register("oak_horse_armor", new HorseArmorItem(2, "oak", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item SPRUCE_HORSE_ARMOR = register("spruce_horse_armor", new HorseArmorItem(2, "spruce", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item BIRCH_HORSE_ARMOR = register("birch_horse_armor", new HorseArmorItem(2, "birch", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item JUNGLE_HORSE_ARMOR = register("jungle_horse_armor", new HorseArmorItem(2, "jungle", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item ACACIA_HORSE_ARMOR = register("acacia_horse_armor", new HorseArmorItem(2, "acacia", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item DARK_OAK_HORSE_ARMOR = register("dark_oak_horse_armor", new HorseArmorItem(2, "dark_oak", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item CHERRY_HORSE_ARMOR = register("cherry_horse_armor", new HorseArmorItem(2, "cherry", new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
    public static final Item MAPLE_HORSE_ARMOR = register("maple_horse_armor", new HorseArmorItem(2, "maple", new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
    public static final Item GHOSTWOOD_HORSE_ARMOR = register("ghostwood_horse_armor", new HorseArmorItem(2, "ghostwood", new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
    public static final Item CLOUDWOOD_HORSE_ARMOR = register("cloudwood_horse_armor", new HorseArmorItem(2, "cloudwood", new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
    public static final Item BLACKBARK_HORSE_ARMOR = register("blackbark_horse_armor", new HorseArmorItem(2, "blackbark", new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
    public static final Item FROSTBARK_HORSE_ARMOR = register("frostbark_horse_armor", new HorseArmorItem(2, "frostbark", new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
   
    public static final Item WHITE_STAINED_WOODEN_HORSE_ARMOR = register("white_stained_wooden_horse_armor", new HorseArmorItem(2, "white_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item ORANGE_STAINED_WOODEN_HORSE_ARMOR = register("orange_stained_wooden_horse_armor", new HorseArmorItem(2, "orange_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item MAGENTA_STAINED_WOODEN_HORSE_ARMOR = register("magenta_stained_wooden_horse_armor", new HorseArmorItem(2, "magenta_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item LIGHT_BLUE_STAINED_WOODEN_HORSE_ARMOR = register("light_blue_stained_wooden_horse_armor", new HorseArmorItem(2, "light_blue_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item YELLOW_STAINED_WOODEN_HORSE_ARMOR = register("yellow_stained_wooden_horse_armor", new HorseArmorItem(2, "yellow_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item LIME_STAINED_WOODEN_HORSE_ARMOR = register("lime_stained_wooden_horse_armor", new HorseArmorItem(2, "lime_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item PINK_STAINED_WOODEN_HORSE_ARMOR = register("pink_stained_wooden_horse_armor", new HorseArmorItem(2, "pink_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item GRAY_STAINED_WOODEN_HORSE_ARMOR = register("gray_stained_wooden_horse_armor", new HorseArmorItem(2, "gray_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item LIGHT_GRAY_STAINED_WOODEN_HORSE_ARMOR = register("light_gray_stained_wooden_horse_armor", new HorseArmorItem(2, "light_gray_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item CYAN_STAINED_WOODEN_HORSE_ARMOR = register("cyan_stained_wooden_horse_armor", new HorseArmorItem(2, "cyan_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item PURPLE_STAINED_WOODEN_HORSE_ARMOR = register("purple_stained_wooden_horse_armor", new HorseArmorItem(2, "purple_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item BLUE_STAINED_WOODEN_HORSE_ARMOR = register("blue_stained_wooden_horse_armor", new HorseArmorItem(2, "blue_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item BROWN_STAINED_WOODEN_HORSE_ARMOR = register("brown_stained_wooden_horse_armor", new HorseArmorItem(2, "brown_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item GREEN_STAINED_WOODEN_HORSE_ARMOR = register("green_stained_wooden_horse_armor", new HorseArmorItem(2, "green_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item RED_STAINED_WOODEN_HORSE_ARMOR = register("red_stained_wooden_horse_armor", new HorseArmorItem(2, "red_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item BLACK_STAINED_WOODEN_HORSE_ARMOR = register("black_stained_wooden_horse_armor", new HorseArmorItem(2, "black_stained_wood", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));

    public static final Item WHITE_WOOLEN_HORSE_ARMOR = register("white_woolen_horse_armor", new HorseArmorItem(3, "white_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item ORANGE_WOOLEN_HORSE_ARMOR = register("orange_woolen_horse_armor", new HorseArmorItem(3, "orange_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item MAGENTA_WOOLEN_HORSE_ARMOR = register("magenta_woolen_horse_armor", new HorseArmorItem(3, "magenta_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item LIGHT_BLUE_WOOLEN_HORSE_ARMOR = register("light_blue_woolen_horse_armor", new HorseArmorItem(3, "light_blue_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item YELLOW_WOOLEN_HORSE_ARMOR = register("yellow_woolen_horse_armor", new HorseArmorItem(3, "yellow_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item LIME_WOOLEN_HORSE_ARMOR = register("lime_woolen_horse_armor", new HorseArmorItem(3, "lime_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item PINK_WOOLEN_HORSE_ARMOR = register("pink_woolen_horse_armor", new HorseArmorItem(3, "pink_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item GRAY_WOOLEN_HORSE_ARMOR = register("gray_woolen_horse_armor", new HorseArmorItem(3, "gray_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item LIGHT_GRAY_WOOLEN_HORSE_ARMOR = register("light_gray_woolen_horse_armor", new HorseArmorItem(3, "light_gray_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item CYAN_WOOLEN_HORSE_ARMOR = register("cyan_woolen_horse_armor", new HorseArmorItem(3, "cyan_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item PURPLE_WOOLEN_HORSE_ARMOR = register("purple_woolen_horse_armor", new HorseArmorItem(3, "purple_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item BLUE_WOOLEN_HORSE_ARMOR = register("blue_woolen_horse_armor", new HorseArmorItem(3, "blue_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item BROWN_WOOLEN_HORSE_ARMOR = register("brown_woolen_horse_armor", new HorseArmorItem(3, "brown_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item GREEN_WOOLEN_HORSE_ARMOR = register("green_woolen_horse_armor", new HorseArmorItem(3, "green_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item RED_WOOLEN_HORSE_ARMOR = register("red_woolen_horse_armor", new HorseArmorItem(3, "red_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item BLACK_WOOLEN_HORSE_ARMOR = register("black_woolen_horse_armor", new HorseArmorItem(3, "black_wool", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    
    public static final Item SPONGE_HORSE_ARMOR = register("sponge_horse_armor", new SpongeHorseArmorItem(3, "sponge", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item GLOWSTONE_HORSE_ARMOR = register("glowstone_horse_armor", new HorseArmorItem(3, "glowstone", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    public static final Item OBSIDIAN_HORSE_ARMOR = register("obsidian_horse_armor", new HorseArmorItem(10, "obsidian", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));

    //public static final Item BACKPACK = register("backpack", new BackpackItem(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
    //backpack -> wearable, another tab of items
    //fanny pack -> wearable, displays extra row
    public static final Item KNAPSACK = register("knapsack", new KnapsackItem(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
    //potion sack -> displays extra potion slots
    //quiver -> displays extra arrow slots
    
    public static final Item CHAMELEON_SPAWN_EGG = register("chameleon_spawn_egg", new SpawnEggItem(EntityTypeTwo.CHAMELEON, 2162500, 14463743, new Item.Properties().group(ItemGroup.MISC)));
    
    public static final Item SNOWGLOBE = register("snowglobe", new SnowglobeItem(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
    public static final Item BALLOON = register("balloon", new Item(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)) {
    	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
    		if(entityIn instanceof PlayerEntity) {
    			if(((PlayerEntity) entityIn).getActiveItemStack().getItem() == ItemsTwo.BALLOON) {
    				((PlayerEntity) entityIn).setNoGravity(true);
    			}
    		}
    	};
    });
    
    public static final Item MUSIC_DISC_BAD_DREAMS = register("music_disc_bad_dreams", new MusicDiscItemTwo(13, SoundEventsTwo.MUSIC_NIGHTMARE, new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE)));
	
    public static final Item LETTER_A = register("letter_a", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_B = register("letter_b", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_C = register("letter_c", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_D = register("letter_d", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_E = register("letter_e", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_F = register("letter_f", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_G = register("letter_g", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_H = register("letter_h", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_I = register("letter_i", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_J = register("letter_j", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_K = register("letter_k", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_L = register("letter_l", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_M = register("letter_m", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_N = register("letter_n", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_O = register("letter_o", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_P = register("letter_p", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_Q = register("letter_q", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_R = register("letter_r", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_S = register("letter_s", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_T = register("letter_t", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_U = register("letter_u", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_V = register("letter_v", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_W = register("letter_w", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_X = register("letter_x", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_Y = register("letter_y", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item LETTER_Z = register("letter_z", new Item(new Item.Properties().group(ItemGroup.MISC)));

    public static final Item NUMBER_0 = register("number_0", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item NUMBER_1 = register("number_1", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item NUMBER_2 = register("number_2", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item NUMBER_3 = register("number_3", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item NUMBER_4 = register("number_4", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item NUMBER_5 = register("number_5", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item NUMBER_6 = register("number_6", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item NUMBER_7 = register("number_7", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item NUMBER_8 = register("number_8", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item NUMBER_9 = register("number_9", new Item(new Item.Properties().group(ItemGroup.MISC)));
    
    
	
	//Tools
    public static final Item EMERALD_SHOVEL = register("emerald_shovel", new ShovelItem(ItemTierTwo.EMERALD, 1.5f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item EMERALD_PICKAXE = register("emerald_pickaxe", new PickaxeItem(ItemTierTwo.EMERALD, 1, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item EMERALD_AXE = register("emerald_axe", new AxeItem(ItemTierTwo.EMERALD, 6.0f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item EMERALD_HOE = register("emerald_hoe", new HoeItem(ItemTierTwo.EMERALD, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));	

    public static final Item RUBY_SHOVEL = register("ruby_shovel", new ShovelItem(ItemTierTwo.RUBY, 1.5f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item RUBY_PICKAXE = register("ruby_pickaxe", new PickaxeItem(ItemTierTwo.RUBY, 1, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item RUBY_AXE = register("ruby_axe", new AxeItem(ItemTierTwo.RUBY, 6.0f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item RUBY_HOE = register("ruby_hoe", new HoeItem(ItemTierTwo.RUBY, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));	

    public static final Item LEAD_SHOVEL = register("lead_shovel", new ShovelItem(ItemTierTwo.LEAD, 1.5f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item LEAD_PICKAXE = register("lead_pickaxe", new PickaxeItem(ItemTierTwo.LEAD, 1, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item LEAD_AXE = register("lead_axe", new AxeItem(ItemTierTwo.LEAD, 6.0f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item LEAD_HOE = register("lead_hoe", new HoeItem(ItemTierTwo.LEAD, -2.0f, new Item.Properties().group(ItemGroup.TOOLS)));	

	public static final Item IRON_SICKLE = register("iron_sickle", new SickleItem(ItemTier.IRON, -1.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item WOODEN_SICKLE = register("wooden_sickle", new SickleItem(ItemTier.WOOD, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item STONE_SICKLE = register("stone_sickle", new SickleItem(ItemTier.STONE, -2.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item DIAMOND_SICKLE = register("diamond_sickle", new SickleItem(ItemTier.DIAMOND, 0.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item GOLDEN_SICKLE = register("golden_sickle", new SickleItem(ItemTier.GOLD, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item EMERALD_SICKLE = register("emerald_sickle", new SickleItem(ItemTierTwo.EMERALD, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item RUBY_SICKLE = register("ruby_sickle", new SickleItem(ItemTierTwo.RUBY, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item LEAD_SICKLE = register("lead_sickle", new SickleItem(ItemTierTwo.LEAD, -2.0f, new Item.Properties().group(ItemGroup.TOOLS)));

	public static final Item SMITHING_HAMMER = register("smithing_hammer", new Item(new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item HANDSAW = register("handsaw", new Item(new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item WRENCH = register("wrench", new Item(new Item.Properties().group(ItemGroup.TOOLS)) {
		public ActionResultType onItemUse(ItemUseContext context) {
			context.getWorld().setBlockState(context.getPos(), context.getWorld().getBlockState(context.getPos()).rotate(Rotation.CLOCKWISE_90));
			
			return ActionResultType.SUCCESS;
		};
	});
	// drill? or maybe the hammer will also serve this functionality.
	// add knockback to hammer and indicator.
	
	public static final Item CRAFTING_BOOK = register("crafting_book", new CraftingBookItem(new Item.Properties().group(ItemGroup.TOOLS)));
	// other books
	

	
	//Combat
	public static final Item EMERALD_SWORD = register("emerald_sword", new SwordItem(ItemTierTwo.EMERALD, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)));
	public static final Item RUBY_SWORD = register("ruby_sword", new SwordItem(ItemTierTwo.RUBY, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)));
	public static final Item LEAD_SWORD = register("lead_sword", new SwordItem(ItemTierTwo.LEAD, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)));
	
    public static final Item IRON_BATTLEAXE = register("iron_battleaxe", new BattleaxeItem(ItemTier.IRON, 6, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
	public static final Item WOODEN_BATTLEAXE = register("wooden_battleaxe", new BattleaxeItem(ItemTier.WOOD, 6, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item STONE_BATTLEAXE = register("stone_battleaxe", new BattleaxeItem(ItemTier.STONE, 7, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item DIAMOND_BATTLEAXE = register("diamond_battleaxe", new BattleaxeItem(ItemTier.DIAMOND, 5, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GOLDEN_BATTLEAXE = register("golden_battleaxe", new BattleaxeItem(ItemTier.GOLD, 6, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item EMERALD_BATTLEAXE = register("emerald_battleaxe", new BattleaxeItem(ItemTierTwo.EMERALD, 6, -2.4f, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item RUBY_BATTLEAXE = register("ruby_battleaxe", new BattleaxeItem(ItemTierTwo.RUBY, 0, -0.0F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LEAD_BATTLEAXE = register("lead_battleaxe", new BattleaxeItem(ItemTierTwo.LEAD, 0, -0.0F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    
    public static final Item IRON_DAGGER = register("iron_dagger", new DaggerItem(ItemTier.IRON, 1, -1.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
	public static final Item WOODEN_DAGGER = register("wooden_dagger", new DaggerItem(ItemTier.WOOD, 1, -1.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item STONE_DAGGER = register("stone_dagger", new DaggerItem(ItemTier.STONE, 1, -1.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item DIAMOND_DAGGER = register("diamond_dagger", new DaggerItem(ItemTier.DIAMOND, 1, -1.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GOLDEN_DAGGER = register("golden_dagger", new DaggerItem(ItemTier.GOLD, 1, -1.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item EMERALD_DAGGER = register("emerald_dagger", new DaggerItem(ItemTierTwo.EMERALD, 1, -1.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item RUBY_DAGGER = register("ruby_dagger", new DaggerItem(ItemTierTwo.RUBY, 1, -1.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LEAD_DAGGER = register("lead_dagger", new DaggerItem(ItemTierTwo.LEAD, 1, -1.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
	
    public static final Item CUTLASS = register("cutlass", new SwordItem(ItemTier.IRON, 3, -2.8f, new Item.Properties()/*.group(ItemGroup.COMBAT)*/) {
    	public net.minecraft.util.ActionResult<ItemStack> onItemRightClick(World worldIn, net.minecraft.entity.player.PlayerEntity playerIn, net.minecraft.util.Hand handIn) {
    		worldIn.playSound(playerIn, playerIn.getPosition(), SoundEventsTwo.MUSIC_NIGHTMARE, SoundCategory.MUSIC, 100.0f, 1.0f);
    		worldIn.playSound(playerIn, playerIn.getPosition(), SoundEventsTwo.ITEM_ARMOR_EQUIP_EMERALD, SoundCategory.NEUTRAL, 100.0f, 1.0f);
    		return ActionResult.func_226248_a_(playerIn.getActiveItemStack());
    	};
    });

    public static final Item BLOOD_WITHER_BLADE = register("blood_wither_blade", new SwordItem(ItemTierTwo.BLOOD_BLADE, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.RARE)) {
    	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    		target.addPotionEffect(new EffectInstance(Effects.WITHER, 50, 2, false, true));
    		return true;
    	}
    });
    public static final Item BLOOD_FLAME_BLADE = register("blood_flame_blade", new SwordItem(ItemTierTwo.BLOOD_BLADE, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.RARE)) {
    	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    		target.setFire(5);
    		return true;
    	}
    });
    public static final Item BLOOD_VENOM_BLADE = register("blood_venom_blade", new SwordItem(ItemTierTwo.BLOOD_BLADE, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.RARE)) {
    	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    		target.addPotionEffect(new EffectInstance(Effects.POISON, 50, 3, false, true));
    		return true;
    	}
    });
    public static final Item BANISHER = register("banisher", new BanisherItem(new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.RARE)));
    public static final Item STORMBREAKER = register("stormbreaker", new StormbreakerItem(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).rarity(Rarity.EPIC)));
    
    public static final Item IRON_CAPPED_ARROW = register("iron_capped_arrow", new CappedArrowItem(ItemTier.IRON, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item WOODEN_CAPPED_ARROW = register("wooden_capped_arrow", new CappedArrowItem(ItemTier.WOOD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item STONE_CAPPED_ARROW = register("stone_capped_arrow", new CappedArrowItem(ItemTier.STONE, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item GOLDEN_CAPPED_ARROW = register("golden_capped_arrow", new CappedArrowItem(ItemTier.GOLD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item DIAMOND_CAPPED_ARROW = register("diamond_capped_arrow", new CappedArrowItem(ItemTier.DIAMOND, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item EMERALD_CAPPED_ARROW = register("emerald_capped_arrow", new CappedArrowItem(ItemTierTwo.EMERALD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item RUBY_CAPPED_ARROW = register("ruby_capped_arrow", new CappedArrowItem(ItemTierTwo.RUBY, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item LEAD_CAPPED_ARROW = register("lead_capped_arrow", new CappedArrowItem(ItemTierTwo.LEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final Item EMERALD_HELMET = register("emerald_helmet", new ArmorItem(ArmorMaterialTwo.EMERALD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item EMERALD_CHESTPLATE = register("emerald_chestplate", new ArmorItem(ArmorMaterialTwo.EMERALD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item EMERALD_LEGGINGS = register("emerald_leggings", new ArmorItem(ArmorMaterialTwo.EMERALD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item EMERALD_BOOTS = register("emerald_boots", new ArmorItem(ArmorMaterialTwo.EMERALD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item RUBY_HELMET = register("ruby_helmet", new ArmorItem(ArmorMaterialTwo.RUBY, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item RUBY_CHESTPLATE = register("ruby_chestplate", new ArmorItem(ArmorMaterialTwo.RUBY, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item RUBY_LEGGINGS = register("ruby_leggings", new ArmorItem(ArmorMaterialTwo.RUBY, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item RUBY_BOOTS = register("ruby_boots", new ArmorItem(ArmorMaterialTwo.RUBY, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item LEAD_HELMET = register("lead_helmet", new ArmorItem(ArmorMaterialTwo.LEAD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LEAD_CHESTPLATE = register("lead_chestplate", new ArmorItem(ArmorMaterialTwo.LEAD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LEAD_LEGGINGS = register("lead_leggings", new ArmorItem(ArmorMaterialTwo.LEAD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LEAD_BOOTS = register("lead_boots", new ArmorItem(ArmorMaterialTwo.LEAD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item STONE_HELMET = register("stone_helmet", new ArmorItem(ArmorMaterialTwo.STONE, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item STONE_CHESTPLATE = register("stone_chestplate", new ArmorItem(ArmorMaterialTwo.STONE, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item STONE_LEGGINGS = register("stone_leggings", new ArmorItem(ArmorMaterialTwo.STONE, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item STONE_BOOTS = register("stone_boots", new ArmorItem(ArmorMaterialTwo.STONE, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item OAK_HELMET = register("oak_helmet", new ArmorItem(ArmorMaterialTwo.OAK, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item OAK_CHESTPLATE = register("oak_chestplate", new ArmorItem(ArmorMaterialTwo.OAK, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item OAK_LEGGINGS = register("oak_leggings", new ArmorItem(ArmorMaterialTwo.OAK, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item OAK_BOOTS = register("oak_boots", new ArmorItem(ArmorMaterialTwo.OAK, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item SPRUCE_HELMET = register("spruce_helmet", new ArmorItem(ArmorMaterialTwo.SPRUCE, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item SPRUCE_CHESTPLATE = register("spruce_chestplate", new ArmorItem(ArmorMaterialTwo.SPRUCE, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item SPRUCE_LEGGINGS = register("spruce_leggings", new ArmorItem(ArmorMaterialTwo.SPRUCE, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item SPRUCE_BOOTS = register("spruce_boots", new ArmorItem(ArmorMaterialTwo.SPRUCE, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item BIRCH_HELMET = register("birch_helmet", new ArmorItem(ArmorMaterialTwo.BIRCH, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BIRCH_CHESTPLATE = register("birch_chestplate", new ArmorItem(ArmorMaterialTwo.BIRCH, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BIRCH_LEGGINGS = register("birch_leggings", new ArmorItem(ArmorMaterialTwo.BIRCH, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BIRCH_BOOTS = register("birch_boots", new ArmorItem(ArmorMaterialTwo.BIRCH, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item JUNGLE_HELMET = register("jungle_helmet", new ArmorItem(ArmorMaterialTwo.JUNGLE, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item JUNGLE_CHESTPLATE = register("jungle_chestplate", new ArmorItem(ArmorMaterialTwo.JUNGLE, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item JUNGLE_LEGGINGS = register("jungle_leggings", new ArmorItem(ArmorMaterialTwo.JUNGLE, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item JUNGLE_BOOTS = register("jungle_boots", new ArmorItem(ArmorMaterialTwo.JUNGLE, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item ACACIA_HELMET = register("acacia_helmet", new ArmorItem(ArmorMaterialTwo.ACACIA, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item ACACIA_CHESTPLATE = register("acacia_chestplate", new ArmorItem(ArmorMaterialTwo.ACACIA, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item ACACIA_LEGGINGS = register("acacia_leggings", new ArmorItem(ArmorMaterialTwo.ACACIA, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item ACACIA_BOOTS = register("acacia_boots", new ArmorItem(ArmorMaterialTwo.ACACIA, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item DARK_OAK_HELMET = register("dark_oak_helmet", new ArmorItem(ArmorMaterialTwo.DARK_OAK, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item DARK_OAK_CHESTPLATE = register("dark_oak_chestplate", new ArmorItem(ArmorMaterialTwo.DARK_OAK, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item DARK_OAK_LEGGINGS = register("dark_oak_leggings", new ArmorItem(ArmorMaterialTwo.DARK_OAK, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item DARK_OAK_BOOTS = register("dark_oak_boots", new ArmorItem(ArmorMaterialTwo.DARK_OAK, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item MAPLE_HELMET = register("maple_helmet", new ArmorItem(ArmorMaterialTwo.MAPLE, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item MAPLE_CHESTPLATE = register("maple_chestplate", new ArmorItem(ArmorMaterialTwo.MAPLE, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item MAPLE_LEGGINGS = register("maple_leggings", new ArmorItem(ArmorMaterialTwo.MAPLE, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item MAPLE_BOOTS = register("maple_boots", new ArmorItem(ArmorMaterialTwo.MAPLE, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item CHERRY_HELMET = register("cherry_helmet", new ArmorItem(ArmorMaterialTwo.CHERRY, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item CHERRY_CHESTPLATE = register("cherry_chestplate", new ArmorItem(ArmorMaterialTwo.CHERRY, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item CHERRY_LEGGINGS = register("cherry_leggings", new ArmorItem(ArmorMaterialTwo.CHERRY, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item CHERRY_BOOTS = register("cherry_boots", new ArmorItem(ArmorMaterialTwo.CHERRY, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));
    
    public static final Item GHOSTWOOD_HELMET = register("ghostwood_helmet", new ArmorItem(ArmorMaterialTwo.GHOSTWOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GHOSTWOOD_CHESTPLATE = register("ghostwood_chestplate", new ArmorItem(ArmorMaterialTwo.GHOSTWOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GHOSTWOOD_LEGGINGS = register("ghostwood_leggings", new ArmorItem(ArmorMaterialTwo.GHOSTWOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GHOSTWOOD_BOOTS = register("ghostwood_boots", new ArmorItem(ArmorMaterialTwo.GHOSTWOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item CLOUDWOOD_HELMET = register("cloudwood_helmet", new ArmorItem(ArmorMaterialTwo.CLOUDWOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item CLOUDWOOD_CHESTPLATE = register("cloudwood_chestplate", new ArmorItem(ArmorMaterialTwo.CLOUDWOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item CLOUDWOOD_LEGGINGS = register("cloudwood_leggings", new ArmorItem(ArmorMaterialTwo.CLOUDWOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item CLOUDWOOD_BOOTS = register("cloudwood_boots", new ArmorItem(ArmorMaterialTwo.CLOUDWOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));
    
    public static final Item BLACKBARK_HELMET = register("blackbark_helmet", new ArmorItem(ArmorMaterialTwo.BLACKBARK, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLACKBARK_CHESTPLATE = register("blackbark_chestplate", new ArmorItem(ArmorMaterialTwo.BLACKBARK, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLACKBARK_LEGGINGS = register("blackbark_leggings", new ArmorItem(ArmorMaterialTwo.BLACKBARK, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLACKBARK_BOOTS = register("blackbark_boots", new ArmorItem(ArmorMaterialTwo.BLACKBARK, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item FROSTBARK_HELMET = register("frostbark_helmet", new ArmorItem(ArmorMaterialTwo.FROSTBARK, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item FROSTBARK_CHESTPLATE = register("frostbark_chestplate", new ArmorItem(ArmorMaterialTwo.FROSTBARK, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item FROSTBARK_LEGGINGS = register("frostbark_leggings", new ArmorItem(ArmorMaterialTwo.FROSTBARK, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item FROSTBARK_BOOTS = register("frostbark_boots", new ArmorItem(ArmorMaterialTwo.FROSTBARK, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item WHITE_STAINED_WOODEN_HELMET = register("white_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.WHITE_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item WHITE_STAINED_WOODEN_CHESTPLATE = register("white_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.WHITE_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item WHITE_STAINED_WOODEN_LEGGINGS = register("white_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.WHITE_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item WHITE_STAINED_WOODEN_BOOTS = register("white_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.WHITE_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));
    
    public static final Item ORANGE_STAINED_WOODEN_HELMET = register("orange_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.ORANGE_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item ORANGE_STAINED_WOODEN_CHESTPLATE = register("orange_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.ORANGE_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item ORANGE_STAINED_WOODEN_LEGGINGS = register("orange_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.ORANGE_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item ORANGE_STAINED_WOODEN_BOOTS = register("orange_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.ORANGE_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item MAGENTA_STAINED_WOODEN_HELMET = register("magenta_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.MAGENTA_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item MAGENTA_STAINED_WOODEN_CHESTPLATE = register("magenta_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.MAGENTA_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item MAGENTA_STAINED_WOODEN_LEGGINGS = register("magenta_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.MAGENTA_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item MAGENTA_STAINED_WOODEN_BOOTS = register("magenta_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.MAGENTA_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item LIGHT_BLUE_STAINED_WOODEN_HELMET = register("light_blue_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.LIGHT_BLUE_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIGHT_BLUE_STAINED_WOODEN_CHESTPLATE = register("light_blue_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.LIGHT_BLUE_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIGHT_BLUE_STAINED_WOODEN_LEGGINGS = register("light_blue_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.LIGHT_BLUE_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIGHT_BLUE_STAINED_WOODEN_BOOTS = register("light_blue_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.LIGHT_BLUE_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item YELLOW_STAINED_WOODEN_HELMET = register("yellow_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.YELLOW_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item YELLOW_STAINED_WOODEN_CHESTPLATE = register("yellow_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.YELLOW_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item YELLOW_STAINED_WOODEN_LEGGINGS = register("yellow_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.YELLOW_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item YELLOW_STAINED_WOODEN_BOOTS = register("yellow_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.YELLOW_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item LIME_STAINED_WOODEN_HELMET = register("lime_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.LIME_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIME_STAINED_WOODEN_CHESTPLATE = register("lime_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.LIME_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIME_STAINED_WOODEN_LEGGINGS = register("lime_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.LIME_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIME_STAINED_WOODEN_BOOTS = register("lime_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.LIME_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item PINK_STAINED_WOODEN_HELMET = register("pink_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.PINK_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item PINK_STAINED_WOODEN_CHESTPLATE = register("pink_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.PINK_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item PINK_STAINED_WOODEN_LEGGINGS = register("pink_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.PINK_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item PINK_STAINED_WOODEN_BOOTS = register("pink_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.PINK_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item GRAY_STAINED_WOODEN_HELMET = register("gray_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.GRAY_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GRAY_STAINED_WOODEN_CHESTPLATE = register("gray_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.GRAY_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GRAY_STAINED_WOODEN_LEGGINGS = register("gray_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.GRAY_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GRAY_STAINED_WOODEN_BOOTS = register("gray_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.GRAY_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item LIGHT_GRAY_STAINED_WOODEN_HELMET = register("light_gray_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.LIGHT_GRAY_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIGHT_GRAY_STAINED_WOODEN_CHESTPLATE = register("light_gray_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.LIGHT_GRAY_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIGHT_GRAY_STAINED_WOODEN_LEGGINGS = register("light_gray_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.LIGHT_GRAY_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIGHT_GRAY_STAINED_WOODEN_BOOTS = register("light_gray_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.LIGHT_GRAY_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item CYAN_STAINED_WOODEN_HELMET = register("cyan_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.CYAN_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item CYAN_STAINED_WOODEN_CHESTPLATE = register("cyan_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.CYAN_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item CYAN_STAINED_WOODEN_LEGGINGS = register("cyan_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.CYAN_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item CYAN_STAINED_WOODEN_BOOTS = register("cyan_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.CYAN_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item PURPLE_STAINED_WOODEN_HELMET = register("purple_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.PURPLE_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item PURPLE_STAINED_WOODEN_CHESTPLATE = register("purple_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.PURPLE_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item PURPLE_STAINED_WOODEN_LEGGINGS = register("purple_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.PURPLE_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item PURPLE_STAINED_WOODEN_BOOTS = register("purple_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.PURPLE_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item BLUE_STAINED_WOODEN_HELMET = register("blue_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.BLUE_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLUE_STAINED_WOODEN_CHESTPLATE = register("blue_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.BLUE_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLUE_STAINED_WOODEN_LEGGINGS = register("blue_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.BLUE_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLUE_STAINED_WOODEN_BOOTS = register("blue_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.BLUE_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item BROWN_STAINED_WOODEN_HELMET = register("brown_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.BROWN_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BROWN_STAINED_WOODEN_CHESTPLATE = register("brown_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.BROWN_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BROWN_STAINED_WOODEN_LEGGINGS = register("brown_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.BROWN_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BROWN_STAINED_WOODEN_BOOTS = register("brown_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.BROWN_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item GREEN_STAINED_WOODEN_HELMET = register("green_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.WHITE_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GREEN_STAINED_WOODEN_CHESTPLATE = register("green_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.WHITE_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GREEN_STAINED_WOODEN_LEGGINGS = register("green_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.WHITE_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GREEN_STAINED_WOODEN_BOOTS = register("green_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.WHITE_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item RED_STAINED_WOODEN_HELMET = register("red_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.RED_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item RED_STAINED_WOODEN_CHESTPLATE = register("red_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.RED_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item RED_STAINED_WOODEN_LEGGINGS = register("red_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.RED_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item RED_STAINED_WOODEN_BOOTS = register("red_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.RED_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item BLACK_STAINED_WOODEN_HELMET = register("black_stained_wooden_helmet", new ArmorItem(ArmorMaterialTwo.BLACK_STAINED_WOOD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLACK_STAINED_WOODEN_CHESTPLATE = register("black_stained_wooden_chestplate", new ArmorItem(ArmorMaterialTwo.BLACK_STAINED_WOOD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLACK_STAINED_WOODEN_LEGGINGS = register("black_stained_wooden_leggings", new ArmorItem(ArmorMaterialTwo.BLACK_STAINED_WOOD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLACK_STAINED_WOODEN_BOOTS = register("black_stained_wooden_boots", new ArmorItem(ArmorMaterialTwo.BLACK_STAINED_WOOD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));
    
    public static final Item WHITE_WOOLEN_HELMET = register("white_woolen_helmet", new ArmorItem(ArmorMaterialTwo.WHITE_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item WHITE_WOOLEN_CHESTPLATE = register("white_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.WHITE_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item WHITE_WOOLEN_LEGGINGS = register("white_woolen_leggings", new ArmorItem(ArmorMaterialTwo.WHITE_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item WHITE_WOOLEN_BOOTS = register("white_woolen_boots", new ArmorItem(ArmorMaterialTwo.WHITE_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item ORANGE_WOOLEN_HELMET = register("orange_woolen_helmet", new ArmorItem(ArmorMaterialTwo.ORANGE_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item ORANGE_WOOLEN_CHESTPLATE = register("orange_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.ORANGE_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item ORANGE_WOOLEN_LEGGINGS = register("orange_woolen_leggings", new ArmorItem(ArmorMaterialTwo.ORANGE_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item ORANGE_WOOLEN_BOOTS = register("orange_woolen_boots", new ArmorItem(ArmorMaterialTwo.ORANGE_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item MAGENTA_WOOLEN_HELMET = register("magenta_woolen_helmet", new ArmorItem(ArmorMaterialTwo.MAGENTA_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item MAGENTA_WOOLEN_CHESTPLATE = register("magenta_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.MAGENTA_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item MAGENTA_WOOLEN_LEGGINGS = register("magenta_woolen_leggings", new ArmorItem(ArmorMaterialTwo.MAGENTA_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item MAGENTA_WOOLEN_BOOTS = register("magenta_woolen_boots", new ArmorItem(ArmorMaterialTwo.MAGENTA_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item LIGHT_BLUE_WOOLEN_HELMET = register("light_blue_woolen_helmet", new ArmorItem(ArmorMaterialTwo.LIGHT_BLUE_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIGHT_BLUE_WOOLEN_CHESTPLATE = register("light_blue_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.LIGHT_BLUE_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIGHT_BLUE_WOOLEN_LEGGINGS = register("light_blue_woolen_leggings", new ArmorItem(ArmorMaterialTwo.LIGHT_BLUE_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIGHT_BLUE_WOOLEN_BOOTS = register("light_blue_woolen_boots", new ArmorItem(ArmorMaterialTwo.LIGHT_BLUE_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item YELLOW_WOOLEN_HELMET = register("yellow_woolen_helmet", new ArmorItem(ArmorMaterialTwo.YELLOW_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item YELLOW_WOOLEN_CHESTPLATE = register("yellow_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.YELLOW_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item YELLOW_WOOLEN_LEGGINGS = register("yellow_woolen_leggings", new ArmorItem(ArmorMaterialTwo.YELLOW_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item YELLOW_WOOLEN_BOOTS = register("yellow_woolen_boots", new ArmorItem(ArmorMaterialTwo.YELLOW_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item LIME_WOOLEN_HELMET = register("lime_woolen_helmet", new ArmorItem(ArmorMaterialTwo.LIME_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIME_WOOLEN_CHESTPLATE = register("lime_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.LIME_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIME_WOOLEN_LEGGINGS = register("lime_woolen_leggings", new ArmorItem(ArmorMaterialTwo.LIME_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIME_WOOLEN_BOOTS = register("lime_woolen_boots", new ArmorItem(ArmorMaterialTwo.LIME_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item PINK_WOOLEN_HELMET = register("pink_woolen_helmet", new ArmorItem(ArmorMaterialTwo.PINK_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item PINK_WOOLEN_CHESTPLATE = register("pink_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.PINK_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item PINK_WOOLEN_LEGGINGS = register("pink_woolen_leggings", new ArmorItem(ArmorMaterialTwo.PINK_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item PINK_WOOLEN_BOOTS = register("pink_woolen_boots", new ArmorItem(ArmorMaterialTwo.PINK_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item GRAY_WOOLEN_HELMET = register("gray_woolen_helmet", new ArmorItem(ArmorMaterialTwo.GRAY_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GRAY_WOOLEN_CHESTPLATE = register("gray_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.GRAY_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GRAY_WOOLEN_LEGGINGS = register("gray_woolen_leggings", new ArmorItem(ArmorMaterialTwo.GRAY_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GRAY_WOOLEN_BOOTS = register("gray_woolen_boots", new ArmorItem(ArmorMaterialTwo.GRAY_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item LIGHT_GRAY_WOOLEN_HELMET = register("light_gray_woolen_helmet", new ArmorItem(ArmorMaterialTwo.LIGHT_GRAY_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIGHT_GRAY_WOOLEN_CHESTPLATE = register("light_gray_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.LIGHT_GRAY_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIGHT_GRAY_WOOLEN_LEGGINGS = register("light_gray_woolen_leggings", new ArmorItem(ArmorMaterialTwo.LIGHT_GRAY_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LIGHT_GRAY_WOOLEN_BOOTS = register("light_gray_woolen_boots", new ArmorItem(ArmorMaterialTwo.LIGHT_GRAY_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item CYAN_WOOLEN_HELMET = register("cyan_woolen_helmet", new ArmorItem(ArmorMaterialTwo.CYAN_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item CYAN_WOOLEN_CHESTPLATE = register("cyan_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.CYAN_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item CYAN_WOOLEN_LEGGINGS = register("cyan_woolen_leggings", new ArmorItem(ArmorMaterialTwo.CYAN_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item CYAN_WOOLEN_BOOTS = register("cyan_woolen_boots", new ArmorItem(ArmorMaterialTwo.CYAN_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item PURPLE_WOOLEN_HELMET = register("purple_woolen_helmet", new ArmorItem(ArmorMaterialTwo.PURPLE_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item PURPLE_WOOLEN_CHESTPLATE = register("purple_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.PURPLE_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item PURPLE_WOOLEN_LEGGINGS = register("purple_woolen_leggings", new ArmorItem(ArmorMaterialTwo.PURPLE_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item PURPLE_WOOLEN_BOOTS = register("purple_woolen_boots", new ArmorItem(ArmorMaterialTwo.PURPLE_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item BLUE_WOOLEN_HELMET = register("blue_woolen_helmet", new ArmorItem(ArmorMaterialTwo.BLUE_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLUE_WOOLEN_CHESTPLATE = register("blue_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.BLUE_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLUE_WOOLEN_LEGGINGS = register("blue_woolen_leggings", new ArmorItem(ArmorMaterialTwo.BLUE_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLUE_WOOLEN_BOOTS = register("blue_woolen_boots", new ArmorItem(ArmorMaterialTwo.BLUE_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item BROWN_WOOLEN_HELMET = register("brown_woolen_helmet", new ArmorItem(ArmorMaterialTwo.BROWN_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BROWN_WOOLEN_CHESTPLATE = register("brown_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.BROWN_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BROWN_WOOLEN_LEGGINGS = register("brown_woolen_leggings", new ArmorItem(ArmorMaterialTwo.BROWN_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BROWN_WOOLEN_BOOTS = register("brown_woolen_boots", new ArmorItem(ArmorMaterialTwo.BROWN_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item GREEN_WOOLEN_HELMET = register("green_woolen_helmet", new ArmorItem(ArmorMaterialTwo.GREEN_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GREEN_WOOLEN_CHESTPLATE = register("green_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.GREEN_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GREEN_WOOLEN_LEGGINGS = register("green_woolen_leggings", new ArmorItem(ArmorMaterialTwo.GREEN_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GREEN_WOOLEN_BOOTS = register("green_woolen_boots", new ArmorItem(ArmorMaterialTwo.GREEN_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item RED_WOOLEN_HELMET = register("red_woolen_helmet", new ArmorItem(ArmorMaterialTwo.RED_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item RED_WOOLEN_CHESTPLATE = register("red_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.RED_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item RED_WOOLEN_LEGGINGS = register("red_woolen_leggings", new ArmorItem(ArmorMaterialTwo.RED_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item RED_WOOLEN_BOOTS = register("red_woolen_boots", new ArmorItem(ArmorMaterialTwo.RED_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item BLACK_WOOLEN_HELMET = register("black_woolen_helmet", new ArmorItem(ArmorMaterialTwo.BLACK_WOOL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLACK_WOOLEN_CHESTPLATE = register("black_woolen_chestplate", new ArmorItem(ArmorMaterialTwo.BLACK_WOOL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLACK_WOOLEN_LEGGINGS = register("black_woolen_leggings", new ArmorItem(ArmorMaterialTwo.BLACK_WOOL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item BLACK_WOOLEN_BOOTS = register("black_woolen_boots", new ArmorItem(ArmorMaterialTwo.BLACK_WOOL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    
    
    public static final Item SPONGE_HELMET = register("sponge_helmet", new SpongeArmorItem(ArmorMaterialTwo.SPONGE, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item SPONGE_CHESTPLATE = register("sponge_chestplate", new SpongeArmorItem(ArmorMaterialTwo.SPONGE, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item SPONGE_LEGGINGS = register("sponge_leggings", new SpongeArmorItem(ArmorMaterialTwo.SPONGE, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item SPONGE_BOOTS = register("sponge_boots", new SpongeArmorItem(ArmorMaterialTwo.SPONGE, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    
    
    public static final Item GLOWSTONE_HELMET = register("glowstone_helmet", new ArmorItem(ArmorMaterialTwo.GLOWSTONE, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)) {
    	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
    		// Lightning whatnot
    	}
    });
    public static final Item GLOWSTONE_CHESTPLATE = register("glowstone_chestplate", new ArmorItem(ArmorMaterialTwo.GLOWSTONE, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GLOWSTONE_LEGGINGS = register("glowstone_leggings", new ArmorItem(ArmorMaterialTwo.GLOWSTONE, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GLOWSTONE_BOOTS = register("glowstone_boots", new ArmorItem(ArmorMaterialTwo.GLOWSTONE, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    
   
    public static final Item OBSIDIAN_HELMET = register("obsidian_helmet", new ArmorItem(ArmorMaterialTwo.OBSIDIAN, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)) {
    	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
    		// Prevent the player from catching fire (or just put them out every tick that they are)
    	}
    });
    public static final Item OBSIDIAN_CHESTPLATE = register("obsidian_chestplate", new ArmorItem(ArmorMaterialTwo.OBSIDIAN, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item OBSIDIAN_LEGGINGS = register("obsidian_leggings", new ArmorItem(ArmorMaterialTwo.OBSIDIAN, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item OBSIDIAN_BOOTS = register("obsidian_boots", new ArmorItem(ArmorMaterialTwo.OBSIDIAN, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    // add balloon for toying around with setNoGravity
    // also setGlowing
    
    public static final Item TOP_HAT = register("top_hat", new TopHatItem(new Item.Properties().group(ItemGroup.COMBAT)));
    

    
    /*
    
    fanny pack
    quiver
    potion sack
    mulch
    dog food
    dowsing rod
    backfire curse
    clumsiness curse
    flimsiness curse
    heaviness curse
    disabler enchant
    lightning
    pyro
    tornado
    vines
    nether
    chill
    smoke bomb
    flash bomb
    confetti bomb
    cutlass
    ore capped-arrows
    bolt (replaces current arrow)
    ore maces
    ore longbows
    ore arbalests
    ore mattocks
    ore sickles
    handsaw
    ore smithing hammers
    whetstone
    jewelry
    speedy wagon
    spacious wagon
    roomy wagon
    stationary wagon
    food scraps
    necromancer's staff
    quartz tools
    
    */
    
    
    
	public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
//    	itemRegistryEvent.getRegistry().getValue(new ResourceLocation("minecraft", "command_block"))
		
		itemRegistryEvent.getRegistry().registerAll(Holder.ITEMSTWO.toArray(new Item[] {}));
    }
	static Item register(Block block, Item.Properties properties) {
		return register(block.getRegistryName().getPath(), new BlockItem(block, properties));
	}
	static Item register(String key, Item item) {
		Holder.ITEMSTWO.add(item.setRegistryName(key));
		
	    return item;
	}
	static class Holder {
		public static final LinkedList<Item> ITEMSTWO = new LinkedList<Item>();
	}
}
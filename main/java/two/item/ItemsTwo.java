package two.item;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import two.block.BlocksTwo;
import two.enchantment.EnchantmentsTwo;
import two.entity.EntityTypeTwo;
import two.entity.projectile.BombArrowEntity;
import two.entity.projectile.CappedArrowEntity;
import two.entity.projectile.FireArrowEntity;
import two.entity.projectile.IceArrowEntity;
import two.entity.projectile.ShockArrowEntity;
import two.fluid.FluidsTwo;
import two.util.SoundEventsTwo;
import two.world.dimension.DimensionTypeTwo;

@ObjectHolder("two")
public class ItemsTwo {
	// Not in creative inventory
//	public static final Item TEST_BLOCK = register(BlocksTwo.TEST_BLOCK, new Item.Properties().rarity(Rarity.EPIC));
//	public static final Item TEST_ITEM = register("test_item", new Item(new Item.Properties().rarity(Rarity.EPIC)));
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
	
	public static final Item PURPETAL_STEM = register(BlocksTwo.PURPETAL_STEM, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item CHERRY_PLANKS = register(BlocksTwo.CHERRY_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MAPLE_PLANKS = register(BlocksTwo.MAPLE_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GHOSTWOOD_PLANKS = register(BlocksTwo.GHOSTWOOD_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CLOUDWOOD_PLANKS = register(BlocksTwo.CLOUDWOOD_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLACKBARK_PLANKS = register(BlocksTwo.BLACKBARK_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item FROSTBARK_PLANKS = register(BlocksTwo.FROSTBARK_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item WHITE_STAINED_WOODEN_PLANKS = register(BlocksTwo.WHITE_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ORANGE_STAINED_WOODEN_PLANKS = register(BlocksTwo.ORANGE_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MAGENTA_STAINED_WOODEN_PLANKS = register(BlocksTwo.MAGENTA_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIGHT_BLUE_STAINED_WOODEN_PLANKS = register(BlocksTwo.LIGHT_BLUE_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item YELLOW_STAINED_WOODEN_PLANKS = register(BlocksTwo.YELLOW_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIME_STAINED_WOODEN_PLANKS = register(BlocksTwo.LIME_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PINK_STAINED_WOODEN_PLANKS = register(BlocksTwo.PINK_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GRAY_STAINED_WOODEN_PLANKS = register(BlocksTwo.GRAY_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIGHT_GRAY_STAINED_WOODEN_PLANKS = register(BlocksTwo.LIGHT_GRAY_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CYAN_STAINED_WOODEN_PLANKS = register(BlocksTwo.CYAN_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PURPLE_STAINED_WOODEN_PLANKS = register(BlocksTwo.PURPLE_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLUE_STAINED_WOODEN_PLANKS = register(BlocksTwo.BLUE_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BROWN_STAINED_WOODEN_PLANKS = register(BlocksTwo.BROWN_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GREEN_STAINED_WOODEN_PLANKS = register(BlocksTwo.GREEN_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item RED_STAINED_WOODEN_PLANKS = register(BlocksTwo.RED_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLACK_STAINED_WOODEN_PLANKS = register(BlocksTwo.BLACK_STAINED_WOODEN_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item WHITE_STAINED_WOODEN_SLAB = register(BlocksTwo.WHITE_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ORANGE_STAINED_WOODEN_SLAB = register(BlocksTwo.ORANGE_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MAGENTA_STAINED_WOODEN_SLAB = register(BlocksTwo.MAGENTA_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIGHT_BLUE_STAINED_WOODEN_SLAB = register(BlocksTwo.LIGHT_BLUE_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item YELLOW_STAINED_WOODEN_SLAB = register(BlocksTwo.YELLOW_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIME_STAINED_WOODEN_SLAB = register(BlocksTwo.LIME_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PINK_STAINED_WOODEN_SLAB = register(BlocksTwo.PINK_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GRAY_STAINED_WOODEN_SLAB = register(BlocksTwo.GRAY_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIGHT_GRAY_STAINED_WOODEN_SLAB = register(BlocksTwo.LIGHT_GRAY_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CYAN_STAINED_WOODEN_SLAB = register(BlocksTwo.CYAN_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PURPLE_STAINED_WOODEN_SLAB = register(BlocksTwo.PURPLE_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLUE_STAINED_WOODEN_SLAB = register(BlocksTwo.BLUE_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BROWN_STAINED_WOODEN_SLAB = register(BlocksTwo.BROWN_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GREEN_STAINED_WOODEN_SLAB = register(BlocksTwo.GREEN_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item RED_STAINED_WOODEN_SLAB = register(BlocksTwo.RED_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLACK_STAINED_WOODEN_SLAB = register(BlocksTwo.BLACK_STAINED_WOODEN_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item WHITE_STAINED_WOODEN_STAIRS = register(BlocksTwo.WHITE_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ORANGE_STAINED_WOODEN_STAIRS = register(BlocksTwo.ORANGE_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MAGENTA_STAINED_WOODEN_STAIRS = register(BlocksTwo.MAGENTA_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIGHT_BLUE_STAINED_WOODEN_STAIRS = register(BlocksTwo.LIGHT_BLUE_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item YELLOW_STAINED_WOODEN_STAIRS = register(BlocksTwo.YELLOW_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIME_STAINED_WOODEN_STAIRS = register(BlocksTwo.LIME_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PINK_STAINED_WOODEN_STAIRS = register(BlocksTwo.PINK_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GRAY_STAINED_WOODEN_STAIRS = register(BlocksTwo.GRAY_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIGHT_GRAY_STAINED_WOODEN_STAIRS = register(BlocksTwo.LIGHT_GRAY_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CYAN_STAINED_WOODEN_STAIRS = register(BlocksTwo.CYAN_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PURPLE_STAINED_WOODEN_STAIRS = register(BlocksTwo.PURPLE_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLUE_STAINED_WOODEN_STAIRS = register(BlocksTwo.BLUE_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BROWN_STAINED_WOODEN_STAIRS = register(BlocksTwo.BROWN_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GREEN_STAINED_WOODEN_STAIRS = register(BlocksTwo.GREEN_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item RED_STAINED_WOODEN_STAIRS = register(BlocksTwo.RED_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLACK_STAINED_WOODEN_STAIRS = register(BlocksTwo.BLACK_STAINED_WOODEN_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

	
	public static final Item CHERRY_LOG = register(BlocksTwo.CHERRY_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MAPLE_LOG = register(BlocksTwo.MAPLE_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GHOSTWOOD_LOG = register(BlocksTwo.GHOSTWOOD_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CLOUDWOOD_LOG = register(BlocksTwo.CLOUDWOOD_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLACKBARK_LOG = register(BlocksTwo.BLACKBARK_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item FROSTBARK_LOG = register(BlocksTwo.FROSTBARK_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item NEONDOT_STEM = register(BlocksTwo.NEONDOT_STEM, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BRIMSHINE_STEM = register(BlocksTwo.BRIMSHINE_STEM, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
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
	
	public static final Item WHITE_GLAZED_BRICK_SLAB = register(BlocksTwo.WHITE_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ORANGE_GLAZED_BRICK_SLAB = register(BlocksTwo.ORANGE_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MAGENTA_GLAZED_BRICK_SLAB = register(BlocksTwo.MAGENTA_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIGHT_BLUE_GLAZED_BRICK_SLAB = register(BlocksTwo.LIGHT_BLUE_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item YELLOW_GLAZED_BRICK_SLAB = register(BlocksTwo.YELLOW_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIME_GLAZED_BRICK_SLAB = register(BlocksTwo.LIME_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PINK_GLAZED_BRICK_SLAB = register(BlocksTwo.PINK_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GRAY_GLAZED_BRICK_SLAB = register(BlocksTwo.GRAY_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIGHT_GRAY_GLAZED_BRICK_SLAB = register(BlocksTwo.LIGHT_GRAY_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CYAN_GLAZED_BRICK_SLAB = register(BlocksTwo.CYAN_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PURPLE_GLAZED_BRICK_SLAB = register(BlocksTwo.PURPLE_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLUE_GLAZED_BRICK_SLAB = register(BlocksTwo.BLUE_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BROWN_GLAZED_BRICK_SLAB = register(BlocksTwo.BROWN_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GREEN_GLAZED_BRICK_SLAB = register(BlocksTwo.GREEN_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item RED_GLAZED_BRICK_SLAB = register(BlocksTwo.RED_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLACK_GLAZED_BRICK_SLAB = register(BlocksTwo.BLACK_GLAZED_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item WHITE_GLAZED_BRICK_STAIRS = register(BlocksTwo.WHITE_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ORANGE_GLAZED_BRICK_STAIRS = register(BlocksTwo.ORANGE_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MAGENTA_GLAZED_BRICK_STAIRS = register(BlocksTwo.MAGENTA_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIGHT_BLUE_GLAZED_BRICK_STAIRS = register(BlocksTwo.LIGHT_BLUE_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item YELLOW_GLAZED_BRICK_STAIRS = register(BlocksTwo.YELLOW_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIME_GLAZED_BRICK_STAIRS = register(BlocksTwo.LIME_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PINK_GLAZED_BRICK_STAIRS = register(BlocksTwo.PINK_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GRAY_GLAZED_BRICK_STAIRS = register(BlocksTwo.GRAY_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LIGHT_GRAY_GLAZED_BRICK_STAIRS = register(BlocksTwo.LIGHT_GRAY_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CYAN_GLAZED_BRICK_STAIRS = register(BlocksTwo.CYAN_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PURPLE_GLAZED_BRICK_STAIRS = register(BlocksTwo.PURPLE_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLUE_GLAZED_BRICK_STAIRS = register(BlocksTwo.BLUE_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BROWN_GLAZED_BRICK_STAIRS = register(BlocksTwo.BROWN_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GREEN_GLAZED_BRICK_STAIRS = register(BlocksTwo.GREEN_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item RED_GLAZED_BRICK_STAIRS = register(BlocksTwo.RED_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BLACK_GLAZED_BRICK_STAIRS = register(BlocksTwo.BLACK_GLAZED_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item GAULT = register(BlocksTwo.GAULT, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item NIGHTSTONE = register(BlocksTwo.NIGHTSTONE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item CLOUD = register(BlocksTwo.CLOUD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item REGOLITH = register(BlocksTwo.REGOLITH, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MYRKYLITE = register(BlocksTwo.MYRKYLITE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MYRKYLITE_SLAB = register(BlocksTwo.MYRKYLITE_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MYRKYLITE_STAIRS = register(BlocksTwo.MYRKYLITE_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item POLISHED_MYRKYLITE = register(BlocksTwo.POLISHED_MYRKYLITE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item POLISHED_MYRKYLITE_SLAB = register(BlocksTwo.POLISHED_MYRKYLITE_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item POLISHED_MYRKYLITE_STAIRS = register(BlocksTwo.POLISHED_MYRKYLITE_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item POLISHED_MYRKYLITE_BRICKS = register(BlocksTwo.POLISHED_MYRKYLITE_BRICKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item POLISHED_MYRKYLITE_BRICK_SLAB = register(BlocksTwo.POLISHED_MYRKYLITE_BRICK_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item POLISHED_MYRKYLITE_BRICK_STAIRS = register(BlocksTwo.POLISHED_MYRKYLITE_BRICK_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item SPORESTONE = register(BlocksTwo.SPORESTONE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SPORESTONE_SOIL = register(BlocksTwo.SPORESTONE_SOIL, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item SANGUINE = register(BlocksTwo.SANGUINE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CRIMSON = register(BlocksTwo.CRIMSON, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ABADDON = register(BlocksTwo.ABADDON, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item PERMAFROST_GRASS_BLOCK = register(BlocksTwo.PERMAFROST_GRASS_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PERMAFROST_DIRT = register(BlocksTwo.PERMAFROST_DIRT, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SILICATE = register(BlocksTwo.SILICATE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item EPIDOTE = register(BlocksTwo.EPIDOTE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MANTLE = register(BlocksTwo.MANTLE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item DESERT_COAL_ORE = register(BlocksTwo.DESERT_COAL_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item DESERT_IRON_ORE = register(BlocksTwo.DESERT_IRON_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item DESERT_GOLD_ORE = register(BlocksTwo.DESERT_GOLD_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item DESERT_COPPER_ORE = register(BlocksTwo.DESERT_COPPER_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item END_COBALT_ORE = register(BlocksTwo.END_COBALT_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item END_JADE_ORE = register(BlocksTwo.END_JADE_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item OPAL_ORE = register(BlocksTwo.OPAL_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item TANZANITE_ORE = register(BlocksTwo.TANZANITE_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item NETHER_AMETHYST_ORE = register(BlocksTwo.NETHER_AMETHYST_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item NETHER_GARNET_ORE = register(BlocksTwo.NETHER_GARNET_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item NETHER_TOPAZ_ORE = register(BlocksTwo.NETHER_TOPAZ_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item END_SAPPHIRE_ORE = register(BlocksTwo.END_SAPPHIRE_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item RUBY_ORE = register(BlocksTwo.RUBY_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item NIDAVELLIR_CELESTIUM_ORE = register(BlocksTwo.NIDAVELLIR_CELESTIUM_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item COBALT_BLOCK = register(BlocksTwo.COBALT_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item JADE_BLOCK = register(BlocksTwo.JADE_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item OPAL_BLOCK = register(BlocksTwo.OPAL_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item TANZANITE_BLOCK = register(BlocksTwo.TANZANITE_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item AMETHYST_BLOCK = register(BlocksTwo.AMETHYST_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GARNET_BLOCK = register(BlocksTwo.GARNET_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item TOPAZ_BLOCK = register(BlocksTwo.TOPAZ_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SAPPHIRE_BLOCK = register(BlocksTwo.SAPPHIRE_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item RUBY_BLOCK = register(BlocksTwo.RUBY_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item CELESTIUM_BLOCK = register(BlocksTwo.CELESTIUM_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item TALC_ORE = register(BlocksTwo.TALC_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item NETHER_LEAD_ORE = register(BlocksTwo.NETHER_LEAD_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item TIN_ORE = register(BlocksTwo.TIN_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ALUMINUM_ORE = register(BlocksTwo.ALUMINUM_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SILVER_ORE = register(BlocksTwo.SILVER_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item COPPER_ORE = register(BlocksTwo.COPPER_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item END_PLATINUM_ORE = register(BlocksTwo.END_PLATINUM_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item NETHER_TITANIUM_ORE = register(BlocksTwo.NETHER_TITANIUM_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PYRITE_ORE = register(BlocksTwo.PYRITE_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item NIDAVELLIR_STARSTONE_ORE = register(BlocksTwo.NIDAVELLIR_STARSTONE_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item NIDAVELLIR_URU_ORE = register(BlocksTwo.NIDAVELLIR_URU_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item TALC_BLOCK = register(BlocksTwo.TALC_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item LEAD_BLOCK = register(BlocksTwo.LEAD_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item TIN_BLOCK = register(BlocksTwo.TIN_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ALUMINUM_BLOCK = register(BlocksTwo.ALUMINUM_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item SILVER_BLOCK = register(BlocksTwo.SILVER_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item COPPER_BLOCK = register(BlocksTwo.COPPER_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PLATINUM_BLOCK = register(BlocksTwo.PLATINUM_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item TITANIUM_BLOCK = register(BlocksTwo.TITANIUM_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PYRITE_BLOCK = register(BlocksTwo.PYRITE_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STARSTONE_BLOCK = register(BlocksTwo.STARSTONE_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item URU_BLOCK = register(BlocksTwo.URU_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
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
	public static final Item PURPETAL = register(BlocksTwo.PURPETAL, new Item.Properties().group(ItemGroup.DECORATIONS));

	public static final Item SUCCULIGHT = register(BlocksTwo.SUCCULIGHT, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	public static final Item NEONDOT = register(BlocksTwo.NEONDOT, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item BRIMSHINE = register(BlocksTwo.BRIMSHINE, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	public static final Item SHROOMGLOW_LANTERN = register(BlocksTwo.SHROOMGLOW_LANTERN, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	public static final Item CHERRY_SAPLING = register(BlocksTwo.CHERRY_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item MAPLE_SAPLING = register(BlocksTwo.MAPLE_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item GHOSTWOOD_SAPLING = register(BlocksTwo.GHOSTWOOD_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item CLOUDWOOD_SAPLING = register(BlocksTwo.CLOUDWOOD_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item BLACKBARK_SAPLING = register(BlocksTwo.BLACKBARK_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item FROSTBARK_SAPLING = register(BlocksTwo.FROSTBARK_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	public static final Item PURPETAL_PETAL = register(BlocksTwo.PURPETAL_PETAL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item PURPETAL_PISTOL = register(BlocksTwo.PURPETAL_PISTOL, new Item.Properties().group(ItemGroup.DECORATIONS));

	public static final Item CHERRY_LEAVES = register(BlocksTwo.CHERRY_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item MAPLE_LEAVES = register(BlocksTwo.MAPLE_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item GHOSTWOOD_LEAVES = register(BlocksTwo.GHOSTWOOD_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item CLOUDWOOD_LEAVES = register(BlocksTwo.CLOUDWOOD_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item BLACKBARK_LEAVES = register(BlocksTwo.BLACKBARK_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item FROSTBARK_LEAVES = register(BlocksTwo.FROSTBARK_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));

	public static final Item NEONDOT_CAP = register(BlocksTwo.NEONDOT_CAP, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item BRIMSHINE_CAP = register(BlocksTwo.BRIMSHINE_CAP, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item SHROOMGLOW = register(BlocksTwo.SHROOMGLOW, new Item.Properties().group(ItemGroup.DECORATIONS));
	
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

	public static final Item ADOBE_DRY_WALL = register(BlocksTwo.ADOBE_DRY_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item ADOBE_FROZEN_WALL = register(BlocksTwo.ADOBE_FROZEN_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	public static final Item WHITE_GLAZED_BRICK_WALL = register(BlocksTwo.WHITE_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item ORANGE_GLAZED_BRICK_WALL = register(BlocksTwo.ORANGE_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item MAGENTA_GLAZED_BRICK_WALL = register(BlocksTwo.MAGENTA_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item LIGHT_BLUE_GLAZED_BRICK_WALL = register(BlocksTwo.LIGHT_BLUE_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item YELLOW_GLAZED_BRICK_WALL = register(BlocksTwo.YELLOW_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item LIME_GLAZED_BRICK_WALL = register(BlocksTwo.LIME_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item PINK_GLAZED_BRICK_WALL = register(BlocksTwo.PINK_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item GRAY_GLAZED_BRICK_WALL = register(BlocksTwo.GRAY_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item LIGHT_GRAY_GLAZED_BRICK_WALL = register(BlocksTwo.LIGHT_GRAY_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item CYAN_GLAZED_BRICK_WALL = register(BlocksTwo.CYAN_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item PURPLE_GLAZED_BRICK_WALL = register(BlocksTwo.PURPLE_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item BLUE_GLAZED_BRICK_WALL = register(BlocksTwo.BLUE_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item BROWN_GLAZED_BRICK_WALL = register(BlocksTwo.BROWN_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item GREEN_GLAZED_BRICK_WALL = register(BlocksTwo.GREEN_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item RED_GLAZED_BRICK_WALL = register(BlocksTwo.RED_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item BLACK_GLAZED_BRICK_WALL = register(BlocksTwo.BLACK_GLAZED_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	public static final Item MYRKYLITE_WALL = register(BlocksTwo.MYRKYLITE_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item POLISHED_MYRKYLITE_WALL = register(BlocksTwo.POLISHED_MYRKYLITE_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item POLISHED_MYRKYLITE_BRICK_WALL = register(BlocksTwo.POLISHED_MYRKYLITE_BRICK_WALL, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	public static final Item DREAMCATCHER_CHAOS = register(BlocksTwo.DREAMCATCHER_CHAOS, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item DREAMCATCHER_HEALING = register(BlocksTwo.DREAMCATCHER_HEALING, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item DREAMCATCHER_LOOT = register(BlocksTwo.DREAMCATCHER_LOOT, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item DREAMCATCHER_LUCKY = register(BlocksTwo.DREAMCATCHER_LUCKY, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item DREAMCATCHER_NIGHTMARE = register(BlocksTwo.DREAMCATCHER_NIGHTMARE, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item DREAMCATCHER_RAINBOW = register(BlocksTwo.DREAMCATCHER_RAINBOW, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item DREAMCATCHER_RANDOM = register(BlocksTwo.DREAMCATCHER_RANDOM, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item DREAMCATCHER_SKY = register(BlocksTwo.DREAMCATCHER_SKY, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	public static final Item MAPLE_TAP = register(BlocksTwo.MAPLE_TAP, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item GROUND_LIGHT = register(BlocksTwo.GROUND_LIGHT, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item BILLBOARD = register(BlocksTwo.BILLBOARD, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item CONVEYER = register(BlocksTwo.CONVEYER, new Item.Properties()/*.group(ItemGroup.DECORATIONS)*/);
	public static final Item ICE_SLIME_BLOCK = register(BlocksTwo.ICE_SLIME_BLOCK, new Item.Properties().group(ItemGroup.DECORATIONS));
	
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
	
	public static final Item STARSTONE_TORCH = register(new WallOrFloorItem(BlocksTwo.STARSTONE_TORCH, BlocksTwo.STARSTONE_WALL_TORCH, new Item.Properties().group(ItemGroup.DECORATIONS)));

	public static final Item FLAGSTONE_PATH = register(BlocksTwo.FLAGSTONE_PATH, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	
	
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
	public static final Item CELESTIUM = register("celestium", new Item(new Item.Properties().group(ItemGroup.MISC)));
	
	public static final Item TALC = register("talc", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item LEAD_INGOT = register("lead_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item TIN_INGOT = register("tin_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item ALUMINUM_INGOT = register("aluminum_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item SILVER_INGOT = register("silver_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item COPPER_INGOT = register("copper_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item PLATINUM_INGOT = register("platinum_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item TITANIUM_INGOT = register("titanium_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item PYRITE_INGOT = register("pyrite_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item STARSTONE = register("starstone", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item URU_INGOT = register("uru_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item STEEL_INGOT = register("steel_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item HARDENED_STEEL_INGOT = register("hardened_steel_ingot", new Item(new Item.Properties().group(ItemGroup.MISC)));
	
    public static final Item CHAINMAIL_HORSE_ARMOR = register("chainmail_horse_armor", new HorseArmorItem(4, "chainmail", new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
	public static final Item EMERALD_HORSE_ARMOR = register("emerald_horse_armor", new HorseArmorItem(5, "emerald", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
	public static final Item RUBY_HORSE_ARMOR = register("ruby_horse_armor", new HorseArmorItem(11, "ruby", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
	public static final Item LEAD_HORSE_ARMOR = register("lead_horse_armor", new HorseArmorItem(5, "lead", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
	public static final Item COPPER_HORSE_ARMOR = register("copper_horse_armor", new HorseArmorItem(6, "copper", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
	public static final Item STONE_HORSE_ARMOR = register("stone_horse_armor", new HorseArmorItem(4, "stone", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
	public static final Item MYRKYLITE_HORSE_ARMOR = register("myrkylite_horse_armor", new HorseArmorItem(4, "myrkylite", new Item.Properties().maxStackSize(1).group((ItemGroup.MISC))));
    
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
    public static final Item SMALL_BACKPACK = register("small_backpack", new BackpackItem(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item KNAPSACK = register("knapsack", new KnapsackItem(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
    //potion sack -> displays extra potion slots
    //quiver -> displays extra arrow slots
    public static final Item INSPECTION_SPECTACLES = register("inspection_spectacles", new InspectionSpectaclesItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    
    public static final Item CHAMELEON_SPAWN_EGG = register("chameleon_spawn_egg", new SpawnEggItem(EntityTypeTwo.CHAMELEON, 2162500, 14463743, new Item.Properties().group(ItemGroup.MISC)));
    public static final Item BEARDED_DRAGON_SPAWN_EGG = register("bearded_dragon_spawn_egg", new SpawnEggItem(EntityTypeTwo.BEARDED_DRAGON, 14397817, 15255450, new Item.Properties().group(ItemGroup.MISC)));
    public static final Item RED_PANDA_SPAWN_EGG = register("red_panda_spawn_egg", new SpawnEggItem(EntityTypeTwo.RED_PANDA, 3215619, 13847826, new Item.Properties().group(ItemGroup.MISC)));
    public static final Item DARK_DWARF_ARCHER_SPAWN_EGG = register("dark_dwarf_archer_spawn_egg", new SpawnEggItem(EntityTypeTwo.DARK_DWARF_ARCHER, 3617852, 7880467, new Item.Properties().group(ItemGroup.MISC)));
    public static final Item MUMMIFIED_ZOMBIE_SPAWN_EGG = register("mummified_zombie_spawn_egg", new SpawnEggItem(EntityTypeTwo.MUMMIFIED_ZOMBIE, 3490609, 13487798, new Item.Properties().group(ItemGroup.MISC)));
    public static final Item ICE_SLIME_SPAWN_EGG = register("ice_slime_spawn_egg", new SpawnEggItem(EntityTypeTwo.ICE_SLIME, 14606335, 16382719, new Item.Properties().group(ItemGroup.MISC)));
    
    public static final Item CHAMELEON_EYE = register("chameleon_eye", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final Item CHAMELEON_SKIN = register("chameleon_skin", new Item(new Item.Properties().group(ItemGroup.MISC)));
    
    public static final Item ICE_SLIME_BALL = register("ice_slime_ball", new Item(new Item.Properties().group(ItemGroup.MISC)));
    
    public static final Item SNOWGLOBE = register("snowglobe", new SnowglobeItem(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
    
    public static final Item REGOLITH_DUST = register("regolith_dust", new Item(new Item.Properties().group(ItemGroup.MISC)  ) {
    	public net.minecraft.util.ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, net.minecraft.util.Hand handIn) {
			playerIn.changeDimension(DimensionTypeTwo.NIDAVELLIR, new ITeleporter() {
				public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
					return repositionEntity.apply(false);
				}
			});

    		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
    	};
    });
    
    public static final Item MUSIC_DISC_BAD_DREAMS = register("music_disc_bad_dreams", new MusicDiscItemTwo(13, SoundEventsTwo.MUSIC_NIGHTMARE, new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE)));
    public static final Item MUSIC_DISC_REALM_NINE = register("music_disc_realm_nine", new MusicDiscItemTwo(14, SoundEventsTwo.MUSIC_NIGHTMARE, new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE)));
	
    public static final Item MUD_BUCKET = register("mud_bucket", new BucketItem(() -> FluidsTwo.MUD, new Item.Properties().group(ItemGroup.MISC)));
    
    public static final Item LETTER_A = register(BlocksTwo.LETTER_A, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_B = register(BlocksTwo.LETTER_B, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_C = register(BlocksTwo.LETTER_C, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_D = register(BlocksTwo.LETTER_D, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_E = register(BlocksTwo.LETTER_E, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_F = register(BlocksTwo.LETTER_F, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_G = register(BlocksTwo.LETTER_G, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_H = register(BlocksTwo.LETTER_H, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_I = register(BlocksTwo.LETTER_I, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_J = register(BlocksTwo.LETTER_J, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_K = register(BlocksTwo.LETTER_K, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_L = register(BlocksTwo.LETTER_L, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_M = register(BlocksTwo.LETTER_M, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_N = register(BlocksTwo.LETTER_N, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_O = register(BlocksTwo.LETTER_O, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_P = register(BlocksTwo.LETTER_P, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_Q = register(BlocksTwo.LETTER_Q, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_R = register(BlocksTwo.LETTER_R, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_S = register(BlocksTwo.LETTER_S, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_T = register(BlocksTwo.LETTER_T, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_U = register(BlocksTwo.LETTER_U, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_V = register(BlocksTwo.LETTER_V, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_W = register(BlocksTwo.LETTER_W, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_X = register(BlocksTwo.LETTER_X, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_Y = register(BlocksTwo.LETTER_Y, new Item.Properties().group(ItemGroup.MISC));
    public static final Item LETTER_Z = register(BlocksTwo.LETTER_Z, new Item.Properties().group(ItemGroup.MISC));

    public static final Item NUMBER_0 = register(BlocksTwo.NUMBER_0, new Item.Properties().group(ItemGroup.MISC));
    public static final Item NUMBER_1 = register(BlocksTwo.NUMBER_1, new Item.Properties().group(ItemGroup.MISC));
    public static final Item NUMBER_2 = register(BlocksTwo.NUMBER_2, new Item.Properties().group(ItemGroup.MISC));
    public static final Item NUMBER_3 = register(BlocksTwo.NUMBER_3, new Item.Properties().group(ItemGroup.MISC));
    public static final Item NUMBER_4 = register(BlocksTwo.NUMBER_4, new Item.Properties().group(ItemGroup.MISC));
    public static final Item NUMBER_5 = register(BlocksTwo.NUMBER_5, new Item.Properties().group(ItemGroup.MISC));
    public static final Item NUMBER_6 = register(BlocksTwo.NUMBER_6, new Item.Properties().group(ItemGroup.MISC));
    public static final Item NUMBER_7 = register(BlocksTwo.NUMBER_7, new Item.Properties().group(ItemGroup.MISC));
    public static final Item NUMBER_8 = register(BlocksTwo.NUMBER_8, new Item.Properties().group(ItemGroup.MISC));
    public static final Item NUMBER_9 = register(BlocksTwo.NUMBER_9, new Item.Properties().group(ItemGroup.MISC));
    
    
    
    // Foodstuffs
    public static final Item BLUEBERRY = register("blueberry", new Item(new Item.Properties().food(FoodsTwo.BLUEBERRY).group(ItemGroup.FOOD)));
    public static final Item TOMATO = register("tomato", new Item(new Item.Properties().food(FoodsTwo.TOMATO).group(ItemGroup.FOOD)));
    public static final Item BANANA_BUNCH = register("banana_bunch", new Item(new Item.Properties().food(FoodsTwo.BANANA_BUNCH).group(ItemGroup.FOOD)));
    public static final Item CORN = register("corn", new Item(new Item.Properties().food(FoodsTwo.CORN).group(ItemGroup.FOOD)));
    public static final Item APPLE_PIE = register("apple_pie", new Item(new Item.Properties().food(FoodsTwo.APPLE_PIE).group(ItemGroup.FOOD)));
    public static final Item TOAST = register("toast", new Item(new Item.Properties().food(FoodsTwo.TOAST).group(ItemGroup.FOOD)));
    
    public static final Item APPLE_CORE = register("apple_core", new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final Item GOLDEN_APPLE_CORE = register("golden_apple_core", new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final Item BEETROOT_STEMS = register("beetroot_stems", new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final Item CARROT_STEM = register("carrot_stem", new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final Item GOLDEN_CARROT_STEM = register("golden_carrot_stem", new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final Item CHORUS_PIT = register("chorus_pit", new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final Item MELON_RIND = register("melon_rind", new Item(new Item.Properties().group(ItemGroup.FOOD)));

    
	
	// Tools
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

	public static final Item COPPER_SHOVEL = register("copper_shovel", new ShovelItem(ItemTierTwo.COPPER, 1.5f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item COPPER_PICKAXE = register("copper_pickaxe", new PickaxeItem(ItemTierTwo.COPPER, 1, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item COPPER_AXE = register("copper_axe", new AxeItem(ItemTierTwo.COPPER, 6.0f, -3.1f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item COPPER_HOE = register("copper_hoe", new HoeItem(ItemTierTwo.COPPER, -1.0f, new Item.Properties().group(ItemGroup.TOOLS)));	

    public static final Item MYRKYLITE_SHOVEL = register("myrkylite_shovel", new ShovelItem(ItemTierTwo.MYRKYLITE, 1.5f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item MYRKYLITE_PICKAXE = register("myrkylite_pickaxe", new PickaxeItem(ItemTierTwo.MYRKYLITE, 1, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item MYRKYLITE_AXE = register("myrkylite_axe", new AxeItem(ItemTierTwo.MYRKYLITE, 6.0f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item MYRKYLITE_HOE = register("myrkylite_hoe", new HoeItem(ItemTierTwo.MYRKYLITE, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));	
	
	public static final Item IRON_SICKLE = register("iron_sickle", new SickleItem(ItemTier.IRON, -1.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item WOODEN_SICKLE = register("wooden_sickle", new SickleItem(ItemTier.WOOD, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item STONE_SICKLE = register("stone_sickle", new SickleItem(ItemTier.STONE, -2.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item DIAMOND_SICKLE = register("diamond_sickle", new SickleItem(ItemTier.DIAMOND, 0.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item GOLDEN_SICKLE = register("golden_sickle", new SickleItem(ItemTier.GOLD, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item EMERALD_SICKLE = register("emerald_sickle", new SickleItem(ItemTierTwo.EMERALD, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item RUBY_SICKLE = register("ruby_sickle", new SickleItem(ItemTierTwo.RUBY, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item LEAD_SICKLE = register("lead_sickle", new SickleItem(ItemTierTwo.LEAD, -2.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item COPPER_SICKLE = register("copper_sickle", new SickleItem(ItemTierTwo.COPPER, -1.0f, new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item MYRKYLITE_SICKLE = register("myrkylite_sickle", new SickleItem(ItemTierTwo.MYRKYLITE, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)));

	public static final Item SMITHING_HAMMER = register("smithing_hammer", new SmithingHammerItem(new Item.Properties().group(ItemGroup.TOOLS).defaultMaxDamage(100)));
	public static final Item HANDSAW = register("handsaw", new Item(new Item.Properties().group(ItemGroup.TOOLS)));
	public static final Item ROTATING_WRENCH = register("rotating_wrench", new RotatingWrenchItem(new Item.Properties().group(ItemGroup.TOOLS)));
	// mattock
	// drill? or maybe the hammer will also serve this functionality.
	
	public static final Item CRAFTING_BOOK = register("crafting_book", new CraftingBookItem(new Item.Properties().group(ItemGroup.TOOLS)));
	// other books
	

	
	//Combat
	public static final Item EMERALD_SWORD = register("emerald_sword", new SwordItem(ItemTierTwo.EMERALD, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)));
	public static final Item RUBY_SWORD = register("ruby_sword", new SwordItem(ItemTierTwo.RUBY, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)));
	public static final Item LEAD_SWORD = register("lead_sword", new SwordItem(ItemTierTwo.LEAD, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)));
	public static final Item COPPER_SWORD = register("copper_sword", new SwordItem(ItemTierTwo.COPPER, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)));
	public static final Item MYRKYLITE_SWORD = register("myrkylite_sword", new SwordItem(ItemTierTwo.MYRKYLITE, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final Item IRON_BATTLEAXE = register("iron_battleaxe", new BattleaxeItem(ItemTier.IRON, 6, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
	public static final Item WOODEN_BATTLEAXE = register("wooden_battleaxe", new BattleaxeItem(ItemTier.WOOD, 6, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item STONE_BATTLEAXE = register("stone_battleaxe", new BattleaxeItem(ItemTier.STONE, 7, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item DIAMOND_BATTLEAXE = register("diamond_battleaxe", new BattleaxeItem(ItemTier.DIAMOND, 5, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GOLDEN_BATTLEAXE = register("golden_battleaxe", new BattleaxeItem(ItemTier.GOLD, 6, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item EMERALD_BATTLEAXE = register("emerald_battleaxe", new BattleaxeItem(ItemTierTwo.EMERALD, 6, -2.4f, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item RUBY_BATTLEAXE = register("ruby_battleaxe", new BattleaxeItem(ItemTierTwo.RUBY, 0, -0.0F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LEAD_BATTLEAXE = register("lead_battleaxe", new BattleaxeItem(ItemTierTwo.LEAD, 0, -0.0F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item COPPER_BATTLEAXE = register("copper_battleaxe", new BattleaxeItem(ItemTierTwo.COPPER, 6, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item MYRKYLITE_BATTLEAXE = register("myrkylite_battleaxe", new BattleaxeItem(ItemTierTwo.MYRKYLITE, 6, -2.4f, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item IRON_DAGGER = register("iron_dagger", new DaggerItem(ItemTier.IRON, 0, -0.8F, (new Item.Properties()).group(ItemGroup.COMBAT)));
	public static final Item WOODEN_DAGGER = register("wooden_dagger", new DaggerItem(ItemTier.WOOD, 0, -0.8F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item STONE_DAGGER = register("stone_dagger", new DaggerItem(ItemTier.STONE, 0, -0.8F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item DIAMOND_DAGGER = register("diamond_dagger", new DaggerItem(ItemTier.DIAMOND, 0, -0.8F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item GOLDEN_DAGGER = register("golden_dagger", new DaggerItem(ItemTier.GOLD, 0, -0.8F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item EMERALD_DAGGER = register("emerald_dagger", new DaggerItem(ItemTierTwo.EMERALD, 0, -0.8F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item RUBY_DAGGER = register("ruby_dagger", new DaggerItem(ItemTierTwo.RUBY, 0, -0.8F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item LEAD_DAGGER = register("lead_dagger", new DaggerItem(ItemTierTwo.LEAD, 0, -0.8F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item COPPER_DAGGER = register("copper_dagger", new DaggerItem(ItemTierTwo.COPPER, 0, -0.8F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item MYRKYLITE_DAGGER = register("myrkylite_dagger", new DaggerItem(ItemTierTwo.MYRKYLITE, 0, -0.8F, (new Item.Properties()).group(ItemGroup.COMBAT)));

    public static final Item CUTLASS = register("cutlass", new CutlassItem(new Item.Properties()/*.group(ItemGroup.COMBAT)*/));

    public static final Item BLOOD_WITHER_BLADE = register("blood_wither_blade", new BloodBladeItem(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).rarity(Rarity.RARE)) {
    	@Override
    	public void bonusEffect(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    		target.addPotionEffect(new EffectInstance(Effects.WITHER, 50, 2, false, true));
    	}
    });
    public static final Item BLOOD_FLAME_BLADE = register("blood_flame_blade", new BloodBladeItem(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).rarity(Rarity.RARE)) {
    	@Override
    	public void bonusEffect(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    		target.setFire(5);
    	}
    });
    public static final Item BLOOD_VENOM_BLADE = register("blood_venom_blade", new BloodBladeItem(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).rarity(Rarity.RARE)) {
    	@Override
    	public void bonusEffect(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    		target.addPotionEffect(new EffectInstance(Effects.POISON, 50, 3, false, true));
    	}
    });
    public static final Item BANISHER = register("banisher", new BanisherItem(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).rarity(Rarity.RARE).maxDamage(1280)));
    public static final Item STORMBREAKER = register("stormbreaker", new StormbreakerItem(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).rarity(Rarity.EPIC)));
    public static final Item EVOCATION_STAFF = register("evocation_staff", new EvocationStaffItem(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).rarity(Rarity.EPIC).maxDamage(1280)));
    public static final Item CONJURATION_STAFF = register("conjuration_staff", new ConjurationStaffItem(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).rarity(Rarity.EPIC).maxDamage(1280)));
    
    public static final Item IRON_CAPPED_ARROW = register("iron_capped_arrow", new CappedArrowItem(ItemTier.IRON, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item WOODEN_CAPPED_ARROW = register("wooden_capped_arrow", new CappedArrowItem(ItemTier.WOOD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item STONE_CAPPED_ARROW = register("stone_capped_arrow", new CappedArrowItem(ItemTier.STONE, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item GOLDEN_CAPPED_ARROW = register("golden_capped_arrow", new CappedArrowItem(ItemTier.GOLD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item DIAMOND_CAPPED_ARROW = register("diamond_capped_arrow", new CappedArrowItem(ItemTier.DIAMOND, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item EMERALD_CAPPED_ARROW = register("emerald_capped_arrow", new CappedArrowItem(ItemTierTwo.EMERALD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item RUBY_CAPPED_ARROW = register("ruby_capped_arrow", new CappedArrowItem(ItemTierTwo.RUBY, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item LEAD_CAPPED_ARROW = register("lead_capped_arrow", new CappedArrowItem(ItemTierTwo.LEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item COPPER_CAPPED_ARROW = register("copper_capped_arrow", new CappedArrowItem(ItemTierTwo.COPPER, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item MYRKYLITE_CAPPED_ARROW = register("myrkylite_capped_arrow", new CappedArrowItem(ItemTierTwo.MYRKYLITE, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final Item FIRE_ARROW = register("fire_arrow", new FireArrowItem(new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item ICE_ARROW = register("ice_arrow", new IceArrowItem(new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item BOMB_ARROW = register("bomb_arrow", new BombArrowItem(new Item.Properties().group(ItemGroup.COMBAT)));
    public static final Item SHOCK_ARROW = register("shock_arrow", new ShockArrowItem(new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final Item SHURIKEN = register("shuriken", new ShurikenItem(new Item.Properties()/*.group(ItemGroup.COMBAT)*/));
    // TODO Shuriken code so that it can stick in blocks and whatnot. 
    // Also rendering and spinning. 
    // And put back into creative menu for 2.023. 
    
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

    public static final Item COPPER_HELMET = register("copper_helmet", new ArmorItem(ArmorMaterialTwo.COPPER, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item COPPER_CHESTPLATE = register("copper_chestplate", new ArmorItem(ArmorMaterialTwo.COPPER, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item COPPER_LEGGINGS = register("copper_leggings", new ArmorItem(ArmorMaterialTwo.COPPER, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item COPPER_BOOTS = register("copper_boots", new ArmorItem(ArmorMaterialTwo.COPPER, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item STONE_HELMET = register("stone_helmet", new ArmorItem(ArmorMaterialTwo.STONE, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item STONE_CHESTPLATE = register("stone_chestplate", new ArmorItem(ArmorMaterialTwo.STONE, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item STONE_LEGGINGS = register("stone_leggings", new ArmorItem(ArmorMaterialTwo.STONE, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item STONE_BOOTS = register("stone_boots", new ArmorItem(ArmorMaterialTwo.STONE, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

    public static final Item MYRKYLITE_HELMET = register("myrkylite_helmet", new ArmorItem(ArmorMaterialTwo.MYRKYLITE, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item MYRKYLITE_CHESTPLATE = register("myrkylite_chestplate", new ArmorItem(ArmorMaterialTwo.MYRKYLITE, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item MYRKYLITE_LEGGINGS = register("myrkylite_leggings", new ArmorItem(ArmorMaterialTwo.MYRKYLITE, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final Item MYRKYLITE_BOOTS = register("myrkylite_boots", new ArmorItem(ArmorMaterialTwo.MYRKYLITE, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));    

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
    		// Lighting whatnot
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

    public static final Item TOP_HAT = register("top_hat", new TopHatItem(new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final Item DOUBLE_JUMP_BOOTS = register("double_jump_boots", new DoubleJumpBootsItem(new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.RARE)));
    public static final Item HERMES_HELMET = register("hermes_helmet", new HermesHelmetItem(new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.RARE)));
    
    
    
    /*
    
    fanny pack
    quiver
    potion sack
    mulch
    dog food
    dowsing rod
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
    
    types of magic:
    magic items (durability)
    ability magic (mana)
    magick (material)
    dnd magic (various things)
	rpg magic (leveling up spells)
	doctor strange magic (rituals and spirits)
	conjuration (spirits)
    
    */
    
    
	public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
//    	itemRegistryEvent.getRegistry().getValue(new ResourceLocation("minecraft", "command_block"))
		itemRegistryEvent.getRegistry().registerAll(Holder.ITEMSTWO.toArray(new Item[] {}));
    
		ItemGroup.COMBAT.setRelevantEnchantmentTypes(new EnchantmentType[]{ EnchantmentType.ALL, EnchantmentType.ARMOR, EnchantmentType.ARMOR_FEET, EnchantmentType.ARMOR_HEAD, EnchantmentType.ARMOR_LEGS, EnchantmentType.ARMOR_CHEST, EnchantmentType.BOW, EnchantmentType.WEAPON, EnchantmentType.WEARABLE, EnchantmentType.BREAKABLE, EnchantmentType.TRIDENT, EnchantmentType.CROSSBOW, EnchantmentsTwo.Holder.DOUBLE_JUMP_BOOTS, EnchantmentsTwo.Holder.BLOOD_BLADE, EnchantmentsTwo.Holder.BANISHER, EnchantmentsTwo.Holder.HERMES_HELMET, EnchantmentsTwo.Holder.EVOCATION_STAFF, EnchantmentsTwo.Holder.DAGGER });
		ItemGroup.TOOLS.setRelevantEnchantmentTypes(new EnchantmentType[]{ EnchantmentType.ALL, EnchantmentType.DIGGER, EnchantmentType.FISHING_ROD, EnchantmentType.BREAKABLE, EnchantmentsTwo.Holder.SICKLE });

		Holder.FOOD_TO_SCRAPS.put(Items.GOLDEN_APPLE, ItemsTwo.GOLDEN_APPLE_CORE);
		Holder.FOOD_TO_SCRAPS.put(Items.GOLDEN_CARROT, ItemsTwo.GOLDEN_CARROT_STEM);
		Holder.FOOD_TO_SCRAPS.put(Items.COOKED_BEEF, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.COOKED_PORKCHOP, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.COOKED_MUTTON, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.COOKED_COD, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.COOKED_SALMON, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.COOKED_CHICKEN, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.COOKED_RABBIT, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.MELON_SLICE, ItemsTwo.MELON_RIND);
		Holder.FOOD_TO_SCRAPS.put(Items.APPLE, ItemsTwo.APPLE_CORE);
		Holder.FOOD_TO_SCRAPS.put(Items.CARROT, ItemsTwo.CARROT_STEM);
		Holder.FOOD_TO_SCRAPS.put(Items.BEETROOT, ItemsTwo.BEETROOT_STEMS);
		Holder.FOOD_TO_SCRAPS.put(Items.SWEET_BERRIES, Items.STICK);
		Holder.FOOD_TO_SCRAPS.put(Items.BEEF, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.PORKCHOP, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.MUTTON, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.CHICKEN, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.RABBIT, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.COD, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.SALMON, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.CHORUS_FRUIT, ItemsTwo.CHORUS_PIT);
		Holder.FOOD_TO_SCRAPS.put(Items.PUFFERFISH, Items.BONE);
		Holder.FOOD_TO_SCRAPS.put(Items.TROPICAL_FISH, Items.BONE);
		
		DispenserBlock.registerDispenseBehavior(ItemsTwo.IRON_CAPPED_ARROW, new ProjectileDispenseBehavior() {
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
				cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
				cappedarrowentity.setItemTier(ItemTier.IRON);
				return cappedarrowentity;
	         }
		});
		DispenserBlock.registerDispenseBehavior(ItemsTwo.WOODEN_CAPPED_ARROW, new ProjectileDispenseBehavior() {
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
				cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
				cappedarrowentity.setItemTier(ItemTier.WOOD);
				return cappedarrowentity;
	         }
		});
		DispenserBlock.registerDispenseBehavior(ItemsTwo.STONE_CAPPED_ARROW, new ProjectileDispenseBehavior() {
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
				cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
				cappedarrowentity.setItemTier(ItemTier.STONE);
				return cappedarrowentity;
	         }
		});
		DispenserBlock.registerDispenseBehavior(ItemsTwo.GOLDEN_CAPPED_ARROW, new ProjectileDispenseBehavior() {
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
				cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
				cappedarrowentity.setItemTier(ItemTier.GOLD);
				return cappedarrowentity;
	         }
		});
		DispenserBlock.registerDispenseBehavior(ItemsTwo.DIAMOND_CAPPED_ARROW, new ProjectileDispenseBehavior() {
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
				cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
				cappedarrowentity.setItemTier(ItemTier.DIAMOND);
				return cappedarrowentity;
	         }
		});
		DispenserBlock.registerDispenseBehavior(ItemsTwo.EMERALD_CAPPED_ARROW, new ProjectileDispenseBehavior() {
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
				cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
				cappedarrowentity.setItemTier(ItemTierTwo.EMERALD);
				return cappedarrowentity;
	         }
		});
		DispenserBlock.registerDispenseBehavior(ItemsTwo.RUBY_CAPPED_ARROW, new ProjectileDispenseBehavior() {
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
				cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
				cappedarrowentity.setItemTier(ItemTierTwo.RUBY);
				return cappedarrowentity;
	         }
		});
		DispenserBlock.registerDispenseBehavior(ItemsTwo.LEAD_CAPPED_ARROW, new ProjectileDispenseBehavior() {
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
				cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
				cappedarrowentity.setItemTier(ItemTierTwo.LEAD);
				return cappedarrowentity;
	         }
		});
		DispenserBlock.registerDispenseBehavior(ItemsTwo.COPPER_CAPPED_ARROW, new ProjectileDispenseBehavior() {
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
				cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
				cappedarrowentity.setItemTier(ItemTierTwo.COPPER);
				return cappedarrowentity;
	         }
		});
		DispenserBlock.registerDispenseBehavior(ItemsTwo.MYRKYLITE_CAPPED_ARROW, new ProjectileDispenseBehavior() {
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
				cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
				cappedarrowentity.setItemTier(ItemTierTwo.MYRKYLITE);
				return cappedarrowentity;
	         }
		});
		
		DispenserBlock.registerDispenseBehavior(ItemsTwo.FIRE_ARROW, new ProjectileDispenseBehavior() {
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				AbstractArrowEntity abstractarrowentity = new FireArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
	            abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
	            return abstractarrowentity;
			}
		});
		DispenserBlock.registerDispenseBehavior(ItemsTwo.ICE_ARROW, new ProjectileDispenseBehavior() {
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				AbstractArrowEntity abstractarrowentity = new IceArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
	            abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
	            return abstractarrowentity;
			}
		});
		DispenserBlock.registerDispenseBehavior(ItemsTwo.BOMB_ARROW, new ProjectileDispenseBehavior() {
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				AbstractArrowEntity abstractarrowentity = new BombArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
	            abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
	            return abstractarrowentity;
			}
		});
		DispenserBlock.registerDispenseBehavior(ItemsTwo.SHOCK_ARROW, new ProjectileDispenseBehavior() {
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
				AbstractArrowEntity abstractarrowentity = new ShockArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
	            abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
	            return abstractarrowentity;
			}
		});
		
//		Items.ARROW.getAttributeModifiers(EquipmentSlotType.MAINHAND).put(SharedMonsterAttributesTwo.PROJECTILE_VELOCITY_ATTRIBUTE.getName(), new AttributeModifier(SharedMonsterAttributesTwo.PROJECTILE_VELOCITY_ID, "Weapon modifier", 1, AttributeModifier.Operation.MULTIPLY_BASE));
	}
	static Item register(Block block, Item.Properties properties) {
		return register(block.getRegistryName().getPath(), new BlockItem(block, properties));
	}
	static Item register(BlockItem block) {
		return register(block.getBlock(), block);
	}
	static Item register(Block block, Item item) {
		return register(block.getRegistryName().getPath(), item);
	}
	static Item register(String key, Item item) {
		Holder.ITEMSTWO.add(item.setRegistryName(key));
		
	    return item;
	}
	public static class Holder {
		public static final LinkedList<Item> ITEMSTWO = new LinkedList<Item>();
	
	    public static final Map<Item, Item> FOOD_TO_SCRAPS = new HashMap<Item, Item>();
	}
}
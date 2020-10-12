package io.github.fallout015.two.block;

import java.util.LinkedList;

import io.github.fallout015.two.block.material.MaterialTwo;
import io.github.fallout015.two.block.trees.BlackbarkTree;
import io.github.fallout015.two.block.trees.CherryTree;
import io.github.fallout015.two.block.trees.CloudwoodTree;
import io.github.fallout015.two.block.trees.FrostbarkTree;
import io.github.fallout015.two.block.trees.GhostwoodTree;
import io.github.fallout015.two.block.trees.MapleTree;
import io.github.fallout015.two.fluid.FluidsTwo;
import io.github.fallout015.two.particles.ParticleTypesTwo;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public class BlocksTwo {
	public static final Block LIGHT_SOURCE = register("light_source", new LightSourceBlock(Block.Properties.create(Material.MISCELLANEOUS).setLightLevel(state -> 16).doesNotBlockMovement().noDrops().notSolid().setAir().tickRandomly()));
//	public static final Block TEST_BLOCK = register("test_block", new Block(Block.Properties.create(Material.MISCELLANEOUS).lightValue(1)));
    
//	@ObjectHolder("minecraft:anvil")
//	public static final Block ANVIL = register("minecraft:anvil", new AnvilBlockTwo(Block.Properties.create(Material.ANVIL)).setRegistryName("minecraft", "anvil"));
	
	public static final Block MUD = register("mud", new FlowingFluidBlock(() -> FluidsTwo.MUD, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(150f).noDrops()));
	
	//public static final Block CEDAR_PLANKS = register("cedar_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	//public static final Block REDWOOD_PLANKS = register("redwood_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block CHERRY_PLANKS = register("cherry_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	//public static final Block ASPEN_PLANKS = register("aspen_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	//public static final Block DRAGONBLOOD_PLANKS = register("dragonblood_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	//public static final Block EUCALYPTUS_PLANKS = register("eucalyptus_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	//public static final Block PINE_PLANKS = register("pine_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	//public static final Block BALSA_PLANKS = register("balsa_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	//public static final Block CONIFER_PLANKS = register("conifer_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block MAPLE_PLANKS = register("maple_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block GHOSTWOOD_PLANKS = register("ghostwood_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	//public static final Block DEADWOOD_PLANKS = register("deadwood_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.STONE).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));	
	public static final Block CLOUDWOOD_PLANKS = register("cloudwood_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.CYAN_TERRACOTTA).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block BLACKBARK_PLANKS = register("blackbark_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block FROSTBARK_PLANKS = register("frostbark_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.ICE).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block NEONDOT_PLANKS = register("neondot_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.CYAN).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block BRIMSHINE_PLANKS = register("brimshine_planks", new Block(Block.Properties.create(Material.WOOD, MaterialColor.LIME).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	
	public static final Block WHITE_STAINED_WOODEN_PLANKS = register("white_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.WHITE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block ORANGE_STAINED_WOODEN_PLANKS = register("orange_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.ORANGE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block MAGENTA_STAINED_WOODEN_PLANKS = register("magenta_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.MAGENTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block LIGHT_BLUE_STAINED_WOODEN_PLANKS = register("light_blue_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.LIGHT_BLUE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block YELLOW_STAINED_WOODEN_PLANKS = register("yellow_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.YELLOW).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block LIME_STAINED_WOODEN_PLANKS = register("lime_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.LIME).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block PINK_STAINED_WOODEN_PLANKS = register("pink_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.PINK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block GRAY_STAINED_WOODEN_PLANKS = register("gray_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.GRAY).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block LIGHT_GRAY_STAINED_WOODEN_PLANKS = register("light_gray_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.LIGHT_GRAY).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block CYAN_STAINED_WOODEN_PLANKS = register("cyan_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.CYAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block PURPLE_STAINED_WOODEN_PLANKS = register("purple_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.PURPLE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BLUE_STAINED_WOODEN_PLANKS = register("blue_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.BLUE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BROWN_STAINED_WOODEN_PLANKS = register("brown_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.BROWN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block GREEN_STAINED_WOODEN_PLANKS = register("green_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.GREEN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block RED_STAINED_WOODEN_PLANKS = register("red_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.RED).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BLACK_STAINED_WOODEN_PLANKS = register("black_stained_wooden_planks", new Block(Block.Properties.create(Material.WOOD, DyeColor.BLACK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	
	public static final Block WHITE_STAINED_WOODEN_SLAB = register("white_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.WHITE).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block ORANGE_STAINED_WOODEN_SLAB = register("orange_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.ORANGE).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block MAGENTA_STAINED_WOODEN_SLAB = register("magenta_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.MAGENTA).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block LIGHT_BLUE_STAINED_WOODEN_SLAB = register("light_blue_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.LIGHT_BLUE).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block YELLOW_STAINED_WOODEN_SLAB = register("yellow_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.YELLOW).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block LIME_STAINED_WOODEN_SLAB = register("lime_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.LIME).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block PINK_STAINED_WOODEN_SLAB = register("pink_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.PINK).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block GRAY_STAINED_WOODEN_SLAB = register("gray_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.GRAY).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block LIGHT_GRAY_STAINED_WOODEN_SLAB = register("light_gray_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.LIGHT_GRAY).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block CYAN_STAINED_WOODEN_SLAB = register("cyan_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.CYAN).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block PURPLE_STAINED_WOODEN_SLAB = register("purple_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.PURPLE).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block BLUE_STAINED_WOODEN_SLAB = register("blue_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.BLUE).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block BROWN_STAINED_WOODEN_SLAB = register("brown_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.BROWN).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block GREEN_STAINED_WOODEN_SLAB = register("green_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.GREEN).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block RED_STAINED_WOODEN_SLAB = register("red_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.RED).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	public static final Block BLACK_STAINED_WOODEN_SLAB = register("black_stained_wooden_slab", new SlabBlock(Block.Properties.create(Material.WOOD, DyeColor.BLACK).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
	
	public static final Block WHITE_STAINED_WOODEN_STAIRS = register("white_stained_wooden_stairs", new StairsBlock(WHITE_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(WHITE_STAINED_WOODEN_PLANKS)));
	public static final Block ORANGE_STAINED_WOODEN_STAIRS = register("orange_stained_wooden_stairs", new StairsBlock(ORANGE_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(ORANGE_STAINED_WOODEN_PLANKS)));
	public static final Block MAGENTA_STAINED_WOODEN_STAIRS = register("magenta_stained_wooden_stairs", new StairsBlock(MAGENTA_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(MAGENTA_STAINED_WOODEN_PLANKS)));
	public static final Block LIGHT_BLUE_STAINED_WOODEN_STAIRS = register("light_blue_stained_wooden_stairs", new StairsBlock(LIGHT_BLUE_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(LIGHT_BLUE_STAINED_WOODEN_PLANKS)));
	public static final Block YELLOW_STAINED_WOODEN_STAIRS = register("yellow_stained_wooden_stairs", new StairsBlock(YELLOW_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(YELLOW_STAINED_WOODEN_PLANKS)));
	public static final Block LIME_STAINED_WOODEN_STAIRS = register("lime_stained_wooden_stairs", new StairsBlock(LIME_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(LIME_STAINED_WOODEN_PLANKS)));
	public static final Block PINK_STAINED_WOODEN_STAIRS = register("pink_stained_wooden_stairs", new StairsBlock(PINK_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(PINK_STAINED_WOODEN_PLANKS)));
	public static final Block GRAY_STAINED_WOODEN_STAIRS = register("gray_stained_wooden_stairs", new StairsBlock(GRAY_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(GRAY_STAINED_WOODEN_PLANKS)));
	public static final Block LIGHT_GRAY_STAINED_WOODEN_STAIRS = register("light_gray_stained_wooden_stairs", new StairsBlock(LIGHT_GRAY_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(LIGHT_GRAY_STAINED_WOODEN_PLANKS)));
	public static final Block CYAN_STAINED_WOODEN_STAIRS = register("cyan_stained_wooden_stairs", new StairsBlock(CYAN_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(CYAN_STAINED_WOODEN_PLANKS)));
	public static final Block PURPLE_STAINED_WOODEN_STAIRS = register("purple_stained_wooden_stairs", new StairsBlock(PURPLE_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(PURPLE_STAINED_WOODEN_PLANKS)));
	public static final Block BLUE_STAINED_WOODEN_STAIRS = register("blue_stained_wooden_stairs", new StairsBlock(BLUE_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(BLUE_STAINED_WOODEN_PLANKS)));
	public static final Block BROWN_STAINED_WOODEN_STAIRS = register("brown_stained_wooden_stairs", new StairsBlock(BROWN_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(BROWN_STAINED_WOODEN_PLANKS)));
	public static final Block GREEN_STAINED_WOODEN_STAIRS = register("green_stained_wooden_stairs", new StairsBlock(GREEN_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(GREEN_STAINED_WOODEN_PLANKS)));
	public static final Block RED_STAINED_WOODEN_STAIRS = register("red_stained_wooden_stairs", new StairsBlock(RED_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(RED_STAINED_WOODEN_PLANKS)));
	public static final Block BLACK_STAINED_WOODEN_STAIRS = register("black_stained_wooden_stairs", new StairsBlock(BLACK_STAINED_WOODEN_PLANKS::getDefaultState, Block.Properties.from(BLACK_STAINED_WOODEN_PLANKS)));
	
	public static final Block WHITE_STAINED_WOODEN_FENCE = register("white_stained_wooden_fence", new FenceBlock(Block.Properties.from(WHITE_STAINED_WOODEN_PLANKS)));
	public static final Block ORANGE_STAINED_WOODEN_FENCE = register("orange_stained_wooden_fence", new FenceBlock(Block.Properties.from(ORANGE_STAINED_WOODEN_PLANKS)));
	public static final Block MAGENTA_STAINED_WOODEN_FENCE = register("magenta_stained_wooden_fence", new FenceBlock(Block.Properties.from(MAGENTA_STAINED_WOODEN_PLANKS)));
	public static final Block LIGHT_BLUE_STAINED_WOODEN_FENCE = register("light_blue_stained_wooden_fence", new FenceBlock(Block.Properties.from(LIGHT_BLUE_STAINED_WOODEN_PLANKS)));
	public static final Block YELLOW_STAINED_WOODEN_FENCE = register("yellow_stained_wooden_fence", new FenceBlock(Block.Properties.from(YELLOW_STAINED_WOODEN_PLANKS)));
	public static final Block LIME_STAINED_WOODEN_FENCE = register("lime_stained_wooden_fence", new FenceBlock(Block.Properties.from(LIME_STAINED_WOODEN_PLANKS)));
	public static final Block PINK_STAINED_WOODEN_FENCE = register("pink_stained_wooden_fence", new FenceBlock(Block.Properties.from(PINK_STAINED_WOODEN_PLANKS)));
	public static final Block GRAY_STAINED_WOODEN_FENCE = register("gray_stained_wooden_fence", new FenceBlock(Block.Properties.from(GRAY_STAINED_WOODEN_PLANKS)));
	public static final Block LIGHT_GRAY_STAINED_WOODEN_FENCE = register("light_gray_stained_wooden_fence", new FenceBlock(Block.Properties.from(LIGHT_GRAY_STAINED_WOODEN_PLANKS)));
	public static final Block CYAN_STAINED_WOODEN_FENCE = register("cyan_stained_wooden_fence", new FenceBlock(Block.Properties.from(CYAN_STAINED_WOODEN_PLANKS)));
	public static final Block PURPLE_STAINED_WOODEN_FENCE = register("purple_stained_wooden_fence", new FenceBlock(Block.Properties.from(PURPLE_STAINED_WOODEN_PLANKS)));
	public static final Block BLUE_STAINED_WOODEN_FENCE = register("blue_stained_wooden_fence", new FenceBlock(Block.Properties.from(BLUE_STAINED_WOODEN_PLANKS)));
	public static final Block BROWN_STAINED_WOODEN_FENCE = register("brown_stained_wooden_fence", new FenceBlock(Block.Properties.from(BROWN_STAINED_WOODEN_PLANKS)));
	public static final Block GREEN_STAINED_WOODEN_FENCE = register("green_stained_wooden_fence", new FenceBlock(Block.Properties.from(GREEN_STAINED_WOODEN_PLANKS)));
	public static final Block RED_STAINED_WOODEN_FENCE = register("red_stained_wooden_fence", new FenceBlock(Block.Properties.from(RED_STAINED_WOODEN_PLANKS)));
	public static final Block BLACK_STAINED_WOODEN_FENCE = register("black_stained_wooden_fence", new FenceBlock(Block.Properties.from(BLACK_STAINED_WOODEN_PLANKS)));

	public static final Block WHITE_STAINED_WOODEN_FENCE_GATE = register("white_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(WHITE_STAINED_WOODEN_PLANKS)));
	public static final Block ORANGE_STAINED_WOODEN_FENCE_GATE = register("orange_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(ORANGE_STAINED_WOODEN_PLANKS)));
	public static final Block MAGENTA_STAINED_WOODEN_FENCE_GATE = register("magenta_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(MAGENTA_STAINED_WOODEN_PLANKS)));
	public static final Block LIGHT_BLUE_STAINED_WOODEN_FENCE_GATE = register("light_blue_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(LIGHT_BLUE_STAINED_WOODEN_PLANKS)));
	public static final Block YELLOW_STAINED_WOODEN_FENCE_GATE = register("yellow_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(YELLOW_STAINED_WOODEN_PLANKS)));
	public static final Block LIME_STAINED_WOODEN_FENCE_GATE = register("lime_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(LIME_STAINED_WOODEN_PLANKS)));
	public static final Block PINK_STAINED_WOODEN_FENCE_GATE = register("pink_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(PINK_STAINED_WOODEN_PLANKS)));
	public static final Block GRAY_STAINED_WOODEN_FENCE_GATE = register("gray_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(GRAY_STAINED_WOODEN_PLANKS)));
	public static final Block LIGHT_GRAY_STAINED_WOODEN_FENCE_GATE = register("light_gray_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(LIGHT_GRAY_STAINED_WOODEN_PLANKS)));
	public static final Block CYAN_STAINED_WOODEN_FENCE_GATE = register("cyan_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(CYAN_STAINED_WOODEN_PLANKS)));
	public static final Block PURPLE_STAINED_WOODEN_FENCE_GATE = register("purple_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(PURPLE_STAINED_WOODEN_PLANKS)));
	public static final Block BLUE_STAINED_WOODEN_FENCE_GATE = register("blue_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(BLUE_STAINED_WOODEN_PLANKS)));
	public static final Block BROWN_STAINED_WOODEN_FENCE_GATE = register("brown_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(BROWN_STAINED_WOODEN_PLANKS)));
	public static final Block GREEN_STAINED_WOODEN_FENCE_GATE = register("green_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(GREEN_STAINED_WOODEN_PLANKS)));
	public static final Block RED_STAINED_WOODEN_FENCE_GATE = register("red_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(RED_STAINED_WOODEN_PLANKS)));
	public static final Block BLACK_STAINED_WOODEN_FENCE_GATE = register("black_stained_wooden_fence_gate", new FenceGateBlock(Block.Properties.from(BLACK_STAINED_WOODEN_PLANKS)));

	// stained boat
	// stained sign
	// stained door (not sure how it's gonna work)
	// stained button
	// stained pressure plate
	// stained trapdoor (also not sure)
	
	// stained barrel
	// stained chest
	
	public static final Block PURPETAL = register("purpetal", new FlowerBlock(Effects.LEVITATION, 10, Block.Properties.create(Material.ORGANIC).notSolid().doesNotBlockMovement()) {
		protected boolean isValidGround(BlockState state, net.minecraft.world.IBlockReader worldIn, BlockPos pos) {
			return state.getBlock() == Blocks.END_STONE;
		};
	});
	public static final Block PURPETAL_STEM = register("purpetal_stem", new RotatedPillarBlock(Block.Properties.create(Material.ORGANIC)));
	public static final Block PURPETAL_PETAL = register("purpetal_petal", new Block(Block.Properties.create(Material.ORGANIC)));
	public static final Block PURPETAL_PISTOL = register("purpetal_pistol", new Block(Block.Properties.create(Material.ORGANIC)));
	
	public static final Block SUCCULIGHT = register("succulight", new SucculightBlock(Effects.NIGHT_VISION, 5, Block.Properties.create(Material.CACTUS).notSolid().doesNotBlockMovement().setLightLevel(state -> 6)));
	public static final Block POTTED_SUCCULIGHT = register("potted_succulight", new FlowerPotBlock(null, () -> BlocksTwo.SUCCULIGHT, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	
	public static final Block CHERRY_SAPLING = register("cherry_sapling", new SaplingBlock(new CherryTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final Block MAPLE_SAPLING = register("maple_sapling", new SaplingBlock(new MapleTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final Block GHOSTWOOD_SAPLING = register("ghostwood_sapling", new SaplingBlock(new GhostwoodTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final Block CLOUDWOOD_SAPLING = register("cloudwood_sapling", new SaplingBlock(new CloudwoodTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final Block BLACKBARK_SAPLING = register("blackbark_sapling", new SaplingBlock(new BlackbarkTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final Block FROSTBARK_SAPLING = register("frostbark_sapling", new SaplingBlock(new FrostbarkTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));

	public static final Block POTTED_CHERRY_SAPLING = register("potted_cherry_sapling", new FlowerPotBlock(null, () -> CHERRY_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	public static final Block POTTED_MAPLE_SAPLING = register("potted_maple_sapling", new FlowerPotBlock(null, () -> MAPLE_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	public static final Block POTTED_GHOSTWOOD_SAPLING = register("potted_ghostwood_sapling", new FlowerPotBlock(null, () -> GHOSTWOOD_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	public static final Block POTTED_CLOUDWOOD_SAPLING = register("potted_cloudwood_sapling", new FlowerPotBlock(null, () -> CLOUDWOOD_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	public static final Block POTTED_BLACKBARK_SAPLING = register("potted_blackbark_sapling", new FlowerPotBlock(null, () -> BLACKBARK_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	public static final Block POTTED_FROSTBARK_SAPLING = register("potted_frostbark_sapling", new FlowerPotBlock(null, () -> FROSTBARK_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	// potted neondot
	// potted brimshine TODO
	
	// working on the ATs
	public static final Block CHERRY_LOG = register("cherry_log", Blocks.createLogBlock(MaterialColor.PINK_TERRACOTTA, MaterialColor.STONE));
	public static final Block MAPLE_LOG = register("maple_log", Blocks.createLogBlock(MaterialColor.SAND, MaterialColor.BROWN_TERRACOTTA));
	public static final Block GHOSTWOOD_LOG = register("ghostwood_log", Blocks.createLogBlock(MaterialColor.RED_TERRACOTTA, MaterialColor.SNOW));
	public static final Block CLOUDWOOD_LOG = register("cloudwood_log", Blocks.createLogBlock(MaterialColor.SNOW, MaterialColor.CYAN));
	public static final Block BLACKBARK_LOG = register("blackbark_log", Blocks.createLogBlock(MaterialColor.BROWN_TERRACOTTA, MaterialColor.BLACK));
	public static final Block FROSTBARK_LOG = register("frostbark_log", Blocks.createLogBlock(MaterialColor.WHITE_TERRACOTTA, MaterialColor.ICE));
	public static final Block NEONDOT_STEM = register("neondot_stem", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN).hardnessAndResistance(1.0F).sound(SoundType.WOOD)));
	public static final Block BRIMSHINE_STEM = register("brimshine_stem", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(1.0F).sound(SoundType.WOOD)));
	
	public static final Block STRIPPED_CHERRY_LOG = register("stripped_cherry_log", Blocks.createLogBlock(MaterialColor.PINK_TERRACOTTA, MaterialColor.PINK_TERRACOTTA));
	public static final Block STRIPPED_MAPLE_LOG = register("stripped_maple_log", Blocks.createLogBlock(MaterialColor.SAND, MaterialColor.SAND));
	public static final Block STRIPPED_GHOSTWOOD_LOG = register("stripped_ghostwood_log", Blocks.createLogBlock(MaterialColor.RED_TERRACOTTA, MaterialColor.RED_TERRACOTTA));
	public static final Block STRIPPED_CLOUDWOOD_LOG = register("stripped_cloudwood_log", Blocks.createLogBlock(MaterialColor.SNOW, MaterialColor.SNOW));
	public static final Block STRIPPED_BLACKBARK_LOG = register("stripped_blackbark_log", Blocks.createLogBlock(MaterialColor.BROWN_TERRACOTTA, MaterialColor.BROWN_TERRACOTTA));
	public static final Block STRIPPED_FROSTBARK_LOG = register("stripped_frostbark_log", Blocks.createLogBlock(MaterialColor.WHITE_TERRACOTTA, MaterialColor.WHITE_TERRACOTTA)); // TODO more parity, thanks for teaching me that word, @Mojang
	// stripped neondot stem
	// stripped brimshine stem
	
	public static final Block STRIPPED_CHERRY_WOOD = register("stripped_cherry_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.RED).hardnessAndResistance(2.0f).sound(SoundType.WOOD)));
	public static final Block STRIPPED_MAPLE_WOOD = register("stripped_maple_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0f).sound(SoundType.WOOD)));
	public static final Block STRIPPED_GHOSTWOOD_WOOD = register("stripped_ghostwood_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(2.0f).sound(SoundType.WOOD)));
	public static final Block STRIPPED_CLOUDWOOD_WOOD = register("stripped_cloudwood_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2.0f).sound(SoundType.WOOD)));
	public static final Block STRIPPED_BLACKBARK_WOOD = register("stripped_blackbark_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2.0f).sound(SoundType.WOOD)));
	public static final Block STRIPPED_FROSTBARK_WOOD = register("stripped_frostbark_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(2.0f).sound(SoundType.WOOD)));
	// stripped neondot hyphae
	// stripped brimshine hyphae
	
	public static final Block CHERRY_WOOD = register("cherry_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.STONE).hardnessAndResistance(2.0f).sound(SoundType.WOOD)));
	public static final Block MAPLE_WOOD = register("maple_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2.0f).sound(SoundType.WOOD)));
	public static final Block GHOSTWOOD_WOOD = register("ghostwood_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2.0f).sound(SoundType.WOOD)));
	public static final Block CLOUDWOOD_WOOD = register("cloudwood_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN).hardnessAndResistance(2.0f).sound(SoundType.WOOD)));
	public static final Block BLACKBARK_WOOD = register("blackbark_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).hardnessAndResistance(2.0f).sound(SoundType.WOOD)));
	public static final Block FROSTBARK_WOOD = register("frostbark_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.ICE).hardnessAndResistance(2.0f).sound(SoundType.WOOD)));
	// neondot hyphae
	// brimshine hyphae
	
	public static final Block CHERRY_LEAVES = register("cherry_leaves", new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
	public static final Block MAPLE_LEAVES = register("maple_leaves", new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
	public static final Block GHOSTWOOD_LEAVES = register("ghostwood_leaves", new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
	public static final Block CLOUDWOOD_LEAVES = register("cloudwood_leaves", new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
	public static final Block BLACKBARK_LEAVES = register("blackbark_leaves", new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2f).tickRandomly().sound(SoundType.PLANT).notSolid()));
	public static final Block FROSTBARK_LEAVES = register("frostbark_leaves", new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2f).tickRandomly().sound(SoundType.PLANT).notSolid()));
	public static final Block NEONDOT_CAP = register("neondot_cap", new Block(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(0.8f).sound(SoundType.CLOTH)));
	public static final Block BRIMSHINE_CAP = register("brimshine_cap", new Block(Block.Properties.create(Material.WOOD, MaterialColor.YELLOW).hardnessAndResistance(0.8f).sound(SoundType.CLOTH)));

	public static final Block CHERRY_SLAB = register("cherry_slab", new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.PINK_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block MAPLE_SLAB = register("maple_slab", new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block GHOSTWOOD_SLAB = register("ghostwood_slab", new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block CLOUDWOOD_SLAB = register("cloudwood_slab", new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BLACKBARK_SLAB = register("blackbark_slab", new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block FROSTBARK_SLAB = register("frostbark_slab", new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.ICE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	// neondot slab
	// brimshine slab
	
	public static final Block CHERRY_PRESSURE_PLATE = register("cherry_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.PINK_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final Block MAPLE_PRESSURE_PLATE = register("maple_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final Block GHOSTWOOD_PRESSURE_PLATE = register("ghostwood_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.RED_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final Block CLOUDWOOD_PRESSURE_PLATE = register("cloudwood_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.CYAN_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final Block BLACKBARK_PRESSURE_PLATE = register("blackbark_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.BLACK).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final Block FROSTBARK_PRESSURE_PLATE = register("frostbark_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.ICE).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	// neondot pressure plate
	// brimshine pressure plate
	
	public static final Block CHERRY_FENCE = register("cherry_fence", new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.PINK_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block MAPLE_FENCE = register("maple_fence", new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block GHOSTWOOD_FENCE = register("ghostwood_fence", new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block CLOUDWOOD_FENCE = register("cloudwood_fence", new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BLACKBARK_FENCE = register("blackbark_fence", new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block FROSTBARK_FENCE = register("frostbark_fence", new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.ICE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	// neondot fence
	// brimshine fence
	
	public static final Block CHERRY_TRAPDOOR = register("cherry_trapdoor", new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.PINK_TERRACOTTA).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final Block MAPLE_TRAPDOOR = register("maple_trapdoor", new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final Block GHOSTWOOD_TRAPDOOR = register("ghostwood_trapdoor", new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final Block CLOUDWOOD_TRAPDOOR = register("cloudwood_trapdoor", new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN_TERRACOTTA).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final Block BLACKBARK_TRAPDOOR = register("blackbark_trapdoor", new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final Block FROSTBARK_TRAPDOOR = register("frostbark_trapdoor", new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.ICE).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	// neondot trapdoor
	// brimshine trapdoor
	
	public static final Block CHERRY_FENCE_GATE = register("cherry_fence_gate", new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.PINK_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block MAPLE_FENCE_GATE = register("maple_fence_gate", new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block GHOSTWOOD_FENCE_GATE = register("ghostwood_fence_gate", new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block CLOUDWOOD_FENCE_GATE = register("cloudwood_fence_gate", new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BLACKBARK_FENCE_GATE = register("blackbark_fence_gate", new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block FROSTBARK_FENCE_GATE = register("frostbark_fence_gate", new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.ICE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	// neondot fence gate
	// brimshine fence gate
	
	public static final Block CHERRY_STAIRS = register("cherry_stairs", new StairsBlock(CHERRY_PLANKS::getDefaultState, Block.Properties.from(CHERRY_PLANKS)));
	public static final Block MAPLE_STAIRS = register("maple_stairs", new StairsBlock(MAPLE_PLANKS::getDefaultState, Block.Properties.from(MAPLE_PLANKS)));
	public static final Block GHOSTWOOD_STAIRS = register("ghostwood_stairs", new StairsBlock(GHOSTWOOD_PLANKS::getDefaultState, Block.Properties.from(GHOSTWOOD_PLANKS)));
	public static final Block CLOUDWOOD_STAIRS = register("cloudwood_stairs", new StairsBlock(CLOUDWOOD_PLANKS::getDefaultState, Block.Properties.from(CLOUDWOOD_PLANKS)));
	public static final Block BLACKBARK_STAIRS = register("blackbark_stairs", new StairsBlock(BLACKBARK_PLANKS::getDefaultState, Block.Properties.from(BLACKBARK_PLANKS)));
	public static final Block FROSTBARK_STAIRS = register("frostbark_stairs", new StairsBlock(FROSTBARK_PLANKS::getDefaultState, Block.Properties.from(FROSTBARK_PLANKS)));
	// neondot stairs
	// brimshine stairs
	
	public static final Block CHERRY_BUTTON = register("cherry_button", new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final Block MAPLE_BUTTON = register("maple_button", new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final Block GHOSTWOOD_BUTTON = register("ghostwood_button", new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final Block CLOUDWOOD_BUTTON = register("cloudwood_button", new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final Block BLACKBARK_BUTTON = register("blackbark_button", new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final Block FROSTBARK_BUTTON = register("frostbark_button", new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	// neondot button
	// brimshine button
	
	public static final Block CHERRY_DOOR = register("cherry_door", new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.PINK_TERRACOTTA).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final Block MAPLE_DOOR = register("maple_door", new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final Block GHOSTWOOD_DOOR = register("ghostwood_door", new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final Block CLOUDWOOD_DOOR = register("cloudwood_door", new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN_TERRACOTTA).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final Block BLACKBARK_DOOR = register("blackbark_door", new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final Block FROSTBARK_DOOR = register("frostbark_door", new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.ICE).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	// neondot door
	// brimshine door
	
	public static final Block CHERRY_SIGN = register("cherry_sign", new StandingSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.PINK_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), WoodTypeTwo.CHERRY));
	public static final Block MAPLE_SIGN = register("maple_sign", new StandingSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), WoodTypeTwo.MAPLE));
	public static final Block GHOSTWOOD_SIGN = register("ghostwood_sign", new StandingSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.RED_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), WoodTypeTwo.GHOSTWOOD));
	public static final Block CLOUDWOOD_SIGN = register("cloudwood_sign", new StandingSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), WoodTypeTwo.CLOUDWOOD));
	public static final Block BLACKBARK_SIGN = register("blackbark_sign", new StandingSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), WoodTypeTwo.BLACKBARK));
	public static final Block FROSTBARK_SIGN = register("frostbark_sign", new StandingSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.ICE).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), WoodTypeTwo.FROSTBARK));
	// neondot sign
	// brimshine sign
	
	public static final Block CHERRY_WALL_SIGN = register("cherry_wall_sign", new WallSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.PINK_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(CHERRY_SIGN), WoodTypeTwo.CHERRY));
	public static final Block MAPLE_WALL_SIGN = register("maple_wall_sign", new WallSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(MAPLE_SIGN), WoodTypeTwo.MAPLE));
	public static final Block GHOSTWOOD_WALL_SIGN = register("ghostwood_wall_sign", new WallSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.RED_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(GHOSTWOOD_SIGN), WoodTypeTwo.GHOSTWOOD));
	public static final Block CLOUDWOOD_WALL_SIGN = register("cloudwood_wall_sign", new WallSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.CYAN_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(CLOUDWOOD_SIGN), WoodTypeTwo.CLOUDWOOD));
	public static final Block BLACKBARK_WALL_SIGN = register("blackbark_wall_sign", new WallSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(BLACKBARK_SIGN), WoodTypeTwo.BLACKBARK));
	public static final Block FROSTBARK_WALL_SIGN = register("frostbark_wall_sign", new WallSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.ICE).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(FROSTBARK_SIGN), WoodTypeTwo.FROSTBARK));
	// neondot wall sign
	// brimshine wall sign
	
	public static final Block WHITE_GLAZED_BRICKS = register("white_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.WHITE).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block ORANGE_GLAZED_BRICKS = register("orange_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.ORANGE).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block MAGENTA_GLAZED_BRICKS = register("magenta_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.MAGENTA).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block LIGHT_BLUE_GLAZED_BRICKS = register("light_blue_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.LIGHT_BLUE).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block YELLOW_GLAZED_BRICKS = register("yellow_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.YELLOW).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block LIME_GLAZED_BRICKS = register("lime_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.LIME).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block PINK_GLAZED_BRICKS = register("pink_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.PINK).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block GRAY_GLAZED_BRICKS = register("gray_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.GRAY).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block LIGHT_GRAY_GLAZED_BRICKS = register("light_gray_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.LIGHT_GRAY).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block CYAN_GLAZED_BRICKS = register("cyan_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.CYAN).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block PURPLE_GLAZED_BRICKS = register("purple_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.PURPLE).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block BLUE_GLAZED_BRICKS = register("blue_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.BLUE).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block BROWN_GLAZED_BRICKS = register("brown_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.BROWN).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block GREEN_GLAZED_BRICKS = register("green_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.GREEN).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block RED_GLAZED_BRICKS = register("red_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.RED).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block BLACK_GLAZED_BRICKS = register("black_glazed_bricks", new Block(Block.Properties.create(Material.ROCK, DyeColor.BLACK).hardnessAndResistance(2.0F, 6.0F)));
	
	public static final Block WHITE_GLAZED_BRICK_SLAB = register("white_glazed_brick_slab", new SlabBlock(Block.Properties.from(WHITE_GLAZED_BRICKS)));
	public static final Block ORANGE_GLAZED_BRICK_SLAB = register("orange_glazed_brick_slab", new SlabBlock(Block.Properties.from(ORANGE_GLAZED_BRICKS)));
	public static final Block MAGENTA_GLAZED_BRICK_SLAB = register("magenta_glazed_brick_slab", new SlabBlock(Block.Properties.from(MAGENTA_GLAZED_BRICKS)));
	public static final Block LIGHT_BLUE_GLAZED_BRICK_SLAB = register("light_blue_glazed_brick_slab", new SlabBlock(Block.Properties.from(LIGHT_BLUE_GLAZED_BRICKS)));
	public static final Block YELLOW_GLAZED_BRICK_SLAB = register("yellow_glazed_brick_slab", new SlabBlock(Block.Properties.from(YELLOW_GLAZED_BRICKS)));
	public static final Block LIME_GLAZED_BRICK_SLAB = register("lime_glazed_brick_slab", new SlabBlock(Block.Properties.from(LIME_GLAZED_BRICKS)));
	public static final Block PINK_GLAZED_BRICK_SLAB = register("pink_glazed_brick_slab", new SlabBlock(Block.Properties.from(PINK_GLAZED_BRICKS)));
	public static final Block GRAY_GLAZED_BRICK_SLAB = register("gray_glazed_brick_slab", new SlabBlock(Block.Properties.from(GRAY_GLAZED_BRICKS)));
	public static final Block LIGHT_GRAY_GLAZED_BRICK_SLAB = register("light_gray_glazed_brick_slab", new SlabBlock(Block.Properties.from(LIGHT_GRAY_GLAZED_BRICKS)));
	public static final Block CYAN_GLAZED_BRICK_SLAB = register("cyan_glazed_brick_slab", new SlabBlock(Block.Properties.from(CYAN_GLAZED_BRICKS)));
	public static final Block PURPLE_GLAZED_BRICK_SLAB = register("purple_glazed_brick_slab", new SlabBlock(Block.Properties.from(PURPLE_GLAZED_BRICKS)));
	public static final Block BLUE_GLAZED_BRICK_SLAB = register("blue_glazed_brick_slab", new SlabBlock(Block.Properties.from(BLUE_GLAZED_BRICKS)));
	public static final Block BROWN_GLAZED_BRICK_SLAB = register("brown_glazed_brick_slab", new SlabBlock(Block.Properties.from(BROWN_GLAZED_BRICKS)));
	public static final Block GREEN_GLAZED_BRICK_SLAB = register("green_glazed_brick_slab", new SlabBlock(Block.Properties.from(GREEN_GLAZED_BRICKS)));
	public static final Block RED_GLAZED_BRICK_SLAB = register("red_glazed_brick_slab", new SlabBlock(Block.Properties.from(RED_GLAZED_BRICKS)));
	public static final Block BLACK_GLAZED_BRICK_SLAB = register("black_glazed_brick_slab", new SlabBlock(Block.Properties.from(BLACK_GLAZED_BRICKS)));

	public static final Block WHITE_GLAZED_BRICK_STAIRS = register("white_glazed_brick_stairs", new StairsBlock(WHITE_GLAZED_BRICKS::getDefaultState, Block.Properties.from(WHITE_GLAZED_BRICKS)));
	public static final Block ORANGE_GLAZED_BRICK_STAIRS = register("orange_glazed_brick_stairs", new StairsBlock(ORANGE_GLAZED_BRICKS::getDefaultState, Block.Properties.from(ORANGE_GLAZED_BRICKS)));
	public static final Block MAGENTA_GLAZED_BRICK_STAIRS = register("magenta_glazed_brick_stairs", new StairsBlock(MAGENTA_GLAZED_BRICKS::getDefaultState, Block.Properties.from(MAGENTA_GLAZED_BRICKS)));
	public static final Block LIGHT_BLUE_GLAZED_BRICK_STAIRS = register("light_blue_glazed_brick_stairs", new StairsBlock(LIGHT_BLUE_GLAZED_BRICKS::getDefaultState, Block.Properties.from(LIGHT_BLUE_GLAZED_BRICKS)));
	public static final Block YELLOW_GLAZED_BRICK_STAIRS = register("yellow_glazed_brick_stairs", new StairsBlock(YELLOW_GLAZED_BRICKS::getDefaultState, Block.Properties.from(YELLOW_GLAZED_BRICKS)));
	public static final Block LIME_GLAZED_BRICK_STAIRS = register("lime_glazed_brick_stairs", new StairsBlock(LIME_GLAZED_BRICKS::getDefaultState, Block.Properties.from(LIME_GLAZED_BRICKS)));
	public static final Block PINK_GLAZED_BRICK_STAIRS = register("pink_glazed_brick_stairs", new StairsBlock(PINK_GLAZED_BRICKS::getDefaultState, Block.Properties.from(PINK_GLAZED_BRICKS)));
	public static final Block GRAY_GLAZED_BRICK_STAIRS = register("gray_glazed_brick_stairs", new StairsBlock(GRAY_GLAZED_BRICKS::getDefaultState, Block.Properties.from(GRAY_GLAZED_BRICKS)));
	public static final Block LIGHT_GRAY_GLAZED_BRICK_STAIRS = register("light_gray_glazed_brick_stairs", new StairsBlock(LIGHT_GRAY_GLAZED_BRICKS::getDefaultState, Block.Properties.from(LIGHT_GRAY_GLAZED_BRICKS)));
	public static final Block CYAN_GLAZED_BRICK_STAIRS = register("cyan_glazed_brick_stairs", new StairsBlock(CYAN_GLAZED_BRICKS::getDefaultState, Block.Properties.from(CYAN_GLAZED_BRICKS)));
	public static final Block PURPLE_GLAZED_BRICK_STAIRS = register("purple_glazed_brick_stairs", new StairsBlock(PURPLE_GLAZED_BRICKS::getDefaultState, Block.Properties.from(PURPLE_GLAZED_BRICKS)));
	public static final Block BLUE_GLAZED_BRICK_STAIRS = register("blue_glazed_brick_stairs", new StairsBlock(BLUE_GLAZED_BRICKS::getDefaultState, Block.Properties.from(BLUE_GLAZED_BRICKS)));
	public static final Block BROWN_GLAZED_BRICK_STAIRS = register("brown_glazed_brick_stairs", new StairsBlock(BROWN_GLAZED_BRICKS::getDefaultState, Block.Properties.from(BROWN_GLAZED_BRICKS)));
	public static final Block GREEN_GLAZED_BRICK_STAIRS = register("green_glazed_brick_stairs", new StairsBlock(GREEN_GLAZED_BRICKS::getDefaultState, Block.Properties.from(GREEN_GLAZED_BRICKS)));
	public static final Block RED_GLAZED_BRICK_STAIRS = register("red_glazed_brick_stairs", new StairsBlock(RED_GLAZED_BRICKS::getDefaultState, Block.Properties.from(RED_GLAZED_BRICKS)));
	public static final Block BLACK_GLAZED_BRICK_STAIRS = register("black_glazed_brick_stairs", new StairsBlock(BLACK_GLAZED_BRICKS::getDefaultState, Block.Properties.from(BLACK_GLAZED_BRICKS)));
	
	public static final Block WHITE_GLAZED_BRICK_WALL = register("white_glazed_brick_wall", new WallBlock(Block.Properties.from(WHITE_GLAZED_BRICKS)));
	public static final Block ORANGE_GLAZED_BRICK_WALL = register("orange_glazed_brick_wall", new WallBlock(Block.Properties.from(ORANGE_GLAZED_BRICKS)));
	public static final Block MAGENTA_GLAZED_BRICK_WALL = register("magenta_glazed_brick_wall", new WallBlock(Block.Properties.from(MAGENTA_GLAZED_BRICKS)));
	public static final Block LIGHT_BLUE_GLAZED_BRICK_WALL = register("light_blue_glazed_brick_wall", new WallBlock(Block.Properties.from(LIGHT_BLUE_GLAZED_BRICKS)));
	public static final Block YELLOW_GLAZED_BRICK_WALL = register("yellow_glazed_brick_wall", new WallBlock(Block.Properties.from(YELLOW_GLAZED_BRICKS)));
	public static final Block LIME_GLAZED_BRICK_WALL = register("lime_glazed_brick_wall", new WallBlock(Block.Properties.from(LIME_GLAZED_BRICKS)));
	public static final Block PINK_GLAZED_BRICK_WALL = register("pink_glazed_brick_wall", new WallBlock(Block.Properties.from(PINK_GLAZED_BRICKS)));
	public static final Block GRAY_GLAZED_BRICK_WALL = register("gray_glazed_brick_wall", new WallBlock(Block.Properties.from(GRAY_GLAZED_BRICKS)));
	public static final Block LIGHT_GRAY_GLAZED_BRICK_WALL = register("light_gray_glazed_brick_wall", new WallBlock(Block.Properties.from(LIGHT_GRAY_GLAZED_BRICKS)));
	public static final Block CYAN_GLAZED_BRICK_WALL = register("cyan_glazed_brick_wall", new WallBlock(Block.Properties.from(CYAN_GLAZED_BRICKS)));
	public static final Block PURPLE_GLAZED_BRICK_WALL = register("purple_glazed_brick_wall", new WallBlock(Block.Properties.from(PURPLE_GLAZED_BRICKS)));
	public static final Block BLUE_GLAZED_BRICK_WALL = register("blue_glazed_brick_wall", new WallBlock(Block.Properties.from(BLUE_GLAZED_BRICKS)));
	public static final Block BROWN_GLAZED_BRICK_WALL = register("brown_glazed_brick_wall", new WallBlock(Block.Properties.from(BROWN_GLAZED_BRICKS)));
	public static final Block GREEN_GLAZED_BRICK_WALL = register("green_glazed_brick_wall", new WallBlock(Block.Properties.from(GREEN_GLAZED_BRICKS)));
	public static final Block RED_GLAZED_BRICK_WALL = register("red_glazed_brick_wall", new WallBlock(Block.Properties.from(RED_GLAZED_BRICKS)));
	public static final Block BLACK_GLAZED_BRICK_WALL = register("black_glazed_brick_wall", new WallBlock(Block.Properties.from(BLACK_GLAZED_BRICKS)));
	
	public static final Block ADOBE_WET = register("adobe_wet", new AdobeWetBlock(Block.Properties.create(Material.CLAY).tickRandomly().hardnessAndResistance(1.0f, 2.0f)));
	
	public static final Block ADOBE_DRY = register("adobe_dry", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 4.5f)));
	public static final Block ADOBE_DRY_SLAB = register("adobe_dry_slab", new SlabBlock(Block.Properties.from(ADOBE_DRY)));
	public static final Block ADOBE_DRY_STAIRS = register("adobe_dry_stairs", new StairsBlock(ADOBE_DRY::getDefaultState, Block.Properties.from(ADOBE_DRY)));
	public static final Block ADOBE_DRY_WALL = register("adobe_dry_wall", new WallBlock(Block.Properties.from(ADOBE_DRY)));
	
	public static final Block ADOBE_FROZEN = register("adobe_frozen", new Block(Block.Properties.create(Material.ICE).slipperiness(0.9f).hardnessAndResistance(0.5f)));
	public static final Block ADOBE_FROZEN_SLAB = register("adobe_frozen_slab", new SlabBlock(Block.Properties.from(ADOBE_FROZEN)));
	public static final Block ADOBE_FROZEN_STAIRS = register("adobe_frozen_stairs", new StairsBlock(ADOBE_FROZEN::getDefaultState, Block.Properties.from(ADOBE_FROZEN)));
	public static final Block ADOBE_FROZEN_WALL = register("adobe_frozen_wall", new WallBlock(Block.Properties.from(ADOBE_FROZEN)));
	
	public static final Block SPORESTONE = register("sporestone", new Block(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.0f, 4.0f).harvestTool(ToolType.PICKAXE)));
	public static final Block SPORESTONE_SOIL = register("sporestone_soil", new Block(Block.Properties.create(Material.ROCK, MaterialColor.GRASS).hardnessAndResistance(1.0f, 4.0f).harvestTool(ToolType.PICKAXE)));
	// make same block? (like grass)
	public static final Block SPORESTONE_ROOTS = register("sporestone_roots", new WallDecorationBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.GRASS).hardnessAndResistance(0.2f).notSolid()));

	public static final Block NEONDOT = register("neondot", new NeondotBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT).setLightLevel(state -> 4)));
	public static final Block BRIMSHINE = register("brimshine", new BrimshineBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT).setLightLevel(state -> 4)));

	public static final Block SHROOMGLOW = register("shroomglow", new Block(Block.Properties.create(Material.WOOD, MaterialColor.LIME).hardnessAndResistance(0.5f).sound(SoundType.CLOTH).setLightLevel(state -> 8)));
	public static final Block SHROOMGLOW_LANTERN = register("shroomglow_lantern", new LanternBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(3.5F).sound(SoundType.LANTERN).setLightLevel(state -> 12).notSolid()));
	
	// Nightmare
	public static final Block GAULT = register("gault", new Block(Block.Properties.create(MaterialTwo.GAULT).hardnessAndResistance(2.0f)));
	public static final Block NIGHTSTONE = register("nightstone", new Block(Block.Properties.create(MaterialTwo.NIGHSTONE).hardnessAndResistance(7.0f)));

	// Sky
	public static final Block CLOUD = register("cloud", new Block(Block.Properties.create(Material.WOOL).hardnessAndResistance(0.1f)));
	
	// Nidavellir
	public static final Block REGOLITH = register("regolith", new Block(Block.Properties.create(MaterialTwo.REGOLITH).hardnessAndResistance(1.0f)));
	
	public static final Block MYRKYLITE = register("myrkylite", new Block(Block.Properties.create(MaterialTwo.MYRKYLITE).hardnessAndResistance(2.0f).harvestTool(ToolType.PICKAXE).harvestLevel(5)));
	public static final Block MYRKYLITE_SLAB = register("myrkylite_slab", new SlabBlock(Block.Properties.create(MaterialTwo.MYRKYLITE).hardnessAndResistance(2.0f).harvestTool(ToolType.PICKAXE).harvestLevel(5)));
	public static final Block MYRKYLITE_STAIRS = register("myrkylite_stairs", new StairsBlock(MYRKYLITE::getDefaultState, Block.Properties.create(MaterialTwo.MYRKYLITE).hardnessAndResistance(2.0f).harvestTool(ToolType.PICKAXE).harvestLevel(5)));
	public static final Block MYRKYLITE_WALL = register("myrkylite_wall", new WallBlock(Block.Properties.create(MaterialTwo.MYRKYLITE).hardnessAndResistance(2.0f).harvestTool(ToolType.PICKAXE).harvestLevel(5)));
	
	public static final Block POLISHED_MYRKYLITE = register("polished_myrkylite", new Block(Block.Properties.create(MaterialTwo.MYRKYLITE).hardnessAndResistance(2.0f).harvestTool(ToolType.PICKAXE)));
	public static final Block POLISHED_MYRKYLITE_SLAB = register("polished_myrkylite_slab", new SlabBlock(Block.Properties.create(MaterialTwo.MYRKYLITE).hardnessAndResistance(2.0f).harvestTool(ToolType.PICKAXE)));
	public static final Block POLISHED_MYRKYLITE_STAIRS = register("polished_myrkylite_stairs", new StairsBlock(POLISHED_MYRKYLITE::getDefaultState, Block.Properties.create(MaterialTwo.MYRKYLITE).hardnessAndResistance(2.0f).harvestTool(ToolType.PICKAXE)));
	public static final Block POLISHED_MYRKYLITE_WALL = register("polished_myrkylite_wall", new WallBlock(Block.Properties.create(MaterialTwo.MYRKYLITE).hardnessAndResistance(2.0f).harvestTool(ToolType.PICKAXE)));
	
	public static final Block POLISHED_MYRKYLITE_BRICKS = register("polished_myrkylite_bricks", new Block(Block.Properties.create(MaterialTwo.MYRKYLITE).hardnessAndResistance(4.0f)));
	public static final Block POLISHED_MYRKYLITE_BRICK_SLAB = register("polished_myrkylite_brick_slab", new SlabBlock(Block.Properties.create(MaterialTwo.MYRKYLITE).hardnessAndResistance(4.0f)));
	public static final Block POLISHED_MYRKYLITE_BRICK_STAIRS = register("polished_myrkylite_brick_stairs", new StairsBlock(POLISHED_MYRKYLITE_BRICKS::getDefaultState, Block.Properties.create(MaterialTwo.MYRKYLITE).hardnessAndResistance(4.0f)));
	public static final Block POLISHED_MYRKYLITE_BRICK_WALL = register("polished_myrkylite_brick_wall", new WallBlock(Block.Properties.create(MaterialTwo.MYRKYLITE).hardnessAndResistance(4.0f)));
	
	// Blood Aether
	public static final Block SANGUINE = register("sanguine", new Block(Block.Properties.create(Material.SAND)));
	public static final Block ABADDON = register("abaddon", new Block(Block.Properties.create(Material.ROCK)));
	
	// Frostbite
	public static final Block PERMAFROST_GRASS_BLOCK = register("permafrost_grass_block", new PermafrostBlock(Block.Properties.create(Material.ORGANIC)));
	public static final Block PERMAFROST_DIRT = register("permafrost_dirt", new Block(Block.Properties.create(Material.ORGANIC)));
	public static final Block SILICATE = register("silicate", new Block(Block.Properties.create(Material.ROCK)));
	public static final Block EPIDOTE = register("epidote", new Block(Block.Properties.create(Material.ROCK)));
	public static final Block MANTLE = register("mantle", new Block(Block.Properties.create(Material.ROCK)));
	
	public static final Block DESERT_COAL_ORE = register("desert_coal_ore", new OreBlock(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(Blocks.COAL_ORE.getHarvestLevel(Blocks.COAL_ORE.getDefaultState()))) {
		protected int getExperience(java.util.Random rand) {
			return MathHelper.nextInt(rand, 0, 3);
		};
	});
	public static final Block DESERT_IRON_ORE = register("desert_iron_ore", new OreBlock(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(Blocks.IRON_ORE.getHarvestLevel(Blocks.IRON_ORE.getDefaultState()))));
	public static final Block DESERT_GOLD_ORE = register("desert_gold_ore", new OreBlock(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(Blocks.GOLD_ORE.getHarvestLevel(Blocks.GOLD_ORE.getDefaultState()))));
	public static final Block DESERT_COPPER_ORE = register("desert_copper_ore", new OreBlock(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));

	public static final Block END_COBALT_ORE = register("end_cobalt_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(3).harvestTool(ToolType.PICKAXE)));
	public static final Block END_JADE_ORE = register("end_jade_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(4).harvestTool(ToolType.PICKAXE)));
	public static final Block OPAL_ORE = register("opal_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final Block TANZANITE_ORE = register("tanzanite_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final Block NETHER_GARNET_ORE = register("nether_garnet_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(3).harvestTool(ToolType.PICKAXE)));
	public static final Block NETHER_TOPAZ_ORE = register("nether_topaz_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(3).harvestTool(ToolType.PICKAXE)));
	public static final Block END_SAPPHIRE_ORE = register("end_sapphire_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(6).harvestTool(ToolType.PICKAXE)));
	public static final Block RUBY_ORE = register("ruby_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(3).harvestTool(ToolType.PICKAXE)));
	public static final Block NIDAVELLIR_CELESTIUM_ORE = register("nidavellir_celestium_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(8).harvestTool(ToolType.PICKAXE)));

	public static final Block COBALT_BLOCK = register("cobalt_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.LIGHT_BLUE_TERRACOTTA).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block JADE_BLOCK = register("jade_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.GREEN).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block OPAL_BLOCK = register("opal_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.LIGHT_BLUE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block TANZANITE_BLOCK = register("tanzanite_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.BLUE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block GARNET_BLOCK = register("garnet_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.PINK).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block TOPAZ_BLOCK = register("topaz_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.YELLOW).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block SAPPHIRE_BLOCK = register("sapphire_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.BLUE_TERRACOTTA).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block RUBY_BLOCK = register("ruby_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block CELESTIUM_BLOCK = register("celestium_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.LIGHT_BLUE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	
	public static final Block TALC_ORE = register("talc_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(0).harvestTool(ToolType.PICKAXE)));
	public static final Block NETHER_LEAD_ORE = register("nether_lead_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final Block TIN_ORE = register("tin_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final Block ALUMINUM_ORE = register("aluminum_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final Block SILVER_ORE = register("silver_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final Block COPPER_ORE = register("copper_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final Block END_PLATINUM_ORE = register("end_platinum_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(5).harvestTool(ToolType.PICKAXE)));
	public static final Block NETHER_TITANIUM_ORE = register("nether_titanium_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(4).harvestTool(ToolType.PICKAXE)));
	public static final Block PYRITE_ORE = register("pyrite_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(0).harvestTool(ToolType.PICKAXE)));
	public static final Block NIDAVELLIR_STARSTONE_ORE = register("nidavellir_starstone_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(6).harvestTool(ToolType.PICKAXE).setLightLevel(state -> 10)));
	public static final Block NIDAVELLIR_URU_ORE = register("nidavellir_uru_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(9).harvestTool(ToolType.PICKAXE)));
	// TODO remove copper and amethyst ores... :(
	public static final Block TALC_BLOCK = register("talc_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.SNOW).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block LEAD_BLOCK = register("lead_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.LIGHT_GRAY).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block TIN_BLOCK = register("tin_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.LIGHT_GRAY).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block ALUMINUM_BLOCK = register("aluminum_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.LIGHT_GRAY).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block SILVER_BLOCK = register("silver_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.GRAY_TERRACOTTA).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block COPPER_BLOCK = register("copper_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.ORANGE_TERRACOTTA).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block PLATINUM_BLOCK = register("platinum_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.LIGHT_GRAY_TERRACOTTA).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block TITANIUM_BLOCK = register("titanium_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.LIGHT_GRAY_TERRACOTTA).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block PYRITE_BLOCK = register("pyrite_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.GOLD).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block STARSTONE_BLOCK = register("starstone_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.GOLD).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).setLightLevel(state -> 15)));
	public static final Block URU_BLOCK = register("uru_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL)));
	public static final Block STEEL_BLOCK = register("steel_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.GRAY).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final Block HARDENED_STEEL_BLOCK = register("hardened_steel_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.STONE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	
	public static final Block CHISELED_LAPIS_BLOCK = register("chiseled_lapis_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.LAPIS).hardnessAndResistance(0.8F)));
	public static final Block LAPIS_PILLAR = register("lapis_pillar", new RotatedPillarBlock(Block.Properties.create(Material.IRON, MaterialColor.LAPIS).hardnessAndResistance(0.8F)));
	public static final Block LAPIS_STAIRS = register("lapis_stairs", new StairsBlock(Blocks.LAPIS_BLOCK::getDefaultState, Block.Properties.from(Blocks.LAPIS_BLOCK)));
	public static final Block LAPIS_SLAB = register("lapis_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.LAPIS).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block SMOOTH_LAPIS = register("smooth_lapis", new Block(Block.Properties.create(Material.IRON, MaterialColor.LAPIS).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block SMOOTH_LAPIS_STAIRS = register("smooth_lapis_stairs", new StairsBlock(SMOOTH_LAPIS::getDefaultState, Block.Properties.from(SMOOTH_LAPIS)));
	public static final Block SMOOTH_LAPIS_SLAB = register("smooth_lapis_slab", new SlabBlock(Block.Properties.from(SMOOTH_LAPIS)));
	public static final Block LAPIS_BRICKS = register("lapis_bricks", new Block(AbstractBlock.Properties.from(Blocks.LAPIS_BLOCK)));
	
	public static final Block CHISELED_IRON_BLOCK = register("chiseled_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(0.8F)));
	public static final Block IRON_PILLAR = register("iron_pillar", new RotatedPillarBlock(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(0.8F)));
	public static final Block IRON_STAIRS = register("iron_stairs", new StairsBlock(Blocks.IRON_BLOCK::getDefaultState, Block.Properties.from(Blocks.IRON_BLOCK)));
	public static final Block IRON_SLAB = register("iron_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block SMOOTH_IRON = register("smooth_iron", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block SMOOTH_IRON_STAIRS = register("smooth_iron_stairs", new StairsBlock(SMOOTH_IRON::getDefaultState, Block.Properties.from(SMOOTH_IRON)));
	public static final Block SMOOTH_IRON_SLAB = register("smooth_iron_slab", new SlabBlock(Block.Properties.from(SMOOTH_IRON)));
	public static final Block IRON_BRICKS = register("iron_bricks", new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));

	public static final Block CHISELED_GOLD_BLOCK = register("chiseled_gold_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.GOLD).hardnessAndResistance(0.8F)));
	public static final Block GOLD_PILLAR = register("gold_pillar", new RotatedPillarBlock(Block.Properties.create(Material.IRON, MaterialColor.GOLD).hardnessAndResistance(0.8F)));
	public static final Block GOLD_STAIRS = register("gold_stairs", new StairsBlock(Blocks.GOLD_BLOCK::getDefaultState, Block.Properties.from(Blocks.GOLD_BLOCK)));
	public static final Block GOLD_SLAB = register("gold_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.GOLD).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block SMOOTH_GOLD = register("smooth_gold", new Block(Block.Properties.create(Material.IRON, MaterialColor.GOLD).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block SMOOTH_GOLD_STAIRS = register("smooth_gold_stairs", new StairsBlock(SMOOTH_GOLD::getDefaultState, Block.Properties.from(SMOOTH_GOLD)));
	public static final Block SMOOTH_GOLD_SLAB = register("smooth_gold_slab", new SlabBlock(Block.Properties.from(SMOOTH_GOLD)));
	public static final Block GOLD_BRICKS = register("gold_bricks", new Block(AbstractBlock.Properties.from(Blocks.GOLD_BLOCK)));

	public static final Block CHISELED_DIAMOND_BLOCK = register("chiseled_diamond_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).hardnessAndResistance(0.8F)));
	public static final Block DIAMOND_PILLAR = register("diamond_pillar", new RotatedPillarBlock(Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).hardnessAndResistance(0.8F)));
	public static final Block DIAMOND_STAIRS = register("diamond_stairs", new StairsBlock(Blocks.DIAMOND_BLOCK::getDefaultState, Block.Properties.from(Blocks.DIAMOND_BLOCK)));
	public static final Block DIAMOND_SLAB = register("diamond_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block SMOOTH_DIAMOND = register("smooth_diamond", new Block(Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block SMOOTH_DIAMOND_STAIRS = register("smooth_diamond_stairs", new StairsBlock(SMOOTH_DIAMOND::getDefaultState, Block.Properties.from(SMOOTH_DIAMOND)));
	public static final Block SMOOTH_DIAMOND_SLAB = register("smooth_diamond_slab", new SlabBlock(Block.Properties.from(SMOOTH_DIAMOND)));
	public static final Block DIAMOND_BRICKS = register("diamond_bricks", new Block(AbstractBlock.Properties.from(Blocks.DIAMOND_BLOCK)));

	public static final Block CHISELED_EMERALD_BLOCK = register("chiseled_emerald_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.EMERALD).hardnessAndResistance(0.8F)));
	public static final Block EMERALD_PILLAR = register("emerald_pillar", new RotatedPillarBlock(Block.Properties.create(Material.IRON, MaterialColor.EMERALD).hardnessAndResistance(0.8F)));
	public static final Block EMERALD_STAIRS = register("emerald_stairs", new StairsBlock(Blocks.EMERALD_BLOCK::getDefaultState, Block.Properties.from(Blocks.EMERALD_BLOCK)));
	public static final Block EMERALD_SLAB = register("emerald_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.EMERALD).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block SMOOTH_EMERALD = register("smooth_emerald", new Block(Block.Properties.create(Material.IRON, MaterialColor.EMERALD).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block SMOOTH_EMERALD_STAIRS = register("smooth_emerald_stairs", new StairsBlock(SMOOTH_EMERALD::getDefaultState, Block.Properties.from(SMOOTH_EMERALD)));
	public static final Block SMOOTH_EMERALD_SLAB = register("smooth_emerald_slab", new SlabBlock(Block.Properties.from(SMOOTH_EMERALD)));
	public static final Block EMERALD_BRICKS = register("emerald_bricks", new Block(AbstractBlock.Properties.from(Blocks.EMERALD_BLOCK)));
	
	public static final Block CHISELED_REDSTONE_BLOCK = register("chiseled_redstone_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.TNT).hardnessAndResistance(0.8F)));
	public static final Block REDSTONE_PILLAR = register("redstone_pillar", new RotatedPillarBlock(Block.Properties.create(Material.IRON, MaterialColor.TNT).hardnessAndResistance(0.8F)));
	public static final Block REDSTONE_STAIRS = register("redstone_stairs", new StairsBlock(Blocks.REDSTONE_BLOCK::getDefaultState, Block.Properties.from(Blocks.REDSTONE_BLOCK)));
	public static final Block REDSTONE_SLAB = register("redstone_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.TNT).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block SMOOTH_REDSTONE = register("smooth_redstone", new Block(Block.Properties.create(Material.IRON, MaterialColor.TNT).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block SMOOTH_REDSTONE_STAIRS = register("smooth_redstone_stairs", new StairsBlock(SMOOTH_REDSTONE::getDefaultState, Block.Properties.from(SMOOTH_REDSTONE)));
	public static final Block SMOOTH_REDSTONE_SLAB = register("smooth_redstone_slab", new SlabBlock(Block.Properties.from(SMOOTH_REDSTONE)));
	public static final Block REDSTONE_BRICKS = register("redstone_bricks", new Block(AbstractBlock.Properties.from(Blocks.REDSTONE_BLOCK)));

	public static final Block CHISELED_COAL_BLOCK = register("chiseled_coal_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.BLACK).hardnessAndResistance(0.8F)));
	public static final Block COAL_PILLAR = register("coal_pillar", new RotatedPillarBlock(Block.Properties.create(Material.IRON, MaterialColor.BLACK).hardnessAndResistance(0.8F)));
	public static final Block COAL_STAIRS = register("coal_stairs", new StairsBlock(Blocks.COAL_BLOCK::getDefaultState, Block.Properties.from(Blocks.COAL_BLOCK)));
	public static final Block COAL_SLAB = register("coal_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.BLACK).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block SMOOTH_COAL = register("smooth_coal", new Block(Block.Properties.create(Material.IRON, MaterialColor.BLACK).hardnessAndResistance(2.0F, 6.0F)));
	public static final Block SMOOTH_COAL_STAIRS = register("smooth_coal_stairs", new StairsBlock(SMOOTH_COAL::getDefaultState, Block.Properties.from(SMOOTH_COAL)));
	public static final Block SMOOTH_COAL_SLAB = register("smooth_coal_slab", new SlabBlock(Block.Properties.from(SMOOTH_COAL)));
	public static final Block COAL_BRICKS = register("coal_bricks", new Block(AbstractBlock.Properties.from(Blocks.COAL_BLOCK)));
	// TODO check block properties... parity with quartz and with its own block
	public static final Block CHISELED_NETHERITE_BLOCK = register("chiseled_netherite_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.BLACK).hardnessAndResistance(50.0F, 1200.0F)));
	public static final Block NETHERITE_PILLAR = register("netherite_pillar", new RotatedPillarBlock(Block.Properties.create(Material.IRON, MaterialColor.BLACK).hardnessAndResistance(50.0F, 1200.0F)));
	public static final Block NETHERITE_STAIRS = register("netherite_stairs", new StairsBlock(Blocks.NETHERITE_BLOCK::getDefaultState, Block.Properties.from(Blocks.NETHERITE_BLOCK)));
	public static final Block NETHERITE_SLAB = register("netherite_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.BLACK).hardnessAndResistance(50.0F, 1200.0F)));
	public static final Block SMOOTH_NETHERITE = register("smooth_netherite", new Block(Block.Properties.create(Material.IRON, MaterialColor.BLACK).hardnessAndResistance(50.0F, 1200.0F)));
	public static final Block SMOOTH_NETHERITE_STAIRS = register("smooth_netherite_stairs", new StairsBlock(SMOOTH_NETHERITE::getDefaultState, Block.Properties.from(SMOOTH_NETHERITE)));
	public static final Block SMOOTH_NETHERITE_SLAB = register("smooth_netherite_slab", new SlabBlock(Block.Properties.from(SMOOTH_NETHERITE)));
	public static final Block NETHERITE_BRICKS = register("netherite_bricks", new Block(AbstractBlock.Properties.from(Blocks.NETHERITE_BLOCK)));

	public static final Block DREAMCATCHER_CHAOS = register("dreamcatcher_chaos", new DreamcatcherBlock(Block.Properties.create(Material.WOOL, MaterialColor.RED).hardnessAndResistance(0.4F).notSolid(), ParticleTypes.ANGRY_VILLAGER, DreamcatcherBlock::dreamcatcherChaos));
	public static final Block DREAMCATCHER_HEALING = register("dreamcatcher_healing", new DreamcatcherBlock(Block.Properties.create(Material.WOOL, MaterialColor.PINK).hardnessAndResistance(0.4F).notSolid(), ParticleTypes.HEART, DreamcatcherBlock::dreamcatcherHealing));
	public static final Block DREAMCATCHER_LOOT = register("dreamcatcher_loot", new DreamcatcherBlock(Block.Properties.create(Material.WOOL, MaterialColor.YELLOW).hardnessAndResistance(0.4F).notSolid(), ParticleTypes.FALLING_NECTAR, DreamcatcherBlock::dreamcatcherLoot));
	public static final Block DREAMCATCHER_LUCKY = register("dreamcatcher_lucky", new DreamcatcherBlock(Block.Properties.create(Material.WOOL, MaterialColor.GREEN_TERRACOTTA).hardnessAndResistance(0.4F).notSolid(), ParticleTypes.COMPOSTER, DreamcatcherBlock::dreamcatcherLucky));
	public static final Block DREAMCATCHER_NIGHTMARE = register("dreamcatcher_nightmare", new DreamcatcherBlock(Block.Properties.create(Material.WOOL, MaterialColor.STONE).hardnessAndResistance(0.4F).notSolid(), ParticleTypes.WITCH, DreamcatcherBlock::dreamcatcherNightmare));
	public static final Block DREAMCATCHER_RAINBOW = register("dreamcatcher_rainbow", new DreamcatcherBlock(Block.Properties.create(Material.WOOL, MaterialColor.CYAN).hardnessAndResistance(0.4F).notSolid(), ParticleTypes.EFFECT, DreamcatcherBlock::dreamcatcherRainbow));
	public static final Block DREAMCATCHER_RANDOM = register("dreamcatcher_random", new DreamcatcherBlock(Block.Properties.create(Material.WOOL, MaterialColor.BLACK).hardnessAndResistance(0.4F).notSolid(), ParticleTypes.NOTE, DreamcatcherBlock::dreamcatcherRandom));
	public static final Block DREAMCATCHER_SKY = register("dreamcatcher_sky", new DreamcatcherBlock(Block.Properties.create(Material.WOOL, MaterialColor.SNOW).hardnessAndResistance(0.4F).notSolid(), ParticleTypes.CLOUD, DreamcatcherBlock::dreamcatcherSky));
	
	public static final Block CATTAILS = register("cattails", new CattailsTopBlock(AbstractBlock.Properties.create(Material.OCEAN_PLANT).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.WET_GRASS)));
	public static final Block CATTAILS_PLANT = register("cattails_plant", new CattailsBlock(AbstractBlock.Properties.create(Material.OCEAN_PLANT).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.WET_GRASS)));
	
	public static final Block MAPLE_TAP = register("maple_tap", new MapleTapBlock(Block.Properties.create(Material.IRON)));
	public static final Block GROUND_LIGHT = register("ground_light", new GroundLightBlock(Block.Properties.create(Material.GLASS).setLightLevel(state -> 8).hardnessAndResistance(0.5f).doesNotBlockMovement()));
	public static final Block BILLBOARD = register("billboard", new Block(Block.Properties.create(Material.GLASS).setLightLevel(state -> 5).hardnessAndResistance(0.2f).sound(SoundType.GLASS)));
	
	public static final Block CONVEYER = register("conveyer", new ConveyerBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f)));
	public static final Block ICE_SLIME_BLOCK = register("ice_slime_block", new SlimeBlock(Block.Properties.create(Material.CLAY, MaterialColor.ICE).slipperiness(1.98F).sound(SoundType.SLIME).notSolid()));
	
	public static final Block TELEPORTER = register("teleporter", new TeleporterBlock(Block.Properties.create(Material.PORTAL)));
	
	public static final Block UPHOLSTERY_TABLE = register("upholstery_table", new UpholsteryTableBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5f).sound(SoundType.WOOD)));
	
	public static final Block CHAIR = register("chair", new ChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5f).sound(SoundType.WOOD)));
	public static final Block EDGE_STOOL = register("edge_stool", new EdgeStoolBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5f).sound(SoundType.WOOD)));

	public static final Block EDGE_TABLE = register("edge_table", new EdgeTableBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5f).sound(SoundType.WOOD)));
//	public static final Block CUPBOARD;
//	public static final Block LAMP;
	
	// TODO parity with vanilla torches, also, maybe improve from 16 to 18 or something
	public static final Block STARSTONE_TORCH = register("starstone_torch", new TorchBlock(Block.Properties.create(Material.MISCELLANEOUS).setLightLevel(state -> 16).doesNotBlockMovement().hardnessAndResistance(0), ParticleTypesTwo.TWINKLE));
	public static final Block STARSTONE_WALL_TORCH = register("starstone_wall_torch", new WallTorchBlock(Block.Properties.create(Material.MISCELLANEOUS).setLightLevel(state -> 16).doesNotBlockMovement().hardnessAndResistance(0), ParticleTypesTwo.TWINKLE));
	
	public static final Block FLAGSTONE_PATH = register("flagstone_path", new Block(Block.Properties.from(Blocks.GRASS_PATH)));
	
	public static final Block LETTER_A = register("letter_a", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_B = register("letter_b", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_C = register("letter_c", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_D = register("letter_d", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_E = register("letter_e", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_F = register("letter_f", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_G = register("letter_g", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_H = register("letter_h", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_I = register("letter_i", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_J = register("letter_j", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_K = register("letter_k", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_L = register("letter_l", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_M = register("letter_m", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_N = register("letter_n", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_O = register("letter_o", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_P = register("letter_p", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_Q = register("letter_q", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_R = register("letter_r", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_S = register("letter_s", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_T = register("letter_t", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_U = register("letter_u", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_V = register("letter_v", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_W = register("letter_w", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_X = register("letter_x", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_Y = register("letter_y", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block LETTER_Z = register("letter_z", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));

	public static final Block NUMBER_0 = register("number_0", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block NUMBER_1 = register("number_1", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block NUMBER_2 = register("number_2", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block NUMBER_3 = register("number_3", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block NUMBER_4 = register("number_4", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block NUMBER_5 = register("number_5", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block NUMBER_6 = register("number_6", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block NUMBER_7 = register("number_7", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block NUMBER_8 = register("number_8", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	public static final Block NUMBER_9 = register("number_9", new WallDecorationBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));

	
	
	
	
	public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
    	blockRegistryEvent.getRegistry().registerAll(Holder.BLOCKSTWO.toArray(new Block[] {}));
	}
	static Block register(String key, Block block) {
		Holder.BLOCKSTWO.add(block.setRegistryName(key));
		
	    return block;
	}
	static class Holder {
		public static final LinkedList<Block> BLOCKSTWO = new LinkedList<Block>();
	}
}
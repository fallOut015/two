package io.github.fallout015.two.world.biome;

import io.github.fallout015.two.block.BlocksTwo;
import io.github.fallout015.two.entity.EntityTypeTwo;
import io.github.fallout015.two.world.gen.carver.WorldCarverTwo;
import io.github.fallout015.two.world.gen.feature.FeatureTwo;
import io.github.fallout015.two.world.gen.feature.MultiReplaceBlockConfig;
import io.github.fallout015.two.world.gen.placement.PlacementTwo;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.BlockWithContextConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class DefaultBiomeFeaturesTwo {
	public static final BlockWithContextConfig SUCCULIGHT_CONFIG = new BlockWithContextConfig(BlocksTwo.SUCCULIGHT.getDefaultState(), new BlockState[] { Blocks.SAND.getDefaultState() }, new BlockState [] { Blocks.CAVE_AIR.getDefaultState() }, new BlockState [] { Blocks.CAVE_AIR.getDefaultState() });
	public static final BlockWithContextConfig NEONDOT_CONFIG = new BlockWithContextConfig(BlocksTwo.NEONDOT.getDefaultState(), new BlockState[] { BlocksTwo.SPORESTONE_SOIL.getDefaultState() }, new BlockState [] { Blocks.CAVE_AIR.getDefaultState() }, new BlockState [] { Blocks.CAVE_AIR.getDefaultState() });
	public static final BlockWithContextConfig BRIMSHINE_CONFIG = new BlockWithContextConfig(BlocksTwo.BRIMSHINE.getDefaultState(), new BlockState[] { BlocksTwo.SPORESTONE_SOIL.getDefaultState() }, new BlockState [] { Blocks.CAVE_AIR.getDefaultState() }, new BlockState [] { Blocks.CAVE_AIR.getDefaultState() });

	public static final BigMushroomFeatureConfig BIG_NEONDOT = new BigMushroomFeatureConfig(new SimpleBlockStateProvider(BlocksTwo.NEONDOT_CAP.getDefaultState()), new SimpleBlockStateProvider(BlocksTwo.NEONDOT_STEM.getDefaultState()), 2);
	public static final BigMushroomFeatureConfig BIG_BRIMSHINE = new BigMushroomFeatureConfig(new SimpleBlockStateProvider(BlocksTwo.BRIMSHINE_CAP.getDefaultState()), new SimpleBlockStateProvider(BlocksTwo.BRIMSHINE_STEM.getDefaultState()), 3);

	public static void addFeatures() {
    	Biomes.JUNGLE.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FeatureTwo.MAPLE_TREE.withConfiguration(FeatureTwo.MAPLE));
    	Biomes.JUNGLE.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FeatureTwo.CHERRY_TREE.withConfiguration(FeatureTwo.MAPLE));
    	Biomes.JUNGLE.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FeatureTwo.GHOSTWOOD_TREE.withConfiguration(FeatureTwo.GHOSTWOOD));

    	Biomes.SAVANNA.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TANZANITE_ORE.getDefaultState(), 1)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 1))));
    	Biomes.SAVANNA_PLATEAU.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TANZANITE_ORE.getDefaultState(), 1)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 1))));
    	Biomes.SHATTERED_SAVANNA.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TANZANITE_ORE.getDefaultState(), 1)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 1))));
    	Biomes.SHATTERED_SAVANNA_PLATEAU.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TANZANITE_ORE.getDefaultState(), 1)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 1))));
    	
    	for(Biome biomeIn : ForgeRegistries.BIOMES) {
    		if(biomeIn.getCategory() == Category.NETHER) {
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.NETHER_AMETHYST_ORE.getDefaultState(), 6)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 10, 20, 64))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.NETHER_GARNET_ORE.getDefaultState(), 6)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 10, 20, 64))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.NETHER_TOPAZ_ORE.getDefaultState(), 5)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 10, 20, 32))));

    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.NETHER_LEAD_ORE.getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 10, 20, 128))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.NETHER_TITANIUM_ORE.getDefaultState(), 4)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 10, 20, 32))));
    		} else if(biomeIn.getCategory() == Category.THEEND) {
    			if(biomeIn != Biomes.THE_END) {
    				biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.END_STONE, BlocksTwo.END_COBALT_ORE.getDefaultState(), 7)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 32))));
    				biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.END_STONE, BlocksTwo.END_JADE_ORE.getDefaultState(), 7)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 32))));
    				biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.END_STONE, BlocksTwo.END_SAPPHIRE_ORE.getDefaultState(), 7)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 16))));

    				biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.END_STONE, BlocksTwo.END_PLATINUM_ORE.getDefaultState(), 5)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 16))));
    			}
    		} else if(biomeIn.getCategory() != Category.NONE) {
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.OPAL_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 32))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.RUBY_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 32))));
        	
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TALC_ORE.getDefaultState(), 16)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TIN_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 48))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.ALUMINUM_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 42))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.SILVER_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 0, 0, 20))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.COPPER_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 0, 0, 44))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.PYRITE_ORE.getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0, 0, 32))));
    		}
    		
    		desertFeatures();
    		icyFeatures();
    		coldFeatures();
    		mushroomFeatures();
    	}
	}
	public static void addStructures() {
		Biomes.BADLANDS.addStructure(FeatureTwo.ADOBE_WELL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
    	Biomes.BADLANDS_PLATEAU.addStructure(FeatureTwo.ADOBE_WELL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
    	Biomes.ERODED_BADLANDS.addStructure(FeatureTwo.ADOBE_WELL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
    	Biomes.MODIFIED_BADLANDS_PLATEAU.addStructure(FeatureTwo.ADOBE_WELL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
    	Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU.addStructure(FeatureTwo.ADOBE_WELL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
    	Biomes.WOODED_BADLANDS_PLATEAU.addStructure(FeatureTwo.ADOBE_WELL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

//    	Biomes.PLAINS.addStructure(FeatureTwo.DWARVEN_KEEP.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	}
	public static void addSpawns() {
		Biomes.SAVANNA.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.BEARDED_DRAGON, 12, 2, 4));
		Biomes.SAVANNA_PLATEAU.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.BEARDED_DRAGON, 12, 2, 4));
		Biomes.SHATTERED_SAVANNA.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.BEARDED_DRAGON, 12, 2, 4));
		Biomes.SHATTERED_SAVANNA_PLATEAU.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.BEARDED_DRAGON, 12, 2, 4));
		
		
		
    	Biomes.DESERT.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 10, 1, 2));
    	Biomes.DESERT_HILLS.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 8, 1, 2));
    	Biomes.DESERT_LAKES.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 8, 1, 2));
    
    	Biomes.DESERT.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(EntityTypeTwo.MUMMIFIED_ZOMBIE, 5, 1, 2));
    	Biomes.DESERT_HILLS.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(EntityTypeTwo.MUMMIFIED_ZOMBIE, 7, 1, 2));
    	
    	
    	
    	Biomes.JUNGLE.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 12, 2, 4));
    	Biomes.JUNGLE_EDGE.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 4, 2, 4));
    	Biomes.JUNGLE_HILLS.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 10, 2, 4));
    	Biomes.MODIFIED_JUNGLE.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 10, 3, 5));
    	Biomes.MODIFIED_JUNGLE_EDGE.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 8, 3, 5));
	
	
    	
		Biomes.ICE_SPIKES.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(EntityTypeTwo.ICE_SLIME, 90, 1, 3));
		Biomes.DEEP_FROZEN_OCEAN.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(EntityTypeTwo.ICE_SLIME, 70, 1, 3));
		Biomes.DEEP_COLD_OCEAN.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(EntityTypeTwo.ICE_SLIME, 70, 1, 3));
		Biomes.FROZEN_OCEAN.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(EntityTypeTwo.ICE_SLIME, 70, 1, 3));
		Biomes.FROZEN_RIVER.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(EntityTypeTwo.ICE_SLIME, 90, 1, 3));
		Biomes.SNOWY_TUNDRA.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(EntityTypeTwo.ICE_SLIME, 90, 1, 3));
	}
	public static void addCarvers() {
    	for(Biome biomeIn : ForgeRegistries.BIOMES) {
        	biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarverTwo.CAVERN, new ProbabilityConfig(0.01285715F)));
        	biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarverTwo.CAVERN, new ProbabilityConfig(0.01285715F)));
        	biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarverTwo.CAVERN, new ProbabilityConfig(0.01285715F)));

        	biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarverTwo.WIDE_CAVE, new ProbabilityConfig(0.07285715F)));
        	biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarverTwo.WIDE_CAVE, new ProbabilityConfig(0.07285715F)));
        	biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarverTwo.WIDE_CAVE, new ProbabilityConfig(0.07285715F)));
    	}
	}
	
	private static void desertFeatures() {
		Biomes.DESERT.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();
		Biomes.DESERT_HILLS.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();
		Biomes.DESERT_LAKES.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();

		Biomes.DESERT.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).removeIf(configuredFeature -> configuredFeature.feature == Feature.SPRING_FEATURE && configuredFeature.config == DefaultBiomeFeatures.LAVA_SPRING_CONFIG);
		Biomes.DESERT_HILLS.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).removeIf(configuredFeature -> configuredFeature.feature == Feature.SPRING_FEATURE && configuredFeature.config == DefaultBiomeFeatures.LAVA_SPRING_CONFIG);
		Biomes.DESERT_LAKES.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).removeIf(configuredFeature -> configuredFeature.feature == Feature.SPRING_FEATURE && configuredFeature.config == DefaultBiomeFeatures.LAVA_SPRING_CONFIG);
		
		
		
		Biomes.DESERT.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureTwo.MULTI_REPLACE_BLOCK.withConfiguration(new MultiReplaceBlockConfig(Blocks.STONE.getDefaultState(), Blocks.SMOOTH_SANDSTONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.SAND.getDefaultState())).withPlacement(PlacementTwo.PLACE_ALL_TO_64.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		Biomes.DESERT_HILLS.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureTwo.MULTI_REPLACE_BLOCK.withConfiguration(new MultiReplaceBlockConfig(Blocks.STONE.getDefaultState(), Blocks.SMOOTH_SANDSTONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.SAND.getDefaultState())).withPlacement(PlacementTwo.PLACE_ALL_TO_64.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		Biomes.DESERT_LAKES.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureTwo.MULTI_REPLACE_BLOCK.withConfiguration(new MultiReplaceBlockConfig(Blocks.STONE.getDefaultState(), Blocks.SMOOTH_SANDSTONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.SAND.getDefaultState())).withPlacement(PlacementTwo.PLACE_ALL_TO_64.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

		Biomes.DESERT.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureTwo.REPLACE_BLOCK.withConfiguration(new ReplaceBlockConfig(Blocks.SMOOTH_SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState())).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(256))));
		Biomes.DESERT_HILLS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureTwo.REPLACE_BLOCK.withConfiguration(new ReplaceBlockConfig(Blocks.SMOOTH_SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState())).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(256))));
		Biomes.DESERT_LAKES.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureTwo.REPLACE_BLOCK.withConfiguration(new ReplaceBlockConfig(Blocks.SMOOTH_SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState())).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(256))));
		
		// add biome seams
		
		// unrelated : for desert biomes add more vegetation and add dunes, with very little vegetation
		// also sandstorms
		
		Biomes.DESERT.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(SUCCULIGHT_CONFIG).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(1, 8, 32, 64))));
		Biomes.DESERT_HILLS.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(SUCCULIGHT_CONFIG).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(1, 8, 32, 64))));
		Biomes.DESERT_LAKES.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(SUCCULIGHT_CONFIG).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(1, 8, 32, 64))));
		
		
		
		Biomes.DESERT.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.SMOOTH_SANDSTONE, BlocksTwo.DESERT_COAL_ORE.getDefaultState(), 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(18, 0, 0, 64))));
		Biomes.DESERT.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.SMOOTH_SANDSTONE, BlocksTwo.DESERT_IRON_ORE.getDefaultState(), 18)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 0, 0, 48))));
		Biomes.DESERT.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.SMOOTH_SANDSTONE, BlocksTwo.DESERT_GOLD_ORE.getDefaultState(), 18)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0, 0, 48))));
		Biomes.DESERT.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.SMOOTH_SANDSTONE, BlocksTwo.DESERT_COPPER_ORE.getDefaultState(), 18)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 0, 0, 48))));
		Biomes.DESERT_HILLS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.SMOOTH_SANDSTONE, BlocksTwo.DESERT_COAL_ORE.getDefaultState(), 18)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(18, 0, 0, 64))));
		Biomes.DESERT_HILLS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.SMOOTH_SANDSTONE, BlocksTwo.DESERT_IRON_ORE.getDefaultState(), 18)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 0, 0, 48))));
		Biomes.DESERT_HILLS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.SMOOTH_SANDSTONE, BlocksTwo.DESERT_GOLD_ORE.getDefaultState(), 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0, 0, 48))));
		Biomes.DESERT_HILLS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.SMOOTH_SANDSTONE, BlocksTwo.DESERT_COPPER_ORE.getDefaultState(), 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0, 0, 28))));
		Biomes.DESERT_LAKES.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.SMOOTH_SANDSTONE, BlocksTwo.DESERT_COAL_ORE.getDefaultState(), 18)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(18, 0, 0, 64))));
		Biomes.DESERT_LAKES.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.SMOOTH_SANDSTONE, BlocksTwo.DESERT_IRON_ORE.getDefaultState(), 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 0, 0, 48))));
		Biomes.DESERT_LAKES.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.SMOOTH_SANDSTONE, BlocksTwo.DESERT_GOLD_ORE.getDefaultState(), 18)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0, 0, 48))));
		Biomes.DESERT_LAKES.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.SMOOTH_SANDSTONE, BlocksTwo.DESERT_COPPER_ORE.getDefaultState(), 18)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0, 0, 28))));
	}
	private static void icyFeatures() {
		Biomes.ICE_SPIKES.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();
		Biomes.DEEP_FROZEN_OCEAN.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();
		Biomes.DEEP_COLD_OCEAN.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();
		Biomes.FROZEN_OCEAN.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();
		Biomes.FROZEN_RIVER.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();
		Biomes.SNOWY_TUNDRA.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();

		Biomes.ICE_SPIKES.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, FeatureTwo.REPLACE_BLOCK.withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState())).withPlacement(PlacementTwo.PLACE_ALL_TO_64.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		Biomes.DEEP_FROZEN_OCEAN.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, FeatureTwo.REPLACE_BLOCK.withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState())).withPlacement(PlacementTwo.PLACE_ALL_TO_64.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		Biomes.DEEP_COLD_OCEAN.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, FeatureTwo.REPLACE_BLOCK.withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState())).withPlacement(PlacementTwo.PLACE_ALL_TO_64.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		Biomes.FROZEN_OCEAN.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, FeatureTwo.REPLACE_BLOCK.withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState())).withPlacement(PlacementTwo.PLACE_ALL_TO_64.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		Biomes.FROZEN_RIVER.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, FeatureTwo.REPLACE_BLOCK.withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState())).withPlacement(PlacementTwo.PLACE_ALL_TO_64.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		Biomes.SNOWY_TUNDRA.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, FeatureTwo.REPLACE_BLOCK.withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState())).withPlacement(PlacementTwo.PLACE_ALL_TO_64.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	}
	private static void coldFeatures() {
		// cold oceans, taiga, snowy mountains, etc.
	}
	private static void mushroomFeatures() {
		Biomes.MUSHROOM_FIELD_SHORE.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();
		Biomes.MUSHROOM_FIELDS.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();
		
		
		
		Biomes.MUSHROOM_FIELD_SHORE.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureTwo.MULTI_REPLACE_BLOCK.withConfiguration(new MultiReplaceBlockConfig(Blocks.STONE.getDefaultState(), BlocksTwo.SPORESTONE.getDefaultState(), Blocks.STONE.getDefaultState(), BlocksTwo.SPORESTONE_SOIL.getDefaultState())).withPlacement(PlacementTwo.PLACE_ALL_TO_64.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		Biomes.MUSHROOM_FIELDS.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureTwo.MULTI_REPLACE_BLOCK.withConfiguration(new MultiReplaceBlockConfig(Blocks.STONE.getDefaultState(), BlocksTwo.SPORESTONE.getDefaultState(), Blocks.STONE.getDefaultState(), BlocksTwo.SPORESTONE_SOIL.getDefaultState())).withPlacement(PlacementTwo.PLACE_ALL_TO_64.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

	
	
		Biomes.MUSHROOM_FIELD_SHORE.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(NEONDOT_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(7))));
		Biomes.MUSHROOM_FIELDS.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(NEONDOT_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(8))));
		
		Biomes.MUSHROOM_FIELD_SHORE.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(BRIMSHINE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(7))));
		Biomes.MUSHROOM_FIELDS.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(BRIMSHINE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(8))));
	
	
		
		Biomes.MUSHROOM_FIELD_SHORE.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureTwo.HUGE_NEONDOT.withConfiguration(BIG_NEONDOT).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 32, 32))));
		Biomes.MUSHROOM_FIELDS.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureTwo.HUGE_NEONDOT.withConfiguration(BIG_NEONDOT).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 32, 32))));

		Biomes.MUSHROOM_FIELD_SHORE.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureTwo.HUGE_BRIMSHINE.withConfiguration(BIG_BRIMSHINE).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 32, 32))));
		Biomes.MUSHROOM_FIELDS.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureTwo.HUGE_BRIMSHINE.withConfiguration(BIG_BRIMSHINE).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 32, 32))));
	}
}
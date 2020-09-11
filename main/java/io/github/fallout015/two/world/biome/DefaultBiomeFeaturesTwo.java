package io.github.fallout015.two.world.biome;

import io.github.fallout015.two.block.BlocksTwo;
import io.github.fallout015.two.entity.EntityTypeTwo;
import io.github.fallout015.two.world.gen.carver.WorldCarverTwo;
import io.github.fallout015.two.world.gen.feature.FeatureTwo;
import io.github.fallout015.two.world.gen.feature.FeaturesTwo;
import io.github.fallout015.two.world.gen.feature.MultiReplaceBlockConfig;
import io.github.fallout015.two.world.gen.placement.PlacementTwo;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.BlockWithContextConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
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

	public static void addFeatures() {
		
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
//		Savanna.addBeardedDragons();
//		SavannaPlateau.addBeardedDragons();
//		ShatteredSavanna.addBeardedDragons();
//		ShatteredSavannaPlateau.addBeardedDragons();
		
//		Desert.addChameleons(10, 1, 2);
//		DesertHills.addChameleons(8, 1, 2);
//		DesertLakes.addChameleons(8, 1, 2);
		
    	Biomes.DESERT.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(EntityTypeTwo.MUMMIFIED_ZOMBIE, 5, 1, 2));
    	Biomes.DESERT_HILLS.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(EntityTypeTwo.MUMMIFIED_ZOMBIE, 7, 1, 2));
    	
//    	Jungle.addChameleons(12, 2, 4);
//    	JungleEdge.addChameleons(4, 2, 4);
//    	JungleHills.addChameleons(10, 2, 4);
//    	ModifiedJungle.addChameleons(10, 3, 5);
//    	ModifiedJungleEdge.addChameleons(8, 3, 5);
	
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
	
	public static void addOverworldOres(BiomeGenerationSettings.Builder builder) {
		// Desert
		// reset desert ores
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_DESERT_IRON);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_DESERT_COAL);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_DESERT_COPPER);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_DESERT_GOLD);
		// else if for other underground regions, else for overworld
		
		// Overworld
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_ALUMINUM);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_COPPER);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_OPAL);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_PYRITE);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_RUBY);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_SILVER);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_TALC);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_TIN);
		
		// Acacia
		// in addition to the overworld ores
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_TANZANITE);
	}
	public static void addNetherOres(BiomeGenerationSettings.Builder builder) {
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_NETHER_AMETHYST);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_NETHER_GARNET);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_NETHER_LEAD);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_NETHER_TITANIUM);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_NETHER_TOPAZ);
	}
	public static void addEndOres(BiomeGenerationSettings.Builder builder) {
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_END_COBALT);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_END_JADE);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_END_PLATINUM);
		builder.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, FeaturesTwo.ORE_END_SAPPHIRE);
	}
	
	public static void addChameleons(MobSpawnInfo.Builder builder, int weight, int minCount, int maxCount) {
		builder.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityTypeTwo.CHAMELEON, weight, minCount, maxCount));
	}
	public static void addBeardedDragons(MobSpawnInfo.Builder builder) {
		builder.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityTypeTwo.BEARDED_DRAGON, 12, 2, 4));
	}
}
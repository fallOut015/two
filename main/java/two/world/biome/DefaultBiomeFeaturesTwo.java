package two.world.biome;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import two.block.BlocksTwo;
import two.entity.EntityTypeTwo;
import two.world.gen.feature.FeatureTwo;

public class DefaultBiomeFeaturesTwo {
	public static void addFeatures() {
    	Biomes.JUNGLE.addFeature(Decoration.VEGETAL_DECORATION, FeatureTwo.MAPLE_TREE.withConfiguration(FeatureTwo.MAPLE));
    	Biomes.JUNGLE.addFeature(Decoration.VEGETAL_DECORATION, FeatureTwo.CHERRY_TREE.withConfiguration(FeatureTwo.MAPLE));
    	Biomes.JUNGLE.addFeature(Decoration.VEGETAL_DECORATION, FeatureTwo.GHOSTWOOD_TREE.withConfiguration(FeatureTwo.GHOSTWOOD));

    	Biomes.SAVANNA.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TANZANITE_ORE.getDefaultState(), 1)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 1))));
    	Biomes.SAVANNA_PLATEAU.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TANZANITE_ORE.getDefaultState(), 1)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 1))));
    	Biomes.SHATTERED_SAVANNA.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TANZANITE_ORE.getDefaultState(), 1)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 1))));
    	Biomes.SHATTERED_SAVANNA_PLATEAU.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TANZANITE_ORE.getDefaultState(), 1)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 1))));

    	for(Biome biomeIn : ForgeRegistries.BIOMES) {
    		if(biomeIn.getCategory() == Category.NETHER) {
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.AMETHYST_ORE.getDefaultState(), 6)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 10, 20, 64))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.GARNET_ORE.getDefaultState(), 6)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 10, 20, 64))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.TOPAZ_ORE.getDefaultState(), 5)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 10, 20, 32))));

    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.LEAD_ORE.getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 10, 20, 128))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.TITANIUM_ORE.getDefaultState(), 4)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 10, 20, 32))));
    		} else if(biomeIn.getCategory() == Category.THEEND) {
    			if(biomeIn != Biomes.THE_END) {
    				biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.END_STONE, BlocksTwo.COBALT_ORE.getDefaultState(), 7)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 32))));
    				biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.END_STONE, BlocksTwo.JADE_ORE.getDefaultState(), 7)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 32))));
    				biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.END_STONE, BlocksTwo.SAPPHIRE_ORE.getDefaultState(), 7)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 16))));

    				biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(FeatureTwo.END_STONE, BlocksTwo.PLATINUM_ORE.getDefaultState(), 5)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 16))));
    			}
    		} else if(biomeIn.getCategory() != Category.NONE) {
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.OPAL_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 32))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.RUBY_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 32))));
        	
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TALC_ORE.getDefaultState(), 17)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TIN_ORE.getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.ALUMINUM_ORE.getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.SILVER_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 0, 0, 20))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.COPPER_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.PYRITE_ORE.getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0, 0, 32))));
    		}
    		// Other ore generation is handled in the new biomes' classes. 
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
    	Biomes.DESERT.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 10, 1, 2));
    	Biomes.DESERT_HILLS.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 8, 1, 2));
    	Biomes.DESERT_LAKES.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 8, 1, 2));
    	
    	Biomes.JUNGLE.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 12, 2, 4));
    	Biomes.JUNGLE_EDGE.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 4, 2, 4));
    	Biomes.JUNGLE_HILLS.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 10, 2, 4));
    	Biomes.MODIFIED_JUNGLE.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 10, 3, 5));
    	Biomes.MODIFIED_JUNGLE_EDGE.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 8, 3, 5));
	}
}
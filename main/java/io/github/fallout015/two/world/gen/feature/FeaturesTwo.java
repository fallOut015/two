package io.github.fallout015.two.world.gen.feature;

import com.google.common.collect.ImmutableList;

import io.github.fallout015.two.block.BlocksTwo;
import io.github.fallout015.two.world.gen.placement.PlacementTwo;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.BlockWithContextConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

// Not to be confused with FeatureTwo. These are specific features, i.e., features with configs. And blockstate references. These are NOT registered, this class is more for convenience
// Also has configs, placements, and states. 

public class FeaturesTwo { // Configured features with placements. 
	// Trees
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MAPLE = register("maple", Feature.field_236291_c_.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FeaturesTwo.States.MAPLE_LOG), new SimpleBlockStateProvider(FeaturesTwo.States.MAPLE_LEAVES), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).func_236700_a_().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY = register("cherry", Feature.field_236291_c_.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FeaturesTwo.States.CHERRY_LOG), new SimpleBlockStateProvider(FeaturesTwo.States.CHERRY_LEAVES), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).func_236700_a_().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> GHOSTWOOD = register("ghostwood", Feature.field_236291_c_.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FeaturesTwo.States.GHOSTWOOD_LOG), new SimpleBlockStateProvider(FeaturesTwo.States.GHOSTWOOD_LEAVES), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).func_236700_a_().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CLOUDWOOD = register("cloudwood", Feature.field_236291_c_.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FeaturesTwo.States.CLOUDWOOD_LOG), new SimpleBlockStateProvider(FeaturesTwo.States.CLOUDWOOD_LEAVES), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).func_236700_a_().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BLACKBARK = register("blackbark", Feature.field_236291_c_.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FeaturesTwo.States.BLACKBARK_LOG), new SimpleBlockStateProvider(FeaturesTwo.States.BLACKBARK_LEAVES), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).func_236700_a_().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FROSTBARK = register("frostbark", Feature.field_236291_c_.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FeaturesTwo.States.FROSTBARK_LOG), new SimpleBlockStateProvider(FeaturesTwo.States.FROSTBARK_LEAVES), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).func_236700_a_().build()));
	// Ores
	public static final ConfiguredFeature<?, ?> ORE_DESERT_COAL = register("ore_desert_coal", Feature.ORE.withConfiguration(new OreFeatureConfig(FeaturesTwo.RuleTests.SMOOTH_SANDSTONE, FeaturesTwo.States.DESERT_COAL_ORE, 20/*size*/)).func_242733_d(128/*y max*/).func_242728_a().func_242731_b(20 /*spread*/));
	public static final ConfiguredFeature<?, ?> ORE_DESERT_IRON = register("ore_desert_iron", Feature.ORE.withConfiguration(new OreFeatureConfig(FeaturesTwo.RuleTests.SMOOTH_SANDSTONE, FeaturesTwo.States.DESERT_IRON_ORE, 18)).func_242733_d(64).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_DESERT_GOLD = register("ore_desert_gold", Feature.ORE.withConfiguration(new OreFeatureConfig(FeaturesTwo.RuleTests.SMOOTH_SANDSTONE, FeaturesTwo.States.DESERT_GOLD_ORE, 18)).func_242733_d(48).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_DESERT_COPPER = register("ore_desert_copper", Feature.ORE.withConfiguration(new OreFeatureConfig(FeaturesTwo.RuleTests.SMOOTH_SANDSTONE, FeaturesTwo.States.DESERT_COPPER_ORE, 18)).func_242733_d(48).func_242728_a().func_242731_b(20));

	public static final ConfiguredFeature<?, ?> ORE_END_COBALT = register("ore_end_cobalt", Feature.ORE.withConfiguration(new OreFeatureConfig(FeaturesTwo.RuleTests.END_STONE, FeaturesTwo.States.END_COBALT_ORE, 7)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_END_JADE = register("ore_end_jade", Feature.ORE.withConfiguration(new OreFeatureConfig(FeaturesTwo.RuleTests.END_STONE, FeaturesTwo.States.END_JADE_ORE, 7)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_OPAL = register("ore_opal", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, FeaturesTwo.States.OPAL_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_TANZANITE = register("ore_tanzanite", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, FeaturesTwo.States.TANZANITE_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_NETHER_AMETHYST = register("ore_nether_amethyst", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241883_b, FeaturesTwo.States.NETHER_AMETHYST_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_NETHER_GARNET = register("ore_nether_garnet", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241883_b, FeaturesTwo.States.NETHER_GARNET_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_NETHER_TOPAZ = register("ore_nether_topaz", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241883_b, FeaturesTwo.States.NETHER_TOPAZ_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_END_SAPPHIRE = register("ore_end_sapphire", Feature.ORE.withConfiguration(new OreFeatureConfig(FeaturesTwo.RuleTests.END_STONE, FeaturesTwo.States.END_SAPPHIRE_ORE, 7)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_RUBY = register("ore_ruby", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, FeaturesTwo.States.RUBY_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_NIDAVELLIR_CELESTIUM = register("ore_nidavellir_celestium", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, FeaturesTwo.States.NIDAVELLIR_CELESTIUM_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));

	public static final ConfiguredFeature<?, ?> ORE_TALC = register("ore_talc", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, FeaturesTwo.States.TALC_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_NETHER_LEAD = register("ore_nether_lead", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241883_b, FeaturesTwo.States.NETHER_LEAD_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_TIN = register("ore_tin", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, FeaturesTwo.States.TIN_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_ALUMINUM = register("ore_aluminum", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, FeaturesTwo.States.ALUMINUM_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_SILVER = register("ore_silver", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, FeaturesTwo.States.SILVER_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_COPPER = register("ore_copper", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, FeaturesTwo.States.COPPER_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_END_PLATINUM = register("ore_end_platinum", Feature.ORE.withConfiguration(new OreFeatureConfig(FeaturesTwo.RuleTests.END_STONE, FeaturesTwo.States.END_PLATINUM_ORE, 5)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_NETHER_TITANIUM = register("ore_nether_titanium", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241883_b, FeaturesTwo.States.NETHER_TITANIUM_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_PYRITE = register("ore_pyrite", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, FeaturesTwo.States.PYRITE_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_NIDAVELLIR_STARSTONE = register("ore_nidavellir_starstone", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, FeaturesTwo.States.NIDAVELLIR_STARSTONE_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ORE_NIDAVELLIR_URU = register("ore_nidavellir_uru", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, FeaturesTwo.States.NIDAVELLIR_URU_ORE, 17)).func_242733_d(128).func_242728_a().func_242731_b(20));
	// Mushrooms
	public static final ConfiguredFeature<?, ?> HUGE_NEONDOT = register("huge_neondot", FeatureTwo.HUGE_NEONDOT.withConfiguration(new BigMushroomFeatureConfig(new SimpleBlockStateProvider(FeaturesTwo.States.NEONDOT_CAP), new SimpleBlockStateProvider(FeaturesTwo.States.NEONDOT_STEM), 2)));
	public static final ConfiguredFeature<?, ?> HUGE_BRIMSHINE = register("huge_brimshine", FeatureTwo.HUGE_BRIMSHINE.withConfiguration(new BigMushroomFeatureConfig(new SimpleBlockStateProvider(FeaturesTwo.States.BRIMSHINE_CAP), new SimpleBlockStateProvider(FeaturesTwo.States.BRIMSHINE_STEM), 3)));
	// Stone Replacers
	public static final ConfiguredFeature<?, ?> DESERT_STONE_REPLACER = register("desert_stone_replacer", FeatureTwo.MULTI_REPLACE_BLOCK.withConfiguration(new MultiReplaceBlockConfig(Blocks.STONE.getDefaultState(), Blocks.SMOOTH_SANDSTONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.SAND.getDefaultState())).withPlacement(PlacementTwo.PLACE_ALL_TO_64.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
//	public static final ConfiguredFeature<?, ?> DESERT_SANDSTONE_PLACER = register("desert_sandstone_placer", FeatureTwo.REPLACE_BLOCK.withConfiguration(new ReplaceBlockConfig(Blocks.SMOOTH_SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState())).withPlacement(Placement.field_242902_f.configure(new FrequencyConfig(256))));
	
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
		return configuredFeature;
	}

	public static final class Configs {
		public static final BlockWithContextConfig NEONDOT_CONFIG = new BlockWithContextConfig(FeaturesTwo.States.NEONDOT, ImmutableList.of(FeaturesTwo.States.SPORESTONE_SOIL), ImmutableList.of(FeaturesTwo.States.CAVE_AIR), ImmutableList.of());
		public static final BlockWithContextConfig BRIMSHINE_CONFIG = new BlockWithContextConfig(FeaturesTwo.States.BRIMSHINE, ImmutableList.of(FeaturesTwo.States.SPORESTONE_SOIL), ImmutableList.of(FeaturesTwo.States.CAVE_AIR), ImmutableList.of());
	}
	
	public static final class Placements { // references to the PlacementTwo class (with configs).
	}
	
	public static final class States { // values of block states.
		protected static final BlockState CHERRY_LOG = BlocksTwo.CHERRY_LOG.getDefaultState();
		protected static final BlockState CHERRY_LEAVES = BlocksTwo.CHERRY_LEAVES.getDefaultState();
		protected static final BlockState MAPLE_LEAVES = BlocksTwo.MAPLE_LEAVES.getDefaultState();
		protected static final BlockState MAPLE_LOG = BlocksTwo.MAPLE_LOG.getDefaultState();
		protected static final BlockState GHOSTWOOD_LOG = BlocksTwo.GHOSTWOOD_LOG.getDefaultState();
		protected static final BlockState GHOSTWOOD_LEAVES = BlocksTwo.GHOSTWOOD_LEAVES.getDefaultState();
		protected static final BlockState CLOUDWOOD_LOG = BlocksTwo.CLOUDWOOD_LOG.getDefaultState();
		protected static final BlockState CLOUDWOOD_LEAVES = BlocksTwo.CLOUDWOOD_LEAVES.getDefaultState();
		protected static final BlockState BLACKBARK_LOG = BlocksTwo.BLACKBARK_LOG.getDefaultState();
		protected static final BlockState BLACKBARK_LEAVES = BlocksTwo.BLACKBARK_LEAVES.getDefaultState();
		protected static final BlockState FROSTBARK_LOG = BlocksTwo.FROSTBARK_LOG.getDefaultState();
		protected static final BlockState FROSTBARK_LEAVES = BlocksTwo.FROSTBARK_LEAVES.getDefaultState();

		protected static final BlockState DESERT_COAL_ORE = BlocksTwo.DESERT_COAL_ORE.getDefaultState();
		protected static final BlockState DESERT_IRON_ORE = BlocksTwo.DESERT_IRON_ORE.getDefaultState();
		protected static final BlockState DESERT_GOLD_ORE = BlocksTwo.DESERT_GOLD_ORE.getDefaultState();
		protected static final BlockState DESERT_COPPER_ORE = BlocksTwo.DESERT_COPPER_ORE.getDefaultState();

		protected static final BlockState END_COBALT_ORE = BlocksTwo.END_COBALT_ORE.getDefaultState();
		protected static final BlockState END_JADE_ORE = BlocksTwo.END_JADE_ORE.getDefaultState();
		protected static final BlockState OPAL_ORE = BlocksTwo.OPAL_ORE.getDefaultState();
		protected static final BlockState TANZANITE_ORE = BlocksTwo.TANZANITE_ORE.getDefaultState();
		protected static final BlockState NETHER_AMETHYST_ORE = BlocksTwo.NETHER_AMETHYST_ORE.getDefaultState();
		protected static final BlockState NETHER_GARNET_ORE = BlocksTwo.NETHER_GARNET_ORE.getDefaultState();
		protected static final BlockState NETHER_TOPAZ_ORE = BlocksTwo.NETHER_TOPAZ_ORE.getDefaultState();
		protected static final BlockState END_SAPPHIRE_ORE = BlocksTwo.END_SAPPHIRE_ORE.getDefaultState();
		protected static final BlockState RUBY_ORE = BlocksTwo.RUBY_ORE.getDefaultState();
		protected static final BlockState NIDAVELLIR_CELESTIUM_ORE = BlocksTwo.NIDAVELLIR_CELESTIUM_ORE.getDefaultState();
	
		protected static final BlockState TALC_ORE = BlocksTwo.TALC_ORE.getDefaultState();
		protected static final BlockState NETHER_LEAD_ORE = BlocksTwo.NETHER_LEAD_ORE.getDefaultState();
		protected static final BlockState TIN_ORE = BlocksTwo.TIN_ORE.getDefaultState();
		protected static final BlockState ALUMINUM_ORE = BlocksTwo.ALUMINUM_ORE.getDefaultState();
		protected static final BlockState SILVER_ORE = BlocksTwo.SILVER_ORE.getDefaultState();
		protected static final BlockState COPPER_ORE = BlocksTwo.COPPER_ORE.getDefaultState();
		protected static final BlockState END_PLATINUM_ORE = BlocksTwo.END_PLATINUM_ORE.getDefaultState();
		protected static final BlockState NETHER_TITANIUM_ORE = BlocksTwo.NETHER_TITANIUM_ORE.getDefaultState();
		protected static final BlockState PYRITE_ORE = BlocksTwo.PYRITE_ORE.getDefaultState();
		protected static final BlockState NIDAVELLIR_STARSTONE_ORE = BlocksTwo.NIDAVELLIR_STARSTONE_ORE.getDefaultState();
		protected static final BlockState NIDAVELLIR_URU_ORE = BlocksTwo.NIDAVELLIR_URU_ORE.getDefaultState();
		
		protected static final BlockState NEONDOT_CAP = BlocksTwo.NEONDOT_CAP.getDefaultState();
		protected static final BlockState NEONDOT_STEM = BlocksTwo.NEONDOT_STEM.getDefaultState();
		protected static final BlockState BRIMSHINE_CAP = BlocksTwo.BRIMSHINE_CAP.getDefaultState();
		protected static final BlockState BRIMSHINE_STEM = BlocksTwo.BRIMSHINE_STEM.getDefaultState();

		protected static final BlockState NEONDOT = BlocksTwo.NEONDOT.getDefaultState();
		protected static final BlockState BRIMSHINE = BlocksTwo.NEONDOT.getDefaultState();
		
		protected static final BlockState SPORESTONE_SOIL = BlocksTwo.SPORESTONE_SOIL.getDefaultState();
	
		protected static final BlockState CAVE_AIR = Blocks.CAVE_AIR.getDefaultState();
	}
	
	public static final class RuleTests {
		public static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);
		public static final RuleTest SMOOTH_SANDSTONE = new BlockMatchRuleTest(Blocks.SMOOTH_SANDSTONE);
//		OreFeatureConfig.FillerBlockType NIGHTSTONE = OreFeatureConfig.FillerBlockType.create("nightstone", "", BlockMatcher.forBlock(BlocksTwo.NIGHTSTONE));
//		OreFeatureConfig.FillerBlockType PACKED_ICE = OreFeatureConfig.FillerBlockType.create("packed_ice", "", BlockMatcher.forBlock(Blocks.PACKED_ICE));
//		public static final OreFeatureConfig.FillerBlockType MYRKYLITE = OreFeatureConfig.FillerBlockType.create("two:MYRKYLITE", "two:myrkylite", BlockMatcher.forBlock(BlocksTwo.MYRKYLITE));
	}
}
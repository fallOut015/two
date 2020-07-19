package two.world.gen.feature;

import java.util.LinkedList;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockWithContextConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.feature.ReplaceBlockFeature;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import two.block.BlocksTwo;
import two.world.gen.feature.structure.AdobeWellStructure;
import two.world.gen.feature.structure.DwarvenKeepStructure;

@SuppressWarnings("unchecked")
public class FeatureTwo {
	public static final OreFeatureConfig.FillerBlockType END_STONE = OreFeatureConfig.FillerBlockType.create("two:END_STONE", "two:end_stone", BlockMatcher.forBlock(Blocks.END_STONE));
	public static final OreFeatureConfig.FillerBlockType SMOOTH_SANDSTONE = OreFeatureConfig.FillerBlockType.create("two:SMOOTH_SANDSTONE", "two:smooth_sandstone", BlockMatcher.forBlock(Blocks.SMOOTH_SANDSTONE));
//	OreFeatureConfig.FillerBlockType NIGHTSTONE = OreFeatureConfig.FillerBlockType.create("nightstone", "", BlockMatcher.forBlock(BlocksTwo.NIGHTSTONE));
//	OreFeatureConfig.FillerBlockType PACKED_ICE = OreFeatureConfig.FillerBlockType.create("packed_ice", "", BlockMatcher.forBlock(Blocks.PACKED_ICE));
	public static final OreFeatureConfig.FillerBlockType MYRKYLITE = OreFeatureConfig.FillerBlockType.create("two:MYRKYLITE", "two:myrkylite", BlockMatcher.forBlock(BlocksTwo.MYRKYLITE));
	
	private static final BlockState CHERRY_LOG = BlocksTwo.CHERRY_LOG.getDefaultState();
	private static final BlockState MAPLE_LOG = BlocksTwo.MAPLE_LOG.getDefaultState();
	private static final BlockState GHOSTWOOD_LOG = BlocksTwo.GHOSTWOOD_LOG.getDefaultState();
	private static final BlockState CLOUDWOOD_LOG = BlocksTwo.CLOUDWOOD_LOG.getDefaultState();
	private static final BlockState BLACKBARK_LOG = BlocksTwo.BLACKBARK_LOG.getDefaultState();
	private static final BlockState FROSTBARK_LOG = BlocksTwo.FROSTBARK_LOG.getDefaultState();
	
	private static final BlockState CHERRY_LEAVES = BlocksTwo.CHERRY_LEAVES.getDefaultState();
	private static final BlockState MAPLE_LEAVES = BlocksTwo.MAPLE_LEAVES.getDefaultState();
	private static final BlockState GHOSTWOOD_LEAVES = BlocksTwo.GHOSTWOOD_LEAVES.getDefaultState();
	private static final BlockState CLOUDWOOD_LEAVES = BlocksTwo.CLOUDWOOD_LEAVES.getDefaultState();
	private static final BlockState BLACKBARK_LEAVES = BlocksTwo.BLACKBARK_LEAVES.getDefaultState();
	private static final BlockState FROSTBARK_LEAVES = BlocksTwo.FROSTBARK_LEAVES.getDefaultState();
	
	public static final TreeFeatureConfig CHERRY = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CHERRY_LOG), new SimpleBlockStateProvider(CHERRY_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(5).heightRandA(2).heightRandB(3).ignoreVines().setSapling((IPlantable) BlocksTwo.CHERRY_SAPLING).build();
	public static final TreeFeatureConfig MAPLE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(MAPLE_LOG), new SimpleBlockStateProvider(MAPLE_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(5).heightRandA(2).heightRandB(3).ignoreVines().setSapling((IPlantable) BlocksTwo.MAPLE_SAPLING).build();
	public static final TreeFeatureConfig GHOSTWOOD = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(GHOSTWOOD_LOG), new SimpleBlockStateProvider(GHOSTWOOD_LEAVES), new BlobFoliagePlacer(0, 0))).baseHeight(5).heightRandA(2).heightRandB(3).trunkHeight(0).ignoreVines().setSapling((IPlantable) BlocksTwo.GHOSTWOOD_SAPLING).build();
	public static final TreeFeatureConfig CLOUDWOOD = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CLOUDWOOD_LOG), new SimpleBlockStateProvider(CLOUDWOOD_LEAVES), new BlobFoliagePlacer(0, 0))).baseHeight(2).heightRandA(0).heightRandB(0).trunkHeight(0).ignoreVines().setSapling((IPlantable) BlocksTwo.CLOUDWOOD_SAPLING).build();
	public static final TreeFeatureConfig BLACKBARK = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BLACKBARK_LOG), new SimpleBlockStateProvider(BLACKBARK_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(5).heightRandA(2).heightRandB(3).ignoreVines().setSapling((IPlantable) BlocksTwo.BLACKBARK_SAPLING).build();
	public static final TreeFeatureConfig FROSTBARK = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(FROSTBARK_LOG), new SimpleBlockStateProvider(FROSTBARK_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(5).heightRandA(2).heightRandB(3).ignoreVines().setSapling((IPlantable) BlocksTwo.FROSTBARK_SAPLING).build();
	
	
	
	@ObjectHolder("two:cherry_tree") public static final Feature<TreeFeatureConfig> CHERRY_TREE = (Feature<TreeFeatureConfig>) register("cherry_tree", new TreeFeature(TreeFeatureConfig::func_227338_a_));
	@ObjectHolder("two:maple_tree") public static final Feature<TreeFeatureConfig> MAPLE_TREE = (Feature<TreeFeatureConfig>) register("maple_tree", new TreeFeature(TreeFeatureConfig::func_227338_a_));
	@ObjectHolder("two:ghostwood_tree") public static final Feature<TreeFeatureConfig> GHOSTWOOD_TREE = (Feature<TreeFeatureConfig>) register("ghostwood_tree", new GhostwoodTreeFeature(TreeFeatureConfig::func_227338_a_));
	@ObjectHolder("two:cloudwood_tree") public static final Feature<TreeFeatureConfig> CLOUDWOOD_TREE = (Feature<TreeFeatureConfig>) register("cloudwood_tree", new CloudwoodTreeFeature(TreeFeatureConfig::func_227338_a_));
	@ObjectHolder("two:blackbark_tree") public static final Feature<TreeFeatureConfig> BLACKBARK_TREE = (Feature<TreeFeatureConfig>) register("blackbark_tree", new BlackbarkTreeFeature(TreeFeatureConfig::func_227338_a_));
	@ObjectHolder("two:frostbark_tree") public static final Feature<TreeFeatureConfig> FROSTBARK_TREE = (Feature<TreeFeatureConfig>) register("frostbark_tree", new FrostbarkTreeFeature(TreeFeatureConfig::func_227338_a_));

	@ObjectHolder("two:adobe_well") public static final Structure<NoFeatureConfig> ADOBE_WELL = (Structure<NoFeatureConfig>) register("adobe_well", new AdobeWellStructure(NoFeatureConfig::deserialize));
	@ObjectHolder("two:dwarven_keep") public static final Structure<NoFeatureConfig> DWARVEN_KEEP = (Structure<NoFeatureConfig>) register("dwarven_keep", new DwarvenKeepStructure(NoFeatureConfig::deserialize));
	
	@ObjectHolder("two:replace_block") public static final Feature<ReplaceBlockConfig> REPLACE_BLOCK = (Feature<ReplaceBlockConfig>) register("replace_block", new ReplaceBlockFeature(ReplaceBlockConfig::deserialize));
	@ObjectHolder("two:multi_replace_block") public static final Feature<MultiReplaceBlockConfig> MULTI_REPLACE_BLOCK = (Feature<MultiReplaceBlockConfig>) register("multi_replace_block", new MultiReplaceBlockFeature(MultiReplaceBlockConfig::deserialize));
	
	public static final BlockWithContextConfig SUCCULIGHT_CONFIG = new BlockWithContextConfig(BlocksTwo.SUCCULIGHT.getDefaultState(), new BlockState[] { Blocks.SAND.getDefaultState() }, new BlockState [] { Blocks.CAVE_AIR.getDefaultState() }, new BlockState [] { Blocks.CAVE_AIR.getDefaultState() });
	public static final BlockWithContextConfig NEONDOT_CONFIG = new BlockWithContextConfig(BlocksTwo.NEONDOT.getDefaultState(), new BlockState[] { BlocksTwo.SPORESTONE_SOIL.getDefaultState() }, new BlockState [] { Blocks.CAVE_AIR.getDefaultState() }, new BlockState [] { Blocks.CAVE_AIR.getDefaultState() });
	public static final BlockWithContextConfig BRIMSHINE_CONFIG = new BlockWithContextConfig(BlocksTwo.BRIMSHINE.getDefaultState(), new BlockState[] { BlocksTwo.SPORESTONE_SOIL.getDefaultState() }, new BlockState [] { Blocks.CAVE_AIR.getDefaultState() }, new BlockState [] { Blocks.CAVE_AIR.getDefaultState() });
	
	
	// desert arch feature
	
	
	
	
	public static void onFeaturesRegistry(final RegistryEvent.Register<Feature<?>> featureRegistryEvent) {
		featureRegistryEvent.getRegistry().registerAll(Holder.FEATURESTWO.toArray(new Feature<?> [] {}));
	}
	static Feature<?> register(String key, Feature<?> feature) {
		Holder.FEATURESTWO.add(feature.setRegistryName("two", key));
		
		return feature;
	}
	static class Holder {
		public static final LinkedList<Feature<?>> FEATURESTWO = new LinkedList<Feature<?>>();
	}
}

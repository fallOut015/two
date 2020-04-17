package two.world.gen.feature;

import java.util.LinkedList;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.RegistryEvent;
import two.block.BlocksTwo;

@SuppressWarnings("unchecked")
public class FeatureTwo {
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
	
	public static final Feature<TreeFeatureConfig> CHERRY_TREE = (Feature<TreeFeatureConfig>) register("cherry_tree", new TreeFeature(TreeFeatureConfig::func_227338_a_));
	public static final Feature<TreeFeatureConfig> MAPLE_TREE = (Feature<TreeFeatureConfig>) register("maple_tree", new TreeFeature(TreeFeatureConfig::func_227338_a_));
	public static final Feature<TreeFeatureConfig> GHOSTWOOD_TREE = (Feature<TreeFeatureConfig>) register("ghostwood_tree", new GhostwoodTreeFeature(TreeFeatureConfig::func_227338_a_));
	public static final Feature<TreeFeatureConfig> CLOUDWOOD_TREE = (Feature<TreeFeatureConfig>) register("cloudwood_tree", new CloudwoodTreeFeature(TreeFeatureConfig::func_227338_a_));
	public static final Feature<TreeFeatureConfig> BLACKBARK_TREE = (Feature<TreeFeatureConfig>) register("blackbark_tree", new BlackbarkTreeFeature(TreeFeatureConfig::func_227338_a_));
	public static final Feature<TreeFeatureConfig> FROSTBARK_TREE = (Feature<TreeFeatureConfig>) register("frostbark_tree", new FrostbarkTreeFeature(TreeFeatureConfig::func_227338_a_));

	public static final TreeFeatureConfig CHERRY = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CHERRY_LOG), new SimpleBlockStateProvider(CHERRY_LEAVES), new BlobFoliagePlacer(2, 0))).func_225569_d_(5).func_227354_b_(2).func_227360_i_(3).func_227352_a_().setSapling((IPlantable) BlocksTwo.CHERRY_SAPLING).func_225568_b_();
	public static final TreeFeatureConfig MAPLE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(MAPLE_LOG), new SimpleBlockStateProvider(MAPLE_LEAVES), new BlobFoliagePlacer(2, 0))).func_225569_d_(5).func_227354_b_(2).func_227360_i_(3).func_227352_a_().setSapling((IPlantable) BlocksTwo.MAPLE_SAPLING).func_225568_b_();
	public static final TreeFeatureConfig GHOSTWOOD = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(GHOSTWOOD_LOG), new SimpleBlockStateProvider(GHOSTWOOD_LEAVES), new BlobFoliagePlacer(2, 0))).func_225569_d_(5).func_227354_b_(2).func_227360_i_(3).func_227352_a_().setSapling((IPlantable) BlocksTwo.GHOSTWOOD_SAPLING).func_225568_b_();
	public static final TreeFeatureConfig CLOUDWOOD = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CLOUDWOOD_LOG), new SimpleBlockStateProvider(CLOUDWOOD_LEAVES), new BlobFoliagePlacer(2, 0))).func_225569_d_(5).func_227354_b_(2).func_227360_i_(3).func_227352_a_().setSapling((IPlantable) BlocksTwo.CLOUDWOOD_SAPLING).func_225568_b_();
	public static final TreeFeatureConfig BLACKBARK = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BLACKBARK_LOG), new SimpleBlockStateProvider(BLACKBARK_LEAVES), new BlobFoliagePlacer(2, 0))).func_225569_d_(5).func_227354_b_(2).func_227360_i_(3).func_227352_a_().setSapling((IPlantable) BlocksTwo.BLACKBARK_SAPLING).func_225568_b_();
	public static final TreeFeatureConfig FROSTBARK = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(FROSTBARK_LOG), new SimpleBlockStateProvider(FROSTBARK_LEAVES), new BlobFoliagePlacer(2, 0))).func_225569_d_(5).func_227354_b_(2).func_227360_i_(3).func_227352_a_().setSapling((IPlantable) BlocksTwo.FROSTBARK_SAPLING).func_225568_b_();
	
	public static void onFeaturesRegistry(final RegistryEvent.Register<Feature<?>> featureRegistryEvent) {
		featureRegistryEvent.getRegistry().registerAll(Holder.FEATURESTWO.toArray(new Feature<?> [] {}));
	}
	static Feature<?> register(String key, Feature<?> feature) {
		Holder.FEATURESTWO.add(feature.setRegistryName(key));
		
		return feature;
	}
	static class Holder {
		public static final LinkedList<Feature<?>> FEATURESTWO = new LinkedList<Feature<?>>();
	}
}

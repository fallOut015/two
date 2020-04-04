package two.world.gen.feature;

import java.util.LinkedList;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.RegistryEvent;
import two.block.BlocksTwo;

@SuppressWarnings("unchecked")
public class FeatureTwo {
	private static final BlockState GHOSTWOOD_LOG = BlocksTwo.GHOSTWOOD_LOG.getDefaultState();
	private static final BlockState CLOUDWOOD_LOG = BlocksTwo.CLOUDWOOD_LOG.getDefaultState();
	
	private static final BlockState GHOSTWOOD_LEAVES = BlocksTwo.GHOSTWOOD_LEAVES.getDefaultState();
	private static final BlockState CLOUDWOOD_LEAVES = BlocksTwo.CLOUDWOOD_LEAVES.getDefaultState();
	
	public static final Feature<TreeFeatureConfig> GHOSTWOOD_TREE = (Feature<TreeFeatureConfig>) register("ghostwood_tree", new GhostwoodTreeFeature(TreeFeatureConfig::func_227338_a_));
	public static final Feature<TreeFeatureConfig> CLOUDWOOD_TREE = (Feature<TreeFeatureConfig>) register("cloudwood_tree", new CloudwoodTreeFeature(TreeFeatureConfig::func_227338_a_));
	
	public static final TreeFeatureConfig GHOSTWOOD = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(GHOSTWOOD_LOG), new SimpleBlockStateProvider(GHOSTWOOD_LEAVES), new BlobFoliagePlacer(2, 0))).func_225569_d_(5).func_227354_b_(2).func_227360_i_(3).func_227352_a_().setSapling((IPlantable) BlocksTwo.GHOSTWOOD_SAPLING).func_225568_b_();
	public static final TreeFeatureConfig CLOUDWOOD = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CLOUDWOOD_LOG), new SimpleBlockStateProvider(CLOUDWOOD_LEAVES), new BlobFoliagePlacer(2, 0))).func_225569_d_(5).func_227354_b_(2).func_227360_i_(3).func_227352_a_().setSapling((IPlantable) BlocksTwo.CLOUDWOOD_SAPLING).func_225568_b_();
	
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

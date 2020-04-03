package two.world.gen.feature;

import java.util.LinkedList;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraftforge.event.RegistryEvent;

@SuppressWarnings("unchecked")
public class FeatureTwo {
	public static final Feature<TreeFeatureConfig> GHOSTWOOD_TREE = (Feature<TreeFeatureConfig>) register("ghostwood_tree", new GhostwoodTreeFeature(TreeFeatureConfig::func_227338_a_));
	public static final Feature<TreeFeatureConfig> CLOUDWOOD_TREE = (Feature<TreeFeatureConfig>) register("cloudwood_tree", new CloudwoodTreeFeature(TreeFeatureConfig::func_227338_a_));
	
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

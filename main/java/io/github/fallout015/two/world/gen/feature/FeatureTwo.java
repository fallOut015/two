package io.github.fallout015.two.world.gen.feature;

import java.util.LinkedList;

import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.feature.ReplaceBlockFeature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public class FeatureTwo {
	public static final Feature<ReplaceBlockConfig> REPLACE_BLOCK = register("replace_block", new ReplaceBlockFeature(ReplaceBlockConfig.field_236604_a_));
	public static final Feature<MultiReplaceBlockConfig> MULTI_REPLACE_BLOCK = register("multi_replace_block", new MultiReplaceBlockFeature(MultiReplaceBlockConfig.CODEC));
	
	public static final Feature<BigMushroomFeatureConfig> HUGE_NEONDOT = register("huge_neondot", new BigNeondotFeature(BigMushroomFeatureConfig.field_236528_a_));
	public static final Feature<BigMushroomFeatureConfig> HUGE_BRIMSHINE = register("huge_brimshine", new BigBrimshineFeature(BigMushroomFeatureConfig.field_236528_a_));

	// desert arch feature
	
	public static void onFeaturesRegistry(final RegistryEvent.Register<Feature<?>> featureRegistryEvent) {
		featureRegistryEvent.getRegistry().registerAll(Holder.FEATURESTWO.toArray(new Feature<?> [] {}));
	}
	static <C extends IFeatureConfig, F extends Feature<C>> F register(String key, F feature) {
		Holder.FEATURESTWO.add(feature.setRegistryName("two", key));
		
		return feature;
	}
	static class Holder {
		public static final LinkedList<Feature<?>> FEATURESTWO = new LinkedList<Feature<?>>();
	}
}
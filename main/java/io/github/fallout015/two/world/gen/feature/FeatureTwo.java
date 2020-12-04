package io.github.fallout015.two.world.gen.feature;

import io.github.fallout015.two.Two;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.feature.ReplaceBlockFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureTwo {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Two.MODID);

	
	
	public static final RegistryObject<Feature<ReplaceBlockConfig>> REPLACE_BLOCK = FEATURES.register("replace_block", () -> new ReplaceBlockFeature(ReplaceBlockConfig.field_236604_a_));
	public static final RegistryObject<Feature<MultiReplaceBlockConfig>> MULTI_REPLACE_BLOCK = FEATURES.register("multi_replace_block", () -> new MultiReplaceBlockFeature(MultiReplaceBlockConfig.CODEC));
	
	public static final RegistryObject<Feature<BigMushroomFeatureConfig>> HUGE_NEONDOT = FEATURES.register("huge_neondot", () -> new BigNeondotFeature(BigMushroomFeatureConfig.field_236528_a_));
	public static final RegistryObject<Feature<BigMushroomFeatureConfig>> HUGE_BRIMSHINE = FEATURES.register("huge_brimshine", () -> new BigBrimshineFeature(BigMushroomFeatureConfig.field_236528_a_));

	public static final RegistryObject<Feature<NoFeatureConfig>> CATTAILS = FEATURES.register("cattails", () -> new CattailsFeature(NoFeatureConfig.field_236558_a_));

	// desert arch feature
	

	
	public static void register(IEventBus bus) {
		FEATURES.register(bus);
	}
}
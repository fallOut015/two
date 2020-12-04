package io.github.fallout015.two.world.gen.feature.structure;

import io.github.fallout015.two.Two;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class StructureTwo {
	public static final DeferredRegister<Structure<?>> STRUCTURE_FEATURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Two.MODID);
	
	
	
//	public static final Structure<NoFeatureConfig> ADOBE_WELL = register("Adobe_Well", new AdobeWellStructure(), GenerationStage.Decoration.SURFACE_STRUCTURES); // Move to features. 
//	public static final Structure<NoFeatureConfig> DWARVEN_KEEP = register("Dwarven_Keep", new DwarvenKeepStructure(), GenerationStage.Decoration.SURFACE_STRUCTURES);
	public static final RegistryObject<Structure<NoFeatureConfig>> LOST = STRUCTURE_FEATURES.register("lost", () -> new LostStructure(NoFeatureConfig.field_236558_a_)/*, GenerationStage.Decoration.SURFACE_STRUCTURES*/);
	
	
	
	public static void register(IEventBus bus) {
		STRUCTURE_FEATURES.register(bus);
	}
}
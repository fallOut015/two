package io.github.fallout015.two.world.gen.feature.structure;

import java.util.LinkedList;

import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public abstract class StructureTwo {
//	public static final Structure<NoFeatureConfig> ADOBE_WELL = register("Adobe_Well", new AdobeWellStructure(), GenerationStage.Decoration.SURFACE_STRUCTURES); // Move to features. 
//	public static final Structure<NoFeatureConfig> DWARVEN_KEEP = register("Dwarven_Keep", new DwarvenKeepStructure(), GenerationStage.Decoration.SURFACE_STRUCTURES);
	
	
	
	public static void onStructuresRegistry(final RegistryEvent.Register<Structure<?>> structureRegistryEvent) {
		structureRegistryEvent.getRegistry().registerAll(Holder.STRUCTURESTWO.toArray(new Structure<?> [] {}));
	}
	static <F extends Structure<?>> F register(String key, F structure, GenerationStage.Decoration decoration) {
		return structure;
	}
	static class Holder {
		public static final LinkedList<Structure<?>> STRUCTURESTWO = new LinkedList<Structure<?>>();
	}
}
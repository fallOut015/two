package io.github.fallout015.two.world.gen.feature.structure;

import java.util.LinkedList;

import io.github.fallout015.two.world.gen.feature.FeatureTwo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public class StructureTwo {
	public static final Structure<NoFeatureConfig> ADOBE_WELL = register("Adobe_Well", FeatureTwo.ADOBE_WELL);
	public static final Structure<NoFeatureConfig> DWARVEN_KEEP = register("Dwarven_Keep", FeatureTwo.DWARVEN_KEEP);
	
	
	
	public static void onStructuresRegistry(final RegistryEvent.Register<Structure<?>> structureRegistryEvent) {
		structureRegistryEvent.getRegistry().registerAll(Holder.STRUCTURESTWO.toArray(new Structure<?> [] {}));
	}
	static <F extends Structure<?>> F register(String key, F structure, GenerationStage.Decoration decoration) {

	}
	static class Holder {
		public static final LinkedList<Structure<?>> STRUCTURESTWO = new LinkedList<Structure<?>>();
	}
}
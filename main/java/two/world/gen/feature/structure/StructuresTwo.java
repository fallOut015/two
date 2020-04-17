package two.world.gen.feature.structure;

import java.util.LinkedList;

import net.minecraft.world.gen.feature.structure.Structure;
import two.world.gen.feature.FeatureTwo;

public class StructuresTwo {
	public static final Structure<?> ADOBE_WELL = register("Adobe_Well", FeatureTwo.ADOBE_WELL);
	
	static Structure<?> register(String key, Structure<?> structure) {
		Holder.STRUCTURESTWO.add((Structure<?>) structure.setRegistryName(key));
		
		return structure;
	}
	static class Holder {
		public static final LinkedList<Structure<?>> STRUCTURESTWO = new LinkedList<Structure<?>>();
	}
}
package two.world.gen.placement;

import java.util.LinkedList;

import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
@SuppressWarnings("unchecked")
public class PlacementTwo {
	public static final Placement<NoPlacementConfig> PLACE_ALL_TO_64 = (Placement<NoPlacementConfig>) register("place_all_to_64", new PlaceAllTo64Placement(NoPlacementConfig::deserialize));
	
	public static void onPlacementsRegistry(final RegistryEvent.Register<Placement<?>> placementRegistryEvent) {
		placementRegistryEvent.getRegistry().registerAll(Holder.PLACEMENTSTWO.toArray(new Placement<?> [] {}));
	}
	static Placement<?> register(String key, Placement<?> placement) {
		Holder.PLACEMENTSTWO.add(placement.setRegistryName("two", key));
		
		return placement;
	}
	static class Holder {
		public static final LinkedList<Placement<?>> PLACEMENTSTWO = new LinkedList<Placement<?>>();
	}
}
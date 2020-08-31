package io.github.fallout015.two.world.gen.placement;

import java.util.LinkedList;

import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public class PlacementTwo {
	public static final Placement<NoPlacementConfig> PLACE_ALL_TO_64 = register("place_all_to_64", new PlaceAllTo64Placement(NoPlacementConfig.field_236555_a_));
	
	public static void onPlacementsRegistry(final RegistryEvent.Register<Placement<?>> placementRegistryEvent) {
		placementRegistryEvent.getRegistry().registerAll(Holder.PLACEMENTSTWO.toArray(new Placement<?> [] {}));
	}
	private static <T extends IPlacementConfig, G extends Placement<T>> G register(String key, G placement) {
		Holder.PLACEMENTSTWO.add(placement.setRegistryName("two", key));
		
		return placement;
	}
	static class Holder {
		public static final LinkedList<Placement<?>> PLACEMENTSTWO = new LinkedList<Placement<?>>();
	}
}
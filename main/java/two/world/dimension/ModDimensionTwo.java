package two.world.dimension;

import java.util.LinkedList;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public class ModDimensionTwo {
	public static final ModDimension NIGHTMARE = register("nightmare", new NightmareModDimension());
//	public static final ModDimension DEEP_DARK;
	public static final ModDimension SKY = register("sky", new SkyModDimension());
//	public static final ModDimension RAINBOW;
	public static final ModDimension FROSTBITE = register("frostbite", new FrostbiteModDimension());
//	public static final ModDimension BLOOD_AETHER;
	public static final ModDimension NIDAVELLIR = register("nidavellir", new NidavellirModDimension());
	// THE SOMETHING
	// SOMETHING REALM
	// THE VALLEY OF SPIRITS
	// SOMETHING WITH PLANETS AND ALCHEMICAL SYMBOLS?
	
	public static void onModDimensionsRegistry(final RegistryEvent.Register<ModDimension> modDimensionRegistryEvent) {
		modDimensionRegistryEvent.getRegistry().registerAll(Holder.MODDIMENSIONS.toArray(new ModDimension [] {}));
	}
	static ModDimension register(String key, ModDimension modDimension) {
		Holder.MODDIMENSIONS.add(modDimension.setRegistryName(key));
		
		return modDimension;
	}
	static class Holder {
		public static final LinkedList<ModDimension> MODDIMENSIONS = new LinkedList<ModDimension>();
	}
}
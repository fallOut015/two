package two.world.biome;

import java.util.LinkedList;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public class BiomesTwo {
	public static final Biome NIGHTMARE = register("nightmare", new NightmareBiome());
	public static final Biome NIGHTMARE_HIGHLANDS = register("nightmare_highlands", new NightmareHighlandsBiome());
	
	public static final Biome SKY = register("sky", new SkyBiome());
	/*public static final Biome MAGNIFIED_FOREST;
	public static final Biome CATLANDS;
	public static final Biome SPOOKY_FOREST;
	public static final Biome MAGICAL_WOODS;
	public static final Biome TEMPERATE_DECIDUOUS_FOREST;
	public static final Biome TAIGA_DECIDUOUS_FOREST;
	public static final Biome LUSCIOUS_CHAPPARAL;
	public static final Biome ALPINE_MOUNTAINS;
	public static final Biome TROPICAL_SAVANNA;
	public static final Biome MEDITERANNEAN_SAVANNA;
	public static final Biome MONTANE_SAVANNA;
	public static final Biome EUCALYPTUS_FOREST;
	public static final Biome DARK_FOREST
	public static final Biome DARK_DESERT
	public static final Biome DARK_JUNGLE
	public static final Biome DARK_TUNDRA*/
	
	public static void onBiomesRegistry(final RegistryEvent.Register<Biome> biomeRegistryEvent) {
		biomeRegistryEvent.getRegistry().registerAll(Holder.BIOMESTWO.toArray(new Biome [] {}));
	}
	static Biome register(String key, Biome biome) {
		Holder.BIOMESTWO.add(biome.setRegistryName(key));
		
		return biome;
	}
	static class Holder {
		public static final LinkedList<Biome> BIOMESTWO = new LinkedList<Biome>();
	}
}

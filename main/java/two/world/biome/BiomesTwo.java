package two.world.biome;

import java.util.LinkedList;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public class BiomesTwo {
	public static final Biome NIGHTMARE = register("nightmare", new NightmareBiome());
	public static final Biome NIGHTMARE_HIGHLANDS = register("nightmare_highlands", new NightmareHighlandsBiome());
	public static final Biome THE_FOREST = register("the_forest", new TheForestBiome());
	
	public static final Biome SKY = register("sky", new SkyBiome());
	
	public static final Biome FROSTED_WOODS = register("frosted_woods", new FrostedWoodsBiome());
	public static final Biome PETRIFIED_PLAINS = register("petrified_plains", new PetrifiedPlainsBiome());
	public static final Biome TUNDRA_HILLS = register("tundra_hills", new TundraHillsBiome());
	
	public static final Biome DARK_SIDE = register("dark_side", new DarkSideBiome());
	public static final Biome LUNAR_PLAINS = register("lunar_plains", new LunarPlainsBiome());
	public static final Biome SVARTALHILLS = register("svartalhills", new SvartalhillsBiome());
	public static final Biome CELESTIAL_FOREST = register("celestial_forest", new CelestialForestBiome());
	
	/*
	public static final Biome MAGNIFIED_FOREST;
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
	public static final Biome DARK_TUNDRA
	public static final Biome DARK_BEACH
	public static final Biome DARK_OCEAN
	public static final Biome DARK_MESA
	*/
	
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

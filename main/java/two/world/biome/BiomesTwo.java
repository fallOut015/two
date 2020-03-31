package two.world.biome;

import java.util.LinkedList;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public class BiomesTwo {
	public static final Biome NIGHTMARE_HIGHLANDS = register("nightmare_highlands", new NightmareHighlandsBiome());
	
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

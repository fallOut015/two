package io.github.fallout015.two.world.gen.carver;

import java.util.LinkedList;

import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public class WorldCarverTwo {
	public static final WorldCarver<ProbabilityConfig> CAVERN = register("cavern", new CavernWorldCarver(ProbabilityConfig.field_236576_b_, 128));
	// huge cave ^
	// slightly bigger cave
	// carvers for specific underground biomes
	public static final WorldCarver<ProbabilityConfig> WIDE_CAVE = register("wide_cave", new WideCaveWorldCarver(ProbabilityConfig.field_236576_b_, 128));
	// crater
	
	public static void onWorldCarversRegistry(final RegistryEvent.Register<WorldCarver<?>> worldCarverRegistryEvent) {
		worldCarverRegistryEvent.getRegistry().registerAll(Holder.WORLDCARVERSTWO.toArray(new WorldCarver<?> [] {}));
	}
	private static <C extends ICarverConfig, F extends WorldCarver<C>> F register(String key, F worldCarver) {
		worldCarver.setRegistryName(key);
		Holder.WORLDCARVERSTWO.add(worldCarver);
		return worldCarver;
	}
	static class Holder {
		public static final LinkedList<WorldCarver<?>> WORLDCARVERSTWO = new LinkedList<WorldCarver<?>>();
	}
}
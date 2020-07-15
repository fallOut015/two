package two.world.gen.carver;

import java.util.LinkedList;

import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
@SuppressWarnings("unchecked")
public class WorldCarverTwo {
	public static final WorldCarver<ProbabilityConfig> CAVERN = (WorldCarver<ProbabilityConfig>) register("cavern", new CavernWorldCarver(ProbabilityConfig::deserialize, 100));
	// huge cave ^
	// slightly bigger cave
	// carvers for specific underground biomes
//	public static final WorldCarver<ProbabilityConfig> WIDE_CAVE
	// crater
	
	public static void onWorldCarversRegistry(final RegistryEvent.Register<WorldCarver<?>> worldCarverRegistryEvent) {
		worldCarverRegistryEvent.getRegistry().registerAll(Holder.WORLDCARVERSTWO.toArray(new WorldCarver<?> [] {}));
	}
	private static WorldCarver<?> register(String key, WorldCarver<?> worldCarver) {
		worldCarver.setRegistryName(key);
		Holder.WORLDCARVERSTWO.add(worldCarver);
		return worldCarver;
	}
	static class Holder {
		public static final LinkedList<WorldCarver<?>> WORLDCARVERSTWO = new LinkedList<WorldCarver<?>>();
	}
}
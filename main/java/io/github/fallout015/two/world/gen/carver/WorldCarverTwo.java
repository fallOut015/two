package io.github.fallout015.two.world.gen.carver;

import io.github.fallout015.two.Two;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldCarverTwo {
	private static final DeferredRegister<WorldCarver<?>> WORLD_CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, Two.MODID);

	public static final RegistryObject<CavernWorldCarver> CAVERN = WORLD_CARVERS.register("cavern", () -> new CavernWorldCarver(ProbabilityConfig.field_236576_b_, 128));
	// huge cave ^
	// slightly bigger cave
	// carvers for specific underground biomes
	public static final RegistryObject<WideCaveWorldCarver> WIDE_CAVE = WORLD_CARVERS.register("wide_cave", () -> new WideCaveWorldCarver(ProbabilityConfig.field_236576_b_, 128));
	// crater
	
	public static void register(IEventBus bus) {
		WORLD_CARVERS.register(bus);
	}
}
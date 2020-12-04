package io.github.fallout015.two.stats;

import io.github.fallout015.two.Two;
import net.minecraft.stats.StatType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class StatsTwo {
	private static final DeferredRegister<StatType<?>> STAT_TYPES = DeferredRegister.create(ForgeRegistries.STAT_TYPES, Two.MODID);

	
	
	public static final RegistryObject<StatType<ResourceLocation>> INTERACT_WITH_UPHOLSTERY_TABLE = STAT_TYPES.register("interact_with_upholstery_table", () -> new StatType<ResourceLocation>(Registry.CUSTOM_STAT));
	
	
	
	public static void register(IEventBus bus) {
		STAT_TYPES.register(bus);
	}
}
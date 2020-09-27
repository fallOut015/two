package io.github.fallout015.two.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneratorTwo {
	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();

		if(event.includeClient()) {
			gen.addProvider(new BlockstateProviderTwo(gen));
		}
		
		if(event.includeServer()) {
			gen.addProvider(new Recipes(gen));
			gen.addProvider(new LootTables(gen));
		}
	}
}
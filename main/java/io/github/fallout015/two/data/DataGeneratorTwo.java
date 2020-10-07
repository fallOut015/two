package io.github.fallout015.two.data;

import io.github.fallout015.two.data.server.RecipeProviderTwo;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

public class DataGeneratorTwo {
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class Gen {
		@SubscribeEvent
		public static void gatherData(final GatherDataEvent event) {
			DataGenerator gen = event.getGenerator();

			if(event.includeClient()) {
//				gen.addProvider(new BlockStateProviderTwo(gen));
//				gen.addProvider(new LanguageProviderTwo(gen));
				// item model gen
			}
			
			if(event.includeServer()) {
//				gen.addProvider(new LootTableProviderTwo(gen));
				gen.addProvider(new RecipeProviderTwo(gen));
				// tag
			}
		}		
	}
}
package two.stats;

import java.util.LinkedList;

import net.minecraft.stats.IStatFormatter;
import net.minecraft.stats.StatType;
import net.minecraft.stats.Stats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;

public class StatsTwo {
	public static final ResourceLocation INTERACT_WITH_UPHOLSTERY_TABLE = registerCustom("interact_with_upholstery_table", IStatFormatter.DEFAULT);
	
	public static void onStatTypesRegistry(final RegistryEvent.Register<StatType<?>> statTypeRegistryEvent) {
		statTypeRegistryEvent.getRegistry().registerAll(Holder.STATTYPES.toArray(new StatType<?> [] {}));
	}
	static ResourceLocation registerCustom(String key, IStatFormatter statFormatter) {
		ResourceLocation resourcelocation = new ResourceLocation("two", key);
		Registry.register(Registry.CUSTOM_STAT, key, resourcelocation);
		Stats.CUSTOM.get(resourcelocation, statFormatter);
		return resourcelocation;
	}
	static class Holder {
		public static final LinkedList<StatType<?>> STATTYPES = new LinkedList<StatType<?>>();
	}
}

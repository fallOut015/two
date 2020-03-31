package two.world.dimension;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;

public class DimensionTypeTwo {
	public static void onDimensionTypesRegistry(final RegistryEvent.Register<DimensionType> dimensionTypeRegistryEvent) {
		DimensionManager.registerDimension(new ResourceLocation("two", "nightmare"), new NightmareModDimension(), null, false);
	}
}
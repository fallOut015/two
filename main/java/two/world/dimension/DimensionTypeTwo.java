package two.world.dimension;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;

public class DimensionTypeTwo {
	public static void onDimensionTypesRegistry(final RegistryEvent.Register<DimensionType> dimensionTypeRegistryEvent) {
		DimensionManager.registerDimension(new ResourceLocation("two", "nightmare"), new NightmareModDimension(), null, false);
		
		//DimensionManager.registerDimension(new ResourceLocation("two", "sky"), new SkyModDimension(), null, true);
		//DimensionManager.registerDimension(new ResourceLocation("two", "deep_dark"), new DeepDarkModDimension(), null, true);
		//DimensionManager.registerDimension(new ResourceLocation("two", "blood_aether"), new BloodAetherModDimension(), null, true);
		//DimensionManager.registerDimension(new ResourceLocation("two", "rainbow"), new RainbowModDimension(), null, true);
		//DimensionManager.registerDimension(new ResourceLocation("two", "frostbite"), new FrostbiteModDimension(), null, true);
	}
}
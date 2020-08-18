package io.github.fallout015.two.world.biome;

import io.github.fallout015.two.world.gen.surfacebuilders.SurfaceBuilderTwo;
import net.minecraft.world.biome.Biome;

public class NightmareBiome extends Biome {
	protected NightmareBiome() {
		super(new Biome.Builder()
			.surfaceBuilder(SurfaceBuilderTwo.NIGHTMARE, SurfaceBuilderTwo.GAULT_NIGHTSTONE_CONFIG)
			.precipitation(RainType.RAIN)
			.category(Category.NONE)
			.depth(0.1f)
			.scale(1.0f)
			.temperature(0.8f)
			.downfall(0.8f)
			.waterColor(16711680)
			.waterFogColor(16711680)
			.parent(null)
		);
	}
}
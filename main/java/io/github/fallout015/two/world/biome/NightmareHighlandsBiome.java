package io.github.fallout015.two.world.biome;

import io.github.fallout015.two.world.gen.surfacebuilders.SurfaceBuilderTwo;
import net.minecraft.world.biome.Biome;

public class NightmareHighlandsBiome extends Biome {
	public NightmareHighlandsBiome() {
		super(new Biome.Builder()
			.surfaceBuilder(SurfaceBuilderTwo.NIGHTMARE_HIGHLANDS, SurfaceBuilderTwo.GAULT_NIGHTSTONE_CONFIG)
			.precipitation(RainType.NONE)
			.category(Category.NONE)
			.depth(0.1f)
			.scale(1.0f)
			.temperature(0.0f)
			.downfall(0.0f)
			.waterColor(16711680)
			.waterFogColor(16711680)
			.parent("nightmare")
		);
	}
}
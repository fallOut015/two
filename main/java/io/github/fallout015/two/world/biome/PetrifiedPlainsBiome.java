package io.github.fallout015.two.world.biome;

import io.github.fallout015.two.world.gen.surfacebuilders.SurfaceBuilderTwo;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;

public class PetrifiedPlainsBiome extends Biome {
	protected PetrifiedPlainsBiome() {
		super(new Biome.Builder()
			.surfaceBuilder(SurfaceBuilderTwo.FROSTBITE, SurfaceBuilderTwo.ICE_PACKED_ICE_CONFIG)
			.precipitation(RainType.SNOW)
			.category(Category.ICY)
			.depth(0.1f)
			.scale(1.0f)
			.temperature(0.2f)
			.downfall(1.0f)
			.waterColor(4159204)
			.waterFogColor(16777215)
			.parent(null)
		);
		
		DefaultBiomeFeatures.addCarvers(this);
	}
}
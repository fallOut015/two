package two.world.biome;

import net.minecraft.world.biome.Biome;
import two.world.gen.surfacebuilders.SurfaceBuilderTwo;

public class SkyBiome extends Biome {
	protected SkyBiome() {
		super(new Biome.Builder()
			.surfaceBuilder(SurfaceBuilderTwo.SKY, SurfaceBuilderTwo.CLOUD_CONFIG)
			.precipitation(RainType.RAIN)
			.category(Category.NONE)
			.depth(0.1f)
			.scale(1.0f)
			.temperature(0.5f)
			.downfall(0.1f)
			.waterColor(4159204)
			.waterFogColor(329011)
			.parent(null)
		);
	}
}

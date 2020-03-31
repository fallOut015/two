package two.world.biome;

import net.minecraft.world.biome.Biome;
import two.world.gen.surfacebuilders.SurfaceBuilders;

public class NightmareBiome extends Biome {
	protected NightmareBiome() {
		super(new Biome.Builder()
			.surfaceBuilder(SurfaceBuilders.NIGHTMARE, SurfaceBuilders.GAULT_CONFIG)
			.precipitation(RainType.RAIN)
			.category(Category.NONE)
			.depth(0.1f)
			.scale(1.0f)
			.temperature(0.0f)
			.downfall(0.0f)
			.waterColor(4159204)
			.waterFogColor(329011)
			.parent(null)
		);
	}
}
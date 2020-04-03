package two.world.biome;

import net.minecraft.world.biome.Biome;
import two.world.gen.surfacebuilders.SurfaceBuilders;

public class NightmareHighlandsBiome extends Biome {
	public NightmareHighlandsBiome() {
		super(new Biome.Builder()
			.surfaceBuilder(SurfaceBuilders.NIGHTMARE_HIGHLANDS, SurfaceBuilders.GAULT_CONFIG)
			.precipitation(RainType.NONE)
			.category(Category.NONE)
			.depth(0.1f)
			.scale(1.0f)
			.temperature(0.0f)
			.downfall(0.0f)
			.waterColor(4159204)
			.waterFogColor(329011)
			.parent("nightmare")
		);
	}
}
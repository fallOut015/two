package two.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import two.world.gen.surfacebuilders.SurfaceBuilderTwo;

public class TundraHillsBiome extends Biome {
	protected TundraHillsBiome() {
		super(new Biome.Builder()
			.surfaceBuilder(SurfaceBuilderTwo.FROSTBITE, SurfaceBuilderTwo.ICE_CONFIG)
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
			
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addCarvers(this);
	}
}
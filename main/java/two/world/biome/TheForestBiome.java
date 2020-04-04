package two.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage.Decoration;
import two.world.gen.feature.FeatureTwo;
import two.world.gen.surfacebuilders.SurfaceBuilderTwo;

public class TheForestBiome extends Biome {
	protected TheForestBiome() {
		super(new Biome.Builder()
			.surfaceBuilder(SurfaceBuilderTwo.NIGHTMARE, SurfaceBuilderTwo.GAULT_CONFIG)
			.precipitation(RainType.SNOW)
			.category(Category.FOREST)
			.depth(0.1f)
			.scale(1.0f)
			.temperature(0.2f)
			.downfall(0.7f)
			.waterColor(16711680)
			.waterFogColor(16711680)
			.parent("nightmare")
		);
		
		DefaultBiomeFeatures.addSprings(this);
		this.addFeature(Decoration.VEGETAL_DECORATION, FeatureTwo.GHOSTWOOD_TREE.func_225566_b_(FeatureTwo.GHOSTWOOD));
	}
}
package io.github.fallout015.two.world.biome;

import io.github.fallout015.two.world.gen.feature.FeatureTwo;
import io.github.fallout015.two.world.gen.surfacebuilders.SurfaceBuilderTwo;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage.Decoration;

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
		
		DefaultBiomeFeatures.addLakes(this);
		DefaultBiomeFeatures.addSprings(this);
		this.addFeature(Decoration.VEGETAL_DECORATION, FeatureTwo.CLOUDWOOD_TREE.withConfiguration(FeatureTwo.CLOUDWOOD));
	}
}

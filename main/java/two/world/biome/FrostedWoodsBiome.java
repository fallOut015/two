package two.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import two.world.gen.surfacebuilders.SurfaceBuilderTwo;

public class FrostedWoodsBiome extends Biome {
	protected FrostedWoodsBiome() {
		super(new Biome.Builder()
			.surfaceBuilder(SurfaceBuilderTwo.FROSTBITE, SurfaceBuilderTwo.PERMAFROST_GRASS_BLOCK_PERMAFROST_DIRT_CONFIG)
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
		
		DefaultBiomeFeatures.addLakes(this);
		//this.addFeature(Decoration.VEGETAL_DECORATION, FeatureTwo.CLOUDWOOD_TREE.func_225566_b_(FeatureTwo.CLOUDWOOD));
		// Replace ^ with frostbark and shiverwood
		DefaultBiomeFeatures.addFreezeTopLayer(this);
		DefaultBiomeFeatures.addTaigaConifers(this);
	}
}
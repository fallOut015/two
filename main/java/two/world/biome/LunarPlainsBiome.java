package two.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import two.block.BlocksTwo;
import two.world.gen.feature.FeatureTwo;
import two.world.gen.surfacebuilders.SurfaceBuilderTwo;

public class LunarPlainsBiome extends Biome {
	protected LunarPlainsBiome() {
		super(new Biome.Builder()
			.surfaceBuilder(SurfaceBuilderTwo.NIDAVELLIR, SurfaceBuilderTwo.REGOLITH_CONFIG)
			.precipitation(RainType.NONE)
			.category(Category.NONE)
			.depth(0.1f)
			.scale(1.0f)
			.temperature(0.1f)
			.downfall(0.0f)
			.waterColor(16711680)
			.waterFogColor(16711680)
			.parent(null)
		);
		
    	this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(FeatureTwo.MYRKYLITE, BlocksTwo.STARSTONE_ORE.getDefaultState(), 8)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(20, 0, 0, 64))));
    	this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(FeatureTwo.MYRKYLITE, BlocksTwo.CELESTIUM_ORE.getDefaultState(), 7)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(2, 0, 0, 32))));
    	this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(FeatureTwo.MYRKYLITE, BlocksTwo.URU_ORE.getDefaultState(), 6)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(1, 0, 0, 16))));
	}
}

package two.block.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class CherryTree extends Tree {
	@Nullable
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random p_225546_1_, boolean p_225546_2_) {
		return Feature.NORMAL_TREE.withConfiguration(p_225546_2_ ? DefaultBiomeFeatures.field_230136_s_ : DefaultBiomeFeatures.field_230135_r_);
	}
}
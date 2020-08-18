package io.github.fallout015.two.block.trees;

import java.util.Random;

import javax.annotation.Nullable;

import io.github.fallout015.two.world.gen.feature.FeatureTwo;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class BlackbarkTree extends Tree {
	@Nullable
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean pick) {
		return FeatureTwo.CLOUDWOOD_TREE.withConfiguration(pick ? FeatureTwo.CLOUDWOOD : FeatureTwo.CLOUDWOOD);
	}
}
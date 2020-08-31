package io.github.fallout015.two.block.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class BlackbarkTree extends Tree {
	@Nullable
	@Override
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean pick) {
		return null;
	}
}
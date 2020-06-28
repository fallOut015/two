package two.block.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import two.world.gen.feature.FeatureTwo;

public class CloudwoodTree extends Tree {
	@Nullable
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean pick) {
		return FeatureTwo.CLOUDWOOD_TREE.withConfiguration(FeatureTwo.CLOUDWOOD);
	}
}
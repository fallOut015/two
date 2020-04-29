package two.block.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import two.world.gen.feature.FeatureTwo;

public class FrostbarkTree extends Tree {
	@Nullable
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> func_225546_b_(Random random, boolean pick) {
		return FeatureTwo.GHOSTWOOD_TREE.func_225566_b_(pick ? FeatureTwo.GHOSTWOOD : FeatureTwo.GHOSTWOOD);
	}
}
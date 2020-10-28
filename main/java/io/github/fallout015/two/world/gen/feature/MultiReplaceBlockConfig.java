package io.github.fallout015.two.world.gen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class MultiReplaceBlockConfig implements IFeatureConfig {
	public static final Codec<MultiReplaceBlockConfig> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(
			BlockState.CODEC.fieldOf("target1").forGetter((config) -> {
			return config.target1;
		}), BlockState.CODEC.fieldOf("state1").forGetter((config) -> {
			return config.state1;
		}), BlockState.CODEC.fieldOf("target2").forGetter((config) -> {
			return config.target2;
		}), BlockState.CODEC.fieldOf("state2").forGetter((config) -> {
			return config.state2;
		})).apply(instance, MultiReplaceBlockConfig::new);
	});
	public final BlockState target1;
	public final BlockState state1;
	public final BlockState target2;
	public final BlockState state2;

	public MultiReplaceBlockConfig(BlockState target1, BlockState state1, BlockState target2, BlockState state2) {
		this.target1 = target1;
		this.state1 = state1;
		this.target2 = target2;
		this.state2 = state2;
	}
}
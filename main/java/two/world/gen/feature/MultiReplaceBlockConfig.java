package two.world.gen.feature;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class MultiReplaceBlockConfig implements IFeatureConfig {
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

	public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
		return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("target1"), BlockState.serialize(ops, this.target1).getValue(), ops.createString("state1"), BlockState.serialize(ops, this.state1).getValue(), ops.createString("target2"), BlockState.serialize(ops, this.target2).getValue(), ops.createString("state2"), BlockState.serialize(ops, this.state2).getValue())));
	}

	public static <T> MultiReplaceBlockConfig deserialize(Dynamic<T> p_214657_0_) {
		BlockState blockstate = p_214657_0_.get("target1").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
		BlockState blockstate1 = p_214657_0_.get("state1").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
		BlockState blockstate2 = p_214657_0_.get("target2").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
		BlockState blockstate3 = p_214657_0_.get("state2").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
		return new MultiReplaceBlockConfig(blockstate, blockstate1, blockstate2, blockstate3);
	}
}
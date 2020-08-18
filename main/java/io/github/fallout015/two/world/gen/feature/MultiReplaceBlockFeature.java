package io.github.fallout015.two.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;

public class MultiReplaceBlockFeature extends Feature<MultiReplaceBlockConfig> {
	public MultiReplaceBlockFeature(Function<Dynamic<?>, ? extends MultiReplaceBlockConfig> p_i51444_1_) {
		super(p_i51444_1_);
	}

	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, MultiReplaceBlockConfig config) {
		if(worldIn.getBlockState(pos.up()).isAir(worldIn, pos)) {
			if (worldIn.getBlockState(pos).getBlock() == config.target2.getBlock()) {
				worldIn.setBlockState(pos, config.state2, 2);
			}
		} else if (worldIn.getBlockState(pos).getBlock() == config.target1.getBlock()) {
			worldIn.setBlockState(pos, config.state1, 2);
		}

		return true;
	}
}
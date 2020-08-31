package io.github.fallout015.two.world.gen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

public class MultiReplaceBlockFeature extends Feature<MultiReplaceBlockConfig> {
	public MultiReplaceBlockFeature(Codec<MultiReplaceBlockConfig> codec) {
		super(codec);
	}

	@Override
	public boolean func_241855_a(ISeedReader seedReader, ChunkGenerator chunkGenerator, Random rand, BlockPos pos, MultiReplaceBlockConfig config) {
		if(seedReader.getBlockState(pos.up()).isAir(seedReader, pos)) {
			if(seedReader.getBlockState(pos).isIn(config.target2.getBlock())) {
				seedReader.setBlockState(pos, config.state2, 2);
			}
		} else if(seedReader.getBlockState(pos).isIn(config.target1.getBlock())) {
			seedReader.setBlockState(pos, config.state1, 2);
		}
		
		return false;
	}
}
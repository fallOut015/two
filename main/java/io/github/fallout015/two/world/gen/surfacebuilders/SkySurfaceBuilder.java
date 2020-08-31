package io.github.fallout015.two.world.gen.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SkySurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	public SkySurfaceBuilder(Codec<SurfaceBuilderConfig> codec) {
		super(codec);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		// Copy from End.
	}
}
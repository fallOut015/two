package io.github.fallout015.two.world.gen.carver;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class CavernWorldCarver extends WorldCarver<ProbabilityConfig> {
	public CavernWorldCarver(Codec<ProbabilityConfig> codec, int maxHeight) {
		super(codec, maxHeight);
	}

	protected int generateCaveStartY(Random rand) {
		return rand.nextInt(rand.nextInt(120) + 8);
	}
	protected float generateCaveRadius(Random rand) {
		float f = rand.nextFloat() * 4.0F + rand.nextFloat();
		if (rand.nextInt(10) == 0) {
			f *= rand.nextFloat() * rand.nextFloat() * 6.0F + 2.0F;
		}

		return f;
	}
	protected int func_222724_a() {
		return 15;
	}
	protected void func_227205_a_(IChunk p_227205_1_, Function<BlockPos, Biome> p_227205_2_, long p_227205_3_, int p_227205_5_, int p_227205_6_, int p_227205_7_, double p_227205_8_, double p_227205_10_, double p_227205_12_, float p_227205_14_, double p_227205_15_, BitSet p_227205_17_) {
		double d0 = 1.5D + (double)(MathHelper.sin(((float)Math.PI / 2F)) * p_227205_14_);
		double d1 = d0 * p_227205_15_;
		this.func_227208_a_(p_227205_1_, p_227205_2_, p_227205_3_, p_227205_5_, p_227205_6_, p_227205_7_, p_227205_8_ + 1.0D, p_227205_10_, p_227205_12_, d0, d1, p_227205_17_);
	}
	protected double func_222725_b() {
		return 1.0D;
	}
	protected void func_227206_a_(IChunk chunk, Function<BlockPos, Biome> biomeGetter, long l3, int i5, int i6, int i7, double d8, double d10, double d12, float f14, float f15, float f16, int i17, int i18, double d19, BitSet bitSet) {
		Random random = new Random(l3);
		int i = random.nextInt(i18 / 2) + i18 / 4;
		boolean flag = random.nextInt(6) == 0;
		float f = 0.0F;
		float f1 = 0.0F;

		for(int j = i17; j < i18; ++j) {
			double d0 = 1.5D + (double)(MathHelper.sin((float)Math.PI * (float)j / (float)i18) * f14);
			double d1 = d0 * d19;
			float f2 = MathHelper.cos(f16);
			d8 += (double)(MathHelper.cos(f15) * f2);
			d10 += (double)MathHelper.sin(f16);
			d12 += (double)(MathHelper.sin(f15) * f2);
			f16 = f16 * (flag ? 0.92F : 0.7F);
			f16 = f16 + f1 * 0.1F;
			f15 += f * 0.1F;
			f1 = f1 * 0.9F;
			f = f * 0.75F;
			f1 = f1 + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
			f = f + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
			if (j == i && f14 > 1.0F) {
	            this.func_227206_a_(chunk, biomeGetter, random.nextLong(), i5, i6, i7, d8, d10, d12, random.nextFloat() * 0.5F + 0.5F, f15 - ((float)Math.PI / 2F), f16 / 3.0F, j, i18, 1.0D, bitSet);
	            this.func_227206_a_(chunk, biomeGetter, random.nextLong(), i5, i6, i7, d8, d10, d12, random.nextFloat() * 0.5F + 0.5F, f15 + ((float)Math.PI / 2F), f16 / 3.0F, j, i18, 1.0D, bitSet);
	            return;
			}

			if (random.nextInt(4) != 0) {
	            if (!this.func_222702_a(i6, i7, d8, d12, j, i18, f14)) {
	            	return;
	            }

	            this.func_227208_a_(chunk, biomeGetter, l3, i5, i6, i7, d8, d10, d12, d0, d1, bitSet);
			}
		}
	}
	
	@Override
	public boolean func_225555_a_(IChunk chunk, Function<BlockPos, Biome> biomeGetter, Random rand, int i4, int i5, int i6, int i7, int i8, BitSet bitSet, ProbabilityConfig config) {
		int i = (this.func_222704_c() * 2 - 1) * 16;
		int j = rand.nextInt(rand.nextInt(rand.nextInt(this.func_222724_a()) + 1) + 1);

		for(int k = 0; k < j; ++k) {
			double d0 = (double)(i5 * 16 + rand.nextInt(16));
			double d1 = (double)this.generateCaveStartY(rand);
			double d2 = (double)(i6 * 16 + rand.nextInt(16));
			int l = 1;
			if (rand.nextInt(4) == 0) {
	            float f1 = 1.0F + rand.nextFloat() * 6.0F;
	            this.func_227205_a_(chunk, biomeGetter, rand.nextLong(), i4, i7, i8, d0, d1, d2, f1, 0.5D, bitSet);
	            l += rand.nextInt(4);
			}

			for(int k1 = 0; k1 < l; ++k1) {
				float f = rand.nextFloat() * ((float)Math.PI * 2F);
	            float f3 = (rand.nextFloat() - 0.5F) / 4.0F;
	            float f2 = this.generateCaveRadius(rand);
	            int i1 = i - rand.nextInt(i / 4);
	            this.func_227206_a_(chunk, biomeGetter, rand.nextLong(), i4, i7, i8, d0, d1, d2, f2, f, f3, 0, i1, this.func_222725_b(), bitSet);
			}
		}

		return true;
	}
	@Override
	public boolean shouldCarve(Random rand, int chunkX, int chunkZ, ProbabilityConfig config) {
		return rand.nextFloat() <= config.probability;
	}
	@Override
	protected boolean func_222708_a(double p_222708_1_, double p_222708_3_, double p_222708_5_, int p_222708_7_) {
		return false;
	}
}
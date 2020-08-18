package io.github.fallout015.two.world.gen.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractSmallTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class GhostwoodTreeFeature extends AbstractSmallTreeFeature<TreeFeatureConfig> {
	public GhostwoodTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> serializer) {
		super(serializer);
	}

	@Override
	protected boolean place(IWorldGenerationReader generationReader, Random rand, BlockPos positionIn, Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox boundingBoxIn, TreeFeatureConfig configIn) {
		/*
		int i = treeFeatureConfig.field_227371_p_ + random.nextInt(treeFeatureConfig.field_227328_b_ + 1) + random.nextInt(treeFeatureConfig.field_227329_c_ + 1);
		int j = treeFeatureConfig.field_227330_d_ >= 0 ? treeFeatureConfig.field_227330_d_ + random.nextInt(treeFeatureConfig.field_227331_f_ + 1) : i - (treeFeatureConfig.field_227334_i_ + random.nextInt(treeFeatureConfig.field_227335_j_ + 1));
		int k = treeFeatureConfig.field_227327_a_.func_225573_a_(random, j, i, treeFeatureConfig);
		Optional<BlockPos> optional = this.func_227212_a_(worldGenerationReader, i, j, k, blockPos, treeFeatureConfig);
		if (!optional.isPresent()) {
			return false;
		} else {
			BlockPos blockpos = optional.get();
			this.setDirtAt(worldGenerationReader, blockpos.down(), blockpos);
			Direction direction = Direction.Plane.HORIZONTAL.random(random);
			int l = i - random.nextInt(4) - 1;
			int i1 = 3 - random.nextInt(3);
			BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
			int j1 = blockpos.getX();
			int k1 = blockpos.getZ();
			int l1 = 0;

			for(int i2 = 0; i2 < i; ++i2) {
				int j2 = blockpos.getY() + i2;
	            if (i2 >= l && i1 > 0) {
	            	j1 += direction.getXOffset();
	            	k1 += direction.getZOffset();
	            	--i1;
	            }

	            if (this.func_227216_a_(worldGenerationReader, random, blockpos$mutable.setPos(j1, j2, k1), set$BlockPos1, mutableBoundingBox, treeFeatureConfig)) {
	            	l1 = j2;
	            }
			}

			BlockPos blockpos1 = new BlockPos(j1, l1, k1);
			treeFeatureConfig.field_227327_a_.func_225571_a_(worldGenerationReader, random, treeFeatureConfig, i, j, k + 1, blockpos1, set$BlockPos2);
			j1 = blockpos.getX();
			k1 = blockpos.getZ();
			Direction direction1 = Direction.Plane.HORIZONTAL.random(random);
			if (direction1 != direction) {
				int j3 = l - random.nextInt(2) - 1;
	            int k2 = 1 + random.nextInt(3);
	            l1 = 0;

	            for(int l2 = j3; l2 < i && k2 > 0; --k2) {
	            	if (l2 >= 1) {
	            		int i3 = blockpos.getY() + l2;
	            		j1 += direction1.getXOffset();
	            		k1 += direction1.getZOffset();
	            		if (this.func_227216_a_(worldGenerationReader, random, blockpos$mutable.setPos(j1, i3, k1), set$BlockPos1, mutableBoundingBox, treeFeatureConfig)) {
	            			l1 = i3;
	            		}
	            	}

	            	++l2;
	            }

	            if (l1 > 0) {
	            	BlockPos blockpos2 = new BlockPos(j1, l1, k1);
	            	treeFeatureConfig.field_227327_a_.func_225571_a_(worldGenerationReader, random, treeFeatureConfig, i, j, k, blockpos2, set$BlockPos2);
	            }
			}

			return true;
		}*/
		return false;
		// TODO
	}
}
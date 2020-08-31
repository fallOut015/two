package io.github.fallout015.two.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.serialization.Codec;

import io.github.fallout015.two.block.BlocksTwo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.AbstractBigMushroomFeature;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;

public class BigBrimshineFeature extends AbstractBigMushroomFeature {
	public BigBrimshineFeature(Codec<BigMushroomFeatureConfig> codec) {
		super(codec);
	}

	@Override
	protected int func_225563_a_(int p_225563_1_, int p_225563_2_, int p_225563_3_, int p_225563_4_) {
		return 0;
	}

	@Override
	protected void func_225564_a_(IWorld p_225564_1_, Random p_225564_2_, BlockPos p_225564_3_, int p_225564_4_, Mutable p_225564_5_, BigMushroomFeatureConfig p_225564_6_) {
		
	}
	@Override
	protected int func_227211_a_(Random rand) {
		return 5; // stem height
	}
	
	@Override
	protected boolean func_227209_a_(IWorld p_227209_1_, BlockPos p_227209_2_, int p_227209_3_, Mutable p_227209_4_, BigMushroomFeatureConfig p_227209_5_) {
		int i = p_227209_2_.getY();
		if (i >= 1 && i + p_227209_3_ + 1 < p_227209_1_.getMaxHeight()) {
			Block block = p_227209_1_.getBlockState(p_227209_2_.down()).getBlock();
			if (block != BlocksTwo.SPORESTONE_SOIL) {
				return false;
			} else {
	            for(int j = 0; j <= p_227209_3_; ++j) {
	            	int k = this.func_225563_a_(-1, -1, p_227209_5_.field_227274_c_, j);

	            	for(int l = -k; l <= k; ++l) {
	            		for(int i1 = -k; i1 <= k; ++i1) {
	            			BlockState blockstate = p_227209_1_.getBlockState(p_227209_4_.setPos(p_227209_2_).move(l, j, i1));
	            			if (!blockstate.isAir(p_227209_1_, p_227209_4_) && !blockstate.isIn(BlockTags.LEAVES)) {
	            				return false;
	            			}
	            		}
	            	}
	            }

	            return true;
			}
		} else {
			return false;
		}
	}
}
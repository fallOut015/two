package io.github.fallout015.two.world.gen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import io.github.fallout015.two.block.BlocksTwo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.AbstractBigMushroomFeature;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;

public class BigNeondotFeature extends AbstractBigMushroomFeature {
	Direction facing;
	
	public BigNeondotFeature(Codec<BigMushroomFeatureConfig> codec) {
		super(codec);
	}

	@Override
	protected int func_225563_a_(int i1, int i2, int i3, int i4) {
		int i = 0;
		if (i4 < i2 && i4 >= i2 - 3) {
			i = i3;
		} else if (i4 == i2) {
			i = i3;
		}
		return i;
	}
	@Override
	protected void func_225564_a_(IWorld world, Random rand, BlockPos pos, int i4, Mutable mutable, BigMushroomFeatureConfig config) {
		// i4 is cap offset
		
		for(int i = i4 - 2; i <= i4; ++i) {
			int j = i < i4 ? config.field_227274_c_ : config.field_227274_c_ - 1;

			// j is radius
			
			for(int l = -j; l <= j; ++l) {
				for(int i1 = -j; i1 <= j; ++i1) {
					boolean flag = l == -j;
					boolean flag1 = l == j;
					boolean flag2 = i1 == -j;
					boolean flag3 = i1 == j;
					boolean flag4 = flag || flag1;
					boolean flag5 = flag2 || flag3;
					if (i >= i4 || flag4 != flag5) {
						mutable.setPos(pos).move(l, i, i1).move(this.facing);
						if (world.getBlockState(mutable).canBeReplacedByLeaves(world, mutable)) {
							if(rand.nextInt(5) == 0) {
								this.setBlockState(world, mutable, BlocksTwo.SHROOMGLOW.getDefaultState());
							} else {
								this.setBlockState(world, mutable, config.field_227272_a_.getBlockState(rand, pos));
							}
							// change to assigning one dot per face. 
						}
					}
				}
			}
		}
	}
	@Override
	protected void func_227210_a_(IWorld world, Random rand, BlockPos pos, BigMushroomFeatureConfig config, int i5, Mutable mutable) {
		for(int i = 0; i < i5; ++ i) {
			if(i >= 4) {
				mutable.setPos(pos).move(this.facing).move(Direction.UP, i);
			} else {
				mutable.setPos(pos).move(Direction.UP, i);
			}
			if (world.getBlockState(mutable).canBeReplacedByLogs(world, mutable)) {
				this.setBlockState(world, mutable, config.field_227273_b_.getBlockState(rand, pos));
				if(i == 0 || i == 1 || i == 3) {
					if(i == 0) {
						// TODO change to algorithm
						this.setBlockState(world, mutable.offset(this.facing).north(), config.field_227273_b_.getBlockState(rand, pos));
						this.setBlockState(world, mutable.offset(this.facing).east(), config.field_227273_b_.getBlockState(rand, pos));
						this.setBlockState(world, mutable.offset(this.facing).south(), config.field_227273_b_.getBlockState(rand, pos));
						this.setBlockState(world, mutable.offset(this.facing).west(), config.field_227273_b_.getBlockState(rand, pos));
						this.setBlockState(world, mutable.north(), config.field_227273_b_.getBlockState(rand, pos));
						this.setBlockState(world, mutable.east(), config.field_227273_b_.getBlockState(rand, pos));
						this.setBlockState(world, mutable.south(), config.field_227273_b_.getBlockState(rand, pos));
						this.setBlockState(world, mutable.west(), config.field_227273_b_.getBlockState(rand, pos));
					}
					this.setBlockState(world, mutable.offset(this.facing), config.field_227273_b_.getBlockState(rand, pos));
				}
			}
		}
	}
	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BigMushroomFeatureConfig config) {
		int i = this.func_227211_a_(rand); // stem height from 6 to 7. 
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
		if (!this.func_227209_a_(worldIn, pos, i, blockpos$mutable, config)) {
			return false; // TODO for placeable on sporestone soil
		} else {
			this.facing = Direction.Plane.HORIZONTAL.random(rand);
			this.func_225564_a_(worldIn, rand, pos, i, blockpos$mutable, config); // place cap
			this.func_227210_a_(worldIn, rand, pos, config, i, blockpos$mutable); // place stems
			return true;
		}
	}
	@Override
	protected int func_227211_a_(Random rand) {
		return rand.nextInt(2) + 6; // 6 or 7
		// Returns height (amount of stems place vertically)
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
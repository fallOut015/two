package two.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.OctavesNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class NightmareSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	protected OctavesNoiseGenerator noiseGenerator;
	
	public NightmareSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> deserializer) {
		super(deserializer);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		int i = seaLevel + 1;
	    int j = x & 15;
	    int k = z & 15;
	    boolean flag = this.noiseGenerator.func_205563_a((double)x * 0.03125D, (double)z * 0.03125D, 0.0D) * 75.0D + random.nextDouble() > 0.0D;
	    boolean flag1 = this.noiseGenerator.func_205563_a((double)x * 0.03125D, 109.0D, (double)z * 0.03125D) * 75.0D + random.nextDouble() > 0.0D;
	    int l = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
	    BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
	    int i1 = -1;
	    BlockState blockstate = SurfaceBuilders.GAULT;
	    BlockState blockstate1 = SurfaceBuilders.NIGHTSTONE;

	    for(int j1 = 127; j1 >= 0; --j1) {
	    	blockpos$mutable.setPos(j, j1, k);
	        BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutable);
	        if (blockstate2.getBlock() != null && !blockstate2.isAir()) {
	        	if (blockstate2.getBlock() == defaultBlock.getBlock()) {
	        		if (i1 == -1) {
	        			if (l <= 0) {
	        				blockstate = AIR;
	        				blockstate1 = SurfaceBuilders.GAULT;
	        			} else if (j1 >= i - 4 && j1 <= i + 1) {
	        				blockstate = SurfaceBuilders.GAULT;
	        				blockstate1 = SurfaceBuilders.NIGHTSTONE;
	        				if (flag1) {
	        					blockstate = SurfaceBuilders.GAULT;
	        					blockstate1 = SurfaceBuilders.NIGHTSTONE;
	        				}

	        				if (flag) {
	        					blockstate = SurfaceBuilders.GAULT;
	        					blockstate1 = SurfaceBuilders.GAULT;
	        				}
	        			}

	        			if (j1 < i && (blockstate == null || blockstate.isAir())) {
	        				blockstate = defaultFluid;
	        			}

	        			i1 = l;
	        			if (j1 >= i - 1) {
	        				chunkIn.setBlockState(blockpos$mutable, blockstate, false);
	        			} else {
	        				chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
	        			}
	               } else if (i1 > 0) {
	            	   --i1;
	            	   chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
	               }
	        	}
	        } else {
	        	i1 = -1;
	        }
	    }
	}
}
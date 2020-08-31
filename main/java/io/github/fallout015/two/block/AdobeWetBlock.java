package io.github.fallout015.two.block;

import java.util.Random;
import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.server.ServerWorld;

public class AdobeWetBlock extends Block {
	public AdobeWetBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void tick(BlockState blockState, ServerWorld serverWorld, BlockPos pos, Random random) {
		if(!serverWorld.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
	    
		// TODO make sure it makes sense and stuff
		if(serverWorld.getBiome(pos).getCategory() == Category.ICY) {
	    	if(random.nextInt(Math.abs((int) (serverWorld.getBiome(pos).getTemperature(pos) * 100)) + 1) <= 50) {
	    		serverWorld.setBlockState(pos, BlocksTwo.ADOBE_FROZEN.getDefaultState());
	    		// roll from one to the temperature * 100 and succeed if the roll is 50 or less. 
	    	}
	    } else {
	    	Stream<BlockPos> lightSpaces = BlockPos.getAllInBox(pos.north().west(), pos.south().east().up());
			if(lightSpaces.anyMatch(blockPos -> random.nextInt(serverWorld.getMaxLightLevel() + 1) <= serverWorld.getLight(blockPos) + (serverWorld.getLight(blockPos) == 0 ? 0 : serverWorld.getBiome(pos).getTemperature(pos)))) {
				serverWorld.setBlockState(pos, BlocksTwo.ADOBE_DRY.getDefaultState());
		    	return;
		    	// roll from 1 to 16 and succeed if the roll is the light value or higher + the temperature. 
		    	// TODO block ticks? or something
		    }	
	    }
	}
}
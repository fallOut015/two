package two.block;

import java.util.Random;
import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class AdobeBlock extends Block {
	public AdobeBlock(Properties properties) {
		super(properties);
	}

	public void func_225534_a_(BlockState blockState, ServerWorld serverWorld, BlockPos pos, Random random) {
		if(!serverWorld.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
	    Stream<BlockPos> lightSpaces = BlockPos.getAllInBox(pos.north().west(), pos.south().east().up());
	    if(lightSpaces.anyMatch(blockPos -> random.nextInt(serverWorld.getMaxLightLevel()) <= serverWorld.getLight(blockPos))) {
	    	serverWorld.setBlockState(pos, BlocksTwo.ADOBE_DRY.getDefaultState());
	    	return;
	    }
	}
}
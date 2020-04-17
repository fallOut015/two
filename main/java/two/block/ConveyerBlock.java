package two.block;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class ConveyerBlock extends RotatedPillarBlock {
	public ConveyerBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public void func_225534_a_(BlockState blockState, ServerWorld serverWorld, BlockPos blockPos, Random random) {
		// TODO push entities
	}
}
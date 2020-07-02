package two.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ConveyerBlock extends RotatedPillarBlock {
	public ConveyerBlock(Properties properties) {
		super(properties);
	}
	
//	@Override
//	public void func_225534_a_(BlockState blockState, ServerWorld serverWorld, BlockPos blockPos, Random random) {
		// TODO push entities
//	}
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if(!(entityIn.getPosY() > pos.getY())) {
			return;
		}
		Vec3d destination = entityIn.getPositionVec();
		if(state.get(AXIS).test(Direction.NORTH)) {
			destination.add(1, 0, 0);
		} else if(state.get(AXIS).test(Direction.EAST)) {
			destination.add(1, 0, 0);
		} else if(state.get(AXIS).test(Direction.SOUTH)) {
			destination.add(-1, 0, 0);
		} else if(state.get(AXIS).test(Direction.WEST)) {
			destination.add(-1, 0, 0);
		}
		entityIn.move(MoverType.SELF, destination);
	}
}
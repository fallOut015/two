package two.pathfinding;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import two.Two;

public class SmallClimberPathNavigator extends GroundPathNavigator {
	private BlockPos targetPosition;

	public SmallClimberPathNavigator(MobEntity entitylivingIn, World worldIn) {
		super(entitylivingIn, worldIn);
	}
	
	@Override
	public Path getPathToPos(BlockPos pos, int p_179680_2_) {
		this.targetPosition = pos;
		return super.getPathToPos(pos, p_179680_2_);
	}
	@Override
	public Path getPathToEntity(Entity entityIn, int p_75494_2_) {
		this.targetPosition = new BlockPos(entityIn);
		return super.getPathToEntity(entityIn, p_75494_2_);
	}
	@Override
	public boolean tryMoveToEntityLiving(Entity entityIn, double speedIn) {
		Path path = this.getPathToEntity(entityIn, 0);
		if (path != null) {
			return this.setPath(path, speedIn);
		} else {
			this.targetPosition = new BlockPos(entityIn);
			this.speed = speedIn;
			return true;
		}
	}
	@Override
	public void tick() {
		if (!this.noPath()) {
			Two.LOGGER.info("has a path");
			super.tick();
		} else {
			Two.LOGGER.info("no path!");
			if(this.currentPath == null) {
				Two.LOGGER.info("current path is null");
			} else if(this.currentPath.isFinished()) {
				Two.LOGGER.info("current path is finished");
			}
			if (this.targetPosition != null) {
				if (!this.targetPosition.withinDistance(this.entity.getPositionVec(), (double)this.entity.getWidth() * 4) && (!(this.entity.getPosY() > (double)this.targetPosition.getY()) || !(new BlockPos((double)this.targetPosition.getX(), this.entity.getPosY(), (double)this.targetPosition.getZ())).withinDistance(this.entity.getPositionVec(), (double)this.entity.getWidth()))) {
					this.entity.getMoveHelper().setMoveTo((double)this.targetPosition.getX(), (double)this.targetPosition.getY(), (double)this.targetPosition.getZ(), this.speed);
					Two.LOGGER.info("set move to");
				} else {
					this.targetPosition = null;
					Two.LOGGER.info("set target pos to null");
	            }
			}
		}
		Two.LOGGER.info("");
	}
}
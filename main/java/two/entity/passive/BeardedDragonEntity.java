package two.entity.passive;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.world.World;

public class BeardedDragonEntity extends ShoulderRidingEntity {
	public BeardedDragonEntity(EntityType<? extends BeardedDragonEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		return null;
	}
}
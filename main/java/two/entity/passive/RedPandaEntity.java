package two.entity.passive;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public class RedPandaEntity extends AnimalEntity {
	public RedPandaEntity(EntityType<? extends RedPandaEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1);
	}
	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		return null;
	}
}
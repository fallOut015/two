package two.entity.monster;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.world.World;

public class IceSlimeEntity extends SlimeEntity {
	public IceSlimeEntity(EntityType<? extends IceSlimeEntity> type, World worldIn) {
		super(type, worldIn);
	}
}
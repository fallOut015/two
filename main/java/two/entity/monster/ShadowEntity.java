package two.entity.monster;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class ShadowEntity extends MonsterEntity {
	public ShadowEntity(EntityType<? extends ShadowEntity> type, World world) {
		super(type, world);
	}
}
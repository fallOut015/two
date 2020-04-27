package two.entity.monster;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public abstract class AbstractDarkDwarfEntity extends MonsterEntity {
	protected AbstractDarkDwarfEntity(EntityType<? extends AbstractDarkDwarfEntity> type, World world) {
		super(type, world);
	}
}
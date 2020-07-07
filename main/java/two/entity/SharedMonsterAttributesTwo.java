package two.entity;

import java.util.UUID;

import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;

public class SharedMonsterAttributesTwo {
	public static final IAttribute PROJECTILE_VELOCITY_ATTRIBUTE = (new RangedAttribute((IAttribute)null, "generic.projectileVelocity", 4.0D, 0.0D, 1024.0D)).setShouldWatch(true);

	public static final UUID PROJECTILE_VELOCITY_ID = UUID.fromString("37cc9ac6-9864-48bc-b81c-d65d3cf81e22");
}
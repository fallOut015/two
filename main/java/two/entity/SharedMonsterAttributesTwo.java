package two.entity;

import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;

public class SharedMonsterAttributesTwo {
	public static final IAttribute PROJECTILE_VELOCITY = (new RangedAttribute((IAttribute)null, "generic.projectileVelocity", 4.0D, 0.0D, 1024.0D)).setShouldWatch(true);
}
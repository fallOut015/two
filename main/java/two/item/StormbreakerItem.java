package two.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.world.server.ServerWorld;

public class StormbreakerItem extends SwordItem {
	public StormbreakerItem(Properties builder) {
		super(ItemTier.IRON, 6, 1.0f, builder);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if(target.isServerWorld()) {
	        LightningBoltEntity lightningboltentity = new LightningBoltEntity(((ServerWorld) target.getEntityWorld()), target.serverPosX, target.serverPosY, target.serverPosZ, false);
			((ServerWorld) target.getEntityWorld()).addLightningBolt(lightningboltentity);
		}
		
		// More effects if it's raining or thundering
		
		return super.hitEntity(stack, target, attacker);
	}
	
	// Right click to throw
}
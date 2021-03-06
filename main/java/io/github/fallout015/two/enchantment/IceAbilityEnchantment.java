package io.github.fallout015.two.enchantment;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;

public class IceAbilityEnchantment extends AbilityEnchantment {
	protected IceAbilityEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
	}

	@Override
	public void action(RightClickItem playerInteractEvent$rightClickItem) {
		for(int i = 0; i < 16; ++ i) {
			double x = playerInteractEvent$rightClickItem.getPlayer().getPosX();
			double y = playerInteractEvent$rightClickItem.getPlayer().getPosY();
			double z = playerInteractEvent$rightClickItem.getPlayer().getPosZ();
			float a = 22.5f * i;
			double xspeed = Math.cos(a);
//			double yspeed = Math.sin(a);
			double yspeed = 0;
			double zspeed = Math.tan(a);
			playerInteractEvent$rightClickItem.getWorld().addParticle(ParticleTypes.CLOUD, true, x, y, z, xspeed, yspeed, zspeed);
		}
	}
}
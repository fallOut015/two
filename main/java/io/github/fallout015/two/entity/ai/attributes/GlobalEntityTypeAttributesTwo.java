package io.github.fallout015.two.entity.ai.attributes;

import io.github.fallout015.two.entity.EntityTypeTwo;
import io.github.fallout015.two.entity.boss.magmeel.MagmeelEntity;
import io.github.fallout015.two.entity.effect.ButterflyEntity;
import io.github.fallout015.two.entity.monster.MummifiedZombieEntity;
import io.github.fallout015.two.entity.passive.BeardedDragonEntity;
import io.github.fallout015.two.entity.passive.ChameleonEntity;
import io.github.fallout015.two.entity.passive.CrimpEntity;
import io.github.fallout015.two.entity.passive.JellyfishEntity;
import io.github.fallout015.two.entity.passive.PenguinEntity;
import io.github.fallout015.two.entity.passive.RedPandaEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class GlobalEntityTypeAttributesTwo {
	public static void setup(final FMLCommonSetupEvent event) {
		GlobalEntityTypeAttributes.put(EntityTypeTwo.BEARDED_DRAGON.get(), BeardedDragonEntity.applyAttributes().create());
		GlobalEntityTypeAttributes.put(EntityTypeTwo.CHAMELEON.get(), ChameleonEntity.applyAttributes().create());
		GlobalEntityTypeAttributes.put(EntityTypeTwo.CRIMP.get(), CrimpEntity.applyAttributes().create());
		GlobalEntityTypeAttributes.put(EntityTypeTwo.JELLYFISH.get(), JellyfishEntity.applyAttributes().create());
		GlobalEntityTypeAttributes.put(EntityTypeTwo.PENGUIN.get(), PenguinEntity.applyAttributes().create());
		GlobalEntityTypeAttributes.put(EntityTypeTwo.RED_PANDA.get(), RedPandaEntity.applyAttributes().create());
		
		GlobalEntityTypeAttributes.put(EntityTypeTwo.DARK_DWARF_ARCHER.get(), MonsterEntity.func_234295_eP_().create()); // TODO give own stats. 
		GlobalEntityTypeAttributes.put(EntityTypeTwo.MUMMIFIED_ZOMBIE.get(), MummifiedZombieEntity.applyAttributes().create());
		GlobalEntityTypeAttributes.put(EntityTypeTwo.ICE_SLIME.get(), MonsterEntity.func_234295_eP_().create()); // TODO give own stats.
		GlobalEntityTypeAttributes.put(EntityTypeTwo.NETHER_FISH.get(), AbstractFishEntity.func_234176_m_().create()); // TODO give own stats.

		GlobalEntityTypeAttributes.put(EntityTypeTwo.BUTTERFLY.get(), ButterflyEntity.applyAttributes().create());

		GlobalEntityTypeAttributes.put(EntityTypeTwo.MAGMEEL.get(), MagmeelEntity.applyAttributes().create());
	}
}
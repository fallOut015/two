package io.github.fallout015.two.entity;

import java.util.LinkedList;

import io.github.fallout015.two.entity.boss.magmeel.MagmeelEntity;
import io.github.fallout015.two.entity.effect.ButterflyEntity;
import io.github.fallout015.two.entity.effect.SigilEntity;
import io.github.fallout015.two.entity.effect.TwisterEntity;
import io.github.fallout015.two.entity.item.BoatEntityTwo;
import io.github.fallout015.two.entity.monster.DarkDwarfArcherEntity;
import io.github.fallout015.two.entity.monster.IceSlimeEntity;
import io.github.fallout015.two.entity.monster.MummifiedZombieEntity;
import io.github.fallout015.two.entity.monster.NetherFishEntity;
import io.github.fallout015.two.entity.passive.BeardedDragonEntity;
import io.github.fallout015.two.entity.passive.ChameleonEntity;
import io.github.fallout015.two.entity.passive.CrimpEntity;
import io.github.fallout015.two.entity.passive.JellyfishEntity;
import io.github.fallout015.two.entity.passive.PenguinEntity;
import io.github.fallout015.two.entity.passive.RedPandaEntity;
import io.github.fallout015.two.entity.projectile.BombArrowEntity;
import io.github.fallout015.two.entity.projectile.CappedArrowEntity;
import io.github.fallout015.two.entity.projectile.EvocationFangsEntity;
import io.github.fallout015.two.entity.projectile.FireArrowEntity;
import io.github.fallout015.two.entity.projectile.IceArrowEntity;
import io.github.fallout015.two.entity.projectile.ShockArrowEntity;
import io.github.fallout015.two.entity.projectile.ShurikenEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public class EntityTypeTwo {
	public static final EntityType<BeardedDragonEntity> BEARDED_DRAGON = register("bearded_dragon", EntityType.Builder.create(BeardedDragonEntity::new, EntityClassification.CREATURE).size(0.2f, 0.2f));
	public static final EntityType<ChameleonEntity> CHAMELEON = register("chameleon", EntityType.Builder.create(ChameleonEntity::new, EntityClassification.CREATURE).size(0.25f, 0.25f));
	public static final EntityType<CrimpEntity> CRIMP = register("crimp", EntityType.Builder.create(CrimpEntity::new, EntityClassification.CREATURE).size(0.6875f, 1f));
	public static final EntityType<JellyfishEntity> JELLYFISH = register("jellyfish", EntityType.Builder.create(JellyfishEntity::new, EntityClassification.CREATURE).size(0.75f, 0.75f));
	public static final EntityType<PenguinEntity> PENGUIN = register("penguin", EntityType.Builder.create(PenguinEntity::new, EntityClassification.CREATURE).size(0.5f, 0.8f));
	public static final EntityType<RedPandaEntity> RED_PANDA = register("red_panda", EntityType.Builder.create(RedPandaEntity::new, EntityClassification.CREATURE).size(0.6875f, 1f));
	
	//	public static EntityType<WandererEntity> WANDERER = (EntityType<WandererEntity>) register("wanderer", EntityType.Builder.create(WandererEntity::new, EntityClassification.MONSTER).size(0.5f, 1.0f).build("wanderer"));
//	public static EntityType<ShadowEntity> SHADOW = (EntityType<ShadowEntity>) register("shadow", EntityType.Builder.create(ShadowEntity::new, EntityClassification.MONSTER).size(0.5f, 1.0f).build("shadow"));
	public static final EntityType<DarkDwarfArcherEntity> DARK_DWARF_ARCHER = register("dark_dwarf_archer", EntityType.Builder.create(DarkDwarfArcherEntity::new, EntityClassification.MONSTER).size(0.5f, 0.75f));
	// DARK_DWARF_GUARD
	// DARK_DWARF_MAGE
	// DARK_DWARF_POTIONER
	// DARK_DWARF_PALADIN
	public static final EntityType<MummifiedZombieEntity> MUMMIFIED_ZOMBIE = register("mummified_zombie", EntityType.Builder.create(MummifiedZombieEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F));
	public static final EntityType<IceSlimeEntity> ICE_SLIME = register("ice_slime", EntityType.Builder.create(IceSlimeEntity::new, EntityClassification.MONSTER).size(2.04F, 2.04F));
	public static final EntityType<NetherFishEntity> NETHER_FISH = register("nether_fish", EntityType.Builder.create(NetherFishEntity::new, EntityClassification.MONSTER).size(2.04f, 2.04f));
	
	public static final EntityType<CappedArrowEntity> CAPPED_ARROW = register("capped_arrow", EntityType.Builder.<CappedArrowEntity>create(CappedArrowEntity::new, EntityClassification.MISC).size(0.5F, 0.5F));
	public static final EntityType<FireArrowEntity> FIRE_ARROW = register("fire_arrow", EntityType.Builder.<FireArrowEntity>create(FireArrowEntity::new, EntityClassification.MISC).size(0.5f, 0.5f));
	public static final EntityType<IceArrowEntity> ICE_ARROW = register("ice_arrow", EntityType.Builder.<IceArrowEntity>create(IceArrowEntity::new, EntityClassification.MISC).size(0.5f, 0.5f));
	public static final EntityType<BombArrowEntity> BOMB_ARROW = register("bomb_arrow", EntityType.Builder.<BombArrowEntity>create(BombArrowEntity::new, EntityClassification.MISC).size(0.5f, 0.5f));
	public static final EntityType<ShockArrowEntity> SHOCK_ARROW = register("shock_arrow", EntityType.Builder.<ShockArrowEntity>create(ShockArrowEntity::new, EntityClassification.MISC).size(0.5f, 0.5f));
	public static final EntityType<EvocationFangsEntity> EVOCATION_FANGS = register("evocation_fangs", EntityType.Builder.<EvocationFangsEntity>create(EvocationFangsEntity::new, EntityClassification.MISC).size(0.5f, 0.8f));
	
	public static final EntityType<ShurikenEntity> SHURIKEN = register("shuriken", EntityType.Builder.<ShurikenEntity>create(ShurikenEntity::new, EntityClassification.MISC).size(0.25f, 0.25f));
	
	public static final EntityType<BoatEntityTwo> BOAT_TWO = register("boat_two", EntityType.Builder.<BoatEntityTwo>create(BoatEntityTwo::new, EntityClassification.MISC).size(1.375F, 0.5625F).trackingRange(10));

	public static final EntityType<SigilEntity> SIGIL = register("sigil", EntityType.Builder.create(SigilEntity::new, EntityClassification.MISC).size(4, 0.1f).disableSerialization());
	public static final EntityType<TwisterEntity> TWISTER = register("twister", EntityType.Builder.<TwisterEntity>create(TwisterEntity::new, EntityClassification.MISC).size(1, 2).disableSerialization());
	
//	public static final EntityType<SwarmEntity> SWARM = register("swarm", EntityType.Builder.create(SwarmEntity::new, EntityClassification.AMBIENT).size(0, 0));
	public static final EntityType<ButterflyEntity> BUTTERFLY = register("butterfly", EntityType.Builder.create(ButterflyEntity::new, EntityClassification.AMBIENT).size(0.5f, 0.5f));
	
	public static final EntityType<MagmeelEntity> MAGMEEL = register("magmeel", EntityType.Builder.create(MagmeelEntity::new, EntityClassification.MONSTER).size(0.5f, 0.5f));
	
	
	
	public static void onEntityTypesRegistry(final RegistryEvent.Register<EntityType<?>> entityTypeRegistryEvent) {
		entityTypeRegistryEvent.getRegistry().registerAll(Holder.ENTITYTYPESTWO.toArray(new EntityType<?>[] {}));
	}
	private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> entityType) {
		EntityType<T> entity = (EntityType<T>) entityType.build(key);
		entity.setRegistryName(key);
		Holder.ENTITYTYPESTWO.add(entity);
		return entity;
	}
	static class Holder {
		public static final LinkedList<EntityType<?>> ENTITYTYPESTWO = new LinkedList<EntityType<?>>();
	}
}
package io.github.fallout015.two.entity;

import io.github.fallout015.two.Two;
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
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeTwo {
	private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Two.MODID);

	
	
	public static final RegistryObject<EntityType<BeardedDragonEntity>> BEARDED_DRAGON = ENTITIES.register("bearded_dragon", () -> EntityType.Builder.create(BeardedDragonEntity::new, EntityClassification.CREATURE).size(0.2f, 0.2f).build("bearded_dragon"));
	public static final RegistryObject<EntityType<ChameleonEntity>> CHAMELEON = ENTITIES.register("chameleon", () -> EntityType.Builder.create(ChameleonEntity::new, EntityClassification.CREATURE).size(0.25f, 0.25f).build("chameleon"));
	public static final RegistryObject<EntityType<CrimpEntity>> CRIMP = ENTITIES.register("crimp", () -> EntityType.Builder.create(CrimpEntity::new, EntityClassification.CREATURE).size(0.6875f, 1f).build("crimp"));
	public static final RegistryObject<EntityType<JellyfishEntity>> JELLYFISH = ENTITIES.register("jellyfish", () -> EntityType.Builder.create(JellyfishEntity::new, EntityClassification.CREATURE).size(0.75f, 0.75f).build("jellyfish"));
	public static final RegistryObject<EntityType<PenguinEntity>> PENGUIN = ENTITIES.register("penguin", () -> EntityType.Builder.create(PenguinEntity::new, EntityClassification.CREATURE).size(0.5f, 0.8f).build("penguin"));
	public static final RegistryObject<EntityType<RedPandaEntity>> RED_PANDA = ENTITIES.register("red_panda", () -> EntityType.Builder.create(RedPandaEntity::new, EntityClassification.CREATURE).size(0.6875f, 1f).build("red_panda"));
	
	//	public static EntityType<WandererEntity> WANDERER = (EntityType<WandererEntity>) register("wanderer", EntityType.Builder.create(WandererEntity::new, EntityClassification.MONSTER).size(0.5f, 1.0f).build("wanderer"));
//	public static EntityType<ShadowEntity> SHADOW = (EntityType<ShadowEntity>) register("shadow", EntityType.Builder.create(ShadowEntity::new, EntityClassification.MONSTER).size(0.5f, 1.0f).build("shadow").build("bearded_dragon"));
	public static final RegistryObject<EntityType<DarkDwarfArcherEntity>> DARK_DWARF_ARCHER = ENTITIES.register("dark_dwarf_archer", () -> EntityType.Builder.create(DarkDwarfArcherEntity::new, EntityClassification.MONSTER).size(0.5f, 0.75f).build("dark_dwarf_archer"));
	// DARK_DWARF_GUARD
	// DARK_DWARF_MAGE
	// DARK_DWARF_POTIONER
	// DARK_DWARF_PALADIN
	public static final RegistryObject<EntityType<MummifiedZombieEntity>> MUMMIFIED_ZOMBIE = ENTITIES.register("mummified_zombie", () -> EntityType.Builder.create(MummifiedZombieEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F).build("mummified_zombie"));
	public static final RegistryObject<EntityType<IceSlimeEntity>> ICE_SLIME = ENTITIES.register("ice_slime", () -> EntityType.Builder.create(IceSlimeEntity::new, EntityClassification.MONSTER).size(2.04F, 2.04F).build("ice_slime"));
	public static final RegistryObject<EntityType<NetherFishEntity>> NETHER_FISH = ENTITIES.register("nether_fish", () -> EntityType.Builder.create(NetherFishEntity::new, EntityClassification.MONSTER).size(2.04f, 2.04f).build("nether_fish"));
	
	public static final RegistryObject<EntityType<CappedArrowEntity>> CAPPED_ARROW = ENTITIES.register("capped_arrow", () -> EntityType.Builder.<CappedArrowEntity>create(CappedArrowEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).build("capped_arrow"));
	public static final RegistryObject<EntityType<FireArrowEntity>> FIRE_ARROW = ENTITIES.register("fire_arrow", () -> EntityType.Builder.<FireArrowEntity>create(FireArrowEntity::new, EntityClassification.MISC).size(0.5f, 0.5f).build("fire_arrow"));
	public static final RegistryObject<EntityType<IceArrowEntity>> ICE_ARROW = ENTITIES.register("ice_arrow", () -> EntityType.Builder.<IceArrowEntity>create(IceArrowEntity::new, EntityClassification.MISC).size(0.5f, 0.5f).build("ice_arrow"));
	public static final RegistryObject<EntityType<BombArrowEntity>> BOMB_ARROW = ENTITIES.register("bomb_arrow", () -> EntityType.Builder.<BombArrowEntity>create(BombArrowEntity::new, EntityClassification.MISC).size(0.5f, 0.5f).build("bomb_arrow"));
	public static final RegistryObject<EntityType<ShockArrowEntity>> SHOCK_ARROW = ENTITIES.register("shock_arrow", () -> EntityType.Builder.<ShockArrowEntity>create(ShockArrowEntity::new, EntityClassification.MISC).size(0.5f, 0.5f).build("shock_arrow"));
	public static final RegistryObject<EntityType<EvocationFangsEntity>> EVOCATION_FANGS = ENTITIES.register("evocation_fangs", () -> EntityType.Builder.<EvocationFangsEntity>create(EvocationFangsEntity::new, EntityClassification.MISC).size(0.5f, 0.8f).build("evocation_fangs"));
	
	public static final RegistryObject<EntityType<ShurikenEntity>> SHURIKEN = ENTITIES.register("shuriken", () -> EntityType.Builder.<ShurikenEntity>create(ShurikenEntity::new, EntityClassification.MISC).size(0.25f, 0.25f).build("shuriken"));
	
	public static final RegistryObject<EntityType<BoatEntityTwo>> BOAT_TWO = ENTITIES.register("boat_two", () -> EntityType.Builder.<BoatEntityTwo>create(BoatEntityTwo::new, EntityClassification.MISC).size(1.375F, 0.5625F).trackingRange(10).build("boat_two"));

	public static final RegistryObject<EntityType<SigilEntity>> SIGIL = ENTITIES.register("sigil", () -> EntityType.Builder.create(SigilEntity::new, EntityClassification.MISC).size(4, 0.1f).disableSerialization().build("sigil"));
	public static final RegistryObject<EntityType<TwisterEntity>> TWISTER = ENTITIES.register("twister", () -> EntityType.Builder.<TwisterEntity>create(TwisterEntity::new, EntityClassification.MISC).size(1, 2).disableSerialization().build("twister"));
	
//	public static final EntityType<SwarmEntity> SWARM = register("swarm", EntityType.Builder.create(SwarmEntity::new, EntityClassification.AMBIENT).size(0, 0));
	public static final RegistryObject<EntityType<ButterflyEntity>> BUTTERFLY = ENTITIES.register("butterfly", () -> EntityType.Builder.create(ButterflyEntity::new, EntityClassification.AMBIENT).size(0.5f, 0.5f).build("butterfly"));
	
	public static final RegistryObject<EntityType<MagmeelEntity>> MAGMEEL = ENTITIES.register("magmeel", () -> EntityType.Builder.create(MagmeelEntity::new, EntityClassification.MONSTER).size(0.5f, 0.5f).build("magmeel"));
	
	
	
	public static void register(IEventBus bus) {
		ENTITIES.register(bus);
	}
}
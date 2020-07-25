package two.entity;

import java.util.LinkedList;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import two.entity.effect.SigilEntity;
import two.entity.effect.TwisterEntity;
import two.entity.monster.DarkDwarfArcherEntity;
import two.entity.monster.IceSlimeEntity;
import two.entity.monster.MummifiedZombieEntity;
import two.entity.passive.BeardedDragonEntity;
import two.entity.passive.ChameleonEntity;
import two.entity.passive.NetherBugEntity;
import two.entity.passive.RedPandaEntity;
import two.entity.projectile.BombArrowEntity;
import two.entity.projectile.CappedArrowEntity;
import two.entity.projectile.EvocationFangsEntity;
import two.entity.projectile.FireArrowEntity;
import two.entity.projectile.IceArrowEntity;
import two.entity.projectile.ShockArrowEntity;

@ObjectHolder("two")
@SuppressWarnings("unchecked")
public class EntityTypeTwo {
	public static EntityType<ChameleonEntity> CHAMELEON = (EntityType<ChameleonEntity>) register("chameleon", EntityType.Builder.create(ChameleonEntity::new, EntityClassification.CREATURE).size(0.25f, 0.25f).build("chameleon"));
	public static EntityType<BeardedDragonEntity> BEARDED_DRAGON = (EntityType<BeardedDragonEntity>) register("bearded_dragon", EntityType.Builder.create(BeardedDragonEntity::new, EntityClassification.CREATURE).size(0.2f, 0.2f).build("bearded_dragon"));
	public static EntityType<RedPandaEntity> RED_PANDA = (EntityType<RedPandaEntity>) register("red_panda", EntityType.Builder.create(RedPandaEntity::new, EntityClassification.CREATURE).size(0.6875f, 1f).build("red_panda"));
	public static EntityType<NetherBugEntity> NETHER_BUG = (EntityType<NetherBugEntity>) register("nether_bug", EntityType.Builder.create(NetherBugEntity::new, EntityClassification.CREATURE).size(0.6875f, 1f).build("nether_bug"));
	
	//	public static EntityType<WandererEntity> WANDERER = (EntityType<WandererEntity>) register("wanderer", EntityType.Builder.create(WandererEntity::new, EntityClassification.MONSTER).size(0.5f, 1.0f).build("wanderer"));
//	public static EntityType<ShadowEntity> SHADOW = (EntityType<ShadowEntity>) register("shadow", EntityType.Builder.create(ShadowEntity::new, EntityClassification.MONSTER).size(0.5f, 1.0f).build("shadow"));
	public static EntityType<DarkDwarfArcherEntity> DARK_DWARF_ARCHER = (EntityType<DarkDwarfArcherEntity>) register("dark_dwarf_archer", EntityType.Builder.create(DarkDwarfArcherEntity::new, EntityClassification.MONSTER).size(0.5f, 0.75f).build("dark_dwarf_archer"));
	// DARK_DWARF_GUARD
	// DARK_DWARF_MAGE
	// DARK_DWARF_POTIONER
	// DARK_DWARF_PALADIN
	public static EntityType<MummifiedZombieEntity> MUMMIFIED_ZOMBIE = (EntityType<MummifiedZombieEntity>) register("mummified_zombie", EntityType.Builder.create(MummifiedZombieEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F).build("mummified_zombie"));
	public static EntityType<IceSlimeEntity> ICE_SLIME = (EntityType<IceSlimeEntity>) register("ice_slime", EntityType.Builder.create(IceSlimeEntity::new, EntityClassification.MONSTER).size(2.04F, 2.04F).build("ice_slime"));
	
	public static EntityType<CappedArrowEntity> CAPPED_ARROW = (EntityType<CappedArrowEntity>) register("capped_arrow", EntityType.Builder.<CappedArrowEntity>create(CappedArrowEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).build("capped_arrow"));
	public static EntityType<FireArrowEntity> FIRE_ARROW = (EntityType<FireArrowEntity>) register("fire_arrow", EntityType.Builder.<FireArrowEntity>create(FireArrowEntity::new, EntityClassification.MISC).size(0.5f, 0.5f).build("fire_arrow"));
	public static EntityType<IceArrowEntity> ICE_ARROW = (EntityType<IceArrowEntity>) register("ice_arrow", EntityType.Builder.<IceArrowEntity>create(IceArrowEntity::new, EntityClassification.MISC).size(0.5f, 0.5f).build("ice_arrow"));
	public static EntityType<BombArrowEntity> BOMB_ARROW = (EntityType<BombArrowEntity>) register("bomb_arrow", EntityType.Builder.<BombArrowEntity>create(BombArrowEntity::new, EntityClassification.MISC).size(0.5f, 0.5f).build("bomb_arrow"));
	public static EntityType<ShockArrowEntity> SHOCK_ARROW = (EntityType<ShockArrowEntity>) register("shock_arrow", EntityType.Builder.<ShockArrowEntity>create(ShockArrowEntity::new, EntityClassification.MISC).size(0.5f, 0.5f).build("shock_arrow"));
	public static EntityType<EvocationFangsEntity> EVOCATION_FANGS = (EntityType<EvocationFangsEntity>) register("evocation_fangs", EntityType.Builder.<EvocationFangsEntity>create(EvocationFangsEntity::new, EntityClassification.MISC).size(0.5f, 0.8f).build("evocation_fangs"));
	
	public static EntityType<SigilEntity> SIGIL = (EntityType<SigilEntity>) register("sigil", EntityType.Builder.create(SigilEntity::new, EntityClassification.MISC).size(4, 0.1f).disableSerialization().build("sigil"));
	public static EntityType<TwisterEntity> TWISTER = (EntityType<TwisterEntity>) register("twister", EntityType.Builder.create(TwisterEntity::new, EntityClassification.MISC).size(1, 2).disableSerialization().build("twister"));
	
	
	
	public static void onEntityTypesRegistry(final RegistryEvent.Register<EntityType<?>> entityTypeRegistryEvent) {
		entityTypeRegistryEvent.getRegistry().registerAll(Holder.ENTITYTYPESTWO.toArray(new EntityType<?> [] {}));
	}
	private static EntityType<?> register(String key, EntityType<?> entityType) {
		entityType.setRegistryName(key);
		Holder.ENTITYTYPESTWO.add(entityType);
		return entityType;
	}
	static class Holder {
		public static final LinkedList<EntityType<?>> ENTITYTYPESTWO = new LinkedList<EntityType<?>>();
	}
}

package two.entity;

import java.util.LinkedList;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import two.entity.effect.SigilEntity;
import two.entity.monster.DarkDwarfArcherEntity;
import two.entity.monster.ShadowEntity;
import two.entity.monster.WandererEntity;
import two.entity.passive.ChameleonEntity;
import two.entity.projectile.CappedArrowEntity;

@ObjectHolder("two")
@SuppressWarnings("unchecked")
public class EntityTypeTwo {
	public static EntityType<ChameleonEntity> CHAMELEON = (EntityType<ChameleonEntity>) register("chameleon", EntityType.Builder.create(ChameleonEntity::new, EntityClassification.CREATURE).size(0.25f, 0.25f).build("chameleon"));
	public static EntityType<WandererEntity> WANDERER = (EntityType<WandererEntity>) register("wanderer", EntityType.Builder.create(WandererEntity::new, EntityClassification.MONSTER).size(0.5f, 1.0f).build("wanderer"));
	public static EntityType<ShadowEntity> SHADOW = (EntityType<ShadowEntity>) register("shadow", EntityType.Builder.create(ShadowEntity::new, EntityClassification.MONSTER).size(0.5f, 1.0f).build("shadow"));
	public static EntityType<DarkDwarfArcherEntity> DARK_DWARF_ARCHER = (EntityType<DarkDwarfArcherEntity>) register("dark_dwarf_archer", EntityType.Builder.create(DarkDwarfArcherEntity::new, EntityClassification.MONSTER).size(0.5f, 0.75f).build("dark_dwarf_archer"));
	// DARK_DWARF_GUARD
	// DARK_DWARF_MAGE
	// DARK_DWARF_POTIONER
	// DARK_DWARF_PALADIN
	
	public static EntityType<CappedArrowEntity> CAPPED_ARROW = (EntityType<CappedArrowEntity>) register("capped_arrow", EntityType.Builder.<CappedArrowEntity>create(CappedArrowEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).build("capped_arrow"));
	
	public static EntityType<SigilEntity> SIGIL = (EntityType<SigilEntity>) register("sigil", EntityType.Builder.create(SigilEntity::new, EntityClassification.MISC).size(4, 0.1f).disableSerialization().build("sigil"));
	
	
	
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

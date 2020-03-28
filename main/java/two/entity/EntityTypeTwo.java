package two.entity;

import java.util.LinkedList;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import two.entity.passive.ChameleonEntity;

@ObjectHolder("two")
@SuppressWarnings("unchecked")
public class EntityTypeTwo {
	public static EntityType<ChameleonEntity> CHAMELEON = (EntityType<ChameleonEntity>) register("chameleon", EntityType.Builder.create(ChameleonEntity::new, EntityClassification.CREATURE).size(0.25f, 0.25f).build("chameleon"));

	public static void onEntityTypesRegistry(final RegistryEvent.Register<EntityType<?>> entityTypeRegistryEvent) {
		entityTypeRegistryEvent.getRegistry().registerAll(Holder.entityTypesTwo.toArray(new EntityType<?> [] {}));
	}
	private static EntityType<?> register(String key, EntityType<?> entityType) {
		entityType.setRegistryName(key);
		Holder.entityTypesTwo.add(entityType);
		return entityType;
	}
	static class Holder {
		public static LinkedList<EntityType<?>> entityTypesTwo = new LinkedList<EntityType<?>>();
	}
}

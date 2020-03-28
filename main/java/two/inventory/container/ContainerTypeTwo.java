package two.inventory.container;

import java.util.LinkedList;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import two.client.gui.screen.inventory.KnapsackScreen;

@ObjectHolder("two")
public class ContainerTypeTwo {
	public static final ContainerType<KnapsackContainer> KNAPSACK = register("knapsack", KnapsackContainer::new);
	
	public static void onContainerTypesRegistry(final RegistryEvent.Register<ContainerType<?>> containerTypeRegistryEvent) {
		containerTypeRegistryEvent.getRegistry().registerAll(Holder.containerTypesTwo.toArray(new ContainerType<?> [] {}));

		ScreenManager.registerFactory(KNAPSACK, KnapsackScreen::new);
	}
	static <T extends Container> ContainerType<T> register(String key, ContainerType.IFactory<T> factory) {
		@SuppressWarnings("unchecked")
		ContainerType<T> containerType = (ContainerType<T>) new ContainerType<T>(factory).setRegistryName(key);
		
		Holder.containerTypesTwo.add(containerType);
		
		return containerType;
	}
	static class Holder {
		public static LinkedList<ContainerType<?>> containerTypesTwo = new LinkedList<ContainerType<?>>();
	}
}
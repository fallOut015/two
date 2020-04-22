package two.inventory.container;

import java.util.LinkedList;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import two.client.gui.screen.inventory.KnapsackScreen;
import two.client.gui.screen.inventory.UpholsteryTableScreen;

@ObjectHolder("two")
public class ContainerTypeTwo {
	public static final ContainerType<KnapsackContainer> KNAPSACK = register("knapsack", KnapsackContainer::new);
	public static final ContainerType<UpholsteryTableContainer> UPHOLSTERY_TABLE = register("upholstery_table", UpholsteryTableContainer::new);
	
	public static void onContainerTypesRegistry(final RegistryEvent.Register<ContainerType<?>> containerTypeRegistryEvent) {
		containerTypeRegistryEvent.getRegistry().registerAll(Holder.CONTAINERTYPESTWO.toArray(new ContainerType<?> [] {}));

		ScreenManager.registerFactory(KNAPSACK, KnapsackScreen::new);
		ScreenManager.registerFactory(UPHOLSTERY_TABLE, UpholsteryTableScreen::new);
	}
	static <T extends Container> ContainerType<T> register(String key, ContainerType.IFactory<T> factory) {
		@SuppressWarnings("unchecked")
		ContainerType<T> containerType = (ContainerType<T>) new ContainerType<T>(factory).setRegistryName(key);
		
		Holder.CONTAINERTYPESTWO.add(containerType);
		
		return containerType;
	}
	static class Holder {
		public static final LinkedList<ContainerType<?>> CONTAINERTYPESTWO = new LinkedList<ContainerType<?>>();
	}
}
package io.github.fallout015.two.inventory.container;

import io.github.fallout015.two.Two;
import io.github.fallout015.two.client.gui.screen.inventory.KnapsackScreen;
import io.github.fallout015.two.client.gui.screen.inventory.UpholsteryTableScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypeTwo {
	private static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Two.MODID);

	
	
	public static final RegistryObject<ContainerType<KnapsackContainer>> KNAPSACK = CONTAINERS.register("knapsack", () -> new ContainerType<KnapsackContainer>(KnapsackContainer::new));
	public static final RegistryObject<ContainerType<UpholsteryTableContainer>> UPHOLSTERY_TABLE = CONTAINERS.register("upholstery_table", () -> new ContainerType<UpholsteryTableContainer>(UpholsteryTableContainer::new));
	
	
	
	@OnlyIn(Dist.CLIENT)
	static void registerScreens() {
		ScreenManager.registerFactory(KNAPSACK.get(), KnapsackScreen::new);
		ScreenManager.registerFactory(UPHOLSTERY_TABLE.get(), UpholsteryTableScreen::new);
	}
	public static void register(IEventBus bus) {
		CONTAINERS.register(bus);
	}
}
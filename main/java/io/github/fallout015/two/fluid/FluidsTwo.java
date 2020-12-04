package io.github.fallout015.two.fluid;

import io.github.fallout015.two.Two;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidsTwo {
	private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Two.MODID);
	
	
	
	public static final RegistryObject<MudFluid.Source> MUD = FLUIDS.register("mud", () -> new MudFluid.Source());
	public static final RegistryObject<MudFluid.Flowing> FLOWING_MUD = FLUIDS.register("flowing_mud", () -> new MudFluid.Flowing());

	
	
	public static void register(IEventBus bus) {
		FLUIDS.register(bus);
	}
}
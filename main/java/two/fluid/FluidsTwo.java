package two.fluid;

import java.util.LinkedList;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public class FluidsTwo {
	public static final FlowingFluid MUD = register("mud", new MudFluid.Source());
	public static final FlowingFluid FLOWING_MUD = register("flowing_mud", new MudFluid.Flowing());
	
	public static void onFluidsRegistry(final RegistryEvent.Register<Fluid> fluidRegistryEvent) {
		fluidRegistryEvent.getRegistry().registerAll(Holder.FLUIDSTWO.toArray(new Fluid [] {}));
	}
	static <T extends Fluid> T register(String key, T fluid) {
		Holder.FLUIDSTWO.add(fluid.setRegistryName("two", key));
		
		return fluid;
	}
	static class Holder {
		public static final LinkedList<Fluid> FLUIDSTWO = new LinkedList<Fluid>();
	}
}
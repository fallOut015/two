package two.world.gen.surfacebuilders;

import java.util.LinkedList;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import two.block.BlocksTwo;

@SuppressWarnings("unchecked")
public class SurfaceBuilders {
	public static final BlockState GAULT = BlocksTwo.GAULT.getDefaultState();
	public static final BlockState NIGHTSTONE = BlocksTwo.NIGHTSTONE.getDefaultState();
	
	public static final SurfaceBuilderConfig GAULT_CONFIG = new SurfaceBuilderConfig(GAULT, NIGHTSTONE, NIGHTSTONE);
	
	public static final SurfaceBuilder<SurfaceBuilderConfig> NIGHTMARE = (SurfaceBuilder<SurfaceBuilderConfig>) register("nightmare", new NightmareSurfaceBuilder(SurfaceBuilderConfig::deserialize));
	
	public static void onSurfaceBuildersRegistry(final RegistryEvent.Register<SurfaceBuilder<?>> surfaceBuilderRegistryEvent) {
		surfaceBuilderRegistryEvent.getRegistry().registerAll(Holder.SURFACEBUILDERSTWO.toArray(new SurfaceBuilder<?> [] {}));
	}
	static SurfaceBuilder<?> register(String key, SurfaceBuilder<?> surfaceBuilder) {
		Holder.SURFACEBUILDERSTWO.add(surfaceBuilder.setRegistryName(key));
		
		return surfaceBuilder;
	}
	static class Holder {
		public static final LinkedList<SurfaceBuilder<?>> SURFACEBUILDERSTWO = new LinkedList<SurfaceBuilder<?>>();
	}
}

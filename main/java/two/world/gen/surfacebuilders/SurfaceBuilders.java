package two.world.gen.surfacebuilders;

import java.util.LinkedList;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import two.block.BlocksTwo;

public class SurfaceBuilders {
	public static final BlockState GAULT = BlocksTwo.GAULT.getDefaultState();
	public static final BlockState NIGHTSTONE = BlocksTwo.NIGHTSTONE.getDefaultState();
	public static final BlockState CLOUD = BlocksTwo.CLOUD.getDefaultState();
	
	public static final SurfaceBuilderConfig GAULT_CONFIG = new SurfaceBuilderConfig(GAULT, NIGHTSTONE, NIGHTSTONE);
	public static final SurfaceBuilderConfig CLOUD_CONFIG = new SurfaceBuilderConfig(CLOUD, CLOUD, CLOUD);
	
	public static final SurfaceBuilder<SurfaceBuilderConfig> NIGHTMARE = register("nightmare", new NightmareSurfaceBuilder(SurfaceBuilderConfig::deserialize));
	public static final SurfaceBuilder<SurfaceBuilderConfig> NIGHTMARE_HIGHLANDS = register("nightmare_highlands", new NightmareHighlandsSurfaceBuilder(SurfaceBuilderConfig::deserialize));
	public static final SurfaceBuilder<SurfaceBuilderConfig> SKY = register("sky", new SkySurfaceBuilder(SurfaceBuilderConfig::deserialize));
	
	public static void onSurfaceBuildersRegistry(final RegistryEvent.Register<SurfaceBuilder<?>> surfaceBuilderRegistryEvent) {
		surfaceBuilderRegistryEvent.getRegistry().registerAll(Holder.SURFACEBUILDERSTWO.toArray(new SurfaceBuilder<?> [] {}));
	}
	static SurfaceBuilder<SurfaceBuilderConfig> register(String key, SurfaceBuilder<SurfaceBuilderConfig> surfaceBuilder) {
		Holder.SURFACEBUILDERSTWO.add(surfaceBuilder.setRegistryName(key));
		
		return surfaceBuilder;
	}
	static class Holder {
		public static final LinkedList<SurfaceBuilder<?>> SURFACEBUILDERSTWO = new LinkedList<SurfaceBuilder<?>>();
	}
}

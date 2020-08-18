package io.github.fallout015.two.world.gen.surfacebuilders;

import java.util.LinkedList;

import io.github.fallout015.two.block.BlocksTwo;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;

public class SurfaceBuilderTwo {
	public static final BlockState GAULT = BlocksTwo.GAULT.getDefaultState();
	public static final BlockState NIGHTSTONE = BlocksTwo.NIGHTSTONE.getDefaultState();
	
	public static final BlockState CLOUD = BlocksTwo.CLOUD.getDefaultState();
	
	public static final BlockState ICE = Blocks.ICE.getDefaultState();
	public static final BlockState PACKED_ICE = Blocks.PACKED_ICE.getDefaultState();
	
	public static final BlockState REGOLITH = BlocksTwo.REGOLITH.getDefaultState();
	public static final BlockState MYRKYLITE = BlocksTwo.MYRKYLITE.getDefaultState();
	
	public static final BlockState PERMAFROST_GRASS_BLOCK = BlocksTwo.PERMAFROST_GRASS_BLOCK.getDefaultState();
	public static final BlockState PERMAFROST_DIRT = BlocksTwo.PERMAFROST_DIRT.getDefaultState();
	
	
	
	public static final SurfaceBuilderConfig GAULT_NIGHTSTONE_CONFIG = new SurfaceBuilderConfig(GAULT, NIGHTSTONE, NIGHTSTONE);
	public static final SurfaceBuilderConfig CLOUD_CONFIG = new SurfaceBuilderConfig(CLOUD, CLOUD, CLOUD);
	public static final SurfaceBuilderConfig ICE_PACKED_ICE_CONFIG = new SurfaceBuilderConfig(ICE, ICE, PACKED_ICE);
	public static final SurfaceBuilderConfig REGOLITH_MYRKYLITE_CONFIG = new SurfaceBuilderConfig(REGOLITH, MYRKYLITE, REGOLITH);
	public static final SurfaceBuilderConfig PERMAFROST_GRASS_BLOCK_PERMAFROST_DIRT_CONFIG = new SurfaceBuilderConfig(PERMAFROST_GRASS_BLOCK, PERMAFROST_DIRT, PERMAFROST_DIRT);
	
	
	
	public static final SurfaceBuilder<SurfaceBuilderConfig> NIGHTMARE = register("nightmare", new NightmareSurfaceBuilder(SurfaceBuilderConfig::deserialize));
	public static final SurfaceBuilder<SurfaceBuilderConfig> NIGHTMARE_HIGHLANDS = register("nightmare_highlands", new NightmareHighlandsSurfaceBuilder(SurfaceBuilderConfig::deserialize));
	public static final SurfaceBuilder<SurfaceBuilderConfig> SKY = register("sky", new SkySurfaceBuilder(SurfaceBuilderConfig::deserialize));
	public static final SurfaceBuilder<SurfaceBuilderConfig> FROSTBITE = register("frostbite", new FrostbiteSurfaceBuilder(SurfaceBuilderConfig::deserialize));
	public static final SurfaceBuilder<SurfaceBuilderConfig> NIDAVELLIR = register("nidavellir", new NidavellirSurfaceBuilder(SurfaceBuilderConfig::deserialize));
	
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

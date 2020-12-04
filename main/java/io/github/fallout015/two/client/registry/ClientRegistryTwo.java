package io.github.fallout015.two.client.registry;

import io.github.fallout015.two.client.renderer.tileentity.ChairRenderer;
import io.github.fallout015.two.tileentity.TileEntityTypeTwo;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientRegistryTwo {
	public static void doClientStuff(final FMLClientSetupEvent event) {
    	ClientRegistry.bindTileEntityRenderer(TileEntityTypeTwo.CHAIR.get(), ChairRenderer::new);
	}
}
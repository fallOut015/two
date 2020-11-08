package io.github.fallout015.two.client.registry;

import io.github.fallout015.two.client.renderer.entity.BeardedDragonRenderer;
import io.github.fallout015.two.client.renderer.entity.BoatRendererTwo;
import io.github.fallout015.two.client.renderer.entity.BombArrowRenderer;
import io.github.fallout015.two.client.renderer.entity.ButterflyRenderer;
import io.github.fallout015.two.client.renderer.entity.CappedArrowRenderer;
import io.github.fallout015.two.client.renderer.entity.ChameleonRenderer;
import io.github.fallout015.two.client.renderer.entity.CrimpRenderer;
import io.github.fallout015.two.client.renderer.entity.DarkDwarfArcherRenderer;
import io.github.fallout015.two.client.renderer.entity.FireArrowRenderer;
import io.github.fallout015.two.client.renderer.entity.IceArrowRenderer;
import io.github.fallout015.two.client.renderer.entity.IceSlimeRenderer;
import io.github.fallout015.two.client.renderer.entity.JellyfishRenderer;
import io.github.fallout015.two.client.renderer.entity.MummifiedZombieRenderer;
import io.github.fallout015.two.client.renderer.entity.NetherFishRenderer;
import io.github.fallout015.two.client.renderer.entity.PenguinRenderer;
import io.github.fallout015.two.client.renderer.entity.RedPandaRenderer;
import io.github.fallout015.two.client.renderer.entity.ShockArrowRenderer;
import io.github.fallout015.two.client.renderer.entity.ShurikenRenderer;
import io.github.fallout015.two.client.renderer.entity.SigilRenderer;
import io.github.fallout015.two.client.renderer.entity.TwisterRenderer;
import io.github.fallout015.two.entity.EntityTypeTwo;
import net.minecraft.client.renderer.entity.EvokerFangsRenderer;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class RenderingRegistryTwo {
	public static void doClientStuff(final FMLClientSetupEvent event) {
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.BEARDED_DRAGON, BeardedDragonRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.CHAMELEON, ChameleonRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.CRIMP, CrimpRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.JELLYFISH, JellyfishRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.PENGUIN, PenguinRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.RED_PANDA, RedPandaRenderer::new);
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.CAPPED_ARROW, CappedArrowRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.FIRE_ARROW, FireArrowRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.ICE_ARROW, IceArrowRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.BOMB_ARROW, BombArrowRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.SHOCK_ARROW, ShockArrowRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.EVOCATION_FANGS, EvokerFangsRenderer::new);
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.SHURIKEN, ShurikenRenderer::new);

    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.BOAT_TWO, BoatRendererTwo::new);

    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.DARK_DWARF_ARCHER, DarkDwarfArcherRenderer::new);

    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.MUMMIFIED_ZOMBIE, MummifiedZombieRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.ICE_SLIME, IceSlimeRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.NETHER_FISH, NetherFishRenderer::new);
    	
//    	RenderingRegistry.registerEntityRenderingHandler(EntityType.WOLF, WolfRendererTwo::new); // TODO
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.SIGIL, SigilRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.TWISTER, TwisterRenderer::new);
    	
//    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.SWARM, SwarmRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.BUTTERFLY, ButterflyRenderer::new);
    	
//    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.MAGMEEL, MagmeelRenderer::new);
	}
}
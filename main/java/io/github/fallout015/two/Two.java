package io.github.fallout015.two;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

import com.google.common.collect.Sets;

import io.github.fallout015.two.block.BlocksTwo;
import io.github.fallout015.two.block.DreamcatcherBlock;
import io.github.fallout015.two.client.particle.FrostParticle;
import io.github.fallout015.two.client.particle.SparkParticle;
import io.github.fallout015.two.client.particle.TwinkleParticle;
import io.github.fallout015.two.client.renderer.RenderTypeLookupTwo;
import io.github.fallout015.two.client.renderer.entity.BeardedDragonRenderer;
import io.github.fallout015.two.client.renderer.entity.BoatRendererTwo;
import io.github.fallout015.two.client.renderer.entity.BombArrowRenderer;
import io.github.fallout015.two.client.renderer.entity.CappedArrowRenderer;
import io.github.fallout015.two.client.renderer.entity.ChameleonRenderer;
import io.github.fallout015.two.client.renderer.entity.CrimpRenderer;
import io.github.fallout015.two.client.renderer.entity.DarkDwarfArcherRenderer;
import io.github.fallout015.two.client.renderer.entity.FireArrowRenderer;
import io.github.fallout015.two.client.renderer.entity.IceArrowRenderer;
import io.github.fallout015.two.client.renderer.entity.IceSlimeRenderer;
import io.github.fallout015.two.client.renderer.entity.MagmeelRenderer;
import io.github.fallout015.two.client.renderer.entity.MummifiedZombieRenderer;
import io.github.fallout015.two.client.renderer.entity.NetherFishRenderer;
import io.github.fallout015.two.client.renderer.entity.PenguinRenderer;
import io.github.fallout015.two.client.renderer.entity.RedPandaRenderer;
import io.github.fallout015.two.client.renderer.entity.ShockArrowRenderer;
import io.github.fallout015.two.client.renderer.entity.ShurikenRenderer;
import io.github.fallout015.two.client.renderer.entity.SigilRenderer;
import io.github.fallout015.two.client.renderer.entity.SwarmRenderer;
import io.github.fallout015.two.client.renderer.entity.TwisterRenderer;
import io.github.fallout015.two.client.renderer.entity.layers.BeardedDragonLayer;
import io.github.fallout015.two.client.renderer.entity.layers.ChameleonCloakLayer;
import io.github.fallout015.two.client.renderer.entity.layers.ChameleonLayer;
import io.github.fallout015.two.client.renderer.entity.layers.CrownLayer;
import io.github.fallout015.two.client.renderer.entity.layers.HeadphonesLayer;
import io.github.fallout015.two.client.renderer.entity.layers.InspectionSpectaclesLayer;
import io.github.fallout015.two.client.renderer.entity.layers.TopHatLayer;
import io.github.fallout015.two.client.renderer.tileentity.ChairRenderer;
import io.github.fallout015.two.common.capabilities.CapabilitiesTwo;
import io.github.fallout015.two.enchantment.AbilityEnchantment;
import io.github.fallout015.two.enchantment.EnchantmentsTwo;
import io.github.fallout015.two.entity.EntityTypeTwo;
import io.github.fallout015.two.entity.boss.magmeel.MagmeelEntity;
import io.github.fallout015.two.entity.monster.MummifiedZombieEntity;
import io.github.fallout015.two.entity.passive.BeardedDragonEntity;
import io.github.fallout015.two.entity.passive.ChameleonEntity;
import io.github.fallout015.two.entity.passive.CrimpEntity;
import io.github.fallout015.two.entity.passive.PenguinEntity;
import io.github.fallout015.two.entity.passive.RedPandaEntity;
import io.github.fallout015.two.fluid.FluidsTwo;
import io.github.fallout015.two.inventory.container.ContainerTypeTwo;
import io.github.fallout015.two.item.ArmorMaterialTwo;
import io.github.fallout015.two.item.ItemsTwo;
import io.github.fallout015.two.item.SlimeBootsItem;
import io.github.fallout015.two.particles.ParticleTypesTwo;
import io.github.fallout015.two.potion.EffectsTwo;
import io.github.fallout015.two.server.JumpPacketHandler;
import io.github.fallout015.two.server.PacketHandler;
import io.github.fallout015.two.stats.StatsTwo;
import io.github.fallout015.two.tileentity.TileEntityTypeTwo;
import io.github.fallout015.two.util.SoundEventsTwo;
import io.github.fallout015.two.world.gen.carver.WorldCarverTwo;
import io.github.fallout015.two.world.gen.feature.FeatureTwo;
import io.github.fallout015.two.world.gen.feature.FeaturesTwo;
import io.github.fallout015.two.world.gen.feature.structure.StructureTwo;
import io.github.fallout015.two.world.gen.placement.PlacementTwo;
import io.github.fallout015.two.world.gen.surfacebuilders.SurfaceBuilderTwo;
import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EvokerFangsRenderer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.INBT;
import net.minecraft.particles.ParticleType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.StatType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraft.world.gen.GenerationStage.Carving;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.SleepFinishedTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("two")
public class Two {
	public static class Config {
		public static final ClientConfig CLIENT;
		public static final ForgeConfigSpec CLIENT_SPEC;
		
		static {
			final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
			CLIENT_SPEC = specPair.getRight();
			CLIENT = specPair.getLeft();
		}
		
		public static boolean pamTextureBloodBlade = true;
		public static boolean disableStainedWoodenCrafting = false;
		public static boolean disableGlazedBricksCrafting = false;
		public static boolean disableAdditionalCaves = false;
		public static boolean disableModifiedCaves = false;
		public static boolean disableNewNetherOres = false;
		public static boolean disableNewOverworldOres = false;
		public static boolean disableNewEndOres = false;
		public static boolean renameVanillaItems = true;
		public static boolean disableDreamcatchersInVillages = false;
		public static boolean enableThrowingArrows = false;
		public static boolean disableDaggerSneakAttack = false;
		public static boolean bombArrowsObeyMobGriefing = false;
		public static boolean disableInspectionSpectacleDescriptions = false;
		public static boolean enablePickaxeTips = false;
		public static boolean disableTeleporterCrafting = false;
		public static boolean disableUndergroundRegions = false;
		public static boolean disableUndergroundBiomes = false;
		public static boolean disableAdobeFreezing = false;
		
		public static void bakeConfig() {
			pamTextureBloodBlade = CLIENT.PAM_TEXTURE_BLOOD_BLADE.get();
			disableInspectionSpectacleDescriptions = CLIENT.DISABLE_INSPECTION_SPECTACLES_DESCRIPTIONS.get();
			enablePickaxeTips = CLIENT.ENABLE_PICKAXE_TIPS.get();
			
			disableStainedWoodenCrafting = CLIENT.DISABLE_STAINED_WOODEN_CRAFTING.get();
			disableGlazedBricksCrafting = CLIENT.DISABLE_GLAZED_BRICK_CRAFTING.get();
			
			enableThrowingArrows = CLIENT.ENABLE_THROWING_ARROWS.get();
		}
		
		public static class ClientConfig {
			// Cosmetic
			public final BooleanValue PAM_TEXTURE_BLOOD_BLADE;
			public final BooleanValue DISABLE_INSPECTION_SPECTACLES_DESCRIPTIONS;
			public final BooleanValue ENABLE_PICKAXE_TIPS;
			// Crafting
			public final BooleanValue DISABLE_STAINED_WOODEN_CRAFTING;
			public final BooleanValue DISABLE_GLAZED_BRICK_CRAFTING;
//			public final BooleanValue disableTeleporterCrafting;
			// World Gen
//			public final BooleanValue disableAdditionalCaves;
//			public final BooleanValue disableModifiedCaves;
//			public final BooleanValue disableNewNetherOres;
//			public final BooleanValue disableNewOverworldOres;
//			public final BooleanValue disableNewEndOres;
//			public final BooleanValue disableUndergroundRegions;
//			public final BooleanValue disableUndergroundBiomes;
			// Vanilla Alterations
//			public final BooleanValue renameVanillaItems;
			// Structures
//			public final BooleanValue disableDreamcatchersInVillages;
			// Misc
			public final BooleanValue ENABLE_THROWING_ARROWS;
//			public final BooleanValue disableDaggerSneakAttack;
//			public final BooleanValue bombArrowsObeyMobGriefing;
//			public final BooleanValue disableAdobeFreezing;
			
			public ClientConfig(ForgeConfigSpec.Builder builder) {
				builder.push("Cosmetic");
				this.PAM_TEXTURE_BLOOD_BLADE = builder.comment("Use Pam's texture for the Blood Venom Blade.").translation("two.config.pamTextureBloodBlade").define("PAM_TEXTURE_BLOOD_BLADE", true);
				this.DISABLE_INSPECTION_SPECTACLES_DESCRIPTIONS = builder.comment("Disable the paragraph descriptions for items when wearing the Inspection Spectacles.").translation("two.config.disableInspectionSpectaclesDescriptions").define("DISABLE_INSPECTION_SPECTACLES_DESCRIPTIONS", false);
				this.ENABLE_PICKAXE_TIPS = builder.comment("Enable pickaxe tooltips for what ores you can mine.").translation("two.config.enablePickaxeTips").define("ENABLE_PICKAXE_TIPS", false);
				builder.pop();
				builder.push("Crafting");
				this.DISABLE_STAINED_WOODEN_CRAFTING = builder.comment("Disable the crafting recipes for everything related to Stained Wooden Planks. In case you have another mod that uses it.").translation("two.config.disableStainedWoodenCrafting").define("DISABLE_STAINED_WOODEN_CRAFTING", false);
				this.DISABLE_GLAZED_BRICK_CRAFTING = builder.comment("Disable the crafting recipes for everything related to Glazed Bricks. In case you have another mod that uses it.").translation("two.config.disableGlazedBricksCrafting").define("DISABLE_GLAZED_BRICKS_CRAFTING", false);
				builder.pop();
				builder.push("Misc");
				this.ENABLE_THROWING_ARROWS = builder.comment("Enable pressing Q to throw arrows like darts.").translation("two.config.enableThrowingArrows").define("ENABLE_THROWING_ARROWS", false);
				builder.pop();
//				builder.push("category");
//				this.anInt = builder.comment("anInt usage description").translation(Two.class.getAnnotation(Mod.class).value() + ".config." + "anInt").defineInRange("anInt", 10, 0, 100);
//				builder.pop();
			}
		}
	}
	
	// TODO PRESSURE PLATE, FENCE, STAIRS, BUTTON, SIGN, AND BOAT FOR STAINED PLANKS
	
	// GLAIVE
	// MACE
	// LONGBOW
	// ARBALEST
	
	// MATTOCK
	
	// PILLARS
	// FURNITURE
	
    public static final Logger LOGGER = LogManager.getLogger(Two.class.getAnnotation(Mod.class).value());
    
	public static AttributeModifier leveluphealth = new AttributeModifier(UUID.fromString("b27e893d-adfa-413d-be70-d1445dfdcf5f"), "level_up_health", 2, AttributeModifier.Operation.ADDITION);
    
	@SuppressWarnings("unused")
	private static final String[] BLACKLIST;
	
    public Two() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC);
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    static {
    	BLACKLIST = new String[] {
    		"Dev"
    	};
    }

	private void setup(final FMLCommonSetupEvent event) {
		PacketHandler.INSTANCE.registerMessage(JumpPacketHandler.JUMP_ID, JumpPacketHandler.class, JumpPacketHandler::encoder, JumpPacketHandler::decoder, JumpPacketHandler::handle);

//    	DeferredWorkQueue ? 
//    	DefaultBiomeFeaturesTwo.addFeatures();
//    	DefaultBiomeFeaturesTwo.addStructures();
//    	DefaultBiomeFeaturesTwo.addSpawns();
//    	DefaultBiomeFeaturesTwo.addCarvers();
    	
//    	try {
//    	} catch(NullPointerException npe) {
//    		npe.printStackTrace();
//    	}
		
		GlobalEntityTypeAttributes.put(EntityTypeTwo.CHAMELEON, ChameleonEntity.applyAttributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(EntityTypeTwo.BEARDED_DRAGON, BeardedDragonEntity.applyAttributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(EntityTypeTwo.RED_PANDA, RedPandaEntity.applyAttributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(EntityTypeTwo.CRIMP, CrimpEntity.applyAttributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(EntityTypeTwo.PENGUIN, PenguinEntity.applyAttributes().func_233813_a_());
		
		GlobalEntityTypeAttributes.put(EntityTypeTwo.DARK_DWARF_ARCHER, MonsterEntity.func_234295_eP_().func_233813_a_()); // TODO give own stats. 
		GlobalEntityTypeAttributes.put(EntityTypeTwo.MUMMIFIED_ZOMBIE, MummifiedZombieEntity.applyAttributes().func_233813_a_());
		GlobalEntityTypeAttributes.put(EntityTypeTwo.ICE_SLIME, MonsterEntity.func_234295_eP_().func_233813_a_()); // TODO give own stats.
		GlobalEntityTypeAttributes.put(EntityTypeTwo.NETHER_FISH, AbstractFishEntity.func_234176_m_().func_233813_a_()); // TODO give own stats.

		GlobalEntityTypeAttributes.put(EntityTypeTwo.MAGMEEL, MagmeelEntity.applyAttributes().func_233813_a_());
	}
	private void doClientStuff(final FMLClientSetupEvent event) {
//    	for(String name : BLACKLIST) {
//    		if(name.equals(event.getMinecraftSupplier().get().player.getName().getString())) {
//    			Assert.assrt("You are blacklisted!", false);
//    		}
//    	} // TODO blacklist code
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.CHAMELEON, ChameleonRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.BEARDED_DRAGON, BeardedDragonRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.RED_PANDA, RedPandaRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.CRIMP, CrimpRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.PENGUIN, PenguinRenderer::new);
    	
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
    	
    	//    	RenderingRegistry.registerEntityRenderingHandler(EntityType.WOLF, WolfRendererTwo::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.SIGIL, SigilRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.TWISTER, TwisterRenderer::new);
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.SWARM, SwarmRenderer::new);
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.MAGMEEL, MagmeelRenderer::new);
    	
    	ClientRegistry.bindTileEntityRenderer(TileEntityTypeTwo.CHAIR, ChairRenderer::new);
    	
    	RenderTypeLookupTwo.setRenderLayers();

    	CapabilitiesTwo.register();
    	
    	try {
    		Two.LOGGER.info("Adding compostables. Making Composter$registerCompostable accessible.");
    		Method registerCompostable = ComposterBlock.class.getDeclaredMethod("registerCompostable", float.class, IItemProvider.class);
        	registerCompostable.setAccessible(true);
        	registerCompostable.invoke(null, 0.3f, ItemsTwo.MELON_RIND);
        	registerCompostable.invoke(null, 0.5f, ItemsTwo.APPLE_CORE);
        	registerCompostable.invoke(null, 0.5f, ItemsTwo.BEETROOT_STEMS);
        	registerCompostable.invoke(null, 0.5f, ItemsTwo.CARROT_STEM);
        	registerCompostable.setAccessible(false); // safety cause why not
        	Two.LOGGER.info("Composter$registerCompostable is private again.");
    	} catch (Exception exception) { LOGGER.warn(exception); }

    	try {
    		Two.LOGGER.info("Running Two$clientOnly, will throw a NoSuchMethod error on a dedicated server.");
    		clientOnly();
    	} catch(NoSuchMethodError e) { Two.LOGGER.error(e + " this is SUPPOSED to happen!"); }
    }
    private void enqueueIMC(final InterModEnqueueEvent event) {}
    private void processIMC(final InterModProcessEvent event) {}
    @OnlyIn(Dist.CLIENT)
    private static void clientOnly() {
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("default").addLayer(new TopHatLayer(Minecraft.getInstance().getRenderManager().getSkinMap().get("default")));
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("slim").addLayer(new TopHatLayer(Minecraft.getInstance().getRenderManager().getSkinMap().get("slim")));

    	Minecraft.getInstance().getRenderManager().getSkinMap().get("default").addLayer(new InspectionSpectaclesLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("default")));
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("slim").addLayer(new InspectionSpectaclesLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("slim")));

    	Minecraft.getInstance().getRenderManager().getSkinMap().get("default").addLayer(new ChameleonLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("default")));
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("slim").addLayer(new ChameleonLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("slim")));

    	Minecraft.getInstance().getRenderManager().getSkinMap().get("default").addLayer(new BeardedDragonLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("default")));
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("slim").addLayer(new BeardedDragonLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("slim")));

    	Minecraft.getInstance().getRenderManager().getSkinMap().get("default").addLayer(new ChameleonCloakLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("default")));
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("slim").addLayer(new ChameleonCloakLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("slim")));

    	// Derek's cosmetic headphones
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("default").addLayer(new HeadphonesLayer(Minecraft.getInstance().getRenderManager().getSkinMap().get("default")));
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("slim").addLayer(new HeadphonesLayer(Minecraft.getInstance().getRenderManager().getSkinMap().get("slim")));

    	// Karsten's cosmetic crown
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("default").addLayer(new CrownLayer(Minecraft.getInstance().getRenderManager().getSkinMap().get("default")));
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("slim").addLayer(new CrownLayer(Minecraft.getInstance().getRenderManager().getSkinMap().get("slim")));
    
    	// Nick's cosmetic gauntlet, one for default and one for slim
    	// Hanna's cosmetic cat ears
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {}
    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent event) {
    	if(event.getConfig().getSpec() == Config.CLIENT_SPEC) {
    		Config.bakeConfig();
    	}
    }
    
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SuppressWarnings("resource")
        @SubscribeEvent
        public static void onParticleFactoryRegistry(final ParticleFactoryRegisterEvent event) {
    		Minecraft.getInstance().particles.registerFactory(ParticleTypesTwo.FROST, FrostParticle.Factory::new);
    		Minecraft.getInstance().particles.registerFactory(ParticleTypesTwo.SPARK, SparkParticle.Factory::new);
    		Minecraft.getInstance().particles.registerFactory(ParticleTypesTwo.TWINKLE, TwinkleParticle.Factory::new);
        }
    	
    	@SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
    		BlocksTwo.onBlocksRegistry(blockRegistryEvent);
        }
    	@SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
    		ItemsTwo.onItemsRegistry(itemRegistryEvent);
        }
    	@SubscribeEvent
    	public static void onBiomesRegistry(final RegistryEvent.Register<Biome> biomeRegistryEvent) {
//    		BiomesTwo.onBiomesRegistry(biomeRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onContainerTypesRegistry(final RegistryEvent.Register<ContainerType<?>> containerTypeRegistryEvent) {
    		ContainerTypeTwo.onContainerTypesRegistry(containerTypeRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onEffectsRegistry(final RegistryEvent.Register<Effect> effectRegistryEvent) {
    		EffectsTwo.onEffectsRegistry(effectRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onEnchantmentsRegistry(final RegistryEvent.Register<Enchantment> enchantmentRegistryEvent) {
    		EnchantmentsTwo.onEnchantmentsRegistry(enchantmentRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onEntityTypesRegistry(final RegistryEvent.Register<EntityType<?>> entityTypeRegistryEvent) {
    		EntityTypeTwo.onEntityTypesRegistry(entityTypeRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onFeaturesRegistry(final RegistryEvent.Register<Feature<?>> featureRegistryEvent) {
    		FeatureTwo.onFeaturesRegistry(featureRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onFluidsRegistry(final RegistryEvent.Register<Fluid> fluidRegistryEvent) {
    		FluidsTwo.onFluidsRegistry(fluidRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onGlobalLootModifierSerializersRegistry(final RegistryEvent.Register<GlobalLootModifierSerializer<?>> globalLootModifierSerializerRegistryEvent) {
    		// loot stuff
//    		LootTables.CHESTS_SIMPLE_DUNGEON.
    	}
    	@SubscribeEvent
    	public static void onParticleTypesRegistry(final RegistryEvent.Register<ParticleType<?>> particleTypeRegistryEvent) {
    		ParticleTypesTwo.onParticleTypesRegistry(particleTypeRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onPlacementsRegistry(final RegistryEvent.Register<Placement<?>> placementRegistryEvent) {
    		PlacementTwo.onPlacementsRegistry(placementRegistryEvent);
    	}
    	@SubscribeEvent
        public static void onSoundEventsRegistry(final RegistryEvent.Register<SoundEvent> soundEventRegistryEvent) {
        	SoundEventsTwo.onSoundEventsRegistry(soundEventRegistryEvent);
        }
    	@SubscribeEvent
    	public static void onStatTypesRegistry(final RegistryEvent.Register<StatType<?>> statTypeRegistry) {
    		StatsTwo.onStatTypesRegistry(statTypeRegistry);
    	}
    	@SubscribeEvent
    	public static void onStructuresRegistry(final RegistryEvent.Register<Structure<?>> structureRegistry) {
    		StructureTwo.onStructuresRegistry(structureRegistry);
    	}
    	@SubscribeEvent
    	public static void onSurfaceBuildersRegistry(final RegistryEvent.Register<SurfaceBuilder<?>> surfaceBuilderRegistryEvent) {
    		SurfaceBuilderTwo.onSurfaceBuildersRegistry(surfaceBuilderRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onTileEntitiesRegistry(final RegistryEvent.Register<TileEntityType<?>> tileEntityRegistryEvent) {
    		TileEntityTypeTwo.onTileEntitiesRegistry(tileEntityRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onVillagerProfessionsRegistry(final RegistryEvent.Register<VillagerProfession> villagerProfessionRegistryEvent) {
    		// tailor and carpenter for now
    	}
    	@SubscribeEvent
    	public static void onWorldCarversRegistry(final RegistryEvent.Register<WorldCarver<?>> worldCarverRegistryEvent) {
    		WorldCarverTwo.onWorldCarversRegistry(worldCarverRegistryEvent);
    	}
    }
    
    @Mod.EventBusSubscriber
    public static class Events {
    	@SubscribeEvent
    	public static void onBiomeLoad(final BiomeLoadingEvent biomeLoadingEvent) {
    		if(biomeLoadingEvent.getCategory() == Category.NETHER) {
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_NETHER_AMETHYST);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_NETHER_GARNET);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_NETHER_LEAD);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_NETHER_TITANIUM);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_NETHER_TOPAZ);
    		} else if(biomeLoadingEvent.getCategory() == Category.THEEND) {
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_END_COBALT);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_END_JADE);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_END_PLATINUM);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_END_SAPPHIRE);
    		} else {
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_ALUMINUM);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_COPPER);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_OPAL);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_PYRITE);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_RUBY);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_SILVER);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_TALC);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_TIN);
    			if(biomeLoadingEvent.getName() == Biomes.SAVANNA.getRegistryName() || biomeLoadingEvent.getName() == Biomes.SAVANNA_PLATEAU.getRegistryName() || biomeLoadingEvent.getName() == Biomes.SHATTERED_SAVANNA.getRegistryName() || biomeLoadingEvent.getName() == Biomes.SHATTERED_SAVANNA_PLATEAU.getRegistryName()) {
        			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_TANZANITE);
    			}
    		}
    		if(biomeLoadingEvent.getCategory() == Category.ICY) {
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).clear();
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.RAW_GENERATION).add(() -> FeaturesTwo.ICY_STONE_REPLACER);

    			biomeLoadingEvent.getSpawns().getSpawner(EntityClassification.CREATURE).add(new Spawners(EntityTypeTwo.PENGUIN, 10, 3, 5));

    			biomeLoadingEvent.getSpawns().getSpawner(EntityClassification.MONSTER).add(new Spawners(EntityTypeTwo.ICE_SLIME, 10, 1, 3));
    		} else if(biomeLoadingEvent.getCategory() == Category.SAVANNA) {
    			biomeLoadingEvent.getSpawns().getSpawner(EntityClassification.CREATURE).add(new Spawners(EntityTypeTwo.BEARDED_DRAGON, 12, 2, 4));
    		} else if(biomeLoadingEvent.getCategory() == Category.DESERT) {
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).clear();
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.RAW_GENERATION).add(() -> FeaturesTwo.DESERT_STONE_REPLACER);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_DESERT_COAL);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_DESERT_COPPER);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_DESERT_GOLD);
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_DESERT_IRON);
    			
//    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Feature.SIMPLE_BLOCK.withConfiguration(FeaturesTwo.Configs.SUCCULIGHT_CONFIG).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(1, 8, 32, 64))));
    			
    			biomeLoadingEvent.getSpawns().getSpawner(EntityClassification.CREATURE).add(new Spawners(EntityTypeTwo.CHAMELEON, 10, 1, 2));

    			biomeLoadingEvent.getSpawns().getSpawner(EntityClassification.MONSTER).add(new Spawners(EntityTypeTwo.MUMMIFIED_ZOMBIE, 7, 1, 2));
    		} else if(biomeLoadingEvent.getCategory() == Category.JUNGLE) {
    			biomeLoadingEvent.getSpawns().getSpawner(EntityClassification.CREATURE).add(new Spawners(EntityTypeTwo.CHAMELEON, 12, 2, 4));
    		} else if(biomeLoadingEvent.getCategory() == Category.MESA) {
//    			biomeLoadingEvent.getGeneration().getStructures().add(() -> StructureTwo.);
    		} else if(biomeLoadingEvent.getCategory() == Category.MUSHROOM) {
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).clear();
    			biomeLoadingEvent.getGeneration().getFeatures(Decoration.RAW_GENERATION).add(() -> FeaturesTwo.MUSHROOM_STONE_REPLACER);
    		}
    		
    		biomeLoadingEvent.getGeneration().getCarvers(Carving.AIR).add(() -> new ConfiguredCarver<>(WorldCarverTwo.CAVERN, new ProbabilityConfig(0.01285715F)));
    		biomeLoadingEvent.getGeneration().getCarvers(Carving.AIR).add(() -> new ConfiguredCarver<>(WorldCarverTwo.WIDE_CAVE, new ProbabilityConfig(0.07285715F)));
    		
//    		Biomes.DESERT.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureTwo.REPLACE_BLOCK.withConfiguration(new ReplaceBlockConfig(Blocks.SMOOTH_SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState())).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(256))));
//    		Biomes.DESERT_HILLS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureTwo.REPLACE_BLOCK.withConfiguration(new ReplaceBlockConfig(Blocks.SMOOTH_SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState())).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(256))));
//    		Biomes.DESERT_LAKES.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureTwo.REPLACE_BLOCK.withConfiguration(new ReplaceBlockConfig(Blocks.SMOOTH_SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState())).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(256))));
    		
    		// add biome seams
    		
    		// unrelated : for desert biomes add more vegetation and add dunes, with very little vegetation
    		// also sandstorms
    		
//    		Biomes.DESERT.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(SUCCULIGHT_CONFIG).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(1, 8, 32, 64))));
//    		Biomes.DESERT_HILLS.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(SUCCULIGHT_CONFIG).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(1, 8, 32, 64))));
//    		Biomes.DESERT_LAKES.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(SUCCULIGHT_CONFIG).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(1, 8, 32, 64))));

    		
    		
//    		Biomes.MUSHROOM_FIELD_SHORE.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(NEONDOT_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(7))));
//    		Biomes.MUSHROOM_FIELDS.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(NEONDOT_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(8))));
//    		
//    		Biomes.MUSHROOM_FIELD_SHORE.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(BRIMSHINE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(7))));
//    		Biomes.MUSHROOM_FIELDS.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(BRIMSHINE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(8))));
    	
    	
//    		Biomes.MUSHROOM_FIELD_SHORE.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureTwo.HUGE_NEONDOT.withConfiguration(BIG_NEONDOT).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 32, 32))));
//    		Biomes.MUSHROOM_FIELDS.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureTwo.HUGE_NEONDOT.withConfiguration(BIG_NEONDOT).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 32, 32))));
    //
//    		Biomes.MUSHROOM_FIELD_SHORE.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureTwo.HUGE_BRIMSHINE.withConfiguration(BIG_BRIMSHINE).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 32, 32))));
//    		Biomes.MUSHROOM_FIELDS.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureTwo.HUGE_BRIMSHINE.withConfiguration(BIG_BRIMSHINE).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 32, 32))));
    	
    		// TODO
    	}
    	@SubscribeEvent
    	public static void onItemToss(final ItemTossEvent itemTossEvent) {
    		if(Config.enableThrowingArrows && itemTossEvent.getEntityItem().getItem().getItem() instanceof ArrowItem && !itemTossEvent.getPlayer().getEntityWorld().isRemote) {
    			AbstractArrowEntity abstractarrowentity = ((ArrowItem) itemTossEvent.getEntityItem().getItem().getItem()).createArrow(itemTossEvent.getEntityItem().getEntityWorld(), itemTossEvent.getEntityItem().getItem(), itemTossEvent.getPlayer());
//                abstractarrowentity.shoot(itemTossEvent.getPlayer(), itemTossEvent.getPlayer().rotationPitch, itemTossEvent.getPlayer().rotationYaw, 0.0F, 0.9F, 2.0F);
                itemTossEvent.getPlayer().getEntityWorld().addEntity(abstractarrowentity);
                itemTossEvent.setCanceled(true);
                // TODO Keep? Remove? I personally don't like this. And adding an extra item with a drop action sounds weird. 
                // Also TODO add item back to inventory in creative after it's cancelled, and add back shooting. 
    		}
    	}
    	@SubscribeEvent
    	public static void onLivingEquipmentChange(final LivingEquipmentChangeEvent livingEquipmentChangeEvent) {
    		if(livingEquipmentChangeEvent.getEntityLiving() instanceof PlayerEntity && livingEquipmentChangeEvent.getSlot().getSlotType().equals(EquipmentSlotType.Group.ARMOR)) {
    			List<ItemStack> list = new LinkedList<ItemStack>();
    			livingEquipmentChangeEvent.getEntityLiving().getArmorInventoryList().forEach(list::add);
    			if(livingEquipmentChangeEvent.getTo().getItem() instanceof ArmorItem && list.stream().allMatch(itemstack -> {
    				return (itemstack.getItem() instanceof ArmorItem) && ((ArmorItem) itemstack.getItem()).getArmorMaterial() == ((ArmorItem) livingEquipmentChangeEvent.getTo().getItem()).getArmorMaterial();
    			})) {
    				if(((ArmorItem) livingEquipmentChangeEvent.getTo().getItem()).getArmorMaterial() == ArmorMaterialTwo.OBSIDIAN) {
    					livingEquipmentChangeEvent.getEntityLiving().addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 50, 3, false, true));
    				}
    				
    				/*
    				 * obsidian -> total fire resistance
    				 * woolen -> padding
    				 * sponge -> squishy swiftness
    				 * glowstone -> dazzling
    				 */
    			}
    		}
    	}
		@SubscribeEvent
    	public static void onPlayerWakeUp(final PlayerWakeUpEvent playerWakeUpEvent) {
			boolean isOverworld = playerWakeUpEvent.getPlayer().getEntityWorld().func_234923_W_() == World.field_234918_g_;
			boolean hasDreamcatcher = playerWakeUpEvent.getPlayer().getEntityWorld().getBlockState(playerWakeUpEvent.getPlayer().getBedPosition().get().up()).getBlock() instanceof DreamcatcherBlock;
			boolean successfulSleep = playerWakeUpEvent.getPlayer().getEntityWorld().getDayTime() == 24000;
			if(successfulSleep && isOverworld && hasDreamcatcher) {
				((DreamcatcherBlock) playerWakeUpEvent.getPlayer().getEntityWorld().getBlockState(playerWakeUpEvent.getPlayer().getBedPosition().get().up()).getBlock()).onPlayerWakeUp(playerWakeUpEvent);
			}
    	}
		@SubscribeEvent
		public static void onSleepFinishedTime(final SleepFinishedTimeEvent sleepFinishedTimeEvent) {
//			((DreamcatcherBlock) sleepFinishedTimeEvent.getPlayer().getEntityWorld().getBlockState(playerWakeUpEvent.getPlayer().getBedLocation(DimensionType.OVERWORLD).up()).getBlock()).onPlayerWakeUp(playerWakeUpEvent);
		}
    	@SubscribeEvent
    	public static void onPlayerSleepInBed(final PlayerSleepInBedEvent playerSleepInBedEvent) {
//    		if(playerSleepInBedEvent.getPlayer().dimension.equals(DimensionManager.registerOrGetDimension(new ResourceLocation("two", "nightmare"), ModDimensionTwo.NIGHTMARE, null, false))) {
//    			playerSleepInBedEvent.getPlayer().changeDimension(DimensionType.OVERWORLD, new ITeleporter() {
//    				public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
//    					return repositionEntity.apply(false);
//    				}
//    			});
//    			playerSleepInBedEvent.getPlayer().getEntityWorld().setDayTime(24000);
//    		}
    	}
    	@SubscribeEvent
    	public static void onItemCrafted(final PlayerEvent.ItemCraftedEvent playerEvent$ItemCraftedEvent) {
    		if(playerEvent$ItemCraftedEvent.getCrafting().getItem() == Items.CAKE) {
    			if(playerEvent$ItemCraftedEvent.getCrafting().hasTag()) {
    				playerEvent$ItemCraftedEvent.getCrafting().getTag().putInt("slices", 8);
    				Two.LOGGER.info("cake HAS tag");
    			} else {
    				CompoundNBT nbt = new CompoundNBT();
    				nbt.putInt("slices", 8);
    				playerEvent$ItemCraftedEvent.getCrafting().setTag(nbt);
    				Two.LOGGER.info("cake has NO tag");
    			}
    		}
    	} // TODO this doesn't cover cake magically appearing in chests...
    	@SubscribeEvent
    	public static void onEntityJoinWorld(final EntityJoinWorldEvent entityJoinWorldEvent) {
    		if(entityJoinWorldEvent.getEntity() instanceof SpiderEntity) {
    			((SpiderEntity) entityJoinWorldEvent.getEntity()).goalSelector.addGoal(3, new AvoidEntityGoal<ChameleonEntity>((CreatureEntity) entityJoinWorldEvent.getEntity(), ChameleonEntity.class, 6.0f, 1.2D, 1.4D));
    		} else if(entityJoinWorldEvent.getEntity() instanceof CaveSpiderEntity) {
    			((CaveSpiderEntity) entityJoinWorldEvent.getEntity()).goalSelector.addGoal(3, new AvoidEntityGoal<ChameleonEntity>((CreatureEntity) entityJoinWorldEvent.getEntity(), ChameleonEntity.class, 6.0f, 1.2D, 1.4D));
    		} else if(entityJoinWorldEvent.getEntity() instanceof SilverfishEntity) {
    			((SilverfishEntity) entityJoinWorldEvent.getEntity()).goalSelector.addGoal(1, new AvoidEntityGoal<ChameleonEntity>((CreatureEntity) entityJoinWorldEvent.getEntity(), ChameleonEntity.class, 6.0f, 0.5D, 0.7D));
    		} else if(entityJoinWorldEvent.getEntity() instanceof EndermiteEntity) {
    			((EndermiteEntity) entityJoinWorldEvent.getEntity()).goalSelector.addGoal(1, new AvoidEntityGoal<ChameleonEntity>((CreatureEntity) entityJoinWorldEvent.getEntity(), ChameleonEntity.class, 6.0f, 0.5D, 0.7D));
    		} else if(entityJoinWorldEvent.getEntity() instanceof BeeEntity) {
    			((BeeEntity) entityJoinWorldEvent.getEntity()).goalSelector.addGoal(3, new AvoidEntityGoal<ChameleonEntity>((CreatureEntity) entityJoinWorldEvent.getEntity(), ChameleonEntity.class, 6.0f, 0.6D, 0.8D));
    		}
    	}
    	@SubscribeEvent
    	public static void onLivingJump(final LivingJumpEvent livingJumpEvent) {
    		if(livingJumpEvent.getEntityLiving().getActivePotionEffect(EffectsTwo.FROSTY) != null) {
    			livingJumpEvent.getEntityLiving().setJumping(false);
    			livingJumpEvent.getEntityLiving().setMotion(Vector3d.ZERO);
    			return;
    		}
//        		if(list.getFirst().getItem() == ItemsTwo.DOUBLE_JUMP_BOOTS) {
////        			LOGGER.info("Boots!");
////        			LOGGER.info("Jumps: " + list.getFirst().getTag().getInt("jumps"));
////        			LOGGER.info("Extra Jump Limit: " + list.getFirst().getTag().getInt("extrajumplimit"));
//        			if(list.getFirst().getTag().getInt("jumps") < list.getFirst().getTag().getInt("extrajumplimit")) {
////        				LOGGER.info("Allowed jump limit!");
//        				if(p.isAirBorne) {
////        					LOGGER.info("Airborne!");
////        					p.jump();
//        					list.getFirst().getTag().putInt("jumps", list.getFirst().getTag().getInt("jumps") + 1);
//        				}
//        			}
//        		}
    	}
    	@SubscribeEvent
    	public static void onKeyInput(final InputEvent.KeyInputEvent inputEvent$KeyInputEvent) {
    		if(inputEvent$KeyInputEvent.getKey() == GLFW.GLFW_KEY_SPACE && inputEvent$KeyInputEvent.getAction() == GLFW.GLFW_PRESS) {
        		PacketHandler.INSTANCE.sendToServer(new JumpPacketHandler());
        		Two.LOGGER.info("Sending jump packet to server");
    		}
    	}
    	@SubscribeEvent
    	public static void onLivingFall(final LivingFallEvent livingFallEvent) {
    		if(livingFallEvent.getEntityLiving() instanceof PlayerEntity) {
//    			LOGGER.info("Player Fall!");
    			PlayerEntity p = (PlayerEntity) livingFallEvent.getEntityLiving();
        		LinkedList<ItemStack> list = new LinkedList<ItemStack>();
        		livingFallEvent.getEntityLiving().getArmorInventoryList().forEach(list::add);
//        		LOGGER.info(list);
        		if(list.getFirst().getItem() == ItemsTwo.SLIME_BOOTS) {
        			int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentsTwo.REBOUND, list.getFirst());
        			if(level > 0) {
            			SlimeBootsItem.bounce(livingFallEvent.getEntityLiving(), level);
        			}
        		}
        		if(list.getFirst().getItem() == ItemsTwo.DOUBLE_JUMP_BOOTS) {
//        			LOGGER.info("Boots!");
        			if(p.func_233570_aj_()) {
//        				LOGGER.info("Grounded!");
        				list.getFirst().getTag().putInt("jumps", 0);
        			}
        		}
    		}
    	}
    	@SubscribeEvent
    	public static void onLevelChange(final PlayerXpEvent.LevelChange playerXpEvent$LevelChange) {
    		// Later on when there are choices for leveling up this will be in an if statement. 
    		
    		INBT nbt = CapabilitiesTwo.PLAYERUPGRADES.writeNBT(CapabilitiesTwo.PLAYERUPGRADES.getDefaultInstance(), Direction.UP);
       		
       		((CompoundNBT) nbt).putDouble("health", ((CompoundNBT) nbt).getDouble("health") + playerXpEvent$LevelChange.getLevels());
       		((CompoundNBT) nbt).putDouble("hunger", ((CompoundNBT) nbt).getDouble("hunger") + playerXpEvent$LevelChange.getLevels());
       		((CompoundNBT) nbt).putDouble("armor", ((CompoundNBT) nbt).getDouble("armor") + playerXpEvent$LevelChange.getLevels());
       		((CompoundNBT) nbt).putDouble("breathing", ((CompoundNBT) nbt).getDouble("breathing") + playerXpEvent$LevelChange.getLevels());

    		CapabilitiesTwo.PLAYERUPGRADES.readNBT(CapabilitiesTwo.PLAYERUPGRADES.getDefaultInstance(), Direction.UP, nbt);

    		Two.LOGGER.info("instance double health: " + CapabilitiesTwo.PLAYERUPGRADES.getDefaultInstance().getHealth());
    		
    		leveluphealth = new AttributeModifier(UUID.fromString("b27e893d-adfa-413d-be70-d1445dfdcf5f"), "level_up_health", CapabilitiesTwo.PLAYERUPGRADES.getDefaultInstance().getHealth(), AttributeModifier.Operation.ADDITION);
    		float health = playerXpEvent$LevelChange.getPlayer().getHealth();
    		if(playerXpEvent$LevelChange.getPlayer().getAttribute(Attributes.field_233818_a_).hasModifier(leveluphealth)) {
        		playerXpEvent$LevelChange.getPlayer().getAttribute(Attributes.field_233818_a_).removeModifier(leveluphealth);
    		}
    		playerXpEvent$LevelChange.getPlayer().getAttribute(Attributes.field_233818_a_).func_233767_b_(leveluphealth);
    		playerXpEvent$LevelChange.getPlayer().setHealth(health);
    	}
    	@SubscribeEvent
    	public static void onPlayerClone(final PlayerEvent.Clone playerEvent$Clone) {
    		if(playerEvent$Clone.isWasDeath()) {
    			try {
    				INBT nbt = CapabilitiesTwo.PLAYERUPGRADES.writeNBT(CapabilitiesTwo.PLAYERUPGRADES.getDefaultInstance(), Direction.UP);
               		
            		((CompoundNBT) nbt).putDouble("health", 0);
               		((CompoundNBT) nbt).putDouble("hunger", 0);
               		((CompoundNBT) nbt).putDouble("armor", 0);
               		((CompoundNBT) nbt).putDouble("breathing", 0);
            		
               		CapabilitiesTwo.PLAYERUPGRADES.readNBT(CapabilitiesTwo.PLAYERUPGRADES.getDefaultInstance(), Direction.UP, nbt);
        		
            		leveluphealth = new AttributeModifier(UUID.fromString("b27e893d-adfa-413d-be70-d1445dfdcf5f"), "level_up_health", 0, AttributeModifier.Operation.ADDITION);
            		if(playerEvent$Clone.getPlayer().getAttribute(Attributes.field_233818_a_).hasModifier(leveluphealth)) {
            			playerEvent$Clone.getPlayer().getAttribute(Attributes.field_233818_a_).removeModifier(leveluphealth);
            		}
            		playerEvent$Clone.getPlayer().getAttribute(Attributes.field_233818_a_).func_233767_b_(leveluphealth);
    			} catch(NullPointerException npe) {
    				LOGGER.warn(npe);
    			}
    		}
    	}
    	@SubscribeEvent
    	public static void onFinish(final LivingEntityUseItemEvent.Finish livingEntityUseItemEvent$Finish) {
    		if(livingEntityUseItemEvent$Finish.getItem().isFood() && livingEntityUseItemEvent$Finish.getEntityLiving() instanceof PlayerEntity && !((PlayerEntity) livingEntityUseItemEvent$Finish.getEntityLiving()).isCreative()) {
    			if(ItemsTwo.Holder.FOOD_TO_SCRAPS.containsKey(livingEntityUseItemEvent$Finish.getItem().getItem())) {
    				
    				ItemStack result = new ItemStack(ItemsTwo.Holder.FOOD_TO_SCRAPS.get(livingEntityUseItemEvent$Finish.getItem().getItem()));

    				if(livingEntityUseItemEvent$Finish.getEntityLiving().getHeldItem(livingEntityUseItemEvent$Finish.getEntityLiving().getActiveHand()) == ItemStack.EMPTY && livingEntityUseItemEvent$Finish.getEntityLiving() instanceof PlayerEntity && !(((PlayerEntity) livingEntityUseItemEvent$Finish.getEntityLiving()).inventory.hasAny(Sets.newHashSet(result.getItem())))) {
    					livingEntityUseItemEvent$Finish.setResultStack(result);
    				} else {
        				livingEntityUseItemEvent$Finish.getEntityLiving().getEntityWorld().addEntity(new ItemEntity(livingEntityUseItemEvent$Finish.getEntityLiving().getEntityWorld(), livingEntityUseItemEvent$Finish.getEntityLiving().getPosX(), livingEntityUseItemEvent$Finish.getEntityLiving().getPosY(), livingEntityUseItemEvent$Finish.getEntityLiving().getPosZ(), result));
    				}
    				
    				// TODO
    				// Make it so food scraps can be fed to animals. 
    				// Food recipes for each new scrap.
    				// Put the scrap in your hand if it can.
    			}
    		}
    	}
    	@SubscribeEvent
    	public static void onRightClickItem(final PlayerInteractEvent.RightClickItem playerInteractEvent$rightClickItem) {
    		if(playerInteractEvent$rightClickItem.getPlayer().isSneaking()) {
    			EnchantmentHelper.getEnchantments(playerInteractEvent$rightClickItem.getItemStack()).forEach((key, value) -> {
        			if(key instanceof AbilityEnchantment) {
        				((AbilityEnchantment) key).action(playerInteractEvent$rightClickItem);
        				playerInteractEvent$rightClickItem.getPlayer().getCooldownTracker().setCooldown(playerInteractEvent$rightClickItem.getItemStack().getItem(), 10);
        				playerInteractEvent$rightClickItem.getPlayer().getHeldItem(playerInteractEvent$rightClickItem.getHand()).damageItem(20, playerInteractEvent$rightClickItem.getPlayer(), playerEntity -> playerEntity.sendBreakAnimation(playerInteractEvent$rightClickItem.getHand() == Hand.MAIN_HAND ? EquipmentSlotType.MAINHAND : EquipmentSlotType.OFFHAND));
        				playerInteractEvent$rightClickItem.getPlayer().swingArm(playerInteractEvent$rightClickItem.getHand());
        			}
        		});
    		}
    		if(playerInteractEvent$rightClickItem.getItemStack().getItem() == Items.ENDER_EYE) {
    			if(playerInteractEvent$rightClickItem.getItemStack().hasTag()) {
    				if(playerInteractEvent$rightClickItem.getItemStack().getTag().contains("pos")) {
    					BlockPos pos = BlockPos.fromLong(playerInteractEvent$rightClickItem.getItemStack().getTag().getLong("pos"));
    					float x = pos.getX();
    					float y = pos.getY();
    					float z = pos.getZ();
    					playerInteractEvent$rightClickItem.getPlayer().attemptTeleport(x, y, z, true);
    					// TODO try true in attemptTeleport
//    					playerInteractEvent$rightClickItem.getPlayer().setPosition(x, y, z);
    				}
    			}
    		}
    	}
    	@SubscribeEvent
    	public static void onLoadFromFile(final PlayerEvent.LoadFromFile playerEvent$LoadFromFile) {
    		if(playerEvent$LoadFromFile.getPlayerDirectory().canRead()) {
    			File fileIn = new File(playerEvent$LoadFromFile.getPlayerDirectory().getPath() + "/two_playerdata.nbt");
    			try {
					CapabilitiesTwo.PLAYERUPGRADES.readNBT(CapabilitiesTwo.PLAYERUPGRADES.getDefaultInstance(), Direction.UP, CompressedStreamTools.read(fileIn));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					Two.LOGGER.warn(e);
				}
    			LOGGER.info("Read from two_playerdata.nbt");
    		}
    	}
    	@SubscribeEvent
    	public static void onSaveToFile(final PlayerEvent.SaveToFile playerEvent$SaveToFile) {
    		if(playerEvent$SaveToFile.getPlayerDirectory().canWrite()) {
    			File fileIn = new File(playerEvent$SaveToFile.getPlayerDirectory().getPath() + "/two_playerdata.nbt");
    			CompoundNBT compound = (CompoundNBT) CapabilitiesTwo.PLAYERUPGRADES.writeNBT(CapabilitiesTwo.PLAYERUPGRADES.getDefaultInstance(), Direction.UP);
    			try {
					CompressedStreamTools.write(compound, fileIn);
    				fileIn.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
    			LOGGER.info("Wrote to two_playerdata.nbt");
    		}
    	}
    	@SubscribeEvent
    	@OnlyIn(Dist.CLIENT)
    	public static void onItemTooltip(final ItemTooltipEvent itemTooltipEvent) {
//    		// Pickaxes show all of the ores they can mine. 
////    		if(itemTooltipEvent.getItemStack().getItem() instanceof PickaxeItem) {
////    			if(((PickaxeItem) itemTooltipEvent.getItemStack().getItem()).getTier().getHarvestLevel() == 6)
////    				itemTooltipEvent.getToolTip().add(new StringTextComponent("Can mine everything."));
////    			else {
////    				List<IItemTier> itemTiers = new LinkedList<IItemTier>();
////    				
////        			for(IItemTier itemTier : ItemTier.values())
////        				if(itemTier != ItemTier.WOOD && ((PickaxeItem) itemTooltipEvent.getItemStack().getItem()).getTier().getHarvestLevel() > itemTier.getHarvestLevel() - 1)
////        					itemTiers.add(itemTier);
////        			for(IItemTier itemTier : ItemTierTwo.values())
////        				if(itemTier != ItemTierTwo.BLOOD_BLADE && ((PickaxeItem) itemTooltipEvent.getItemStack().getItem()).getTier().getHarvestLevel() > itemTier.getHarvestLevel() - 1)
////        					itemTiers.add(itemTier);
////        			
////        			Collections.sort((List<IItemTier>) itemTiers, (itemTier1, itemTier2) -> itemTier1.getHarvestLevel() - itemTier2.getHarvestLevel());
////        			
////        			itemTooltipEvent.getToolTip().add(new StringTextComponent("Can mine...").applyTextStyle(TextFormatting.GRAY));        			
////        			itemTooltipEvent.getToolTip().add(new StringTextComponent(itemTiers.toString().toLowerCase()/*.replaceAll("[", "").replaceAll("]", "")*/).applyTextStyle(TextFormatting.GRAY));
////    			}
////    		}
    		if(itemTooltipEvent.getItemStack().getItem() == ItemsTwo.CHAIR) {
    			String seat = "";
    			try {
        			seat = itemTooltipEvent.getItemStack().getTag().getString("top");
    			} catch(Exception e) {
    				Two.LOGGER.info(e);
    			}
    			String legs = "";
    			try {
    				legs = itemTooltipEvent.getItemStack().getTag().getString("middle");
    			} catch(Exception e) {
    				Two.LOGGER.info(e);
    			}
    			String back = "";
    			try {
    				back = itemTooltipEvent.getItemStack().getTag().getString("bottom");
    			} catch(Exception e) {
    				Two.LOGGER.info(e);
    			}
    			itemTooltipEvent.getToolTip().add(new StringTextComponent("Back: " + back));
    			itemTooltipEvent.getToolTip().add(new StringTextComponent("Seat: " + seat));
    			itemTooltipEvent.getToolTip().add(new StringTextComponent("Legs: " + legs));
    		}
    		if(itemTooltipEvent.getItemStack().getItem() == Items.ENDER_EYE) {
    			if(itemTooltipEvent.getItemStack().hasTag()) {
    				if(itemTooltipEvent.getItemStack().getTag().contains("pos")) {
    					BlockPos pos = BlockPos.fromLong(itemTooltipEvent.getItemStack().getTag().getLong("pos"));
    					itemTooltipEvent.getToolTip().add(new TranslationTextComponent("item.minecraft.ender_eye.pos").func_240701_a_(TextFormatting.ITALIC, TextFormatting.YELLOW).func_230529_a_(new StringTextComponent("(" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")"))); // attuned ender eyes found in chests and stuff will have obfuscated names
    				}
    			}
    		}
//    		if(itemTooltipEvent.getItemStack().getItem() instanceof DoubleJumpBootsItem) {
//    			int jumps = itemTooltipEvent.getItemStack().getTag().getInt("jumps");
//    			int extrajumplimit = itemTooltipEvent.getItemStack().getTag().getInt("extrajumplimit");
//    			
//    			itemTooltipEvent.getToolTip().add(new StringTextComponent("Jumps: " + jumps));
//    			itemTooltipEvent.getToolTip().add(new StringTextComponent("Extra Jump Limit: " + extrajumplimit));
//    		}
//    		
//    		LinkedList<Item> equipment = new LinkedList<Item>();
//    		if(itemTooltipEvent.getEntityLiving() != null) {
//        		itemTooltipEvent.getEntityLiving().getArmorInventoryList().forEach(itemStack -> equipment.add(itemStack.getItem()));
//        		if(equipment.contains(ItemsTwo.INSPECTION_SPECTACLES)) {
//        			if(Two.Config.igjeingien && !LanguageMap.getInstance().translateKey(itemTooltipEvent.getItemStack().getItem().getTranslationKey() + ".desc").equals((itemTooltipEvent.getItemStack().getItem().getTranslationKey() + ".desc"))) {
//            			itemTooltipEvent.getToolTip().add(new TranslationTextComponent(itemTooltipEvent.getItemStack().getItem().getTranslationKey() + ".info").applyTextStyles(TextFormatting.ITALIC, TextFormatting.GOLD));
//        			}
//        			if(itemTooltipEvent.getItemStack().getItem() instanceof TieredItem) {
//        				itemTooltipEvent.getToolTip().add(new StringTextComponent("Tier: " + ((TieredItem) itemTooltipEvent.getItemStack().getItem()).getTier()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.GREEN));
//        				itemTooltipEvent.getToolTip().add(new StringTextComponent("Enchantability: " + ((TieredItem) itemTooltipEvent.getItemStack().getItem()).getItemEnchantability()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.GREEN));
//
//        				itemTooltipEvent.getToolTip().add(new StringTextComponent("Max Uses: " + ((TieredItem) itemTooltipEvent.getItemStack().getItem()).getTier().getMaxUses()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.GREEN));
//        				itemTooltipEvent.getToolTip().add(new StringTextComponent("Efficiency: " + ((TieredItem) itemTooltipEvent.getItemStack().getItem()).getTier().getEfficiency()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.GREEN));
//        				itemTooltipEvent.getToolTip().add(new StringTextComponent("Harvest Level: " + ((TieredItem) itemTooltipEvent.getItemStack().getItem()).getTier().getHarvestLevel()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.GREEN));
//        				itemTooltipEvent.getToolTip().add(new StringTextComponent("Repair Material: " + ((TieredItem) itemTooltipEvent.getItemStack().getItem()).getTier().getRepairMaterial().getMatchingStacks()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.GREEN));
//        			}
//        			if(itemTooltipEvent.getItemStack().getItem().isFood()) {
//        				if(itemTooltipEvent.getItemStack().getItem().getFood().isMeat()) {
//        					itemTooltipEvent.getToolTip().add(new StringTextComponent("Meat").applyTextStyles(TextFormatting.ITALIC, TextFormatting.RED));
//        				}
//        				if(itemTooltipEvent.getItemStack().getItem().getFood().canEatWhenFull()) {
//        					itemTooltipEvent.getToolTip().add(new StringTextComponent("Can eat when full").applyTextStyles(TextFormatting.ITALIC, TextFormatting.RED));
//        				}
//        				if(itemTooltipEvent.getItemStack().getItem().getFood().isFastEating()) {
//        					itemTooltipEvent.getToolTip().add(new StringTextComponent("Fast eating").applyTextStyles(TextFormatting.ITALIC, TextFormatting.RED));
//        				}
//    					itemTooltipEvent.getToolTip().add(new StringTextComponent("Hunger Healing: " + itemTooltipEvent.getItemStack().getItem().getFood().getHealing()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.RED));
//    					itemTooltipEvent.getToolTip().add(new StringTextComponent("Saturation: " + itemTooltipEvent.getItemStack().getItem().getFood().getSaturation()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.RED));
//    					if(!itemTooltipEvent.getItemStack().getItem().getFood().getEffects().isEmpty()) {
//    						itemTooltipEvent.getToolTip().add(new StringTextComponent("Effects: " + itemTooltipEvent.getItemStack().getItem().getFood().getEffects().toString()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.RED));
//    					}
//        			}
//        			if(itemTooltipEvent.getItemStack().getItem() instanceof ArmorItem) {
//    					itemTooltipEvent.getToolTip().add(new StringTextComponent("Tier: " + ((ArmorItem) (itemTooltipEvent.getItemStack().getItem())).getArmorMaterial()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.BLUE));
//    					itemTooltipEvent.getToolTip().add(new StringTextComponent("Enchantability: " + ((ArmorItem) (itemTooltipEvent.getItemStack().getItem())).getItemEnchantability()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.BLUE));
//        			}
//        			if(itemTooltipEvent.getItemStack().getItem() instanceof HorseArmorItem) {
//        				itemTooltipEvent.getToolTip().add(new StringTextComponent("Protection: " + ((HorseArmorItem) itemTooltipEvent.getItemStack().getItem()).func_219977_e()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.BLUE));
//        			}
//        			if(itemTooltipEvent.getItemStack().getItem() instanceof BlockItem) {
//        				Block block = ((BlockItem) (itemTooltipEvent.getItemStack().getItem())).getBlock();
//        				if(block instanceof FlowerBlock) {
//        					itemTooltipEvent.getToolTip().add(new StringTextComponent("Effect: " + LanguageMap.getInstance().translateKey(((FlowerBlock) block).getStewEffect().getName())).applyTextStyles(TextFormatting.ITALIC, TextFormatting.LIGHT_PURPLE));
//        					itemTooltipEvent.getToolTip().add(new StringTextComponent("Duration: " + ((FlowerBlock) block).getStewEffectDuration()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.LIGHT_PURPLE));
//        				}
//        				// TODO Other Block Data. 
//        			}
//        		}
//    		}
    	}
//    	@SubscribeEvent
//    	public static <T extends LivingEntity> void onRenderLivingPre(final RenderLivingEvent.Pre<T, EntityModel<T>> renderLivingEvent$Pre) {
//    		if(renderLivingEvent$Pre.getEntity().getActivePotionEffect(EffectsTwo.FROSTY) != null) {
//        		RenderType renderType = RenderType.getEntitySolid(renderLivingEvent$Pre.getRenderer().getEntityTexture((T) renderLivingEvent$Pre.getEntity()));
//        		renderLivingEvent$Pre.getBuffers().getBuffer(renderType).color(0, 64, 128, 128);
//    		} // TODO shade an entity an icy blue when frozen
//    	}
    	@SubscribeEvent
    	public static void onRenderGameOverlayPre(final RenderGameOverlayEvent.Pre renderGameOverlayEvent$Pre) {
    		if(renderGameOverlayEvent$Pre.getType() == ElementType.VIGNETTE) {
    			// render a light cyan vignette when frozen
    		}
    	}
    	@SubscribeEvent
    	public static void onRenderGameOverlayPost(final RenderGameOverlayEvent.Post renderGameOverlayEvent$Post) {
    		
    	}
    }
}
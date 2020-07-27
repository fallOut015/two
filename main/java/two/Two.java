package two;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EvokerFangsRenderer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.LanguageMap;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.util.ITeleporter;
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
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import two.block.BlocksTwo;
import two.block.DreamcatcherBlock;
import two.client.renderer.RenderTypeLookupTwo;
import two.client.renderer.entity.BeardedDragonRenderer;
import two.client.renderer.entity.BombArrowRenderer;
import two.client.renderer.entity.CappedArrowRenderer;
import two.client.renderer.entity.ChameleonRenderer;
import two.client.renderer.entity.DarkDwarfArcherRenderer;
import two.client.renderer.entity.FireArrowRenderer;
import two.client.renderer.entity.IceArrowRenderer;
import two.client.renderer.entity.IceSlimeRenderer;
import two.client.renderer.entity.MummifiedZombieRenderer;
import two.client.renderer.entity.NetherBugRenderer;
import two.client.renderer.entity.RedPandaRenderer;
import two.client.renderer.entity.ShockArrowRenderer;
import two.client.renderer.entity.ShurikenRenderer;
import two.client.renderer.entity.SigilRenderer;
import two.client.renderer.entity.TwisterRenderer;
import two.client.renderer.entity.layers.ChameleonLayer;
import two.client.renderer.entity.layers.InspectionSpectaclesLayer;
import two.client.renderer.entity.layers.TopHatLayer;
import two.client.renderer.tileentity.ChairRenderer;
import two.common.capabilities.CapabilitiesTwo;
import two.enchantment.AbilityEnchantment;
import two.enchantment.EnchantmentsTwo;
import two.entity.EntityTypeTwo;
import two.entity.passive.ChameleonEntity;
import two.fluid.FluidsTwo;
import two.inventory.container.ContainerTypeTwo;
import two.item.ArmorMaterialTwo;
import two.item.DoubleJumpBootsItem;
import two.item.ItemsTwo;
import two.particles.ParticleTypesTwo;
import two.potion.EffectsTwo;
import two.stats.StatsTwo;
import two.tileentity.TileEntityTypeTwo;
import two.util.SoundEventsTwo;
import two.world.biome.BiomesTwo;
import two.world.biome.DefaultBiomeFeaturesTwo;
import two.world.dimension.DimensionTypeTwo;
import two.world.dimension.ModDimensionTwo;
import two.world.gen.carver.WorldCarverTwo;
import two.world.gen.feature.FeatureTwo;
import two.world.gen.placement.PlacementTwo;
import two.world.gen.surfacebuilders.SurfaceBuilderTwo;

@Mod("two")
public class Two {
	// TODO SLAB, PRESSURE PLATE, FENCE, STAIRS, BUTTON, SIGN, AND BOAT FOR STAINED PLANKS
	
	// GLAIVE
	// MACE
	// LONGBOW
	// ARBALEST
	
	// MATTOCK
	
	// PILLARS
	// FURNITURE
	// CURSED CHESTS?
	// FOOD SCRAPS
	
    public static final Logger LOGGER = LogManager.getLogger();
    
	public static AttributeModifier leveluphealth = new AttributeModifier(UUID.fromString("b27e893d-adfa-413d-be70-d1445dfdcf5f"), "level_up_health", 2, AttributeModifier.Operation.ADDITION);
    
    public Two() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
//    	DeferredWorkQueue ? 
    	DefaultBiomeFeaturesTwo.addFeatures();
    	DefaultBiomeFeaturesTwo.addStructures();
    	DefaultBiomeFeaturesTwo.addSpawns();
    	DefaultBiomeFeaturesTwo.addCarvers();
    	
    	
    }
    private void doClientStuff(final FMLClientSetupEvent event) {
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.CHAMELEON, ChameleonRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.BEARDED_DRAGON, BeardedDragonRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.RED_PANDA, RedPandaRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.NETHER_BUG, NetherBugRenderer::new);
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.CAPPED_ARROW, CappedArrowRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.FIRE_ARROW, FireArrowRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.ICE_ARROW, IceArrowRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.BOMB_ARROW, BombArrowRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.SHOCK_ARROW, ShockArrowRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.EVOCATION_FANGS, EvokerFangsRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.SHURIKEN, ShurikenRenderer::new);
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.DARK_DWARF_ARCHER, DarkDwarfArcherRenderer::new);

    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.MUMMIFIED_ZOMBIE, MummifiedZombieRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.ICE_SLIME, IceSlimeRenderer::new);
    	
    	//    	RenderingRegistry.registerEntityRenderingHandler(EntityType.WOLF, WolfRendererTwo::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.SIGIL, SigilRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.TWISTER, TwisterRenderer::new);
    	
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
    	} catch(NoSuchMethodError e) { Two.LOGGER.error(e); }
    }
    private void enqueueIMC(final InterModEnqueueEvent event) {}
    private void processIMC(final InterModProcessEvent event) {}
    @OnlyIn(Dist.CLIENT)
    private static void clientOnly() {
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("default").addLayer(new TopHatLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("default")));
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("slim").addLayer(new TopHatLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("slim")));

    	Minecraft.getInstance().getRenderManager().getSkinMap().get("default").addLayer(new InspectionSpectaclesLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("default")));
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("slim").addLayer(new InspectionSpectaclesLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("slim")));

    	Minecraft.getInstance().getRenderManager().getSkinMap().get("default").addLayer(new ChameleonLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("default")));
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("slim").addLayer(new ChameleonLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("slim")));
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {}
    
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
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
    		BiomesTwo.onBiomesRegistry(biomeRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onContainerTypesRegistry(final RegistryEvent.Register<ContainerType<?>> containerTypeRegistryEvent) {
    		ContainerTypeTwo.onContainerTypesRegistry(containerTypeRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onDimensionTypesRegistry(final RegistryEvent.Register<DimensionType> dimensionTypeRegistryEvent) {
    		DimensionTypeTwo.onDimensionTypesRegistry(dimensionTypeRegistryEvent);
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
    	public static void onModDimensionsRegistry(final RegistryEvent.Register<ModDimension> modDimensionRegistryEvent) {
    		ModDimensionTwo.onModDimensionsRegistry(modDimensionRegistryEvent);
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
    	public static void onSurfaceBuildersRegistry(final RegistryEvent.Register<SurfaceBuilder<?>> surfaceBuilderRegistryEvent) {
    		SurfaceBuilderTwo.onSurfaceBuildersRegistry(surfaceBuilderRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onTileEntitiesRegistry(final RegistryEvent.Register<TileEntityType<?>> tileEntityRegistryEvent) {
    		TileEntityTypeTwo.onTileEntitiesRegistry(tileEntityRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onWorldCarversRegistry(final RegistryEvent.Register<WorldCarver<?>> worldCarverRegistryEvent) {
    		WorldCarverTwo.onWorldCarversRegistry(worldCarverRegistryEvent);
    	}
    }
    
    @Mod.EventBusSubscriber
    public static class Events {
    	@SubscribeEvent
    	public static void onItemToss(final ItemTossEvent itemTossEvent) {
    		if(itemTossEvent.getEntityItem().getItem().getItem() instanceof ArrowItem && !itemTossEvent.getPlayer().getEntityWorld().isRemote) {
    			AbstractArrowEntity abstractarrowentity = ((ArrowItem) itemTossEvent.getEntityItem().getItem().getItem()).createArrow(itemTossEvent.getEntityItem().getEntityWorld(), itemTossEvent.getEntityItem().getItem(), itemTossEvent.getPlayer());
                abstractarrowentity.shoot(itemTossEvent.getPlayer(), itemTossEvent.getPlayer().rotationPitch, itemTossEvent.getPlayer().rotationYaw, 0.0F, 0.9F, 2.0F);
                itemTossEvent.getPlayer().getEntityWorld().addEntity(abstractarrowentity);
                itemTossEvent.setCanceled(true);
                // TODO Keep? Remove? I personally don't like this. And adding an extra item with a drop action sounds weird. 
                // Also TODO add item back to inventory in creative after it's cancelled. 
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
			if(playerWakeUpEvent.getPlayer().getEntityWorld().getDayTime() == 24000) {
    			if(playerWakeUpEvent.getPlayer().dimension == DimensionType.OVERWORLD && playerWakeUpEvent.getPlayer().getEntityWorld().getBlockState(playerWakeUpEvent.getPlayer().getBedLocation(DimensionType.OVERWORLD).up()).getBlock() instanceof DreamcatcherBlock) {
    				((DreamcatcherBlock) playerWakeUpEvent.getPlayer().getEntityWorld().getBlockState(playerWakeUpEvent.getPlayer().getBedLocation(DimensionType.OVERWORLD).up()).getBlock()).onPlayerWakeUp(playerWakeUpEvent);
    			}
    		}
    	}
    	@SubscribeEvent
    	public static void onPlayerSleepInBed(final PlayerSleepInBedEvent playerSleepInBedEvent) {
    		if(playerSleepInBedEvent.getPlayer().dimension.equals(DimensionManager.registerOrGetDimension(new ResourceLocation("two", "nightmare"), ModDimensionTwo.NIGHTMARE, null, false))) {
    			playerSleepInBedEvent.getPlayer().changeDimension(DimensionType.OVERWORLD, new ITeleporter() {
    				public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
    					return repositionEntity.apply(false);
    				}
    			});
    			playerSleepInBedEvent.getPlayer().getEntityWorld().setDayTime(24000);
    		}
    	}
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
    			livingJumpEvent.getEntityLiving().setMotion(Vec3d.ZERO);
    			return;
    		}
    		if(livingJumpEvent.getEntityLiving() instanceof PlayerEntity) {
//    			livingJumpEvent.getEntityLiving().addVelocity(0, 0.42F, 0);
//    			LOGGER.info("Player Jump!");
    			PlayerEntity p = (PlayerEntity) livingJumpEvent.getEntityLiving();
        		LinkedList<ItemStack> list = new LinkedList<ItemStack>();
        		livingJumpEvent.getEntityLiving().getArmorInventoryList().forEach(list::add);
//        		LOGGER.info(list);
        		if(list.getFirst().getItem() == ItemsTwo.DOUBLE_JUMP_BOOTS) {
//        			LOGGER.info("Boots!");
//        			LOGGER.info("Jumps: " + list.getFirst().getTag().getInt("jumps"));
//        			LOGGER.info("Extra Jump Limit: " + list.getFirst().getTag().getInt("extrajumplimit"));
        			if(list.getFirst().getTag().getInt("jumps") < list.getFirst().getTag().getInt("extrajumplimit")) {
//        				LOGGER.info("Allowed jump limit!");
        				if(p.isAirBorne) {
//        					LOGGER.info("Airborne!");
//        					p.jump();
        					list.getFirst().getTag().putInt("jumps", list.getFirst().getTag().getInt("jumps") + 1);
        				}
        			}
        		}
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
        		if(list.getFirst().getItem() == ItemsTwo.DOUBLE_JUMP_BOOTS) {
//        			LOGGER.info("Boots!");
        			if(p.onGround) {
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
    		if(playerXpEvent$LevelChange.getPlayer().getAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(leveluphealth)) {
        		playerXpEvent$LevelChange.getPlayer().getAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(leveluphealth);
    		}
    		playerXpEvent$LevelChange.getPlayer().getAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(leveluphealth);
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
            		if(playerEvent$Clone.getPlayer().getAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(leveluphealth)) {
            			playerEvent$Clone.getPlayer().getAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(leveluphealth);
            		}
            		playerEvent$Clone.getPlayer().getAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(leveluphealth);
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
    		// Pickaxes show all of the ores they can mine. 
//    		if(itemTooltipEvent.getItemStack().getItem() instanceof PickaxeItem) {
//    			if(((PickaxeItem) itemTooltipEvent.getItemStack().getItem()).getTier().getHarvestLevel() == 6)
//    				itemTooltipEvent.getToolTip().add(new StringTextComponent("Can mine everything."));
//    			else {
//    				List<IItemTier> itemTiers = new LinkedList<IItemTier>();
//    				
//        			for(IItemTier itemTier : ItemTier.values())
//        				if(itemTier != ItemTier.WOOD && ((PickaxeItem) itemTooltipEvent.getItemStack().getItem()).getTier().getHarvestLevel() > itemTier.getHarvestLevel() - 1)
//        					itemTiers.add(itemTier);
//        			for(IItemTier itemTier : ItemTierTwo.values())
//        				if(itemTier != ItemTierTwo.BLOOD_BLADE && ((PickaxeItem) itemTooltipEvent.getItemStack().getItem()).getTier().getHarvestLevel() > itemTier.getHarvestLevel() - 1)
//        					itemTiers.add(itemTier);
//        			
//        			Collections.sort((List<IItemTier>) itemTiers, (itemTier1, itemTier2) -> itemTier1.getHarvestLevel() - itemTier2.getHarvestLevel());
//        			
//        			itemTooltipEvent.getToolTip().add(new StringTextComponent("Can mine...").applyTextStyle(TextFormatting.GRAY));        			
//        			itemTooltipEvent.getToolTip().add(new StringTextComponent(itemTiers.toString().toLowerCase()/*.replaceAll("[", "").replaceAll("]", "")*/).applyTextStyle(TextFormatting.GRAY));
//    			}
//    		}
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
    		if(itemTooltipEvent.getItemStack().getItem() instanceof DoubleJumpBootsItem) {
    			int jumps = itemTooltipEvent.getItemStack().getTag().getInt("jumps");
    			int extrajumplimit = itemTooltipEvent.getItemStack().getTag().getInt("extrajumplimit");
    			
    			itemTooltipEvent.getToolTip().add(new StringTextComponent("Jumps: " + jumps));
    			itemTooltipEvent.getToolTip().add(new StringTextComponent("Extra Jump Limit: " + extrajumplimit));
    		}
    		
    		LinkedList<Item> equipment = new LinkedList<Item>();
    		if(itemTooltipEvent.getEntityLiving() != null) {
        		itemTooltipEvent.getEntityLiving().getArmorInventoryList().forEach(itemStack -> equipment.add(itemStack.getItem()));
        		if(equipment.contains(ItemsTwo.INSPECTION_SPECTACLES)) {
        			if(!LanguageMap.getInstance().translateKey(itemTooltipEvent.getItemStack().getItem().getTranslationKey() + ".desc").equals((itemTooltipEvent.getItemStack().getItem().getTranslationKey() + ".desc"))) {
            			itemTooltipEvent.getToolTip().add(new TranslationTextComponent(itemTooltipEvent.getItemStack().getItem().getTranslationKey() + ".desc").applyTextStyles(TextFormatting.ITALIC, TextFormatting.GOLD));
        			}
        			if(itemTooltipEvent.getItemStack().getItem() instanceof TieredItem) {
        				itemTooltipEvent.getToolTip().add(new StringTextComponent("Tier: " + ((TieredItem) itemTooltipEvent.getItemStack().getItem()).getTier()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.GREEN));
        				itemTooltipEvent.getToolTip().add(new StringTextComponent("Enchantability: " + ((TieredItem) itemTooltipEvent.getItemStack().getItem()).getItemEnchantability()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.GREEN));

        				itemTooltipEvent.getToolTip().add(new StringTextComponent("Max Uses: " + ((TieredItem) itemTooltipEvent.getItemStack().getItem()).getTier().getMaxUses()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.GREEN));
        				itemTooltipEvent.getToolTip().add(new StringTextComponent("Efficiency: " + ((TieredItem) itemTooltipEvent.getItemStack().getItem()).getTier().getEfficiency()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.GREEN));
        				itemTooltipEvent.getToolTip().add(new StringTextComponent("Harvest Level: " + ((TieredItem) itemTooltipEvent.getItemStack().getItem()).getTier().getHarvestLevel()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.GREEN));
        				itemTooltipEvent.getToolTip().add(new StringTextComponent("Repair Material: " + ((TieredItem) itemTooltipEvent.getItemStack().getItem()).getTier().getRepairMaterial().getMatchingStacks()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.GREEN));
        			}
        			if(itemTooltipEvent.getItemStack().getItem().isFood()) {
        				if(itemTooltipEvent.getItemStack().getItem().getFood().isMeat()) {
        					itemTooltipEvent.getToolTip().add(new StringTextComponent("Meat").applyTextStyles(TextFormatting.ITALIC, TextFormatting.RED));
        				}
        				if(itemTooltipEvent.getItemStack().getItem().getFood().canEatWhenFull()) {
        					itemTooltipEvent.getToolTip().add(new StringTextComponent("Can eat when full").applyTextStyles(TextFormatting.ITALIC, TextFormatting.RED));
        				}
        				if(itemTooltipEvent.getItemStack().getItem().getFood().isFastEating()) {
        					itemTooltipEvent.getToolTip().add(new StringTextComponent("Fast eating").applyTextStyles(TextFormatting.ITALIC, TextFormatting.RED));
        				}
    					itemTooltipEvent.getToolTip().add(new StringTextComponent("Hunger Healing: " + itemTooltipEvent.getItemStack().getItem().getFood().getHealing()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.RED));
    					itemTooltipEvent.getToolTip().add(new StringTextComponent("Saturation: " + itemTooltipEvent.getItemStack().getItem().getFood().getSaturation()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.RED));
    					if(!itemTooltipEvent.getItemStack().getItem().getFood().getEffects().isEmpty()) {
    						itemTooltipEvent.getToolTip().add(new StringTextComponent("Effects: " + itemTooltipEvent.getItemStack().getItem().getFood().getEffects().toString()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.RED));
    					}
        			}
        			if(itemTooltipEvent.getItemStack().getItem() instanceof ArmorItem) {
    					itemTooltipEvent.getToolTip().add(new StringTextComponent("Tier: " + ((ArmorItem) (itemTooltipEvent.getItemStack().getItem())).getArmorMaterial()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.BLUE));
    					itemTooltipEvent.getToolTip().add(new StringTextComponent("Enchantability: " + ((ArmorItem) (itemTooltipEvent.getItemStack().getItem())).getItemEnchantability()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.BLUE));
        			}
        			if(itemTooltipEvent.getItemStack().getItem() instanceof HorseArmorItem) {
        				itemTooltipEvent.getToolTip().add(new StringTextComponent("Protection: " + ((HorseArmorItem) itemTooltipEvent.getItemStack().getItem()).func_219977_e()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.BLUE));
        			}
        			if(itemTooltipEvent.getItemStack().getItem() instanceof BlockItem) {
        				Block block = ((BlockItem) (itemTooltipEvent.getItemStack().getItem())).getBlock();
        				if(block instanceof FlowerBlock) {
        					itemTooltipEvent.getToolTip().add(new StringTextComponent("Effect: " + LanguageMap.getInstance().translateKey(((FlowerBlock) block).getStewEffect().getName())).applyTextStyles(TextFormatting.ITALIC, TextFormatting.LIGHT_PURPLE));
        					itemTooltipEvent.getToolTip().add(new StringTextComponent("Duration: " + ((FlowerBlock) block).getStewEffectDuration()).applyTextStyles(TextFormatting.ITALIC, TextFormatting.LIGHT_PURPLE));
        				}
        				// TODO Other Block Data. 
        			}
        		}
    		}
    	}
    }
}
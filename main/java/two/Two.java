package two;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.StatType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
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
import net.minecraftforge.registries.ForgeRegistries;
import two.block.BlocksTwo;
import two.block.DreamcatcherBlock;
import two.client.renderer.entity.CappedArrowRenderer;
import two.client.renderer.entity.ChameleonRenderer;
import two.client.renderer.entity.DarkDwarfArcherRenderer;
import two.client.renderer.entity.layers.TopHatLayer;
import two.client.renderer.tileentity.ChairRenderer;
import two.enchantment.EnchantmentsTwo;
import two.entity.EntityTypeTwo;
import two.inventory.container.ContainerTypeTwo;
import two.item.ArmorMaterialTwo;
import two.item.BloodBladeItem;
import two.item.ItemTierTwo;
import two.item.ItemsTwo;
import two.stats.StatsTwo;
import two.tileentity.TileEntityTypeTwo;
import two.util.SoundEventsTwo;
import two.world.biome.BiomesTwo;
import two.world.dimension.ModDimensionTwo;
import two.world.gen.feature.FeatureTwo;
import two.world.gen.surfacebuilders.SurfaceBuilderTwo;

@Mod("two")
public class Two {
	// TODO STAIRS AND SLAB FOR ADOBE AND GLAZED BRICKS
	// TODO SLAB, PRESSURE PLATE, FENCE, STAIRS, BUTTON, SIGN, AND BOAT FOR STAINED PLANKS
	
	// GLAIVE
	// DAGGER
	// MACE
	// LONGBOW
	// ARBALEST
	// CAPPED ARROWS
	
	// MATTOCK
	
	// PILLARS
	// FURNITURE
	// CURSED CHESTS?
	// FOOD SCRAPS
	
	// FIX TREES
	// FIX SOUNDS
	// FIX MODELS (LIKE DREAMCATCHERS AND SAPLINGS)
	
    public static final Logger LOGGER = LogManager.getLogger();
    
    public Two() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {}
    private void doClientStuff(final FMLClientSetupEvent event) {
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.CHAMELEON, ChameleonRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.CAPPED_ARROW, CappedArrowRenderer::new);
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.DARK_DWARF_ARCHER, DarkDwarfArcherRenderer::new);
//    	RenderingRegistry.registerEntityRenderingHandler(EntityType.WOLF, WolfRendererTwo::new);
    	
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("default").addLayer(new TopHatLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("default")));
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("slim").addLayer(new TopHatLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("slim")));
    	
    	ClientRegistry.bindTileEntityRenderer(TileEntityTypeTwo.CHAIR, ChairRenderer::new);
    	
    	Biomes.JUNGLE.addFeature(Decoration.VEGETAL_DECORATION, FeatureTwo.MAPLE_TREE.func_225566_b_(FeatureTwo.MAPLE));
    	Biomes.JUNGLE.addFeature(Decoration.VEGETAL_DECORATION, FeatureTwo.CHERRY_TREE.func_225566_b_(FeatureTwo.MAPLE));
    	Biomes.JUNGLE.addFeature(Decoration.VEGETAL_DECORATION, FeatureTwo.GHOSTWOOD_TREE.func_225566_b_(FeatureTwo.GHOSTWOOD));
    	
    	Biomes.BADLANDS.func_226711_a_(FeatureTwo.ADOBE_WELL.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
    	Biomes.BADLANDS_PLATEAU.func_226711_a_(FeatureTwo.ADOBE_WELL.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
    	Biomes.ERODED_BADLANDS.func_226711_a_(FeatureTwo.ADOBE_WELL.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
    	Biomes.MODIFIED_BADLANDS_PLATEAU.func_226711_a_(FeatureTwo.ADOBE_WELL.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
    	Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU.func_226711_a_(FeatureTwo.ADOBE_WELL.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
    	Biomes.WOODED_BADLANDS_PLATEAU.func_226711_a_(FeatureTwo.ADOBE_WELL.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));

    	Biomes.PLAINS.func_226711_a_(FeatureTwo.DWARVEN_KEEP.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
    	
    	Biomes.SAVANNA.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TANZANITE_ORE.getDefaultState(), 1)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(1, 0, 0, 1))));
    	Biomes.SAVANNA_PLATEAU.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TANZANITE_ORE.getDefaultState(), 1)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(1, 0, 0, 1))));
    	Biomes.SHATTERED_SAVANNA.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TANZANITE_ORE.getDefaultState(), 1)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(1, 0, 0, 1))));
    	Biomes.SHATTERED_SAVANNA_PLATEAU.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TANZANITE_ORE.getDefaultState(), 1)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(1, 0, 0, 1))));

    	Biomes.DESERT.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 10, 1, 2));
    	Biomes.DESERT_HILLS.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 8, 1, 2));
    	Biomes.DESERT_LAKES.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 8, 1, 2));
    	
    	Biomes.JUNGLE.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 12, 2, 4));
    	Biomes.JUNGLE_EDGE.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 4, 2, 4));
    	Biomes.JUNGLE_HILLS.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 10, 2, 4));
    	Biomes.MODIFIED_JUNGLE.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 10, 3, 5));
    	Biomes.MODIFIED_JUNGLE_EDGE.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityTypeTwo.CHAMELEON, 8, 3, 5));
    	
    	for(Biome biomeIn : ForgeRegistries.BIOMES) {
    		if(biomeIn.getCategory() == Category.NETHER) {
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.AMETHYST_ORE.getDefaultState(), 6)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(8, 10, 20, 64))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.GARNET_ORE.getDefaultState(), 6)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(8, 10, 20, 64))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.TOPAZ_ORE.getDefaultState(), 5)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(4, 10, 20, 32))));

    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.LEAD_ORE.getDefaultState(), 9)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(16, 10, 20, 128))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksTwo.TITANIUM_ORE.getDefaultState(), 4)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(4, 10, 20, 32))));
    		} else if(biomeIn.getCategory() == Category.THEEND) {
    			if(biomeIn != Biomes.THE_END) {
    				biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(FeatureTwo.END_STONE, BlocksTwo.COBALT_ORE.getDefaultState(), 7)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(8, 0, 0, 32))));
    				biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(FeatureTwo.END_STONE, BlocksTwo.JADE_ORE.getDefaultState(), 7)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(8, 0, 0, 32))));
    				biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(FeatureTwo.END_STONE, BlocksTwo.SAPPHIRE_ORE.getDefaultState(), 7)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(4, 0, 0, 16))));

    				biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(FeatureTwo.END_STONE, BlocksTwo.PLATINUM_ORE.getDefaultState(), 5)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(4, 0, 0, 16))));
    			}
    		} else if(biomeIn.getCategory() != Category.NONE) {
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.OPAL_ORE.getDefaultState(), 8)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(4, 0, 0, 32))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.RUBY_ORE.getDefaultState(), 8)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(4, 0, 0, 32))));
        	
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TALC_ORE.getDefaultState(), 17)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(20, 0, 0, 128))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.TIN_ORE.getDefaultState(), 10)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(20, 0, 0, 64))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.ALUMINUM_ORE.getDefaultState(), 10)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(20, 0, 0, 64))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.SILVER_ORE.getDefaultState(), 9)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(16, 0, 0, 20))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.COPPER_ORE.getDefaultState(), 9)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(20, 0, 0, 64))));
    			biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksTwo.PYRITE_ORE.getDefaultState(), 9)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(2, 0, 0, 32))));
    		}
    		// Other ore generation is handled in the new biomes' classes. 
    	}
    }
    private void enqueueIMC(final InterModEnqueueEvent event) {}
    private void processIMC(final InterModProcessEvent event) {}
    
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
    	public static void onEntityTypesRegistry(final RegistryEvent.Register<EntityType<?>> entityTypeRegistryEvent) {
    		EntityTypeTwo.onEntityTypesRegistry(entityTypeRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onFeaturesRegistry(final RegistryEvent.Register<Feature<?>> featureRegistryEvent) {
    		FeatureTwo.onFeaturesRegistry(featureRegistryEvent);
    	}
    	@SubscribeEvent
    	public static void onModDimensionsRegistry(final RegistryEvent.Register<ModDimension> modDimensionRegistryEvent) {
    		ModDimensionTwo.onModDimensionsRegistry(modDimensionRegistryEvent);
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
    	public static void onEnchantmentsRegistry(final RegistryEvent.Register<Enchantment> enchantmentRegistryEvent) {
    		EnchantmentsTwo.onEnchantmentsRegistry(enchantmentRegistryEvent);
    	}
    }
    
    @Mod.EventBusSubscriber
    public static class Events {
    	@SubscribeEvent
    	public static void onLivingEquipmentChange(final LivingEquipmentChangeEvent livingEquipmentChangeEvent) {
    		if(livingEquipmentChangeEvent.getEntityLiving() instanceof PlayerEntity) {
    			if(livingEquipmentChangeEvent.getSlot().getSlotType().equals(EquipmentSlotType.Group.ARMOR)) {
    				List<ItemStack> list = new LinkedList<ItemStack>();
    				livingEquipmentChangeEvent.getEntityLiving().getArmorInventoryList().forEach(list::add);
    				if(livingEquipmentChangeEvent.getFrom().getItem() instanceof ArmorItem) {
    					try {
    						if(list.stream().allMatch(itemstack -> ((ArmorItem) itemstack.getItem()).getArmorMaterial() == ((ArmorItem) livingEquipmentChangeEvent.getFrom().getItem()).getArmorMaterial())) {
            					LOGGER.info("Apply set bonus!");
            					if(((ArmorItem) livingEquipmentChangeEvent.getFrom().getItem()).getArmorMaterial() == ArmorMaterialTwo.OBSIDIAN) {
            			    		 livingEquipmentChangeEvent.getEntityLiving().addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 50, 3, false, true));
            					}
            				}     						
    					} catch(Exception e) {
    						LOGGER.warn(e);
    						LOGGER.warn(e.getClass());
    					}
    				}
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
    	public static void onLivingJump(final LivingJumpEvent livingJumpEvent) {
    		if(livingJumpEvent.getEntityLiving() instanceof PlayerEntity) {
    			LOGGER.info("Player Jump!");
    			PlayerEntity p = (PlayerEntity) livingJumpEvent.getEntityLiving();
        		LinkedList<ItemStack> list = new LinkedList<ItemStack>();
        		livingJumpEvent.getEntityLiving().getArmorInventoryList().forEach(list::add);
        		LOGGER.info(list);
        		if(list.getFirst().getItem() == ItemsTwo.DOUBLE_JUMP_BOOTS) {
        			LOGGER.info("Boots!");
        			if(list.getFirst().getTag().getInt("jumps") < list.getFirst().getTag().getInt("extrajumplimit")) {
        				LOGGER.info("Allowed jump limit!");
        				if(p.isAirBorne) {
        					LOGGER.info("Airborne!");
        					p.jump();
//        					if(false) {
//        						EnchantmentHelper.getEnchantmentLevel(EnchantmentsTwo.BOUNDING, list.getFirst());
//        					}
        					list.getFirst().getTag().putInt("jumps", list.getFirst().getTag().getInt("jumps") + 1);
        				}
        			}
        		}
    		}
    	}
    	@SubscribeEvent
    	public static void onLivingFall(final LivingFallEvent livingFallEvent) {
    		if(livingFallEvent.getEntityLiving() instanceof PlayerEntity) {
    			LOGGER.info("Player Fall!");
    			PlayerEntity p = (PlayerEntity) livingFallEvent.getEntityLiving();
        		LinkedList<ItemStack> list = new LinkedList<ItemStack>();
        		livingFallEvent.getEntityLiving().getArmorInventoryList().forEach(list::add);
        		LOGGER.info(list);
        		if(list.getFirst().getItem() == ItemsTwo.DOUBLE_JUMP_BOOTS) {
        			LOGGER.info("Boots!");
        			if(p.onGround) {
        				LOGGER.info("Grounded!");
        				list.getFirst().getTag().putInt("jumps", 0);
        			}
        		}
    		}
    	}
    	@SubscribeEvent
    	public static void onItemTooltip(final ItemTooltipEvent itemToolTipEvent) {
    		// Pickaxes show all of the ores they can mine. 
    		if(itemToolTipEvent.getItemStack().getItem() instanceof PickaxeItem) {
    			if(((PickaxeItem) itemToolTipEvent.getItemStack().getItem()).getTier().getHarvestLevel() == 6)
    				itemToolTipEvent.getToolTip().add(new StringTextComponent("Can mine everything."));
    			else {
    				List<IItemTier> itemTiers = new LinkedList<IItemTier>();
    				
        			for(IItemTier itemTier : ItemTier.values())
        				if(itemTier != ItemTier.WOOD && ((PickaxeItem) itemToolTipEvent.getItemStack().getItem()).getTier().getHarvestLevel() >= itemTier.getHarvestLevel() - 1)
        					itemTiers.add(itemTier);
        			for(IItemTier itemTier : ItemTierTwo.values())
        				if(itemTier != ItemTierTwo.BLOOD_BLADE && ((PickaxeItem) itemToolTipEvent.getItemStack().getItem()).getTier().getHarvestLevel() >= itemTier.getHarvestLevel() - 1)
        					itemTiers.add(itemTier);
        			
        			Collections.sort((List<IItemTier>) itemTiers, (itemTier1, itemTier2) -> itemTier1.getHarvestLevel() - itemTier2.getHarvestLevel());
        			
        			itemToolTipEvent.getToolTip().add(new StringTextComponent("Can mine...").applyTextStyle(TextFormatting.GRAY));        			
        			itemToolTipEvent.getToolTip().add(new StringTextComponent(itemTiers.toString().toLowerCase()/*.replaceAll("[", "").replaceAll("]", "")*/).applyTextStyle(TextFormatting.GRAY));
    			}
    		}
    		if(itemToolTipEvent.getItemStack().getItem() == ItemsTwo.CHAIR) {
    			String seat = "";
    			try {
        			seat = itemToolTipEvent.getItemStack().getTag().getString("top");
    			} catch(Exception e) {
    				Two.LOGGER.info(e);
    			}
    			String legs = "";
    			try {
    				legs = itemToolTipEvent.getItemStack().getTag().getString("middle");
    			} catch(Exception e) {
    				Two.LOGGER.info(e);
    			}
    			String back = "";
    			try {
    				back = itemToolTipEvent.getItemStack().getTag().getString("bottom");
    			} catch(Exception e) {
    				Two.LOGGER.info(e);
    			}
    			itemToolTipEvent.getToolTip().add(new StringTextComponent("Back: " + back));
    			itemToolTipEvent.getToolTip().add(new StringTextComponent("Seat: " + seat));
    			itemToolTipEvent.getToolTip().add(new StringTextComponent("Legs: " + legs));
    		}
    		if(itemToolTipEvent.getItemStack().getItem() instanceof BloodBladeItem) {
    			float xp = 0;
    			int level = 0;
    			
    			try {
    				xp = itemToolTipEvent.getItemStack().getTag().getFloat("xp");
    			} catch(Exception e) {
    				LOGGER.info(e);
    			}
    			try {
    				level = itemToolTipEvent.getItemStack().getTag().getInt("level");
    			} catch(Exception e) {
    				LOGGER.info(e);
    			}
    			
    			itemToolTipEvent.getToolTip().add(new StringTextComponent("XP: " + xp));
    			itemToolTipEvent.getToolTip().add(new StringTextComponent("Level: " + level));
    		}
    	}
    }
}

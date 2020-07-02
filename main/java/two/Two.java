package two;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.StatType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.feature.Feature;
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
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
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
import two.client.renderer.entity.CappedArrowRenderer;
import two.client.renderer.entity.ChameleonRenderer;
import two.client.renderer.entity.DarkDwarfArcherRenderer;
import two.client.renderer.entity.SigilRenderer;
import two.client.renderer.entity.layers.TopHatLayer;
import two.client.renderer.tileentity.ChairRenderer;
import two.common.capabilities.CapabilitiesTwo;
import two.enchantment.EnchantmentsTwo;
import two.entity.EntityTypeTwo;
import two.inventory.container.ContainerTypeTwo;
import two.item.ArmorMaterialTwo;
import two.item.DoubleJumpBootsItem;
import two.item.ItemTierTwo;
import two.item.ItemsTwo;
import two.stats.StatsTwo;
import two.tileentity.TileEntityTypeTwo;
import two.util.SoundEventsTwo;
import two.world.biome.BiomesTwo;
import two.world.biome.DefaultBiomeFeaturesTwo;
import two.world.dimension.ModDimensionTwo;
import two.world.gen.feature.FeatureTwo;
import two.world.gen.surfacebuilders.SurfaceBuilderTwo;

@Mod("two")
public class Two {
	// TODO SLABS, STAIRS, and WALLS for GLAZED BRICKS
	// TODO SLAB, PRESSURE PLATE, FENCE, STAIRS, BUTTON, SIGN, AND BOAT FOR STAINED PLANKS
	
	// GLAIVE
	// DAGGER
	// MACE
	// LONGBOW
	// ARBALEST
	
	// MATTOCK
	
	// PILLARS
	// FURNITURE
	// CURSED CHESTS?
	// FOOD SCRAPS
	
    public static final Logger LOGGER = LogManager.getLogger();
    
//	public static AttributeModifier leveluphealth = new AttributeModifier(UUID.fromString("5D6F0BA2-1186-46AC-B896-C61C5CEE99CC"), "level_up_health", 2, AttributeModifier.Operation.ADDITION);
    
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
    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.SIGIL, SigilRenderer::new);
    	
    	ClientRegistry.bindTileEntityRenderer(TileEntityTypeTwo.CHAIR, ChairRenderer::new);
    	
    	DefaultBiomeFeaturesTwo.addFeatures();
    	DefaultBiomeFeaturesTwo.addStructures();
    	DefaultBiomeFeaturesTwo.addSpawns();

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
    		clientOnly();
    	} catch(NoSuchMethodError e) { Two.LOGGER.error(e); }
    }
    private void enqueueIMC(final InterModEnqueueEvent event) {}
    private void processIMC(final InterModProcessEvent event) {}
    @OnlyIn(Dist.CLIENT)
    private static void clientOnly() {
		Two.LOGGER.info("Running Two$clientOnly, will throw a NoSuchMethod error on a dedicated server.");

    	Minecraft.getInstance().getRenderManager().getSkinMap().get("default").addLayer(new TopHatLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("default")));
    	Minecraft.getInstance().getRenderManager().getSkinMap().get("slim").addLayer(new TopHatLayer<>(Minecraft.getInstance().getRenderManager().getSkinMap().get("slim")));
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
    	public static void onGlobalLootModifierSerializersRegistry(final RegistryEvent.Register<GlobalLootModifierSerializer<?>> globalLootModifierSerializerRegistryEvent) {
    		// loot stuff
//    		LootTables.CHESTS_SIMPLE_DUNGEON.
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
    }
    
    @Mod.EventBusSubscriber
    public static class Events {
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
    	public static void onLivingJump(final LivingJumpEvent livingJumpEvent) {
    		if(livingJumpEvent.getEntityLiving() instanceof PlayerEntity) {
    			LOGGER.info("Player Jump!");
    			PlayerEntity p = (PlayerEntity) livingJumpEvent.getEntityLiving();
        		LinkedList<ItemStack> list = new LinkedList<ItemStack>();
        		livingJumpEvent.getEntityLiving().getArmorInventoryList().forEach(list::add);
        		LOGGER.info(list);
        		if(list.getFirst().getItem() == ItemsTwo.DOUBLE_JUMP_BOOTS) {
        			LOGGER.info("Boots!");
        			LOGGER.info("Jumps: " + list.getFirst().getTag().getInt("jumps"));
        			LOGGER.info("Extra Jump Limit: " + list.getFirst().getTag().getInt("extrajumplimit"));
        			if(list.getFirst().getTag().getInt("jumps") < list.getFirst().getTag().getInt("extrajumplimit")) {
        				LOGGER.info("Allowed jump limit!");
        				if(p.isAirBorne) {
        					LOGGER.info("Airborne!");
        					p.jump();
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
    	public static void onLevelChange(final PlayerXpEvent.LevelChange playerXpEvent$LevelChange) {
    		// Later on when there are choices for leveling up this will be in an if statement. 
    		
    		INBT nbt = CapabilitiesTwo.PLAYERUPGRADES.writeNBT(CapabilitiesTwo.PLAYERUPGRADES.getDefaultInstance(), Direction.UP);
       		
       		((CompoundNBT) nbt).putDouble("health", ((CompoundNBT) nbt).getDouble("health") + playerXpEvent$LevelChange.getLevels());
       		((CompoundNBT) nbt).putDouble("hunger", ((CompoundNBT) nbt).getDouble("hunger") + playerXpEvent$LevelChange.getLevels());
       		((CompoundNBT) nbt).putDouble("armor", ((CompoundNBT) nbt).getDouble("armor") + playerXpEvent$LevelChange.getLevels());
       		((CompoundNBT) nbt).putDouble("breathing", ((CompoundNBT) nbt).getDouble("breathing") + playerXpEvent$LevelChange.getLevels());

    		CapabilitiesTwo.PLAYERUPGRADES.readNBT(CapabilitiesTwo.PLAYERUPGRADES.getDefaultInstance(), Direction.UP, nbt);

    		Two.LOGGER.info("instance double health: " + CapabilitiesTwo.PLAYERUPGRADES.getDefaultInstance().getHealth());
    		
//    		leveluphealth = new AttributeModifier(UUID.fromString("5D6F0BA2-1186-46AC-B896-C61C5CEE99CC"), "level_up_health", currentleveluphealth + playerXpEvent$LevelChange.getLevels(), AttributeModifier.Operation.ADDITION);
//    		playerXpEvent$LevelChange.getPlayer().getAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(leveluphealth);
    	}
    	@SubscribeEvent
    	public static void onPlayerClone(final PlayerEvent.Clone playerEvent$Clone) {
    		if(playerEvent$Clone.isWasDeath()) {
        		INBT nbt = CapabilitiesTwo.PLAYERUPGRADES.writeNBT(CapabilitiesTwo.PLAYERUPGRADES.getDefaultInstance(), Direction.UP);
           		
        		((CompoundNBT) nbt).putDouble("health", 0);
           		((CompoundNBT) nbt).putDouble("hunger", 0);
           		((CompoundNBT) nbt).putDouble("armor", 0);
           		((CompoundNBT) nbt).putDouble("breathing", 0);
        		
           		CapabilitiesTwo.PLAYERUPGRADES.readNBT(CapabilitiesTwo.PLAYERUPGRADES.getDefaultInstance(), Direction.UP, nbt);
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
    	@OnlyIn(Dist.CLIENT)
    	public static void onItemTooltip(final ItemTooltipEvent itemTooltipEvent) {
    		// Pickaxes show all of the ores they can mine. 
    		if(itemTooltipEvent.getItemStack().getItem() instanceof PickaxeItem) {
    			if(((PickaxeItem) itemTooltipEvent.getItemStack().getItem()).getTier().getHarvestLevel() == 6)
    				itemTooltipEvent.getToolTip().add(new StringTextComponent("Can mine everything."));
    			else {
    				List<IItemTier> itemTiers = new LinkedList<IItemTier>();
    				
        			for(IItemTier itemTier : ItemTier.values())
        				if(itemTier != ItemTier.WOOD && ((PickaxeItem) itemTooltipEvent.getItemStack().getItem()).getTier().getHarvestLevel() >= itemTier.getHarvestLevel() - 1)
        					itemTiers.add(itemTier);
        			for(IItemTier itemTier : ItemTierTwo.values())
        				if(itemTier != ItemTierTwo.BLOOD_BLADE && ((PickaxeItem) itemTooltipEvent.getItemStack().getItem()).getTier().getHarvestLevel() >= itemTier.getHarvestLevel() - 1)
        					itemTiers.add(itemTier);
        			
        			Collections.sort((List<IItemTier>) itemTiers, (itemTier1, itemTier2) -> itemTier1.getHarvestLevel() - itemTier2.getHarvestLevel());
        			
        			itemTooltipEvent.getToolTip().add(new StringTextComponent("Can mine...").applyTextStyle(TextFormatting.GRAY));        			
        			itemTooltipEvent.getToolTip().add(new StringTextComponent(itemTiers.toString().toLowerCase()/*.replaceAll("[", "").replaceAll("]", "")*/).applyTextStyle(TextFormatting.GRAY));
    			}
    		}
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
    	}
    }
}
package io.github.fallout015.two.enchantment;

import io.github.fallout015.two.Two;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentsTwo {
	private static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Two.MODID);

	
	
	public static final RegistryObject<Enchantment> SWIPING = ENCHANTMENTS.register("swiping", () -> new SwipingEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<Enchantment> DISABLER = ENCHANTMENTS.register("disabler", () -> new DisablerEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<Enchantment> DISARMING = ENCHANTMENTS.register("disarming", () -> new DisarmingEnchantment(Enchantment.Rarity.COMMON, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<Enchantment> VITALITY_THIEF = ENCHANTMENTS.register("vitality_thief", () -> new VitalityThiefEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<Enchantment> SNAPPING = ENCHANTMENTS.register("snapping", () -> new SnappingEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<Enchantment> DISTANCE = ENCHANTMENTS.register("distance", () -> new DistanceEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<Enchantment> BOUNDING = ENCHANTMENTS.register("bounding", () -> new BoundingEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.FEET));
	public static final RegistryObject<Enchantment> GENTLE_DESCENT = ENCHANTMENTS.register("gentle_descent", () -> new GentleDescentEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.HEAD));
	public static final RegistryObject<Enchantment> REBOUND = ENCHANTMENTS.register("rebound", () -> new ReboundEnchantment(Enchantment.Rarity.COMMON, EquipmentSlotType.FEET));
	
	public static final RegistryObject<Enchantment> FLIMSINESS_CURSE = ENCHANTMENTS.register("flimsiness_curse", () -> new FlimsinessCurseEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<Enchantment> CLUMSINESS_CURSE = ENCHANTMENTS.register("clumsiness_curse", () -> new ClumsinessCurseEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<Enchantment> BACKFIRE_CURSE = ENCHANTMENTS.register("backfire_curse", () -> new BackfireCurseEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<Enchantment> HEAVINESS_CURSE = ENCHANTMENTS.register("heaviness_curse", () -> new HeavinessCurseEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET));
	
	public static final RegistryObject<Enchantment> FIRE_ABILITY = ENCHANTMENTS.register("fire_ability", () -> new FireAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<Enchantment> LIGHTNING_ABILITY = ENCHANTMENTS.register("lightning_ability", () -> new LightningAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<Enchantment> GRASS_ABILITY = ENCHANTMENTS.register("grass_ability", () -> new GrassAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<Enchantment> NETHER_ABILITY = ENCHANTMENTS.register("nether_ability", () -> new NetherAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<Enchantment> WIND_ABILITY = ENCHANTMENTS.register("wind_ability", () -> new WindAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<Enchantment> ICE_ABILITY = ENCHANTMENTS.register("ice_ability", () -> new IceAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));

	// electricity
	// conjuring
	// something for shields and bucklers
	// crossbow enchantments for arbalest
	// bow enchantments for longbow
	
	
	
	public static void register(IEventBus bus) {
		ENCHANTMENTS.register(bus);
	}
}
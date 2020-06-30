package two.enchantment;

import java.util.LinkedList;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import two.item.BloodBladeItem;
import two.item.ItemsTwo;
import two.item.SickleItem;

@ObjectHolder("two")
public class EnchantmentsTwo {
	public static final Enchantment SWIPING = register("swiping", new SwipingEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlotType.MAINHAND));
	public static final Enchantment DISABLER = register("disabler", new DisablerEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlotType.MAINHAND));
	public static final Enchantment VITALITY_THIEF = register("vitality_thief", new VitalityThiefEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	public static final Enchantment DISTANCE = register("distance", new DistanceEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));
	public static final Enchantment BOUNDING = register("bounding", new BoundingEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.FEET));
	public static final Enchantment GENTLE_DESCENT = register("gentle_descent", new GentleDescentEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.HEAD));
	
	public static final Enchantment FLIMSINESS_CURSE = register("flimsiness_curse", new FlimsinessCurseEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlotType.MAINHAND));
	public static final Enchantment CLUMSINESS_CURSE = register("clumsiness_curse", new ClumsinessCurseEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlotType.MAINHAND));
	public static final Enchantment BACKFIRE_CURSE = register("backfire_curse", new BackfireCurseEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));
	public static final Enchantment HEAVINESS_CURSE = register("heaviness_curse", new HeavinessCurseEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET));
	
	public static final Enchantment FIRE_ABILITY = register("fire_ability", new FireAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	public static final Enchantment LIGHTNING_ABILITY = register("lightning_ability", new LightningAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	public static final Enchantment GRASS_ABILITY = register("grass_ability", new GrassAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	public static final Enchantment NETHER_ABILITY = register("nether_ability", new NetherAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	public static final Enchantment WIND_ABILITY = register("wind_ability", new WindAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	public static final Enchantment ICE_ABILITY = register("ice_ability", new IceAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));

	// electricity
	// evoking
	// conjuring
	// something for shields and bucklers
	// crossbow enchantments for arbalest
	// bow enchantments for longbow
	
	public static void onEnchantmentsRegistry(final RegistryEvent.Register<Enchantment> enchantmentRegistryEvent) {
		enchantmentRegistryEvent.getRegistry().registerAll(Holder.ENCHANTMENTSTWO.toArray(new Enchantment [] {}));
	}
	private static Enchantment register(String key, Enchantment enchantment) {
		Holder.ENCHANTMENTSTWO.add(enchantment.setRegistryName(key));
		return enchantment;
	}
	public static class Holder {
		public static final LinkedList<Enchantment> ENCHANTMENTSTWO = new LinkedList<Enchantment>();
	
		public static final EnchantmentType DOUBLE_JUMP_BOOTS = EnchantmentType.create("double_jump_boots", item -> item.asItem() == ItemsTwo.DOUBLE_JUMP_BOOTS);
		public static final EnchantmentType SICKLE = EnchantmentType.create("sickle", item -> item.asItem() instanceof SickleItem);
		public static final EnchantmentType BLOOD_BLADE = EnchantmentType.create("blood_blade", item -> item.asItem() instanceof BloodBladeItem);
		public static final EnchantmentType BANISHER = EnchantmentType.create("banisher", item -> item.asItem() == ItemsTwo.BANISHER);
		public static final EnchantmentType HERMES_HELMET = EnchantmentType.create("hermes_helmet", item -> item.asItem() == ItemsTwo.HERMES_HELMET);
	}
}

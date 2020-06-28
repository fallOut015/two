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
	public static final Enchantment BOUNDING = register("bounding", new BoundingEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.FEET));
	public static final Enchantment SWIPING = register("swiping", new SwipingEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlotType.MAINHAND));
	public static final Enchantment VITALITY_THIEF = register("vitality_thief", new VitalityThiefEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	public static final Enchantment FIRE_ABILITY = register("fire_ability", new FireAbilityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
	//	public static final Enchantment DISTANCE = register("distance", new DistanceEnchantment());
	//	public static final Enchantment GENTLE_DESCENT;
	// disabler
	// backfire curse
	// clumsiness curse
	// flimsiness curse
	// heaviness curse
	// lightning ability
	// fire ability (pyro)
	// grass ability (vines)
	// nether ability
	// wind ability (tornado)
	// ice ability (chill)
	// electricity
	// evoking
	// conjuring
	// something for shields and bucklers
	// crossbow enchantments for arbalest
	
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
	}
}

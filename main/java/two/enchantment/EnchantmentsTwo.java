package two.enchantment;

import java.util.LinkedList;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import two.item.ItemsTwo;
import two.item.SickleItem;

@ObjectHolder("two")
public class EnchantmentsTwo {
	public static final Enchantment BOUNDING = register("bounding", new BoundingEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.FEET));
	public static final Enchantment SWIPING = register("swiping", new SwipingEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlotType.MAINHAND));
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
	// vitality thief
	// distance
	// electricity
	// evoking
	// conjuring
	// gentle descent
	
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
	}
}

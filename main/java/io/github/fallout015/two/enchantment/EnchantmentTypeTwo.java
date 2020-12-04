package io.github.fallout015.two.enchantment;

import io.github.fallout015.two.item.BloodBladeItem;
import io.github.fallout015.two.item.DaggerItem;
import io.github.fallout015.two.item.ItemsTwo;
import io.github.fallout015.two.item.SickleItem;
import net.minecraft.enchantment.EnchantmentType;

public class EnchantmentTypeTwo {
	public static final EnchantmentType DOUBLE_JUMP_BOOTS = EnchantmentType.create("double_jump_boots", item -> item.asItem() == ItemsTwo.DOUBLE_JUMP_BOOTS);
	public static final EnchantmentType SICKLE = EnchantmentType.create("sickle", item -> item.asItem() instanceof SickleItem);
	public static final EnchantmentType DAGGER = EnchantmentType.create("dagger", item -> item.asItem() instanceof DaggerItem);
	public static final EnchantmentType BLOOD_BLADE = EnchantmentType.create("blood_blade", item -> item.asItem() instanceof BloodBladeItem);
	public static final EnchantmentType EVOCATION_STAFF = EnchantmentType.create("evocation_staff", item -> item.asItem() == ItemsTwo.EVOCATION_STAFF);
	public static final EnchantmentType BANISHER = EnchantmentType.create("banisher", item -> item.asItem() == ItemsTwo.BANISHER);
	public static final EnchantmentType HERMES_HELMET = EnchantmentType.create("hermes_helmet", item -> item.asItem() == ItemsTwo.HERMES_HELMET);
	public static final EnchantmentType SLIME_BOOTS = EnchantmentType.create("slime_boots", item -> item.asItem() == ItemsTwo.SLIME_BOOTS);
}
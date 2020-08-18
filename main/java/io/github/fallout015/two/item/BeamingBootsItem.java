package io.github.fallout015.two.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class BeamingBootsItem extends ArmorItem {
	public BeamingBootsItem(Properties builder) {
		super(ArmorMaterialTwo.BEAMING_BOOTS, EquipmentSlotType.FEET, builder);
	}
}
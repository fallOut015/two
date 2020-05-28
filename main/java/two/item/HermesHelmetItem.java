package two.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class HermesHelmetItem extends ArmorItem {
	public HermesHelmetItem(Properties builder) {
		super(ArmorMaterialTwo.HERMES_HELMET, EquipmentSlotType.HEAD, builder);
	}
}
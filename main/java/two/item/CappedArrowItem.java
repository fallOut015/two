package two.item;

import com.google.common.collect.Multimap;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.world.World;
import two.entity.SharedMonsterAttributesTwo;
import two.entity.projectile.CappedArrowEntity;

public class CappedArrowItem extends ArrowItem {
	private IItemTier tier;

	public CappedArrowItem(IItemTier tier, Properties builder) {
		super(builder);
		this.tier = tier;
	}
	
	public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, shooter);
		cappedarrowentity.setItemTier(this.tier);
		return cappedarrowentity;
	}
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		@SuppressWarnings("deprecation")
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
		if (equipmentSlot == EquipmentSlotType.MAINHAND) {
		    multimap.put(SharedMonsterAttributesTwo.PROJECTILE_VELOCITY_ATTRIBUTE.getName(), new AttributeModifier(SharedMonsterAttributesTwo.PROJECTILE_VELOCITY_ID, "Weapon modifier", ((double) this.tier.getEfficiency() / (double) ItemTier.IRON.getEfficiency()), AttributeModifier.Operation.MULTIPLY_BASE));
		}

		return multimap;
	}
}
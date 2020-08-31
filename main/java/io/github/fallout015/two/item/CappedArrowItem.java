package io.github.fallout015.two.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import io.github.fallout015.two.entity.projectile.CappedArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CappedArrowItem extends ArrowItem {
	private IItemTier tier;
	private final Multimap<Attribute, AttributeModifier> modifiers;

	public CappedArrowItem(IItemTier tier, Properties properties) {
		super(properties);
		this.tier = tier;
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
//	    builder.put(Attributes.field_233825_h_, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)attackSpeedIn, AttributeModifier.Operation.ADDITION));
	    this.modifiers = builder.build();
	}
	
	public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, shooter);
		cappedarrowentity.setItemTier(this.tier);
		return cappedarrowentity;
	}
	@SuppressWarnings("deprecation")
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		return equipmentSlot == EquipmentSlotType.MAINHAND ? this.modifiers : super.getAttributeModifiers(equipmentSlot);
	}
}
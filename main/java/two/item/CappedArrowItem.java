package two.item;

import com.google.common.collect.Multimap;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
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
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.tier.getAttackDamage(), AttributeModifier.Operation.ADDITION));
		    multimap.put(SharedMonsterAttributesTwo.PROJECTILE_VELOCITY.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.tier.getEfficiency(), AttributeModifier.Operation.ADDITION));
		}

		return multimap;
	}
}
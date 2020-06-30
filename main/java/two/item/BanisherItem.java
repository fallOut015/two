package two.item;

import java.util.List;

import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import two.enchantment.EnchantmentsTwo;

public class BanisherItem extends Item {
	private final float attackDamage;
	private final float attackSpeed;	
	
	public BanisherItem(Properties properties) {
		super(properties);
		
		this.attackDamage = 1.0f;
		this.attackSpeed = -3.0f;
	}
	
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if(attacker instanceof PlayerEntity) {
//			if(((PlayerEntity) attacker).getCooledAttackStrength(0) == 0.0f) {
			if(this.getPropertyGetter(new ResourceLocation("minecraft", "cooldown")).call(stack, attacker.getEntityWorld(), attacker) == 0.0f) {
				target.knockBack(target, 2 * (EnchantmentHelper.getEnchantmentLevel(EnchantmentsTwo.DISTANCE, stack) + 1), -(target.prevPosX - attacker.prevPosX), -(target.prevPosZ - attacker.prevPosZ));
				target.world.addParticle(ParticleTypes.EXPLOSION, target.prevPosX, target.prevPosY, target.prevPosZ, -(target.prevPosX - attacker.prevPosX), -0.1, -(target.prevPosZ - attacker.prevPosZ));
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("This mighty hammer can send a foe a miles, given the proper enchantments.").applyTextStyle(TextFormatting.ITALIC));
	}
	@SuppressWarnings("deprecation")
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
		if (equipmentSlot == EquipmentSlotType.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.attackSpeed, AttributeModifier.Operation.ADDITION));
		}
		return multimap;
	}
}
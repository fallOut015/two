package io.github.fallout015.two.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;

import io.github.fallout015.two.enchantment.EnchantmentsTwo;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BanisherItem extends Item implements IVanishable {
	private final float attackDamage;
	private final Multimap<Attribute, AttributeModifier> modifiers;

	public BanisherItem(Properties properties) {
		super(properties);
		this.attackDamage = 0f;
		float attackSpeedIn = -3.5f;
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
	    builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
	    builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)attackSpeedIn, AttributeModifier.Operation.ADDITION));
	    this.modifiers = builder.build();
	}
	
	@Override
	public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		return !player.isCreative();
	}
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damageItem(1, attacker, livingEntityIn -> livingEntityIn.sendBreakAnimation(EquipmentSlotType.MAINHAND));
		return true;
	}
	@SuppressWarnings("deprecation")
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		return equipmentSlot == EquipmentSlotType.MAINHAND ? this.modifiers : super.getAttributeModifiers(equipmentSlot);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
		if(entity instanceof LivingEntity) {
			stack.hitEntity((LivingEntity) entity, player);
			if((player).getCooledAttackStrength(0.5f) == 1f) {
				((LivingEntity) entity).applyKnockback(2 * (EnchantmentHelper.getEnchantmentLevel(EnchantmentsTwo.DISTANCE.get(), stack) + 1), -(entity.prevPosX - player.prevPosX), -(entity.prevPosZ - player.prevPosZ));
				entity.world.addParticle(ParticleTypes.EXPLOSION, entity.getPosX(), entity.getPosY(), entity.getPosZ(), -(entity.prevPosX - player.prevPosX), -0.1, -(entity.prevPosZ - player.prevPosZ));
				stack.damageItem(4, player, livingEntityIn -> livingEntityIn.sendBreakAnimation(EquipmentSlotType.MAINHAND));
				return true;
			}
		}
		return false;
	}
}
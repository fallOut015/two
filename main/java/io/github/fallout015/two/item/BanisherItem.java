package io.github.fallout015.two.item;

import com.google.common.collect.Multimap;

import io.github.fallout015.two.enchantment.EnchantmentsTwo;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BanisherItem extends Item {
	private final float attackDamage;
	private final float attackSpeed;	
	
	public BanisherItem(Properties properties) {
		super(properties);
		
		this.attackDamage = 0.5f;
		this.attackSpeed = -3.5f;
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
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
		if (equipmentSlot == EquipmentSlotType.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.attackSpeed, AttributeModifier.Operation.ADDITION));
		}
		return multimap;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
		if(entity instanceof LivingEntity) {
			stack.hitEntity((LivingEntity) entity, player);
			if((player).getCooledAttackStrength(0.5f) == 1f) {
				((LivingEntity) entity).knockBack(entity, 2 * (EnchantmentHelper.getEnchantmentLevel(EnchantmentsTwo.DISTANCE, stack) + 1), -(entity.prevPosX - player.prevPosX), -(entity.prevPosZ - player.prevPosZ));
				entity.world.addParticle(ParticleTypes.EXPLOSION, player.getPosX(), player.getPosY(), entity.getPosZ(), -(entity.prevPosX - player.prevPosX), -0.1, -(entity.prevPosZ - player.prevPosZ));
				stack.damageItem(4, player, livingEntityIn -> livingEntityIn.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			}		
		}
		return false;
	}
}
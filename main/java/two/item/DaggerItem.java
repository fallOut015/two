package two.item;

import com.google.common.collect.Multimap;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import two.enchantment.EnchantmentsTwo;

public class DaggerItem extends TieredItem {
	private final float attackDamage;
	private final float attackSpeed;

	public DaggerItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, builder);
		this.attackSpeed = attackSpeedIn;
	    this.attackDamage = (float)attackDamageIn + tier.getAttackDamage();
	}
	
	public float getAttackDamage() {
	    return this.attackDamage;
	}
	public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		return !player.isCreative();
	}
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damageItem(1, attacker, player ->
			player.sendBreakAnimation(EquipmentSlotType.MAINHAND)
	    );
		
	    return true;
	}
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
		if(EnchantmentHelper.getEnchantmentLevel(EnchantmentsTwo.DISARMING, stack) > 0 && playerIn.getPositionVec().distanceTo(target.getPositionVec()) < 1.41421356237) {
			if(target.entityDropItem(target.getHeldItem(hand)) == null) {
				return false;
			}
			target.setHeldItem(hand, ItemStack.EMPTY);
			return true;
		}
		
		return false;
	}
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
		if(state.getBlockHardness(worldIn, pos) != 0.0F) {
			stack.damageItem(2, entityLiving, player ->
				player.sendBreakAnimation(EquipmentSlotType.MAINHAND)
			);
		}

	    return true;
	}
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		@SuppressWarnings("deprecation")
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
			if(player.isCrouching()) {
				((LivingEntity) entity).setHealth(((LivingEntity) entity).getHealth() - 1);
				((LivingEntity) entity).setMotion(0, 0.5, 0);
				for(int i = 0; i < ((LivingEntity) entity).getHealth(); ++ i)
					entity.getEntityWorld().addParticle(ParticleTypes.CRIT, entity.getPosX(), entity.getPosY() + entity.getHeight() / 2, entity.getPosZ(), Math.random() - 0.5D, 0.0D, Math.random() - 0.5D);
			}
		}
		return false;
	}
}
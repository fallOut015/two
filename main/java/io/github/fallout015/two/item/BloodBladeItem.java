package io.github.fallout015.two.item;

import java.util.List;

import io.github.fallout015.two.Two;
import io.github.fallout015.two.enchantment.EnchantmentsTwo;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public abstract class BloodBladeItem extends SwordItem {
	public BloodBladeItem(Properties builder) {
		this(builder, false);
	}
	public BloodBladeItem(Properties builder, boolean texture) {
		super(ItemTierTwo.BLOOD_BLADE, 3, -2.4f, builder);
		
		if(texture) {
			ItemModelsProperties.func_239418_a_(this, new ResourceLocation("two", "pam_texture"), (itemStack, clientWorld,livingEntity) -> {
				return Two.Config.pamTextureBloodBlade ? 1F : 0F;
			});
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		float xp = stack.getTag().getFloat("xp");
		int level = stack.getTag().getInt("level");
		
		tooltip.add(new StringTextComponent("XP: " + xp + " / " + Math.pow(1.45, stack.getTag().getInt("level"))));
		tooltip.add(new StringTextComponent("Level: " + level));
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if(playerIn.getActiveItemStack().hasTag()) {
			playerIn.getActiveItemStack().getTag().putFloat("xp", 0.1f);
			playerIn.getActiveItemStack().getTag().putInt("level", 10);
		} else {
			Two.LOGGER.info("No tag!");
		}
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
		if(entity instanceof LivingEntity) {
			stack.hitEntity((LivingEntity) entity, player);
			if((player).getCooledAttackStrength(0.5f) == 1f) {
				this.bonusEffect(stack, (LivingEntity) entity, player);

				if(EnchantmentHelper.getEnchantmentLevel(EnchantmentsTwo.VITALITY_THIEF, stack) > 0) {
					player.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 1, EnchantmentHelper.getEnchantmentLevel(EnchantmentsTwo.VITALITY_THIEF, stack), false, false));
				}
			}
			
			CompoundNBT nbt;
			if(player.getActiveItemStack().hasTag()) {
				nbt = player.getActiveItemStack().getTag();
			} else {
				nbt = new CompoundNBT();
				nbt.putFloat("xp", 0.1f);
				nbt.putInt("level", 0);
			}
			
			nbt.putFloat("xp", (float) (nbt.getFloat("xp") + Math.sqrt(stack.getDamage())));
			if(nbt.getFloat("xp") >= Math.pow(1.45, nbt.getInt("level"))) {
				nbt.putInt("level", nbt.getInt("level") + 1);
				nbt.putFloat("xp", 0);
			}
			
			player.getActiveItemStack().setTag(nbt);
		}
		return false;
	}

	public abstract void bonusEffect(ItemStack stack, LivingEntity target, LivingEntity attacker);
}
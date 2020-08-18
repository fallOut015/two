package io.github.fallout015.two.item;

import io.github.fallout015.two.entity.projectile.ShurikenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ShurikenItem extends Item {
	public ShurikenItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
		if (!worldIn.isRemote) {
			ShurikenEntity shurikenentity = new ShurikenEntity(playerIn, worldIn);
			shurikenentity.setItem(itemstack);
			shurikenentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 0.0F);
			worldIn.addEntity(shurikenentity);
		}

		playerIn.addStat(Stats.ITEM_USED.get(this));
		if (!playerIn.abilities.isCreativeMode) {
			itemstack.shrink(1);
		}
		
		playerIn.getCooldownTracker().setCooldown(this, 5);

		return ActionResult.resultSuccess(itemstack);
	}
}
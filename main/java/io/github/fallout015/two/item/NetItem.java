package io.github.fallout015.two.item;

import java.util.List;

import io.github.fallout015.two.entity.EntityTypeTwo;
import io.github.fallout015.two.entity.effect.ButterflyEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceContext.FluidMode;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class NetItem extends Item {
	public NetItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if(playerIn.getHeldItem(handIn).getOrCreateTag().contains("ButterflyEntity") && worldIn instanceof ServerWorld) {
			ButterflyEntity butterfly = EntityTypeTwo.BUTTERFLY.create((ServerWorld) worldIn, (CompoundNBT) playerIn.getHeldItem(handIn).getOrCreateTag().get("ButterflyEntity"), null, playerIn, rayTrace(worldIn, playerIn, FluidMode.ANY).getPos(), SpawnReason.EVENT, false, false);
			butterfly.setVariant(((CompoundNBT) playerIn.getHeldItem(handIn).getOrCreateTag().get("ButterflyEntity")).getInt("VARIANT"));
			playerIn.getHeldItem(handIn).getOrCreateTag().remove("ButterflyEntity");
			worldIn.addEntity(butterfly);
			
			return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
		}
		
		return ActionResult.resultPass(playerIn.getHeldItem(handIn));
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if(stack.getOrCreateTag().contains("ButterflyEntity")) {
			String variant = ButterflyEntity.VARIANTS[((CompoundNBT) stack.getOrCreateTag().get("ButterflyEntity")).getInt("VARIANT")];
			tooltip.add(new TranslationTextComponent(variant).mergeStyle(TextFormatting.ITALIC, TextFormatting.YELLOW));			
		}
		
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		if(stack.getOrCreateTag().contains("ButterflyEntity")) {
			return new TranslationTextComponent("item.two.net.used");
		} else {
			return super.getDisplayName(stack);			
		}
	}
}
package two.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import two.Two;

public abstract class BloodBladeItem extends SwordItem {
	public BloodBladeItem(Properties builder) {
		super(ItemTierTwo.BLOOD_BLADE, 3, -2.4f, builder);
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
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		this.bonusEffect(stack, target, attacker);
		
		CompoundNBT nbt;
		if(attacker.getActiveItemStack().hasTag()) {
			nbt = attacker.getActiveItemStack().getTag();
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
		
		attacker.getActiveItemStack().setTag(nbt);
		
		return true;
	}

	public abstract void bonusEffect(ItemStack stack, LivingEntity target, LivingEntity attacker);
}
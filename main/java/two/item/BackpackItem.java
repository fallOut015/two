package two.item;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BackpackItem extends Item {
	public BackpackItem(Properties properties) {
		super(properties);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
	    EquipmentSlotType equipmentslottype = MobEntity.getSlotForItemStack(itemstack);
	    ItemStack itemstack1 = playerIn.getItemStackFromSlot(equipmentslottype);
	    if (itemstack1.isEmpty()) {
	    	playerIn.setItemStackToSlot(equipmentslottype, itemstack.copy());
	        itemstack.setCount(0);
	        return ActionResult.func_226248_a_(itemstack);
	    } else {
	    	return ActionResult.func_226251_d_(itemstack);
	    }
	}
}
package two.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class CraftingBookItem extends Item {
	WorkbenchContainer workbenchContainer;
	
	public CraftingBookItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemStack = playerIn.getHeldItem(handIn);
		
		workbenchContainer = new WorkbenchContainer(0, playerIn.inventory);
		
		IInventory craftingInventory = (new CraftingInventory(this.workbenchContainer, 3, 3));
		playerIn.openContainer()
		playerIn.addStat(Stats.ITEM_USED.get(this));
		
		return ActionResult.func_226248_a_(itemStack);
	}
}
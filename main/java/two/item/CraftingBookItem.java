package two.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class CraftingBookItem extends Item {
	private static final ITextComponent CONTAINER_CRAFTING = new TranslationTextComponent("container.crafting");
	   
	public CraftingBookItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemStack = playerIn.getHeldItem(handIn);
		
		INamedContainerProvider craftingContainer = new SimpleNamedContainerProvider((id, playerInventory, playerEntity) -> {
			return new WorkbenchContainer(id, playerInventory);
		}, CONTAINER_CRAFTING);
		//IInventory craftingInventory = (new CraftingInventory(craftingContainer.createMenu(0, playerIn.inventory, playerIn), 3, 3));
		
		playerIn.openContainer(craftingContainer);
		playerIn.addStat(Stats.ITEM_USED.get(this));
		
		return ActionResult.func_226248_a_(itemStack);
	}
}
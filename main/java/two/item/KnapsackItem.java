package two.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import two.inventory.KnapsackInventory;

public class KnapsackItem extends AbstractContainerItem {
	public KnapsackItem(Properties properties) {
		super(properties);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemStack = playerIn.getHeldItem(handIn);
		
		INamedContainerProvider knapsackContainer = new KnapsackInventory(playerIn, itemStack);
		playerIn.openContainer(knapsackContainer);
		playerIn.addStat(Stats.ITEM_USED.get(this));
		
		return ActionResult.func_226248_a_(itemStack);
	}
}
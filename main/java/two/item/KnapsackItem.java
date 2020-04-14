package two.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import two.Two;
import two.inventory.KnapsackInventory;

public class KnapsackItem extends Item {
	private boolean open;
	public KnapsackItem(Properties properties) {
		super(properties);
		this.open = false;
		this.addPropertyOverride(new ResourceLocation("open"), (itemStack, world, livingEntity) -> {
			//Two.LOGGER.info("is livingEntity null? " + livingEntity == null);
			if(livingEntity == null) {
				Two.LOGGER.info("living entity is null");
				return 0.0f;
			}
			if(livingEntity.getActiveItemStack().getItem() instanceof KnapsackItem) {
				Two.LOGGER.info("living entity's itemstack is a knapsack item");
				if(((KnapsackItem) itemStack.getItem()).isOpen()) {
					Two.LOGGER.info("knapsack is open, returning true for 'open'");
					return 1.0f;
				}
			}
			return 0.0f;
		});
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemStack = playerIn.getHeldItem(handIn);
		
		INamedContainerProvider knapsackContainerProvider = new KnapsackInventory(playerIn, itemStack);
		playerIn.openContainer(knapsackContainerProvider);
		playerIn.addStat(Stats.ITEM_USED.get(this));
		
		return ActionResult.func_226248_a_(itemStack);
	}
	public void setOpen() {
		this.open = true;
	}
	public void setClosed() {
		this.open = false;
	}
	public boolean isOpen() {
		return this.open;
	}
}
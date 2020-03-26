package two.inventory.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.Two;
import two.inventory.KnapsackContainerProvider;

public class KnapsackContainer extends Container {
	private final IInventory knapsackInventory;
	private final int numRows;
	public CompoundNBT compoundNBT;
	
	public KnapsackContainer(int windowId, PlayerInventory player) {
		this(windowId, player, new KnapsackContainerProvider(player.player, ItemStack.EMPTY), 2);
	}
	public KnapsackContainer(int id, PlayerInventory playerInventoryIn, IInventory knapsackInventory, int rows) {
		super(ContainerTypeTwo.KNAPSACK, id);
		assertInventorySize(knapsackInventory, rows * 9);
	    this.knapsackInventory = knapsackInventory;
	    this.numRows = rows;
	    this.compoundNBT = new CompoundNBT();
	    Two.LOGGER.info("Created a new CompoundNBT (and a new container!)");
	    knapsackInventory.openInventory(playerInventoryIn.player);
	    
	    int i = (this.numRows - 4) * 18;
	    for(int j = 0; j < this.numRows; ++j)
	    	for(int k = 0; k < 9; ++k)
	    		this.addSlot(new Slot(knapsackInventory, k + j * 9, 8 + k * 18, 18 + j * 18));
	    for(int l = 0; l < 3; ++l)
	    	for(int j1 = 0; j1 < 9; ++j1)
	    		this.addSlot(new Slot(playerInventoryIn, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
	    for(int i1 = 0; i1 < 9; ++i1)
	    	this.addSlot(new Slot(playerInventoryIn, i1, 8 + i1 * 18, 161 + i));
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		Two.LOGGER.info("player can " + (this.knapsackInventory.isUsableByPlayer(playerIn) ? "" : "NOT ") + "interact with the knapsack.");
		return this.knapsackInventory.isUsableByPlayer(playerIn);
	}
	
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
	    Slot slot = this.inventorySlots.get(index);
	    if (slot != null && slot.getHasStack()) {
	    	ItemStack itemstack1 = slot.getStack();
	        itemstack = itemstack1.copy();
	        if (index < this.knapsackInventory.getSizeInventory())
	        	if (!this.mergeItemStack(itemstack1, this.knapsackInventory.getSizeInventory(), this.inventorySlots.size(), true))
	        		return ItemStack.EMPTY;
	        else if (!this.mergeItemStack(itemstack1, 0, this.knapsackInventory.getSizeInventory(), false))
	            return ItemStack.EMPTY;

	        if (itemstack1.isEmpty())
	        	slot.putStack(ItemStack.EMPTY);
	        else
	            slot.onSlotChanged();
	    }
	    return itemstack;
	}
	public void onContainerClosed(PlayerEntity playerIn) {
		super.onContainerClosed(playerIn);
		
	    Two.LOGGER.info("closing container.");
		
		this.compoundNBT = ((KnapsackContainerProvider) this.knapsackInventory).write(this.compoundNBT);
		((KnapsackContainerProvider) this.knapsackInventory).itemStack.setTag(this.compoundNBT);
		
	    this.knapsackInventory.closeInventory(playerIn);
	}
	public IInventory getKnapsackInventory() {
		return this.knapsackInventory;
	}
	@OnlyIn(Dist.CLIENT)
	public int getNumRows() {
		return this.numRows;
	}
}

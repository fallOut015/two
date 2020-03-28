package two.inventory.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import two.Two;
import two.inventory.KnapsackContainerProvider;

public class KnapsackContainer extends Container {
	private final IInventory knapsackInventory;
	public CompoundNBT compoundNBT;
	
	public KnapsackContainer(int windowId, PlayerInventory player) {
		this(windowId, player, new KnapsackContainerProvider(player.player, ItemStack.EMPTY));
	}
	public KnapsackContainer(int id, PlayerInventory playerInventoryIn, IInventory knapsackInventory) {
		super(ContainerTypeTwo.KNAPSACK, id);
		assertInventorySize(knapsackInventory, 18);
	    this.knapsackInventory = knapsackInventory;
	    this.compoundNBT = new CompoundNBT();
	    Two.LOGGER.info("Created a new CompoundNBT (and a new container!)");
	    knapsackInventory.openInventory(playerInventoryIn.player);
	    
	    /*int i = (this.numRows - 4) * 18;
	    for(int j = 0; j < this.numRows; ++j)
	    	for(int k = 0; k < 9; ++k)
	    		this.addSlot(new Slot(knapsackInventory, k + j * 9, 8 + k * 18, 18 + j * 18));
	    for(int l = 0; l < 3; ++l)
	    	for(int j1 = 0; j1 < 9; ++j1)
	    		this.addSlot(new Slot(playerInventoryIn, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
	    for(int i1 = 0; i1 < 9; ++i1)
	    	this.addSlot(new Slot(playerInventoryIn, i1, 8 + i1 * 18, 161 + i));*/
	    
	    //int j = 9;
	    
	    for(int k = 0; k < 2; ++k)
	    	for(int l = 0; l < 9; ++l)
	    		this.addSlot(new Slot(knapsackInventory, l + k * 9, 8 + l * 18, 18 + k * 18));
	    for(int i1 = 0; i1 < 3; ++i1)
	    	for(int k1 = 0; k1 < 9; ++k1)
	    		this.addSlot(new Slot(playerInventoryIn, k1 + i1 * 9 + 9, 8 + k1 * 18, 84 + i1 * 18));
	    for(int j1 = 0; j1 < 9; ++j1)
	    	this.addSlot(new Slot(playerInventoryIn, j1, 8 + j1 * 18, 163));
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
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
}

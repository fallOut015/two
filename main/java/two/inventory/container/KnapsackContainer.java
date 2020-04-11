package two.inventory.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import two.inventory.KnapsackInventory;
import two.item.KnapsackItem;

public class KnapsackContainer extends Container {
	private final IInventory knapsackInventory;
	public CompoundNBT compoundNBT;
	
	public KnapsackContainer(int windowId, PlayerInventory player) {
		this(windowId, player, new KnapsackInventory(player.player, ItemStack.EMPTY));
	}
	public KnapsackContainer(int id, PlayerInventory playerInventoryIn, IInventory knapsackInventory) {
		super(ContainerTypeTwo.KNAPSACK, id);
		assertInventorySize(knapsackInventory, 18);
	    this.knapsackInventory = knapsackInventory;
	    this.compoundNBT = new CompoundNBT();
	    knapsackInventory.openInventory(playerInventoryIn.player);
	    
	    for(int j = 0; j < 2; ++j)
	    	for(int k = 0; k < 9; ++k)
	    		this.addSlot(new Slot(knapsackInventory, k + j * 9, 8 + k * 18, 18 + j * 18));

	    for(int l = 0; l < 3; ++l)
	    	for(int j1 = 0; j1 < 9; ++j1)
	            this.addSlot(new Slot(playerInventoryIn, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 - 36));

	    for(int i1 = 0; i1 < 9; ++i1)
	    	this.addSlot(new Slot(playerInventoryIn, i1, 8 + i1 * 18, 125));
	    
	    // Slot that holds knapsack is greyed out and red when hovered over.
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
	        if (index < 18) {
	        	if (!this.mergeItemStack(itemstack1, 18, this.inventorySlots.size(), true)) {
	        		return ItemStack.EMPTY;
	            }
	        } else if (!this.mergeItemStack(itemstack1, 0, 18, false))
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
		
		this.compoundNBT = ((KnapsackInventory) this.knapsackInventory).write(this.compoundNBT);
		((KnapsackInventory) this.knapsackInventory).itemStack.setTag(this.compoundNBT);
		
		if(this.knapsackInventory instanceof KnapsackInventory)
			if(((KnapsackInventory) this.knapsackInventory ).itemStack.getItem() instanceof KnapsackItem)
				((KnapsackItem) ((KnapsackInventory) this.knapsackInventory).itemStack.getItem()).setClosed();
		
	    this.knapsackInventory.closeInventory(playerIn);
	}
	public IInventory getKnapsackInventory() {
		return this.knapsackInventory;
	}
}
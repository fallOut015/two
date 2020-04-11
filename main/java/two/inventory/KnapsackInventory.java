package two.inventory;

import java.util.List;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.inventory.container.KnapsackContainer;
import two.item.KnapsackItem;

public class KnapsackInventory implements INamedContainerProvider, IInventory {
	private NonNullList<ItemStack> knapsackContents = NonNullList.withSize(18, ItemStack.EMPTY);
	private int timesChanged;
	public ItemStack itemStack;

	
	public KnapsackInventory(PlayerEntity player, ItemStack itemStack) {
		this.itemStack = itemStack;
	}
	
	public void read(CompoundNBT compound) {
	    this.loadFromNbt(compound);
	}
	public CompoundNBT write(CompoundNBT compound) {
	    return this.saveToNbt(compound);
	}
	public void loadFromNbt(CompoundNBT compound) {
		this.knapsackContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if (!compound.getList("Items", 10).isEmpty())
	    	ItemStackHelper.loadAllItems(compound, this.knapsackContents);
	}
	public CompoundNBT saveToNbt(CompoundNBT compound) {
		ItemStackHelper.saveAllItems(compound, this.knapsackContents, false);
	    return compound;
	}
	
	@Override
	public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity) {
		if(this.itemStack.hasTag())
			read(this.itemStack.getTag());
		if(this.itemStack.getItem() instanceof KnapsackItem)
			((KnapsackItem) this.itemStack.getItem()).setOpen();
		return new KnapsackContainer(id, playerInventory, this);
	}
	@Override
	public ITextComponent getDisplayName() {
		return new TranslationTextComponent("container.knapsack");
	}
	
	@Override
	public void clear() {
		this.getItems().clear();
	}
	@Override
	public int getSizeInventory() {
		return 18;
	}
	@Override
	public boolean isEmpty() {
		return this.getItems().stream().allMatch(ItemStack::isEmpty);
	}
	@Override
	public ItemStack getStackInSlot(int index) {
		List<ItemStack> list = null;
	    if (index < this.getItems().size())
	    	list = this.getItems();
	    return list == null ? ItemStack.EMPTY : list.get(index);
	}
	@Override
	public ItemStack decrStackSize(int index, int count) {
		List<ItemStack> list = null;
	    if (index < this.getItems().size())
	    	list = this.getItems();
	    return list != null && !list.get(index).isEmpty() ? ItemStackHelper.getAndSplit(list, index, count) : ItemStack.EMPTY;
	}
	@Override
	public ItemStack removeStackFromSlot(int index) {
		NonNullList<ItemStack> nonnulllist = null;
	    if (index < this.getItems().size())
	    	nonnulllist = this.getItems();
	    if (nonnulllist != null && !nonnulllist.get(index).isEmpty()) {
	    	ItemStack itemstack = nonnulllist.get(index);
	        nonnulllist.set(index, ItemStack.EMPTY);
	        return itemstack;
	    } else
	    	return ItemStack.EMPTY;
	}
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		NonNullList<ItemStack> nonnulllist = null;
	    if (index < this.getItems().size())
	    	nonnulllist = this.getItems();
	    if (nonnulllist != null)
	    	nonnulllist.set(index, stack);
	}
	@Override
	public void markDirty() {
		++this.timesChanged;
	}
	@Override
	public boolean isUsableByPlayer(PlayerEntity player) {
		return !player.world.isRemote;
	}
	
	public NonNullList<ItemStack> getItems() {
		return this.knapsackContents;
	}
	@OnlyIn(Dist.CLIENT)
	public int getTimesChanged() {
		return this.timesChanged;
	}
}

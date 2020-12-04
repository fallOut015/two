package io.github.fallout015.two.inventory.container;

import javax.annotation.Nullable;

import io.github.fallout015.two.Two;
import io.github.fallout015.two.block.BlocksTwo;
import io.github.fallout015.two.client.gui.screen.inventory.UpholsteryTableScreen;
import io.github.fallout015.two.util.SoundEventsTwo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class UpholsteryTableContainer extends Container {
	private final IWorldPosCallable worldPos;
	
	@Nullable
	private UpholsteryTableScreen.Furniture furniture = null;
	
	private Runnable update = () -> { };
	
	private final Slot slottop;
	private final Slot slotmiddle;
	private final Slot slotbottom;
	private final Slot slotoutput;
	
	private long time;
	
	private final IInventory inputs = new Inventory(3) {
		public void markDirty() {
			super.markDirty();
			UpholsteryTableContainer.this.onCraftMatrixChanged(this);
			UpholsteryTableContainer.this.update.run();
		}
	};
	
	private final IInventory outputs = new Inventory(1) {
		public void markDirty() {
			super.markDirty();
			UpholsteryTableContainer.this.update.run();
		}
	};
	
	public UpholsteryTableContainer(int id, PlayerInventory playerInventory) {
	    this(id, playerInventory, IWorldPosCallable.DUMMY);
	}
	public UpholsteryTableContainer(int id, PlayerInventory playerInventory, final IWorldPosCallable worldPosCallable) {
		super(ContainerTypeTwo.UPHOLSTERY_TABLE.get(), id);
		
		this.worldPos = worldPosCallable;
		
		this.slottop = this.addSlot(new Slot(this.inputs, 0, 23, 15) {
			public boolean isItemValid(ItemStack stack) {
				if(furniture != null) {
					return furniture.getTopPredicate().test(stack.getItem());
				}
				return false;
			}
		});
		this.slotmiddle = this.addSlot(new Slot(this.inputs, 1, 23, 33) {
			public boolean isItemValid(ItemStack stack) {
				if(furniture != null)
					return furniture.getMiddlePredicate().test(stack.getItem());
				return false;
			}
		});
		this.slotbottom = this.addSlot(new Slot(this.inputs, 2, 23, 51) {
			public boolean isItemValid(ItemStack stack) {
				if(furniture != null)
					return furniture.getBottomPredicate().test(stack.getItem());
				return false;
			}
		});
		
		this.slotoutput = this.addSlot(new Slot(this.outputs, 0, 138, 32) {
			public boolean isItemValid(ItemStack stack) {
	            return false;
			}

			public ItemStack onTake(PlayerEntity thePlayer, ItemStack stack) {
				UpholsteryTableContainer.this.slottop.decrStackSize(1);
				UpholsteryTableContainer.this.slotmiddle.decrStackSize(1);
				UpholsteryTableContainer.this.slotbottom.decrStackSize(1);
				
	            worldPosCallable.consume((worldIn, pos) -> {
	            	long l = worldIn.getGameTime();
	            	if (UpholsteryTableContainer.this.time != l) {
	            		worldIn.playSound((PlayerEntity) null, pos, SoundEventsTwo.GUI_UPHOLSTERY_TABLE_TAKE_RESULT.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
	            		UpholsteryTableContainer.this.time = l;
	            	}

	            });
	            return super.onTake(thePlayer, stack);
			}
		});
		
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(this.worldPos, playerIn, BlocksTwo.UPHOLSTERY_TABLE);
	}
	
	public boolean enchantItem(PlayerEntity playerIn, @Nullable UpholsteryTableScreen.Furniture furniture) {
		Two.LOGGER.info("enchantItem(" + playerIn + ", " + furniture + ")");
		
		if(furniture != null) {
			this.furniture = furniture;
////			this.craft();
			return true;
		}
		return false;
	}
	public void onCraftMatrixChanged(IInventory inventoryIn) {
		Two.LOGGER.info("onCraftMatrixChanged(" + inventoryIn + ")");
		
//		ItemStack top = this.slottop.getStack();
//		ItemStack middle = this.slotmiddle.getStack();
//		ItemStack bottom = this.slotbottom.getStack();
//		ItemStack output = this.slotoutput.getStack();
		
		/*if (itemstack3.isEmpty() || !itemstack.isEmpty() && !itemstack1.isEmpty() && this.intReferenceHolder.get() > 0 && !itemstack2.isEmpty()) {
			if (!itemstack2.isEmpty()) {
				CompoundNBT compoundnbt = itemstack.getOrCreateChildTag("BlockEntityTag");
	            boolean flag = compoundnbt.contains("Patterns", 9) && !itemstack.isEmpty() && compoundnbt.getList("Patterns", 10).size() >= 6;
	            if (flag) {
	            	this.intReferenceHolder.set(0);
	            } else {
	            	//this.intReferenceHolder.set(((BannerPatternItem)itemstack2.getItem()).func_219980_b().ordinal());
	            }
			}
		} else {
			this.slotOutput.putStack(ItemStack.EMPTY);
			this.intReferenceHolder.set(0);
		}*/

		this.craft();
		this.detectAndSendChanges();
	}

	@OnlyIn(Dist.CLIENT)
	public void setUpdate(Runnable update) {
		Two.LOGGER.info("setUpdate(" + update + ")");
		
		this.update = update;
	}

	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index == this.slotoutput.slotNumber) {
				if (!this.mergeItemStack(itemstack1, 4, 40, true)) {
					return ItemStack.EMPTY;
	            }

				slot.onSlotChange(itemstack1, itemstack);
			} else if (index != this.slottop.slotNumber && index != this.slotmiddle.slotNumber && index != this.slotbottom.slotNumber) {
	            /*if (PLANKS.test((BlockItem) itemstack1.getItem())) {
	            	if (!this.mergeItemStack(itemstack1, this.slotLegs.slotNumber, this.slotLegs.slotNumber + 1, false)) {
	            		return ItemStack.EMPTY;
	            	}
	            } else if (PLANKS_WOOL.test((BlockItem) itemstack1.getItem())) {
	            	if (!this.mergeItemStack(itemstack1, this.slotSeat.slotNumber, this.slotSeat.slotNumber + 1, false)) {
	            		return ItemStack.EMPTY;
	            	} else if(!this.mergeItemStack(itemstack1, this.slotBack.slotNumber, this.slotBack.slotNumber + 1, false)) {
	            		return ItemStack.EMPTY;
	            	}
	            } else if (index >= 4 && index < 31) {
	            	if (!this.mergeItemStack(itemstack1, 31, 40, false)) {
	            		return ItemStack.EMPTY;
	            	}
	            } else if (index >= 31 && index < 40 && !this.mergeItemStack(itemstack1, 4, 31, false)) {
	            	return ItemStack.EMPTY;
	            }*/
			} else if (!this.mergeItemStack(itemstack1, 4, 40, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
	            slot.putStack(ItemStack.EMPTY);
			} else {
	            slot.onSlotChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, itemstack1);
		}

		return itemstack;
	}

	public void onContainerClosed(PlayerEntity playerIn) {
		Two.LOGGER.info("container closed");
		super.onContainerClosed(playerIn);
		this.worldPos.consume((worldIn, pos) -> {
			this.clearContainer(playerIn, playerIn.world, this.inputs);
		});
	}
	
	private void craft() {
		Two.LOGGER.info("craft()");
		
		if(!this.slottop.isItemValid(this.slottop.getStack())) {
			// placeItemBackInInventory
		}
		
		ItemStack stack = ItemStack.EMPTY;
		if(this.furniture != null && this.slottop.getHasStack() && this.slotmiddle.getHasStack() && this.slotbottom.getHasStack()) {
			stack = new ItemStack(this.furniture.getItem());
			CompoundNBT nbt = new CompoundNBT();
			nbt.putString("top", this.slottop.getStack().getItem().toString());
			nbt.putString("middle", this.slotmiddle.getStack().getItem().toString());
			nbt.putString("bottom", this.slotbottom.getStack().getItem().toString());
			stack.setTag(nbt);
		}
		
		this.slotoutput.putStack(stack);
		
		// Add code for ejecting values that don't apply to the predicates when a new furniture is selected. 
	}

	@OnlyIn(Dist.CLIENT)
	public Slot top() {
		return this.slottop;
	}
	@OnlyIn(Dist.CLIENT)
	public Slot middle() {
		return this.slotmiddle;
	}
	@OnlyIn(Dist.CLIENT)
	public Slot bottom() {
		return this.slotbottom;
	}
	@OnlyIn(Dist.CLIENT)
	public Slot output() {
		return this.slotoutput;
	}
}
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
import two.inventory.KnapsackInventory;

public class KnapsackItem extends Item {
	private boolean open;
	public KnapsackItem(Properties properties) {
		super(properties);
		this.open = false;
		this.addPropertyOverride(new ResourceLocation("open"), (itemStack, world, livingEntity) -> {
			if(livingEntity != null && livingEntity.getActiveItemStack().getItem() instanceof KnapsackItem)
				if(((KnapsackItem) itemStack.getItem()).isOpen())
					return 1.0f;
			return 0.0f;
		});
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		super.onItemRightClick(worldIn, playerIn, handIn);
		
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
	
	/*@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);

		CompoundNBT compoundnbt = stack.getChildTag("BlockEntityTag");
		if (compoundnbt != null) {
			if (compoundnbt.contains("LootTable", 8)) {
				tooltip.add(new StringTextComponent("???????"));
			}

			if (compoundnbt.contains("Items", 9)) {
				NonNullList<ItemStack> nonnulllist = NonNullList.withSize(27, ItemStack.EMPTY);
	            ItemStackHelper.loadAllItems(compoundnbt, nonnulllist);
	            int i = 0;
	            int j = 0;

	            for(ItemStack itemstack : nonnulllist) {
	            	if (!itemstack.isEmpty()) {
	            		++j;
	            		if (i <= 4) {
	            			++i;
	            			ITextComponent itextcomponent = itemstack.getDisplayName().deepCopy();
	            			itextcomponent.appendText(" x").appendText(String.valueOf(itemstack.getCount()));
	            			tooltip.add(itextcomponent);
	            		}
	            	}
	            }

	            if (j - i > 0) {
	            	tooltip.add((new TranslationTextComponent("container.knapsack.more", j - i)).applyTextStyle(TextFormatting.ITALIC));
	            }
			}
		}
		
		/// TODO
		 * CUSTOM NAME STUFF AT SOME POINT
		 * SHOWING WHAT IS IN A KNAPSACK
		 * LOOTTABLE SUPPORT
		 * ANIMATION
	}*/
}
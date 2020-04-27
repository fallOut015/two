package two.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import two.block.ChairBlock;

public class ChairItem extends BlockItem {
	public ChairItem(Block blockIn, Properties builder) {
		super(blockIn, builder);
	}

	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
		/*if(this.isInGroup(group)) {
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.WHITE_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.ORANGE_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.MAGENTA_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.LIGHT_BLUE_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.YELLOW_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.LIME_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.PINK_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.GRAY_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.LIGHT_GRAY_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.CYAN_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.PURPLE_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.BLUE_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.BROWN_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.GREEN_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.RED_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
			items.add(ChairItem.from(BlocksTwo.CHAIR.getStateContainer().getBaseState().with(ChairBlock.BACK, FurnitureProperties.PlanksWool.OAK_PLANKS).with(ChairBlock.SEAT, FurnitureProperties.PlanksWool.BLACK_WOOL).with(ChairBlock.LEGS, FurnitureProperties.Planks.OAK_PLANKS)));
		}*/
	}
	
	public static ItemStack from(BlockState state) {
		ItemStack stack = ItemStack.EMPTY;
		if(state.getBlock() instanceof ChairBlock) {
			CompoundNBT nbt = new CompoundNBT();
//			nbt.putString("top", state.get(ChairBlock.BACK).toString());
//			nbt.putString("middle", state.get(ChairBlock.SEAT).toString());
//			nbt.putString("bottom", state.get(ChairBlock.LEGS).toString());
			stack.setTag(nbt);
		}
		return stack;
	}
	
	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		// Screw readable code, preserve memory. 
		return new TranslationTextComponent(this.getTranslationKey(stack));
	}
}
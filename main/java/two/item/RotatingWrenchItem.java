package two.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Rotation;

public class RotatingWrenchItem extends Item {
	public RotatingWrenchItem(Properties properties) {
		super(properties);
	}
	
	public ActionResultType onItemUse(ItemUseContext context) {
		context.getWorld().setBlockState(context.getPos(), context.getWorld().getBlockState(context.getPos()).rotate(Rotation.CLOCKWISE_90));
		
		return ActionResultType.SUCCESS;
	};
}
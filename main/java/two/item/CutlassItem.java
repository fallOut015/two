package two.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import two.util.SoundEventsTwo;

public class CutlassItem extends SwordItem {
	public CutlassItem(Properties builder) {
		super(ItemTier.IRON, 3, -2.8f, builder);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		// sound tests
		worldIn.playSound(playerIn, playerIn.getPosition(), SoundEventsTwo.MUSIC_NIGHTMARE, SoundCategory.MUSIC, 100.0f, 1.0f);
		worldIn.playSound(playerIn, playerIn.getPosition(), SoundEventsTwo.ITEM_ARMOR_EQUIP_EMERALD, SoundCategory.NEUTRAL, 100.0f, 1.0f);
		// add code for sword blocking
		return ActionResult.resultSuccess(playerIn.getActiveItemStack());
	};
}
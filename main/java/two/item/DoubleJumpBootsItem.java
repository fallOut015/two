package two.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;

public class DoubleJumpBootsItem extends ArmorItem {
	private static final int EXTRA_JUMPS = 3;
	
	public DoubleJumpBootsItem(Properties builder) {
		super(ArmorMaterialTwo.DOUBLE_JUMP_BOOTS, EquipmentSlotType.FEET, builder);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		super.onCreated(stack, worldIn, playerIn);
		
		int jumps = EXTRA_JUMPS;
//		if(stack.getEnchantmentTagList().contains(EnchantmentsTwo.BOUNDING)) {
//			jumps +=
//		}
		
		CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("extrajumplimit", jumps);
		nbt.putInt("jumps", 0);
		stack.setTag(nbt);
	}
}

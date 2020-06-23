package two.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;

public class DoubleJumpBootsItem extends ArmorItem {
	public DoubleJumpBootsItem(Properties builder) {
		super(ArmorMaterialTwo.DOUBLE_JUMP_BOOTS, EquipmentSlotType.FEET, builder);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		super.onCreated(stack, worldIn, playerIn);
		
		CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("extrajumplimit", 3);
		nbt.putInt("jumps", 0);
	}
}

package io.github.fallout015.two.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ConjurationStaffItem extends Item {
	public ConjurationStaffItem(Properties properties) {
		super(properties);
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.SPEAR;
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		/*for(int i = 0; i < 3; ++i) {
			BlockPos blockpos = (new BlockPos(playerIn)).add(-2 + playerIn.rand.nextInt(5), 1, -2 + playerIn.rand.nextInt(5));
            VexEntity vexentity = EntityType.VEX.create(playerIn.world);
            vexentity.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
            vexentity.onInitialSpawn(playerIn.world, playerIn.world.getDifficultyForLocation(blockpos), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
            vexentity.setOwner(playerIn);
            vexentity.setBoundOrigin(blockpos);
            vexentity.setLimitedLife(20 * (30 + playerIn.rand.nextInt(90)));
            playerIn.world.addEntity(vexentity);
		}*/
		
		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
	}
}
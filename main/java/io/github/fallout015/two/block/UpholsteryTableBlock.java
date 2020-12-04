package io.github.fallout015.two.block;

import io.github.fallout015.two.inventory.container.UpholsteryTableContainer;
import io.github.fallout015.two.stats.StatsTwo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class UpholsteryTableBlock extends Block {
   private static final TranslationTextComponent CONTAINER_UPHOLSTERY_TABLE = new TranslationTextComponent("container.upholstery_table");

   protected UpholsteryTableBlock(Block.Properties properties) {
      super(properties);
   }

   @Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	   if (worldIn.isRemote) {
		   return ActionResultType.SUCCESS;
	   } else {
		   player.openContainer(state.getContainer(worldIn, pos));
		   player.addStat(StatsTwo.INTERACT_WITH_UPHOLSTERY_TABLE.get().getRegistryName()); // TODO?
		   return ActionResultType.SUCCESS;
	   }
   }

   public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
      return new SimpleNamedContainerProvider((id, playerInventory, playerEntity) -> {
         return new UpholsteryTableContainer(id, playerInventory, IWorldPosCallable.of(worldIn, pos));
      }, CONTAINER_UPHOLSTERY_TABLE);
   }
}
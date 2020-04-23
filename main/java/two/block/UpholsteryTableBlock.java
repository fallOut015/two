package two.block;

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
import two.inventory.container.UpholsteryTableContainer;
import two.stats.StatsTwo;

public class UpholsteryTableBlock extends Block {
   private static final TranslationTextComponent CONTAINER_UPHOLSTERY_TABLE = new TranslationTextComponent("container.upholstery_table");

   protected UpholsteryTableBlock(Block.Properties properties) {
      super(properties);
   }

   public ActionResultType func_225533_a_(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult blockRayTraceResult) {
      if (worldIn.isRemote) {
         return ActionResultType.SUCCESS;
      } else {
         playerIn.openContainer(state.getContainer(worldIn, pos));
         playerIn.addStat(StatsTwo.INTERACT_WITH_UPHOLSTERY_TABLE);
         return ActionResultType.SUCCESS;
      }
   }

   public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
      return new SimpleNamedContainerProvider((id, playerInventory, playerEntity) -> {
         return new UpholsteryTableContainer(id, playerInventory, IWorldPosCallable.of(worldIn, pos));
      }, CONTAINER_UPHOLSTERY_TABLE);
   }
}
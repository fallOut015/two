package two.item;

import java.util.function.Function;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.ITeleporter;
import two.world.dimension.ModDimensionTwo;

public class SnowglobeItem extends Item {
	public SnowglobeItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		super.onItemRightClick(worldIn, playerIn, handIn);
		
		DimensionType frostbite = DimensionManager.registerOrGetDimension(new ResourceLocation("two", "frostbite"), ModDimensionTwo.FROSTBITE, null, false);
		playerIn.changeDimension(frostbite, new ITeleporter() {
			public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
				return repositionEntity.apply(false);
			}
		});

		playerIn.addStat(Stats.ITEM_USED.get(this));
		return ActionResult.func_226248_a_(playerIn.getHeldItem(handIn));
	}
}
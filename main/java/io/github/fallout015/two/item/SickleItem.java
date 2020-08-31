package io.github.fallout015.two.item;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import io.github.fallout015.two.enchantment.EnchantmentsTwo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;

public class SickleItem extends ToolItem {
	private static final Set<Block> effectiveBlocksIn = ImmutableSet.of(Blocks.NETHER_WART_BLOCK, Blocks.field_235374_mn_, Blocks.HAY_BLOCK, Blocks.DRIED_KELP_BLOCK, Blocks.field_235396_nb_, Blocks.field_235383_mw_, Blocks.SPONGE, Blocks.WET_SPONGE, Blocks.JUNGLE_LEAVES, Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.ACACIA_LEAVES, Blocks.BIRCH_LEAVES); // TODO change to sickle effective blocks
	private static final Set<Block> CROPS = Sets.newHashSet(Blocks.WHEAT, Blocks.CARROTS, Blocks.POTATOES);

	public SickleItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties p_i48512_5_) {
		super((float)attackDamageIn, attackSpeedIn, tier, effectiveBlocksIn, p_i48512_5_.addToolType(net.minecraftforge.common.ToolType.HOE, tier.getHarvestLevel())); // TODO add sickle
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		if(!context.getWorld().isRemote()) {
			if(CROPS.contains(context.getWorld().getBlockState(context.getPos()).getBlock())) {
				BlockState crop = context.getWorld().getBlockState(context.getPos());
				if(((CropsBlock) (crop.getBlock())).isMaxAge(crop)) {
					context.getWorld().destroyBlock(context.getPos(), false);
					context.getWorld().setBlockState(context.getPos(), crop.with(CropsBlock.AGE, 0));
					
					context.getItem().damageItem(1, context.getPlayer(), playerEntity -> playerEntity.sendBreakAnimation(context.getHand() == Hand.MAIN_HAND ? EquipmentSlotType.MAINHAND : EquipmentSlotType.OFFHAND));
					
					int extrareach = (EnchantmentHelper.getEnchantmentLevel(EnchantmentsTwo.SWIPING, context.getItem()));
					
					BlockPos topleft = new BlockPos(context.getPos().north().west().getX() - extrareach, context.getPos().north().west().getY(), context.getPos().north().west().getZ() - extrareach);
					BlockPos bottomright = new BlockPos(context.getPos().south().east().getX() + extrareach, context.getPos().south().east().getY(), context.getPos().south().east().getZ() + extrareach);
					
					for(BlockPos blockPos : BlockPos.getAllInBoxMutable(topleft, bottomright)) {
						if(CROPS.contains(context.getWorld().getBlockState(blockPos).getBlock())) {
							crop = context.getWorld().getBlockState(blockPos);
							if(((CropsBlock) (crop.getBlock())).isMaxAge(crop)) {
								context.getWorld().destroyBlock(blockPos, false);
								context.getWorld().setBlockState(blockPos, crop.with(CropsBlock.AGE, 0));

								context.getItem().damageItem(1, context.getPlayer(), playerEntity -> playerEntity.sendBreakAnimation(context.getHand() == Hand.MAIN_HAND ? EquipmentSlotType.MAINHAND : EquipmentSlotType.OFFHAND));
							}
						}
					}
				}
			}
		}
				
		return super.onItemUse(context);
	}
}
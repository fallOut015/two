package two.item;

import java.util.Set;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.TieredItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;

public class SickleItem extends TieredItem {
	private final float speed;
	private static final Set<Block> CROPS = Sets.newHashSet(Blocks.WHEAT, Blocks.CARROTS, Blocks.POTATOES, Blocks.BEETROOTS);

	public SickleItem(IItemTier tierIn, float attackSpeedIn, Properties builder) {
		super(tierIn, builder);
		this.speed = attackSpeedIn;
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		if(CROPS.contains(context.getWorld().getBlockState(context.getPos()).getBlock())) {
			BlockState crop = context.getWorld().getBlockState(context.getPos());
			if(((CropsBlock) (crop.getBlock())).isMaxAge(crop)) {
				context.getWorld().destroyBlock(context.getPos(), true);
				context.getWorld().setBlockState(context.getPos(), crop.with(CropsBlock.AGE, 0));
				
				context.getItem().damageItem(1, context.getPlayer(), playerEntity -> playerEntity.sendBreakAnimation(context.getHand() == Hand.MAIN_HAND ? EquipmentSlotType.MAINHAND : EquipmentSlotType.OFFHAND));
				
				for(BlockPos blockPos : BlockPos.getAllInBoxMutable(context.getPos().north().west(), context.getPos().south().east())) {
					if(CROPS.contains(context.getWorld().getBlockState(blockPos).getBlock())) {
						crop = context.getWorld().getBlockState(blockPos);
						if(((CropsBlock) (crop.getBlock())).isMaxAge(crop)) {
							context.getWorld().destroyBlock(blockPos, true);
							context.getWorld().setBlockState(blockPos, crop.with(CropsBlock.AGE, 0));

							context.getItem().damageItem(1, context.getPlayer(), playerEntity -> playerEntity.sendBreakAnimation(context.getHand() == Hand.MAIN_HAND ? EquipmentSlotType.MAINHAND : EquipmentSlotType.OFFHAND));
						}
					}
				}
			}
		}
				
		return super.onItemUse(context);
	}
	
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		//stack.damageItem(1, attacker);
		return true;
	}
	
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		@SuppressWarnings("deprecation")
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
		if (equipmentSlot == EquipmentSlotType.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 0.0D, AttributeModifier.Operation.ADDITION));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.speed, AttributeModifier.Operation.ADDITION));
		}
		return multimap;
	}
}
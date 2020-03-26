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
			if(((CropsBlock)(crop.getBlock())).isMaxAge(crop)) {
				context.getWorld().destroyBlock(context.getPos(), false);
				context.getWorld().setBlockState(context.getPos(), crop.with(CropsBlock.AGE, 0));
				
				//context.getItem().damageItem(1, context.getPlayer());
				
				//if(!context.getWorld().isRemote) context.getWorld().spawnEntity(new ItemEntity(context.getWorld(), context.getPos().getX(), context.getPos().getY(), context.getPos().getZ(), new ItemStack(((CropsBlock)(crop.getBlock())).getItemDropped(crop, context.getWorld(), context.getPos(), 1))));
				
				if(CROPS.contains(context.getWorld().getBlockState(context.getPos().north()).getBlock())) {
					crop = context.getWorld().getBlockState(context.getPos().north());
					if(((CropsBlock)(crop.getBlock())).isMaxAge(crop)) {
						context.getWorld().destroyBlock(context.getPos().north(), false);
						context.getWorld().setBlockState(context.getPos().north(), crop.with(CropsBlock.AGE, 0));

						//context.getItem().damageItem(1, context.getPlayer());
						
						//if(!context.getWorld().isRemote) context.getWorld().spawnEntity(new EntityItem(context.getWorld(), context.getPos().getX(), context.getPos().getY(), context.getPos().getZ(), new ItemStack(((CropsBlock)(crop.getBlock())).getItemDropped(crop, context.getWorld(), context.getPos(), 1))));
					}
				}
				if(CROPS.contains(context.getWorld().getBlockState(context.getPos().east()).getBlock())) {
					crop = context.getWorld().getBlockState(context.getPos().east());
					if(((CropsBlock)(crop.getBlock())).isMaxAge(crop)) {
						context.getWorld().destroyBlock(context.getPos().east(), false);
						context.getWorld().setBlockState(context.getPos().east(), crop.with(CropsBlock.AGE, 0));

						//context.getItem().damageItem(1, context.getPlayer());

						//if(!context.getWorld().isRemote) context.getWorld().spawnEntity(new EntityItem(context.getWorld(), context.getPos().getX(), context.getPos().getY(), context.getPos().getZ(), new ItemStack(((CropsBlock)(crop.getBlock())).getItemDropped(crop, context.getWorld(), context.getPos(), 1))));
					}
				}
				if(CROPS.contains(context.getWorld().getBlockState(context.getPos().south()).getBlock())) {
					crop = context.getWorld().getBlockState(context.getPos().south());
					if(((CropsBlock)(crop.getBlock())).isMaxAge(crop)) {
						context.getWorld().destroyBlock(context.getPos().south(), false);
						context.getWorld().setBlockState(context.getPos().south(), crop.with(CropsBlock.AGE, 0));

						//context.getItem().damageItem(1, context.getPlayer());

						//if(!context.getWorld().isRemote) context.getWorld().spawnEntity(new EntityItem(context.getWorld(), context.getPos().getX(), context.getPos().getY(), context.getPos().getZ(), new ItemStack(((CropsBlock)(crop.getBlock())).getItemDropped(crop, context.getWorld(), context.getPos(), 1))));
					}
				}
				if(CROPS.contains(context.getWorld().getBlockState(context.getPos().west()).getBlock())) {
					crop = context.getWorld().getBlockState(context.getPos().west());
					if(((CropsBlock)(crop.getBlock())).isMaxAge(crop)) {
						context.getWorld().destroyBlock(context.getPos().west(), false);
						context.getWorld().setBlockState(context.getPos().west(), crop.with(CropsBlock.AGE, 0));

						//context.getItem().damageItem(1, context.getPlayer());

						//if(!context.getWorld().isRemote) context.getWorld().spawnEntity(new EntityItem(context.getWorld(), context.getPos().getX(), context.getPos().getY(), context.getPos().getZ(), new ItemStack(((CropsBlock)(crop.getBlock())).getItemDropped(crop, context.getWorld(), context.getPos(), 1))));
					}
				}
				
				if(CROPS.contains(context.getWorld().getBlockState(context.getPos().north().east()).getBlock())) {
					crop = context.getWorld().getBlockState(context.getPos().north().east());
					if(((CropsBlock)(crop.getBlock())).isMaxAge(crop)) {
						context.getWorld().destroyBlock(context.getPos().north().east(), false);
						context.getWorld().setBlockState(context.getPos().north().east(), crop.with(CropsBlock.AGE, 0));

						//context.getItem().damageItem(1, context.getPlayer());

						//if(!context.getWorld().isRemote) context.getWorld().spawnEntity(new EntityItem(context.getWorld(), context.getPos().getX(), context.getPos().getY(), context.getPos().getZ(), new ItemStack(((CropsBlock)(crop.getBlock())).getItemDropped(crop, context.getWorld(), context.getPos(), 1))));
					}
				}
				if(CROPS.contains(context.getWorld().getBlockState(context.getPos().east().south()).getBlock())) {
					crop = context.getWorld().getBlockState(context.getPos().east().south());
					if(((CropsBlock)(crop.getBlock())).isMaxAge(crop)) {
						context.getWorld().destroyBlock(context.getPos().east().south(), false);
						context.getWorld().setBlockState(context.getPos().east().south(), crop.with(CropsBlock.AGE, 0));

						//context.getItem().damageItem(1, context.getPlayer());

						//if(!context.getWorld().isRemote) context.getWorld().spawnEntity(new EntityItem(context.getWorld(), context.getPos().getX(), context.getPos().getY(), context.getPos().getZ(), new ItemStack(((CropsBlock)(crop.getBlock())).getItemDropped(crop, context.getWorld(), context.getPos(), 1))));
					}
				}
				if(CROPS.contains(context.getWorld().getBlockState(context.getPos().south().west()).getBlock())) {
					crop = context.getWorld().getBlockState(context.getPos().south().west());
					if(((CropsBlock)(crop.getBlock())).isMaxAge(crop)) {
						context.getWorld().destroyBlock(context.getPos().south().west(), false);
						context.getWorld().setBlockState(context.getPos().south().west(), crop.with(CropsBlock.AGE, 0));

						//context.getItem().damageItem(1, context.getPlayer());

						//if(!context.getWorld().isRemote) context.getWorld().spawnEntity(new EntityItem(context.getWorld(), context.getPos().getX(), context.getPos().getY(), context.getPos().getZ(), new ItemStack(((CropsBlock)(crop.getBlock())).getItemDropped(crop, context.getWorld(), context.getPos(), 1))));
					}
				}
				if(CROPS.contains(context.getWorld().getBlockState(context.getPos().west().north()).getBlock())) {
					crop = context.getWorld().getBlockState(context.getPos().west().north());
					if(((CropsBlock)(crop.getBlock())).isMaxAge(crop)) {
						context.getWorld().destroyBlock(context.getPos().west().north(), false);
						context.getWorld().setBlockState(context.getPos().west().north(), crop.with(CropsBlock.AGE, 0));

						//context.getItem().damageItem(1, context.getPlayer());

						//if(!context.getWorld().isRemote) context.getWorld().spawnEntity(new EntityItem(context.getWorld(), context.getPos().getX(), context.getPos().getY(), context.getPos().getZ(), new ItemStack(((CropsBlock)(crop.getBlock())).getItemDropped(crop, context.getWorld(), context.getPos(), 1))));
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
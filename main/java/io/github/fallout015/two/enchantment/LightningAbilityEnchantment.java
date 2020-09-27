package io.github.fallout015.two.enchantment;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceContext.FluidMode;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;

public class LightningAbilityEnchantment extends AbilityEnchantment {
	protected LightningAbilityEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
	}

	@Override
	public void action(RightClickItem playerInteractEvent$rightClickItem) {
		PlayerEntity playerIn = playerInteractEvent$rightClickItem.getPlayer();
		
		RayTraceResult result = rayTrace(playerIn.getEntityWorld(), playerIn, FluidMode.ANY);
			
		double d0 = Math.min(result.getHitVec().getY(), playerIn.getPosY());
		double d1 = Math.max(result.getHitVec().getY(), playerIn.getPosY()) + 1.0D;
		float f = (float)MathHelper.atan2(result.getHitVec().getZ() - playerIn.getPosZ(), result.getHitVec().getX() - playerIn.getPosX());

		for(int l = 2; l < 12; ++ l) {
			double d2 = 1.5D * (double)(l + 1);
			int j = 1 * l;
			this.spawnLightning(playerIn.getPosX() + (double)MathHelper.cos(f) * d2, playerIn.getPosZ() + (double)MathHelper.sin(f) * d2, d0, d1, f, j, playerIn);
		}
	}
	
	private void spawnLightning(double d1, double d3, double d5, double d7, float f9, int i10, PlayerEntity playerIn) {
        // Based off of EvokerEntity::spawnFangs
		
		BlockPos blockpos = new BlockPos(d1, d7, d3);
        boolean flag = false;
        double d0 = 0.0D;

        while(true) {
        	BlockPos blockpos1 = blockpos.down();
        	BlockState blockstate = playerIn.world.getBlockState(blockpos1);
        	if(blockstate.isSolidSide(playerIn.world, blockpos1, Direction.UP)) {
        		if(!playerIn.world.isAirBlock(blockpos)) {
        			BlockState blockstate1 = playerIn.world.getBlockState(blockpos);
        			VoxelShape voxelshape = blockstate1.getCollisionShape(playerIn.world, blockpos);
        			if(!voxelshape.isEmpty()) {
        				d0 = voxelshape.getEnd(Direction.Axis.Y);
        			}
        		}

        		flag = true;
        		break;
        	}

        	  blockpos = blockpos.down();
        	  if(blockpos.getY() < MathHelper.floor(d5) - 1) {
        		  break;
        	  }
        }

        if(flag) {
        	if(playerIn.getEntityWorld() instanceof ServerWorld) {
        		LightningBoltEntity lightningboltentity = EntityType.LIGHTNING_BOLT.create(playerIn.getEntityWorld());
        		BlockPos bp = new BlockPos(d1, blockpos.getY() + d0, d3);
        		lightningboltentity.moveForced(Vector3d.copyCenteredHorizontally(bp));
                lightningboltentity.setEffectOnly(playerIn.getEntityWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING) && playerIn.getEntityWorld().rand.nextDouble() < (double) playerIn.getEntityWorld().getDifficultyForLocation(bp).getAdditionalDifficulty() * 0.01D);
                playerIn.getEntityWorld().addEntity(lightningboltentity);
        	}
        }
        
        // make custom lightning bolt that can't hurt user or set fires? yes
        // TODO
	}
	
	// Copied from Item::rayTrace
	protected static RayTraceResult rayTrace(World worldIn, PlayerEntity player, RayTraceContext.FluidMode fluidMode) {
		float f = player.rotationPitch;
		float f1 = player.rotationYaw;
		Vector3d vec3d = player.getEyePosition(1.0F);
		float f2 = MathHelper.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
		float f3 = MathHelper.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
		float f4 = -MathHelper.cos(-f * ((float)Math.PI / 180F));
		float f5 = MathHelper.sin(-f * ((float)Math.PI / 180F));
		float f6 = f3 * f4;
		float f7 = f2 * f4;
		double d0 = player.getAttribute(net.minecraftforge.common.ForgeMod.REACH_DISTANCE.get()).getValue();;
		Vector3d vec3d1 = vec3d.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
		return worldIn.rayTraceBlocks(new RayTraceContext(vec3d, vec3d1, RayTraceContext.BlockMode.OUTLINE, fluidMode, player));
	}
}
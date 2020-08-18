package io.github.fallout015.two.block;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WallTorchBlockTwo extends WallTorchBlock {
	private final IParticleData smoke;
	private final IParticleData flame;
	
	public WallTorchBlockTwo(IParticleData smoke, IParticleData flame, Properties properties) {
		super(properties);
		
		this.smoke = smoke;
		this.flame = flame;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		Direction direction = stateIn.get(HORIZONTAL_FACING);
		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.7D;
		double d2 = (double)pos.getZ() + 0.5D;
		Direction direction1 = direction.getOpposite();
		worldIn.addParticle(this.smoke, d0 + 0.27D * (double)direction1.getXOffset(), d1 + 0.22D, d2 + 0.27D * (double)direction1.getZOffset(), 0.0D, 0.0D, 0.0D);
		worldIn.addParticle(this.flame, d0 + 0.27D * (double)direction1.getXOffset(), d1 + 0.22D, d2 + 0.27D * (double)direction1.getZOffset(), 0.0D, 0.0D, 0.0D);
	}
}
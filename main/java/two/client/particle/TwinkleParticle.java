package two.client.particle;

import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TwinkleParticle extends SpriteTexturedParticle {
	protected TwinkleParticle(World worldIn, double x, double y, double z, double p_i50999_8_, double p_i50999_10_, double p_i50999_12_) {
		super(worldIn, x, y, z);
	}

	@Override
	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}
}
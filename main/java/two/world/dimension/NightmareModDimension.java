package two.world.dimension;

import java.util.function.BiFunction;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraftforge.common.ModDimension;
import two.world.biome.BiomesTwo;
import two.world.gen.surfacebuilders.SurfaceBuilderTwo;

public class NightmareModDimension extends ModDimension {
	private static final Vec3d fogColor = new Vec3d((double)0.2F, (double)0.03F, (double)0.03F);

	@Override
	public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
		return (world, dimensionType) -> new Dimension(world, dimensionType, 0) {
			@Override
			public ChunkGenerator<?> createChunkGenerator() {
			    OverworldGenSettings nightmaregensettings = ChunkGeneratorType.SURFACE.createSettings();
			    nightmaregensettings.setDefaultBlock(SurfaceBuilderTwo.GAULT);
			    nightmaregensettings.setDefaultFluid(Blocks.WATER.getDefaultState());
			    return ChunkGeneratorType.SURFACE.create(this.world, BiomeProviderType.CHECKERBOARD.create(BiomeProviderType.CHECKERBOARD.func_226840_a_(this.world.getWorldInfo()).setBiomes(new Biome [] { BiomesTwo.NIGHTMARE, BiomesTwo.NIGHTMARE_HIGHLANDS })), nightmaregensettings);
			}
			@Override
			public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
				return null;
			}
			@Override
			public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
				return null;
			}
			@Override
			public float calculateCelestialAngle(long worldTime, float partialTicks) {
				double d0 = MathHelper.frac((double)worldTime / 24000.0D - 0.25D);
			    double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
			    return (float)(d0 * 2.0D + d1) / 3.0F;
			}
			@Override
			public boolean isSurfaceWorld() {
				return false;
			}
			@Override
			public Vec3d getFogColor(float celestialAngle, float partialTicks) {
				return fogColor;
			}
			@Override
			public boolean canRespawnHere() {
				return false;
			}
			@Override
			public boolean doesXZShowFog(int x, int z) {
				return true;
			}
		};
	}
}
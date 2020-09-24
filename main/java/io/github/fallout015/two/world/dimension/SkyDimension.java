package io.github.fallout015.two.world.dimension;

public class SkyDimension {
//	private static final Vec3d fogColor = new Vec3d((double)0.2F, (double)0.03F, (double)0.03F);
//
//	public SkyDimension(World world, DimensionType dimensionType, float lighting) {
//		super(world, dimensionType, lighting);
//	}
//	
//	@Override
//	public ChunkGenerator<?> createChunkGenerator() {
//		EndGenerationSettings skygensettings = ChunkGeneratorType.FLOATING_ISLANDS.createSettings();
//		skygensettings.setDefaultBlock(SurfaceBuilderTwo.CLOUD);
//		skygensettings.setDefaultFluid(Blocks.WATER.getDefaultState());
//		return ChunkGeneratorType.FLOATING_ISLANDS.create(this.world, BiomeProviderType.FIXED.create(BiomeProviderType.FIXED.createSettings(this.world.getWorldInfo()).setBiome(BiomesTwo.SKY)), skygensettings);
//	}
//	@Override
//	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
//		return null;
//	}
//	@Override
//	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
//		return null;
//	}
//	@Override
//	public float calculateCelestialAngle(long worldTime, float partialTicks) {
//		double d0 = MathHelper.frac((double)worldTime / 24000.0D - 0.25D);
//	    double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
//	    return (float)(d0 * 2.0D + d1) / 3.0F;
//	}
//	@Override
//	public boolean isSurfaceWorld() {
//		return false;
//	}
//	@Override
//	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
//		return fogColor;
//	}
//	@Override
//	public boolean canRespawnHere() {
//		return false;
//	}
//	@Override
//	public boolean doesXZShowFog(int x, int z) {
//		return true;
//	}
}
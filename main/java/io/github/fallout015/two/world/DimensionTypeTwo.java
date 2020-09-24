package io.github.fallout015.two.world;

import java.util.OptionalLong;

import net.minecraft.tags.BlockTags;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.ColumnFuzzedBiomeMagnifier;
import net.minecraft.world.biome.IBiomeMagnifier;

public class DimensionTypeTwo extends DimensionType {
	public static final ResourceLocation NIGHTMARE_LOCATION = new ResourceLocation("nightmare");
	public static final ResourceLocation SKY_LOCATION = new ResourceLocation("sky");
	public static final ResourceLocation FROSTBITE_LOCATION = new ResourceLocation("frostbite");
	public static final ResourceLocation NIDAVELLIR_LOCATION = new ResourceLocation("nidavellir");
	public static final ResourceLocation DEEP_DARK_LOCATION = new ResourceLocation("deep_dark");
	public static final ResourceLocation BLOOD_AETHER_LOCATION = new ResourceLocation("blood_aether");
	public static final ResourceLocation RAINBOW_LOCATION = new ResourceLocation("rainbow");
	public static final ResourceLocation UMBRAL_PLANE_LOCATION = new ResourceLocation("umbral_plane");
	
	public static final RegistryKey<DimensionType> NIGHTMARE_KEY = RegistryKey.func_240903_a_(Registry.field_239698_ad_, NIGHTMARE_LOCATION);
	public static final RegistryKey<DimensionType> SKY_KEY = RegistryKey.func_240903_a_(Registry.field_239698_ad_, SKY_LOCATION);
	public static final RegistryKey<DimensionType> FROSTBITE_KEY = RegistryKey.func_240903_a_(Registry.field_239698_ad_, FROSTBITE_LOCATION);
	public static final RegistryKey<DimensionType> NIDAVELLIR_KEY = RegistryKey.func_240903_a_(Registry.field_239698_ad_, NIDAVELLIR_LOCATION);
	public static final RegistryKey<DimensionType> DEEP_DARK_KEY = RegistryKey.func_240903_a_(Registry.field_239698_ad_, DEEP_DARK_LOCATION);
	public static final RegistryKey<DimensionType> BLOOD_AETHER_KEY = RegistryKey.func_240903_a_(Registry.field_239698_ad_, BLOOD_AETHER_LOCATION);
	public static final RegistryKey<DimensionType> RAINBOW_KEY = RegistryKey.func_240903_a_(Registry.field_239698_ad_, RAINBOW_LOCATION);
	public static final RegistryKey<DimensionType> UMBRAL_PLANE_KEY = RegistryKey.func_240903_a_(Registry.field_239698_ad_, UMBRAL_PLANE_LOCATION);

	protected DimensionTypeTwo(OptionalLong p_i241973_1_, boolean hasSkyLight, boolean p_i241973_3_, boolean p_i241973_4_, boolean p_i241973_5_, double p_i241973_6_, boolean p_i241973_8_, boolean p_i241973_9_, boolean p_i241973_10_, boolean p_i241973_11_, boolean p_i241973_12_, int height, IBiomeMagnifier magnifier, ResourceLocation infiniburns, ResourceLocation resourceLocation, float p_i241973_17_) {
		super(p_i241973_1_, hasSkyLight, p_i241973_3_, p_i241973_4_, p_i241973_5_, p_i241973_6_, p_i241973_8_, p_i241973_9_, p_i241973_10_, p_i241973_11_, p_i241973_12_, height, magnifier, infiniburns, resourceLocation, p_i241973_17_);
	}
	
	protected static final DimensionType NIGHTMARE = new DimensionTypeTwo(OptionalLong.empty(), true, false, false, true, 1.0D, false, false, true, false, true, 256, ColumnFuzzedBiomeMagnifier.INSTANCE, BlockTags.field_241277_aC_.func_230234_a_(), NIGHTMARE_LOCATION, 0.0F);
	
//	protected static final DimensionType NIGHTMARE = new DimensionType(OptionalLong.empty(), true, false, false, true, 1.0D, false, false, true, false, true, 256, ColumnFuzzedBiomeMagnifier.INSTANCE, BlockTags.field_241277_aC_.func_230234_a_(), NIGHTMARE_LOCATION, 0.0F);
}
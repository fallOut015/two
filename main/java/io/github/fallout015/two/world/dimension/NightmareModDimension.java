package io.github.fallout015.two.world.dimension;

import java.util.function.BiFunction;

import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

public class NightmareModDimension extends ModDimension/* implements IInventoryDimension*/ {
	@Override
	public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
		return (world, dimensionType) -> new NightmareDimension(world, dimensionType, 0.1f);
	}
}
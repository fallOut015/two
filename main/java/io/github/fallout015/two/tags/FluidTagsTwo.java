package io.github.fallout015.two.tags;

import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class FluidTagsTwo {
	public static final Tag<Fluid> MUD = makeWrapperTag("mud");
	
	private static Tag<Fluid> makeWrapperTag(String id) {
		return new FluidTags.Wrapper(new ResourceLocation(id));
	}
}
package io.github.fallout015.two.world;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class WorldTwo {
	public static final RegistryKey<World> NIGHTMARE = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("nightmare"));
}
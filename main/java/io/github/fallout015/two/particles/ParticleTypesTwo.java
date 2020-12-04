package io.github.fallout015.two.particles;

import io.github.fallout015.two.Two;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ParticleTypesTwo {
	private static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Two.MODID);

	
	
	public static final RegistryObject<BasicParticleType> FROST = PARTICLE_TYPES.register("frost", () -> new BasicParticleType(false));
	public static final RegistryObject<BasicParticleType> SPARK = PARTICLE_TYPES.register("spark", () -> new BasicParticleType(false));
	public static final RegistryObject<BasicParticleType> TWINKLE = PARTICLE_TYPES.register("twinkle", () -> new BasicParticleType(false));

	
	
	public static void register(IEventBus bus) {
		PARTICLE_TYPES.register(bus);
	}
}
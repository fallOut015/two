package io.github.fallout015.two.potion;

import io.github.fallout015.two.Two;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectsTwo {
	private static final DeferredRegister<Effect> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, Two.MODID);

	
	
	public static final RegistryObject<Effect> FROSTY = POTIONS.register("frosty", () -> (new EffectTwo(EffectType.HARMFUL, 14024703)).addAttributesModifier(Attributes.MOVEMENT_SPEED, "e81d73be-7ee5-4811-b94b-d9eb3fb4c9cb", -1d, AttributeModifier.Operation.MULTIPLY_TOTAL));
	// TODO AT for effect <init>
	
	
	
	public static void register(IEventBus bus) {
		POTIONS.register(bus);
	}
}
package io.github.fallout015.two.common.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilitiesTwo {
	@CapabilityInject(IPlayerUpgrades.class)
	public static final Capability<IPlayerUpgrades> PLAYERUPGRADES = null;
	
	public static void register() {
    	CapabilityManager.INSTANCE.register(IPlayerUpgrades.class, new PlayerUpgradesStorage(), new PlayerUpgradesCallable());
	}
}
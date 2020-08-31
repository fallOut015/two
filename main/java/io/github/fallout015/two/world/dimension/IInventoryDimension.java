package io.github.fallout015.two.world.dimension;

import net.minecraft.inventory.IInventory;

// An inventory dimension is a dimension that stores a different inventory for the player.
public interface IInventoryDimension {
	public IInventory getInventory();
}
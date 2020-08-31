package io.github.fallout015.two.block.material;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public final class MaterialTwo {
	public static final Material GAULT = new Material.Builder(MaterialColor.OBSIDIAN)/*.flammable().pushDestroys()*/.build(); // TODO apparently requiresTool() was removed, also flammable and pushDestroys
	public static final Material NIGHSTONE = new Material.Builder(MaterialColor.BLUE_TERRACOTTA)/*.pushBlocks()*/.build(); // pushBlocks
	
	public static final Material REGOLITH = new Material.Builder(MaterialColor.LIGHT_GRAY).build();
	public static final Material MYRKYLITE = new Material.Builder(MaterialColor.BLACK_TERRACOTTA).build();
}
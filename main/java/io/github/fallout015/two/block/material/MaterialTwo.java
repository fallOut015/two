package io.github.fallout015.two.block.material;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;

public final class MaterialTwo {
	public static final Material GAULT = (new MaterialTwo.Builder(MaterialColor.OBSIDIAN)).flammable().requiresTool().pushDestroys().build();
	public static final Material NIGHSTONE = (new MaterialTwo.Builder(MaterialColor.BLUE_TERRACOTTA)).requiresTool().pushBlocks().build();
	
	public static final Material REGOLITH = new MaterialTwo.Builder(MaterialColor.LIGHT_GRAY).build();
	public static final Material MYRKYLITE = new MaterialTwo.Builder(MaterialColor.BLACK_TERRACOTTA).requiresTool().build();
	
	static class Builder extends Material.Builder {
		private PushReaction pushReaction = PushReaction.NORMAL;
	    private boolean blocksMovement = true;
	    private boolean canBurn;
	    private boolean requiresNoTool = true;
	    private boolean isLiquid;
	    private boolean isReplaceable;
	    private boolean isSolid = true;
	    private final MaterialColor color;
	    private boolean isOpaque = true;
		
		public Builder(MaterialColor color) {
			super(color);
			this.color = color;
		}

	    public MaterialTwo.Builder liquid() {
	    	this.isLiquid = true;
	    	return this;
	    }
	    public MaterialTwo.Builder notSolid() {
	    	this.isSolid = false;
	    	return this;
	    }
	    public MaterialTwo.Builder doesNotBlockMovement() {
	    	this.blocksMovement = false;
	    	return this;
	    }
	    @SuppressWarnings("unused")
		private MaterialTwo.Builder notOpaque() {
	    	this.isOpaque = false;
	    	return this;
	    }
	    protected MaterialTwo.Builder requiresTool() {
	    	this.requiresNoTool = false;
	    	return this;
	    }
	    protected MaterialTwo.Builder flammable() {
	    	this.canBurn = true;
	    	return this;
	    }
	    public MaterialTwo.Builder replaceable() {
	    	this.isReplaceable = true;
	    	return this;
	    }
	    protected MaterialTwo.Builder pushDestroys() {
	    	this.pushReaction = PushReaction.DESTROY;
	    	return this;
	    }
	    protected MaterialTwo.Builder pushBlocks() {
	    	this.pushReaction = PushReaction.BLOCK;
	    	return this;
	    }
	    public Material build() {
	    	return new Material(this.color, this.isLiquid, this.isSolid, this.blocksMovement, this.isOpaque, this.requiresNoTool, this.canBurn, this.isReplaceable, this.pushReaction);
	    }
	}
}
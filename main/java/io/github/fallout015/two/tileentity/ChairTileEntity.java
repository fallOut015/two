package io.github.fallout015.two.tileentity;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;

public class ChairTileEntity extends TileEntity implements IFurnitureSlots {
	private String back = "oak_planks";
	private String seat = "white_wool";
	private String legs = "oak_planks";
	
	public ChairTileEntity() {
		super(TileEntityTypeTwo.CHAIR.get());
	}
	
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		
		compound.putString("top", this.back.toString());
		compound.putString("middle", this.seat.toString());
		compound.putString("bottom", this.legs.toString());
		
		return compound;
	}
	public void read(CompoundNBT compound) {
		this.back = compound.getString("top");
		this.seat = compound.getString("middle");
		this.legs = compound.getString("bottom");
		
//		super.read(compound);
	}
	
	@Nullable
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.pos, 9, this.getUpdateTag());
	}
	public CompoundNBT getUpdateTag() {
		return this.write(new CompoundNBT());
	}

	@Override
	public String getTop() {
		return this.back;
	}
	@Override
	public String getMiddle() {
		return this.seat;
	}
	@Override
	public String getBottom() {
		return this.legs;
	}
}
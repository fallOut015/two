package two.common.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PlayerUpgradesStorage implements IStorage<IPlayerUpgrades> {
	@Override
	public INBT writeNBT(Capability<IPlayerUpgrades> capability, IPlayerUpgrades instance, Direction side) {
		CompoundNBT nbt = new CompoundNBT();
		nbt.putDouble("health", instance.getHealth());
		nbt.putDouble("hunger", instance.getHunger());
		nbt.putDouble("armor", instance.getArmor());
		nbt.putDouble("breathing", instance.getBreathing());
		return nbt;
	}
	@Override
	public void readNBT(Capability<IPlayerUpgrades> capability, IPlayerUpgrades instance, Direction side, INBT nbt) {
		if(nbt instanceof CompoundNBT) {
			instance.setHealth(((CompoundNBT) nbt).getDouble("health"));
			instance.setHunger(((CompoundNBT) nbt).getDouble("hunger"));
			instance.setArmor(((CompoundNBT) nbt).getDouble("armor"));
			instance.setBreathing(((CompoundNBT) nbt).getDouble("breathing"));
		}
	}
}
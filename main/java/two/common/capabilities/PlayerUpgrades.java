package two.common.capabilities;

public class PlayerUpgrades implements IPlayerUpgrades {
	double health = 0; // bonus health in half hearts. 
	double hunger = 0; // bonus hunger in half shanks. 
	double armor = 0; // bonus armor in half plates. 
	double breathing = 0; // bonus breathing in half bubbles. 
	
	@Override
	public void setHunger(double hunger) {
		this.hunger = hunger;
	}
	@Override
	public void setHealth(double health) {
		this.health = health;
	}
	@Override
	public void setBreathing(double breathing) {
		this.breathing = breathing;
	}
	@Override
	public void setArmor(double armor) {
		this.armor = armor;
	}
	
	@Override
	public double getHunger() {
		return this.hunger;
	}
	@Override
	public double getHealth() {
		return this.health;
	}
	@Override
	public double getBreathing() {
		return this.breathing;
	}
	@Override
	public double getArmor() {
		return this.armor;
	}
}
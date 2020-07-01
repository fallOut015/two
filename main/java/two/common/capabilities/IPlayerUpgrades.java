package two.common.capabilities;

public interface IPlayerUpgrades {
	double getHealth();
	double getHunger();
	double getArmor();
	double getBreathing();
	
	void setHealth(double health);
	void setHunger(double hunger);
	void setArmor(double armor);
	void setBreathing(double breathing);
}
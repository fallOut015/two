package two.common.capabilities;

public interface IPlayerUpgrades {
	int getUpgradePoints();
	
	double getHealth();
	double getHunger();
	double getArmor();
	double getBreathing();
	
	void setUpgradePoints(int upgradePoints);
	
	void setHealth(double health);
	void setHunger(double hunger);
	void setArmor(double armor);
	void setBreathing(double breathing);
}
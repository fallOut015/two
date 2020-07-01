package two.common.capabilities;

import java.util.concurrent.Callable;

public class PlayerUpgradesCallable implements Callable<IPlayerUpgrades> {
	private static final PlayerUpgrades PLAYERUPGRADES;
	
	static {
		PLAYERUPGRADES = new PlayerUpgrades();
	}
	
	@Override
	public IPlayerUpgrades call() throws Exception {
		return PLAYERUPGRADES;
	}
}
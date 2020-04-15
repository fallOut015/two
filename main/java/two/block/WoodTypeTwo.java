package two.block;

import java.util.Set;
import java.util.stream.Stream;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WoodTypeTwo extends WoodType {
	private static final Set<WoodType> WOODTYPES = new ObjectArraySet<>();

	public static final WoodType CEDAR = register(new WoodTypeTwo("cedar"));
	public static final WoodType REDWOOD = register(new WoodTypeTwo("redwood"));
	public static final WoodType CHERRY = register(new WoodTypeTwo("cherry"));
	public static final WoodType ASPEN = register(new WoodTypeTwo("aspen"));
	public static final WoodType DRAGONBLOOD = register(new WoodTypeTwo("dragonblood"));
	public static final WoodType EUCALYPTUS = register(new WoodTypeTwo("eucalyptus"));
	public static final WoodType PINE = register(new WoodTypeTwo("pine"));
	public static final WoodType BALSA = register(new WoodTypeTwo("balsa"));
	public static final WoodType CONIFER = register(new WoodTypeTwo("conifer"));
	public static final WoodType MAPLE = register(new WoodTypeTwo("maple"));
	
	public static final WoodType GHOSTWOOD = register(new WoodTypeTwo("ghostwood")); //Heavy, hard
	public static final WoodType DEADWOOD = register(new WoodTypeTwo("deadwood")); //Heavy, hard
	public static final WoodType CLOUDWOOD = register(new WoodTypeTwo("cloudwood")); //Lightweight, soft
	public static final WoodType BLACKBARK = register(new WoodTypeTwo("blackbark")); 
	public static final WoodType FROSTBARK = register(new WoodTypeTwo("frostbark")); 
	
	private final String ID;
	
	public WoodTypeTwo(String ID) {
		super(ID);
		this.ID = ID;
	}
	
	private static WoodType register(WoodType woodType) {
		WOODTYPES.add(woodType);
		return woodType;
	}
	@OnlyIn(Dist.CLIENT)
	public static Stream<WoodType> func_227046_a_() {
		return WOODTYPES.stream();
	}
	@OnlyIn(Dist.CLIENT)
	public String func_227048_b_() {
		return this.ID;
	}
}
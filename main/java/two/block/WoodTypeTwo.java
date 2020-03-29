package two.block;

import java.util.Set;
import java.util.stream.Stream;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WoodTypeTwo extends WoodType {
	private static final Set<WoodType> WOODTYPES = new ObjectArraySet<>();

	public static final WoodType CHERRY = register(new WoodTypeTwo("cherry"));
	public static final WoodType MAPLE = register(new WoodTypeTwo("maple"));
	public static final WoodType GHOSTWOOD = register(new WoodTypeTwo("ghostwood"));
	public static final WoodType CLOUDWOOD = register(new WoodTypeTwo("cloudwood"));
	
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
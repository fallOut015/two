package two.world.dimension;

import java.util.LinkedList;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;

public class DimensionTypeTwo {
	public static final DimensionType NIGHTMARE = register("nightmare", ModDimensionTwo.NIGHTMARE, null, true);
	public static final DimensionType SKY = register("sky", ModDimensionTwo.SKY, null, true);
	public static final DimensionType FROSTBTIE = register("frostbite", ModDimensionTwo.FROSTBITE, null, true);
	public static final DimensionType NIDAVELLIR = register("nidavellir", ModDimensionTwo.NIDAVELLIR, null, false);
	
	public static void onDimensionTypesRegistry(final RegistryEvent.Register<DimensionType> dimensionTypeRegistryEvent) {
		dimensionTypeRegistryEvent.getRegistry().registerAll(Holder.DIMENSIONTYPESTWO.toArray(new DimensionType [] {}));
	}
	private static DimensionType register(String key, ModDimension type, PacketBuffer data, boolean hasSkyLight) {
		DimensionType dimensionType = DimensionManager.registerOrGetDimension(new ResourceLocation("two", key), type, data, hasSkyLight);
		Holder.DIMENSIONTYPESTWO.add(dimensionType);
		return dimensionType;
	}
	public static class Holder {
		public static final LinkedList<DimensionType> DIMENSIONTYPESTWO = new LinkedList<DimensionType>();
	}
}
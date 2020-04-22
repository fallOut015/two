package two.state.properties;

import net.minecraft.state.EnumProperty;
import two.state.properties.FurnitureProperties.Planks;
import two.state.properties.FurnitureProperties.PlanksWool;

public class BlockStatePropertiesTwo {
	public static final EnumProperty<PlanksWool> SEAT = EnumProperty.create("seat", PlanksWool.class);
	public static final EnumProperty<Planks> LEGS = EnumProperty.create("legs", Planks.class);
	public static final EnumProperty<PlanksWool> BACK = EnumProperty.create("back", PlanksWool.class);
}

package two.state.properties;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.IStringSerializable;

public class FurnitureProperties {
	public static final Map<String, Planks> NAMETOPLANKS = new HashMap<String, Planks>();
	public static final Map<String, PlanksWool> NAMETOPLANKSWOOL = new HashMap<String, PlanksWool>();

	public static enum Planks implements IStringSerializable {
		OAK_PLANKS(Items.OAK_PLANKS),
		SPRUCE_PLANKS(Items.SPRUCE_PLANKS),
		BIRCH_PLANKS(Items.BIRCH_PLANKS),
		JUNGLE_PLANKS(Items.JUNGLE_PLANKS),
		ACACIA_PLANKS(Items.ACACIA_PLANKS),
		DARK_OAK_PLANKS(Items.DARK_OAK_PLANKS);
		
		private final Item item;
				
		Planks(Item item) {
			this.item = item;
			NAMETOPLANKS.put(this.getName(), this);
		}
		
		public Item getItem() {
			return this.item;
		}

		@Override
		public String getName() {
			return this.item.getRegistryName().getPath();
		}
	}
	public static enum PlanksWool implements IStringSerializable {
		OAK_PLANKS(Items.OAK_PLANKS),
		SPRUCE_PLANKS(Items.SPRUCE_PLANKS),
		BIRCH_PLANKS(Items.BIRCH_PLANKS),
		JUNGLE_PLANKS(Items.JUNGLE_PLANKS),
		ACACIA_PLANKS(Items.ACACIA_PLANKS),
		DARK_OAK_PLANKS(Items.DARK_OAK_PLANKS),
		
		WHITE_WOOL(Items.WHITE_WOOL),
		ORANGE_WOOL(Items.ORANGE_WOOL),
		MAGENTA_WOOL(Items.MAGENTA_WOOL),
		LIGHT_BLUE_WOOL(Items.LIGHT_BLUE_WOOL),
		YELLOW_WOOL(Items.YELLOW_WOOL),
		LIME_WOOL(Items.LIME_WOOL),
		PINK_WOOL(Items.PINK_WOOL),
		GRAY_WOOL(Items.GRAY_WOOL),
		LIGHT_GRAY_WOOL(Items.LIGHT_GRAY_WOOL),
		CYAN_WOOL(Items.CYAN_WOOL),
		PURPLE_WOOL(Items.PURPLE_WOOL),
		BLUE_WOOL(Items.BLUE_WOOL),
		BROWN_WOOL(Items.BROWN_WOOL),
		GREEN_WOOL(Items.GREEN_WOOL),
		RED_WOOL(Items.RED_WOOL),
		BLACK_WOOL(Items.BLACK_WOOL);
		
		private final Item item;
		
		PlanksWool(Item item) {
			this.item = item;
			NAMETOPLANKSWOOL.put(this.getName(), this);
		}
		
		public Item getItem() {
			return this.item;
		}

		@Override
		public String getName() {
			return this.item.getRegistryName().getPath();
		}
	}

}

package io.github.fallout015.two.data;

import io.github.fallout015.two.block.BlocksTwo;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;

public class LootTables extends BaseLootTableProvider {
	public LootTables(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
	}

	@Override
    protected void addTables() {
		buildSelfDroppingLootTable(BlocksTwo.WHITE_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.ORANGE_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.MAGENTA_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.LIGHT_BLUE_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.YELLOW_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.LIME_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.PINK_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.GRAY_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.LIGHT_GRAY_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.CYAN_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.PURPLE_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.BLUE_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.BROWN_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.GREEN_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.RED_STAINED_WOODEN_FENCE);
		buildSelfDroppingLootTable(BlocksTwo.BLACK_STAINED_WOODEN_FENCE);
    }
	
	public void buildSelfDroppingLootTable(Block block) {
        lootTables.put(block, createStandardTable(block.getRegistryName().getPath(), block));
	}
}
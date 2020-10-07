package io.github.fallout015.two.data.server;

import io.github.fallout015.two.block.BlocksTwo;
import net.minecraft.data.DataGenerator;

public class LootTableProviderTwo extends BaseLootTableProvider {
	public LootTableProviderTwo(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
	}

	@Override
    protected void addTables() {
		buildSurvivesExplosion(BlocksTwo.LAPIS_BRICKS, lootTables);
		buildSurvivesExplosion(BlocksTwo.IRON_BRICKS, lootTables);
		buildSurvivesExplosion(BlocksTwo.GOLD_BRICKS, lootTables);
		buildSurvivesExplosion(BlocksTwo.DIAMOND_BRICKS, lootTables);
		buildSurvivesExplosion(BlocksTwo.EMERALD_BRICKS, lootTables);
		buildSurvivesExplosion(BlocksTwo.REDSTONE_BRICKS, lootTables);
		buildSurvivesExplosion(BlocksTwo.COAL_BRICKS, lootTables);
		
//		buildSurvivesExplosion(BlocksTwo.WHITE_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.ORANGE_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.MAGENTA_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.LIGHT_BLUE_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.YELLOW_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.LIME_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.PINK_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.GRAY_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.LIGHT_GRAY_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.CYAN_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.PURPLE_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.BLUE_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.BROWN_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.GREEN_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.RED_STAINED_WOODEN_FENCE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.BLACK_STAINED_WOODEN_FENCE, this.lootTables);
////
//		buildSurvivesExplosion(BlocksTwo.WHITE_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.ORANGE_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.MAGENTA_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.LIGHT_BLUE_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.YELLOW_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.LIME_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.PINK_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.GRAY_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.LIGHT_GRAY_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.CYAN_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.PURPLE_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.BLUE_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.BROWN_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.GREEN_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.RED_STAINED_WOODEN_FENCE_GATE, this.lootTables);
//		buildSurvivesExplosion(BlocksTwo.BLACK_STAINED_WOODEN_FENCE_GATE, this.lootTables);
    }
}
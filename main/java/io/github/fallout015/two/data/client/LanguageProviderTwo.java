package io.github.fallout015.two.data.client;

import io.github.fallout015.two.block.BlocksTwo;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguageProviderTwo extends LanguageProvider {
	public LanguageProviderTwo(DataGenerator gen) {
		super(gen, "two", "en_us");
	}

	@Override
	protected void addTranslations() {
//		this.add(BlocksTwo.LAPIS_BRICKS, "Lapis Bricks");
//		this.add(BlocksTwo.IRON_BRICKS, "Iron Bricks");
//		this.add(BlocksTwo.GOLD_BRICKS, "Gold Bricks");
//		this.add(BlocksTwo.DIAMOND_BRICKS, "Diamond Bricks");
//		this.add(BlocksTwo.EMERALD_BRICKS, "Emerald Bricks");
//		this.add(BlocksTwo.REDSTONE_BRICKS, "Redstone Bricks");
//		this.add(BlocksTwo.COAL_BRICKS, "Coal Bricks");
		
		this.add(BlocksTwo.CHISELED_NETHERITE_BLOCK, "Chiseled Netherite Block");
		this.add(BlocksTwo.NETHERITE_PILLAR, "Netherite Pillar");
		this.add(BlocksTwo.NETHERITE_STAIRS, "Netherite Stairs");
		this.add(BlocksTwo.NETHERITE_SLAB, "Netherite Slab");
		this.add(BlocksTwo.SMOOTH_NETHERITE, "Smooth Netherite");
		this.add(BlocksTwo.SMOOTH_NETHERITE_STAIRS, "Smooth Netherite Stairs");
		this.add(BlocksTwo.SMOOTH_NETHERITE_SLAB, "Smooth Netherite Slab");
		this.add(BlocksTwo.NETHERITE_BRICKS, "Netherite Bricks");
	}
}
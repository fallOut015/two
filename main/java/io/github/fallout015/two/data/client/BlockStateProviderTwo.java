package io.github.fallout015.two.data.client;

import io.github.fallout015.two.block.BlocksTwo;
import io.github.fallout015.two.data.client.StateModelMapper.SlabMapper;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;

public class BlockStateProviderTwo extends BaseBlockStateProvider {
	public BlockStateProviderTwo(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
	}
	
	@Override
    protected void addBlockstates() {
		this.addMapper(new SlabMapper(BlocksTwo.DIAMOND_SLAB, Blocks.DIAMOND_BLOCK));
		this.addMapper(new SlabMapper(BlocksTwo.SMOOTH_DIAMOND_SLAB, BlocksTwo.SMOOTH_DIAMOND));
		
		this.addMapper(new SlabMapper(BlocksTwo.EMERALD_SLAB, Blocks.EMERALD_BLOCK));
		this.addMapper(new SlabMapper(BlocksTwo.SMOOTH_EMERALD_SLAB, BlocksTwo.SMOOTH_EMERALD));

		this.addMapper(new SlabMapper(BlocksTwo.REDSTONE_SLAB, Blocks.REDSTONE_BLOCK));
		this.addMapper(new SlabMapper(BlocksTwo.SMOOTH_REDSTONE_SLAB, BlocksTwo.SMOOTH_REDSTONE));

		this.addMapper(new SlabMapper(BlocksTwo.COAL_SLAB, Blocks.COAL_BLOCK));
		this.addMapper(new SlabMapper(BlocksTwo.SMOOTH_COAL_SLAB, BlocksTwo.SMOOTH_COAL));
		
//		this.addMapper(new CubeColumnMapper(BlocksTwo.CHISELED_NETHERITE_BLOCK, false));
//		this.addMapper(new CubeColumnMapper(BlocksTwo.NETHERITE_PILLAR, true));
//		this.addMapper(new StairsMapper(BlocksTwo.NETHERITE_STAIRS, Blocks.NETHERITE_BLOCK));
		this.addMapper(new SlabMapper(BlocksTwo.NETHERITE_SLAB, Blocks.NETHERITE_BLOCK));
//		this.addMapper(new CubeAllMapper(BlocksTwo.SMOOTH_NETHERITE));
//		this.addMapper(new StairsMapper(BlocksTwo.SMOOTH_NETHERITE_STAIRS, BlocksTwo.SMOOTH_NETHERITE));
		this.addMapper(new SlabMapper(BlocksTwo.SMOOTH_NETHERITE_SLAB, BlocksTwo.SMOOTH_NETHERITE));
//		this.addMapper(new CubeAllMapper(BlocksTwo.NETHERITE_BRICKS));
	}
}
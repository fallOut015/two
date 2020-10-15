package io.github.fallout015.two.data.client;

import io.github.fallout015.two.block.BlocksTwo;
import io.github.fallout015.two.data.client.StateModelMapper.CubeAllMapper;
import io.github.fallout015.two.data.client.StateModelMapper.CubeColumnMapper;
import io.github.fallout015.two.data.client.StateModelMapper.SlabMapper;
import io.github.fallout015.two.data.client.StateModelMapper.StairsMapper;
import net.minecraft.data.DataGenerator;

public class BlockStateProviderTwo extends BaseBlockStateProvider {
	public BlockStateProviderTwo(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
	}
	
	@Override
    protected void addBlockstates() {
		this.addMapper(new CubeAllMapper(BlocksTwo.LEAD_BLOCK));
		this.addMapper(new CubeColumnMapper(BlocksTwo.CHISELED_LEAD_BLOCK, false));
		this.addMapper(new CubeColumnMapper(BlocksTwo.LEAD_PILLAR, true));
		this.addMapper(new StairsMapper(BlocksTwo.LEAD_STAIRS, BlocksTwo.LEAD_BLOCK));
		this.addMapper(new SlabMapper(BlocksTwo.LEAD_SLAB, BlocksTwo.LEAD_BLOCK));
		this.addMapper(new CubeAllMapper(BlocksTwo.SMOOTH_LEAD));
		this.addMapper(new StairsMapper(BlocksTwo.SMOOTH_LEAD_STAIRS, BlocksTwo.SMOOTH_LEAD));
		this.addMapper(new SlabMapper(BlocksTwo.SMOOTH_LEAD_SLAB, BlocksTwo.SMOOTH_LEAD));
		this.addMapper(new CubeAllMapper(BlocksTwo.LEAD_BRICKS));
		
		this.addMapper(new CubeAllMapper(BlocksTwo.TITANIUM_BLOCK));
		this.addMapper(new CubeColumnMapper(BlocksTwo.CHISELED_TITANIUM_BLOCK, false));
		this.addMapper(new CubeColumnMapper(BlocksTwo.TITANIUM_PILLAR, true));
		this.addMapper(new StairsMapper(BlocksTwo.TITANIUM_STAIRS, BlocksTwo.TITANIUM_BLOCK));
		this.addMapper(new SlabMapper(BlocksTwo.TITANIUM_SLAB, BlocksTwo.TITANIUM_BLOCK));
		this.addMapper(new CubeAllMapper(BlocksTwo.SMOOTH_TITANIUM));
		this.addMapper(new StairsMapper(BlocksTwo.SMOOTH_TITANIUM_STAIRS, BlocksTwo.SMOOTH_TITANIUM));
		this.addMapper(new SlabMapper(BlocksTwo.SMOOTH_TITANIUM_SLAB, BlocksTwo.SMOOTH_TITANIUM));
		this.addMapper(new CubeAllMapper(BlocksTwo.TITANIUM_BRICKS));
		
		this.addMapper(new CubeAllMapper(BlocksTwo.GARNET_BLOCK));
		this.addMapper(new CubeColumnMapper(BlocksTwo.CHISELED_GARNET_BLOCK, false));
		this.addMapper(new CubeColumnMapper(BlocksTwo.GARNET_PILLAR, true));
		this.addMapper(new StairsMapper(BlocksTwo.GARNET_STAIRS, BlocksTwo.GARNET_BLOCK));
		this.addMapper(new SlabMapper(BlocksTwo.GARNET_SLAB, BlocksTwo.GARNET_BLOCK));
		this.addMapper(new CubeAllMapper(BlocksTwo.SMOOTH_GARNET));
		this.addMapper(new StairsMapper(BlocksTwo.SMOOTH_GARNET_STAIRS, BlocksTwo.SMOOTH_GARNET));
		this.addMapper(new SlabMapper(BlocksTwo.SMOOTH_GARNET_SLAB, BlocksTwo.SMOOTH_GARNET));
		this.addMapper(new CubeAllMapper(BlocksTwo.GARNET_BRICKS));
		
		this.addMapper(new CubeAllMapper(BlocksTwo.TOPAZ_BLOCK));
		this.addMapper(new CubeColumnMapper(BlocksTwo.CHISELED_TOPAZ_BLOCK, false));
		this.addMapper(new CubeColumnMapper(BlocksTwo.TOPAZ_PILLAR, true));
		this.addMapper(new StairsMapper(BlocksTwo.TOPAZ_STAIRS, BlocksTwo.TOPAZ_BLOCK));
		this.addMapper(new SlabMapper(BlocksTwo.TOPAZ_SLAB, BlocksTwo.TOPAZ_BLOCK));
		this.addMapper(new CubeAllMapper(BlocksTwo.SMOOTH_TOPAZ));
		this.addMapper(new StairsMapper(BlocksTwo.SMOOTH_TOPAZ_STAIRS, BlocksTwo.SMOOTH_TOPAZ));
		this.addMapper(new SlabMapper(BlocksTwo.SMOOTH_TOPAZ_SLAB, BlocksTwo.SMOOTH_TOPAZ));
		this.addMapper(new CubeAllMapper(BlocksTwo.TOPAZ_BRICKS));
		
		// TODO fix slab mapper
	}
}
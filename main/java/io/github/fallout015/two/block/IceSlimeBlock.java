package io.github.fallout015.two.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlimeBlock;

public class IceSlimeBlock extends SlimeBlock {
	public IceSlimeBlock(Properties properties) {
		super(properties);
	}
	
	public boolean isSlimeBlock(BlockState state) {
        return true;
    }
	public boolean isStickyBlock(BlockState state) {
        return true;
    }
	public boolean canStickTo(BlockState state, BlockState other) {
        if (state.getBlock() == Blocks.HONEY_BLOCK && (other.getBlock() == Blocks.SLIME_BLOCK || other.getBlock() == BlocksTwo.ICE_SLIME_BLOCK)) return false;
        if (state.getBlock() == Blocks.SLIME_BLOCK && (other.getBlock() == Blocks.HONEY_BLOCK || other.getBlock() == BlocksTwo.ICE_SLIME_BLOCK)) return false;
        if (state.getBlock() == BlocksTwo.ICE_SLIME_BLOCK && (other.getBlock() == Blocks.HONEY_BLOCK || other.getBlock() == Blocks.SLIME_BLOCK)) return false;
        return state.isStickyBlock() || other.isStickyBlock();
    }
}
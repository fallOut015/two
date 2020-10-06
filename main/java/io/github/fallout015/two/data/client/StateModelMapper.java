package io.github.fallout015.two.data.client;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;

import io.github.fallout015.two.data.client.writer.block.CubeAllWriter;
import io.github.fallout015.two.data.client.writer.block.FenceGateOpenWriter;
import io.github.fallout015.two.data.client.writer.block.FenceGateWallOpenWriter;
import io.github.fallout015.two.data.client.writer.block.FenceGateWallWriter;
import io.github.fallout015.two.data.client.writer.block.FenceGateWriter;
import io.github.fallout015.two.data.client.writer.block.FenceInventoryWriter;
import io.github.fallout015.two.data.client.writer.block.FencePostWriter;
import io.github.fallout015.two.data.client.writer.block.FenceSideWriter;
import io.github.fallout015.two.data.client.writer.item.FenceItemWriter;
import net.minecraft.block.Block;
import net.minecraft.data.BlockModelWriter;
import net.minecraft.data.IFinishedBlockState;
import net.minecraft.util.ResourceLocation;

public class StateModelMapper {
	final Block block;
	final BiConsumer<Block, Map<Block, IFinishedBlockState>> blockstate;
	final List<Function<ResourceLocation, Supplier<JsonElement>>> blockmodels;
	final Function<ResourceLocation, Supplier<JsonElement>> itemmodel;
	@Nullable final Block sharedblock;
	
	public StateModelMapper(final Block block, final BiConsumer<Block, Map<Block, IFinishedBlockState>> blockstate, final List<Function<ResourceLocation, Supplier<JsonElement>>> blockmodels, final Function<ResourceLocation, Supplier<JsonElement>> itemmodel, final @Nullable Block sharedblock) {
		this.block = block;
		this.blockstate = blockstate;
		this.blockmodels = blockmodels;
		this.itemmodel = itemmodel;
		this.sharedblock = sharedblock;
	}
	public StateModelMapper(final Block block, final BiConsumer<Block, Map<Block, IFinishedBlockState>> blockstate, final List<Function<ResourceLocation, Supplier<JsonElement>>> blockmodels, final Function<ResourceLocation, Supplier<JsonElement>> itemmodel) {
		this(block, blockstate, blockmodels, itemmodel, null);
	}
	public StateModelMapper(final Block block, final BiConsumer<Block, Map<Block, IFinishedBlockState>> blockstate, final Function<ResourceLocation, Supplier<JsonElement>> blockmodel, final Function<ResourceLocation, Supplier<JsonElement>> itemmodel) {
		this(block, blockstate, ImmutableList.of(blockmodel), itemmodel);
	}
	public StateModelMapper(final Block block, final BiConsumer<Block, Map<Block, IFinishedBlockState>> blockstate, final Function<ResourceLocation, Supplier<JsonElement>> blockmodel) {
		this(block, blockstate, blockmodel, BlockModelWriter::new);
	}
	public StateModelMapper(final Block block, final BiConsumer<Block, Map<Block, IFinishedBlockState>> blockstate) {
		this(block, blockstate, CubeAllWriter::new);
	}
	public StateModelMapper(final Block block) {
		this(block, BlockStateBuilders::buildNoVariants);
	}
	
	public Block getBlock() {
		return block;
	}
	public BiConsumer<Block, Map<Block, IFinishedBlockState>> getBlockState() {
		return blockstate;
	}
	public List<Function<ResourceLocation, Supplier<JsonElement>>> getBlockModels() {
		return blockmodels;
	}
	public Function<ResourceLocation, Supplier<JsonElement>> getItemModel() {
		return itemmodel;
	}
	public boolean usesSharedBlock() {
		return this.sharedblock != null;
	}
	public Block getSharedBlock() {
		return sharedblock;
	}
	
	public static class CubeAllMapper extends StateModelMapper {
		public CubeAllMapper(final Block block) {
			super(block);
		}
	}
	public static class FenceMapper extends StateModelMapper {
		public FenceMapper(final Block block, final Block sharedblock) {
			super(
				block,
				BlockStateBuilders::buildFence,
				ImmutableList.of(
					FencePostWriter::new, 
					FenceSideWriter::new, 
					FenceInventoryWriter::new
				), 
				FenceItemWriter::new,
				sharedblock
			); // replace with static strings in classes instead of appends?
		}
	}
	public static class FenceGateMapper extends StateModelMapper {
		public FenceGateMapper(final Block block, final Block sharedblock) {
			super(
				block,
				BlockStateBuilders::buildFenceGate, 
				ImmutableList.of(
					FenceGateOpenWriter::new, 
					FenceGateWallOpenWriter::new, 
					FenceGateWallWriter::new, 
					FenceGateWriter::new
				), 
				BlockModelWriter::new,
				sharedblock
			);
		}
	}
}
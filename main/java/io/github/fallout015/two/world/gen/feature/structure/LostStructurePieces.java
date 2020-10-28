package io.github.fallout015.two.world.gen.feature.structure;

import java.util.Random;

import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class LostStructurePieces {
	public static class HouseCrimsonPiece extends ScatteredStructurePiece {
		private boolean placedMainChest;

		public HouseCrimsonPiece(Random random, int x, int z) {
			super(StructurePieceTypes.LHC, random, x, 64, z, 12, 10, 15);
		}

		public HouseCrimsonPiece(TemplateManager templateManagerIn, CompoundNBT nbt) {
			super(StructurePieceTypes.LHC, nbt);
			this.placedMainChest = nbt.getBoolean("placedMainChest");
		}

		@Override
		public boolean func_230383_a_(ISeedReader worldIn, StructureManager p_230383_2_, ChunkGenerator p_230383_3_, Random p_230383_4_, MutableBoundingBox boundingboxIn, ChunkPos p_230383_6_, BlockPos p_230383_7_) {
			if (!this.isInsideBounds(worldIn, boundingboxIn, 0)) {
				return false;
			} else {
				this.fillWithBlocks(worldIn, boundingboxIn, 0, 0, 0, 3, 3, 3, Blocks.CRIMSON_PLANKS.getDefaultState(), Blocks.CRIMSON_STEM.getDefaultState(), true);
				this.fillWithBlocks(worldIn, boundingboxIn, 4, 4, 4, 7, 7, 7, Blocks.CRIMSON_PLANKS.getDefaultState(), Blocks.CRIMSON_STEM.getDefaultState(), false);

				return true;
			}
		}
		
		protected void readAdditional(CompoundNBT tagCompound) {
			super.readAdditional(tagCompound);
			tagCompound.putBoolean("placedMainChest", this.placedMainChest);
		}
	}
	
	public static class HouseWarpedPiece extends ScatteredStructurePiece {
		private boolean placedMainChest;

		public HouseWarpedPiece(Random random, int x, int z) {
			super(StructurePieceTypes.LHW, random, x, 64, z, 12, 10, 15);
		}

		public HouseWarpedPiece(TemplateManager templateManagerIn, CompoundNBT nbt) {
			super(StructurePieceTypes.LHW, nbt);
			this.placedMainChest = nbt.getBoolean("placedMainChest");
		}

		@Override
		public boolean func_230383_a_(ISeedReader worldIn, StructureManager p_230383_2_, ChunkGenerator p_230383_3_, Random p_230383_4_, MutableBoundingBox boundingboxIn, ChunkPos p_230383_6_, BlockPos p_230383_7_) {
			if (!this.isInsideBounds(worldIn, boundingboxIn, 0)) {
				return false;
			} else {
				this.fillWithBlocks(worldIn, boundingboxIn, 0, 0, 0, 3, 3, 3, Blocks.WARPED_PLANKS.getDefaultState(), Blocks.WARPED_STEM.getDefaultState(), true);
				this.fillWithBlocks(worldIn, boundingboxIn, 4, 4, 4, 7, 7, 7, Blocks.WARPED_PLANKS.getDefaultState(), Blocks.WARPED_STEM.getDefaultState(), false);

				return true;
			}
		}
		
		protected void readAdditional(CompoundNBT tagCompound) {
			super.readAdditional(tagCompound);
			tagCompound.putBoolean("placedMainChest", this.placedMainChest);
		}
	}
}

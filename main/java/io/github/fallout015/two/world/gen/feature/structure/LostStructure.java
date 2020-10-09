package io.github.fallout015.two.world.gen.feature.structure;

import javax.annotation.Nullable;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class LostStructure extends Structure<NoFeatureConfig> {
	public LostStructure(Codec<NoFeatureConfig> codec) {
		super(codec);
	}

	@Override
	public IStartFactory<NoFeatureConfig> getStartFactory() {
		return LostStructure.Start::new;
	}
	
	public static class Start extends StructureStart<NoFeatureConfig> {
		public Start(Structure<NoFeatureConfig> p_i225876_1_, int p_i225876_2_, int p_i225876_3_, MutableBoundingBox p_i225876_4_, int p_i225876_5_, long p_i225876_6_) {
			super(p_i225876_1_, p_i225876_2_, p_i225876_3_, p_i225876_4_, p_i225876_5_, p_i225876_6_);
		}

		@Override
		public void func_230364_a_(DynamicRegistries dynamicRegistries, ChunkGenerator chunkGenerator, TemplateManager templateManager, int x, int z, Biome biome, NoFeatureConfig config) {
			@Nullable ScatteredStructurePiece piece = null;
			if(biome.getRegistryName() == Biomes.CRIMSON_FOREST.getRegistryName()) {
				piece = new LostStructurePieces.HouseCrimsonPiece(this.rand, 16 * x, 16 * z);
			} else if(biome.getRegistryName() == Biomes.WARPED_FOREST.getRegistryName()) {
				piece = new LostStructurePieces.HouseWarpedPiece(this.rand, 16 * x, 16 * z);
			}
			if(piece != null) {
				this.components.add(piece);
				this.recalculateStructureSize();
			}
		}
	}
}
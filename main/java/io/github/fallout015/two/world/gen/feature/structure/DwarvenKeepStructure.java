package io.github.fallout015.two.world.gen.feature.structure;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DwarvenKeepStructure extends Structure<NoFeatureConfig> {
	public DwarvenKeepStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51427_1_) {
		super(p_i51427_1_);
	}

	@Override
	public boolean canBeGenerated(BiomeManager biomeManagerIn, ChunkGenerator<?> generatorIn, Random randIn, int chunkX, int chunkZ, Biome biomeIn) {
		return false;
	}
	@Override
	public IStartFactory getStartFactory() {
		return DwarvenKeepStructure.Start::new;
	}
	@Override
	public String getStructureName() {
		return "Dwarven_Keep";
	}
	@Override
	public int getSize() {
		return 8;
	}
	
	public static class Start extends StructureStart {
		public Start(Structure<?> structure, int i1, int i3, MutableBoundingBox mutableBoundingBox, int i5, long l6) {
			super(structure, i1, i3, mutableBoundingBox, i5, l6);
		}

		@Override
		public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
	         Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
	         BlockPos blockpos = new BlockPos(chunkX * 16 + 8, chunkZ % 60, chunkZ * 16 + 8);
	         DwarvenKeepPieces.startGenerators(templateManagerIn, blockpos, rotation, this.components, this.rand);
	         this.recalculateStructureSize();
		}
	}
}
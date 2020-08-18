package io.github.fallout015.two.world.gen.feature.structure;

import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.ScatteredStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class AdobeWellStructure extends ScatteredStructure<NoFeatureConfig> {
	public AdobeWellStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> function) {
		super(function);
	}

	@Override
	protected int getSeedModifier() {
		return 165745296;
	}
	@Override
	public IStartFactory getStartFactory() {
		return AdobeWellStructure.Start::new;
	}
	@Override
	public String getStructureName() {
		return "Adobe_Well";
	}
	@Override
	public int getSize() {
		return 3;
	}
	
	public static class Start extends StructureStart {
		public Start(Structure<?> structure, int p_i225876_2_, int p_i225876_3_, MutableBoundingBox mutableBoundingBox, int p_i225876_5_, long p_i225876_6_) {
			super(structure, p_i225876_2_, p_i225876_3_, mutableBoundingBox, p_i225876_5_, p_i225876_6_);
		}

		@Override
		public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
			AdobeWellPiece adobewellpiece = new AdobeWellPiece(this.rand, chunkX * 16, chunkZ * 16);
			this.components.add(adobewellpiece);
			this.recalculateStructureSize();
		}
	}
}
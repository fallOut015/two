package two.world.gen.feature.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class AdobeWellPiece extends ScatteredStructurePiece {
//	private static final ResourceLocation ADOBE_WELL = new ResourceLocation("adobe_well");
//	private static final PlacementSettings PLACEMENT_SETTINGS = new PlacementSettings().
	
	public AdobeWellPiece(Random random, int x, int z) {
		super(IStructurePieceType.TEDP, random, x, 64, z, 21, 15, 21);
	}
	public AdobeWellPiece(TemplateManager p_i51351_1_, CompoundNBT p_i51351_2_) {
		super(IStructurePieceType.TEDP, p_i51351_2_);
	}
	
	@Override
	public boolean func_225577_a_(IWorld world, ChunkGenerator<?> chunkGenerator, Random random, MutableBoundingBox mutableBoundingBox, ChunkPos chunkPos) {
		List<StructurePiece> list$structurepiece = new ArrayList<StructurePiece>(1);
		list$structurepiece.add(this);
		this.buildComponent(this, list$structurepiece, random);
		return true;
	}
}
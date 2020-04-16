package two.world.gen.feature.structure;

import java.util.Random;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class PillarsPiece extends ScatteredStructurePiece {
	public PillarsPiece(Random random, int x, int z) {
		super(IStructurePieceType.TEDP, random, x, 64, z, 21, 15, 21);
	}
	public PillarsPiece(TemplateManager p_i51351_1_, CompoundNBT p_i51351_2_) {
		super(IStructurePieceType.TEDP, p_i51351_2_);
	}
	
	@Override
	public boolean func_225577_a_(IWorld p_225577_1_, ChunkGenerator<?> p_225577_2_, Random p_225577_3_, MutableBoundingBox p_225577_4_, ChunkPos p_225577_5_) {
		// TODO stuff
		return true;
	}
}
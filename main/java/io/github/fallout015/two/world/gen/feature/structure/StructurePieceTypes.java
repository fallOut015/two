package io.github.fallout015.two.world.gen.feature.structure;

import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class StructurePieceTypes {
	public static final IStructurePieceType LHC = IStructurePieceType.register(LostStructurePieces.HouseCrimsonPiece::new, "LHC"); // LostHouseCrimson
	public static final IStructurePieceType LHW = IStructurePieceType.register(LostStructurePieces.HouseWarpedPiece::new, "LHC"); // LostHouseCrimson
}
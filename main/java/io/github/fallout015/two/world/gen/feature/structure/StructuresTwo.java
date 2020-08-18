package io.github.fallout015.two.world.gen.feature.structure;

import io.github.fallout015.two.world.gen.feature.FeatureTwo;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;

public class StructuresTwo {
	public static final IStructurePieceType AWP = IStructurePieceType.register(AdobeWellPiece::new, "AWP");
	public static final IStructurePieceType DKP = IStructurePieceType.register(DwarvenKeepPieces.KeepTemplate::new, "DKP");
	
	
	
	public static final Structure<?> ADOBE_WELL = register("Adobe_Well", FeatureTwo.ADOBE_WELL);
	public static final Structure<?> DWARVEN_KEEP = register("Dwarven_Keep", FeatureTwo.DWARVEN_KEEP);
	
	
	
	
	
	static Structure<?> register(String key, Structure<?> structure) {
		return structure;
	}
}
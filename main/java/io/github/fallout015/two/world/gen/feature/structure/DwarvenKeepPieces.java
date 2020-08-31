package io.github.fallout015.two.world.gen.feature.structure;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DwarvenKeepPieces {
	private static final PlacementSettings OVERWRITE = (new PlacementSettings()).setIgnoreEntities(true).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
	private static final PlacementSettings INSERT = (new PlacementSettings()).setIgnoreEntities(true).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);
	
	private static DwarvenKeepPieces.KeepTemplate addPiece(TemplateManager templateManager, DwarvenKeepPieces.KeepTemplate template, BlockPos pos, String name, Rotation rotation, boolean owerwrite) {
		DwarvenKeepPieces.KeepTemplate dwarvenkeeppieces$keeptemplate = new DwarvenKeepPieces.KeepTemplate(templateManager, name, template.getTemplatePosition(), rotation, owerwrite);
		BlockPos blockpos = template.getTemplate().calculateConnectedPos(template.getPlacementSettings(), pos, dwarvenkeeppieces$keeptemplate.getPlacementSettings(), BlockPos.ZERO);
		dwarvenkeeppieces$keeptemplate.offset(blockpos.getX(), blockpos.getY(), blockpos.getZ());
		return dwarvenkeeppieces$keeptemplate;
	}
	private static DwarvenKeepPieces.KeepTemplate addHelper(List<StructurePiece> list$structurepiece, DwarvenKeepPieces.KeepTemplate template) {
		list$structurepiece.add(template);
		return template;
	}
	private static boolean recursiveChildren(TemplateManager templateManager, IGenerator<KeepTemplate> generator, int i2, DwarvenKeepPieces.KeepTemplate template, BlockPos pos, List<StructurePiece> list$structurePiece, Random random) {
		if (i2 > 8)
			return false;
		else {
			List<StructurePiece> list = Lists.newArrayList();
			if (generator.generate(templateManager, i2, template, pos, list, random)) {
				boolean flag = false;
	            int i = random.nextInt();

	            for(StructurePiece structurepiece : list) {
	            	if(structurepiece instanceof KeepTemplate)
	            		((KeepTemplate) structurepiece).setComponentType(i);
	            	StructurePiece structurepiece1 = StructurePiece.findIntersecting(list$structurePiece, structurepiece.getBoundingBox());
	            	if (structurepiece1 != null && structurepiece1.getComponentType() != template.getComponentType()) {
	            		flag = true;
	            		break;
	            	}
	            }

	            if (!flag) {
	            	list$structurePiece.addAll(list);
	            	return true;
	            }
			}
			return false;
		}
	}
	public static void startGenerators(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> list$structurePiece, Random random) {
		CORRIDOR_GENERATOR.init();
		SPIRE_GENERATOR.init();
		DwarvenKeepPieces.KeepTemplate dwarvenKeepPieces$keepTemplate = addHelper(list$structurePiece, new DwarvenKeepPieces.KeepTemplate(templateManager, "wall_normal", pos, rotation, true));
		recursiveChildren(templateManager, CORRIDOR_GENERATOR, 1, dwarvenKeepPieces$keepTemplate, (BlockPos) null, list$structurePiece, random);
	}
	
	private static final IGenerator<KeepTemplate> CORRIDOR_GENERATOR = new IKeepGenerator() {
		@Override
		public void init() { }
		@Override
		public boolean generate(TemplateManager templateManager, int i2, KeepTemplate keepTemplate, BlockPos pos, List<StructurePiece> list$structurePiece, Random random) {
            if(i2 > 8) return false;
			Rotation rotation = keepTemplate.getPlacementSettings().getRotation();
            DwarvenKeepPieces.KeepTemplate dwarvenKeepPieces$keepTemplate = DwarvenKeepPieces.addHelper(list$structurePiece, DwarvenKeepPieces.addPiece(templateManager, keepTemplate, pos, "corridor_small", rotation, true));
            int i = random.nextInt(2);
            if (i == 0) {
            	DwarvenKeepPieces.addHelper(list$structurePiece, DwarvenKeepPieces.addPiece(templateManager, dwarvenKeepPieces$keepTemplate, new BlockPos(-1, 4, -1), "corridor_corner", rotation, true));
            } else if (i == 1) {
            	dwarvenKeepPieces$keepTemplate = DwarvenKeepPieces.addHelper(list$structurePiece, DwarvenKeepPieces.addPiece(templateManager, dwarvenKeepPieces$keepTemplate, new BlockPos(-1, 0, -1), "corridor_medium", rotation, false));
            	dwarvenKeepPieces$keepTemplate = DwarvenKeepPieces.addHelper(list$structurePiece, DwarvenKeepPieces.addPiece(templateManager, dwarvenKeepPieces$keepTemplate, new BlockPos(-1, 8, -1), "corridor_large", rotation, false));
            	DwarvenKeepPieces.recursiveChildren(templateManager, DwarvenKeepPieces.SPIRE_GENERATOR, i2 + 1, dwarvenKeepPieces$keepTemplate, (BlockPos)null, list$structurePiece, random);
            }
            return true;
		}
	};
	private static final IGenerator<KeepTemplate> SPIRE_GENERATOR = new IKeepGenerator() {
		@Override
		public void init() { }
		@Override
		public boolean generate(TemplateManager templateManager, int i2, KeepTemplate keepTemplate, BlockPos pos, List<StructurePiece> list$structurePiece, Random random) {
			if(i2 > 8) return false;
			Rotation rotation = keepTemplate.getPlacementSettings().getRotation();
            DwarvenKeepPieces.KeepTemplate dwarvenKeepPieces$keepTemplate = DwarvenKeepPieces.addHelper(list$structurePiece, DwarvenKeepPieces.addPiece(templateManager, keepTemplate, pos, "corridor_small", rotation, true));
            int i = random.nextInt(2);
            switch(i) {
            	case 0:
                	DwarvenKeepPieces.addHelper(list$structurePiece, DwarvenKeepPieces.addPiece(templateManager, dwarvenKeepPieces$keepTemplate, new BlockPos(-1, 4, -1), "spire_normal", rotation, true));
            		break;
            	case 1:
                	DwarvenKeepPieces.addHelper(list$structurePiece, DwarvenKeepPieces.addPiece(templateManager, dwarvenKeepPieces$keepTemplate, new BlockPos(-1, 4, -1), "spire_flag_inner", rotation, true));
            		break;
            	case 2:
                	DwarvenKeepPieces.addHelper(list$structurePiece, DwarvenKeepPieces.addPiece(templateManager, dwarvenKeepPieces$keepTemplate, new BlockPos(-1, 4, -1), "spire_flag_outer", rotation, true));
            		break;
            	default:
            }
			return true;
		}
	};
	
	public static class KeepTemplate extends TemplateStructurePiece {
		private final String pieceName;
		private final Rotation rotation;
		private final boolean overwrite;

		public KeepTemplate(TemplateManager template, String pieceName, BlockPos templatePosition, Rotation rotation, boolean overwriteIn) {
			super(StructureTwo.DKP, 0);
			this.pieceName = pieceName;
			this.templatePosition = templatePosition;
			this.rotation = rotation;
			this.overwrite = overwriteIn;
			this.loadTemplate(template);
		}
		public KeepTemplate(TemplateManager template, CompoundNBT nbt) {
			super(StructureTwo.DKP, nbt);
			this.pieceName = nbt.getString("Template");
			this.rotation = Rotation.valueOf(nbt.getString("Rot"));
			this.overwrite = nbt.getBoolean("OW");
			this.loadTemplate(template);
		}
		
		public Template getTemplate() {
			return this.template;
		}
		public BlockPos getTemplatePosition() {
			return this.templatePosition;
		}
		public PlacementSettings getPlacementSettings() {
			return this.placeSettings;
		}
		public void setComponentType(int componentType) {
			this.componentType = componentType;
		}

		private void loadTemplate(TemplateManager templatemanager) {
			Template template = templatemanager.getTemplateDefaulted(new ResourceLocation("two", "dwarven_keep/" + this.pieceName));
			PlacementSettings placementsettings = (this.overwrite ? DwarvenKeepPieces.OVERWRITE : DwarvenKeepPieces.INSERT).copy().setRotation(this.rotation);
			this.setup(template, this.templatePosition, placementsettings);
		}

		protected void readAdditional(CompoundNBT tagCompound) {
			super.readAdditional(tagCompound);
			tagCompound.putString("Template", this.pieceName);
			tagCompound.putString("Rot", this.rotation.name());
			tagCompound.putBoolean("OW", this.overwrite);
		}
		protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb) {
			
		}
	}
	
	interface IGenerator<T extends TemplateStructurePiece> {
		void init();
		boolean generate(TemplateManager templateManager, int i2, T keepTemplate, BlockPos pos, List<StructurePiece> list$structurePiece, Random random);
	}
	interface IKeepGenerator extends IGenerator<KeepTemplate> {
		
	}
}
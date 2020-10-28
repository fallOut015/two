package io.github.fallout015.two.data.client;

import java.util.Map;

import io.github.fallout015.two.Two;
import net.minecraft.block.Block;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SixWayBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.data.BlockModelDefinition;
import net.minecraft.data.BlockModelFields;
import net.minecraft.data.BlockModelFields.Rotation;
import net.minecraft.data.BlockStateVariantBuilder;
import net.minecraft.data.FinishedMultiPartBlockState;
import net.minecraft.data.FinishedVariantBlockState;
import net.minecraft.data.IFinishedBlockState;
import net.minecraft.data.IMultiPartPredicateBuilder;
import net.minecraft.data.ModelsResourceUtil;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class BlockStateBuilders {
	public static void buildNoVariants(Block block, final Map<Block, IFinishedBlockState> blockstatesSave) {
    	blockstatesSave.put(
    		block,
    		FinishedVariantBlockState.func_240120_a_(
    			block,
    			BlockModelDefinition.getNewModelDefinition(
    			).replaceInfoValue(
    				BlockModelFields.field_240202_c_,
    				ModelsResourceUtil.func_240221_a_(
    					block
    				)
    			)
    		)
    	);
    }
	public static void buildStairs(Block block, final Map<Block, IFinishedBlockState> blockstatesSave) {
		blockstatesSave.put(
    		block,
    		FinishedVariantBlockState.func_240119_a_(
    			block
    		).func_240125_a_(
    			BlockStateVariantBuilder.func_240135_a_(
    				StairsBlock.FACING,
    				StairsBlock.HALF,
    				StairsBlock.SHAPE
    			).func_240160_a_(
    				(facing, half, shape) -> {
    					String append = "";
    					if(shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT) {
    						append = "_inner";
    					} else if(shape == StairsShape.OUTER_LEFT || shape == StairsShape.OUTER_RIGHT) {
    						append = "_outer";
    					}
    		    		ResourceLocation resource = new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString() + append);
    		    		
    		    		boolean north = facing == Direction.NORTH;
    		    		boolean east = facing == Direction.EAST;
    		    		boolean south = facing == Direction.SOUTH;
    		    		boolean west = facing == Direction.WEST;
    		    		
    		    		boolean top = half == Half.TOP;
    		    		boolean bottom = half == Half.BOTTOM;
    		    		
    		    		boolean straight = shape == StairsShape.STRAIGHT;
    		    		boolean inner_left = shape == StairsShape.INNER_LEFT;
    		    		boolean inner_right = shape == StairsShape.INNER_RIGHT;
    		    		boolean outer_left = shape == StairsShape.OUTER_LEFT;
    		    		boolean outer_right = shape == StairsShape.OUTER_RIGHT;
    		    		
    		    		Rotation x = Rotation.R0;
    		    		
    		    		if(top) {
    		    			x = Rotation.R180;
    		    		}
    		    		
    		    		
    		    		
    		    		Rotation y = Rotation.R0;
    		    		
    		    		if(
    		    			(east && top && inner_right) ||
    		    			(east && top && outer_right) ||
    		    		
    		    			(south && bottom && inner_right) ||
    		    			(south && bottom && outer_right) ||
    		    			(south && bottom && straight) ||
    		    			(south && top && inner_left) ||
    		    			(south && top && outer_left) ||
    		    			(south && top && straight) ||
    		    		
    		    			(west && bottom && inner_left) ||
    		    			(west && bottom && outer_left)
    		    		) {
    		    			y = Rotation.R90;
    		    		} else if(
        		    		(north && bottom && inner_left) ||
        		    		(north && bottom && outer_left) ||
        		    		
        		    		(south && top && inner_right) ||
        		    		(south && top && outer_right) ||
        		    		
        		    		(west && bottom && inner_right) ||
        		    		(west && bottom && outer_right) ||
        		    		(west && bottom && straight) ||
        		    		(west && top && inner_left) ||
        		    		(west && top && outer_left) ||
        		    		(west && top && straight)
        		    	) {
        		    		y = Rotation.R180;
    		    		} else if(
    		    			(east && bottom && inner_left) ||
    		    			(east && bottom && outer_left) ||
    		    			
    		    			(north && bottom && inner_right) ||
    		    			(north && bottom && outer_right) ||
    		    			(north && bottom && straight) ||
    		    			(north && top && inner_left) ||
    		    			(north && top && outer_left) ||
    		    			(north && top && straight) ||
    		    			
    		    			(west && top && inner_right) ||
    		    			(west && top && outer_right)
    		    		) {
    		    			y = Rotation.R270;
    		    		}

    		    		
    		    		
    		    		boolean uvlock = true;
    		    		
    		    		if(
        		    		(east && bottom && inner_right) ||
        		    		(east && bottom && outer_right) ||
        		    		(east && bottom && straight) ||
        		    		(south && bottom && inner_left) ||
        		    		(south && bottom && outer_left)
    		    		) {
        		    		uvlock = false;
    		    		}
    		    		
    					return BlockModelDefinition.getNewModelDefinition(
    					).replaceInfoValue(
    						BlockModelFields.field_240202_c_,
    						resource
    					).replaceInfoValue(
    						BlockModelFields.field_240200_a_,
    						x
    					).replaceInfoValue(
    						BlockModelFields.field_240201_b_,
    						y
    					).replaceInfoValue(
    						BlockModelFields.field_240203_d_,
        					uvlock
        				);
    				}
    			)
    		)	
    	);
    }
	@SuppressWarnings({ "incomplete-switch", "deprecation" })
	public static void buildSlab(Block block, final Map<Block, IFinishedBlockState> blockstatesSave) {
		blockstatesSave.put(
	    	block, 
	    	FinishedVariantBlockState.func_240119_a_(
	    		block
	    	).func_240125_a_(
	    		BlockStateVariantBuilder.func_240133_a_(
	    			SlabBlock.TYPE
	    		).func_240145_a_(
	    			type -> {
	    				ResourceLocation resource = ModelsResourceUtil.func_240221_a_(block);
	    				
	    				switch(type) {
	    					case DOUBLE:
	    						resource = new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString().replace("slab", "block"));
	    						if(!Registry.BLOCK.containsKey(resource)) {
	    							Two.LOGGER.info(resource + " -> ");
		    						resource = new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString().replace("slab", "block").replace("two", "minecraft"));
	    							Two.LOGGER.info(resource); // TODO fix
	    						}
	    						break;
	    					case TOP:
	    						resource = new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString() + "_top");
	    						break;
	    				}
	    		
	    				return BlockModelDefinition.getNewModelDefinition(
	    				).replaceInfoValue(
	    					BlockModelFields.field_240202_c_,
	    					resource
	    				);
	    			}
	    		)
	    	)
	    );
	}
	public static void buildThreeAxis(Block block, final Map<Block, IFinishedBlockState> blockstatesSave) {
		blockstatesSave.put(
	    	block, 
	    	FinishedVariantBlockState.func_240119_a_(
	    		block
	    	).func_240125_a_(
	    		BlockStateVariantBuilder.func_240133_a_(
	    			BlockStateProperties.AXIS
	    		).func_240145_a_(
	    			axis -> {
	    				return BlockModelDefinition.getNewModelDefinition(
	    				).replaceInfoValue(
	    					BlockModelFields.field_240202_c_,
	    					new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString() + (axis == Axis.X || axis == Axis.Z ? "_horizontal" : ""))
	    				).replaceInfoValue(
	    					BlockModelFields.field_240200_a_,
	    					axis == Axis.X || axis == Axis.Z ? Rotation.R90 : Rotation.R0
	    				).replaceInfoValue(
	    					BlockModelFields.field_240201_b_,
	    					axis == Axis.X ? Rotation.R90 : Rotation.R0
	    				);
	    			}
	    		)
	    	)
	    );
	}
    @SuppressWarnings("incomplete-switch")
    public static void buildFenceGate(Block block, final Map<Block, IFinishedBlockState> blockstatesSave) {
    	blockstatesSave.put(
    		block,
    		FinishedVariantBlockState.func_240119_a_(
    			block
    		).func_240125_a_(
    			BlockStateVariantBuilder.func_240135_a_(
    				HorizontalBlock.HORIZONTAL_FACING,
    				BlockStateProperties.OPEN,
    				BlockStateProperties.IN_WALL
    			).func_240160_a_(
    				(direction, open, inWall) -> {
    					BlockModelFields.Rotation rotation = BlockModelFields.Rotation.R0;
    		    		switch(direction) {
    		    			case NORTH:
    		    				rotation = Rotation.R0;
    		    				break;
    		    			case EAST:
    		    				rotation = Rotation.R90;
    		    				break;
    		    			case SOUTH:
    		    				rotation = Rotation.R180;
    		    				break;
    		    			case WEST:
    		    				rotation = Rotation.R270;
    		    		}
    		    		
    		    		ResourceLocation resource = new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString());
    		    		if(open) {
    		    			if(inWall) {
    		    				resource = new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString() + "_wall_open");
    		    			} else {
    		    				resource = new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString() + "_open");
    		    			}
    		    		} else {
    		    			if(inWall) {
    		    				resource = new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString() + "_wall");
    		    			}
    		    		} // TODO refactor to beautfiy
    		    		
    					return BlockModelDefinition.getNewModelDefinition(
    					).replaceInfoValue(
    						BlockModelFields.field_240202_c_,
    						resource
    					).replaceInfoValue(
    						BlockModelFields.field_240201_b_,
    						rotation
    					).replaceInfoValue(
    						BlockModelFields.field_240203_d_,
    						true
    					);
    				}
    			)
    		)	
    	);
    }
    public static void buildFence(Block block, final Map<Block, IFinishedBlockState> blockstatesSave) {
    	blockstatesSave.put(
    		block,
    		FinishedMultiPartBlockState.func_240106_a_(
    			block
    		).func_240111_a_(
        	    BlockModelDefinition.getNewModelDefinition(
        	    ).replaceInfoValue(
        	    	BlockModelFields.field_240202_c_,
        	    	new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString() + "_post")
        	    )
    		).func_240110_a_(
    			new IMultiPartPredicateBuilder.Properties(
    			).func_240098_a_(
    				SixWayBlock.NORTH,
    				true
    			),
    			BlockModelDefinition.getNewModelDefinition(
    			).replaceInfoValue(
    				BlockModelFields.field_240202_c_,
    				new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString() + "_side")
    			).replaceInfoValue(
        			BlockModelFields.field_240203_d_,
        			true
        		)
    		).func_240110_a_(
        		new IMultiPartPredicateBuilder.Properties(
        		).func_240098_a_(
        			SixWayBlock.EAST,
        			true
        		),
        		BlockModelDefinition.getNewModelDefinition(
        		).replaceInfoValue(
        			BlockModelFields.field_240202_c_,
        			new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString() + "_side")
        		).replaceInfoValue(
        	    	BlockModelFields.field_240203_d_,
        	    	true
        	    ).replaceInfoValue(
        	    	BlockModelFields.field_240201_b_,
        	    	Rotation.R90
        	    )
    		).func_240110_a_(
            	new IMultiPartPredicateBuilder.Properties(
            	).func_240098_a_(
            		SixWayBlock.SOUTH,
                    true
                ),
                BlockModelDefinition.getNewModelDefinition(
                ).replaceInfoValue(
                	BlockModelFields.field_240202_c_,
                    new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString() + "_side")
                ).replaceInfoValue(
                	BlockModelFields.field_240203_d_,
                    true
                ).replaceInfoValue(
                	BlockModelFields.field_240201_b_,
                	Rotation.R180
                )
    		).func_240110_a_(
               	new IMultiPartPredicateBuilder.Properties(
                ).func_240098_a_(
                	SixWayBlock.WEST,
                    true
                ),
                BlockModelDefinition.getNewModelDefinition(
                ).replaceInfoValue(
                	BlockModelFields.field_240202_c_,
                    new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString() + "_side")
                ).replaceInfoValue(
                	BlockModelFields.field_240203_d_,
                    true
                ).replaceInfoValue(
                    BlockModelFields.field_240201_b_,
                    Rotation.R270
                )
    		)
    	);
    }
    @SuppressWarnings("incomplete-switch")
    public static void buildFourDirections(Block block, final Map<Block, IFinishedBlockState> blockstatesSave) {
    	blockstatesSave.put(
    		block, 
    		FinishedVariantBlockState.func_240119_a_(
    			block
    		).func_240125_a_(
    			BlockStateVariantBuilder.func_240133_a_(
    				HorizontalBlock.HORIZONTAL_FACING
    			).func_240145_a_(
    				direction -> {
    					BlockModelFields.Rotation rotation = BlockModelFields.Rotation.R0;
    					switch(direction) {
    						case NORTH:
    							rotation = Rotation.R0;
    							break;
    						case EAST:
    							rotation = Rotation.R90;
    							break;
    						case SOUTH:
    							rotation = Rotation.R180;
    							break;
    						case WEST:
    							rotation = Rotation.R270;
    					}
    		
    					return BlockModelDefinition.getNewModelDefinition(
    					).replaceInfoValue(
    						BlockModelFields.field_240202_c_,
    						ModelsResourceUtil.func_240221_a_(block)
    					).replaceInfoValue(
    						BlockModelFields.field_240201_b_,
    						rotation
    					);
    				}
    			)
    		)
    	);
    }
}
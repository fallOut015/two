package io.github.fallout015.two.data.client;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SixWayBlock;
import net.minecraft.data.BlockModelDefinition;
import net.minecraft.data.BlockModelFields;
import net.minecraft.data.BlockStateVariantBuilder;
import net.minecraft.data.FinishedMultiPartBlockState;
import net.minecraft.data.FinishedVariantBlockState;
import net.minecraft.data.IFinishedBlockState;
import net.minecraft.data.IMultiPartPredicateBuilder;
import net.minecraft.data.ModelsResourceUtil;
import net.minecraft.data.BlockModelFields.Rotation;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;

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
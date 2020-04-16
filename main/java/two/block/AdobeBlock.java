package two.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;

public class AdobeBlock extends Block implements IGrowable {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_1;

	public AdobeBlock(Properties properties) {
		super(properties);
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}
	public int getMaxAge() {
		return 1;
	}
	protected int getAge(BlockState state) {
		return state.get(this.getAgeProperty());
	}
	public BlockState withAge(int age) {
		return this.getDefaultState().with(this.getAgeProperty(), Integer.valueOf(age));
	}
	public boolean isMaxAge(BlockState state) {
		return state.get(this.getAgeProperty()) >= this.getMaxAge();
	}
	public void func_225534_a_(BlockState p_225534_1_, ServerWorld p_225534_2_, BlockPos p_225534_3_, Random p_225534_4_) {
	    if (!p_225534_2_.isAreaLoaded(p_225534_3_, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
	    if (p_225534_2_.func_226659_b_(p_225534_3_, 0) >= 9) {
	    	int i = this.getAge(p_225534_1_);
	        if (i < this.getMaxAge()) {
	        	float f = getGrowthChance(this, p_225534_2_, p_225534_3_);
	        	if (ForgeHooks.onCropsGrowPre(p_225534_2_, p_225534_3_, p_225534_1_, p_225534_4_.nextInt((int)(25.0F / f) + 1) == 0)) {
	        		p_225534_2_.setBlockState(p_225534_3_, this.withAge(i + 1), 2);
	        		ForgeHooks.onCropsGrowPost(p_225534_2_, p_225534_3_, p_225534_1_);
	        	}
	        }
	    }
	}
	public void grow(World worldIn, BlockPos pos, BlockState state) {
		if(this.getAge(state) == 1) {
			// TODO for biome temperature checking
			worldIn.setBlockState(pos, BlocksTwo.ADOBE_DRY.getDefaultState());
			return;
		}
		int i = this.getAge(state)/* + this.getBonemealAgeIncrease(worldIn)*/;
	    int j = this.getMaxAge();
	    if (i > j)
	    	i = j;
	    worldIn.setBlockState(pos, this.withAge(i), 2);
	}
	protected static float getGrowthChance(Block blockIn, IBlockReader worldIn, BlockPos pos) {
		float f = 1.0F;
	    BlockPos blockpos = pos.down();

	    for(int i = -1; i <= 1; ++i) {
	    	for(int j = -1; j <= 1; ++j) {
	    		float f1 = 0.0F;
	            BlockState blockstate = worldIn.getBlockState(blockpos.add(i, 0, j));
	            if (blockstate.canSustainPlant(worldIn, blockpos.add(i, 0, j), net.minecraft.util.Direction.UP, (net.minecraftforge.common.IPlantable)blockIn)) {
	            	f1 = 1.0F;
	            	if (blockstate.isFertile(worldIn, blockpos.add(i, 0, j)))
	            		f1 = 3.0F;
	            }

	            if (i != 0 || j != 0)
	            	f1 /= 4.0F;

	            f += f1;
	        }
	    }

	    BlockPos blockpos1 = pos.north();
	    BlockPos blockpos2 = pos.south();
	    BlockPos blockpos3 = pos.west();
	    BlockPos blockpos4 = pos.east();
	    boolean flag = blockIn == worldIn.getBlockState(blockpos3).getBlock() || blockIn == worldIn.getBlockState(blockpos4).getBlock();
	    boolean flag1 = blockIn == worldIn.getBlockState(blockpos1).getBlock() || blockIn == worldIn.getBlockState(blockpos2).getBlock();
	    if (flag && flag1)
	    	f /= 2.0F;
	    else {
	    	boolean flag2 = blockIn == worldIn.getBlockState(blockpos3.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.south()).getBlock() || blockIn == worldIn.getBlockState(blockpos3.south()).getBlock();
	    	if (flag2)
	    		f /= 2.0F;
	    }

	    return f;
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}
	
	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return !this.isMaxAge(state);
	}
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return false;
	}
	@Override
	public void func_225535_a_(ServerWorld serverWorld, Random random, BlockPos blockPos, BlockState blockState) {
		this.grow(serverWorld, blockPos, blockState);
	}
}
package io.github.fallout015.two.entity.ai.goal;

import java.util.EnumSet;

import net.minecraft.block.Block;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.AnimalEntity;

public class RestOnBlockGoal extends Goal {
	private final AnimalEntity animal;
	private final Block block;
	
	public RestOnBlockGoal(AnimalEntity animal, Block block) {
		this.animal = animal;
		this.block = block;
		
		this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}
		   
	@Override
	public boolean shouldExecute() {
		return false;
	}
}
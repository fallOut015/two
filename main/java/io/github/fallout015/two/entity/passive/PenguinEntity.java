package io.github.fallout015.two.entity.passive;

import io.github.fallout015.two.entity.EntityTypeTwo;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class PenguinEntity extends AnimalEntity {
	// penguins have a separate pose for when swimming
	// penguins guard their baby penguins
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.SALMON, Items.COD); // ????

	public PenguinEntity(EntityType<? extends PenguinEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity p_241840_2_) {
		PenguinEntity penguinentity = EntityTypeTwo.PENGUIN.create(serverWorld);
		return penguinentity;
	}
	
	public static AttributeModifierMap.MutableAttribute applyAttributes() {
		return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233821_d_, (double)0.17F).func_233815_a_(Attributes.field_233818_a_, 5.0D);
	}
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 10.0F));
		this.goalSelector.addGoal(5, new PanicGoal(this, 2.0D));
	}
}
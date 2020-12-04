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
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class RedPandaEntity extends AnimalEntity {
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.SWEET_BERRIES); // ????

	public RedPandaEntity(EntityType<? extends RedPandaEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity ageable) {
		RedPandaEntity redpandaentity = EntityTypeTwo.RED_PANDA.get().create(serverWorld);
		return redpandaentity;
	}
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(3, new PanicGoal(this, 2.0D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 0.8D, 1.0000001E-5F));
		this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 10.0F));
		this.goalSelector.addGoal(6, new BreedGoal(this, 0.8D));
		this.goalSelector.addGoal(7, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
	}
	
	public static AttributeModifierMap.MutableAttribute applyAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.16F).createMutableAttribute(Attributes.MAX_HEALTH, 20.0D);
	}
}
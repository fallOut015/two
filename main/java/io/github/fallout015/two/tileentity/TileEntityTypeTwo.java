package io.github.fallout015.two.tileentity;

import io.github.fallout015.two.Two;
import io.github.fallout015.two.block.BlocksTwo;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeTwo {
	private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Two.MODID);

	
	
	public static final RegistryObject<TileEntityType<ChairTileEntity>> CHAIR = TILE_ENTITIES.register("chair", () -> TileEntityType.Builder.create(ChairTileEntity::new, BlocksTwo.CHAIR).build(Util.attemptDataFix(TypeReferences.BLOCK_ENTITY, "chair")));
	
	
	
	public static void register(IEventBus bus) {
		TILE_ENTITIES.register(bus);
	}
}
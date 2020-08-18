package io.github.fallout015.two.tileentity;

import java.util.LinkedList;

import io.github.fallout015.two.block.BlocksTwo;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public class TileEntityTypeTwo {
	public static final TileEntityType<ChairTileEntity> CHAIR = register("chair", TileEntityType.Builder.create(ChairTileEntity::new, BlocksTwo.CHAIR));

	public static void onTileEntitiesRegistry(final RegistryEvent.Register<TileEntityType<?>> tileEntityRegistryEvent) {
		tileEntityRegistryEvent.getRegistry().registerAll(Holder.TILEENTITYTYPESTWO.toArray(new TileEntityType<?> [] {}));
	}
	private static <T extends TileEntity> TileEntityType<T> register(String key, TileEntityType.Builder<T> builder) {
		TileEntityType<T> tileEntityType = builder.build(null);
		tileEntityType.setRegistryName(key);
		Holder.TILEENTITYTYPESTWO.add(tileEntityType);
		return tileEntityType;
	}
	static class Holder {
		public static final LinkedList<TileEntityType<?>> TILEENTITYTYPESTWO = new LinkedList<TileEntityType<?>>();
	}
}

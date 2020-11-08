package io.github.fallout015.two.server;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public abstract class PacketHandler {
	private static int ids;
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
	    new ResourceLocation("two", "main"),
	    () -> PROTOCOL_VERSION,
	    PROTOCOL_VERSION::equals,
	    PROTOCOL_VERSION::equals
	);
	
	final int id;
	
	protected PacketHandler(int id) {
		this.id = id;
	}
	
	public static int getNewID() {
		return ids++;
	}
	
	public static void setup(final FMLCommonSetupEvent event) {
		PacketHandler.INSTANCE.registerMessage(JumpPacketHandler.JUMP_ID, JumpPacketHandler.class, JumpPacketHandler::encoder, JumpPacketHandler::decoder, JumpPacketHandler::handle);
	}
}
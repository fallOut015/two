package io.github.fallout015.two.server;

import java.util.function.Supplier;

import io.github.fallout015.two.Two;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.fml.network.NetworkEvent;

public class JumpPacketHandler extends PacketHandler {
	public static final int JUMP_ID = 0;
	
	public JumpPacketHandler() {
		super(JUMP_ID);
	}
	
	public static void encoder(JumpPacketHandler msg, PacketBuffer buffer) {
		
	}
	public static JumpPacketHandler decoder(PacketBuffer buffer) {
		return new JumpPacketHandler();
	}
	public static void handle(JumpPacketHandler msg, Supplier<NetworkEvent.Context> ctx) {
	    ctx.get().enqueueWork(() -> {
	        ServerPlayerEntity sender = ctx.get().getSender();
	        Two.LOGGER.info("Recieved jump packet on server");
	        if(sender.isAirBorne) {
	        	Two.LOGGER.info("airborne");
	            Vector3d vector3d = sender.getMotion();
	            float f = 0.42f * 10;
	            sender.addVelocity(vector3d.x, (double) f, vector3d.z);
	        }
	    });
	    ctx.get().setPacketHandled(true);
	}
}
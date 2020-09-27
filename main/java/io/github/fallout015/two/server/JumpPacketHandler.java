package io.github.fallout015.two.server;

import java.util.function.Supplier;

import io.github.fallout015.two.Two;
import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.network.NetworkEvent;

public class JumpPacketHandler extends PacketHandler {
	public static final int JUMP_ID = PacketHandler.getNewID();
	
	public JumpPacketHandler() {
		super(JUMP_ID);
	}
	
	public static void encoder(JumpPacketHandler msg, PacketBuffer buffer) {
		Two.LOGGER.info("Encoding {} to ", msg, buffer);
	}
	public static JumpPacketHandler decoder(PacketBuffer buffer) {
		Two.LOGGER.info("Decoding {}", buffer);
		return new JumpPacketHandler();
	}
	public static void handle(JumpPacketHandler msg, Supplier<NetworkEvent.Context> ctx) {
	    ctx.get().enqueueWork(() -> {
	    	Two.LOGGER.info("Recieved jump packet on server");
	    	
	        ServerPlayerEntity sender = ctx.get().getSender();
	        
	        if(!sender.isOnGround() && sender.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemsTwo.DOUBLE_JUMP_BOOTS) {
	        	sender.addVelocity(0, 0.84f, 0);
	        	if(sender.getMotion().getY() > 0.84f) { // clamp velocity
	        		sender.setMotion(sender.getMotion().getX(), 0.84f, sender.getMotion().getX());
	        	}
	        	
//	        	sender.setFire(1);
	        	sender.attackEntityFrom(DamageSource.ON_FIRE, 0);
	        	for(int i = 0; i < 8; ++i) {
	        		double xmod = Math.cos(((360 / 8) * i) * (180d / Math.PI));
	        		double zmod = Math.sin(((360 / 8) * i) * (180d / Math.PI));
		        	sender.getEntityWorld().addParticle(ParticleTypes.CLOUD, sender.getPosX() + xmod, sender.getPosY(), sender.getPosZ() + zmod, zmod, 0.1, xmod);
	        	}
	        }
	    });
	    ctx.get().setPacketHandled(true);
	}
}
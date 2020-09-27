package io.github.fallout015.two.server;

import java.util.function.Supplier;

import io.github.fallout015.two.Two;
import io.github.fallout015.two.item.DoubleJumpBootsItem;
import io.github.fallout015.two.item.ItemsTwo;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.fml.network.NetworkEvent;

public class JumpPacketHandler extends PacketHandler {
	public static final int JUMP_ID = PacketHandler.getNewID();
	
	public JumpPacketHandler() {
		super(JUMP_ID);
	}
	
	public static void encoder(JumpPacketHandler msg, PacketBuffer buffer) {
		Two.LOGGER.debug("Encoding {} to {}", msg, buffer);
	}
	public static JumpPacketHandler decoder(PacketBuffer buffer) {
		Two.LOGGER.debug("Decoding {}", buffer);
		return new JumpPacketHandler();
	}
	public static void handle(JumpPacketHandler msg, Supplier<NetworkEvent.Context> ctx) {
	    ctx.get().enqueueWork(() -> {
	    	Two.LOGGER.debug("Recieved jump packet on server");
	    	
	        ServerPlayerEntity sender = ctx.get().getSender();
	        
	        if(!sender.isOnGround() && !sender.isInWater() && sender.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemsTwo.DOUBLE_JUMP_BOOTS) {
	        	ItemStack bootstack = sender.getItemStackFromSlot(EquipmentSlotType.FEET);
	        	if(!bootstack.getOrCreateTag().contains("jumps")) {
	        		bootstack.getOrCreateTag().putInt("jumps", 0);
	        	}
	        	if(bootstack.getOrCreateTag().contains("jumps") && bootstack.getOrCreateTag().getInt("jumps") < DoubleJumpBootsItem.getJumpLimit(bootstack)) {
	        		bootstack.getOrCreateTag().putInt("jumps", bootstack.getOrCreateTag().getInt("jumps") + 1);
	        	
	        		sender.setMotion(sender.getMotion().getX(), 0, sender.getMotion().getZ());
		        	sender.jump();
		        	sender.velocityChanged = true;
		        	
		        	for(int i = 0; i < 8; ++i) {
		        		double xmod = Math.cos(((360 / 8) * i) * (180d / Math.PI));
		        		double zmod = Math.sin(((360 / 8) * i) * (180d / Math.PI));
			        	sender.getEntityWorld().addParticle(ParticleTypes.CLOUD, sender.getPosX() + xmod, sender.getPosY(), sender.getPosZ() + zmod, zmod, 0.1, xmod);
		        	}
		        	
		        	// let the player know how many uses they have left (xp bar?) and let the player know when the last jump is used
		        	// maybe give the boots a passive glow or particle effect or something that goes away when all of the extra jumps are expended
	        	}
	        }
	    });
	    ctx.get().setPacketHandled(true);
	}
}
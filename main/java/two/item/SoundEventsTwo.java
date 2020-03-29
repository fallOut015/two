package two.item;

import java.util.LinkedList;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public class SoundEventsTwo {
	public static final SoundEvent ITEM_ARMOR_EQUIP_EMERALD = register("item.armor.equip_emerald");
	public static final SoundEvent ITEM_ARMOR_EQUIP_RUBY = register("item.armor.equip_ruby");
	public static final SoundEvent ITEM_ARMOR_EQUIP_LEAD = register("item.armor.equip_lead");
	public static final SoundEvent ITEM_ARMOR_EQUIP_STONE = register("item.armor.equip_stone");
	public static final SoundEvent ITEM_ARMOR_EQUIP_WOOD = register("item.armor.equip_wood");
	public static final SoundEvent ITEM_ARMOR_EQUIP_WOOL = register("item.armor.equip_wool");
	public static final SoundEvent ITEM_ARMOR_EQUIP_SPONGE = register("item.armor.equip_sponge");
	public static final SoundEvent ITEM_ARMOR_EQUIP_GLOWSTONE = register("item.armor.equip_glowstone");
	
	public static void onSoundEventsRegistry(final RegistryEvent.Register<SoundEvent> soundEventRegistryEvent) {
    	//soundEventRegistryEvent.getRegistry().registerAll(Holder.soundEventsTwo.toArray(new SoundEvent[] {}));
	}
	static SoundEvent register(String key) {
		SoundEvent soundEvent = new SoundEvent(new ResourceLocation("two", key));
		Holder.SOUNDEVENTSTWO.add(soundEvent);
		
		return soundEvent;
	}
	static class Holder {
		public static final LinkedList<SoundEvent> SOUNDEVENTSTWO = new LinkedList<SoundEvent>();
	}
}
package io.github.fallout015.two.util;

import java.util.LinkedList;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("two")
public class SoundEventsTwo {
	@ObjectHolder("item.armor.equip_emerald") public static final SoundEvent ITEM_ARMOR_EQUIP_EMERALD = register("item.armor.equip_emerald");
	@ObjectHolder("item.armor.equip_ruby") public static final SoundEvent ITEM_ARMOR_EQUIP_RUBY = register("item.armor.equip_ruby");
	@ObjectHolder("item.armor.equip_lead") public static final SoundEvent ITEM_ARMOR_EQUIP_LEAD = register("item.armor.equip_lead");
	@ObjectHolder("item.armor.equip_titanium") public static final SoundEvent ITEM_ARMOR_EQUIP_TITANIUM = register("item.armor.equip_titanium");
	@ObjectHolder("item.armor.equip_garnet") public static final SoundEvent ITEM_ARMOR_EQUIP_GARNET = register("item.armor.equip_garnet");
	@ObjectHolder("item.armor.equip_topaz") public static final SoundEvent ITEM_ARMOR_EQUIP_TOPAZ = register("item.armor.equip_topaz");
	@ObjectHolder("item.armor.equip_copper") public static final SoundEvent ITEM_ARMOR_EQUIP_COPPER = register("item.armor.equip_copper");
	
	@ObjectHolder("item.armor.equip_stone") public static final SoundEvent ITEM_ARMOR_EQUIP_STONE = register("item.armor.equip_stone");
	@ObjectHolder("item.armor.equip_myrkylite") public static final SoundEvent ITEM_ARMOR_EQUIP_MYRKYLITE = register("item.armor.equip_myrkylite");
	
	@ObjectHolder("item.armor.equip_wood") public static final SoundEvent ITEM_ARMOR_EQUIP_WOOD = register("item.armor.equip_wood");
	@ObjectHolder("item.armor.equip_fungus") public static final SoundEvent ITEM_ARMOR_EQUIP_FUNGUS = register("item.armor.equip_fungus");
	
	@ObjectHolder("item.armor.equip_wool") public static final SoundEvent ITEM_ARMOR_EQUIP_WOOL = register("item.armor.equip_wool");
	
	@ObjectHolder("item.armor.equip_sponge") public static final SoundEvent ITEM_ARMOR_EQUIP_SPONGE = register("item.armor.equip_sponge");
	@ObjectHolder("item.armor.equip_glowstone") public static final SoundEvent ITEM_ARMOR_EQUIP_GLOWSTONE = register("item.armor.equip_glowstone");
	@ObjectHolder("item.armor.equip_obsidian") public static final SoundEvent ITEM_ARMOR_EQUIP_OBSIDIAN = register("item.armor.equip_obsidian");
	
	@ObjectHolder("item.armor.equip_double_jump_boots") public static final SoundEvent ITEM_ARMOR_EQUIP_DOUBLE_JUMP_BOOTS = register("item.armor.equip_double_jump_boots"); // also used for power up sound
	@ObjectHolder("item.armor.off_double_jumps_boots") public static final SoundEvent ITEM_ARMOR_OFF_DOUBLE_JUMP_BOOTS = register("item.armor.off_double_jump_boots"); // used for when the double jump boots run out of double jumps
	@ObjectHolder("item.armor.equip_beaming_boots") public static final SoundEvent ITEM_ARMOR_EQUIP_BEAMING_BOOTS = register("item.armor.equip_beaming_boots");
	@ObjectHolder("item.armor.equip_slime_boots") public static final SoundEvent ITEM_ARMOR_EQUIP_SLIME_BOOTS = register("item.armor.equip_slime_boots");
	@ObjectHolder("item.armor.equip_hermes_helmet") public static final SoundEvent ITEM_ARMOR_EQUIP_HERMES_HELMET = register("item.armor.equip_hermes_helmet");
	
	
	
	@ObjectHolder("gui.upholstery_table.select_template") public static final SoundEvent GUI_UPHOLSTERY_TABLE_SELECT_TEMPLATE = register("gui.upholstery_table.select_template");
	@ObjectHolder("gui.upholstery_table.take_result") public static final SoundEvent GUI_UPHOLSTERY_TABLE_TAKE_RESULT = register("gui.upholstery_table.take_result");
	
	
	
	@ObjectHolder("music.nightmare") public static final SoundEvent MUSIC_NIGHTMARE = register("music.nightmare");
	@ObjectHolder("music.sky") public static final SoundEvent MUSIC_SKY = register("music.sky");
	
	
	
	public static void onSoundEventsRegistry(final RegistryEvent.Register<SoundEvent> soundEventRegistryEvent) {
    	soundEventRegistryEvent.getRegistry().registerAll(Holder.SOUNDEVENTSTWO.toArray(new SoundEvent[] {}));
	}
	static SoundEvent register(String key) {
		SoundEvent soundEvent = new SoundEvent(new ResourceLocation(key));
		Holder.SOUNDEVENTSTWO.add(soundEvent.setRegistryName(key));
		
		return soundEvent;
	}
	static class Holder {
		public static final LinkedList<SoundEvent> SOUNDEVENTSTWO = new LinkedList<SoundEvent>();
	}
}
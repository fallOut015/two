package io.github.fallout015.two.util;

import io.github.fallout015.two.Two;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundEventsTwo {
	private static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Two.MODID);

	
	
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_EMERALD = SOUND_EVENTS.register("item_armor_equip_emerald", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_emerald")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_RUBY = SOUND_EVENTS.register("item_armor_equip_ruby", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_ruby")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_LEAD = SOUND_EVENTS.register("item_armor_equip_lead", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_lead")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_TITANIUM = SOUND_EVENTS.register("item_armor_equip_titanium", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_titanium")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_GARNET = SOUND_EVENTS.register("item_armor_equip_garnet", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_garnet")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_TOPAZ = SOUND_EVENTS.register("item_armor_equip_topaz", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_topaz")));
//	public static final SoundEvent ITEM_ARMOR_EQUIP_COPPER = register("item.armor.equip_copper");
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_STONE = SOUND_EVENTS.register("item_armor_equip_stone", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_stone")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_MYRKYLITE = SOUND_EVENTS.register("item_armor_equip_myrkylite", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_myrkylite")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_WOOD = SOUND_EVENTS.register("item_armor_equip_wood", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_wood")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_FUNGUS = SOUND_EVENTS.register("item_armor_equip_fungus", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_fungus")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_WOOL = SOUND_EVENTS.register("item_armor_equip_wool", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_wool")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_SPONGE = SOUND_EVENTS.register("item_armor_equip_sponge", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_sponge")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_GLOWSTONE = SOUND_EVENTS.register("item_armor_equip_glowstone", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_glowstone")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_OBSIDIAN = SOUND_EVENTS.register("item_armor_equip_obsidian", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_obsidian")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_DOUBLE_JUMP_BOOTS = SOUND_EVENTS.register("item_armor_equip_double_jump_boots", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_double_jump_boots"))); // also used for power up sound
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_OFF_DOUBLE_JUMP_BOOTS = SOUND_EVENTS.register("item_armor_off_double_jump_boots", () -> new SoundEvent(new ResourceLocation("two", "item.armor.off_double_jump_boots"))); // used for when the double jump boots run out of double jumps
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_BEAMING_BOOTS = SOUND_EVENTS.register("item_armor_equip_beaming_boots", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_beaming_boots")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_SLIME_BOOTS = SOUND_EVENTS.register("item_armor_equip_slime_boots", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_slime_boots")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_HERMES_HELMET = SOUND_EVENTS.register("item_armor_equip_hermes_helmet", () -> new SoundEvent(new ResourceLocation("two", "item.armor.equip_hermes_helmet")));
	
	public static final RegistryObject<SoundEvent> GUI_UPHOLSTERY_TABLE_SELECT_TEMPLATE = SOUND_EVENTS.register("gui_upholstery_table_select_template", () -> new SoundEvent(new ResourceLocation("two", "gui.upholstery_table.select_template")));
	public static final RegistryObject<SoundEvent> GUI_UPHOLSTERY_TABLE_TAKE_RESULT = SOUND_EVENTS.register("gui_upholstery_table_take_result", () -> new SoundEvent(new ResourceLocation("two", "gui.upholstery_table.take_result")));
	
	public static final RegistryObject<SoundEvent> MUSIC_NIGHTMARE = SOUND_EVENTS.register("music_nightmare", () -> new SoundEvent(new ResourceLocation("two", "music.nightmare")));
	public static final RegistryObject<SoundEvent> MUSIC_SKY = SOUND_EVENTS.register("music_sky", () -> new SoundEvent(new ResourceLocation("two", "music.sky")));
	
	
	
	public static void register(IEventBus bus) {
		SOUND_EVENTS.register(bus);
	}
}
package io.github.fallout015.two.tags;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class ItemTagsTwo {
	public static final ITag.INamedTag<Item> GEMS_GARNET = ItemTags.makeWrapperTag("forge:gems/garnet");
	public static final ITag.INamedTag<Item> GEMS_TOPAZ = ItemTags.makeWrapperTag("forge:gems/topaz");

	public static final ITag.INamedTag<Item> INGOTS_LEAD = ItemTags.makeWrapperTag("forge:ingots/lead");
	public static final ITag.INamedTag<Item> INGOTS_TITANIUM = ItemTags.makeWrapperTag("forge:ingots/titanium");
}
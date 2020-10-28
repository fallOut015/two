package io.github.fallout015.two.data.client.writer.block;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;

public class SlabWriter extends AbstractWriter {
	public SlabWriter(ResourceLocation resource) {
		super(resource);
	}
	
	@Override
	public JsonElement get() {
		JsonObject jsonobject = new JsonObject();
		jsonobject.addProperty("parent", "minecraft:block/slab");
		JsonObject textures = new JsonObject();
		textures.addProperty("bottom", this.resource.toString());
		textures.addProperty("top", this.resource.toString());
		textures.addProperty("side", this.resource.toString());
		jsonobject.add("textures", textures);
		return jsonobject;
	}
}
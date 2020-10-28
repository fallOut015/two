package io.github.fallout015.two.data.client.writer.block;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;

public class StairsOuterWriter extends AbstractWriter {
	public StairsOuterWriter(ResourceLocation resource) {
		super(resource, "_outer");
	}
	
	@Override
	public JsonElement get() {
		JsonObject jsonobject = new JsonObject();
		jsonobject.addProperty("parent", "minecraft:block/outer_stairs");
		JsonObject textures = new JsonObject();
		textures.addProperty("bottom", this.resource.toString());
		textures.addProperty("top", this.resource.toString());
		textures.addProperty("side", this.resource.toString());
		jsonobject.add("textures", textures);
		return jsonobject;
	}
}
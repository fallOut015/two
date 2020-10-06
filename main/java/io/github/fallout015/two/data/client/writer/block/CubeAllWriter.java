package io.github.fallout015.two.data.client.writer.block;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;

public class CubeAllWriter extends AbstractWriter {
	public CubeAllWriter(ResourceLocation resourceLocation) {
		super(resourceLocation);
	}
	
	@Override
	public JsonElement get() {
		JsonObject jsonobject = new JsonObject();
		jsonobject.addProperty("parent", "minecraft:block/cube_all");
		JsonObject textures = new JsonObject();
		textures.addProperty("all", this.resource.toString());
		jsonobject.add("textures", textures);
		return jsonobject;
	}
}
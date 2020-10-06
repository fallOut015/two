package io.github.fallout015.two.data.client.writer.block;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;

public class CubeColumnWriter extends AbstractWriter {
	public CubeColumnWriter(ResourceLocation resourceLocation) {
		super(resourceLocation);
	}
	
	@Override
	public JsonElement get() {
		JsonObject jsonobject = new JsonObject();
		jsonobject.addProperty("parent", "minecraft:block/cube_column");
		JsonObject textures = new JsonObject();
		textures.addProperty("end", this.resource.toString() + "_top");
		textures.addProperty("side", this.resource.toString());
		jsonobject.add("textures", textures);
		return jsonobject;
	}
}
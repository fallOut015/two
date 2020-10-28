package io.github.fallout015.two.data.client.writer.block;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;

public class FenceSideWriter extends AbstractWriter {
	public FenceSideWriter(ResourceLocation resourceLocation) {
		super(resourceLocation, "_side");
	}
	
	@Override
	public JsonElement get() {
		JsonObject jsonobject = new JsonObject();
		jsonobject.addProperty("parent", "minecraft:block/fence_side");
		JsonObject textures = new JsonObject();
		textures.addProperty("texture", this.resource.toString());
		jsonobject.add("textures", textures);
		return jsonobject;
	}
}
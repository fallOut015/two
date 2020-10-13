package io.github.fallout015.two.data.client.writer.item;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.github.fallout015.two.data.client.writer.block.AbstractWriter;
import net.minecraft.util.ResourceLocation;

public class GeneratedItemWriter extends AbstractWriter {
	public GeneratedItemWriter(ResourceLocation resource) {
		super(resource);
	}
	
	@Override
	public JsonElement get() {
		JsonObject jsonobject = new JsonObject();
		jsonobject.addProperty("parent", "minecraft:item/generated");
		JsonObject textures = new JsonObject();
		textures.addProperty("layer0", this.resource.toString());
		jsonobject.add("textures", textures);
		return jsonobject;
	}
}
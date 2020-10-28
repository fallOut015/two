package io.github.fallout015.two.data.client.writer.block;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;

public class FenceGateOpenWriter extends AbstractWriter {
	public FenceGateOpenWriter(ResourceLocation resourceLocation) {
		super(resourceLocation, "_open");
	}
	
	@Override
	public JsonElement get() {
		JsonObject jsonobject = new JsonObject();
		jsonobject.addProperty("parent", "minecraft:block/template_fence_gate_open");
		JsonObject textures = new JsonObject();
		textures.addProperty("texture", this.resource.toString());
		jsonobject.add("textures", textures);
		return jsonobject;
	}
}
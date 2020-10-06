package io.github.fallout015.two.data.client.writer.block;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;

public class FenceGateWallWriter extends AbstractWriter {
	public FenceGateWallWriter(ResourceLocation resourceLocation) {
		super(resourceLocation, "_wall");
	}
	
	@Override
	public JsonElement get() {
		JsonObject jsonobject = new JsonObject();
		jsonobject.addProperty("parent", "minecraft:block/template_fence_gate_wall");
		JsonObject textures = new JsonObject();
		textures.addProperty("texture", this.resource.toString());
		jsonobject.add("textures", textures);
		return jsonobject;
	}
}
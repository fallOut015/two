package io.github.fallout015.two.data.client.writer.item;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.github.fallout015.two.data.client.writer.block.AbstractWriter;
import net.minecraft.util.ResourceLocation;

public class FenceItemWriter extends AbstractWriter {
	public FenceItemWriter(ResourceLocation resource) {
		super(resource);
	}
	
	@Override
	public JsonElement get() {
		JsonObject jsonobject = new JsonObject();
		jsonobject.addProperty("parent", this.resource.toString() + "_inventory");
		return jsonobject;
	}
}
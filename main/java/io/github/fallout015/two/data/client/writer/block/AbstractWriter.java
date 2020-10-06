package io.github.fallout015.two.data.client.writer.block;

import java.util.function.Supplier;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;

public abstract class AbstractWriter implements Supplier<JsonElement> {
	protected final ResourceLocation resource;
	protected final String fileAppend;
	
	public AbstractWriter(final ResourceLocation resource, final String fileAppend) {
		this.resource = resource;
		this.fileAppend = fileAppend;
	}
	public AbstractWriter(final ResourceLocation resource) {
		this(resource, "");
	}
	
	@Override
	public JsonElement get() {
		JsonObject jsonobject = new JsonObject();
		jsonobject.addProperty("parent", this.resource.toString());
		return jsonobject;
	}
	public final String getFileAppend() {
		return this.fileAppend;
	}
}
package io.github.fallout015.two.data.client;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import io.github.fallout015.two.Two;
import io.github.fallout015.two.data.client.writer.item.GeneratedItemWriter;
import io.github.fallout015.two.data.client.writer.item.HandheldItemWriter;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.data.ModelsResourceUtil;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public abstract class BaseItemModelProvider implements IDataProvider {
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    protected final Map<Item, Function<ResourceLocation, Supplier<JsonElement>>> itemModels = new HashMap<>();
    private final DataGenerator generator;
    
	public BaseItemModelProvider(DataGenerator dataGeneratorIn) {
		this.generator = dataGeneratorIn;
	}
	
    protected abstract void addItemModels();
    protected void addItemModel(Item key, Function<ResourceLocation, Supplier<JsonElement>> value) {
    	this.itemModels.put(key, value);
    }

	public void addHandheldModel(Item item) {
		this.addItemModel(item, HandheldItemWriter::new);
	}
	public void addGeneratedModel(Item item) {
		this.addItemModel(item, GeneratedItemWriter::new);
	}
    
	@Override
	public void act(DirectoryCache cache) {
		this.addItemModels();
		
		Path pathApplicant = this.generator.getOutputFolder();
		
		Map<ResourceLocation, Supplier<JsonElement>> models = Maps.newHashMap();
		
		this.itemModels.forEach((key, value) -> {
			mapModelGen(ModelsResourceUtil.func_240219_a_(key), value.apply(ModelsResourceUtil.func_240219_a_(key)), models);
		});
		
		this.write(cache, pathApplicant, models);
	}

	private void write(DirectoryCache cache, Path pathApplicant, Map<ResourceLocation, ? extends Supplier<JsonElement>> map) {
		map.forEach((key, supplier) -> {
			Path path = pathApplicant.resolve("assets/" + key.getNamespace() + "/models/" + key.getPath() + ".json");

			try {
				IDataProvider.save(GSON, cache, supplier.get(), path);
			} catch (Exception exception) {
	            Two.LOGGER.error("Couldn't save {}", path, exception);
			}
		});
	}
	private static void mapModelGen(ResourceLocation resource, Supplier<JsonElement> supplier, Map<ResourceLocation, Supplier<JsonElement>> map) {
		Supplier<JsonElement> file = map.put(resource, supplier);
		
		if(file != null) {
			throw new IllegalStateException("Duplicate model definition for " + resource);
		}
	}
	
	@Override
	public String getName() {
		return "Item Models";
	}
}
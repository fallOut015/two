package io.github.fallout015.two.data.client;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import io.github.fallout015.two.Two;
import io.github.fallout015.two.data.client.writer.block.AbstractWriter;
import net.minecraft.block.Block;
import net.minecraft.data.BlockModelWriter;
import net.minecraft.data.BlockStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.data.IFinishedBlockState;
import net.minecraft.data.ModelsResourceUtil;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public abstract class BaseBlockStateProvider extends BlockStateProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    protected final Map<Block, IFinishedBlockState> blockstatesSave = new HashMap<>();
    private final DataGenerator generator;
    private final List<StateModelMapper> mappers = new LinkedList<>();
    
	public BaseBlockStateProvider(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
		
		this.generator = dataGeneratorIn;
	}
	
    protected abstract void addBlockstates();
    protected void addMapper(final StateModelMapper stateModelMapper) {
    	this.mappers.add(stateModelMapper);
    }
    
	@Override
	public void act(DirectoryCache cache) {
		this.addBlockstates();
		
		Path pathApplicant = this.generator.getOutputFolder();
		
		Map<Block, IFinishedBlockState> blockstates = Maps.newHashMap();
		Map<ResourceLocation, Supplier<JsonElement>> models = Maps.newHashMap();

		Set<Item> set = Sets.newHashSet();
		final List<Block> list = new LinkedList<>();
		
		this.mappers.forEach(mapper -> {
			Block block = mapper.getBlock();
			Item item = block.asItem();
			
			mapper.getBlockState().accept(mapper.getBlock(), this.blockstatesSave);
			mapBlockstateGen(blockstatesSave.get(block), blockstates);
			for(int index = 0; index < mapper.getBlockModels().size(); ++ index) {
				AbstractWriter writer;
				if(mapper.usesSharedBlock()) {
					writer = (AbstractWriter) mapper.getBlockModels().get(index).apply(ModelsResourceUtil.func_240221_a_(mapper.getSharedBlock()));
				} else {
					writer = (AbstractWriter) mapper.getBlockModels().get(index).apply(ModelsResourceUtil.func_240221_a_(block));
				}
				ResourceLocation resource = new ResourceLocation(ModelsResourceUtil.func_240221_a_(block).toString() + writer.getFileAppend());
				
				mapModelGen(resource, writer, models);

			}
			mapModelGen(ModelsResourceUtil.func_240219_a_(item), mapper.getItemModel().apply(ModelsResourceUtil.func_240221_a_(block)), models);
			
			set.add(Item.BLOCK_TO_ITEM.get(block));
			
			if(!blockstates.containsKey(block)) {
				list.add(block);
			}
		});
		
		if (!list.isEmpty()) {
			throw new IllegalStateException("Missing blockstate definitions for: " + list);
		} else {
			this.blockstatesSave.forEach((block, state) -> {
				Item item = Item.BLOCK_TO_ITEM.get(block);
	            if (item != null) {
	            	if (set.contains(item)) {
	            		return;
	            	}

	            	ResourceLocation resourcelocation = ModelsResourceUtil.func_240219_a_(item);
	            	if (!models.containsKey(resourcelocation)) {
	            		models.put(resourcelocation, new BlockModelWriter(ModelsResourceUtil.func_240221_a_(block)));
	            	}
	            }

			});
			
	 		this.write(cache, pathApplicant, blockstates, BaseBlockStateProvider::blockstateWriter);
	        this.write(cache, pathApplicant, models, BaseBlockStateProvider::modelWriter);
		}
	}
	
	private <T> void write(DirectoryCache cache, Path pathApplicant, Map<T, ? extends Supplier<JsonElement>> map, BiFunction<Path, T, Path> applier) {
		map.forEach((key, supplier) -> {
			Path path = applier.apply(pathApplicant, key);

			try {
				IDataProvider.save(GSON, cache, supplier.get(), path);
			} catch (Exception exception) {
	            Two.LOGGER.error("Couldn't save {}", path, exception);
			}
		});
	}
	
	private static Path blockstateWriter(Path path, Block block) {
		@SuppressWarnings("deprecation")
		ResourceLocation resourcelocation = Registry.BLOCK.getKey(block);
		return path.resolve("assets/" + resourcelocation.getNamespace() + "/blockstates/" + resourcelocation.getPath() + ".json");
	}
	private static Path modelWriter(Path path, ResourceLocation resource) {
		return path.resolve("assets/" + resource.getNamespace() + "/models/" + resource.getPath() + ".json");
	}
	
	private static void mapBlockstateGen(IFinishedBlockState state, Map<Block, IFinishedBlockState> map) {
		Block block = state.func_230524_a_();
		IFinishedBlockState blockstate = map.put(block, state);
		
		if(blockstate != null) {
			throw new IllegalStateException("Duplicate blockstate definition for " + block);
		}
	} // maps the blockstates
	private static void mapModelGen(ResourceLocation resource, Supplier<JsonElement> supplier, Map<ResourceLocation, Supplier<JsonElement>> map) {
		Supplier<JsonElement> file = map.put(resource, supplier);
			
		if (file != null) {
			throw new IllegalStateException("Duplicate model definition for " + resource);
		}
	} // maps the models
}
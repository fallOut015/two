package io.github.fallout015.two.data.server;

import java.nio.file.Path;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.TagsProvider;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TagProviderTwo extends TagsProvider<Item> {
	protected TagProviderTwo(DataGenerator generatorIn, Registry<Item> registryIn, String modId, ExistingFileHelper existingFileHelper) {
		super(generatorIn, registryIn, modId, existingFileHelper);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void registerTags() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Path makePath(ResourceLocation id) {
		// TODO Auto-generated method stub
		return null;
	}
}
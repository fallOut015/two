package io.github.fallout015.two.client.renderer.entity;

import io.github.fallout015.two.client.renderer.entity.model.DarkDwarfArcherModel;
import io.github.fallout015.two.entity.monster.DarkDwarfArcherEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DarkDwarfArcherRenderer extends MobRenderer<DarkDwarfArcherEntity, DarkDwarfArcherModel<DarkDwarfArcherEntity>> {
	public static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/dark_dwarf_archer.png");
	
	public DarkDwarfArcherRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new DarkDwarfArcherModel<>(), 0.75f);
	}

	public ResourceLocation getEntityTexture(DarkDwarfArcherEntity entity) {
		return TEXTURE;
	}
}
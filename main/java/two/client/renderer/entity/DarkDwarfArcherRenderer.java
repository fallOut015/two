package two.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.client.renderer.entity.model.DarkDwarfArcherModel;
import two.entity.monster.DarkDwarfArcherEntity;

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
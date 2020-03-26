package two.client.renderer.entity;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.client.renderer.entity.model.ChameleonModel;
import two.entity.passive.ChameleonEntity;

@OnlyIn(Dist.CLIENT)
public class ChameleonRenderer extends MobRenderer<ChameleonEntity, ChameleonModel<ChameleonEntity>> {
	public static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/chameleon.png");
	
	public ChameleonRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ChameleonModel<>(), 0.25f);
	}

	@SuppressWarnings("deprecation")
	public ResourceLocation getEntityTexture(ChameleonEntity entity) {
		switch(entity.getStandingOn().getRegistryName().toString()) { //Had to convert to string for the switch statement. 
			case "minecraft:air":
			case "minecraft:cave_air":
			case "minecraft:water":
			case "minecraft:flowing_water":
			case "minecraft:lava":
			case "minecraft:flowing_lava":
			case "minecraft:barrier":
				return TEXTURE;
			default:
				BlockState state = entity.getStandingOn().getDefaultState();
				// TODO
				String location;
				try {
					TextureAtlasSprite texture = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(state).getQuads(state, Direction.UP, entity.getRNG()).get(0).getSprite();
					location = texture.getName().getNamespace().replaceFirst("minecraft:", "") + ":textures/" + texture.getName().getPath() + ".png";
				} catch(IndexOutOfBoundsException exception) {
					location = "two:textures/entity/chameleon.png";
				}
				return new ResourceLocation(location);
		}
	}
}
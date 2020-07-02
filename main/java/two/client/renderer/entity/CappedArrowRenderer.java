package two.client.renderer.entity;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.Two;
import two.entity.projectile.CappedArrowEntity;
import two.item.ItemTierTwo;

@OnlyIn(Dist.CLIENT)
public class CappedArrowRenderer extends ArrowRenderer<CappedArrowEntity> {
	private static final ResourceLocation RESOURCE_LOCATION_IRON = new ResourceLocation("two", "textures/entity/projectiles/iron_capped_arrow.png");
	private static final ResourceLocation RESOURCE_LOCATION_WOOD = new ResourceLocation("two", "textures/entity/projectiles/wooden_capped_arrow.png");
	private static final ResourceLocation RESOURCE_LOCATION_STONE = new ResourceLocation("two", "textures/entity/projectiles/stone_capped_arrow.png");
	private static final ResourceLocation RESOURCE_LOCATION_GOLD = new ResourceLocation("two", "textures/entity/projectiles/golden_capped_arrow.png");
	private static final ResourceLocation RESOURCE_LOCATION_DIAMOND = new ResourceLocation("two", "textures/entity/projectiles/diamond_capped_arrow.png");
	private static final ResourceLocation RESOURCE_LOCATION_EMERALD = new ResourceLocation("two", "textures/entity/projectiles/emerald_capped_arrow.png");
	private static final ResourceLocation RESOURCE_LOCATION_RUBY = new ResourceLocation("two", "textures/entity/projectiles/ruby_capped_arrow.png");
	private static final ResourceLocation RESOURCE_LOCATION_LEAD = new ResourceLocation("two", "textures/entity/projectiles/lead_capped_arrow.png");
	private static final ResourceLocation RESOURCE_LOCATION_MYRKYLITE = new ResourceLocation("two", "textures/entity/projectiles/myrkylite_capped_arrow.png");

	private static final Map<IItemTier, ResourceLocation> RESOURCE_FOR_ARROW_TIER = new HashMap<IItemTier, ResourceLocation>(9);
	
	public CappedArrowRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getEntityTexture(CappedArrowEntity entity) {
		Two.LOGGER.info(entity.getItemTier());
		Two.LOGGER.info(RESOURCE_FOR_ARROW_TIER.get(entity.getItemTier()));
		return RESOURCE_FOR_ARROW_TIER.get(entity.getItemTier());
	}
	
	static {
		RESOURCE_FOR_ARROW_TIER.put(ItemTier.IRON, RESOURCE_LOCATION_IRON);
		RESOURCE_FOR_ARROW_TIER.put(ItemTier.WOOD, RESOURCE_LOCATION_WOOD);
		RESOURCE_FOR_ARROW_TIER.put(ItemTier.STONE, RESOURCE_LOCATION_STONE);
		RESOURCE_FOR_ARROW_TIER.put(ItemTier.GOLD, RESOURCE_LOCATION_GOLD);
		RESOURCE_FOR_ARROW_TIER.put(ItemTier.DIAMOND, RESOURCE_LOCATION_DIAMOND);
		RESOURCE_FOR_ARROW_TIER.put(ItemTierTwo.EMERALD, RESOURCE_LOCATION_EMERALD);
		RESOURCE_FOR_ARROW_TIER.put(ItemTierTwo.RUBY, RESOURCE_LOCATION_RUBY);
		RESOURCE_FOR_ARROW_TIER.put(ItemTierTwo.LEAD, RESOURCE_LOCATION_LEAD);
		RESOURCE_FOR_ARROW_TIER.put(ItemTierTwo.MYRKYLITE, RESOURCE_LOCATION_MYRKYLITE);
	}
}
package io.github.fallout015.two.client.renderer.entity;

import java.lang.reflect.Method;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.fallout015.two.client.renderer.entity.model.ChameleonModel;
import io.github.fallout015.two.entity.passive.ChameleonEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;

@OnlyIn(Dist.CLIENT)
public class ChameleonRenderer extends MobRenderer<ChameleonEntity, ChameleonModel<ChameleonEntity>> {
	public static final ResourceLocation TEXTURE = new ResourceLocation("two", "textures/entity/chameleon.png");
	
	public ChameleonRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ChameleonModel<>(), 0.25f);
	}
	
	@SuppressWarnings("deprecation")
	ResourceLocation blockOnResource(ChameleonEntity entity, BlockState blockStateIn) {
		String location;
		try {
			TextureAtlasSprite texture = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(blockStateIn).getQuads(blockStateIn, Direction.UP, entity.getRNG()).get(0).getSprite();
			location = texture.getName().getNamespace().replaceFirst("minecraft:", "") + ":textures/" + texture.getName().getPath() + ".png";
		} catch(IndexOutOfBoundsException exception) {
			location = "two:textures/entity/chameleon.png";
		}
		return new ResourceLocation(location);
	}

	public ResourceLocation getEntityTexture(ChameleonEntity entity) {
		if(entity.blendOff()) {
			return TEXTURE;
		} else if(entity.blend()) {
			entity.updateOn();
		}
		
		switch(entity.getOn().getBlock().getRegistryName().toString()) { //Had to convert to string for the switch statement. 
			case "minecraft:air":
			case "minecraft:cave_air":
			case "minecraft:water":
			case "minecraft:flowing_water":
			case "minecraft:lava":
			case "minecraft:flowing_lava":
			case "minecraft:barrier":
				return TEXTURE;
			default:
				BlockState blockStateIn = entity.getOn();
				return blockOnResource(entity, blockStateIn);
		}
	}
	@Override
	public void render(ChameleonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if(!entityIn.blendOff() && entityIn.getColor() != -1) {
			if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Pre<ChameleonEntity, ChameleonModel<ChameleonEntity>>(entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn))) return;
			matrixStackIn.push();
			this.entityModel.swingProgress = this.getSwingProgress(entityIn, partialTicks);

			boolean shouldSit = entityIn.isPassenger() && (entityIn.getRidingEntity() != null && entityIn.getRidingEntity().shouldRiderSit());
			this.entityModel.isSitting = shouldSit;
			this.entityModel.isChild = entityIn.isChild();
			float f = MathHelper.interpolateAngle(partialTicks, entityIn.prevRenderYawOffset, entityIn.renderYawOffset);
			float f1 = MathHelper.interpolateAngle(partialTicks, entityIn.prevRotationYawHead, entityIn.rotationYawHead);
			float f2 = f1 - f;
			if (shouldSit && entityIn.getRidingEntity() instanceof LivingEntity) {
				LivingEntity livingentity = (LivingEntity)entityIn.getRidingEntity();
				f = MathHelper.interpolateAngle(partialTicks, livingentity.prevRenderYawOffset, livingentity.renderYawOffset);
				f2 = f1 - f;
				float f3 = MathHelper.wrapDegrees(f2);
				if (f3 < -85.0F) {
		            f3 = -85.0F;
				}

				if (f3 >= 85.0F) {
		            f3 = 85.0F;
				}

				f = f1 - f3;
				if (f3 * f3 > 2500.0F) {
		            f += f3 * 0.2F;
				}

				f2 = f1 - f;
			}

			float f6 = MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch);
			if (entityIn.getPose() == Pose.SLEEPING) {
				Direction direction = entityIn.getBedDirection();
				if (direction != null) {
					float f4 = entityIn.getEyeHeight(Pose.STANDING) - 0.1F;
		            matrixStackIn.translate((double)((float)(-direction.getXOffset()) * f4), 0.0D, (double)((float)(-direction.getZOffset()) * f4));
				}
			}

			float f7 = this.handleRotationFloat(entityIn, partialTicks);
			this.applyRotations(entityIn, matrixStackIn, f7, f, partialTicks);
			matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
			this.preRenderCallback(entityIn, matrixStackIn, partialTicks);
			matrixStackIn.translate(0.0D, (double)-1.501F, 0.0D);
			float f8 = 0.0F;
			float f5 = 0.0F;
			if (!shouldSit && entityIn.isAlive()) {
				f8 = MathHelper.lerp(partialTicks, entityIn.prevLimbSwingAmount, entityIn.limbSwingAmount);
				f5 = entityIn.limbSwing - entityIn.limbSwingAmount * (1.0F - partialTicks);
				if (entityIn.isChild()) {
		            f5 *= 3.0F;
				}

				if (f8 > 1.0F) {
		            f8 = 1.0F;
				}
			}

			this.entityModel.setLivingAnimations(entityIn, f5, f8, partialTicks);
			this.entityModel.setRotationAngles(entityIn, f5, f8, f7, f2, f6);
			boolean flag = this.isVisible(entityIn);
			boolean flag1 = !flag && !entityIn.isInvisibleToPlayer(Minecraft.getInstance().player);
			if(entityIn.getOn().getBlock().getTags().contains(Tags.Blocks.GLASS.getName())) {
				flag1 = true;
			}
			RenderType rendertype = this.func_230496_a_(entityIn, flag, flag1, false); // udpate render code, the fourth "false" should be flag2 which controls outlines
			if (rendertype != null) {
				IVertexBuilder ivertexbuilder = bufferIn.getBuffer(rendertype);
				int i = getPackedOverlay(entityIn, this.getOverlayProgress(entityIn, partialTicks));
	            float red = (float)(entityIn.getColor() >> 16 & 255) / 255.0F;
	            float green = (float)(entityIn.getColor() >> 8 & 255) / 255.0F;
	            float blue = (float)(entityIn.getColor() & 255) / 255.0F;
				this.entityModel.render(matrixStackIn, ivertexbuilder, packedLightIn, i, red, green, blue, flag1 ? 0.15F : 1.0F);
			}

			if (!entityIn.isSpectator()) {
				for(LayerRenderer<ChameleonEntity, ChameleonModel<ChameleonEntity>> layerrenderer : this.layerRenderers) {
					layerrenderer.render(matrixStackIn, bufferIn, packedLightIn, entityIn, f5, f8, partialTicks, f7, f2, f6);
				}
			}

			matrixStackIn.pop();
			net.minecraftforge.client.event.RenderNameplateEvent renderNameplateEvent = new net.minecraftforge.client.event.RenderNameplateEvent(entityIn, entityIn.getDisplayName().copyRaw(), this, matrixStackIn, bufferIn, packedLightIn, partialTicks);
			net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(renderNameplateEvent);
			if (renderNameplateEvent.getResult() != net.minecraftforge.eventbus.api.Event.Result.DENY && (renderNameplateEvent.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW || this.canRenderName(entityIn))) {
				this.renderName(entityIn, renderNameplateEvent.getContent(), matrixStackIn, bufferIn, packedLightIn);
			}
			net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Post<ChameleonEntity, ChameleonModel<ChameleonEntity>>(entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn));
		
			Entity entity = entityIn.getLeashHolder();
			if (entity != null) {
				try {
					Method renderLeash = MobRenderer.class.getDeclaredMethod("renderLeash", Object.class, float.class, MatrixStack.class, IRenderTypeBuffer.class, Object.class);
					renderLeash.setAccessible(true);
					renderLeash.invoke((MobRenderer<ChameleonEntity, ChameleonModel<ChameleonEntity>>) this, entityIn, partialTicks, matrixStackIn, bufferIn, entity);
					renderLeash.setAccessible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		}
	}
}
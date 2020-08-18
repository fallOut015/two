package io.github.fallout015.two.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.fallout015.two.entity.monster.DarkDwarfArcherEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DarkDwarfArcherModel<T extends DarkDwarfArcherEntity> extends EntityModel<T> { // todo biped
    public ModelRenderer body;
    public ModelRenderer legRight;
    public ModelRenderer legLeft;
    public ModelRenderer armLeft;
    public ModelRenderer armRight;
    public ModelRenderer head;

    public DarkDwarfArcherModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.body.addBox(-5.0F, -4.0F, -3.0F, 10, 8, 6);
        this.armRight = new ModelRenderer(this, 53, 6);
        this.armRight.setRotationPoint(-6.0F, -3.0F, 0.0F);
        this.armRight.addBox(-1.0F, 0.0F, -1.5F, 2, 6, 3);
        this.legRight = new ModelRenderer(this, 44, 0);
        this.legRight.setRotationPoint(-2.5F, 3.5F, 0.0F);
        this.legRight.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3);
        this.armLeft = new ModelRenderer(this, 32, 9);
        this.armLeft.setRotationPoint(6.0F, -3.0F, 0.0F);
        this.armLeft.addBox(-1.0F, 0.0F, -1.5F, 2, 6, 3);
        this.head = new ModelRenderer(this, 0, 14);
        this.head.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.head.addBox(-3.0F, -2.0F, -2.0F, 6, 4, 4);
        this.legLeft = new ModelRenderer(this, 32, 0);
        this.legLeft.setRotationPoint(2.5F, 3.5F, 0.0F);
        this.legLeft.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3);
        this.body.addChild(this.armRight);
        this.body.addChild(this.legRight);
        this.body.addChild(this.armLeft);
        this.body.addChild(this.head);
        this.body.addChild(this.legLeft);
    }

    @Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		ImmutableList.of(this.body).forEach(modelRenderer -> {
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// TODO
	}
}

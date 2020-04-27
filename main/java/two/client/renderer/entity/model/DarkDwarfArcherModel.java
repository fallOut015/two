package two.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.entity.monster.DarkDwarfArcherEntity;

@OnlyIn(Dist.CLIENT)
public class DarkDwarfArcherModel<T extends DarkDwarfArcherEntity> extends EntityModel<T> {
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
        this.body.func_228300_a_(-5.0F, -4.0F, -3.0F, 10, 8, 6);
        this.armRight = new ModelRenderer(this, 53, 6);
        this.armRight.setRotationPoint(-6.0F, -3.0F, 0.0F);
        this.armRight.func_228300_a_(-1.0F, 0.0F, -1.5F, 2, 6, 3);
        this.legRight = new ModelRenderer(this, 44, 0);
        this.legRight.setRotationPoint(-2.5F, 3.5F, 0.0F);
        this.legRight.func_228300_a_(-1.5F, 0.0F, -1.5F, 3, 6, 3);
        this.armLeft = new ModelRenderer(this, 32, 9);
        this.armLeft.setRotationPoint(6.0F, -3.0F, 0.0F);
        this.armLeft.func_228300_a_(-1.0F, 0.0F, -1.5F, 2, 6, 3);
        this.head = new ModelRenderer(this, 0, 14);
        this.head.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.head.func_228300_a_(-3.0F, -2.0F, -2.0F, 6, 4, 4);
        this.legLeft = new ModelRenderer(this, 32, 0);
        this.legLeft.setRotationPoint(2.5F, 3.5F, 0.0F);
        this.legLeft.func_228300_a_(-1.5F, 0.0F, -1.5F, 3, 6, 3);
        this.body.addChild(this.armRight);
        this.body.addChild(this.legRight);
        this.body.addChild(this.armLeft);
        this.body.addChild(this.head);
        this.body.addChild(this.legLeft);
    }

    @Override
	public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder vertexBuilder, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
		ImmutableList.of(this.body).forEach(modelRenderer -> {
			modelRenderer.func_228309_a_(matrixStack, vertexBuilder, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
		});
	}

	@Override
	public void func_225597_a_(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
		// Rotations
	}
}

package two.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import two.entity.passive.BeardedDragonEntity;

@OnlyIn(Dist.CLIENT)
public class BeardedDragonModel<T extends BeardedDragonEntity> extends EntityModel<T> {
	public ModelRenderer head;
    public ModelRenderer bodyMiddle;
    public ModelRenderer tailFront;
    public ModelRenderer tongueA;
    public ModelRenderer tongueB;
    public ModelRenderer bodyTop;
    public ModelRenderer legTopRight;
    public ModelRenderer legTopLeft;
    public ModelRenderer legBottomLeft;
    public ModelRenderer legBottomRight;
    public ModelRenderer legTopRightFoot;
    public ModelRenderer legTopLeftFoot;
    public ModelRenderer legBottomLeftFoot;
    public ModelRenderer legBottomRightFoot;
    public ModelRenderer tailMiddleA;
    public ModelRenderer tailMiddleB;
    public ModelRenderer tailEnd;
    
    public BeardedDragonModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.tongueA = new ModelRenderer(this, 0, 0);
        this.tongueA.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.tongueA.addBox(-0.5F, 0.0F, -1.0F, 1, 0, 2, 0.0F);
        this.tailFront = new ModelRenderer(this, 16, 0);
        this.tailFront.setRotationPoint(0.0F, 23.5F, 2.9F);
        this.tailFront.addBox(-1.0F, -0.5F, 0.0F, 2, 1, 4, 0.0F);
        this.setRotateAngle(tailFront, 0.08726646259971647F, 0.0F, 0.0F);
        this.legTopRight = new ModelRenderer(this, 32, 0);
        this.legTopRight.setRotationPoint(-2.3F, 0.5F, -2.5F);
        this.legTopRight.addBox(-1.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(legTopRight, 0.0F, -0.7853981633974483F, 0.0F);
        this.legBottomRightFoot = new ModelRenderer(this, 0, 0);
        this.legBottomRightFoot.setRotationPoint(1.5F, 0.3F, 0.0F);
        this.legBottomRightFoot.addBox(-0.5F, 0.0F, -0.5F, 1, 0, 1, 0.0F);
        this.tailMiddleA = new ModelRenderer(this, 54, 0);
        this.tailMiddleA.mirror = true;
        this.tailMiddleA.setRotationPoint(0.0F, -0.2F, 4.8F);
        this.tailMiddleA.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(tailMiddleA, 0.17453292519943295F, 0.0F, 0.0F);
        this.tongueB = new ModelRenderer(this, 0, 0);
        this.tongueB.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.tongueB.addBox(-0.5F, 0.0F, -1.0F, 1, 0, 2, 0.0F);
        this.setRotateAngle(tongueB, 3.141592653589793F, 0.0F, 0.0F);
        this.legBottomLeftFoot = new ModelRenderer(this, 0, 0);
        this.legBottomLeftFoot.setRotationPoint(1.5F, 0.3F, 0.0F);
        this.legBottomLeftFoot.addBox(-0.5F, 0.0F, -0.5F, 1, 0, 1, 0.0F);
        this.tailMiddleB = new ModelRenderer(this, 16, 0);
        this.tailMiddleB.mirror = true;
        this.tailMiddleB.setRotationPoint(0.0F, -0.2F, 1.3F);
        this.tailMiddleB.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tailMiddleB, 0.3490658503988659F, 0.0F, 0.0F);
        this.legTopRightFoot = new ModelRenderer(this, 0, 0);
        this.legTopRightFoot.setRotationPoint(-1.5F, 0.3F, 0.0F);
        this.legTopRightFoot.addBox(-0.5F, 0.0F, -0.5F, 1, 0, 1, 0.0F);
        this.legTopLeftFoot = new ModelRenderer(this, 0, 0);
        this.legTopLeftFoot.setRotationPoint(-1.5F, 0.3F, 0.0F);
        this.legTopLeftFoot.addBox(-0.5F, 0.0F, -0.5F, 1, 0, 1, 0.0F);
        this.legTopLeft = new ModelRenderer(this, 38, 0);
        this.legTopLeft.setRotationPoint(-2.3F, 0.5F, 2.5F);
        this.legTopLeft.addBox(-1.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(legTopLeft, 0.0F, 0.7853981633974483F, 0.0F);
        this.tailEnd = new ModelRenderer(this, 24, 0);
        this.tailEnd.mirror = true;
        this.tailEnd.setRotationPoint(0.0F, -0.2F, 0.6F);
        this.tailEnd.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tailEnd, 0.6981317007977318F, 0.0F, 0.0F);
        this.bodyTop = new ModelRenderer(this, 23, 0);
        this.bodyTop.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.bodyTop.addBox(-1.0F, -0.5F, -2.5F, 2, 1, 5, 0.0F);
        this.legBottomLeft = new ModelRenderer(this, 44, 0);
        this.legBottomLeft.setRotationPoint(2.3F, 0.5F, 2.5F);
        this.legBottomLeft.addBox(-1.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(legBottomLeft, 0.0F, -0.7853981633974483F, 0.0F);
        this.bodyMiddle = new ModelRenderer(this, 2, 0);
        this.bodyMiddle.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.bodyMiddle.addBox(-2.0F, -1.0F, -3.0F, 4, 2, 6, 0.0F);
        this.legBottomRight = new ModelRenderer(this, 50, 0);
        this.legBottomRight.setRotationPoint(2.3F, 0.5F, -2.5F);
        this.legBottomRight.addBox(-1.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(legBottomRight, 0.0F, 0.7853981633974483F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 23.0F, -4.0F);
        this.head.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.head.addChild(this.tongueA);
        this.bodyMiddle.addChild(this.legTopRight);
        this.legBottomRight.addChild(this.legBottomRightFoot);
        this.tailFront.addChild(this.tailMiddleA);
        this.head.addChild(this.tongueB);
        this.legBottomLeft.addChild(this.legBottomLeftFoot);
        this.tailMiddleA.addChild(this.tailMiddleB);
        this.legTopRight.addChild(this.legTopRightFoot);
        this.legTopLeft.addChild(this.legTopLeftFoot);
        this.bodyMiddle.addChild(this.legTopLeft);
        this.tailMiddleB.addChild(this.tailEnd);
        this.bodyMiddle.addChild(this.bodyTop);
        this.bodyMiddle.addChild(this.legBottomLeft);
        this.bodyMiddle.addChild(this.legBottomRight);
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.legBottomLeft.rotateAngleY = MathHelper.cos(limbSwing * 0.06662F + (float)Math.PI) * -1.8F * limbSwingAmount - 0.5F;
    	//this.LegTopRight.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * -1.8F * limbSwingAmount - 0.5F;
    	this.legBottomRight.rotateAngleY = MathHelper.cos(limbSwing * 0.06662F + (float)Math.PI) * 1.8F * limbSwingAmount + 0.5F;
    	//this.LegTopLeft.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.8F * limbSwingAmount + 0.5F;
    	this.tailFront.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.9F * limbSwingAmount; 
	}
	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		ImmutableList.of(this.head, this.bodyMiddle, this.tailFront).forEach(modelRenderer -> {
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}
}
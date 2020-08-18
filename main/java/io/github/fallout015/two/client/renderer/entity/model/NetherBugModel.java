package io.github.fallout015.two.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.fallout015.two.entity.passive.NetherBugEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.6.3
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public class NetherBugModel<T extends NetherBugEntity> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer legA;
	private final ModelRenderer legB;
	private final ModelRenderer legC;
	private final ModelRenderer legD;
	private final ModelRenderer legE;
	private final ModelRenderer legF;
	private final ModelRenderer legG;
	private final ModelRenderer legH;
	private final ModelRenderer shell;
	private final ModelRenderer partA;
	private final ModelRenderer partB;
	private final ModelRenderer partC;
	private final ModelRenderer partD;
	private final ModelRenderer partE;
	private final ModelRenderer antennae;
	private final ModelRenderer right;
	private final ModelRenderer frontright;
	private final ModelRenderer left;
	private final ModelRenderer frontleft;

	public NetherBugModel() {
		textureWidth = 32;
		textureHeight = 48;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(body, 0.0F, 3.1416F, 0.0F);
		body.setTextureOffset(0, 11).addBox(-4.0F, -1.5F, -5.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 2.0F, 9.0F, 0.0F, false);

		legA = new ModelRenderer(this);
		legA.setRotationPoint(4.0F, -1.5F, 3.0F);
		body.addChild(legA);
		setRotationAngle(legA, -0.1309F, -0.3054F, 0.2182F);
		legA.setTextureOffset(18, 11).addBox(-0.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		legB = new ModelRenderer(this);
		legB.setRotationPoint(-4.0F, -1.5F, 3.0F);
		body.addChild(legB);
		setRotationAngle(legB, -0.1309F, 0.3054F, -0.2182F);
		legB.setTextureOffset(18, 11).addBox(-1.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		legC = new ModelRenderer(this);
		legC.setRotationPoint(-4.0F, -1.5F, 1.0F);
		body.addChild(legC);
		setRotationAngle(legC, -0.1309F, 0.1396F, -0.2182F);
		legC.setTextureOffset(18, 11).addBox(-1.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		legD = new ModelRenderer(this);
		legD.setRotationPoint(4.0F, -1.5F, 1.0F);
		body.addChild(legD);
		setRotationAngle(legD, -0.1309F, -0.1396F, 0.2182F);
		legD.setTextureOffset(18, 11).addBox(-0.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		legE = new ModelRenderer(this);
		legE.setRotationPoint(-4.0F, -1.5F, -1.0F);
		body.addChild(legE);
		setRotationAngle(legE, -0.1309F, -0.1396F, -0.2182F);
		legE.setTextureOffset(18, 11).addBox(-1.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		legF = new ModelRenderer(this);
		legF.setRotationPoint(4.0F, -1.5F, -1.0F);
		body.addChild(legF);
		setRotationAngle(legF, -0.1309F, 0.1396F, 0.2182F);
		legF.setTextureOffset(18, 11).addBox(-0.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		legG = new ModelRenderer(this);
		legG.setRotationPoint(-4.0F, -1.5F, -3.0F);
		body.addChild(legG);
		setRotationAngle(legG, -0.1309F, -0.3054F, -0.2182F);
		legG.setTextureOffset(18, 11).addBox(-1.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		legH = new ModelRenderer(this);
		legH.setRotationPoint(4.0F, -1.5F, -3.0F);
		body.addChild(legH);
		setRotationAngle(legH, -0.1309F, 0.3054F, 0.2182F);
		legH.setTextureOffset(18, 11).addBox(-0.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		shell = new ModelRenderer(this);
		shell.setRotationPoint(0.0F, -1.5F, -5.0F);
		body.addChild(shell);
		

		partA = new ModelRenderer(this);
		partA.setRotationPoint(0.0F, 0.0F, 0.0F);
		shell.addChild(partA);
		setRotationAngle(partA, 0.3054F, 0.0F, 0.0F);
		partA.setTextureOffset(0, 13).addBox(-5.0F, -0.5F, -1.0F, 10.0F, 1.0F, 2.0F, 0.0F, false);

		partB = new ModelRenderer(this);
		partB.setRotationPoint(0.5F, -1.0F, 1.0F);
		shell.addChild(partB);
		setRotationAngle(partB, 0.1745F, 0.0F, 0.0F);
		partB.setTextureOffset(0, 16).addBox(-6.0F, 0.0F, -1.0F, 11.0F, 1.0F, 3.0F, 0.0F, false);

		partC = new ModelRenderer(this);
		partC.setRotationPoint(0.0F, 0.0F, 0.0F);
		shell.addChild(partC);
		partC.setTextureOffset(0, 20).addBox(-6.0F, -1.5F, 2.0F, 12.0F, 1.0F, 4.0F, 0.0F, false);

		partD = new ModelRenderer(this);
		partD.setRotationPoint(-0.5F, -0.5F, 3.0F);
		shell.addChild(partD);
		setRotationAngle(partD, -0.0873F, 0.0F, 0.0F);
		partD.setTextureOffset(0, 25).addBox(-5.0F, -1.5F, 2.0F, 11.0F, 1.0F, 4.0F, 0.0F, false);

		partE = new ModelRenderer(this);
		partE.setRotationPoint(-0.5F, -0.5F, 9.0F);
		shell.addChild(partE);
		setRotationAngle(partE, -0.1745F, 0.0F, 0.0F);
		partE.setTextureOffset(0, 30).addBox(-4.5F, -1.0F, -1.0F, 10.0F, 1.0F, 3.0F, 0.0F, false);

		antennae = new ModelRenderer(this);
		antennae.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(antennae);
		

		right = new ModelRenderer(this);
		right.setRotationPoint(1.5F, -1.5F, 6.0F);
		antennae.addChild(right);
		right.setTextureOffset(0, 34).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 0.1F, 4.0F, 0.0F, false);

		frontright = new ModelRenderer(this);
		frontright.setRotationPoint(1.0F, 0.0F, 3.0F);
		right.addChild(frontright);
		setRotationAngle(frontright, 0.0F, 0.8727F, 0.0F);
		frontright.setTextureOffset(10, 34).addBox(-0.1984F, 0.05F, -1.7962F, 1.0F, 0.1F, 3.0F, 0.0F, false);

		left = new ModelRenderer(this);
		left.setRotationPoint(-1.5F, -1.5F, 6.0F);
		antennae.addChild(left);
		left.setTextureOffset(0, 34).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 0.1F, 4.0F, 0.0F, false);

		frontleft = new ModelRenderer(this);
		frontleft.setRotationPoint(1.0F, 0.0F, 3.0F);
		left.addChild(frontleft);
		setRotationAngle(frontleft, 0.0F, -0.8727F, 0.0F);
		frontleft.setTextureOffset(10, 34).addBox(-2.0858F, 0.05F, -0.2469F, 1.0F, 0.1F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}
	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.legA.rotateAngleY = MathHelper.cos(limbSwing * 3.6662F) * 1.4F * limbSwingAmount;
		this.legB.rotateAngleY = MathHelper.cos(limbSwing * 3.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.legC.rotateAngleY = MathHelper.cos(limbSwing * 3.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.legD.rotateAngleY = MathHelper.cos(limbSwing * 3.6662F) * 1.4F * limbSwingAmount;
		this.legE.rotateAngleY = MathHelper.cos(limbSwing * 3.6662F) * 1.4F * limbSwingAmount;
		this.legF.rotateAngleY = MathHelper.cos(limbSwing * 3.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.legG.rotateAngleY = MathHelper.cos(limbSwing * 3.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.legH.rotateAngleY = MathHelper.cos(limbSwing * 3.6662F) * 1.4F * limbSwingAmount;
	
    	this.left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.9F * limbSwingAmount; 
    	this.right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.9F * limbSwingAmount; 
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
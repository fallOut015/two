// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class PenguinModel extends EntityModel<PenguinEntity> {
	private final ModelRenderer body;
	private final ModelRenderer leftFoot;
	private final ModelRenderer rightFoot;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer head;

	public penguin() {
		textureWidth = 32;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-3.0F, -13.0F, -3.0F, 6.0F, 12.0F, 4.0F, 0.0F, false);

		leftFoot = new ModelRenderer(this);
		leftFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(leftFoot);
		leftFoot.setTextureOffset(0, 16).addBox(1.0F, -1.0F, -4.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		rightFoot = new ModelRenderer(this);
		rightFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(rightFoot);
		rightFoot.setTextureOffset(12, 16).addBox(-3.0F, -1.0F, -4.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(4.5F, -11.5F, -0.5F);
		body.addChild(leftArm);
		setRotationAngle(leftArm, 0.0F, 0.0F, -0.1309F);
		leftArm.setTextureOffset(24, 0).addBox(-1.4914F, -0.6305F, -1.5F, 1.0F, 9.0F, 3.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-4.5F, -11.5F, -0.5F);
		body.addChild(rightArm);
		setRotationAngle(rightArm, 0.0F, 0.0F, 0.1309F);
		rightArm.setTextureOffset(24, 12).addBox(0.4914F, -0.6305F, -1.5F, 1.0F, 9.0F, 3.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(head);
		head.setTextureOffset(0, 21).addBox(-2.0F, -17.0F, -2.0F, 4.0F, 4.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(0, 28).addBox(-1.0F, -15.0F, -4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
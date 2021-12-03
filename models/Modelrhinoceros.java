// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelrhinoceros extends EntityModel {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer body_r1;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;

	public Modelrhinoceros() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 10.0F, -16.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.5F, -6.0F, -3.0F, 9, 8, 7, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 0, 44, -3.5F, -12.0F, -7.0F, 7, 14, 4, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 26, 0, -2.5F, -6.0F, -11.0F, 5, 8, 4, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 26, 0, -1.5F, -10.0F, -13.0F, 3, 12, 2, 0.0F, true));

		body = new ModelRenderer(this);
		body.setRotationPoint(2.0F, 9.0F, 12.0F);

		body_r1 = new ModelRenderer(this);
		body_r1.setRotationPoint(-2.0F, 15.0F, -12.0F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, 1.5708F, 0.0F, 0.0F);
		body_r1.cubeList.add(new ModelBox(body_r1, 39, 0, -8.0F, 2.0F, 8.0F, 16, 12, 12, 0.0F, true));
		body_r1.cubeList.add(new ModelBox(body_r1, 0, 19, -9.0F, -12.0F, 8.0F, 18, 14, 14, 0.0F, true));

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(4.5F, 14.0F, 6.0F);
		leg0.cubeList.add(new ModelBox(leg0, 50, 22, -2.0F, 0.0F, -2.0F, 6, 10, 8, 0.0F, true));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-4.5F, 14.0F, 6.0F);
		leg1.cubeList.add(new ModelBox(leg1, 50, 22, -4.0F, 0.0F, -2.0F, 6, 10, 8, 0.0F, true));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(3.5F, 14.0F, -8.0F);
		leg2.cubeList.add(new ModelBox(leg2, 50, 40, -2.0F, 0.0F, -2.0F, 6, 10, 6, 0.0F, true));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-3.5F, 14.0F, -8.0F);
		leg3.cubeList.add(new ModelBox(leg3, 50, 40, -4.0F, 0.0F, -2.0F, 6, 10, 6, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		body.render(f5);
		leg0.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}
// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelpoule extends EntityModel {
	private final ModelRenderer head;
	private final ModelRenderer beak;
	private final ModelRenderer comb;
	private final ModelRenderer body;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer wing0;
	private final ModelRenderer wing1;

	public Modelpoule() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 15.0F, -4.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -2.0F, -6.0F, -2.0F, 4, 6, 3, 0.0F, true));

		beak = new ModelRenderer(this);
		beak.setRotationPoint(0.0F, 15.0F, -4.0F);
		beak.cubeList.add(new ModelBox(beak, 14, 0, -2.0F, -4.0F, -4.0F, 4, 2, 2, 0.0F, true));

		comb = new ModelRenderer(this);
		comb.setRotationPoint(0.0F, 15.0F, -4.0F);
		comb.cubeList.add(new ModelBox(comb, 14, 4, -1.0F, -2.0F, -3.0F, 2, 2, 2, 0.0F, true));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 16.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 9, -3.0F, -4.0F, -3.0F, 6, 8, 6, 0.0F, true));

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(2.0F, 19.0F, 1.0F);
		leg0.cubeList.add(new ModelBox(leg0, 26, 0, -2.0F, 0.0F, -3.0F, 3, 5, 3, 0.0F, true));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-1.0F, 19.0F, 1.0F);
		leg1.cubeList.add(new ModelBox(leg1, 26, 0, -2.0F, 0.0F, -3.0F, 3, 5, 3, 0.0F, true));

		wing0 = new ModelRenderer(this);
		wing0.setRotationPoint(3.0F, 13.0F, 0.0F);
		wing0.cubeList.add(new ModelBox(wing0, 24, 13, 0.0F, 0.0F, -3.0F, 1, 4, 6, 0.0F, true));

		wing1 = new ModelRenderer(this);
		wing1.setRotationPoint(-3.0F, 13.0F, 0.0F);
		wing1.cubeList.add(new ModelBox(wing1, 24, 13, -1.0F, 0.0F, -3.0F, 1, 4, 6, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		beak.render(f5);
		comb.render(f5);
		body.render(f5);
		leg0.render(f5);
		leg1.render(f5);
		wing0.render(f5);
		wing1.render(f5);
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
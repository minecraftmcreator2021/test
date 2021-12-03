package net.mcreator.minecraftrpg.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.minecraftrpg.entity.RhinocerosEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class RhinocerosRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(RhinocerosEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelrhinoceros(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("minecraft_rpg:textures/rhinoceros.png");
					}
				};
			});
		}
	}

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
			addBoxHelper(head, 0, 0, -4.5F, -6.0F, -3.0F, 9, 8, 7, 0.0F, true);
			addBoxHelper(head, 0, 44, -3.5F, -12.0F, -7.0F, 7, 14, 4, 0.0F, true);
			addBoxHelper(head, 26, 0, -2.5F, -6.0F, -11.0F, 5, 8, 4, 0.0F, true);
			addBoxHelper(head, 26, 0, -1.5F, -10.0F, -13.0F, 3, 12, 2, 0.0F, true);
			body = new ModelRenderer(this);
			body.setRotationPoint(2.0F, 9.0F, 12.0F);
			body_r1 = new ModelRenderer(this);
			body_r1.setRotationPoint(-2.0F, 15.0F, -12.0F);
			body.addChild(body_r1);
			setRotationAngle(body_r1, 1.5708F, 0.0F, 0.0F);
			addBoxHelper(body_r1, 39, 0, -8.0F, 2.0F, 8.0F, 16, 12, 12, 0.0F, true);
			addBoxHelper(body_r1, 0, 19, -9.0F, -12.0F, 8.0F, 18, 14, 14, 0.0F, true);
			leg0 = new ModelRenderer(this);
			leg0.setRotationPoint(4.5F, 14.0F, 6.0F);
			addBoxHelper(leg0, 50, 22, -2.0F, 0.0F, -2.0F, 6, 10, 8, 0.0F, true);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(-4.5F, 14.0F, 6.0F);
			addBoxHelper(leg1, 50, 22, -4.0F, 0.0F, -2.0F, 6, 10, 8, 0.0F, true);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(3.5F, 14.0F, -8.0F);
			addBoxHelper(leg2, 50, 40, -2.0F, 0.0F, -2.0F, 6, 10, 6, 0.0F, true);
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(-3.5F, 14.0F, -8.0F);
			addBoxHelper(leg3, 50, 40, -4.0F, 0.0F, -2.0F, 6, 10, 6, 0.0F, true);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			head.render(ms, vb, i1, i2, f1, f2, f3, f4);
			body.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg0.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg1.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg2.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg3.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta) {
		addBoxHelper(renderer, texU, texV, x, y, z, dx, dy, dz, delta, renderer.mirror);
	}

	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta,
			boolean mirror) {
		renderer.mirror = mirror;
		renderer.addBox("", x, y, z, dx, dy, dz, delta, texU, texV);
	}
}

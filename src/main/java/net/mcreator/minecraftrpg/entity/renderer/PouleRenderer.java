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

import net.mcreator.minecraftrpg.entity.PouleEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class PouleRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(PouleEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelpoule(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("minecraft_rpg:textures/poule.png");
					}
				};
			});
		}
	}

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
			addBoxHelper(head, 0, 0, -2.0F, -6.0F, -2.0F, 4, 6, 3, 0.0F, true);
			beak = new ModelRenderer(this);
			beak.setRotationPoint(0.0F, 15.0F, -4.0F);
			addBoxHelper(beak, 14, 0, -2.0F, -4.0F, -4.0F, 4, 2, 2, 0.0F, true);
			comb = new ModelRenderer(this);
			comb.setRotationPoint(0.0F, 15.0F, -4.0F);
			addBoxHelper(comb, 14, 4, -1.0F, -2.0F, -3.0F, 2, 2, 2, 0.0F, true);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 16.0F, 0.0F);
			addBoxHelper(body, 0, 9, -3.0F, -4.0F, -3.0F, 6, 8, 6, 0.0F, true);
			leg0 = new ModelRenderer(this);
			leg0.setRotationPoint(2.0F, 19.0F, 1.0F);
			addBoxHelper(leg0, 26, 0, -2.0F, 0.0F, -3.0F, 3, 5, 3, 0.0F, true);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(-1.0F, 19.0F, 1.0F);
			addBoxHelper(leg1, 26, 0, -2.0F, 0.0F, -3.0F, 3, 5, 3, 0.0F, true);
			wing0 = new ModelRenderer(this);
			wing0.setRotationPoint(3.0F, 13.0F, 0.0F);
			addBoxHelper(wing0, 24, 13, 0.0F, 0.0F, -3.0F, 1, 4, 6, 0.0F, true);
			wing1 = new ModelRenderer(this);
			wing1.setRotationPoint(-3.0F, 13.0F, 0.0F);
			addBoxHelper(wing1, 24, 13, -1.0F, 0.0F, -3.0F, 1, 4, 6, 0.0F, true);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			head.render(ms, vb, i1, i2, f1, f2, f3, f4);
			beak.render(ms, vb, i1, i2, f1, f2, f3, f4);
			comb.render(ms, vb, i1, i2, f1, f2, f3, f4);
			body.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg0.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg1.render(ms, vb, i1, i2, f1, f2, f3, f4);
			wing0.render(ms, vb, i1, i2, f1, f2, f3, f4);
			wing1.render(ms, vb, i1, i2, f1, f2, f3, f4);
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

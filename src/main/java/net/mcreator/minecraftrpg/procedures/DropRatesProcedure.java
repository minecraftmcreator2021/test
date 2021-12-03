package net.mcreator.minecraftrpg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.minecraftrpg.item.YatorbsItem;
import net.mcreator.minecraftrpg.entity.RhinocerosEntity;
import net.mcreator.minecraftrpg.entity.PouleEntity;
import net.mcreator.minecraftrpg.MinecraftRpgMod;

import java.util.Map;
import java.util.HashMap;

public class DropRatesProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityDeath(LivingDeathEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency entity for procedure DropRates!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency x for procedure DropRates!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency y for procedure DropRates!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency z for procedure DropRates!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency world for procedure DropRates!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity instanceof PouleEntity.CustomEntity)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(YatorbsItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 5));
			}
			if ((Math.random() > 0.2)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		}
		if ((entity instanceof RhinocerosEntity.CustomEntity)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(YatorbsItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 3000000));
			}
			if ((Math.random() > 0.2)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.TRIDENT));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}

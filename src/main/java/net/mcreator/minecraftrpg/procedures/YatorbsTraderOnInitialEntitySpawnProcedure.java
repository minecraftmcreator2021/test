package net.mcreator.minecraftrpg.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.minecraftrpg.MinecraftRpgMod;

import java.util.Map;

public class YatorbsTraderOnInitialEntitySpawnProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency entity for procedure YatorbsTraderOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("itemTrade1", 1);
		entity.getPersistentData().putDouble("itemTrade2", 2);
		entity.getPersistentData().putDouble("itemTrade3", 3);
		entity.getPersistentData().putDouble("itemTrade4", 4);
		entity.getPersistentData().putDouble("itemTrade5", 5);
		entity.getPersistentData().putDouble("itemTrade6", 6);
	}
}

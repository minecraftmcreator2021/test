package net.mcreator.minecraftrpg.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.minecraftrpg.MinecraftRpgMod;

import java.util.Map;

public class VampireProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency sourceentity for procedure Vampire!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof LivingEntity)
			((LivingEntity) sourceentity)
					.setHealth((float) (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1) + 1));
	}
}

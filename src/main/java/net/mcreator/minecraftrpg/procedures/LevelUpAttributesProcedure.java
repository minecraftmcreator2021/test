package net.mcreator.minecraftrpg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.minecraftrpg.MinecraftRpgMod;

import java.util.Map;
import java.util.HashMap;

public class LevelUpAttributesProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerXPChange(PlayerXpEvent.XpChange event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				int amount = event.getAmount();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("amount", amount);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency entity for procedure LevelUpAttributes!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		((LivingEntity) entity).getAttribute(Attributes.MAX_HEALTH)
				.setBaseValue((20 + (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) * 0.1)));
		((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE)
				.setBaseValue((((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue()
						+ (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) * 0.1)));
		((LivingEntity) entity).getAttribute(Attributes.ARMOR).setBaseValue((((LivingEntity) entity).getAttribute(Attributes.ARMOR).getBaseValue()
				+ (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) * 0.1)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1e+31,
					(int) (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) * 0.005)));
	}
}

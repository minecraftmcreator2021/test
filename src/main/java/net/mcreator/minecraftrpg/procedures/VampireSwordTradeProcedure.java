package net.mcreator.minecraftrpg.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.minecraftrpg.item.VampireSwordItem;
import net.mcreator.minecraftrpg.item.ThousandYatorbsItem;
import net.mcreator.minecraftrpg.item.HundredYatorbsItem;
import net.mcreator.minecraftrpg.MinecraftRpgMod;

import java.util.Map;

public class VampireSwordTradeProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency entity for procedure VampireSwordTrade!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency sourceentity for procedure VampireSwordTrade!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double hundred_yatorbs = 0;
		if (((sourceentity instanceof PlayerEntity)
				? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(ThousandYatorbsItem.block))
				: false)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(HundredYatorbsItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 10,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(VampireSwordItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not enough Yatorbs!"), (false));
			}
		}
	}
}

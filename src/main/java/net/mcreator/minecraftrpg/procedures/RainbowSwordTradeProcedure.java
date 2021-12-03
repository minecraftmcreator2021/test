package net.mcreator.minecraftrpg.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.minecraftrpg.item.ThousandYatorbsItem;
import net.mcreator.minecraftrpg.item.RainbowSwordItem;
import net.mcreator.minecraftrpg.MinecraftRpgMod;

import java.util.Map;

public class RainbowSwordTradeProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency entity for procedure RainbowSwordTrade!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ThousandYatorbsItem.block)) : false)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(ThousandYatorbsItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(RainbowSwordItem.block);
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

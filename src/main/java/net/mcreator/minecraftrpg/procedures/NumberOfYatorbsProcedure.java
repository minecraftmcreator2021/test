package net.mcreator.minecraftrpg.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.minecraftrpg.item.YatorbsItem;
import net.mcreator.minecraftrpg.item.ThousandYatorbsItem;
import net.mcreator.minecraftrpg.item.TenYatorbsItem;
import net.mcreator.minecraftrpg.item.HundredYatorbsItem;
import net.mcreator.minecraftrpg.MinecraftRpgMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import java.util.HashMap;

public class NumberOfYatorbsProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency entity for procedure NumberOfYatorbs!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency world for procedure NumberOfYatorbs!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double yatorb = 0;
		double ten_yatorbs = 0;
		double hundred_yatorbs = 0;
		yatorb = (double) 0;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if ((YatorbsItem.block == (itemstackiterator).getItem())) {
						yatorb = (double) (yatorb + (((itemstackiterator)).getCount()));
					}
				}
			}
		}
		if ((yatorb >= 10)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(YatorbsItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 10,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(TenYatorbsItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent(
								(("The") + "" + (((yatorb) + "" + (" yatorbs in your inventory have been changed in the an equivalent!"))))),
						(false));
			}
		}
		ten_yatorbs = (double) 0;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if ((TenYatorbsItem.block == (itemstackiterator).getItem())) {
						ten_yatorbs = (double) (ten_yatorbs + (((itemstackiterator)).getCount()));
					}
				}
			}
		}
		if ((ten_yatorbs >= 10)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(TenYatorbsItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 10,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(HundredYatorbsItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent(
								(("The") + "" + (((ten_yatorbs) + "" + ("ten_yatorbs in your inventory have been changed in the an equivalent!"))))),
						(false));
			}
		}
		hundred_yatorbs = (double) 0;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if ((HundredYatorbsItem.block == (itemstackiterator).getItem())) {
						hundred_yatorbs = (double) (hundred_yatorbs + (((itemstackiterator)).getCount()));
					}
				}
			}
		}
		if ((hundred_yatorbs >= 10)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(HundredYatorbsItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 10,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(ThousandYatorbsItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						(("The") + "" + (((hundred_yatorbs) + "" + ("hundred_yatorbs in your inventory have been changed in the an equivalent!"))))),
						(false));
			}
		}
	}
}

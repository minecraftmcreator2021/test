package net.mcreator.minecraftrpg.procedures;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.minecraftrpg.gui.GuiMarchandGui;
import net.mcreator.minecraftrpg.MinecraftRpgModVariables;
import net.mcreator.minecraftrpg.MinecraftRpgMod;

import java.util.Map;

import io.netty.buffer.Unpooled;

public class YatorbsTraderRightClickedOnEntityProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency entity for procedure YatorbsTraderRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency sourceentity for procedure YatorbsTraderRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency x for procedure YatorbsTraderRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency y for procedure YatorbsTraderRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency z for procedure YatorbsTraderRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftRpgMod.LOGGER.warn("Failed to load dependency world for procedure YatorbsTraderRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		MinecraftRpgModVariables.MapVariables.get(world).guiItemTrade1 = (double) (entity.getPersistentData().getDouble("itemTrade1"));
		MinecraftRpgModVariables.MapVariables.get(world).syncData(world);
		MinecraftRpgModVariables.MapVariables.get(world).guiItemTrade2 = (double) (entity.getPersistentData().getDouble("itemTrade2"));
		MinecraftRpgModVariables.MapVariables.get(world).syncData(world);
		MinecraftRpgModVariables.MapVariables.get(world).guiItemTrade3 = (double) (entity.getPersistentData().getDouble("itemTrade3"));
		MinecraftRpgModVariables.MapVariables.get(world).syncData(world);
		MinecraftRpgModVariables.MapVariables.get(world).guiItemTrade4 = (double) (entity.getPersistentData().getDouble("itemTrade4"));
		MinecraftRpgModVariables.MapVariables.get(world).syncData(world);
		MinecraftRpgModVariables.MapVariables.get(world).guiItemTrade5 = (double) (entity.getPersistentData().getDouble("itemTrade5"));
		MinecraftRpgModVariables.MapVariables.get(world).syncData(world);
		MinecraftRpgModVariables.MapVariables.get(world).guiItemTrade6 = (double) (entity.getPersistentData().getDouble("itemTrade6"));
		MinecraftRpgModVariables.MapVariables.get(world).syncData(world);
		{
			Entity _ent = sourceentity;
			if (_ent instanceof ServerPlayerEntity) {
				BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
				NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("GuiMarchand");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						return new GuiMarchandGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}

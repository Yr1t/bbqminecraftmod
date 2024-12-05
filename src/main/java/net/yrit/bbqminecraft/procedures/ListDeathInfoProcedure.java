package net.yrit.bbqminecraft.procedures;

import net.yrit.bbqminecraft.network.BbqMinecraftModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class ListDeathInfoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("" + (entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BbqMinecraftModVariables.PlayerVariables())).DeathX)), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("" + (entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BbqMinecraftModVariables.PlayerVariables())).DeathY)), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("" + (entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BbqMinecraftModVariables.PlayerVariables())).DeathZ)), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("" + (entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BbqMinecraftModVariables.PlayerVariables())).DeathDimension)), false);
	}
}

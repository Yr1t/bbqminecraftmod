package net.yrit.bbqminecraft.procedures;

import net.yrit.bbqminecraft.network.BbqMinecraftModVariables;

import net.minecraft.world.entity.Entity;

public class DisableToolAbilityOnKeypressProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = !(entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BbqMinecraftModVariables.PlayerVariables())).RightClickAbilityEnabled;
			entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.RightClickAbilityEnabled = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}

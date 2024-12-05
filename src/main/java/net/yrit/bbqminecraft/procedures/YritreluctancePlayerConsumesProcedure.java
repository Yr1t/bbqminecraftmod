package net.yrit.bbqminecraft.procedures;

import net.yrit.bbqminecraft.network.BbqMinecraftModVariables;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class YritreluctancePlayerConsumesProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BbqMinecraftModVariables.PlayerVariables())).DrankYritReluctance == false) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							("dimtp " + entity.getDisplayName().getString() + " \"" + (entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BbqMinecraftModVariables.PlayerVariables())).DeathDimension + "\" "
									+ (entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BbqMinecraftModVariables.PlayerVariables())).DeathX + " "
									+ (entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BbqMinecraftModVariables.PlayerVariables())).DeathY + " "
									+ (entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BbqMinecraftModVariables.PlayerVariables())).DeathZ));
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(2);
			itemstack.shrink(1);
			{
				boolean _setval = true;
				entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DrankYritReluctance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You've already used this in your current life!"), true);
		}
	}
}

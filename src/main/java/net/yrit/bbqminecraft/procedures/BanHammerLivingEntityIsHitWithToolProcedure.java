package net.yrit.bbqminecraft.procedures;

import net.yrit.bbqminecraft.BbqMinecraftMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class BanHammerLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity.hasPermissions(3)) {
			if (entity instanceof Player || entity instanceof ServerPlayer) {
				if (entity.hasPermissions(3)) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Nuh uh!"), true);
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList()
								.broadcastSystemMessage(Component.literal((sourceentity.getDisplayName().getString() + " has unleashed the Ban Hammer on " + entity.getDisplayName().getString() + "! But there's no effect...")), false);
				} else {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("bbq_minecraft:almighty")))), 2147483647);
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("ban " + entity.getDisplayName().getString()));
						}
					}
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((sourceentity.getDisplayName().getString() + " has unleashed the Ban Hammer on " + entity.getDisplayName().getString() + "!")), false);
				}
			} else {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("bbq_minecraft:almighty")))), 2147483647);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((sourceentity.getDisplayName().getString() + " has unleashed the Ban Hammer on " + entity.getDisplayName().getString() + "!")), false);
			}
		} else {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You don't have OP. How'd you get this?"), true);
			BbqMinecraftMod.LOGGER.warn((sourceentity.getDisplayName().getString() + " got access to the Ban Hammer without OP. Is something going on?"));
		}
	}
}

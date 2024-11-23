package net.yrit.bbqminecraft.procedures;

import net.yrit.bbqminecraft.network.BbqMinecraftModVariables;
import net.yrit.bbqminecraft.init.BbqMinecraftModMobEffects;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RageOverlayDisplayOverlayIngameProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static boolean execute(Entity entity) {
		return execute(null, entity);
	}

	private static boolean execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return false;
		if (((entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BbqMinecraftModVariables.PlayerVariables())).RageActive && entity instanceof LivingEntity _livEnt0
				&& _livEnt0.hasEffect(BbqMinecraftModMobEffects.SATAN_SLASHING.get())) == true) {
			return true;
		}
		return false;
	}
}

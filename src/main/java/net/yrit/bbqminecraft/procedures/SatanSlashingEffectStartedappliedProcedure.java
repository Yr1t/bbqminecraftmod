package net.yrit.bbqminecraft.procedures;

import net.yrit.bbqminecraft.init.BbqMinecraftModMobEffects;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class SatanSlashingEffectStartedappliedProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(BbqMinecraftModMobEffects.SATAN_SLASHING.get())) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
					.hasModifier((new AttributeModifier(UUID.fromString("325275b6-936b-462b-ab92-5d02473736b8"), "SatanHealth", 30, AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.addTransientModifier((new AttributeModifier(UUID.fromString("325275b6-936b-462b-ab92-5d02473736b8"), "SatanHealth", 30, AttributeModifier.Operation.ADDITION)));
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.hasModifier((new AttributeModifier(UUID.fromString("328bab5a-e57f-11ee-b95d-325096b39f47"), "SatanSpeed", 0.2, AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
						.addTransientModifier((new AttributeModifier(UUID.fromString("328bab5a-e57f-11ee-b95d-325096b39f47"), "SatanSpeed", 0.2, AttributeModifier.Operation.ADDITION)));
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
					.hasModifier((new AttributeModifier(UUID.fromString("328baa2e-e57f-11ee-bc66-325096b39f47"), "SatanAttk", 2, AttributeModifier.Operation.MULTIPLY_TOTAL)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
						.addTransientModifier((new AttributeModifier(UUID.fromString("328baa2e-e57f-11ee-bc66-325096b39f47"), "SatanAttk", 2, AttributeModifier.Operation.MULTIPLY_TOTAL)));
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED)
					.hasModifier((new AttributeModifier(UUID.fromString("328ba97a-e57f-11ee-9083-325096b39f47"), "SatanAttkSpd", 0.7, AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED)
						.addTransientModifier((new AttributeModifier(UUID.fromString("328ba97a-e57f-11ee-9083-325096b39f47"), "SatanAttkSpd", 0.7, AttributeModifier.Operation.ADDITION)));
		}
	}
}

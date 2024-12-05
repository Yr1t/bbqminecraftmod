package net.yrit.bbqminecraft.procedures;

import net.yrit.bbqminecraft.init.BbqMinecraftModMobEffects;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class EOBEffectStartProcedureProcedure {
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
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(BbqMinecraftModMobEffects.ESSENCE_OF_BBQ.get())) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
					.hasModifier((new AttributeModifier(UUID.fromString("c9e9006d-bf60-4e0a-adc2-c96eec26da18"), "BBQ Resistance ", 10, AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
						.addTransientModifier((new AttributeModifier(UUID.fromString("c9e9006d-bf60-4e0a-adc2-c96eec26da18"), "BBQ Resistance ", 10, AttributeModifier.Operation.ADDITION)));
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
					.hasModifier((new AttributeModifier(UUID.fromString("e2c8cebc-073d-4111-adc0-79de7aa18cf2"), "BBQ Strength", 10, AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
						.addTransientModifier((new AttributeModifier(UUID.fromString("e2c8cebc-073d-4111-adc0-79de7aa18cf2"), "BBQ Strength", 10, AttributeModifier.Operation.ADDITION)));
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
					.hasModifier((new AttributeModifier(UUID.fromString("75240bdc-0bc8-4d69-b39a-04874a4dc257"), "BBQ Toughness", 5, AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
						.addTransientModifier((new AttributeModifier(UUID.fromString("75240bdc-0bc8-4d69-b39a-04874a4dc257"), "BBQ Toughness", 5, AttributeModifier.Operation.ADDITION)));
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
					.hasModifier((new AttributeModifier(UUID.fromString("9eb43710-c701-4242-ac65-820f13a9c8f1"), "BBQ Hearts", 20, AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.addTransientModifier((new AttributeModifier(UUID.fromString("9eb43710-c701-4242-ac65-820f13a9c8f1"), "BBQ Hearts", 20, AttributeModifier.Operation.ADDITION)));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 5));
		}
	}
}

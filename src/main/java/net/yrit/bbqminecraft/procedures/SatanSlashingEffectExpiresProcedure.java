package net.yrit.bbqminecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class SatanSlashingEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
				.removeModifier((new AttributeModifier(UUID.fromString("325275b6-936b-462b-ab92-5d02473736b8"), "SatanHealth", 30, AttributeModifier.Operation.ADDITION)));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
				.removeModifier((new AttributeModifier(UUID.fromString("328bab5a-e57f-11ee-b95d-325096b39f47"), "SatanSpeed", 0.2, AttributeModifier.Operation.ADDITION)));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
				.removeModifier((new AttributeModifier(UUID.fromString("328baa2e-e57f-11ee-bc66-325096b39f47"), "SatanAttk", 2, AttributeModifier.Operation.MULTIPLY_TOTAL)));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED)
				.removeModifier((new AttributeModifier(UUID.fromString("328ba97a-e57f-11ee-9083-325096b39f47"), "SatanAttkSpd", 0.7, AttributeModifier.Operation.ADDITION)));
	}
}

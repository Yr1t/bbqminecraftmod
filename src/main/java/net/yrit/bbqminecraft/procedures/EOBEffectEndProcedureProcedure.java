package net.yrit.bbqminecraft.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class EOBEffectEndProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).removeModifier(UUID.fromString("c9e9006d-bf60-4e0a-adc2-c96eec26da18"));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).removeModifier(UUID.fromString("e2c8cebc-073d-4111-adc0-79de7aa18cf2"));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).removeModifier(UUID.fromString("75240bdc-0bc8-4d69-b39a-04874a4dc257"));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).removeModifier(UUID.fromString("9eb43710-c701-4242-ac65-820f13a9c8f1"));
	}
}

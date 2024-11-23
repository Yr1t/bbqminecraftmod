package net.yrit.bbqminecraft.procedures;

import net.yrit.bbqminecraft.init.BbqMinecraftModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

public class BBQSauceGiveEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(BbqMinecraftModMobEffects.ESSENCE_OF_BBQ.get(), 3600, 0));
	}
}

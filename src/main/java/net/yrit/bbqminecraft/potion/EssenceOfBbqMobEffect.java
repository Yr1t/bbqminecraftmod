
package net.yrit.bbqminecraft.potion;

import net.yrit.bbqminecraft.procedures.EOBEffectStartProcedureProcedure;
import net.yrit.bbqminecraft.procedures.EOBEffectEndProcedureProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class EssenceOfBbqMobEffect extends MobEffect {
	public EssenceOfBbqMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -12510711);
	}

	@Override
	public String getDescriptionId() {
		return "effect.bbq_minecraft.essence_of_bbq";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		EOBEffectStartProcedureProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		EOBEffectEndProcedureProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

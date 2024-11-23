
package net.yrit.bbqminecraft.potion;

import net.yrit.bbqminecraft.procedures.SatanSlashingEffectStartedappliedProcedure;
import net.yrit.bbqminecraft.procedures.SatanSlashingEffectExpiresProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class SatanSlashingMobEffect extends MobEffect {
	public SatanSlashingMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -8192000);
	}

	@Override
	public String getDescriptionId() {
		return "effect.bbq_minecraft.satan_slashing";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		SatanSlashingEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		SatanSlashingEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

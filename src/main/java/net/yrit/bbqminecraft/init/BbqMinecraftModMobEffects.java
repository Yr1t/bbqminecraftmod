
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.yrit.bbqminecraft.init;

import net.yrit.bbqminecraft.potion.SatanSlashingMobEffect;
import net.yrit.bbqminecraft.potion.EssenceOfBbqMobEffect;
import net.yrit.bbqminecraft.BbqMinecraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class BbqMinecraftModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BbqMinecraftMod.MODID);
	public static final RegistryObject<MobEffect> ESSENCE_OF_BBQ = REGISTRY.register("essence_of_bbq", () -> new EssenceOfBbqMobEffect());
	public static final RegistryObject<MobEffect> SATAN_SLASHING = REGISTRY.register("satan_slashing", () -> new SatanSlashingMobEffect());
}

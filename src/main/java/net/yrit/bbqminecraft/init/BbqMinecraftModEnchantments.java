
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.yrit.bbqminecraft.init;

import net.yrit.bbqminecraft.enchantment.EssenceofRageEnchantment;
import net.yrit.bbqminecraft.BbqMinecraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

public class BbqMinecraftModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, BbqMinecraftMod.MODID);
	public static final RegistryObject<Enchantment> ESSENCEOF_RAGE = REGISTRY.register("essenceof_rage", () -> new EssenceofRageEnchantment());
}

package net.yrit.bbqminecraft.procedures;

import net.yrit.bbqminecraft.init.BbqMinecraftModEnchantments;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;

public class BBQJuggernautSpecialInformationProcedure {
	public static String execute(ItemStack itemstack) {
		if ((EnchantmentHelper.getItemEnchantmentLevel(BbqMinecraftModEnchantments.ESSENCEOF_RAGE.get(), itemstack) != 0) == true) {
			return "\u00A75Right click to \u00A74enter \u00A7lRAGE.";
		}
		return "\u00A75Right click to launch fireball.";
	}
}

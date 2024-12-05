
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.yrit.bbqminecraft.init;

import net.yrit.bbqminecraft.BbqMinecraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class BbqMinecraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BbqMinecraftMod.MODID);
	public static final RegistryObject<CreativeModeTab> BBQ_CREATIVE = REGISTRY.register("bbq_creative",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.bbq_minecraft.bbq_creative")).icon(() -> new ItemStack(BbqMinecraftModItems.BBQ_INGOT.get())).displayItems((parameters, tabData) -> {
				tabData.accept(BbqMinecraftModItems.BBQ_JUGGERNAUT.get());
				tabData.accept(BbqMinecraftModItems.BBQ_HELMET.get());
				tabData.accept(BbqMinecraftModItems.BBQ_CHESTPLATE.get());
				tabData.accept(BbqMinecraftModItems.BBQ_LEGGINGS.get());
				tabData.accept(BbqMinecraftModItems.BBQ_BOOTS.get());
				tabData.accept(BbqMinecraftModItems.STEW_GOLD.get());
				tabData.accept(BbqMinecraftModItems.BBQ_INGOT.get());
				tabData.accept(BbqMinecraftModItems.BBQSMITHINGTEMPLATE.get());
				tabData.accept(BbqMinecraftModItems.BBQ_SAUCE.get());
				tabData.accept(BbqMinecraftModItems.BBQSTEW.get());
				tabData.accept(BbqMinecraftModItems.BBQ_ESSENCE.get());
				tabData.accept(BbqMinecraftModBlocks.BBQ_ORE.get().asItem());
				tabData.accept(BbqMinecraftModBlocks.DIAMOND_BONG.get().asItem());
				tabData.accept(BbqMinecraftModBlocks.BLOCKED_WALL.get().asItem());
				tabData.accept(BbqMinecraftModItems.ONE_HIT_OBLITERATOR.get());
				tabData.accept(BbqMinecraftModItems.BAN_HAMMER.get());
				tabData.accept(BbqMinecraftModItems.LORD_BBQ_SUMMON.get());
				tabData.accept(BbqMinecraftModItems.YRITRELUCTANCE.get());
			})

					.build());
}

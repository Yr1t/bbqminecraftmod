
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.yrit.bbqminecraft.init;

import net.yrit.bbqminecraft.item.StewGoldItem;
import net.yrit.bbqminecraft.item.OneHitObliteratorItem;
import net.yrit.bbqminecraft.item.BbqstewItem;
import net.yrit.bbqminecraft.item.BbqsmithingtemplateItem;
import net.yrit.bbqminecraft.item.BbqIngotItem;
import net.yrit.bbqminecraft.item.BanHammerItem;
import net.yrit.bbqminecraft.item.BBQSauceItem;
import net.yrit.bbqminecraft.item.BBQJuggernautItem;
import net.yrit.bbqminecraft.item.BBQItem;
import net.yrit.bbqminecraft.item.BBQEssenceItem;
import net.yrit.bbqminecraft.BbqMinecraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class BbqMinecraftModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BbqMinecraftMod.MODID);
	public static final RegistryObject<Item> BBQ_JUGGERNAUT = REGISTRY.register("bbq_juggernaut", () -> new BBQJuggernautItem());
	public static final RegistryObject<Item> BBQ_HELMET = REGISTRY.register("bbq_helmet", () -> new BBQItem.Helmet());
	public static final RegistryObject<Item> BBQ_CHESTPLATE = REGISTRY.register("bbq_chestplate", () -> new BBQItem.Chestplate());
	public static final RegistryObject<Item> BBQ_LEGGINGS = REGISTRY.register("bbq_leggings", () -> new BBQItem.Leggings());
	public static final RegistryObject<Item> BBQ_BOOTS = REGISTRY.register("bbq_boots", () -> new BBQItem.Boots());
	public static final RegistryObject<Item> STEW_GOLD = REGISTRY.register("stew_gold", () -> new StewGoldItem());
	public static final RegistryObject<Item> BBQ_INGOT = REGISTRY.register("bbq_ingot", () -> new BbqIngotItem());
	public static final RegistryObject<Item> BBQSMITHINGTEMPLATE = REGISTRY.register("bbqsmithingtemplate", () -> new BbqsmithingtemplateItem());
	public static final RegistryObject<Item> BBQ_SAUCE = REGISTRY.register("bbq_sauce", () -> new BBQSauceItem());
	public static final RegistryObject<Item> BBQSTEW = REGISTRY.register("bbqstew", () -> new BbqstewItem());
	public static final RegistryObject<Item> BBQ_ESSENCE = REGISTRY.register("bbq_essence", () -> new BBQEssenceItem());
	public static final RegistryObject<Item> BBQ_ORE = block(BbqMinecraftModBlocks.BBQ_ORE);
	public static final RegistryObject<Item> DIAMOND_BONG = block(BbqMinecraftModBlocks.DIAMOND_BONG);
	public static final RegistryObject<Item> BLOCKED_WALL = block(BbqMinecraftModBlocks.BLOCKED_WALL);
	public static final RegistryObject<Item> ONE_HIT_OBLITERATOR = REGISTRY.register("one_hit_obliterator", () -> new OneHitObliteratorItem());
	public static final RegistryObject<Item> BAN_HAMMER = REGISTRY.register("ban_hammer", () -> new BanHammerItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}

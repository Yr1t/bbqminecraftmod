
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.yrit.bbqminecraft.init;

import net.yrit.bbqminecraft.block.DiamondBongBlock;
import net.yrit.bbqminecraft.block.BlockedWallBlock;
import net.yrit.bbqminecraft.block.BBQOreBlock;
import net.yrit.bbqminecraft.BbqMinecraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class BbqMinecraftModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BbqMinecraftMod.MODID);
	public static final RegistryObject<Block> BBQ_ORE = REGISTRY.register("bbq_ore", () -> new BBQOreBlock());
	public static final RegistryObject<Block> DIAMOND_BONG = REGISTRY.register("diamond_bong", () -> new DiamondBongBlock());
	public static final RegistryObject<Block> BLOCKED_WALL = REGISTRY.register("blocked_wall", () -> new BlockedWallBlock());
}

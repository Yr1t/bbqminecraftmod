package net.yrit.bbqminecraft.procedures;

import net.yrit.bbqminecraft.BbqMinecraftMod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BbqlordtrueformOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BbqMinecraftMod.queueServerWork(10, () -> {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.LAVA || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.LAVA) {
				world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.RED_NETHER_BRICKS.defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.COBWEB) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		});
	}
}

package net.yrit.bbqminecraft.procedures;

import net.minecraft.world.entity.Entity;

public class BbqlordtrueformOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("DrankBBQ", 0);
	}
}

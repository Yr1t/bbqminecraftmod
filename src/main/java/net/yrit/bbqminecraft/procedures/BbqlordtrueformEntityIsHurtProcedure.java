package net.yrit.bbqminecraft.procedures;

import net.yrit.bbqminecraft.init.BbqMinecraftModMobEffects;
import net.yrit.bbqminecraft.init.BbqMinecraftModItems;
import net.yrit.bbqminecraft.BbqMinecraftMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class BbqlordtrueformEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double bbqdrunk = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2 && entity.getPersistentData().getDouble("DrankBBQ") == 0) {
			entity.getPersistentData().putDouble("DrankBBQ", 1);
			if (entity instanceof Mob _entity)
				_entity.getNavigation().stop();
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 90000, 99, false, false));
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(BbqMinecraftModItems.BBQ_SAUCE.get());
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			BbqMinecraftMod.queueServerWork(20, () -> {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.OFF_HAND, true);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<The BBQ Lord> *glug glug glug*"), false);
				BbqMinecraftMod.queueServerWork(20, () -> {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.OFF_HAND, true);
					BbqMinecraftMod.queueServerWork(20, () -> {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.OFF_HAND, true);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(BbqMinecraftModMobEffects.ESSENCE_OF_BBQ.get(), 3600, 0));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 1));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 8));
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
							_level.addFreshEntity(entityToSpawn);
						}
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Blocks.AIR);
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					});
				});
			});
		} else if (Math.abs(entity.getX()) - Math.abs(sourceentity.getX()) >= 5 || Math.abs(entity.getX()) - Math.abs(sourceentity.getX()) <= -5 || Math.abs(entity.getZ()) - Math.abs(sourceentity.getZ()) >= 5
				|| Math.abs(entity.getZ()) - Math.abs(sourceentity.getZ()) <= -5 || Math.abs(entity.getY()) - Math.abs(sourceentity.getY()) >= 5 || Math.abs(entity.getY()) - Math.abs(sourceentity.getY()) <= -5) {
			if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
				_entity.setTarget(_ent);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ())));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("bbq_minecraft:almighty"))), entity),
					(float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 2));
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("<The BBQ Lord> Come fight me face to face, coward!"), false);
		}
	}
}

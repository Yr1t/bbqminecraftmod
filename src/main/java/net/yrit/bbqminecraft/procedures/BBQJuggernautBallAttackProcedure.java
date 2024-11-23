package net.yrit.bbqminecraft.procedures;

import net.yrit.bbqminecraft.network.BbqMinecraftModVariables;
import net.yrit.bbqminecraft.init.BbqMinecraftModMobEffects;
import net.yrit.bbqminecraft.init.BbqMinecraftModEntities;
import net.yrit.bbqminecraft.init.BbqMinecraftModEnchantments;
import net.yrit.bbqminecraft.entity.BBQBlastEntity;
import net.yrit.bbqminecraft.BbqMinecraftMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class BBQJuggernautBallAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BbqMinecraftModVariables.PlayerVariables())).RightClickAbilityEnabled == true) {
			if ((EnchantmentHelper.getItemEnchantmentLevel(BbqMinecraftModEnchantments.ESSENCEOF_RAGE.get(), itemstack) != 0) == true) {
				{
					boolean _setval = true;
					entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.RageActive = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(BbqMinecraftModMobEffects.SATAN_SLASHING.get(), 900, 0));
				BbqMinecraftMod.queueServerWork(899, () -> {
					{
						boolean _setval = false;
						entity.getCapability(BbqMinecraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.RageActive = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(700, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 14400);
				});
			} else {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new BBQBlastEntity(BbqMinecraftModEntities.BBQ_BLAST.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								entityToSpawn.setPierceLevel(piercing);
								entityToSpawn.setSecondsOnFire(100);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 10, 5, (byte) 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 4, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(700, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 60);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Right click ability for your tool is currently disabled."), true);
		}
	}
}

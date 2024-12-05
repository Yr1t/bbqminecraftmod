package net.yrit.bbqminecraft.procedures;

import net.yrit.bbqminecraft.init.BbqMinecraftModEntities;
import net.yrit.bbqminecraft.entity.BBQBlastEntity;
import net.yrit.bbqminecraft.BbqMinecraftMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class ThebbqlordEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Mob _entity)
			_entity.getNavigation().stop();
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("<The BBQ Lord> ARRRRGHHHHHHHH!!"), false);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 30000, 99, false, false));
		BbqMinecraftMod.queueServerWork(20, () -> {
			BbqMinecraftMod.queueServerWork(7, () -> {
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
						}.getArrow(projectileLevel, entity, 5, 1, (byte) 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				BbqMinecraftMod.queueServerWork(7, () -> {
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
							}.getArrow(projectileLevel, entity, 5, 1, (byte) 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					BbqMinecraftMod.queueServerWork(7, () -> {
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
								}.getArrow(projectileLevel, entity, 5, 1, (byte) 1);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, (float) 0.4);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						BbqMinecraftMod.queueServerWork(7, () -> {
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
									}.getArrow(projectileLevel, entity, 5, 1, (byte) 1);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, (float) 0.4);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
							BbqMinecraftMod.queueServerWork(7, () -> {
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
										}.getArrow(projectileLevel, entity, 5, 1, (byte) 1);
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, (float) 0.4);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
								BbqMinecraftMod.queueServerWork(7, () -> {
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
											}.getArrow(projectileLevel, entity, 5, 1, (byte) 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, (float) 0.4);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
									BbqMinecraftMod.queueServerWork(7, () -> {
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
												}.getArrow(projectileLevel, entity, 5, 1, (byte) 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, (float) 0.4);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										BbqMinecraftMod.queueServerWork(7, () -> {
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
													}.getArrow(projectileLevel, entity, 5, 1, (byte) 1);
													_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
													_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, (float) 0.4);
													projectileLevel.addFreshEntity(_entityToSpawn);
												}
											}
											BbqMinecraftMod.queueServerWork(7, () -> {
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
														}.getArrow(projectileLevel, entity, 5, 1, (byte) 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, (float) 0.4);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												BbqMinecraftMod.queueServerWork(7, () -> {
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
															}.getArrow(projectileLevel, entity, 5, 1, (byte) 1);
															_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
															_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, (float) 0.4);
															projectileLevel.addFreshEntity(_entityToSpawn);
														}
													}
													BbqMinecraftMod.queueServerWork(7, () -> {
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
																}.getArrow(projectileLevel, entity, 5, 1, (byte) 1);
																_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
																_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, (float) 0.4);
																projectileLevel.addFreshEntity(_entityToSpawn);
															}
														}
														BbqMinecraftMod.queueServerWork(7, () -> {
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
																	}.getArrow(projectileLevel, entity, 5, 1, (byte) 1);
																	_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
																	_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, (float) 0.4);
																	projectileLevel.addFreshEntity(_entityToSpawn);
																}
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
																_level.addFreshEntity(entityToSpawn);
															}
															if (!entity.level().isClientSide())
																entity.discard();
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("<The BBQ Lord> It seems you require divine punishment!"), false);
															if (world instanceof ServerLevel _level) {
																Entity entityToSpawn = BbqMinecraftModEntities.BBQLORDTRUEFORM.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
																if (entityToSpawn != null) {
																}
															}
															if (!world.isClientSide() && world.getServer() != null)
																world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("<The BBQ Lord> It seems you require divine punishment, " + sourceentity.getDisplayName().getString() + "!")),
																		false);
														});
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			});
		});
	}
}

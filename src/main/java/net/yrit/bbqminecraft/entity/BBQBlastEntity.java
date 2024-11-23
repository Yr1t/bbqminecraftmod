
package net.yrit.bbqminecraft.entity;

import net.yrit.bbqminecraft.procedures.BBQBlastProjectileHitsProcedure;
import net.yrit.bbqminecraft.init.BbqMinecraftModItems;
import net.yrit.bbqminecraft.init.BbqMinecraftModEntities;

import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class BBQBlastEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(BbqMinecraftModItems.BBQ_ESSENCE.get());

	public BBQBlastEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(BbqMinecraftModEntities.BBQ_BLAST.get(), world);
	}

	public BBQBlastEntity(EntityType<? extends BBQBlastEntity> type, Level world) {
		super(type, world);
	}

	public BBQBlastEntity(EntityType<? extends BBQBlastEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public BBQBlastEntity(EntityType<? extends BBQBlastEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void playerTouch(Player entity) {
		super.playerTouch(entity);
		BBQBlastProjectileHitsProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		BBQBlastProjectileHitsProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		BBQBlastProjectileHitsProcedure.execute(this.level(), blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ());
	}

	@Override
	public void tick() {
		super.tick();
		if (this.inGround)
			this.discard();
	}

	public static BBQBlastEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 6f, 10, 5);
	}

	public static BBQBlastEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		BBQBlastEntity entityarrow = new BBQBlastEntity(BbqMinecraftModEntities.BBQ_BLAST.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		entityarrow.setSecondsOnFire(100);
		world.addFreshEntity(entityarrow);
		return entityarrow;
	}

	public static BBQBlastEntity shoot(LivingEntity entity, LivingEntity target) {
		BBQBlastEntity entityarrow = new BBQBlastEntity(BbqMinecraftModEntities.BBQ_BLAST.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 6f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(10);
		entityarrow.setKnockback(5);
		entityarrow.setCritArrow(false);
		entityarrow.setSecondsOnFire(100);
		entity.level().addFreshEntity(entityarrow);
		return entityarrow;
	}
}

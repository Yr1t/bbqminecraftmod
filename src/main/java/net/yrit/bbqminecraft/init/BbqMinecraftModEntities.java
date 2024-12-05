
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.yrit.bbqminecraft.init;

import net.yrit.bbqminecraft.entity.ThebbqlordEntity;
import net.yrit.bbqminecraft.entity.BbqlordtrueformEntity;
import net.yrit.bbqminecraft.entity.BBQBlastEntity;
import net.yrit.bbqminecraft.BbqMinecraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BbqMinecraftModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BbqMinecraftMod.MODID);
	public static final RegistryObject<EntityType<BBQBlastEntity>> BBQ_BLAST = register("projectile_bbq_blast",
			EntityType.Builder.<BBQBlastEntity>of(BBQBlastEntity::new, MobCategory.MISC).setCustomClientFactory(BBQBlastEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ThebbqlordEntity>> THEBBQLORD = register("thebbqlord", EntityType.Builder.<ThebbqlordEntity>of(ThebbqlordEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(80)
			.setUpdateInterval(3).setCustomClientFactory(ThebbqlordEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BbqlordtrueformEntity>> BBQLORDTRUEFORM = register("bbqlordtrueform", EntityType.Builder.<BbqlordtrueformEntity>of(BbqlordtrueformEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(70).setUpdateInterval(3).setCustomClientFactory(BbqlordtrueformEntity::new).fireImmune().sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ThebbqlordEntity.init();
			BbqlordtrueformEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(THEBBQLORD.get(), ThebbqlordEntity.createAttributes().build());
		event.put(BBQLORDTRUEFORM.get(), BbqlordtrueformEntity.createAttributes().build());
	}
}

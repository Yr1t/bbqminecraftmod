
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.yrit.bbqminecraft.init;

import net.yrit.bbqminecraft.client.renderer.ThebbqlordRenderer;
import net.yrit.bbqminecraft.client.renderer.BbqlordtrueformRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BbqMinecraftModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(BbqMinecraftModEntities.BBQ_BLAST.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(BbqMinecraftModEntities.THEBBQLORD.get(), ThebbqlordRenderer::new);
		event.registerEntityRenderer(BbqMinecraftModEntities.BBQLORDTRUEFORM.get(), BbqlordtrueformRenderer::new);
	}
}

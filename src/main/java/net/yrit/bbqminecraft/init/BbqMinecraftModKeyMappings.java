
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.yrit.bbqminecraft.init;

import org.lwjgl.glfw.GLFW;

import net.yrit.bbqminecraft.network.DisableToolAbilityBindingMessage;
import net.yrit.bbqminecraft.BbqMinecraftMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class BbqMinecraftModKeyMappings {
	public static final KeyMapping DISABLE_TOOL_ABILITY_BINDING = new KeyMapping("key.bbq_minecraft.disable_tool_ability_binding", GLFW.GLFW_KEY_G, "key.categories.bbq") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BbqMinecraftMod.PACKET_HANDLER.sendToServer(new DisableToolAbilityBindingMessage(0, 0));
				DisableToolAbilityBindingMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(DISABLE_TOOL_ABILITY_BINDING);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				DISABLE_TOOL_ABILITY_BINDING.consumeClick();
			}
		}
	}
}

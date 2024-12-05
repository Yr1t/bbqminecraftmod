package net.yrit.bbqminecraft.network;

import net.yrit.bbqminecraft.BbqMinecraftMod;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BbqMinecraftModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		BbqMinecraftMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.DeathX = original.DeathX;
			clone.DeathY = original.DeathY;
			clone.DeathZ = original.DeathZ;
			clone.DeathDimension = original.DeathDimension;
			if (!event.isWasDeath()) {
				clone.RightClickAbilityEnabled = original.RightClickAbilityEnabled;
				clone.RageActive = original.RageActive;
				clone.rageattk = original.rageattk;
				clone.ragespeed = original.ragespeed;
				clone.rageattkspd = original.rageattkspd;
				clone.ragehealth = original.ragehealth;
				clone.HighActive = original.HighActive;
				clone.DrankYritReluctance = original.DrankYritReluctance;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("bbq_minecraft", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean RightClickAbilityEnabled = true;
		public boolean RageActive = false;
		public double rageattk = 0;
		public double ragespeed = 0;
		public double rageattkspd = 0;
		public double ragehealth = 0;
		public boolean HighActive = false;
		public double DeathX = 0;
		public double DeathY = 256.0;
		public double DeathZ = 0;
		public boolean DrankYritReluctance = false;
		public String DeathDimension = "\"\"";

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				BbqMinecraftMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("RightClickAbilityEnabled", RightClickAbilityEnabled);
			nbt.putBoolean("RageActive", RageActive);
			nbt.putDouble("rageattk", rageattk);
			nbt.putDouble("ragespeed", ragespeed);
			nbt.putDouble("rageattkspd", rageattkspd);
			nbt.putDouble("ragehealth", ragehealth);
			nbt.putBoolean("HighActive", HighActive);
			nbt.putDouble("DeathX", DeathX);
			nbt.putDouble("DeathY", DeathY);
			nbt.putDouble("DeathZ", DeathZ);
			nbt.putBoolean("DrankYritReluctance", DrankYritReluctance);
			nbt.putString("DeathDimension", DeathDimension);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			RightClickAbilityEnabled = nbt.getBoolean("RightClickAbilityEnabled");
			RageActive = nbt.getBoolean("RageActive");
			rageattk = nbt.getDouble("rageattk");
			ragespeed = nbt.getDouble("ragespeed");
			rageattkspd = nbt.getDouble("rageattkspd");
			ragehealth = nbt.getDouble("ragehealth");
			HighActive = nbt.getBoolean("HighActive");
			DeathX = nbt.getDouble("DeathX");
			DeathY = nbt.getDouble("DeathY");
			DeathZ = nbt.getDouble("DeathZ");
			DrankYritReluctance = nbt.getBoolean("DrankYritReluctance");
			DeathDimension = nbt.getString("DeathDimension");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.RightClickAbilityEnabled = message.data.RightClickAbilityEnabled;
					variables.RageActive = message.data.RageActive;
					variables.rageattk = message.data.rageattk;
					variables.ragespeed = message.data.ragespeed;
					variables.rageattkspd = message.data.rageattkspd;
					variables.ragehealth = message.data.ragehealth;
					variables.HighActive = message.data.HighActive;
					variables.DeathX = message.data.DeathX;
					variables.DeathY = message.data.DeathY;
					variables.DeathZ = message.data.DeathZ;
					variables.DrankYritReluctance = message.data.DrankYritReluctance;
					variables.DeathDimension = message.data.DeathDimension;
				}
			});
			context.setPacketHandled(true);
		}
	}
}

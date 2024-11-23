
package net.yrit.bbqminecraft.command;

import org.checkerframework.checker.units.qual.s;

import net.yrit.bbqminecraft.procedures.BBQTpWhenRanProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class BbqTpCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("dimtp").requires(s -> s.hasPermission(3)).then(Commands.argument("Player", EntityArgument.player()).then(Commands.argument("dim", StringArgumentType.string())
				.then(Commands.argument("X", DoubleArgumentType.doubleArg()).then(Commands.argument("Y", DoubleArgumentType.doubleArg()).then(Commands.argument("Z", DoubleArgumentType.doubleArg()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					BBQTpWhenRanProcedure.execute(arguments, entity);
					return 0;
				})))))));
	}
}

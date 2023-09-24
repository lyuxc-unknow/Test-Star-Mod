package me.lyuxc.develop.event;

import me.lyuxc.develop.Star;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Calendar;
import java.util.Objects;

@Mod.EventBusSubscriber
public class onCommandRegistry {
    @SubscribeEvent
    public static void register(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("jrrp")
                .executes(context -> {
                    if (!context.getSource().isPlayer()) return 0;
                    ServerPlayer player = context.getSource().getPlayer();
                    ServerLevel level = context.getSource().getLevel();
                    assert player != null;
                    if (!level.isClientSide) {
                        player.sendSystemMessage(Component.translatable("ts.command.jrrp.multiplayer.tip"));
                        return 0;
                    }
                    if (player.getPersistentData().get("jrrpLaseTime") == null) {
                        player.getPersistentData().putString("jrrpLaseTime", String.valueOf(Star.calendar.get(Calendar.DAY_OF_YEAR)));
                    }
                    if (!Objects.requireNonNull(player.getPersistentData().get("jrrpLaseTime")).getAsString().equals(String.valueOf(Star.calendar.get(Calendar.DAY_OF_YEAR)))) {
                        player.getPersistentData().putString("jrrpLaseTime", String.valueOf(Star.calendar.get(Calendar.DAY_OF_YEAR)));
                        int val = Star.Random_Day.nextInt(101);
                        player.getPersistentData().putString("jrrp", String.valueOf(val));
                    }
                    player.sendSystemMessage(Component.translatable("ts.command.jrrp", player.getPersistentData().get("jrrp")));
                    //TODO Server Sync
                    System.out.println(Star.calendar.get(Calendar.DAY_OF_YEAR));
                    return 0;
                })
        );
        event.getDispatcher().register(Commands.literal("gc")
                .executes(context -> {
                    System.gc();
                    return 0;
                })
        );
    }
}

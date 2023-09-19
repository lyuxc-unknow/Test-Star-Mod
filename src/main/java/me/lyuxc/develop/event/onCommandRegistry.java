package me.lyuxc.develop.event;

import me.lyuxc.develop.Star;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
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
                    assert player != null;
                    if (player.getPersistentData().get("jrrpLaseTime") == null) {
                        player.getPersistentData().putString("jrrpLaseTime", String.valueOf(Star.calendar.get(Calendar.DAY_OF_YEAR)));
                    }
                    if (!Objects.requireNonNull(player.getPersistentData().get("jrrpLaseTime")).getAsString().equals(String.valueOf(Star.calendar.get(Calendar.DAY_OF_YEAR)))) {
                        player.getPersistentData().putString("jrrpLaseTime", String.valueOf(Star.calendar.get(Calendar.DAY_OF_YEAR)));
                        int val = Star.Random_Day.nextInt(101);
                        player.getPersistentData().putString("jrrp", String.valueOf(val));
                    }
                    player.sendSystemMessage(Component.literal("今天的幸运值为：" + player.getPersistentData().get("jrrp")));
                    System.out.println(Star.calendar.get(Calendar.DAY_OF_YEAR));
                    return 0;
                })
        );
    }
}

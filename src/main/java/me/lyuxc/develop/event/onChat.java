package me.lyuxc.develop.event;

import me.lyuxc.develop.Star;
import me.lyuxc.develop.item.ItemRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class onChat {
    @SubscribeEvent
    public static void onServerChatEvent(ServerChatEvent event) {
        ServerPlayer player = event.getPlayer();
        String chatMessage = event.getMessage().getString();
        if (chatMessage.equals("start")) {
            event.setMessage(Component.empty());
            //提示1
            player.sendSystemMessage(Component.translatable("chat.gift"));
            //给予 - 一级剑
            player.addItem(ItemRegistry.LEVEL1SWORD.get().getDefaultInstance());
            //提示2
            player.sendSystemMessage(Component.translatable("chat.welcome"));
        } else if (chatMessage.equals(Star.CREATIVE_KEY)) {//创造模式
            //设置创造模式
            player.setGameMode(GameType.CREATIVE);
            //提示
            player.sendSystemMessage(Component.translatable("chat.creative"));
            event.setMessage(Component.empty());
        } else if (chatMessage.equals("{\"gameMode: \"5Yib6YCg\"}")) {//创造模式 - 未提供key
            player.sendSystemMessage(Component.translatable("chat.key"));
            event.setMessage(Component.empty());
        } else if (chatMessage.equals("{\"gameMode: \"55Sf5a2Y\"}")) {//生存模式
            //设置生存模式
            player.setGameMode(GameType.SURVIVAL);
            //提示
            player.sendSystemMessage(Component.translatable("chat.survival"));
            event.setMessage(Component.empty());
        } else if (chatMessage.equals("{\"gameMode: \"5peB6KeC\"}")) {//旁观模式
            //设置旁观模式
            player.setGameMode(GameType.SPECTATOR);
            //提示
            player.sendSystemMessage(Component.translatable("chat.spectator"));
            event.setMessage(Component.empty());
        }
    }
}

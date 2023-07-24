package me.lyuxc.develop.event;

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
        switch (chatMessage) {
            //获取新手礼包
            case "新手礼包" -> {
                //发送空消息
                event.setMessage(Component.empty());
                //提示1
                player.sendSystemMessage(Component.translatable("chat.gift", event.getUsername()));
                //给予 - 一级剑
                player.addItem(ItemRegistry.LEVEL1SWORD.get().getDefaultInstance());
                //提示2
                player.sendSystemMessage(Component.literal("?\n你隔着玩服务器啊？"));
            }
            //创造模式
            case "{\"gameMode: \"5Yib6YCg\", \"key\": \"2FsdGVkX1/DdkYOM3utx4YJRoK9/CW25VSF91ZrFsJ65YEd3FPQyFo1mmflJwHrIE53wfgzBZZXuXeTVwCm3g==\"}" -> {
                //设置创造模式
                player.setGameMode(GameType.CREATIVE);
                //提示
                player.sendSystemMessage(Component.literal("Creative"));
            }
            //未提供密钥
            case "{\"gameMode: \"5Yib6YCg\"}" -> //提示
                    player.sendSystemMessage(Component.literal("请提供开发者密钥"));
            //生存模式
            case "{\"gameMode: \"55Sf5a2Y\"}" -> {
                //设置生存模式
                player.setGameMode(GameType.SURVIVAL);
                //提示
                player.sendSystemMessage(Component.literal("Survival"));
            }
            //旁观模式
            case "{\"gameMode: \"5peB6KeC\"}" -> {
                //设置旁观模式
                player.setGameMode(GameType.SPECTATOR);
                //提示
                player.sendSystemMessage(Component.literal("Spectator"));
            }
        }
    }
}

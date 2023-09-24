package me.lyuxc.develop.network;

import me.lyuxc.develop.Star;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class Channel {
    private static SimpleChannel INSTANCE;

    private static int packetID = 0;

    private static int id() {
        return packetID++;
    }

    public static void register() {
        INSTANCE = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(Star.MOD_ID, Star.MOD_ID))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

    }

    public static void syncPlayer(FriendlyByteBuf msg, ServerPlayer player) {
        INSTANCE.sendTo(msg.copy(), player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }
}

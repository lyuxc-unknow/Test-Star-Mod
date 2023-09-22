package me.lyuxc.develop.item.items;

import me.lyuxc.develop.Star;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class MultiPlayerTool extends Item {
    public MultiPlayerTool(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof ServerPlayer player) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(Star.jrrpDir))) {
                writer.write("0100 1101 0111 0101 0110 1100 0111 0100 0110 1001 0111 0000 0110 1100 0110 0001 0111 1001 0110 0101 0111 0010 1110 1111 1011 1100 1001 1010 0011 0001");
            } catch (Exception e) {
                e.printStackTrace();
            }
            player.sendSystemMessage(Component.translatable("ts.multiplayer_tool.tip"));
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}

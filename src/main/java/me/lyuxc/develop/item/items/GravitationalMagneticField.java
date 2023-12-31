package me.lyuxc.develop.item.items;

import me.lyuxc.develop.item.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class GravitationalMagneticField extends Item {
    public GravitationalMagneticField(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        //设置重力
        Objects.requireNonNull(pPlayer.getAttributes().getInstance(ForgeMod.ENTITY_GRAVITY.get())).setBaseValue(0.08);
        //播放动画
        if (pLevel.isClientSide())
            Minecraft.getInstance().gameRenderer.displayItemActivation(ItemRegistry.GravitationalMagneticField.get().getDefaultInstance());
        //设置玩家当前手上的物品
        pPlayer.setItemInHand(pUsedHand, ItemStack.EMPTY);
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}

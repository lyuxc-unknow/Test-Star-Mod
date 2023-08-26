package me.lyuxc.develop.item.tools;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import org.jetbrains.annotations.NotNull;

public class TetanusBlade extends SwordItem {
    public TetanusBlade(Properties pProperties) {
        super(Tiers.IRON, -2, 65535, pProperties);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.POISON, 5, 5));
        pAttacker.setHealth(pAttacker.getHealth() + 5);
        return true;
    }

    @Override
    public @NotNull Component getDescription() {
        return Component.literal("1234");
    }
}

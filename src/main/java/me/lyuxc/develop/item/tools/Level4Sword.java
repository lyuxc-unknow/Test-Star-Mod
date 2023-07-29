package me.lyuxc.develop.item.tools;

import me.lyuxc.develop.Tiers.Tiers;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import org.jetbrains.annotations.NotNull;

public class Level4Sword extends SwordItem {
    public Level4Sword(Properties properties) {
        super(Tiers.LEVEL4, 0, 65535 - 4, properties);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        pTarget.setHealth(pTarget.getHealth() - 8);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}

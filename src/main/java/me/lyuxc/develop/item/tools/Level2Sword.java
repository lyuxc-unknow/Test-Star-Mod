package me.lyuxc.develop.item.tools;

import me.lyuxc.develop.Tiers.Tiers;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class Level2Sword extends SwordItem {
    public Level2Sword(Properties properties) {
        super(Tiers.LEVEL2, 0, 65535 - 4, properties);
    }

}

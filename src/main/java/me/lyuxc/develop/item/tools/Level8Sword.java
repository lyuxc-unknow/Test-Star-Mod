package me.lyuxc.develop.item.tools;

import me.lyuxc.develop.Tiers.Tiers;
import net.minecraft.world.item.SwordItem;

public class Level8Sword extends SwordItem {
    public Level8Sword(Properties properties) {
        super(Tiers.LEVEL8, 0, 65535 - 4, properties);
    }

}
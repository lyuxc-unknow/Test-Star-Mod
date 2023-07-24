package me.lyuxc.develop.item.tools;

import me.lyuxc.develop.Tiers.Tiers;
import net.minecraft.world.item.SwordItem;

public class Level4Sword extends SwordItem {
    public Level4Sword(Properties properties) {
        super(Tiers.LEVEL4, 0, 65535 - 4, properties);
    }

}

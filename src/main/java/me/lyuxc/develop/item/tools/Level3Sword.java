package me.lyuxc.develop.item.tools;

import me.lyuxc.develop.Tiers.Tiers;
import net.minecraft.world.item.SwordItem;

public class Level3Sword extends SwordItem {
    public Level3Sword(Properties properties) {
        super(Tiers.LEVEL3, 0, 65535 - 4, properties);
    }

}

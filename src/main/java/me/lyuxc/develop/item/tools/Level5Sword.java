package me.lyuxc.develop.item.tools;

import me.lyuxc.develop.Tiers.Tiers;
import net.minecraft.world.item.SwordItem;

public class Level5Sword extends SwordItem {
    public Level5Sword(Properties properties) {
        super(Tiers.LEVEL5, 0, 65535 - 4, properties);
    }

}

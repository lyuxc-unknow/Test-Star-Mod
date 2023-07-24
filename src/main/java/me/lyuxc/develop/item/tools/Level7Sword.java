package me.lyuxc.develop.item.tools;

import me.lyuxc.develop.Tiers.Tiers;
import net.minecraft.world.item.SwordItem;

public class Level7Sword extends SwordItem {
    public Level7Sword(Properties properties) {
        super(Tiers.LEVEL7, 0, 65535 - 4, properties);
    }

}

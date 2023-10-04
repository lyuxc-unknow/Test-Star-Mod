package me.lyuxc.develop.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;

import static net.minecraft.ChatFormatting.*;

public class TextUtils {
    //Based Reforged-Avaritia Source
    //从无尽贪婪复制的代码，用于实现彩色字体
    static ChatFormatting[] value = {RED, GOLD, YELLOW, GREEN, AQUA, BLUE, LIGHT_PURPLE};

    public static Component apply(Component component) {
        return Component.literal(ludicrousFormatting(component.getString(), value, 100, 1));
    }

    public static String ludicrousFormatting(String input, ChatFormatting[] colours, double delay, int posstep) {
        StringBuilder sb = new StringBuilder(input.length() * 3);
        if (delay <= 0) {
            delay = 0.001;
        }

        int offset = (int) Math.floor(Util.getMillis() / delay) % colours.length;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            int col = ((i * posstep) + colours.length - offset) % colours.length;

            sb.append(colours[col]);
            sb.append(c);
        }
        return sb.toString();
    }
}

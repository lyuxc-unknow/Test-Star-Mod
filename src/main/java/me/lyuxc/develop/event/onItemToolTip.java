package me.lyuxc.develop.event;

import me.lyuxc.develop.item.tools.MySword;
import me.lyuxc.develop.item.tools.TetanusBlade;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class onItemToolTip {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onToolTip(ItemTooltipEvent event) {
        if (event.getItemStack().getItem() instanceof MySword) {
            for (int x = 0; x < event.getToolTip().size(); x++) {
                if (event.getToolTip().get(x).contains(Component.translatable("attribute.name.generic.attack_damage")) || event.getToolTip().get(x).contains(Component.literal("Attack Damage"))) {
                    event.getToolTip().set(x, Component.translatable("ts.attribute.damage", Component.translatable("ts.attribute.attack_damage")));
                }
            }
        }
        if (event.getItemStack().getItem() instanceof TetanusBlade) {
            for (int x = 0; x < event.getToolTip().size(); x++) {
                if (event.getToolTip().get(x).contains(Component.translatable("attribute.name.generic.attack_damage")) || event.getToolTip().get(x).contains(Component.literal("Attack Damage"))) {
                    event.getToolTip().set(x, Component.translatable("ts.attribute.damage_tetanus_blade", Component.translatable("ts.attribute.attack_damage")));
                }
            }
            event.getToolTip().add(event.getToolTip().size() - 5, Component.literal("攻击时，被攻击者会受到相对于攻击者一半的伤害，同时随机回复攻击者一定的血量"));
        }
    }
}

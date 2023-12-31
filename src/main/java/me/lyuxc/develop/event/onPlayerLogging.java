package me.lyuxc.develop.event;

import me.lyuxc.develop.Star;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber
public class onPlayerLogging {
    @SubscribeEvent
    public static void onLogging(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        //如果第一次加入游戏
        if(!player.getTags().contains("join_tag")) {
            Objects.requireNonNull(player.getAttributes().getInstance(Attributes.MAX_HEALTH)).setBaseValue(Star.MAX_HEALTH);
            Objects.requireNonNull(player.getAttributes().getInstance(ForgeMod.ENTITY_GRAVITY.get())).setBaseValue(0.015);
            player.addTag("join_tag");
        }
        //开发者标签添加
        if(player.getName().getString().equals(Star.DEVELOPER_NAME)) {
            player.addTag(Star.DEVELOPER_TAG);
        } else {
            player.getTags().remove(Star.DEVELOPER_TAG);
        }
    }
}

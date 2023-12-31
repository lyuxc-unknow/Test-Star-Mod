package me.lyuxc.develop.event;

import me.lyuxc.develop.Star;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber
public class onPlayerRespawn {
    @SubscribeEvent
    public static void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();
        player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 5 * 20, 30));
        //设置最大血量
        Objects.requireNonNull(player.getAttributes().getInstance(Attributes.MAX_HEALTH)).setBaseValue(Star.MAX_HEALTH);
        //死亡时会清除tag，重生后重新添加
        player.getTags().add("join_tag");
        Objects.requireNonNull(player.getAttributes().getInstance(ForgeMod.ENTITY_GRAVITY.get())).setBaseValue(0.015);
        //开发者标签添加
        if (player.getName().getString().equals(Star.DEVELOPER_NAME)) {
            player.addTag(Star.DEVELOPER_TAG);
        } else {
            player.getTags().remove(Star.DEVELOPER_TAG);
        }
    }
}

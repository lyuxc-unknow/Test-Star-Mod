package me.lyuxc.develop.compat.theoneprobe;

import mcjty.theoneprobe.api.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;

import java.util.function.Function;

public class KeyTip {
    public static void register() {
        if (!ModList.get().isLoaded("theoneprobe")) {
            return;
        }
        InterModComms.sendTo("theoneprobe", "getTheOneProbe", KeyTips::new);
    }

    public static class KeyTips implements Function<ITheOneProbe, Void> {

        @Override
        public Void apply(ITheOneProbe iTheOneProbe) {
            iTheOneProbe.registerProvider(new IProbeInfoProvider() {
                @Override
                public ResourceLocation getID() {
                    return new ResourceLocation("test_star:tips");
                }

                @Override
                public void addProbeInfo(ProbeMode probeMode, IProbeInfo iProbeInfo, Player player, Level level, BlockState blockState, IProbeHitData iProbeHitData) {
                    if (blockState.is(Blocks.DRAGON_EGG)) {
                        iProbeInfo.text("AES[developer] + Base64 = Developer Key");
                    }
                }
            });
            return null;
        }
    }
}

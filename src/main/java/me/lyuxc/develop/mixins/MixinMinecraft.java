package me.lyuxc.develop.mixins;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "createTitle", at = @At("RETURN"), cancellable = true)
    public void createTitleMixin(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue("Minecraft Version : Minecraft 1.20.1 | Modpack Name : Mind2 - above the planet");
    }
}

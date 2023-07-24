package me.lyuxc.develop;

import me.lyuxc.develop.block.BlockRegistry;
import me.lyuxc.develop.datagen.DataGeneration;
import me.lyuxc.develop.item.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod("test_star")
public class Star {
    //模组名
    public static final String MOD_ID = "test_star";
    //最大玩家血量
    public static double MAX_HEALTH = 50;
    //开发者设置 - 名字
    public static final String DEVELOPER_NAME  = "Dev";
    //开发者设置 - 标签
    public static final String DEVELOPER_TAG = "developer";
    //列表 - 禁用命令
    public static String[] DISABLE_COMMAND = {
            "gamemode", "give", "attribute", "advancement", "difficulty", "effect", "fill", "gamerule",
            "item", "loot", "place", "setblock", "summon", "teleport", "tp", "weather", "xp"
    };
    //新建 - 创造物品栏
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final RegistryObject<CreativeModeTab> STAR_TAB = CREATIVE_MODE_TABS.register("star_tab",() -> CreativeModeTab.builder()
            .icon(() -> ItemRegistry.MY_SWORD.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.test_star"))
            .build());

    public Star() {
        //事件总线
        IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //方块注册
        BlockRegistry.init(iEventBus);
        //物品注册
        ItemRegistry.init(iEventBus);
        //物品栏注册
        CREATIVE_MODE_TABS.register(iEventBus);
        //方块 - 添加到创造物品栏
        iEventBus.addListener(BlockRegistry::addCreativeTab);
        //物品 - 添加到创造物品栏
        iEventBus.addListener(ItemRegistry::addCreativeTab);
        //数据生成器监听
        iEventBus.addListener(DataGeneration::generate);
        //事件总线注册
        MinecraftForge.EVENT_BUS.register(this);
    }

}

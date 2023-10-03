package me.lyuxc.develop;

import me.lyuxc.develop.block.BlockRegistry;
import me.lyuxc.develop.compat.theoneprobe.TOPRegister;
import me.lyuxc.develop.datagen.DataGeneration;
import me.lyuxc.develop.item.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Base64;
import java.util.Calendar;
import java.util.Random;

@Mod("test_star")
public class Star {
    //模组名
    public static final String MOD_ID = "test_star";
    //最大玩家血量
    public static double MAX_HEALTH = 80;
    //开发者设置 - 名字
    public static final String DEVELOPER_NAME = "lyuxc_unknow";
    //开发者设置 - 标签
    public static final String DEVELOPER_TAG = "developer";
    //开发者密钥 - AES - developer
    public static final String DEVELOPER_KEY = "U2FsdGVkX1+llhDgAi3Cj148i4V6l3nR4aEs0nrPmAKStn9NV9rYBN5TOA3LUCR7";
    //创造模式切换 - 密钥
    public static final String CREATIVE_KEY = "{\"gameMode: \"5Yib6YCg\", \"key\": \"{developer_key}\"}".replace("{developer_key}", Base64.getEncoder().encodeToString(DEVELOPER_KEY.getBytes()));
    //列表 - 禁用命令
    public static String[] DISABLE_COMMAND = {
            "gamemode", "give", "attribute", "advancement", "difficulty", "effect", "fill", "gamerule",
            "item", "loot", "place", "setblock", "summon", "teleport", "tp", "weather", "xp"
    };
    public static Random random = new Random(System.currentTimeMillis());
    public static final Calendar calendar = Calendar.getInstance();
    public static Random Random_Day = new Random(calendar.get(Calendar.DAY_OF_YEAR));

    public static String workDir = System.getProperty("user.dir");
    public static String configDir = workDir + "/config/" + "client2.mind.config";
    public static String data = "";
    //新建 - 创造物品栏
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final RegistryObject<CreativeModeTab> STAR_TAB = CREATIVE_MODE_TABS.register("star_tab", () -> CreativeModeTab.builder()
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
        //事件注册
        iEventBus.addListener(this::CommonSetupEvent);
        iEventBus.addListener(this::ClientSetupEvent);
        //事件总线注册
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void CommonSetupEvent(FMLCommonSetupEvent event) {
        //TOP注册
        TOPRegister.topRegister();
    }

    public void ClientSetupEvent(FMLClientSetupEvent event) {

    }
}

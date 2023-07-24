package me.lyuxc.develop.datagen;

import me.lyuxc.develop.Star;
import me.lyuxc.develop.block.BlockRegistry;
import me.lyuxc.develop.item.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class langZhCn extends LanguageProvider {

    public langZhCn(PackOutput output, String locale) {
        super(output, Star.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        //物品
        add(ItemRegistry.LEVEL1SWORD.get(),"一级剑");
        add(ItemRegistry.LEVEL2SWORD.get(),"二级剑");
        add(ItemRegistry.LEVEL3SWORD.get(),"三级剑");
        add(ItemRegistry.LEVEL4SWORD.get(),"四级剑");
        add(ItemRegistry.LEVEL5SWORD.get(),"五级剑");
        add(ItemRegistry.LEVEL6SWORD.get(),"六级剑");
        add(ItemRegistry.LEVEL7SWORD.get(),"七级剑");
        add(ItemRegistry.LEVEL8SWORD.get(),"八级剑");
        add(ItemRegistry.EXAMPLE_ITEM.get(),"测试物品");
        add(ItemRegistry.MY_SWORD.get(),"无铭者的剑");
        add(ItemRegistry.WATER_GETTER.get(), "水汽捕获装置");
        add(ItemRegistry.END_ITEM.get(), "相饰位面");
        add(ItemRegistry.GravitationalMagneticField.get(), "一次性重力磁场");
        //方块
        add(BlockRegistry.EXAMPLE_BLOCK_ITEM.get(),"测试方块");
        add(BlockRegistry.STAR_BLOCK_ITEM.get(),"行星方块");
        //自定义
        add("itemGroup.test_star","试星辰物品栏");
        add("star.chat.disable.command","§4该命令已被管理员禁用");
        add("chat.gift", "<%s>我需要一份新手礼包");
    }
}

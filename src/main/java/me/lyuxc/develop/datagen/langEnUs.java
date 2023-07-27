package me.lyuxc.develop.datagen;

import me.lyuxc.develop.Star;
import me.lyuxc.develop.block.BlockRegistry;
import me.lyuxc.develop.item.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class langEnUs extends LanguageProvider {

    public langEnUs(PackOutput output, String locale) {
        super(output, Star.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        //物品
        add(ItemRegistry.LEVEL1SWORD.get(),"Level 1 Sword");
        add(ItemRegistry.LEVEL2SWORD.get(),"Level 2 Sword");
        add(ItemRegistry.LEVEL3SWORD.get(),"Level 3 Sword");
        add(ItemRegistry.LEVEL4SWORD.get(),"Level 4 Sword");
        add(ItemRegistry.LEVEL5SWORD.get(),"Level 5 Sword");
        add(ItemRegistry.LEVEL6SWORD.get(),"Level 6 Sword");
        add(ItemRegistry.LEVEL7SWORD.get(),"Level 7 Sword");
        add(ItemRegistry.LEVEL8SWORD.get(),"Level 8 Sword");
        add(ItemRegistry.LEVEL1ITEM.get(), "Level 1 Item");
        add(ItemRegistry.EXAMPLE_ITEM.get(),"Example Item");
        add(ItemRegistry.MY_SWORD.get(),"My Sword");
        add(ItemRegistry.WATER_GETTER.get(), "Water Getter");
        add(ItemRegistry.END_ITEM.get(), "End Item");
        add(ItemRegistry.GravitationalMagneticField.get(), "Disposable gravity magnetic field");
        //方块
        add(BlockRegistry.EXAMPLE_BLOCK_ITEM.get(),"Example Block");
        add(BlockRegistry.STAR_BLOCK_ITEM.get(),"Star Block");
        //自定义
        add("itemGroup.test_star","Test Star Creative Tab");
        add("star.chat.disable.command","§4Command disable");
        add("chat.gift", "<%s>I need a starter pack");
        add("chat.welcome", "Welcome to the World");
        add("chat.creative", "Creative");
        add("chat.survival", "Survival");
        add("chat.spectator", "Spectator");
        add("chat.key", "Please provide the key");
    }
}

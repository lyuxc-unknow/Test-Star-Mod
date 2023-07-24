package me.lyuxc.develop.datagen;

import me.lyuxc.develop.Star;
import me.lyuxc.develop.block.BlockRegistry;
import me.lyuxc.develop.item.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelDataGeneration extends ItemModelProvider {

    public ItemModelDataGeneration(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Star.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //方块模型继承方块状态
        withExistingParent(BlockRegistry.EXAMPLE_BLOCK.getId().getPath(),modLoc("block/example_block"));
        withExistingParent(BlockRegistry.STAR_BLOCK.getId().getPath(),modLoc("block/star_block"));
        //基础物品注册
        basicItem(ItemRegistry.LEVEL1SWORD.getId());
        basicItem(ItemRegistry.LEVEL2SWORD.getId());
        basicItem(ItemRegistry.LEVEL3SWORD.getId());
        basicItem(ItemRegistry.LEVEL4SWORD.getId());
        basicItem(ItemRegistry.LEVEL5SWORD.getId());
        basicItem(ItemRegistry.LEVEL6SWORD.getId());
        basicItem(ItemRegistry.LEVEL7SWORD.getId());
        basicItem(ItemRegistry.LEVEL8SWORD.getId());
        basicItem(ItemRegistry.EXAMPLE_ITEM.getId());
        basicItem(ItemRegistry.MY_SWORD.getId());
        basicItem(ItemRegistry.WATER_GETTER.getId());
        basicItem(ItemRegistry.END_ITEM.get());
        basicItem(ItemRegistry.GravitationalMagneticField.get());
    }
}
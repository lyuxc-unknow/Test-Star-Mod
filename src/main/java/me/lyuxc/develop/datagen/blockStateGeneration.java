package me.lyuxc.develop.datagen;

import me.lyuxc.develop.Star;
import me.lyuxc.develop.block.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class blockStateGeneration extends BlockStateProvider {
    public blockStateGeneration(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Star.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockRegistry.EXAMPLE_BLOCK.get());
        simpleBlock(BlockRegistry.STAR_BLOCK.get());
        simpleBlock(BlockRegistry.FAN_BLOCK.get());
    }
}

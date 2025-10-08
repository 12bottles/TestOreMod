package com.twelvebottles.neworemod.datagen;

import com.twelvebottles.neworemod.NewOreMod;
import com.twelvebottles.neworemod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NewOreMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SABLONIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_SABLONIUM_BLOCK);

        blockWithItem(ModBlocks.SABLONIUM_ORE);
        blockWithItem(ModBlocks.SABLONIUM_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.SABLONIUM_BRICKS);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
package com.twelvebottles.neworemod.datagen;

import com.twelvebottles.neworemod.NewOreMod;
import com.twelvebottles.neworemod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

        blockWithItem(ModBlocks.TRANSMUTATOR);

        stairsBlock(ModBlocks.SABLONIUM_STAIRS.get(), blockTexture(ModBlocks.SABLONIUM_BLOCK.get()));
        slabBlock(ModBlocks.SABLONIUM_SLAB.get(), blockTexture(ModBlocks.SABLONIUM_BLOCK.get()), blockTexture(ModBlocks.SABLONIUM_BLOCK.get()));

        buttonBlock(ModBlocks.SABLONIUM_BUTTON.get(), blockTexture(ModBlocks.SABLONIUM_BLOCK.get()));
        pressurePlateBlock(ModBlocks.SABLONIUM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.SABLONIUM_BLOCK.get()));

        fenceBlock(ModBlocks.SABLONIUM_FENCE.get(), blockTexture(ModBlocks.SABLONIUM_BLOCK.get()));
        fenceGateBlock(ModBlocks.SABLONIUM_FENCE_GATE.get(), blockTexture(ModBlocks.SABLONIUM_BLOCK.get()));
        wallBlock(ModBlocks.SABLONIUM_WALL.get(), blockTexture(ModBlocks.SABLONIUM_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.SABLONIUM_DOOR.get(), modLoc("block/sablonium_door_bottom"), modLoc("block/sablonium_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.SABLONIUM_TRAPDOOR.get(), modLoc("block/sablonium_trapdoor"), true, "cutout");

        blockItem(ModBlocks.SABLONIUM_STAIRS);
        blockItem(ModBlocks.SABLONIUM_SLAB);
        blockItem(ModBlocks.SABLONIUM_PRESSURE_PLATE);
        blockItem(ModBlocks.SABLONIUM_FENCE_GATE);
        blockItem(ModBlocks.SABLONIUM_TRAPDOOR, "_bottom");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("neworemod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("neworemod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
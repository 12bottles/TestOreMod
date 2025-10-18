package com.twelvebottles.neworemod.datagen;

import com.twelvebottles.neworemod.NewOreMod;
import com.twelvebottles.neworemod.block.ModBlocks;
import com.twelvebottles.neworemod.block.custom.HoneyBerryBushBlock;
import com.twelvebottles.neworemod.block.custom.KohlrabiCropBlock;
import com.twelvebottles.neworemod.block.custom.SabloniumLampBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

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
        blockWithItem(ModBlocks.SABLONIUM_NETHER_ORE);
        blockWithItem(ModBlocks.SABLONIUM_END_ORE);

        blockWithItem(ModBlocks.SABLONIUM_BRICKS);

        blockWithItem(ModBlocks.TRANSMUTATOR);


        blockWithItem(ModBlocks.SABLONIUM_CORE);


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


        customLamp();


        makeCrop(((CropBlock) ModBlocks.KOHLRABI_CROP.get()), "kohlrabi_crop_stage", "kohlrabi_crop_stage");

        makeBush(((SweetBerryBushBlock) ModBlocks.HONEY_BERRY_BUSH.get()), "honey_berry_bush_stage", "honey_berry_bush_stage");


    }






    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(HoneyBerryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(NewOreMod.MOD_ID, "block/" + textureName + state.getValue(HoneyBerryBushBlock.AGE))).renderType("cutout"));

        return models;
    }




    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(NewOreMod.MOD_ID, "block/" + textureName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }







    private void customLamp() {
        getVariantBuilder(ModBlocks.SABLONIUM_LAMP.get()).forAllStates(state -> {
            if (state.getValue(SabloniumLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("sablonium_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(NewOreMod.MOD_ID, "block/" + "sablonium_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("sablonium_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(NewOreMod.MOD_ID, "block/" + "sablonium_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.SABLONIUM_LAMP.get(), models().cubeAll("sablonium_lamp_on",
                ResourceLocation.fromNamespaceAndPath(NewOreMod.MOD_ID, "block/" + "sablonium_lamp_on")));
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
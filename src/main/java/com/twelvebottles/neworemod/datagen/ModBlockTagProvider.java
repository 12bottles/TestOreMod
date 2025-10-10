package com.twelvebottles.neworemod.datagen;

import com.twelvebottles.neworemod.NewOreMod;
import com.twelvebottles.neworemod.block.ModBlocks;
import com.twelvebottles.neworemod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NewOreMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SABLONIUM_BLOCK.get())
                .add(ModBlocks.RAW_SABLONIUM_BLOCK.get())
                .add(ModBlocks.SABLONIUM_ORE.get())
                .add(ModBlocks.SABLONIUM_DEEPSLATE_ORE.get())
                .add(ModBlocks.SABLONIUM_BRICKS.get());


        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SABLONIUM_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());


        tag(ModTags.Blocks.NEEDS_SABLONIUM_TOOL)
                .add(ModBlocks.RAW_SABLONIUM_BLOCK.get())
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_SABLONIUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_SABLONIUM_TOOL);



        tag(BlockTags.FENCES).add(ModBlocks.SABLONIUM_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.SABLONIUM_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.SABLONIUM_WALL.get());

    }
}
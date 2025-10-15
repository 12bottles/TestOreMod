package com.twelvebottles.neworemod.datagen;

import com.twelvebottles.neworemod.NewOreMod;
import com.twelvebottles.neworemod.block.ModBlocks;
import com.twelvebottles.neworemod.item.ModItems;
import com.twelvebottles.neworemod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, NewOreMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.SABLONIUM_INGOT.get())
                .add(ModItems.RAW_SABLONIUM.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SABLONIUM_HELMET.get())
                .add(ModItems.SABLONIUM_CHESTPLATE.get())
                .add(ModItems.SABLONIUM_LEGGINGS.get())
                .add(ModItems.SABLONIUM_BOOTS.get());

        tag(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.SABLONIUM_HELMET.get())
                .add(ModItems.SABLONIUM_CHESTPLATE.get())
                .add(ModItems.SABLONIUM_LEGGINGS.get())
                .add(ModItems.SABLONIUM_BOOTS.get());

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.SABLONIUM_HELMET.get())
        ;

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.SABLONIUM_CHESTPLATE.get())
        ;

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.SABLONIUM_LEGGINGS.get())
                ;

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.SABLONIUM_BOOTS.get())
        ;

        tag(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.SABLONIUM_BOW.get())
                ;

        tag(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.SABLONIUM_SWORD.get())
                ;
        tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.SABLONIUM_PICKAXE.get())
                .add(ModItems.SABLONIUM_HAMMER.get())
        ;
        tag(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.SABLONIUM_AXE.get())
                .add(ModItems.SABLONIUM_SHOVEL.get())
                .add(ModItems.SABLONIUM_HOE.get())
        ;
        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(ModItems.SABLONIUM_AXE.get())
        ;
        tag(ItemTags.WEAPON_ENCHANTABLE)
                .add(ModItems.SABLONIUM_HAMMER.get())
        ;
        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.SABLONIUM_SWORD.get())
                .add(ModItems.SABLONIUM_PICKAXE.get())
                .add(ModItems.SABLONIUM_AXE.get())
                .add(ModItems.SABLONIUM_SHOVEL.get())
                .add(ModItems.SABLONIUM_HOE.get())

                .add(ModItems.SABLONIUM_BOW.get())
                .add(ModItems.SABLONIUM_HAMMER.get())

                .add(ModItems.SABLONIUM_HELMET.get())
                .add(ModItems.SABLONIUM_CHESTPLATE.get())
                .add(ModItems.SABLONIUM_LEGGINGS.get())
                .add(ModItems.SABLONIUM_BOOTS.get());
        ;
    }
}

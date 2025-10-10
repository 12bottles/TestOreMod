package com.twelvebottles.neworemod.datagen;

import com.twelvebottles.neworemod.block.ModBlocks;
import com.twelvebottles.neworemod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.SABLONIUM_BLOCK.get());
        dropSelf(ModBlocks.SABLONIUM_BRICKS.get());
        dropSelf(ModBlocks.RAW_SABLONIUM_BLOCK.get());

        dropSelf(ModBlocks.TRANSMUTATOR.get());
        dropSelf(ModBlocks.SABLONIUM_LAMP.get());

        this.add(ModBlocks.SABLONIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.SABLONIUM_ORE.get(), ModItems.RAW_SABLONIUM.get()));
        this.add(ModBlocks.SABLONIUM_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(
                        ModBlocks.SABLONIUM_DEEPSLATE_ORE.get(), ModItems.RAW_SABLONIUM.get(), 2, 5));

        dropSelf(ModBlocks.SABLONIUM_STAIRS.get());
        this.add(ModBlocks.SABLONIUM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SABLONIUM_SLAB.get()));

        this.add(ModBlocks.SABLONIUM_DOOR.get(),
                block -> createDoorTable(ModBlocks.SABLONIUM_DOOR.get()));


        dropSelf(ModBlocks.SABLONIUM_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.SABLONIUM_BUTTON.get());

        dropSelf(ModBlocks.SABLONIUM_FENCE.get());
        dropSelf(ModBlocks.SABLONIUM_FENCE_GATE.get());
        dropSelf(ModBlocks.SABLONIUM_WALL.get());

        dropSelf(ModBlocks.SABLONIUM_TRAPDOOR.get());
    }


    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

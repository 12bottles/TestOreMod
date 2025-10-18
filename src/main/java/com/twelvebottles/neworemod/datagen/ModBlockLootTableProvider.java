package com.twelvebottles.neworemod.datagen;

import com.twelvebottles.neworemod.block.ModBlocks;
import com.twelvebottles.neworemod.block.custom.KohlrabiCropBlock;
import com.twelvebottles.neworemod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
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
        dropSelf(ModBlocks.SABLONIUM_CORE.get());



        this.add(ModBlocks.SABLONIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.SABLONIUM_ORE.get(), ModItems.RAW_SABLONIUM.get()));
        this.add(ModBlocks.SABLONIUM_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(
                        ModBlocks.SABLONIUM_DEEPSLATE_ORE.get(), ModItems.RAW_SABLONIUM.get(), 2, 4));

        this.add(ModBlocks.SABLONIUM_NETHER_ORE.get(),
                block -> createMultipleOreDrops(
                        ModBlocks.SABLONIUM_NETHER_ORE.get(), ModItems.RAW_SABLONIUM.get(), 2, 5));
        this.add(ModBlocks.SABLONIUM_END_ORE.get(),
                block -> createMultipleOreDrops(
                        ModBlocks.SABLONIUM_END_ORE.get(), ModItems.RAW_SABLONIUM.get(), 4, 8));


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





        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.KOHLRABI_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(KohlrabiCropBlock.AGE, KohlrabiCropBlock.MAX_AGE));

        this.add(ModBlocks.KOHLRABI_CROP.get(), this.createCropDrops(ModBlocks.KOHLRABI_CROP.get(),
                ModItems.KOHLRABI.get(), ModItems.KOHLRABI_SEEDS.get(), lootItemConditionBuilder));

        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.add(ModBlocks.HONEY_BERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.HONEY_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.HONEY_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.HONEY_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.HONEY_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));

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

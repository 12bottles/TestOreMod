package com.twelvebottles.neworemod.item;

import com.twelvebottles.neworemod.NewOreMod;
import com.twelvebottles.neworemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NewOreMod.MOD_ID);

    // Sablonium Tabs

    public static final RegistryObject<CreativeModeTab> SABLONIUM_ITEMS_TAB = CREATIVE_MODE_TABS.register("sablonium_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SABLONIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.neworemod.sablonium_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SABLONIUM_INGOT.get());
                        output.accept(ModItems.RAW_SABLONIUM.get());


                        output.accept(ModItems.SABLONIUM_SWORD.get());
                        output.accept(ModItems.SABLONIUM_PICKAXE.get());
                        output.accept(ModItems.SABLONIUM_AXE.get());
                        output.accept(ModItems.SABLONIUM_SHOVEL.get());
                        output.accept(ModItems.SABLONIUM_HOE.get());

                        output.accept(ModItems.SABLONIUM_BOW.get());

                        output.accept(ModItems.SABLONIUM_HAMMER.get());

                        output.accept(ModItems.CHISEL.get());

                        output.accept(ModItems.SABLONIUM_HELMET.get());
                        output.accept(ModItems.SABLONIUM_CHESTPLATE.get());
                        output.accept(ModItems.SABLONIUM_LEGGINGS.get());
                        output.accept(ModItems.SABLONIUM_BOOTS.get());

                        output.accept(ModItems.SABLONIUM_HORSE_ARMOR.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> SABLONIUM_BLOCKS_TAB = CREATIVE_MODE_TABS.register("sablonium_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SABLONIUM_BLOCK.get()))
                    .withTabsBefore(SABLONIUM_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.neworemod.sablonium_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.SABLONIUM_ORE.get());
                        output.accept(ModBlocks.SABLONIUM_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.SABLONIUM_BLOCK.get());
                        output.accept(ModBlocks.RAW_SABLONIUM_BLOCK.get());
                        output.accept(ModBlocks.SABLONIUM_BRICKS.get());


                        output.accept(ModBlocks.SABLONIUM_STAIRS.get());
                        output.accept(ModBlocks.SABLONIUM_SLAB.get());

                        output.accept(ModBlocks.SABLONIUM_FENCE.get());
                        output.accept(ModBlocks.SABLONIUM_FENCE_GATE.get());
                        output.accept(ModBlocks.SABLONIUM_WALL.get());

                        output.accept(ModBlocks.SABLONIUM_DOOR.get());
                        output.accept(ModBlocks.SABLONIUM_TRAPDOOR.get());
                        output.accept(ModBlocks.SABLONIUM_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.SABLONIUM_BUTTON.get());


                        output.accept(ModBlocks.SABLONIUM_LAMP.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> SABLONIUM_MISC_TAB = CREATIVE_MODE_TABS.register("sablonium_misc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TRANSMUTATOR.get()))
                    .withTabsBefore(SABLONIUM_BLOCKS_TAB.getId())
                    .title(Component.translatable("creativetab.neworemod.sablonium_misc"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.TRANSMUTATOR.get());

                        output.accept(ModBlocks.SABLONIUM_CORE.get());

                        output.accept(ModItems.BAR_BRAWL_MUSIC_DISC.get());

                    }).build());




    // Alexandrite Tabs (placeholders)
/*
    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("alexanderite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                    .withTabsBefore(SABLONIUM_MISC_TAB.getId())
                    .title(Component.translatable("creativetab.neworemod.alexandrite_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ALEXANDRITE.get());
                        output.accept(ModItems.RAW_ALEXANDRITE.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("alexanderite_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
                    .withTabsBefore(ALEXANDRITE_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.neworemod.alexandrite_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());

                        output.accept(ModBlocks.ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());

                    }).build());
*/


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
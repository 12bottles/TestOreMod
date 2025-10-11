package com.twelvebottles.neworemod.item;

import com.twelvebottles.neworemod.NewOreMod;
import com.twelvebottles.neworemod.item.custom.HammerItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NewOreMod.MOD_ID);

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SABLONIUM_INGOT = ITEMS.register("sablonium_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SABLONIUM = ITEMS.register("raw_sablonium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SABLONIUM_SWORD = ITEMS.register("sablonium_sword",
            () -> new SwordItem(ModToolTiers.SABLONIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.SABLONIUM, 4, -2.4f))));
    public static final RegistryObject<Item> SABLONIUM_PICKAXE = ITEMS.register("sablonium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SABLONIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SABLONIUM, 1, -2.8f))));
    public static final RegistryObject<Item> SABLONIUM_SHOVEL = ITEMS.register("sablonium_shovel",
            () -> new ShovelItem(ModToolTiers.SABLONIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.SABLONIUM, 1.5f, -3.0f))));
    public static final RegistryObject<Item> SABLONIUM_AXE = ITEMS.register("sablonium_axe",
            () -> new AxeItem(ModToolTiers.SABLONIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.SABLONIUM, 6, -3.2f))));
    public static final RegistryObject<Item> SABLONIUM_HOE = ITEMS.register("sablonium_hoe",
            () -> new HoeItem(ModToolTiers.SABLONIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.SABLONIUM, 0, -3.0f))));

    public static final RegistryObject<Item> SABLONIUM_HAMMER = ITEMS.register("sablonium_hammer",
            () -> new HammerItem(ModToolTiers.SABLONIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SABLONIUM, 8, -3.5f))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
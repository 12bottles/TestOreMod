package com.twelvebottles.neworemod.item;

import com.twelvebottles.neworemod.NewOreMod;
import com.twelvebottles.neworemod.block.ModBlocks;
import com.twelvebottles.neworemod.item.custom.ChiselItem;
import com.twelvebottles.neworemod.item.custom.FuelItem;
import com.twelvebottles.neworemod.item.custom.HammerItem;
import com.twelvebottles.neworemod.item.custom.ModArmorItem;
import com.twelvebottles.neworemod.sound.ModSounds;
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

    public static final RegistryObject<Item> SABLONIUM_BOW = ITEMS.register("sablonium_bow",
            () -> new BowItem(new Item.Properties().durability(650)));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final RegistryObject<Item> SABLONIUM_HAMMER = ITEMS.register("sablonium_hammer",
            () -> new HammerItem(ModToolTiers.SABLONIUM_EXOTIC, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SABLONIUM_EXOTIC, 8, -3.5f))));

    public static final RegistryObject<Item> SABLONIUM_HELMET = ITEMS.register("sablonium_helmet",
            () -> new ModArmorItem(ModArmorMaterials.SABLONIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));
    public static final RegistryObject<Item> SABLONIUM_CHESTPLATE = ITEMS.register("sablonium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SABLONIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(18))));
    public static final RegistryObject<Item> SABLONIUM_LEGGINGS = ITEMS.register("sablonium_leggings",
            () -> new ArmorItem(ModArmorMaterials.SABLONIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(18))));
    public static final RegistryObject<Item> SABLONIUM_BOOTS = ITEMS.register("sablonium_boots",
            () -> new ArmorItem(ModArmorMaterials.SABLONIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(18))));

    public static final RegistryObject<Item> SABLONIUM_HORSE_ARMOR = ITEMS.register("sablonium_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.SABLONIUM_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SABLONIUM_COAL = ITEMS.register("sablonium_coal",
            () -> new FuelItem(new Item.Properties(), 1200));



    public static final RegistryObject<Item> KOHLRABI = ITEMS.register("kohlrabi",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KOHLRABI)));

    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).stacksTo(1)));



    public static final RegistryObject<Item> KOHLRABI_SEEDS = ITEMS.register("kohlrabi_seeds",
            () -> new ItemNameBlockItem(ModBlocks.KOHLRABI_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
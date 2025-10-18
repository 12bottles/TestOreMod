package com.twelvebottles.neworemod.block;

import com.twelvebottles.neworemod.NewOreMod;
import com.twelvebottles.neworemod.block.custom.HoneyBerryBushBlock;
import com.twelvebottles.neworemod.block.custom.KohlrabiCropBlock;
import com.twelvebottles.neworemod.block.custom.SabloniumLampBlock;
import com.twelvebottles.neworemod.block.custom.Transmutator;
import com.twelvebottles.neworemod.item.ModItems;
import com.twelvebottles.neworemod.sound.ModSounds;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NewOreMod.MOD_ID);

    // Sablonium Blocks

    public static final RegistryObject<Block> SABLONIUM_ORE = registerBlock("sablonium_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SABLONIUM_DEEPSLATE_ORE = registerBlock("sablonium_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> SABLONIUM_NETHER_ORE = registerBlock("sablonium_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SABLONIUM_END_ORE = registerBlock("sablonium_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(4, 8), BlockBehaviour.Properties.of()
                    .strength(6f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> SABLONIUM_BLOCK = registerBlock("sablonium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> RAW_SABLONIUM_BLOCK = registerBlock("raw_sablonium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SABLONIUM_BRICKS = registerBlock("sablonium_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    // Sab Block Type Blocks

    public static final RegistryObject<StairBlock> SABLONIUM_STAIRS = registerBlock("sablonium_stairs",
            () -> new StairBlock(ModBlocks.SABLONIUM_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> SABLONIUM_SLAB = registerBlock("sablonium_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<PressurePlateBlock> SABLONIUM_PRESSURE_PLATE = registerBlock("sablonium_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> SABLONIUM_BUTTON = registerBlock("sablonium_button",
            () -> new ButtonBlock(BlockSetType.IRON,1, BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().noCollission()));

    public static final RegistryObject<FenceBlock> SABLONIUM_FENCE = registerBlock("sablonium_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> SABLONIUM_FENCE_GATE = registerBlock("sablonium_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> SABLONIUM_WALL = registerBlock("sablonium_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<DoorBlock> SABLONIUM_DOOR = registerBlock("sablonium_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> SABLONIUM_TRAPDOOR = registerBlock("sablonium_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));



    // Custom Blocks

    public static final RegistryObject<Block> TRANSMUTATOR = registerBlock("transmutator",
            () -> new Transmutator(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(ModSounds.TRANSMUTATOR_SOUNDS)));

    public static final RegistryObject<Block> SABLONIUM_LAMP = registerBlock("sablonium_lamp",
            () -> new SabloniumLampBlock(BlockBehaviour.Properties.of().strength(2f)
                    .lightLevel(state -> state.getValue(SabloniumLampBlock.CLICKED) ? 15 : 0)));

    public static final RegistryObject<Block> SABLONIUM_CORE = registerBlock("sablonium_core",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(7f).requiresCorrectToolForDrops().sound(SoundType.HEAVY_CORE)));

    // Crops & Misc.

    public static final RegistryObject<Block> KOHLRABI_CROP = BLOCKS.register("kohlrabi_crop",
            () -> new KohlrabiCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));

    public static final RegistryObject<Block> HONEY_BERRY_BUSH = BLOCKS.register("honey_berry_bush",
            () -> new HoneyBerryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));


    // BUFFER ROOM








    // Example Alexandrite Blocks

    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).noLootTable().sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).noLootTable()));

    public static final RegistryObject<Block> ALEXANDRITE_ORE = registerBlock("alexandrite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(4f).noLootTable()));
    public static final RegistryObject<Block> ALEXANDRITE_DEEPSLATE_ORE = registerBlock("alexandrite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of()
                    .strength(5f).noLootTable().sound(SoundType.DEEPSLATE)));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

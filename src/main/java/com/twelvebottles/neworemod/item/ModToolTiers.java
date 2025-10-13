package com.twelvebottles.neworemod.item;

import com.twelvebottles.neworemod.block.ModBlocks;
import com.twelvebottles.neworemod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier SABLONIUM = new ForgeTier(200, 7, 3f, 50,
            ModTags.Blocks.NEEDS_SABLONIUM_TOOL, () -> Ingredient.of(ModItems.SABLONIUM_INGOT.get()),
            ModTags.Blocks.INCORRECT_FOR_SABLONIUM_TOOL);

    public static final Tier SABLONIUM_EXOTIC = new ForgeTier(2000, 7, 3f, 50,
            ModTags.Blocks.NEEDS_SABLONIUM_TOOL, () -> Ingredient.of(ModBlocks.SABLONIUM_BLOCK.get()),
            ModTags.Blocks.INCORRECT_FOR_SABLONIUM_TOOL);
}
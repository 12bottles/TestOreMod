package com.twelvebottles.neworemod.util;

import com.twelvebottles.neworemod.NewOreMod;
import com.twelvebottles.neworemod.component.ModDataComponentTypes;
import com.twelvebottles.neworemod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(NewOreMod.MOD_ID, "used"),
                (itemStack, clientLevel, livingEntity, i) -> itemStack.get(ModDataComponentTypes.COORDINATES.get()) != null ? 1f : 0f);

    }
}
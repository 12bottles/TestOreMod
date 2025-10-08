package com.twelvebottles.neworemod.datagen;

import com.twelvebottles.neworemod.NewOreMod;
import com.twelvebottles.neworemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NewOreMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.SABLONIUM_INGOT.get());
        basicItem(ModItems.RAW_SABLONIUM.get());

    }
}
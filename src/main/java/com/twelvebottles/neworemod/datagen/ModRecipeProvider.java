package com.twelvebottles.neworemod.datagen;

import com.twelvebottles.neworemod.NewOreMod;
import com.twelvebottles.neworemod.block.ModBlocks;
import com.twelvebottles.neworemod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> SABLONIUM_SMELTABLES = List.of(ModItems.RAW_SABLONIUM.get(),
                ModBlocks.SABLONIUM_ORE.get(), ModBlocks.SABLONIUM_DEEPSLATE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SABLONIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.SABLONIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.SABLONIUM_INGOT.get()), has(ModItems.SABLONIUM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SABLONIUM_BRICKS.get(), 4)
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.SABLONIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.SABLONIUM_INGOT.get()), has(ModItems.SABLONIUM_INGOT.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SABLONIUM_INGOT.get(), 9)
                .requires(ModBlocks.SABLONIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SABLONIUM_BLOCK.get()), has(ModBlocks.SABLONIUM_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.OAK_LOG, 32)
                .requires(ModBlocks.SABLONIUM_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.SABLONIUM_BLOCK.get()), has(ModBlocks.SABLONIUM_BLOCK.get()))
                .save(pRecipeOutput, NewOreMod.MOD_ID + ":sablonium_ingot_from_sablonium_bricks");

        oreSmelting(pRecipeOutput, SABLONIUM_SMELTABLES, RecipeCategory.MISC, ModItems.SABLONIUM_INGOT.get(), 0.25f, 200, "sablonium_ingot");
        oreBlasting(pRecipeOutput, SABLONIUM_SMELTABLES, RecipeCategory.MISC, ModItems.SABLONIUM_INGOT.get(), 0.25f, 100, "sablonium_ingot");

        stairBuilder(ModBlocks.SABLONIUM_STAIRS.get(), Ingredient.of(ModItems.SABLONIUM_INGOT.get())).group("sablonium")
                .unlockedBy(getHasName(ModItems.SABLONIUM_INGOT.get()), has(ModItems.SABLONIUM_INGOT.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SABLONIUM_SLAB.get(), ModItems.SABLONIUM_INGOT.get());

        buttonBuilder(ModBlocks.SABLONIUM_BUTTON.get(), Ingredient.of(ModItems.SABLONIUM_INGOT.get())).group("sablonium")
                .unlockedBy(getHasName(ModItems.SABLONIUM_INGOT.get()), has(ModItems.SABLONIUM_INGOT.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.SABLONIUM_PRESSURE_PLATE.get(), ModItems.SABLONIUM_INGOT.get());

        fenceBuilder(ModBlocks.SABLONIUM_FENCE.get(), Ingredient.of(ModItems.SABLONIUM_INGOT.get())).group("sablonium")
                .unlockedBy(getHasName(ModItems.SABLONIUM_INGOT.get()), has(ModItems.SABLONIUM_INGOT.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.SABLONIUM_FENCE_GATE.get(), Ingredient.of(ModItems.SABLONIUM_INGOT.get())).group("sablonium")
                .unlockedBy(getHasName(ModItems.SABLONIUM_INGOT.get()), has(ModItems.SABLONIUM_INGOT.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SABLONIUM_WALL.get(), ModItems.SABLONIUM_INGOT.get());

        doorBuilder(ModBlocks.SABLONIUM_DOOR.get(), Ingredient.of(ModItems.SABLONIUM_INGOT.get())).group("sablonium")
                .unlockedBy(getHasName(ModItems.SABLONIUM_INGOT.get()), has(ModItems.SABLONIUM_INGOT.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.SABLONIUM_TRAPDOOR.get(), Ingredient.of(ModItems.SABLONIUM_INGOT.get())).group("sablonium")
                .unlockedBy(getHasName(ModItems.SABLONIUM_INGOT.get()), has(ModItems.SABLONIUM_INGOT.get())).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SABLONIUM_CORE.get())
                .pattern("CAC")
                .pattern("ABA")
                .pattern("CAC")
                .define('A', ModItems.SABLONIUM_INGOT.get())
                .define('B', Items.HEAVY_CORE)
                .define('C', ModBlocks.SABLONIUM_BLOCK.get())
                .unlockedBy(getHasName(Items.HEAVY_CORE), has(ModBlocks.SABLONIUM_BLOCK.get())).save(pRecipeOutput);




        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SABLONIUM_HAMMER.get())
                .pattern("  B")
                .pattern(" A ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', ModBlocks.SABLONIUM_CORE.get())
                .unlockedBy(getHasName(ModBlocks.SABLONIUM_CORE.get()), has(ModItems.SABLONIUM_INGOT.get())).save(pRecipeOutput);



    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, NewOreMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
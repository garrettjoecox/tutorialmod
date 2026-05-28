package dev.punkdawg12.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import dev.punkdawg12.tutorialmod.block.ModBlocks;
import dev.punkdawg12.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> TIN_SMELTABLES = List.of(ModItems.RAW_TIN, ModBlocks.TIN_ORE, ModBlocks.TIN_DEEPSLATE_ORE,
                        ModBlocks.TIN_NETHER_ORE, ModBlocks.TIN_END_ORE);

                oreSmelting(TIN_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.TIN, 0.25f, 200, "tin");
                oreBlasting(TIN_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.TIN, 0.25f, 100, "tin");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.TIN, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_BLOCK);

                shaped(RecipeCategory.MISC, ModBlocks.RAW_TIN_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModItems.RAW_TIN)
                        .unlockedBy(getHasName(ModItems.RAW_TIN), has(ModItems.RAW_TIN))
                        .group("tin")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.RAW_TIN, 9)
                        .requires(ModBlocks.RAW_TIN_BLOCK)
                        .unlockedBy(getHasName(ModBlocks.RAW_TIN_BLOCK), has(ModBlocks.RAW_TIN_BLOCK))
                        .group("tin")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.RAW_TIN, 4)
                        .requires(ModItems.TIN)
                        .requires(Items.STICK)
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("tin")
                        .save(output, "raw_tin_from_tin_and_stick");

                stairBuilder(ModBlocks.TIN_STAIRS, Ingredient.of(ModBlocks.TIN_BLOCK))
                        .unlockedBy(getHasName(ModBlocks.TIN_BLOCK), has(ModBlocks.TIN_BLOCK))
                        .group("tin")
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_SLAB, ModBlocks.TIN_BLOCK);

                buttonBuilder(ModBlocks.TIN_BUTTON, Ingredient.of(ModItems.TIN))
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .group("tin")
                        .save(output);
                pressurePlate(ModBlocks.TIN_PRESSURE_PLATE, ModItems.TIN);

                fenceBuilder(ModBlocks.TIN_FENCE, Ingredient.of(ModItems.TIN))
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .group("tin")
                        .save(output);
                fenceGateBuilder(ModBlocks.TIN_FENCE_GATE, Ingredient.of(ModItems.TIN))
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .group("tin")
                        .save(output);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_WALL, ModBlocks.TIN_BLOCK);

                doorBuilder(ModBlocks.TIN_DOOR, Ingredient.of(ModItems.TIN))
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .group("tin")
                        .save(output);
                trapdoorBuilder(ModBlocks.TIN_TRAPDOOR, Ingredient.of(ModItems.TIN))
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .group("tin")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.TIN_SWORD)
                        .pattern("F")
                        .pattern("F")
                        .pattern("S")
                        .define('F', ModItems.TIN)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("tin")
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.TIN_PICKAXE)
                        .pattern("FFF")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('F', ModItems.TIN)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("tin")
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.TIN_SHOVEL)
                        .pattern("F")
                        .pattern("S")
                        .pattern("S")
                        .define('F', ModItems.TIN)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("tin")
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.TIN_AXE)
                        .pattern("FF")
                        .pattern("SF")
                        .pattern("S ")
                        .define('F', ModItems.TIN)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("tin")
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.TIN_HOE)
                        .pattern("FF")
                        .pattern("S ")
                        .pattern("S ")
                        .define('F', ModItems.TIN)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("tin")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.TIN_SPEAR)
                        .pattern("  F")
                        .pattern(" S ")
                        .pattern("S  ")
                        .define('F', ModItems.TIN)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("tin")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.TIN_HELMET)
                        .pattern("FFF")
                        .pattern("F F")
                        .define('F', ModItems.TIN)
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .group("tin")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.TIN_CHESTPLATE)
                        .pattern("F F")
                        .pattern("FFF")
                        .pattern("FFF")
                        .define('F', ModItems.TIN)
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .group("tin")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.TIN_LEGGINGS)
                        .pattern("FFF")
                        .pattern("F F")
                        .pattern("F F")
                        .define('F', ModItems.TIN)
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .group("tin")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.TIN_BOOTS)
                        .pattern("F F")
                        .pattern("F F")
                        .define('F', ModItems.TIN)
                        .unlockedBy(getHasName(ModItems.TIN), has(ModItems.TIN))
                        .group("tin")
                        .save(output);


            }
        };
    }

    @Override
    public String getName() {
        return "TutorialMod Recipes";
    }
}

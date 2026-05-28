package dev.punkdawg12.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import dev.punkdawg12.tutorialmod.block.ModBlocks;
import dev.punkdawg12.tutorialmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.RAW_TIN_BLOCK)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.TIN_DEEPSLATE_ORE)
                .add(ModBlocks.TIN_NETHER_ORE)
                .add(ModBlocks.TIN_END_ORE)
                .add(ModBlocks.MAGIC_BLOCK)
                .add(ModBlocks.TIN_STAIRS)
                .add(ModBlocks.TIN_SLAB)
                .add(ModBlocks.TIN_FENCE)
                .add(ModBlocks.TIN_FENCE_GATE)
                .add(ModBlocks.TIN_WALL)
                .add(ModBlocks.TIN_DOOR)
                .add(ModBlocks.TIN_TRAPDOOR);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TIN_DEEPSLATE_ORE);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TIN_NETHER_ORE)
                .add(ModBlocks.TIN_END_ORE);

        valueLookupBuilder(BlockTags.STAIRS).add(ModBlocks.TIN_STAIRS);
        valueLookupBuilder(BlockTags.SLABS).add(ModBlocks.TIN_SLAB);
        valueLookupBuilder(BlockTags.BUTTONS).add(ModBlocks.TIN_BUTTON);
        valueLookupBuilder(BlockTags.PRESSURE_PLATES).add(ModBlocks.TIN_PRESSURE_PLATE);

        valueLookupBuilder(BlockTags.FENCES).add(ModBlocks.TIN_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES).add(ModBlocks.TIN_FENCE_GATE);
        valueLookupBuilder(BlockTags.WALLS).add(ModBlocks.TIN_WALL);

        valueLookupBuilder(BlockTags.DOORS).add(ModBlocks.TIN_DOOR);
        valueLookupBuilder(BlockTags.TRAPDOORS).add(ModBlocks.TIN_TRAPDOOR);

        valueLookupBuilder(ModTags.Blocks.NEEDS_TIN_TOOL)
                .add(ModBlocks.MAGIC_BLOCK)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        valueLookupBuilder(ModTags.Blocks.INCORRECT_FOR_TIN_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);


    }
}

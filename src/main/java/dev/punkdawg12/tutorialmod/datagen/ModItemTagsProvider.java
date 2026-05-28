package dev.punkdawg12.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import dev.punkdawg12.tutorialmod.item.ModItems;
import dev.punkdawg12.tutorialmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.TIN)
                .add(Items.IRON_INGOT)
                .add(Items.COAL)
                .add(Items.BRICK);

        valueLookupBuilder(ItemTags.SWORDS).add(ModItems.TIN_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES).add(ModItems.TIN_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS).add(ModItems.TIN_SHOVEL);
        valueLookupBuilder(ItemTags.AXES).add(ModItems.TIN_AXE);
        valueLookupBuilder(ItemTags.HOES).add(ModItems.TIN_HOE);
        valueLookupBuilder(ItemTags.SPEARS).add(ModItems.TIN_SPEAR);

        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(ModItems.TIN_HELMET);
        valueLookupBuilder(ItemTags.CHEST_ARMOR).add(ModItems.TIN_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR).add(ModItems.TIN_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR).add(ModItems.TIN_BOOTS);

    }
}

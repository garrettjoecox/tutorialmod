package dev.punkdawg12.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import dev.punkdawg12.tutorialmod.block.ModBlocks;
import dev.punkdawg12.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.TIN_BLOCK);
        dropSelf(ModBlocks.RAW_TIN_BLOCK);

        add(ModBlocks.TIN_ORE, createOreDrop(ModBlocks.TIN_ORE, ModItems.RAW_TIN));
        add(ModBlocks.TIN_DEEPSLATE_ORE, createOreDrop(ModBlocks.TIN_DEEPSLATE_ORE, ModItems.RAW_TIN));

        add(ModBlocks.TIN_NETHER_ORE, createMultipleOreDrops(ModBlocks.TIN_NETHER_ORE, ModItems.RAW_TIN, 3, 6));
        add(ModBlocks.TIN_END_ORE, createMultipleOreDrops(ModBlocks.TIN_END_ORE, ModItems.RAW_TIN, 5, 8));

        dropSelf(ModBlocks.MAGIC_BLOCK);
        dropSelf(ModBlocks.TIN_STAIRS);
        add(ModBlocks.TIN_SLAB, this::createSlabItemTable);

        dropSelf(ModBlocks.TIN_BUTTON);
        dropSelf(ModBlocks.TIN_PRESSURE_PLATE);
        dropSelf(ModBlocks.TIN_FENCE);
        dropSelf(ModBlocks.TIN_FENCE_GATE);
        dropSelf(ModBlocks.TIN_WALL);
        dropSelf(ModBlocks.TIN_TRAPDOOR);

        add(ModBlocks.TIN_DOOR, this::createDoorTable);

    }

    public LootTable.Builder createMultipleOreDrops(final Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(
                        block, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }
}

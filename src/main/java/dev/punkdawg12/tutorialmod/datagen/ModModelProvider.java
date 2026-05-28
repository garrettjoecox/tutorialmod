package dev.punkdawg12.tutorialmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import dev.punkdawg12.tutorialmod.block.ModBlocks;
import dev.punkdawg12.tutorialmod.item.ModArmorMaterials;
import dev.punkdawg12.tutorialmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        // blockModelGenerators.createTrivialCube(ModBlocks.TIN_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.RAW_TIN_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.TIN_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.TIN_DEEPSLATE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.TIN_NETHER_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.TIN_END_ORE);

        blockModelGenerators.createTrivialCube(ModBlocks.MAGIC_BLOCK);

        blockModelGenerators.family(ModBlocks.TIN_BLOCK)
                .stairs(ModBlocks.TIN_STAIRS)
                .slab(ModBlocks.TIN_SLAB)
                .button(ModBlocks.TIN_BUTTON)
                .pressurePlate(ModBlocks.TIN_PRESSURE_PLATE)
                .fence(ModBlocks.TIN_FENCE)
                .fenceGate(ModBlocks.TIN_FENCE_GATE)
                .wall(ModBlocks.TIN_WALL);

        blockModelGenerators.createDoor(ModBlocks.TIN_DOOR);
        blockModelGenerators.createTrapdoor(ModBlocks.TIN_TRAPDOOR);


    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.TIN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_TIN, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STRAWBERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.COMBUSTIBLE_SPORES, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.TIN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TIN_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TIN_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TIN_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TIN_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModItems.TIN_SPEAR);

        itemModelGenerators.generateTrimmableItem(ModItems.TIN_HELMET, ModArmorMaterials.TIN_KEY,
                ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(ModItems.TIN_CHESTPLATE, ModArmorMaterials.TIN_KEY,
                ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(ModItems.TIN_LEGGINGS, ModArmorMaterials.TIN_KEY,
                ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.TIN_BOOTS, ModArmorMaterials.TIN_KEY,
                ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

    }
}

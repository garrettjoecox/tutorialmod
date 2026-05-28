package dev.punkdawg12.tutorialmod.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import dev.punkdawg12.tutorialmod.TutorialMod;
import dev.punkdawg12.tutorialmod.block.ModBlocks;
import dev.punkdawg12.tutorialmod.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab TIN_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "tin_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIN))
                    .title(Component.translatable("creativemodetab.tutorialmod.tin_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.TIN);
                        output.accept(ModItems.RAW_TIN);

                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.STRAWBERRY);

                        output.accept(ModItems.COMBUSTIBLE_SPORES);

                        output.accept(ModItems.TIN_SWORD);
                        output.accept(ModItems.TIN_PICKAXE);
                        output.accept(ModItems.TIN_SHOVEL);
                        output.accept(ModItems.TIN_AXE);
                        output.accept(ModItems.TIN_HOE);
                        output.accept(ModItems.TIN_SPEAR);

                        output.accept(ModItems.TIN_HELMET);
                        output.accept(ModItems.TIN_CHESTPLATE);
                        output.accept(ModItems.TIN_LEGGINGS);
                        output.accept(ModItems.TIN_BOOTS);


                    }).build());

    public static final CreativeModeTab TIN_BLOCK_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "tin_blocks"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TIN_BLOCK))
                    .title(Component.translatable("creativemodetab.tutorialmod.tin_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.TIN_BLOCK);
                        output.accept(ModBlocks.RAW_TIN_BLOCK);
                        output.accept(ModBlocks.TIN_ORE);
                        output.accept(ModBlocks.TIN_DEEPSLATE_ORE);

                        output.accept(ModBlocks.TIN_NETHER_ORE);
                        output.accept(ModBlocks.TIN_END_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);

                        output.accept(ModBlocks.TIN_STAIRS);
                        output.accept(ModBlocks.TIN_SLAB);
                        output.accept(ModBlocks.TIN_BUTTON);
                        output.accept(ModBlocks.TIN_PRESSURE_PLATE);
                        output.accept(ModBlocks.TIN_FENCE);
                        output.accept(ModBlocks.TIN_FENCE_GATE);
                        output.accept(ModBlocks.TIN_WALL);
                        output.accept(ModBlocks.TIN_DOOR);
                        output.accept(ModBlocks.TIN_TRAPDOOR);


                    }).build());


    public static void registerModCreativeModeTabs() {
        TutorialMod.LOGGER.info("Registering Creative Mode Tabs for " + TutorialMod.MOD_ID);
    }
}

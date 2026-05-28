package dev.punkdawg12.tutorialmod.block;

import dev.punkdawg12.tutorialmod.TutorialMod;
import dev.punkdawg12.tutorialmod.block.custom.MagicBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlocks {
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            properties -> new Block(properties.strength(3f)
                    .requiresCorrectToolForDrops()));

    public static final Block TIN_ORE = registerBlock("tin_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 5),
                    properties.strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final Block TIN_DEEPSLATE_ORE = registerBlock("tin_deepslate_ore",
            properties -> new DropExperienceBlock(UniformInt.of(3, 6),
                    properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final Block TIN_NETHER_ORE = registerBlock("tin_nether_ore",
            properties -> new DropExperienceBlock(UniformInt.of(1, 5),
                    properties.strength(3f).requiresCorrectToolForDrops()));
    public static final Block TIN_END_ORE = registerBlock("tin_end_ore",
            properties -> new DropExperienceBlock(UniformInt.of(4, 8),
                    properties.strength(6f).requiresCorrectToolForDrops()));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            properties -> new MagicBlock(properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)), Component.translatable("tooltip.tutorialmod.magic_block"));


    public static final Block TIN_STAIRS = registerBlock("tin_stairs",
            properties -> new StairBlock(ModBlocks.TIN_BLOCK.defaultBlockState(),
                    properties.strength(3f).requiresCorrectToolForDrops()));
    public static final Block TIN_SLAB = registerBlock("tin_slab",
            properties -> new SlabBlock(properties.strength(3f).requiresCorrectToolForDrops()));

    public static final Block TIN_BUTTON = registerBlock("tin_button",
            properties -> new ButtonBlock(BlockSetType.IRON, 20,
                    properties.strength(3f).noCollision()));
    public static final Block TIN_PRESSURE_PLATE = registerBlock("tin_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.IRON,
                    properties.mapColor(MapColor.COLOR_BLUE).forceSolidOn().instrument(NoteBlockInstrument.BASS)
                            .noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY)));

    public static final Block TIN_FENCE = registerBlock("tin_fence",
            properties -> new FenceBlock(properties.strength(3f).requiresCorrectToolForDrops()));
    public static final Block TIN_FENCE_GATE = registerBlock("tin_fence_gate",
            properties -> new FenceGateBlock(WoodType.ACACIA,
                    properties.strength(3f).requiresCorrectToolForDrops()));
    public static final Block TIN_WALL = registerBlock("tin_wall",
            properties -> new WallBlock(properties.strength(3f).requiresCorrectToolForDrops()));

    public static final Block TIN_DOOR = registerBlock("tin_door",
            properties -> new DoorBlock(BlockSetType.IRON, properties.strength(3f)
                    .requiresCorrectToolForDrops().noOcclusion()));
    public static final Block TIN_TRAPDOOR = registerBlock("tin_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.IRON, properties.strength(3f)
                    .requiresCorrectToolForDrops().noOcclusion()));



    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function, Component... tooltips) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name))));
        registerBlockItem(name, toRegister, tooltips);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block, Component... tooltips) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name)))) {
                    @Override
                    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                        for(var component : tooltips) {
                            builder.accept(component);
                        }
                        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                    }
                });
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);
    }
}

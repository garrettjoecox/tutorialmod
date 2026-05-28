package dev.punkdawg12.tutorialmod.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import dev.punkdawg12.tutorialmod.TutorialMod;
import dev.punkdawg12.tutorialmod.food.ModFoods;
import dev.punkdawg12.tutorialmod.item.custom.ChiselItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {
    public static final Item TIN = registerItem("tin", Item::new);
    public static final Item RAW_TIN = registerItem("raw_tin", Item::new);

    public static final Item CHISEL = registerItem("chisel", properties -> new ChiselItem(properties.durability(32)));
    public static final Item STRAWBERRY = registerItem("strawberry", properties -> new Item(properties
            .food(ModFoods.STRAWBERRY, ModFoods.STRAWBERRY_CONSUMABLE)) {
        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
            builder.accept(Component.translatable("tooltip.tutorialmod.strawberry"));
            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    });

    public static final Item COMBUSTIBLE_SPORES = registerItem("combustible_spores", properties -> new Item(properties.stacksTo(16)));

    public static final Item TIN_SWORD = registerItem("tin_sword",
            properties -> new Item(properties.sword(ModToolMaterials.TIN, 3, -2.4f)));
    public static final Item TIN_PICKAXE = registerItem("tin_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolMaterials.TIN, 1, -2.8f)));
    public static final Item TIN_SHOVEL = registerItem("tin_shovel",
            properties -> new ShovelItem(ModToolMaterials.TIN, 1.5f, -3.0f, properties));
    public static final Item TIN_AXE = registerItem("tin_axe",
            properties -> new AxeItem(ModToolMaterials.TIN, 6f, -3.2f, properties));
    public static final Item TIN_HOE = registerItem("tin_hoe",
            properties -> new HoeItem(ModToolMaterials.TIN, 0f, -3.0f, properties));
    public static final Item TIN_SPEAR = registerItem("tin_spear",
            properties -> new Item(properties.spear(ModToolMaterials.TIN, 0.95F, 0.95F, 0.6F,
                    2.5F, 11.0F, 6.75F, 5.1F, 11.25F, 4.6F)));

    public static final Item TIN_HELMET = registerItem("tin_helmet",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.TIN_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final Item TIN_CHESTPLATE = registerItem("tin_chestplate",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.TIN_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final Item TIN_LEGGINGS = registerItem("tin_leggings",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.TIN_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final Item TIN_BOOTS = registerItem("tin_boots",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.TIN_ARMOR_MATERIAL, ArmorType.BOOTS)));



    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(TIN);
            output.accept(RAW_TIN);
        });
    }
}

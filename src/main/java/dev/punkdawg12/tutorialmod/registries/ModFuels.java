package dev.punkdawg12.tutorialmod.registries;

import net.fabricmc.fabric.api.registry.FuelValueEvents;
import dev.punkdawg12.tutorialmod.item.ModItems;

public class ModFuels {
    public static void registerFuels() {
        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.COMBUSTIBLE_SPORES, 1200);
        });
    }
}

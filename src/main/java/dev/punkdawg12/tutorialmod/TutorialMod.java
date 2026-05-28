package dev.punkdawg12.tutorialmod;

import net.fabricmc.api.ModInitializer;

import dev.punkdawg12.tutorialmod.block.ModBlocks;
import dev.punkdawg12.tutorialmod.creativemodetab.ModCreativeModeTabs;
import dev.punkdawg12.tutorialmod.item.ModItems;
import dev.punkdawg12.tutorialmod.registries.ModFuels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Important Comment
public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();


		ModFuels.registerFuels();

	}
}
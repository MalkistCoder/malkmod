package dev.malkist.malkmod;

import dev.malkist.malkmod.block.ModBlocks;
import dev.malkist.malkmod.item.ModItemGroups;
import dev.malkist.malkmod.item.ModItems;
import dev.malkist.malkmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MalkMod implements ModInitializer {
	public static final String MOD_ID = "malkmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Mod " + MOD_ID + " initialized.");

		ModItemGroups.registerModItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();
	}
}
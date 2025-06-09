package codes.malki.malkmod;

import codes.malki.malkmod.block.ModBlocks;
import codes.malki.malkmod.item.ModItemGroups;
import codes.malki.malkmod.item.ModItems;
import codes.malki.malkmod.world.gen.ModWorldGeneration;
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
package codes.malki.malkmod.item;

import codes.malki.malkmod.MalkMod;
import codes.malki.malkmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MALKMOD_ITEM_GROUP = Registry.register(
            Registries.ITEM_GROUP, new Identifier(MalkMod.MOD_ID, "malkmod"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.malkmod"))
                    .icon(() -> new ItemStack(ModItems.SUN))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModBlocks.RUBY_BLOCK);

                        entries.add(ModBlocks.COPPER_WIRE);

                        entries.add(ModItems.YELLOW_PHOSPHOR);
                        entries.add(ModBlocks.YELLOW_PHOSPHOR_ORE);
                        entries.add(ModBlocks.YELLOW_PHOSPHOR_BLOCK);

                        entries.add(ModItems.SUN);
                        entries.add(ModItems.PHOSPHOR_AMBER);
                        entries.add(ModItems.PHOSPHOR_FEATHER);
                        entries.add(ModBlocks.PHOSPHOR_DIE);

                        entries.add(ModBlocks.GLOWWOOD_LOG);
                        entries.add(ModBlocks.GLOWWOOD_WOOD);
                        entries.add(ModBlocks.GLOWWOOD_PLANKS);
                        entries.add(ModBlocks.GLOWWOOD_STAIRS);
                        entries.add(ModBlocks.GLOWWOOD_SLAB);
                        entries.add(ModBlocks.GLOWWOOD_FENCE);
                        entries.add(ModBlocks.GLOWWOOD_FENCE_GATE);
                        entries.add(ModBlocks.GLOWWOOD_BUTTON);
                        entries.add(ModBlocks.GLOWWOOD_PRESSURE_PLATE);
                        entries.add(ModBlocks.GLOWWOOD_DOOR);
                        entries.add(ModBlocks.GLOWWOOD_TRAPDOOR);

                        entries.add(ModItems.THE_FIRST_GLASS_BEACH_ALBUM);
                    }))
                    .build()
    );

    public static void registerModItemGroups() {
        MalkMod.LOGGER.info("Registering mod item groups for " + MalkMod.MOD_ID);
    }
}

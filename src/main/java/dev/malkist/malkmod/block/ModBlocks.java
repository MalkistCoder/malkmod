package dev.malkist.malkmod.block;

import dev.malkist.malkmod.MalkMod;
import dev.malkist.malkmod.block.custom.PhosphorDieBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock(
            "ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)
                    .mapColor(MapColor.BRIGHT_RED)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            )
    );

    public static final Block COPPER_WIRE = registerBlock("copper_wire",
            new TripwireBlock(null, FabricBlockSettings.copyOf(Blocks.TRIPWIRE))
    );

    public static final Block YELLOW_PHOSPHOR_ORE = registerBlock("yellow_phosphor_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE)
                    .luminance(8),
                    UniformIntProvider.create(1, 4)
            )
    );
    public static final Block YELLOW_PHOSPHOR_BLOCK = registerBlock("yellow_phosphor_block",
            new Block(FabricBlockSettings.copyOf(Blocks.YELLOW_WOOL)
                    .luminance(15)
                    .requiresTool()
            )
    );

    public static final Block GLOWWOOD_LOG = registerBlock("glowwood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).luminance(8))
    );
    public static final Block GLOWWOOD_WOOD = registerBlock("glowwood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).luminance(8))
    );
    public static final Block GLOWWOOD_PLANKS = registerBlock("glowwood_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).luminance(8))
    );

    public static final Block GLOWWOOD_STAIRS = registerBlock("glowwood_stairs",
            new StairsBlock(GLOWWOOD_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).luminance(8))
    );
    public static final Block GLOWWOOD_SLAB = registerBlock("glowwood_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).luminance(8))
    );

    public static final Block GLOWWOOD_BUTTON = registerBlock("glowwood_button",
            new ButtonBlock(
                    FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).luminance(8),
                    BlockSetType.OAK, 15, true
            )
    );
    public static final Block GLOWWOOD_PRESSURE_PLATE = registerBlock("glowwood_pressure_plate",
            new PressurePlateBlock(
                    PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).luminance(8),
                    BlockSetType.OAK
            )
    );

    public static final Block GLOWWOOD_FENCE = registerBlock("glowwood_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).luminance(8))
    );
    public static final Block GLOWWOOD_FENCE_GATE = registerBlock("glowwood_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).luminance(8), WoodType.OAK)
    );

    public static final Block GLOWWOOD_DOOR = registerBlock("glowwood_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).luminance(8), BlockSetType.OAK)
    );
    public static final Block GLOWWOOD_TRAPDOOR = registerBlock("glowwood_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).luminance(8), BlockSetType.OAK)
    );

    public static final Block PHOSPHOR_DIE = registerBlock("phosphor_die",
            new PhosphorDieBlock(FabricBlockSettings.copyOf(Blocks.GLOWSTONE).notSolid().sounds(BlockSoundGroup.DEEPSLATE_BRICKS).nonOpaque()),
            new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)
    );


    private static Block registerBlock(String name, Block block) {
        return registerBlock(name, block, new FabricItemSettings());
    }

    private static Block registerBlock(String name, Block block, FabricItemSettings itemSettings) {
        registerBlockItem(name, block, itemSettings);

        return Registry.register(Registries.BLOCK, new Identifier(MalkMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block, FabricItemSettings itemSettings) {
        Registry.register(
                Registries.ITEM, new Identifier(MalkMod.MOD_ID, name),
                new BlockItem(block, itemSettings)
        );
    }

    public static void registerModBlocks() {
        MalkMod.LOGGER.info("Registering modded blocks for " + MalkMod.MOD_ID);
    }
}

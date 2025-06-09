package codes.malki.malkmod.datagen;

import codes.malki.malkmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.YELLOW_PHOSPHOR_ORE);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.YELLOW_PHOSPHOR_BLOCK)
                .add(ModBlocks.RUBY_BLOCK);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.GLOWWOOD_LOG)
                .add(ModBlocks.GLOWWOOD_WOOD)
                .add(ModBlocks.GLOWWOOD_PLANKS)
                .add(ModBlocks.GLOWWOOD_PRESSURE_PLATE)
                .add(ModBlocks.GLOWWOOD_BUTTON)
                .add(ModBlocks.GLOWWOOD_FENCE)
                .add(ModBlocks.GLOWWOOD_FENCE_GATE)
                .add(ModBlocks.GLOWWOOD_STAIRS)
                .add(ModBlocks.GLOWWOOD_SLAB)
                .add(ModBlocks.GLOWWOOD_DOOR)
                .add(ModBlocks.GLOWWOOD_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.YELLOW_PHOSPHOR_ORE)
                .add(ModBlocks.YELLOW_PHOSPHOR_BLOCK);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "ores")))
                .add(ModBlocks.YELLOW_PHOSPHOR_ORE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "ores_in_ground/stone")))
                .add(ModBlocks.YELLOW_PHOSPHOR_ORE);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.GLOWWOOD_LOG)
                .add(ModBlocks.GLOWWOOD_WOOD);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.GLOWWOOD_LOG)
                .add(ModBlocks.GLOWWOOD_WOOD);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.GLOWWOOD_PLANKS);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.GLOWWOOD_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.GLOWWOOD_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.GLOWWOOD_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.GLOWWOOD_SLAB);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.GLOWWOOD_FENCE);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.GLOWWOOD_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.GLOWWOOD_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBlocks.GLOWWOOD_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.GLOWWOOD_DOOR);

        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.GLOWWOOD_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.GLOWWOOD_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.GLOWWOOD_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.GLOWWOOD_BUTTON);

        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.GLOWWOOD_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.GLOWWOOD_PRESSURE_PLATE);
    }
}

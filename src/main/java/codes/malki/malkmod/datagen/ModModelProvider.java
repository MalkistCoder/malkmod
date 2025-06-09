package codes.malki.malkmod.datagen;

import codes.malki.malkmod.block.ModBlocks;
import codes.malki.malkmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.YELLOW_PHOSPHOR_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.YELLOW_PHOSPHOR_ORE);

        blockStateModelGenerator.registerLog(ModBlocks.GLOWWOOD_LOG).log(ModBlocks.GLOWWOOD_LOG).wood(ModBlocks.GLOWWOOD_WOOD);
        BlockStateModelGenerator.BlockTexturePool glowwoodPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GLOWWOOD_PLANKS);

        glowwoodPool.button(ModBlocks.GLOWWOOD_BUTTON);
        glowwoodPool.slab(ModBlocks.GLOWWOOD_SLAB);
        glowwoodPool.stairs(ModBlocks.GLOWWOOD_STAIRS);
        glowwoodPool.fence(ModBlocks.GLOWWOOD_FENCE);
        glowwoodPool.pressurePlate(ModBlocks.GLOWWOOD_PRESSURE_PLATE);
        glowwoodPool.fenceGate(ModBlocks.GLOWWOOD_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.GLOWWOOD_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.GLOWWOOD_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.YELLOW_PHOSPHOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.THE_FIRST_GLASS_BEACH_ALBUM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.COPPER_WIRE.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModItems.PHOSPHOR_AMBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PHOSPHOR_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.PHOSPHOR_DIE.asItem(), Models.GENERATED);
    }
}

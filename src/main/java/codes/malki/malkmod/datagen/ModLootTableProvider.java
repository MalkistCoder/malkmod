package codes.malki.malkmod.datagen;

import codes.malki.malkmod.block.ModBlocks;
import codes.malki.malkmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RUBY_BLOCK);

        addDrop(ModBlocks.YELLOW_PHOSPHOR_BLOCK, phosphorBlockDrops(ModBlocks.YELLOW_PHOSPHOR_BLOCK, ModItems.YELLOW_PHOSPHOR, 4));
        addDrop(ModBlocks.YELLOW_PHOSPHOR_ORE, phosphorOreDrops(ModBlocks.YELLOW_PHOSPHOR_ORE, ModItems.YELLOW_PHOSPHOR));

        addDrop(ModBlocks.GLOWWOOD_LOG);
        addDrop(ModBlocks.GLOWWOOD_PLANKS);
        addDrop(ModBlocks.GLOWWOOD_BUTTON);
        addDrop(ModBlocks.GLOWWOOD_PRESSURE_PLATE);
        addDrop(ModBlocks.GLOWWOOD_STAIRS);
        addDrop(ModBlocks.GLOWWOOD_SLAB, slabDrops(ModBlocks.GLOWWOOD_SLAB));
        addDrop(ModBlocks.GLOWWOOD_DOOR, doorDrops(ModBlocks.GLOWWOOD_DOOR));
        addDrop(ModBlocks.GLOWWOOD_TRAPDOOR);
        addDrop(ModBlocks.GLOWWOOD_FENCE);
        addDrop(ModBlocks.GLOWWOOD_FENCE_GATE);

        addDrop(ModBlocks.PHOSPHOR_DIE);
    }

    public LootTable.Builder phosphorBlockDrops(Block drop, Item item, int count) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float)count)))
                )
        );
    }

    public LootTable.Builder phosphorOreDrops(Block drop, Item item) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }
}

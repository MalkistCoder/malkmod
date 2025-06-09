package codes.malki.malkmod.datagen;

import codes.malki.malkmod.block.ModBlocks;
import codes.malki.malkmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        // Ruby and Ruby Block
        offerReversibleCompactingRecipes(consumer, RecipeCategory.MISC, ModItems.RUBY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK);

        // Yellow Phosphor Dust and Block of Yellow Phosphor
        offer2x2CompactingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_PHOSPHOR_BLOCK, ModItems.YELLOW_PHOSPHOR);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.YELLOW_PHOSPHOR, 4)
                .input(ModBlocks.YELLOW_PHOSPHOR_BLOCK)
                .criterion(hasItem(ModBlocks.YELLOW_PHOSPHOR_BLOCK), conditionsFromItem(ModBlocks.YELLOW_PHOSPHOR_BLOCK))
                .criterion(hasItem(ModItems.YELLOW_PHOSPHOR), conditionsFromItem(ModItems.YELLOW_PHOSPHOR))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.YELLOW_PHOSPHOR)));

        // Yellow Phosphor Smelting
        List<ItemConvertible> yellowPhosphorOres = List.of(ModBlocks.YELLOW_PHOSPHOR_ORE);
        offerSmelting(consumer, yellowPhosphorOres, RecipeCategory.MISC, ModItems.YELLOW_PHOSPHOR, 1f, 200, "yellow_phosphor");
        offerBlasting(consumer, yellowPhosphorOres, RecipeCategory.MISC, ModItems.YELLOW_PHOSPHOR, 1f, 100, "yellow_phosphor");

        // Copper Wire
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COPPER_WIRE, 12)
                .pattern("###")
                .input('#', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModBlocks.COPPER_WIRE)));

        // Sun
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SUN, 1)
                .pattern(" N ")
                .pattern("PSP")
                .pattern(" B ")
                .input('N', Items.NETHERITE_INGOT)
                .input('S', ModBlocks.COPPER_WIRE)
                .input('P', ModBlocks.YELLOW_PHOSPHOR_BLOCK)
                .input('B', Items.GLASS_BOTTLE)
                .criterion(hasItem(ModItems.YELLOW_PHOSPHOR), conditionsFromItem(ModItems.YELLOW_PHOSPHOR))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SUN)));

        // the first glass beach album
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.THE_FIRST_GLASS_BEACH_ALBUM, 1)
                .pattern("SSS")
                .pattern(" # ")
                .pattern("GGG")
                .input('S', ItemTags.SMELTS_TO_GLASS)
                .input('#', ItemTags.MUSIC_DISCS)
                .input('G', Blocks.GLASS)
                .criterion("has_music_disc", conditionsFromTag(ItemTags.MUSIC_DISCS))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.THE_FIRST_GLASS_BEACH_ALBUM)));

        // Glowwood Log
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWWOOD_LOG, 4)
                .input(ItemTags.LOGS_THAT_BURN)
                .input(ItemTags.LOGS_THAT_BURN)
                .input(ItemTags.LOGS_THAT_BURN)
                .input(ItemTags.LOGS_THAT_BURN)
                .input(ModItems.YELLOW_PHOSPHOR)
                .criterion(hasItem(ModItems.YELLOW_PHOSPHOR), conditionsFromItem(ModItems.YELLOW_PHOSPHOR))
                .offerTo(consumer, new Identifier(getRecipeName(ModBlocks.GLOWWOOD_LOG)));

        // Glowwood Planks
        offerShapelessRecipe(consumer, ModBlocks.GLOWWOOD_PLANKS, ModBlocks.GLOWWOOD_LOG, "glowwood", 4);

        // Glowwood Set
        Ingredient glowwoodPlanksIngredient = Ingredient.ofItems(ModBlocks.GLOWWOOD_PLANKS);
        offerSlabRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWWOOD_SLAB, ModBlocks.GLOWWOOD_PLANKS);
        createStairsRecipe(ModBlocks.GLOWWOOD_STAIRS, glowwoodPlanksIngredient).criterion(hasItem(ModBlocks.GLOWWOOD_LOG), conditionsFromItem(ModBlocks.GLOWWOOD_LOG)).offerTo(consumer);
        offerSingleOutputShapelessRecipe(consumer, ModBlocks.GLOWWOOD_BUTTON, ModBlocks.GLOWWOOD_PLANKS, "glowwood");
        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWWOOD_PRESSURE_PLATE, glowwoodPlanksIngredient).criterion(hasItem(ModBlocks.GLOWWOOD_LOG), conditionsFromItem(ModBlocks.GLOWWOOD_LOG)).offerTo(consumer);
        createDoorRecipe(ModBlocks.GLOWWOOD_DOOR, glowwoodPlanksIngredient).criterion(hasItem(ModBlocks.GLOWWOOD_LOG), conditionsFromItem(ModBlocks.GLOWWOOD_LOG)).offerTo(consumer);
        createTrapdoorRecipe(ModBlocks.GLOWWOOD_TRAPDOOR, glowwoodPlanksIngredient).criterion(hasItem(ModBlocks.GLOWWOOD_LOG), conditionsFromItem(ModBlocks.GLOWWOOD_LOG)).offerTo(consumer);
        createFenceRecipe(ModBlocks.GLOWWOOD_FENCE, glowwoodPlanksIngredient).criterion(hasItem(ModBlocks.GLOWWOOD_LOG), conditionsFromItem(ModBlocks.GLOWWOOD_LOG)).offerTo(consumer);
        createFenceGateRecipe(ModBlocks.GLOWWOOD_FENCE_GATE, glowwoodPlanksIngredient).criterion(hasItem(ModBlocks.GLOWWOOD_LOG), conditionsFromItem(ModBlocks.GLOWWOOD_LOG)).offerTo(consumer);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PHOSPHOR_AMBER, 1)
                .pattern(" S ")
                .pattern("LPL")
                .pattern(" G ")
                .input('S', Items.STRING)
                .input('L', Items.LAPIS_LAZULI)
                .input('P', ModBlocks.YELLOW_PHOSPHOR_BLOCK)
                .input('G', Items.GLOWSTONE_DUST)
                .criterion(hasItem(ModItems.YELLOW_PHOSPHOR), conditionsFromItem(ModItems.YELLOW_PHOSPHOR))
                .offerTo(consumer);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PHOSPHOR_FEATHER, 1)
                .pattern("GPG")
                .pattern("PFP")
                .pattern("GPG")
                .input('G', Items.GOLD_INGOT)
                .input('P', ModBlocks.YELLOW_PHOSPHOR_BLOCK)
                .input('F', Items.FEATHER)
                .criterion(hasItem(ModItems.YELLOW_PHOSPHOR), conditionsFromItem(ModItems.YELLOW_PHOSPHOR))
                .offerTo(consumer);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModBlocks.PHOSPHOR_DIE, 1)
                .pattern("PTP")
                .input('T', ItemTags.TERRACOTTA)
                .input('P', ModBlocks.YELLOW_PHOSPHOR_BLOCK)
                .criterion(hasItem(ModItems.YELLOW_PHOSPHOR), conditionsFromItem(ModItems.YELLOW_PHOSPHOR))
                .offerTo(consumer);
    }
}

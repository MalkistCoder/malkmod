package dev.malkist.malkmod.item;

import dev.malkist.malkmod.MalkMod;
import dev.malkist.malkmod.item.custom.PhosphorAmberItem;
import dev.malkist.malkmod.item.custom.PhosphorFeatherItem;
import dev.malkist.malkmod.item.custom.SunItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item THE_FIRST_GLASS_BEACH_ALBUM = registerItem("the_first_glass_beach_album", new Item(new FabricItemSettings()));

    public static final Item YELLOW_PHOSPHOR = registerItem("yellow_phosphor",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder()
                            .hunger(1)
                            .saturationModifier(0F)
                            .alwaysEdible()
                            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 1200, 1), 1.0F)
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 2), 1.0F)
                            .build()
                    )
            )
    );

    public static final Item SUN = registerItem("sun",
            new SunItem(new FabricItemSettings()
                    .maxCount(1)
                    .rarity(Rarity.RARE)
            )
    );

    public static final Item PHOSPHOR_AMBER = registerItem("phosphor_amber",
            new PhosphorAmberItem(ModArmorMaterials.PHOSPHOR_AMBER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON))
    );
    public static final Item PHOSPHOR_FEATHER = registerItem("phosphor_feather",
            new PhosphorFeatherItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON))
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MalkMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MalkMod.LOGGER.info("Registering modded items for " + MalkMod.MOD_ID);
    }
}

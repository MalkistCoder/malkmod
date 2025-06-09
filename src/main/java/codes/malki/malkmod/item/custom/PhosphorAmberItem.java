package codes.malki.malkmod.item.custom;

import codes.malki.malkmod.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PhosphorAmberItem extends ArmorItem {
    public PhosphorAmberItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if ((!world.isClient()) && (entity instanceof PlayerEntity player)) {
            if (isWorn(player) && !player.hasStatusEffect(StatusEffects.REGENERATION)) {
                player.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.REGENERATION,
                        300, 1,
                        true, false, true
                ));
            }
        }
    }

    private boolean isWorn(PlayerEntity player) {
        ItemStack chestplateStack = player.getInventory().getArmorStack(2);

        return chestplateStack.getItem() instanceof ArmorItem
                && ((ArmorItem)chestplateStack.getItem()).getMaterial() == ModArmorMaterials.PHOSPHOR_AMBER;
    }
}

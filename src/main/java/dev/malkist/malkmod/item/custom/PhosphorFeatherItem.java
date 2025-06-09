package dev.malkist.malkmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PhosphorFeatherItem extends Item {
    public PhosphorFeatherItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && selected && entity instanceof LivingEntity livingEntity) {
            if (!livingEntity.hasStatusEffect(StatusEffects.JUMP_BOOST)) {
                livingEntity.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.JUMP_BOOST,
                        5, 1,
                        true, false, true
                ));
            }

            if (!livingEntity.hasStatusEffect(StatusEffects.SPEED)) {
                livingEntity.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.SPEED,
                        5, 1,
                        true, false, true
                ));
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient()) {
            handleDash(user);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    private void handleDash(PlayerEntity user) {

    }


}

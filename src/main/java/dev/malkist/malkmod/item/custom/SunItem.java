package dev.malkist.malkmod.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SunItem extends BoneMealItem {
    public SunItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ActionResult result = super.useOnBlock(context);

        context.getStack().setCount(1);

        return result;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 5, false, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 1, false, false));

        World world = entity.getWorld();
        Vec3d entityPos = entity.getPos();
        EntityDimensions entityDimensions = entity.getDimensions(entity.getPose());

        double halfWidth = entityDimensions.width * 0.5;
        double halfHeight = entityDimensions.height * 0.5;

        if (!world.isClient()) {
            ((ServerWorld) world).spawnParticles(
                    ParticleTypes.WAX_OFF,
                    entityPos.x, entityPos.y + halfHeight, entityPos.z,
                    30,
                    halfWidth, halfHeight, halfWidth,
                    1.5
            );
        }

        user.getItemCooldownManager().set(this, 100);

        return ActionResult.SUCCESS;
    }

    private BlockState getBlockState(ItemUsageContext context) {
        return context.getWorld().getBlockState(context.getBlockPos());
    }
}

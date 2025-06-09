package dev.malkist.malkmod.block.custom;

import dev.malkist.malkmod.MalkMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stat.Stat;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PhosphorDieBlock extends Block {
    public PhosphorDieBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.375, 0, 0.375, 0.625, 0.25, 0.625);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getOutlineShape(state, world, pos, context);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int roll = world.random.nextBetween(1, 6);

        if (!world.isClient()) {
            outputRoll(player, roll);

            int duration = 400 * (7 - roll);
            MalkMod.LOGGER.debug("Duration: {} Amplifier: {}", duration, roll);

            player.setStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, duration, roll - 1, true, true), null);
        }

        return ActionResult.SUCCESS;
    }

    private void outputRoll(PlayerEntity player, int roll) {
        player.sendMessage(Text.literal("You rolled a " + roll + "!"));
    }
}

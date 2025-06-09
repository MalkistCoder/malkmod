package dev.malkist.malkmod;

import dev.malkist.malkmod.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.render.RenderLayer;

public class MalkModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.GLOWWOOD_DOOR,
                ModBlocks.GLOWWOOD_TRAPDOOR,
                ModBlocks.COPPER_WIRE
        );
    }
}

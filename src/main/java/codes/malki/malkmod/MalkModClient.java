package codes.malki.malkmod;

import codes.malki.malkmod.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
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

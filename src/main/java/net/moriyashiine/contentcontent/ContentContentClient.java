package net.moriyashiine.contentcontent;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.render.RenderLayer;
import net.moriyashiine.contentcontent.block.ModBlocks;
import net.moriyashiine.contentcontent.particle.ModParticles;
import net.moriyashiine.contentcontent.particle.custom.Vase_Break_Particle;

public class ContentContentClient implements ClientModInitializer {
   public void onInitializeClient() {
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHOCOLATE_RAVEN, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHOCOLATE_FROG, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHOCOLATE_SQUIRREL, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AQUARIUM_GLASS, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SCULK_ORIFICE, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.IRON_SCAFFOLDING, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BRAZIER, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOUL_BRAZIER, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANCIENT_VASE_3, RenderLayer.getCutout());
      ParticleFactoryRegistry.getInstance().register(ModParticles.VASE_BREAK_PARTICLE, Vase_Break_Particle.Factory::new);
   }
}

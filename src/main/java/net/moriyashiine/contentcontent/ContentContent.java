package net.moriyashiine.contentcontent;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.moriyashiine.contentcontent.block.ModBlocks;
import net.moriyashiine.contentcontent.item.ModItems;
import net.moriyashiine.contentcontent.particle.ModParticles;
import net.moriyashiine.contentcontent.world.features.ModPlacedFeatures;
import net.moriyashiine.contentcontent.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContentContent implements ModInitializer {
   public static final String MOD_ID = "contentcontent";
   public static final DefaultParticleType VASE_BREAK = FabricParticleTypes.simple();
   public static final Logger LOGGER = LoggerFactory.getLogger("contentcontent");

   public void onInitialize() {
      ModItems.registerModItems();
      ModBlocks.registerModBlocks();
      ModParticles.registerParticles();
      ModWorldGen.generateWorldGen();
   }
}

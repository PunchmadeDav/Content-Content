package net.moriyashiine.contentcontent.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.moriyashiine.contentcontent.ContentContent;
import net.moriyashiine.contentcontent.world.features.ModConfiguredFeatures;
import net.moriyashiine.contentcontent.world.features.ModPlacedFeatures;

public class ModWorldGen {
   public static void generateWorldGen() {
      ModConfiguredFeatures.bootstrap();
      ModPlacedFeatures.bootstrap();

      BiomeModifications.addFeature(
              BiomeSelectors.foundInOverworld(),
              GenerationStep.Feature.UNDERGROUND_ORES,
              RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(ContentContent.MOD_ID, "ancient_vase_1_placed"))
      );

      BiomeModifications.addFeature(
              BiomeSelectors.foundInOverworld(),
              GenerationStep.Feature.UNDERGROUND_ORES,
              RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(ContentContent.MOD_ID, "ancient_vase_1_placed1"))
      );
   }
}
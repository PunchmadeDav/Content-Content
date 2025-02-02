package net.moriyashiine.contentcontent.world.features;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataProvider;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.util.BlockMatchRuleTest;
import net.moriyashiine.contentcontent.block.ModBlocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModConfiguredFeatures implements DataProvider {
   public static final List<OreFeatureConfig.Target> ANCIENT_VASES = List.of(
           OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.DEEPSLATE_BRICKS), ModBlocks.ANCIENT_VASE_1.getDefaultState())
   );
   public static final List<OreFeatureConfig.Target> ANCIENT_VASES1 = List.of(
           OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.DEEPSLATE_TILES), ModBlocks.ANCIENT_VASE_1.getDefaultState())
   );

   private final FabricDataOutput output;
   private final CompletableFuture<Registerable<?>> registriesFuture;

   public ModConfiguredFeatures(FabricDataOutput output, CompletableFuture<Registerable<?>> registriesFuture) {
      this.output = output;
      this.registriesFuture = registriesFuture;
   }

   public void run(Registerable<ConfiguredFeature<?, ?>> context) {
      register(context, "ancient_vase_1", Feature.ORE, new OreFeatureConfig(ANCIENT_VASES, 6));
      register(context, "ancient_vase_11", Feature.ORE, new OreFeatureConfig(ANCIENT_VASES1, 6));
   }

   private static void register(Registerable<ConfiguredFeature<?, ?>> context, String id, Feature<OreFeatureConfig> feature, OreFeatureConfig config) {
      RegistryKey<ConfiguredFeature<?, ?>> key = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier("contentcontent", id));
      context.register(key, new ConfiguredFeature<>(feature, config));
   }

   @Override
   public String getName() {
      return "ModConfiguredFeatures";
   }
}
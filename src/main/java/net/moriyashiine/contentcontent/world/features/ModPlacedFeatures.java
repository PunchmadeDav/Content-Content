package net.moriyashiine.contentcontent.world.features;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModPlacedFeatures implements DataProvider {
   public static final RegistryKey<PlacedFeature> ANCIENT_VASE_1_PLACED = RegistryKey.of(
           RegistryKeys.PLACED_FEATURE, new Identifier("contentcontent", "ancient_vase_1_placed")
   );

   public static final RegistryKey<PlacedFeature> ANCIENT_VASE_11_PLACED = RegistryKey.of(
           RegistryKeys.PLACED_FEATURE, new Identifier("contentcontent", "ancient_vase_1_placed1")
   );

   private final FabricDataOutput output;
   private final CompletableFuture<Registerable<?>> registriesFuture;

   public ModPlacedFeatures(FabricDataOutput output, CompletableFuture<Registerable<?>> registriesFuture) {
      this.output = output;
      this.registriesFuture = registriesFuture;
   }

   @Override
   public void run(Registerable<PlacedFeature> context) {
      context.register(ANCIENT_VASE_1_PLACED, new PlacedFeature(
              context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE).getOrThrow(
                      RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier("contentcontent", "ancient_vase_1"))
              ),
              modifiersWithCount(80, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)))
      ));

      context.register(ANCIENT_VASE_11_PLACED, new PlacedFeature(
              context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE).getOrThrow(
                      RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier("contentcontent", "ancient_vase_11"))
              ),
              modifiersWithCount(80, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)))
      ));
   }

   private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
      return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
   }

   private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
      return modifiers(CountPlacementModifier.of(count), heightModifier);
   }

   @Override
   public String getName() {
      return "ModPlacedFeatures";
   }
}
package net.moriyashiine.contentcontent;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.moriyashiine.contentcontent.world.features.ModConfiguredFeatures;
import net.moriyashiine.contentcontent.world.features.ModPlacedFeatures;

public class ContentContentDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        // Register configured and placed features
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider((output, registriesFuture) -> new ModConfiguredFeatures(output, registriesFuture));
        pack.addProvider((output, registriesFuture) -> new ModPlacedFeatures(output, registriesFuture));
    }
}
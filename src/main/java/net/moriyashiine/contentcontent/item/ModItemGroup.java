package net.moriyashiine.contentcontent.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.moriyashiine.contentcontent.ContentContent;
import net.moriyashiine.contentcontent.block.ModBlocks;

public class ModItemGroup {
   public static final ItemGroup CONTENTCONTENT = FabricItemGroup.builder()
           .icon(() -> new ItemStack(ModBlocks.CHOCOLATE_RAVEN.asItem()))
           .displayName(Text.translatable("itemGroup.contentcontent.contentcontent"))
           .entries((context, entries) -> {

              entries.add(ModBlocks.CHOCOLATE_RAVEN);
              entries.add(ModBlocks.CHOCOLATE_RAT);
              entries.add(ModBlocks.CHOCOLATE_SQUIRREL);
              entries.add(ModBlocks.CHOCOLATE_FROG);
              entries.add(ModBlocks.CHOCOLATE_CREWMATE);
              entries.add(ModBlocks.CHOCOLATE_EGG);
              entries.add(ModBlocks.CHISELED_CHOCOLATE_EGG);
              entries.add(ModBlocks.DIORITE_TILES);
              entries.add(ModBlocks.ANCIENT_VASE_1);
              entries.add(ModBlocks.ANCIENT_VASE_2);
              entries.add(ModBlocks.ANCIENT_VASE_3);
              entries.add(ModBlocks.ANCIENT_VASE_4);
              entries.add(ModBlocks.IRON_SCAFFOLDING);
              entries.add(ModBlocks.IRON_BAR);
              entries.add(ModBlocks.BRAZIER);
              entries.add(ModBlocks.SOUL_BRAZIER);
              entries.add(ModBlocks.AQUARIUM_GLASS);
              entries.add(ModBlocks.SCULK_ORIFICE);
           })
           .build();

   public static void registerModItemGroup() {
      Registry.register(Registries.ITEM_GROUP, new Identifier(ContentContent.MOD_ID, "contentcontent"), CONTENTCONTENT);
      ContentContent.LOGGER.debug("Registering ModItemGroup for " + ContentContent.MOD_ID);
   }
}
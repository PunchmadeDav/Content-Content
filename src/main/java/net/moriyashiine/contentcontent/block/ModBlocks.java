package net.moriyashiine.contentcontent.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.moriyashiine.contentcontent.ContentContent;
import net.moriyashiine.contentcontent.block.custom.AncientVase1Block;
import net.moriyashiine.contentcontent.block.custom.AncientVase2Block;
import net.moriyashiine.contentcontent.block.custom.AncientVase3Block;
import net.moriyashiine.contentcontent.block.custom.AncientVase4Block;
import net.moriyashiine.contentcontent.block.custom.AquariumGlassBlock;
import net.moriyashiine.contentcontent.block.custom.BrazierBlock;
import net.moriyashiine.contentcontent.block.custom.ChiseledChocolateEggBlock;
import net.moriyashiine.contentcontent.block.custom.ChocolateCrewmateBlock;
import net.moriyashiine.contentcontent.block.custom.ChocolateEggBlock;
import net.moriyashiine.contentcontent.block.custom.ChocolateFrogBlock;
import net.moriyashiine.contentcontent.block.custom.ChocolateRatBlock;
import net.moriyashiine.contentcontent.block.custom.ChocolateRavenBlock;
import net.moriyashiine.contentcontent.block.custom.ChocolateSquirrelBlock;
import net.moriyashiine.contentcontent.block.custom.IronBarBlock;
import net.moriyashiine.contentcontent.block.custom.IronScaffoldingBlock;
import net.moriyashiine.contentcontent.block.custom.SculkOrificeBlock;
import net.moriyashiine.contentcontent.block.custom.SoulBrazierBlock;
import net.moriyashiine.contentcontent.item.ModFoodComponents;
import net.moriyashiine.contentcontent.item.ModItemGroup;

public class ModBlocks {
   public static final Block DIORITE_TILES = registerBlock(
           "diorite_tiles", new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(4.0F).requiresTool()), ModItemGroup.CONTENTCONTENT
   );
   public static final Block CHOCOLATE_EGG = registerEdibleBlock(
           "chocolate_egg", new ChocolateEggBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(0.1F).nonOpaque()), ModItemGroup.CONTENTCONTENT
   );
   public static final Block CHISELED_CHOCOLATE_EGG = registerEdibleBlock(
           "chiseled_chocolate_egg",
           new ChiseledChocolateEggBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(0.1F).nonOpaque()),
           ModItemGroup.CONTENTCONTENT
   );
   public static final Block CHOCOLATE_RAVEN = registerEdibleBlock(
           "chocolate_raven", new ChocolateRavenBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(0.1F).nonOpaque()), ModItemGroup.CONTENTCONTENT
   );
   public static final Block CHOCOLATE_RAT = registerEdibleBlock(
           "chocolate_rat", new ChocolateRatBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(0.1F).nonOpaque()), ModItemGroup.CONTENTCONTENT
   );
   public static final Block CHOCOLATE_SQUIRREL = registerEdibleBlock(
           "chocolate_squirrel", new ChocolateSquirrelBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(0.1F).nonOpaque()), ModItemGroup.CONTENTCONTENT
   );
   public static final Block CHOCOLATE_FROG = registerEdibleBlock(
           "chocolate_frog", new ChocolateFrogBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(0.1F).nonOpaque()), ModItemGroup.CONTENTCONTENT
   );
   public static final Block CHOCOLATE_CREWMATE = registerEdibleBlock(
           "chocolate_crewmate", new ChocolateCrewmateBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(0.1F).nonOpaque()), ModItemGroup.CONTENTCONTENT
   );
   public static final Block ANCIENT_VASE_3 = registerBlock(
           "ancient_vase_3",
           new AncientVase3Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(0.3F).nonOpaque().dynamicBounds()),
           ModItemGroup.CONTENTCONTENT
   );
   public static final Block ANCIENT_VASE_4 = registerBlock(
           "ancient_vase_4",
           new AncientVase4Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(0.3F).nonOpaque().dynamicBounds()),
           ModItemGroup.CONTENTCONTENT
   );
   public static final Block ANCIENT_VASE_2 = registerBlock(
           "ancient_vase_2",
           new AncientVase2Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(0.3F).nonOpaque().dynamicBounds()),
           ModItemGroup.CONTENTCONTENT
   );
   public static final Block ANCIENT_VASE_1 = registerBlock(
           "ancient_vase_1",
           new AncientVase1Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(0.3F).nonOpaque().dynamicBounds()),
           ModItemGroup.CONTENTCONTENT
   );
   public static final Block IRON_SCAFFOLDING = registerBlock(
           "iron_scaffolding",
           new IronScaffoldingBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0.1F).collidable(false)),
           ModItemGroup.CONTENTCONTENT
   );
   public static final Block IRON_BAR = registerBlock(
           "iron_bar", new IronBarBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0.1F).nonOpaque().dynamicBounds()), ModItemGroup.CONTENTCONTENT
   );
   public static final Block BRAZIER = registerBlock(
           "brazier", new BrazierBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0.1F).nonOpaque().dynamicBounds()), ModItemGroup.CONTENTCONTENT
   );
   public static final Block SOUL_BRAZIER = registerBlock(
           "soul_brazier",
           new SoulBrazierBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0.1F).nonOpaque().dynamicBounds()),
           ModItemGroup.CONTENTCONTENT
   );
   public static final Block AQUARIUM_GLASS = registerBlock(
           "aquarium_glass",
           new AquariumGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).strength(0.1F).nonOpaque().dynamicBounds()),
           ModItemGroup.CONTENTCONTENT
   );
   public static final Block SCULK_ORIFICE = registerBlock(
           "sculk_orifice",
           new SculkOrificeBlock(FabricBlockSettings.copyOf(Blocks.SCULK).strength(0.1F).nonOpaque().dynamicBounds()),
           ModItemGroup.CONTENTCONTENT
   );

   private static Block registerEdibleBlock(String name, Block block, ItemGroup tab) {
      registerEdibleBlockItem(name, block, tab);
      return Registry.register(Registries.BLOCK, new Identifier("contentcontent", name), block);
   }

   private static Item registerEdibleBlockItem(String name, Block block, ItemGroup tab) {
      return Registry.register(
              Registries.ITEM,
              new Identifier("contentcontent", name),
              new BlockItem(block, new FabricItemSettings().food(ModFoodComponents.CHOCOLATE))
      );
   }

   private static Block registerBlock(String name, Block block, ItemGroup tab) {
      registerBlockItem(name, block, tab);
      return Registry.register(Registries.BLOCK, new Identifier("contentcontent", name), block);
   }

   private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
      return Registry.register(
              Registries.ITEM, new Identifier("contentcontent", name), new BlockItem(block, new FabricItemSettings())
      );
   }

   public static void registerModBlocks() {
      ContentContent.LOGGER.debug("Registering ModBlocks for contentcontent");
   }
}
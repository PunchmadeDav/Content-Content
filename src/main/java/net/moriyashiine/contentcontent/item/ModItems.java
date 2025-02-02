package net.moriyashiine.contentcontent.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.moriyashiine.contentcontent.ContentContent;

public class ModItems {
   private static Item registerItem(String name, Item item) {
      return (Item) Registry.register(Registries.ITEM, new Identifier("contentcontent", name), item);
   }

   public static void registerModItems() {
      ContentContent.LOGGER.debug("Registering Mod Items for contentcontent");
   }
}

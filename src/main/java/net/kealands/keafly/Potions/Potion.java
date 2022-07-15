package net.kealands.keafly.Potions;

import net.kealands.keafly.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class Potion {

    public ItemStack createItemPotion(PotionType potionType) {
        if(potionType.equals(PotionType.DRINK)) {
            return new ItemBuilder(Material.POTION).setName("§6Potion of Flight").setLore(Arrays.asList("§8Drink then, fly away!")).toItemStack();
        }
        if(potionType.equals(PotionType.SPLASH)) {
            return new ItemBuilder(Material.SPLASH_POTION).setName("§6Splash Potion of Flight").setLore(Arrays.asList("§8Throw then, fly away!")).toItemStack();
        }
        return null;
    }
}

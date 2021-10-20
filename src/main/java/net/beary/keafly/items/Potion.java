package net.beary.keafly.items;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.ArrayList;
import java.util.List;

public class Potion {



    public static ItemStack splashPotion() {
        ItemStack s = new ItemStack(Material.SPLASH_POTION);
        PotionMeta m = (PotionMeta) s.getItemMeta();
        m.setColor(Color.AQUA);
        m.setDisplayName("§bSplash Potion of Flight");
        List<String> lore = new ArrayList<>();
        lore.add("§9Flight (5:00)");
        lore.add("§7§oFly with friends!");
        m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        m.setLore(lore);
        s.setItemMeta(m);


        return s;
    }


    public static ItemStack casualPotion() {
        ItemStack s = new ItemStack(Material.POTION);
        PotionMeta m = (PotionMeta) s.getItemMeta();
        m.setColor(Color.AQUA);
        m.setDisplayName("§bPotion of Flight");
        List<String> lore = new ArrayList<>();
        m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        lore.add("§9Flight (5:00)");
        lore.add("§7§oFly with yourself!");
        m.setLore(lore);
        s.setItemMeta(m);


        return s;
    }


}

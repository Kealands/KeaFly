package net.beary.keafly.potions;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class FlySplashPotion {

    public ItemStack splashPotion() {
        ItemStack stack = new ItemStack(Material.SPLASH_POTION);
        ItemMeta im = stack.getItemMeta();
        im.setLore(lore());
        im.setDisplayName(ChatColor.BOLD + "" + ChatColor.GOLD + "Splash Potion of Flight");
        stack.setItemMeta(im);

        return stack;
    }


    private List<String> lore() {
        List<String> newLore = new ArrayList<>();
        newLore.add(ChatColor.ITALIC + "Splash, then double tap");
        newLore.add(ChatColor.ITALIC + "space to fly!");
        return newLore;
    }

}

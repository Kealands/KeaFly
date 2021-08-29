package net.beary.keafly.potions;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FlyPotion {


    public ItemStack potion() {
        ItemStack stack = new ItemStack(Material.POTION);
        ItemMeta im = stack.getItemMeta();
        im.setLore(lore());
        im.setDisplayName(ChatColor.BOLD + "" + ChatColor.GOLD + "Potion of Flight");
        stack.setItemMeta(im);

        return stack;
    }


    private List<String> lore() {
        List<String> newLore = new ArrayList<>();
        newLore.add(ChatColor.ITALIC + "Drink, then double tap");
        newLore.add(ChatColor.ITALIC + "space to fly!");
        return newLore;
    }
}

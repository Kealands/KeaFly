package net.beary.keafly.managers;

import net.beary.keafly.KeaFly;
import net.beary.keafly.items.Potion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class FlyManager implements Listener {

    @EventHandler
    public void onPotionDrink(PlayerItemConsumeEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItem();
        if(item.isSimilar(Potion.casualPotion())) {
            if(KeaFly.getInstance().getConfig().getBoolean("currently_flying." + player.getUniqueId().toString() + ".enabled")) {
                int time = KeaFly.getInstance().getConfig().getInt("currently_flying." + player.getUniqueId().toString() + ".time");
                if(time != 0) {
                    KeaFly.getInstance().getConfig().set("currently_flying." + player.getUniqueId().toString() + ".time" , time + 300);
                    // don't activate flight just add more time fucking idiot
                } else {
                    // do the activate shit
                    startFlight(player);
                    Bukkit.getConsoleSender().sendMessage("§c[ERROR] Config lied to us " + player.getName() + " is the reason it broke blame them");
                    //say config lied to us
                }
            } else {
                // set usual 300 fucking idiot

            }
        }
    }



    public void startFlight(Player player) {
        

    }



}

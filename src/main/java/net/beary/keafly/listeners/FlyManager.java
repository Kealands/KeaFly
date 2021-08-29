package net.beary.keafly.listeners;

import net.beary.keafly.KeaFly;
import net.beary.keafly.Utilites.Util;
import net.beary.keafly.potions.FlyPotion;
import net.beary.keafly.potions.FlySplashPotion;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class FlyManager implements Listener {

    HashMap<Player, Integer> flightTime = new HashMap<>();
    Util util = new Util();
    FlyPotion flyPotion =new FlyPotion();
    FlySplashPotion flySplashPotion = new FlySplashPotion();


    @EventHandler
    public void onDrinkEvent(PlayerItemConsumeEvent e) {
        ItemStack consumed = e.getItem();
        Player victim = e.getPlayer();
        if(consumed.isSimilar(flyPotion.potion())) {
            if (flightTime.containsKey(victim)) {
                victim.sendMessage(ChatColor.GOLD + "You already have flight!");
                e.setCancelled(true);
            } else {
                util.sendActionBar(victim, ChatColor.GOLD + "You have activated flight!");
                startFly(victim);
                checkFlight(victim);
            }

        }
    }



    public void startFly(Player player) {
        if(flightTime.containsKey(player)) {
           int currentTime = flightTime.get(player);
           int addedTime = currentTime + 300;
            } else if(!flightTime.containsKey(player)) {
            flightTime.put(player, 300);
            player.setAllowFlight(true);
        }

    }

    public void checkFlight(Player player) {
        new BukkitRunnable() {

            @Override
            public void run() {
                    if (flightTime.containsKey(player)) {
                        if (flightTime.get(player) == 0) {
                            player.setAllowFlight(false);
                            player.sendMessage(ChatColor.GOLD + "You have ran out of flight!");
                            util.cancelFall(player);
                            flightTime.remove(player);
                        } else {
                            int currentTime = flightTime.get(player);
                            int newTime = currentTime -1;
                            flightTime.remove(player);
                            flightTime.put(player, newTime);
                            util.sendActionBar(player, ChatColor.GOLD + "You have " + currentTime + " second(s) left of flight!");
                        }
                    }
                }

        }.runTaskTimer(KeaFly.getInstance(), 0, 20);
    }

    @EventHandler
    public void onQuitEvent(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        if(flightTime.containsKey(player)) {
            flightTime.remove(player);
            Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "Removed " + player.getName() + " from flight list!");
        }
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if(e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                if(util.getCancelFall().contains(player)) {
                    e.setCancelled(true);
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + player.getName() + " was saved due to {CANCELFALL}");
                    util.getCancelFall().remove(player);
                }
            }

        }
    }
    @EventHandler
    public void onPotionSplash(PotionSplashEvent event) {
        ItemStack thrownPotion = event.getPotion().getItem(); // Get the splash potion
        Collection<LivingEntity> affectedList = event.getAffectedEntities(); // Get entities affected
        if (thrownPotion.isSimilar(flySplashPotion.splashPotion())) { // Check if potion was a fly potion
            for (LivingEntity affected : affectedList) { // Allow flight for all affected players
                if (affected instanceof Player) {
                    Player victim = (Player) affected;
                    if (flightTime.containsKey(victim)) {
                        victim.sendMessage(ChatColor.GOLD + "You already have flight!");
                        event.setCancelled(true);
                    } else {
                        util.sendActionBar(victim, ChatColor.GOLD + "You have activated flight!");
                        startFly(victim);
                        checkFlight(victim);
                    }

                }
            }
        }
    }

}

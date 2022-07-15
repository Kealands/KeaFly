package net.kealands.keafly.Fly.Tasks;

import net.kealands.keafly.Fly.FlyManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class FlightCountdown extends BukkitRunnable {

    private Player player; // Countdown player
    FlyManager flyManager = new FlyManager();

    public FlightCountdown(Player player) {
        this.player = player;
    }



    @Override
    public void run() {
        int time = flyManager.getFlying().get(player);
        if(!player.isOnline() || player.getWorld().equals(Bukkit.getWorld("minigame"))) {// Checks if player is online or an currently playing in a minigame if so cancel
            cancel();
            flyManager.getFlying().remove(player);
            flyManager.getFlying().put(player, time); // updates player to a new time interval if they leave or join.
        } else {
            if(time <= 0) {
                flyManager.getFlying().remove(player);
                player.sendMessage("§6§lKeaFly §8| §fYou're flight has ran out! §8[SAFEFALL ENABLED]");
                player.setFlying(false);
                player.setAllowFlight(false);
                flyManager.safeFall(player);
                cancel();
            } else {
                time--;
                flyManager.getFlying().replace(player, flyManager.getFlying().get(player) - 1);
                String text = "§fYou've got §6%time%s §fleft on your flight§6!".replace("%time%", String.valueOf(time));
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(text));
            }
        }
    }
}

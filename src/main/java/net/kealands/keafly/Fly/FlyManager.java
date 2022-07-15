package net.kealands.keafly.Fly;

import net.kealands.keafly.Fly.Tasks.FlightCountdown;
import net.kealands.keafly.KeaFly;
import net.kealands.keafly.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.lang.management.PlatformLoggingMXBean;
import java.util.*;

public class FlyManager {

    private static HashMap<Player, Integer> flying = new HashMap<>();
    private static List<Player> safeFall = new ArrayList<>();

    public List<Player> getSafeFall() {
        return safeFall;
    }



    public HashMap<Player, Integer> getFlying() {
        return flying;
    }

    public void activateFlight(Player player, int seconds) {
        getFlying().put(player, seconds);
        player.setAllowFlight(true);
        player.setFlying(true);
        player.sendMessage("§6§lKeaFly §8| §f§6Flight §fis now activated for §6" + Util.transferTime(seconds));
        new FlightCountdown(player).runTaskTimer(KeaFly.inst(), 0, 20);
    }

    public boolean isPlayerGrounded(Player player) {
        if(player.getLocation().subtract(0, 1,0).getBlock().getType().equals(Material.AIR)) {
            return false;
        } else {
            return true;
        }
    }

    public void addSafeFall(Player player) {
        if(isPlayerGrounded(player)) {
            player.sendMessage("§6§lKeaFly §8| §fSince your grounded SafeFall didn't activate!");
        } else {
            safeFall.add(player);
        }
    }
}

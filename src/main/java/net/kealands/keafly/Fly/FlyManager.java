package net.kealands.keafly.Fly;

import net.kealands.keafly.Fly.Tasks.FlightCountdown;
import net.kealands.keafly.KeaFly;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.lang.management.PlatformLoggingMXBean;
import java.util.*;

public class FlyManager {

    private static HashMap<Player, Integer> flying = new HashMap<>();

    public void safeFall(Player player) {
        player.sendMessage("lol i havent even coded safe fall KEKW");
    }

    public HashMap<Player, Integer> getFlying() {
        return flying;
    }

    public void activateFlight(Player player) {
        getFlying().put(player, 300);
        player.setAllowFlight(true);
        player.setFlying(true);
        player.sendMessage("§6§lKeaFly §8| §f§6Flight §fis now activated for §65 minutes§f!");
        new FlightCountdown(player).runTaskTimer(KeaFly.inst(), 0, 20);
    }
}

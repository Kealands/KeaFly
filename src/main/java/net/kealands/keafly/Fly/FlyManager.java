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
    private static List<Player> safeFall = new ArrayList<>();

    public List<Player> getSafeFall() {
        return safeFall;
    }



    public HashMap<Player, Integer> getFlying() {
        return flying;
    }

    public void activateFlight(Player player) {
        getFlying().put(player, 15);
        player.setAllowFlight(true);
        player.setFlying(true);
        player.sendMessage("§6§lKeaFly §8| §f§6Flight §fis now activated for §65 minutes§f!");
        new FlightCountdown(player).runTaskTimer(KeaFly.inst(), 0, 20);
    }
}

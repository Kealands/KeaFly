package net.kealands.keafly;

import net.kealands.keafly.Fly.FlyListener;
import net.kealands.keafly.Fly.FlyManager;
import net.kealands.keafly.Fly.KeaFlyCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public final class KeaFly extends JavaPlugin {

    private static KeaFly inst;
    public static KeaFly inst() { return inst; }

    private FlyManager flyManager;

    @Override
    public void onEnable() {
        inst = this;
        getCommand("keafly").setExecutor(new KeaFlyCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new FlyListener(), this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        this.flyManager =new FlyManager();
        for(Player flyers : flyManager.getFlying().keySet()) {
            flyers.sendMessage("§6§lKeaFly §8| §cYour flight has been disabled unexpectedly. §4SafeFall was not able to turn on!");
            flyers.setFlying(false);
        }
    }
}

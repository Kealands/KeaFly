package net.kealands.keafly;

import net.kealands.keafly.Fly.FlyListener;
import net.kealands.keafly.Fly.KeaFlyCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class KeaFly extends JavaPlugin {

    private static KeaFly inst;
    public static KeaFly inst() { return inst; }

    @Override
    public void onEnable() {
        inst = this;
        getCommand("keafly").setExecutor(new KeaFlyCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new FlyListener(), this);
        saveDefaultConfig();
    }
}

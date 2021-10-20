package net.beary.keafly;

import net.beary.keafly.commands.KeaFlyCommand;
import net.beary.keafly.managers.FlyManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class KeaFly extends JavaPlugin {

    private static KeaFly instance;
    public static KeaFly getInstance() { return instance; }


    @Override
    public void onEnable() {
        saveDefaultConfig();

        Bukkit.getServer().getPluginManager().registerEvents(new FlyManager(), this);
        getCommand("keafly").setExecutor(new KeaFlyCommand());


    }
}

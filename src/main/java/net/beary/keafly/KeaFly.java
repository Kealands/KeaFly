package net.beary.keafly;

import net.beary.keafly.command.KeaFlyCommand;
import net.beary.keafly.listeners.FlyManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class KeaFly extends JavaPlugin {

    private static KeaFly instance;
    public static KeaFly getInstance() { return instance; }


    @Override
    public void onEnable() {
        instance = this;
        getCommand("keafly").setExecutor(new KeaFlyCommand());
        getServer().getPluginManager().registerEvents(new FlyManager(), this);



    }
}

package net.beary.keafly;

import org.bukkit.plugin.java.JavaPlugin;


public final class KeaFly extends JavaPlugin {

    private static KeaFly instance;
    public static KeaFly getInstance() { return instance; }


    @Override
    public void onEnable() {
        saveDefaultConfig();
    }
}

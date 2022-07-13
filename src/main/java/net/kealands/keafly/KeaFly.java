package net.kealands.keafly;

import org.bukkit.plugin.java.JavaPlugin;


public final class KeaFly extends JavaPlugin {

    private static KeaFly inst;
    public static KeaFly inst() { return inst; }

    @Override
    public void onEnable() {
        inst = this;
        saveDefaultConfig();
    }
}

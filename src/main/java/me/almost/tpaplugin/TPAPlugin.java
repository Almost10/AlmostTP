package me.almost.tpaplugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class TPAPlugin extends JavaPlugin {
    static Map<String, String> TpList = new HashMap<>();
    static Map<String, Boolean> TpVerifier = new HashMap<>();
    static Map<String, String> NameOf = new HashMap<>();
    public static TPAPlugin getPlugin() {
        return getPlugin(TPAPlugin.class);
    }

    @Override
    public void onEnable() {
        getCommand("tpa").setExecutor(new TPRequest());
        getCommand("tpaccept").setExecutor(new TPAccept());


        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

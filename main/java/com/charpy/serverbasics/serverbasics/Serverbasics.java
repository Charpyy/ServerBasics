package com.charpy.serverbasics.serverbasics;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Serverbasics extends JavaPlugin {

    public FileConfiguration config;
    public File configFile;

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        getCommand("sb").setExecutor(new ReloadHelpCommands(this));
        getCommand("sbkit").setExecutor(new DefaultKitCommand(this));

        loadConfig();


        String firstJoinMessage = config.getString("firstJoinMessage");
        String joinMessage = config.getString("joinMessage");
        System.out.println(" ");
        System.out.println("Server Basics v-1.0 Loaded");
        System.out.println(" ");
    }

    @Override
    public void onDisable() {
        System.out.println("Server Basics v-1.0 Disabled");
        saveConfig();
    }

    public void loadConfig() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            saveDefaultConfig();
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            getLogger().severe("Impossible de sauvegarder la configuration dans config.yml");
        }
    }
}
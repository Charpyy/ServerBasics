package com.charpy.serverbasics.serverbasics;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener implements Listener {
    private final Serverbasics plugin;

    public PlayerListener(Serverbasics plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String joinMessage = plugin.getConfig().getString("joinMessage");
        joinMessage = joinMessage.replace("%player%", player.getName());
        e.setJoinMessage(joinMessage);
    }
    @EventHandler
    public void OnPlayerFirstJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (!player.hasPlayedBefore()) {
            String firstJoinMessage = plugin.getConfig().getString("firstJoinMessage");
            firstJoinMessage = firstJoinMessage.replace("%player%", player.getName());
            Bukkit.broadcastMessage(firstJoinMessage);
            ItemStack[] kitItems = (ItemStack[]) plugin.getConfig().get("kitItems");
            if (kitItems != null) {
                String defaultKitMessage = plugin.getConfig().getString("defaultKitMessage");
                player.getInventory().setContents(kitItems);
                player.sendMessage(defaultKitMessage);
            }
        }
    }
    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent e) {
        Player player = e.getPlayer();
        String quitMessage = plugin.getConfig().getString("quitMessage");
        quitMessage = quitMessage.replace("%player%", player.getName());
        e.setQuitMessage(quitMessage);
    }

}



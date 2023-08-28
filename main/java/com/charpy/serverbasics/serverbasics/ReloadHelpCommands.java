package com.charpy.serverbasics.serverbasics;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadHelpCommands implements CommandExecutor {
    private final Serverbasics plugin;

    public ReloadHelpCommands(Serverbasics plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sb")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                sender.sendMessage("§8» §6Server Basics §8« §dConfig reloaded !");
                return true;
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
                sender.sendMessage("§8» §6Server Basics §8« §fList of Server Basics commands:");
                sender.sendMessage("");
                sender.sendMessage("§8- §f/sb reload, §8to reload the configuration of the plugin");
                return true;
            }
        }
        return false;
    }
}
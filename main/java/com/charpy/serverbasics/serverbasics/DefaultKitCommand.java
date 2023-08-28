package com.charpy.serverbasics.serverbasics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class DefaultKitCommand implements CommandExecutor {
    private final Serverbasics plugin;

    public DefaultKitCommand(Serverbasics plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by a player");
            return true;
        }

        Player player = (Player) sender;
        PlayerInventory playerInventory = player.getInventory();

        if (cmd.getName().equalsIgnoreCase("sbkit")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("create")) {
                ItemStack[] kitItems = playerInventory.getContents();
                plugin.getConfig().set("kitItems", kitItems);
                plugin.saveConfig();
                player.sendMessage("§8» §6Server Basics §8« §fKit created !");
                return true;
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("delete")) {
                plugin.getConfig().set("kitItems", null);
                plugin.saveConfig();
                player.sendMessage("§8» §6Server Basics §8« §fKit removed !");
                return true;
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("edit")) {
                ItemStack[] kitItems = playerInventory.getContents();
                plugin.getConfig().set("kitItems", kitItems);
                plugin.saveConfig();
                player.sendMessage("§8» §6Server Basics §8« §fKit edited !");
                return true;
            }
        }
        return false;
    }
}


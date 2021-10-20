package net.beary.keafly.commands;

import net.beary.keafly.items.Potion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KeaFlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("keafly.admin")) {
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("flightstatus")) {
                        // return flight
                    } else {
                        if(args[0].equalsIgnoreCase("splash")) {
                            player.getInventory().addItem(Potion.splashPotion());
                            player.sendMessage("§3§lFLIGHT §8| §bYou have been given §3Splash Potion of Flight§b!");
                        } else {
                            if(args[0].equalsIgnoreCase("potion")) {
                                player.getInventory().addItem(Potion.casualPotion());
                                player.sendMessage("§3§lFLIGHT §8| §bYou have been given §3Potion of Flight§b!");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}

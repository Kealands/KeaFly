package net.beary.keafly.command;

import net.beary.keafly.potions.FlyPotion;
import net.beary.keafly.potions.FlySplashPotion;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KeaFlyCommand implements CommandExecutor {

    FlySplashPotion flySplashPotion = new FlySplashPotion();
    FlyPotion flyPotion = new FlyPotion();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(sender.hasPermission("keafly.give")) {
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("splash")) {
                    player.getInventory().addItem(flySplashPotion.splashPotion());
                } else {
                    if(args[0].equalsIgnoreCase("potion")) {
                        player.getInventory().addItem(flyPotion.potion());

                    } else {
                        if(args[0].equalsIgnoreCase("stick")) {
                            player.getInventory().addItem(flyPotion.stick());
                        }
                    }
            }

            } else {
                if(args.length == 2) {
                    if (args[0].equalsIgnoreCase("splash")) {
                        Player target = Bukkit.getPlayerExact(args[1]);
                        if (target != null) {
                            target.getInventory().addItem(flySplashPotion.splashPotion());
                        } else {
                            sender.sendMessage("This player doesn't exist!!!!!!!!");
                        }
                    } else {
                        if (args[0].equalsIgnoreCase("potion")) {
                            Player target = Bukkit.getPlayerExact(args[1]);
                            if (target != null) {
                                target.getInventory().addItem(flySplashPotion.splashPotion());
                            } else {
                                sender.sendMessage("This player doesn't exist!!!!!!!!");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}

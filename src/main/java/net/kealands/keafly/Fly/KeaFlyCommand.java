package net.kealands.keafly.Fly;

import net.kealands.keafly.Potions.Potion;
import net.kealands.keafly.Potions.PotionType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KeaFlyCommand implements CommandExecutor {

    private Potion potion;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        this.potion = new Potion();
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(!player.hasPermission("keafly.admin")) return false;
        player.getInventory().addItem(potion.createItemPotion(PotionType.valueOf(args[0].toUpperCase())));

        return false;
    }
}

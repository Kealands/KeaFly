package net.beary.keafly.Utilites;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Util {

    private List<Player> cancelFallList = new ArrayList<>();


    public void sendActionBar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }


    public void cancelFall(Player player) {
        boolean isNearGround = player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().isSolid();
        if (isNearGround) return;

        cancelFallList.add(player);
    }

    public List<Player> getCancelFall() {
        return cancelFallList;
    }
}

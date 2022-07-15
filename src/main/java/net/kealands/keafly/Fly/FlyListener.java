package net.kealands.keafly.Fly;

import net.kealands.keafly.Potions.Potion;
import net.kealands.keafly.Potions.PotionType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class FlyListener implements Listener {

    private Potion potion;
    FlyManager flyManager = new FlyManager();

    @EventHandler
    public void onPotionDrink(PlayerItemConsumeEvent e) {
        this.potion = new Potion();
        if(!e.getItem().isSimilar(potion.createItemPotion(PotionType.DRINK))) return;

        flyManager.activateFlight(e.getPlayer());


    }

}

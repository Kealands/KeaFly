package net.kealands.keafly.Fly;

import net.kealands.keafly.Potions.Potion;
import net.kealands.keafly.Potions.PotionType;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class FlyListener implements Listener {

    private Potion potion;
    FlyManager flyManager = new FlyManager();

    @EventHandler // Use safe fall if player takes fall damage after flight cancel
    public void onFallDamage(EntityDamageEvent e) {
        if(!e.getEntity().getType().equals(EntityType.PLAYER)) return;
        Player player = (Player) e.getEntity();
        if(!e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) return;
        if(!flyManager.getSafeFall().contains(player)) return;
        e.setDamage(0);
        player.sendMessage("§6§lKeaFly §8| §fYou have been saved from fall damage! §7[SAFEFALL]");
        flyManager.getSafeFall().remove(player);

    }

    @EventHandler // Disable safe fall if player lands in water instead
    public void onLiquidEnter(PlayerMoveEvent e) {
        Block block = e.getPlayer().getLocation().getBlock();
        Block blockunder = e.getPlayer().getLocation().subtract(0, 1, 0).getBlock();
        if(!flyManager.getSafeFall().contains(e.getPlayer())) return;
        if(blockunder.getType().equals(Material.WATER) || blockunder.getType().equals(Material.LAVA)) {
            e.getPlayer().sendMessage("§6§lKeaFly §8| §fCongratulations for landing in " + blockunder.getType().toString() + " §7[SAFEFALL]");
            flyManager.getSafeFall().remove(e.getPlayer());
        }
        if(block.getType().equals(Material.WATER) || block.getType().equals(Material.LAVA)) {
            e.getPlayer().sendMessage("§6§lKeaFly §8| §fCongratulations for landing in " + block.getType().toString() + " §7[SAFEFALL]");
            flyManager.getSafeFall().remove(e.getPlayer());
        }
    }

    @EventHandler // Potion Drink Checker - 15/07/2022
    public void onPotionDrink(PlayerItemConsumeEvent e) {
        this.potion = new Potion();
        if(!e.getItem().isSimilar(potion.createItemPotion(PotionType.DRINK))) return;

        flyManager.activateFlight(e.getPlayer(), 300);
    }

    @EventHandler
    public void onPlayerSplash(PotionSplashEvent e) {
        this.potion = new Potion();
        if(e.getPotion().getItem().isSimilar(potion.createItemPotion(PotionType.SPLASH))) {
        for(LivingEntity affected : e.getAffectedEntities()) {
            if (affected.getType().equals(EntityType.PLAYER)) {
                Player player = (Player) affected;
                flyManager.activateFlight(player, 210);
            }
        }
        }
    }


}

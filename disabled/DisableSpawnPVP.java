package me.alex.firstplugin.disabled;

import me.alex.firstplugin.game.Game;
import me.alex.firstplugin.statechange.Start;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DisableSpawnPVP implements Listener {

    @EventHandler
    public void onSpawnHit(EntityDamageByEntityEvent e) {
        if (!Game.currentGameStats.containsKey(e.getEntity())) {
            e.setCancelled(true);
        }
    }
}

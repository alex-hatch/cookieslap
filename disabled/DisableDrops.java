package me.alex.firstplugin.disabled;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DisableDrops implements Listener {

    @EventHandler
    public static void onDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }
}

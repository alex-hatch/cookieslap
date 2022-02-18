package me.alex.firstplugin.disabled;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class DisableExplosion implements Listener {
    @EventHandler
    public void onBlockExplode(EntityExplodeEvent e) {
        e.setCancelled(true);
    }
}

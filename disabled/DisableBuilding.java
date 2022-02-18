package me.alex.firstplugin.disabled;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class DisableBuilding implements Listener {
    @EventHandler
    public void onBuild(BlockPlaceEvent e) {
        if (e.getPlayer().getDisplayName().equals("Senro")) {
            return;
        } else {
            e.setCancelled(true);
        }
    }
}

package me.alex.firstplugin.disabled;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class DisableBreaking implements Listener {

    @EventHandler
    public void cancelBreak(BlockBreakEvent e) {
        if (e.getPlayer().getDisplayName().equals("Senro")) {
            return;
        } else {
            e.setCancelled(true);
        }
    }
}

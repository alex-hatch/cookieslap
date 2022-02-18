package me.alex.firstplugin.disabled;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class DisableEating implements Listener {
    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        e.setCancelled(true);
    }
}

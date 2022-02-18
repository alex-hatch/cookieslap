package me.alex.firstplugin.statechange;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        e.setQuitMessage(ChatColor.GOLD + e.getPlayer().getDisplayName() + ChatColor.GRAY + " has left the game");
    }
}

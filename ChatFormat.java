package me.alex.firstplugin;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        e.setFormat(ChatColor.GRAY + e.getPlayer().getDisplayName() + ": " + ChatColor.GRAY + e.getMessage());
    }

}

package me.alex.firstplugin.disabled;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.HashSet;

public class DisableCommands implements Listener {
    HashSet<String> validCommands = new HashSet<>();

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        String command = e.getMessage().toLowerCase();
        if (e.getPlayer().getDisplayName().equals("Senro")) {
            return;
        }
        if (!(command.equals("/start") || command.equals("/play") || command.equals("/stuck") || command.equals("/game") || command.equals("/leave") || command.equals("/buy") || command.equals("/vote"))) {
            e.getPlayer().sendMessage(ChatColor.AQUA + "Type" + ChatColor.GOLD + " /play " + ChatColor.AQUA + "to play a game!");
            e.getPlayer().sendMessage(" ");
            e.getPlayer().sendMessage(ChatColor.AQUA + "Type" + ChatColor.GOLD + " /leave " + ChatColor.AQUA + "to leave a game");
            e.setCancelled(true);
        }
    }
}

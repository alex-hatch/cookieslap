package me.alex.firstplugin.statechange;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

/**
 * Executed when player types /spawn
 * aliases: [stuck, leave] (see plugin.yml)
 */
public class Spawn implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            return false;
        }

        Player p = (Player) commandSender;
        if (!p.isOnGround() && command.getName().equalsIgnoreCase("spawn")) {
            p.sendMessage(ChatColor.RED + "You must be standing still on the ground to use this!");
            return false;
        }

        if (command.getName().equalsIgnoreCase("spawn")) {
            InitializeSpawnState.initSpawnState(((Player) commandSender).getPlayer());
            return true;
        }
        return false;
    }
}

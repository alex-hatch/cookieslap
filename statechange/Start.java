package me.alex.firstplugin.statechange;

import me.alex.firstplugin.game.CurrentGameStats;
import me.alex.firstplugin.game.Kill;
import me.alex.firstplugin.items.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.HashMap;

/**
 * Executed when a player joins a game
 * commands: [game, play] (see plugin.yml)
 */
public class Start implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            return false;
        }

        if (command.getName().equalsIgnoreCase("start")) {
            Player p = ((Player) commandSender).getPlayer();
            InitializeGameState.initGameState(p);
            if(Kill.lastDamager.containsKey(p)) {
                Kill.lastDamager.remove(p);
            }

            if(Weapons.weapons.size() == 0) {
                Weapons.initializeWeapons();
            }
            return true;
        }
        return false;
    }
}

package me.alex.firstplugin.stats;

import me.alex.firstplugin.game.Game;
import me.alex.firstplugin.scoreboard.lobby.LobbyScoreboard;
import me.alex.firstplugin.statechange.Start;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


public class SetCoins implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length != 2) {
            return false;
        }

        if (command.getName().equalsIgnoreCase("setcoins")) {
            Player targetPlayer = Bukkit.getPlayerExact(strings[0]);
            int amount = Integer.parseInt(strings[1]);
            PlayerConfig.setCoins(targetPlayer, amount);
            PlayerConfig.save();

            if(!Game.currentGameStats.containsKey(targetPlayer)) {
                LobbyScoreboard.generateScoreboard(targetPlayer);
            }

            targetPlayer.sendMessage(ChatColor.GREEN + "You now have " + ChatColor.GOLD + amount + ChatColor.GREEN + " coins ");
            return true;
        }

        return false;
    }
}

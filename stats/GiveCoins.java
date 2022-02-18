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


public class GiveCoins implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length != 2) {
            return false;
        }

        if (command.getName().equalsIgnoreCase("givecoins")) {
            Player targetPlayer = Bukkit.getPlayerExact(strings[0]);
            int amountToGive = Integer.parseInt(strings[1]);
            int currentPlayerCoins = PlayerConfig.getCoins(targetPlayer);
            PlayerConfig.setCoins(targetPlayer, amountToGive + currentPlayerCoins);
            PlayerConfig.save();

            if(!Game.currentGameStats.containsKey(targetPlayer)) {
                LobbyScoreboard.generateScoreboard(targetPlayer);
            }

            targetPlayer.sendMessage(ChatColor.GOLD + "" + amountToGive + " coins " + ChatColor.GREEN + "have been added to your account!");
            return true;
        }

        return false;
    }
}

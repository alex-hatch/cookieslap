package me.alex.firstplugin.scoreboard.lobby;

import me.alex.firstplugin.stats.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class LobbyScoreboard {

    public static void generateScoreboard(Player p) {
        String title = ChatColor.RED + "Cookie Slap";
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("dummy", "title");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(title);
        Score kills = obj.getScore(ChatColor.WHITE + "Total Kills: " + ChatColor.RED + PlayerConfig.getConfig().getInt("Players." + p.getUniqueId().toString() + ".Kills"));
        Score coins = obj.getScore(ChatColor.WHITE + "Total Coins: " + ChatColor.RED + PlayerConfig.getConfig().getInt("Players." + p.getUniqueId().toString() + ".Coins"));
        Score deaths = obj.getScore(ChatColor.WHITE + "Total Deaths: " + ChatColor.RED + PlayerConfig.getConfig().getInt("Players." + p.getUniqueId().toString() + ".Deaths"));
        Score highestStreak = obj.getScore(ChatColor.WHITE + "Highest Streak: " + ChatColor.RED + PlayerConfig.getConfig().getInt("Players." + p.getUniqueId().toString() + ".HighestStreak"));
        Score currentWeapon = obj.getScore(ChatColor.WHITE + "Selected Weapon: " + PlayerConfig.getConfig().getString("Players." + p.getUniqueId().toString() + ".ChosenWeapon"));

        kills.setScore(5);
        deaths.setScore(4);
        highestStreak.setScore(3);
        coins.setScore(2);
        currentWeapon.setScore(1);
        p.setScoreboard(board);
    }

    public static void disableScoreBoard(Player p) {
        p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }

}
